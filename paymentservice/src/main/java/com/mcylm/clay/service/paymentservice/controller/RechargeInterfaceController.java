package com.mcylm.clay.service.paymentservice.controller;

import com.google.gson.Gson;
import com.mcylm.clay.service.paymentservice.model.ParameterModel;
import com.mcylm.clay.service.paymentservice.model.UauthToken;
import com.mcylm.clay.service.paymentservice.service.RechargeInterfaceService;
import com.mcylm.clay.service.paymentservice.util.Base64Utils;
import com.mcylm.clay.service.paymentservice.util.RedisUtils;
import com.mcylm.clay.service.paymentservice.util.StringUtils;
import com.mcylm.clay.service.paymentservice.util.ZhiUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo-pc on 2017/8/17.
 */
@Controller
public class RechargeInterfaceController {
    @Autowired
    private RechargeInterfaceService rechargeInterfaceService;

    /**
     * 充值前账户验证是否登录
     *
     * @param parameterModel
     * @param model
     * @param request
     * @return
     */
    @RequestMapping("/rechargeInterface")
    public String rechargeInterface(ParameterModel parameterModel, Model model, HttpServletRequest request) {
        //获取当前地址
        StringBuffer url = request.getRequestURL();
        url.replace(17, 22, "/pay/");
        parameterModel.setRedirectUrl(url.toString());
        //检测是否登录
        String recharge = RedisUtils.checkLogin(parameterModel, "recharge");
        //生成ordersUuid
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String format = simpleDateFormat.format(date);
        String uuid1 = StringUtils.getUuid();
        String ordersUuid = format + uuid1;
        model.addAttribute("ordersUuid", ordersUuid);
        model.addAttribute("uuid", parameterModel.getToken());
        return recharge;
    }

    //根据token获取uuid
    public String getUUidByToken(String uuid) {
        String valByKey = RedisUtils.getValByKey(Base64Utils.decodeBase64String(uuid));
        Gson gson = new Gson();
        UauthToken uauthToken = gson.fromJson(valByKey, UauthToken.class);
        return uauthToken.getUuid();
    }

    /**
     * 功能:
     *
     * @param
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/getFuXinXi")
    public String getFuXinXi(String uuid, String ordersUuid, String money, String pd_FrpId, HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("GBK");
        //商家号
        String p1_MerId = "10001126856";
        // 重定向的地址
        String p8_Url = "http://localhost/pay/callback/?uuid="+uuid;
        //传输过去的秘钥
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";
        //调用方法进行加密
        // p8 是商家接受成功的地址
        // 商家编号
        // 提供密钥
        String hmac = ZhiUtil.buildHmac("Buy", p1_MerId, ordersUuid, money, "CNY", "", "", "", p8_Url,
                "0", "", pd_FrpId, "0", keyValue);

        model.addAttribute("uuid", uuid);
        model.addAttribute("ordersUuid", ordersUuid);
        model.addAttribute("money", money);
        System.out.println("**********uuid**********"+uuid+"********************");
        System.out.println("**********ordersUuid**********"+ordersUuid+"********************");
        System.out.println("**********money**********"+money+"********************");
        model.addAttribute("pd_FrpId", pd_FrpId);
        model.addAttribute("p1_MerId", p1_MerId);
        model.addAttribute("p8_Url", p8_Url);
        model.addAttribute("hmac", hmac);
        return "recharge2";
    }

    /**
     * @param request
     * @param model
     * @param hmac       从易宝传来的加密过的数据
     * @param r0_Cmd     业务类型
     * @param r1_Code    扣款结果1表示成功
     * @param r2_TrxId   易宝交易的订单号
     * @param r3_Amt     扣款金额，交易结束后，易宝交易系统将实际扣款金额返回商户
     * @param r4_Cur     交易的币种，人民币为CNY
     * @param r5_Pid     商品的id
     * @param r6_Order   商户订单号
     * @param r7_Uid     易宝会员id
     * @param r8_MP      商户扩展信息，可任意填写1k的字符串，交易返回时候将原样返回
     * @param r9_BType   交易结果通知类型1：交易成功回调（浏览器重定向）2：交易成功主动通知
     * @param rb_BankId  支付的银行
     * @param rp_PayDate 在银行支付的时间
     * @return
     * @throws UnsupportedEncodingException
     */
    @RequestMapping("/callback")
    public String callback(HttpServletRequest request, Model model,String uuids, String hmac, String r0_Cmd, String r1_Code, String r2_TrxId, String r3_Amt, String r4_Cur, String r5_Pid, String r6_Order, String r7_Uid, String r8_MP, String r9_BType, String rb_BankId, String rp_PayDate) throws UnsupportedEncodingException {

        request.setCharacterEncoding("GBK");
        //获取易宝传输过来的值
        String p1_MerId = "10001126856";
        String keyValue = "69cl522AV6q613Ii4W6u8K6XuW8vM1N6bFgyv769220IuYe9u37N4y7rI4Pl";

        boolean bool = ZhiUtil.verifyCallback(hmac, p1_MerId, r0_Cmd, r1_Code, r2_TrxId,
                r3_Amt, r4_Cur, r5_Pid, r6_Order, r7_Uid,
                r8_MP, r9_BType, keyValue);
        String msg = "";
        if (bool) {
            System.out.println("安全");

            if ("1".equals(r1_Code)) {
                String uuid = this.getUUidByToken(uuids);
                Integer i = rechargeInterfaceService.rechargeInterface(uuid, Double.valueOf(r3_Amt),r6_Order);
                System.out.println("充值成功！！！");
                //这里如果成功，那么把订单的状态改为已经支付
                msg += "支付成功—————商品的订单号为" + r6_Order + "————金额" + r3_Amt + "元-----";
                if ("1".equals(r9_BType)) {
                    msg += "浏览器重定向";
                } else if ("2".equals(r9_BType)) {
                    msg += "易宝主动通知";
                }
                msg += "--易宝公司的订单编号为" + r2_TrxId;

            } else {
                msg += "支付失败";
            }
            System.out.println(msg);
        } else {
            System.out.println("数据来源不合法");
        }
        System.out.println("callback");
        model.addAttribute("msg", msg);
        return "error";
    }


}

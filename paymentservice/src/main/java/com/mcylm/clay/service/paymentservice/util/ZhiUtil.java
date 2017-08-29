package com.mcylm.clay.service.paymentservice.util;

public class ZhiUtil {

	/**
	 * 功能: 把生成的md5进行传给页面 ----
	 * 注： 只有成为易宝的客户的时候，才会给一个商家的编号，和密钥。
	 * 加密的顺序要一致 变量不能为null
	 * @param
	 * @return
	 */
	public static String buildHmac(String p0_Cmd,String p1_MerId,String p2_Order,String p3_Amt,String   
            p4_Cur,String p5_Pid,String p6_Pcat,String p7_Pdesc,String p8_Url,String p9_SAF,String pa_MP,  
            String pd_FrpId,String pr_NeedResponse,String keyValue){  
        StringBuffer str = new StringBuffer();//字符顺序不能改变  
        str.append(p0_Cmd);//业务类型，buy（在线支付）  
        str.append(p1_MerId);//商户编号/成为易宝用户/易宝分配一个商户的编号与密钥  
        str.append(p2_Order);//商户订单号/网站上的订单号-我们系统中跟踪订单  
        str.append(p3_Amt);//支付金额  
        str.append(p4_Cur);//交易币种    CNY
        str.append(p5_Pid);//商品名称/可不提供  
        str.append(p6_Pcat);//商品种类/可不提供  
        str.append(p7_Pdesc);//商品描述/可不提供  
        str.append(p8_Url);//商户接收支付成功数据的地址  
        str.append(p9_SAF);//送货地址/可不填/设为空字符串  
        str.append(pa_MP);//商户扩展信息/在用户支付完之后，发送什么数据按原样返回，做扩展/空字符串  
        str.append(pd_FrpId);//银行编码/银行代码，易宝支付方规定  
        str.append(pr_NeedResponse);//应答机制  
        //为"1": 需要应答机制;为"0": 不需要应答机制.  
        //0后台程序访问结果回调地址，返回200则认为成功，不再通知；1不以200的编码为判断机制，以页面返回结果是否为success为判断，若是则认为接收到，若不是则不断发送  
        //两种应答方式返回支付结果1.向接收路径发送请求数据，不可靠，通过引导用户的浏览器把数据发回Url上，一旦浏览器出问题或人为暂停了浏览器，无法接收到用户的支付结果  
        //2.采用了一个后台程序，后台程序链接到Web服务器，再请求结果回调路径，不依赖用户浏览器，通过服务器后台发送请求  
        String returnStr = DigestUtil.hmacSign(str.toString(),keyValue);//成为易宝用户/易宝提供密钥  
        return returnStr;  
    }  

	
	
	
	/**
	  * 返回校验hmac方法
	  *
	  * @param hmac 支付网关发来的加密验证码
	  * @param p1_MerId 商户编号
	  * @param r0_Cmd 业务类型
	  * @param r1_Code 支付结果
	  * @param r2_TrxId 易宝支付交易流水号
	  * @param r3_Amt 支付金额
	  * @param r4_Cur 交易币种
	  * @param r5_Pid 商品名称
	  * @param r6_Order 商户订单号
	  * @param r7_Uid 易宝支付会员ID
	  * @param r8_MP 商户扩展信息
	  * @param r9_BType 交易结果返回类型
	  * @param keyValue 密钥
	  * @return
	  */
	 public static boolean verifyCallback(String hmac, String p1_MerId,
	   String r0_Cmd, String r1_Code, String r2_TrxId, String r3_Amt,
	   String r4_Cur, String r5_Pid, String r6_Order, String r7_Uid,
	   String r8_MP, String r9_BType, String keyValue) {
	  StringBuffer sValue = new StringBuffer();
	  // 商户编号
	  sValue.append(p1_MerId);
	  // 业务类型
	  sValue.append(r0_Cmd);
	  // 支付结果
	  sValue.append(r1_Code);
	  // 易宝支付交易流水号
	  sValue.append(r2_TrxId);
	  // 支付金额
	  sValue.append(r3_Amt);
	  // 交易币种
	  sValue.append(r4_Cur);
	  // 商品名称
	  sValue.append(r5_Pid);
	  // 商户订单号
	  sValue.append(r6_Order);
	  // 易宝支付会员ID
	  sValue.append(r7_Uid);
	  // 商户扩展信息
	  sValue.append(r8_MP);
	  // 交易结果返回类型
	  sValue.append(r9_BType);
	  String sNewString = DigestUtil.hmacSign(sValue.toString(), keyValue);

	  if (hmac.equals(sNewString)) {
	   return true;
	  }
	  return false;
	 }
}
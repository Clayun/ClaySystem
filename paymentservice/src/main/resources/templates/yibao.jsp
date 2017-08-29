<%@ page language="java" contentType="text/html; charset=GBK"
pageEncoding="GBK"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=GBK">
    <title>Insert title here</title>
</head>
<body>
<!--这个表单是不需要人工  -->
<!-- 测试网关  http://tech.yeepay.com:8080/robot/debug.action -->
<!-- 正常的网管： https://www.yeepay.com/app-merchant-proxy/node -->
<form  action="https://www.yeepay.com/app-merchant-proxy/node" method="post">
    <input type='hidden' name='p0_Cmd' value="Buy"><!-- 请求命令，在线支付固定为Buy -->
    <input type='hidden' name='p1_MerId' value="${merchantID }"><!--  商家ID -->
    <input type='hidden' name='p2_Order' value="${orderId}"><!-- 商家的交易订单号 -->
    <input type='hidden' name='p3_Amt' value="${amount}"><!-- 订单金额 -->
    <input type='hidden' name='p4_Cur' value="CNY"><!-- 货币种类 -->
    <input type='hidden' name='p5_Pid' value=""><!-- 商品ID -->
    <input type='hidden' name='p6_Pcat' value=""><!-- 商品种类 -->
    <input type='hidden' name='p7_Pdesc' value=""><!-- 商品描述 -->
    <input type='hidden' name='p8_Url' value="${p8_Url}"><!-- 交易结果通知地址 -->
    <input type='hidden' name='p9_SAF' value="0"><!-- 需要填写送货信息 0：不需要 1：需要 -->
    <input type='hidden' name='pa_MP' value=""><!-- 商家扩展信息 -->
    <input type='hidden' name='pd_FrpId' value="${pd_FrpId}"><!-- 银行ID -->
    <!-- 应答机制为“1”：需要应答机制，“0”：不要应答机制 -->
    <input type='hidden' name='pr_NeedResponse' value="0">
    <!-- MD5-hmac验证码 -->
    <input type='hidden' name='hmac' value="${hmac }">

    <input type="submit" value="支付">
</form>
</body>
</html>
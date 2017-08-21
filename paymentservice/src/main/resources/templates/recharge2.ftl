<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>订单付款 - 弹性云MineCraft服务器</title>
		<#--<link rel="stylesheet" type="text/css" href="/pay/css/style.css">
		<link rel="stylesheet" type="text/css" href="/pay/css/jquery.range.css">
		<link rel="stylesheet" type="text/css" href="/pay/css/orderpay.css">
		<script type="text/javascript" src="/pay/js/jquery-1.7.1.min.js" ></script>
		<script type="text/javascript" src="/pay/js/jquery.range.js" ></script>-->

	</head>
	
	<body>
    <!-- 117.136.38.178 本机外网地址-->
    <!--1: 要发给支付网关的一些数据。  -->
    <form  action="https://www.yeepay.com/app-merchant-proxy/node" method="post">
        <h2>订单号：${ordersUuid } ,金额 ： ${money}</h2>
        <input type='hidden' name='p0_Cmd' value="Buy"><!-- 请求命令，在线支付固定为Buy -->
        <input type='hidden' name='p1_MerId' value="${p1_MerId}"><!--  商家ID -->
        <input type='hidden' name='p2_Order' value="${ordersUuid}"><!-- 商家的交易订单号 -->
        <input type='hidden' name='p3_Amt' value="${money}"><!-- 订单金额 -->
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

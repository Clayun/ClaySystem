<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>订单付款 - 弹性云MineCraft服务器</title>
	</head>
	
	<body>
    <!-- 117.136.38.178 本机外网地址-->
    <!--1: 要发给支付网关的一些数据。  -->
    <form action="/pay/getFuXinXi" method="post">
        <table>
            <tr>
                <td>
                    <input type="hidden"  name="uuid" value="${uuid}" readonly>
                    <input type="text"  name="ordersUuid" value="${ordersUuid}" readonly>订单编号
                </td>
            </tr>
            <tr>
                <td><input type="text"  name="money" size="6">金额</td>
            </tr>

            <tr>
                <td>
                    <input type="radio" name="pd_FrpId" value="CMBCHINA-NET">招商银行
                    <input type="radio" name="pd_FrpId" value="ICBC-NET">工商银行
                    <input type="radio" name="pd_FrpId" value="ABC-NET">农行银行
                    <input type="radio" name="pd_FrpId" value="CCB-NET">建设银行
                </td>
            </tr>
            <tr>
                <td>
                    <input type="radio" name="pd_FrpId" value="CMBC-NET">中国民生银行总行
                    <input type="radio" name="pd_FrpId" value="CEB-NET">光大银行
                    <input type="radio" name="pd_FrpId" value="BOCO-NET">交通银行
                    <input type="radio" name="pd_FrpId" value="SDB-NET">深圳发展银行
                </td>
            </tr>
            <tr>
                <td>
                    <input type="radio" name="pd_FrpId" value="BCCB-NET">北京银行
                    <input type="radio" name="pd_FrpId" value="CIB-NET">兴业银行
                    <input type="radio" name="pd_FrpId" value="SPDB-NET">上海浦发银行
                    <input type="radio" name="pd_FrpId" value="POST-NET">邮政银行
                </td>
            </tr>
            <tr>
                <td><input type="submit" value="支付"></td>
            </tr>

        </table>
	</body>
</html>

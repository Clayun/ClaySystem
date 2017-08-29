<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<!-- 117.136.38.178 本机外网地址-->
<!--1: 要发给支付网关的一些数据。  -->
<form action="<%=path %>/zhi/getFuXinXi.action" method="post">
    <table>
        <tr>
            <td><input type="text"  name="ding">订单编号</td>

        </tr>
        <tr>
            <td><input type="text"  name="money">金额</td>
        </tr>

        <tr>
            <td>
                <input type="radio" name="wang" value="CMBCHINA-NET">招商银行
                <input type="radio" name="wang" value="ICBC-NET">工商银行
                <input type="radio" name="wang" value="ABC-NET">农行银行
                <input type="radio" name="wang" value="CCB-NET">建设银行
            </td>
        </tr>
        <tr>
            <td>
                <input type="radio" name="wang" value="CMBC-NET">中国民生银行总行
                <input type="radio" name="wang" value="CEB-NET">光大银行
                <input type="radio" name="wang" value="BOCO-NET">交通银行
                <input type="radio" name="wang" value="SDB-NET">深圳发展银行
            </td>
        </tr>
        <tr>
            <td>
                <input type="radio" name="wang" value="BCCB-NET">北京银行
                <input type="radio" name="wang" value="CIB-NET">兴业银行
                <input type="radio" name="wang" value="SPDB-NET">上海浦发银行
                <input type="radio" name="wang" value="POST-NET">邮政银行
            </td>
        </tr>
        <tr>
            <td><input type="submit" value="支付"></td>
        </tr>

    </table>

</form>
</body>
</html>
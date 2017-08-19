<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
		<title></title>
		<script src="/js/jquery-1.7.1.min.js"></script>
	</head>

	<body>
		<form action="/paymentInterface" id="form" method="get">
			<table border="1">
				<tr>
                    <th>付款人编号/用户名<input type="text" name="uuid" value="1"></th>
				</tr>
				<tr>
                    <th>付款金额<input type="text" name="amount" value="100"></th>
				</tr>
				<tr>
                    <th>付款用途<input type="text" name="paymentPurposes" value="1"></th>
				</tr>
				<tr>
                    <th>备注<input type="text" name="remarks" value="买手机！！！"></th>
				</tr>
				<tr>
                    <th>付款时间<input type="text" name="paymentTime" value="2019/9/9"></th>
				</tr>
				<tr>
                    <th>订购月份<input type="text" name="month" value="10"></th>
				</tr>
				<tr>
                    <th>实际金额<input type="text" name="theActualAmount" value="100"></th>
				</tr>
				<tr>
                    <th>状态<input type="text" name="state" value="2"></th>
				</tr>
				<tr>
                	<th colspan="10"><input type="submit" value="测试支付接口" ></th><#--onclick="test()"-->
            	</tr>
			</table>
		</form>

    </body>
</html>

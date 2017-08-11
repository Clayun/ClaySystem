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

		<table border="1">
		<#list ordersList as l>
            <tr>
                <th>付款人编号/用户名</th>
                <th>付款金额</th>
                <th>付款用途</th>
                <th>备注</th>
                <th>付款时间</th>
                <th>实际金额</th>
                <th>状态</th>
            </tr>
			<tr>
                <th>${l.uuid}</th>
                <th>${l.amount}</th>
                <th>${l.paymentPurposesName}</th>
                <th>${l.remarks}</th>
                <th>${l.paymentTime?string("yyyy-MM-dd HH:mm:ss")}</th>
                <th>${l.theActualAmount}</th>
                <th>${l.statesName}</th>
			</tr>
		</#list>
		</table>
    </body>
        <script type="text/javascript">
           function test(){
               alert("看看");
               alert($("#form").serialize());
               $.ajax({
                   url:"paymentInterface",
                   data	:$("#form").serialize(),
                   dataType:'json',
                   type:'post',
                   success:function(m){
                       if (m){
                           alert("支付成功");
                       }
                       else{
                           alert("支付失败");
                       }
                   }
               });
		   }
        </script>
    </footer>

</html>

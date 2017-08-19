<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <script src="/console/js/jquery-3.2.1.min.js"></script>
    <script src="/console/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/console/css/bootstrap.min.css"/>
    <script src="/console/js/bootstrapValidator.min.js"></script>
    <link href="/console/css/bootstrapValidator.min.css" rel="stylesheet" />
    <script src="/console/js/sweetalert.min.js"></script>
    <script src="/console/js/sweetalert-dev.js"></script>
    <link href="/console/css/sweetalert.css" rel="stylesheet" />
    <title>列表</title>
</head>
<script>
    function toback(){
        location.href="orderlist";
    }
</script>
<body>
<div class="container">
    <div class="row" style="margin-top: 30px;">
        <table class="table table-striped table-bordered text-center" style="vertical-align: middle;">
            <tr>
                <td><strong>订单编号</strong></td>
            </tr>
            <tr>
                <td>${dateils.id}</td>
            </tr>
            <tr>
                <td><strong>账单流水号</strong></td>
            </tr>
            <tr>
                <td>${dateils.ordersId}</td>
            </tr>
            <tr>
                <td><strong>购买详情参数</strong></td>
            </tr>
            <tr>
                <td>${dateils.content}</td>
            </tr>
            <tr>
                <td><strong>购买时长</strong></td>
            </tr>
            <tr>
                <td>${dateils.length}</td>
            </tr>
            <tr>
                <td><strong>享受活动内容</strong></td>
            </tr>
            <tr>
                <td>${dateils.activityId}</td>
            </tr>
            <tr>
                <td><strong>账单创建时间</strong></td>
            </tr>
            <tr>
                <td>${dateils.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
            </tr>
            <tr>
                <td>
                    <button class="btn btn-info" onclick="toback()">返回上层</button>
                </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
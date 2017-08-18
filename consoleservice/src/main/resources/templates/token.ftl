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
<body>
    <div class="container">
        <div class="row" style="margin-top: 30px;">
            <table class="table table-striped table-bordered text-center" style="vertical-align: middle;">
                <tr>
                    <td><strong>令牌编号</strong></td>
                    <td><strong>UUID</strong></td>
                    <td><strong>ClientID</strong></td>
                    <td><strong>令牌</strong></td>
                    <td><strong>登录时间</strong></td>
                    <td><strong>主机IP</strong></td>
                </tr>
                <#list list as l>
                    <tr>
                        <td>${l.id}</td>
                        <td>${l.uuid}</td>
                        <td>${l.clientid}</td>
                        <td>${l.token}</td>
                        <td>${l.logintime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${l.hostip}</td>
                    </tr>
                </#list>
            </table>
        </div>
    </div>
</body>
</html>
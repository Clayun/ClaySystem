<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>注册账号 - 企业级云服务器、弹性云MineCraft服务器租用服务提供商</title>
    <link rel="stylesheet" type="text/css" href="/security/css/login.css">

</head>
<body>
<div class="login-box-up-right">
    <div class="login-box-up-right-loginbox">
        <span id="msg"></span>
        <div id="userMessage">
            <span>密码登录</span>
            <p id="msg">请输入您的用户名</p>

            <input type="text" name="username" placeholder="用户名/手机号" id="user" />
            <div style="margin-left: 25px;width: 312px;margin-top: 25px;">
                <div id="captcha1">
                    <p id="wait1" class="show">正在加载验证码......</p>
                </div>
            </div>
            <p id="notice1" class="hide">请先完成验证</p>
            <button style="cursor: pointer;margin-bottom: 10px;" id="submit">下一步</button>
        </div>

        <div id="phoneMessage" style="display: none">
            <span >通过手机 <span id="phone"></span></span>
            <input type="button" id="repely" style="cursor: pointer;" value="发送验证码" class="box1button" /><br>
            <input type="text" name="username" placeholder="验证码" id="vephone" />
            <button style="cursor: pointer;margin-bottom: 10px;" id="submitphone">下一步</button>
        </div>

        <div id="passwordMessage" style="display: none">
            <input type="text" name="password" placeholder="密码" id="pwd" />
            <input type="text" name="qupasword" placeholder="确认密码" id="qupwd">
            <button style="cursor: pointer;margin-bottom: 10px;" id="submitPassword">下一步</button>
        </div>
    </div>
</div>
</div>
<script src="/security/js/jquery-1.7.1.min.js"></script>
<script src="/security/js/gt.js"></script>
<script src="/security/js/restpwd.js"></script>

</body>
</html>
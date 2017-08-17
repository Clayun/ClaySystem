<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>注册账号 - 企业级云服务器、弹性云MineCraft服务器租用服务提供商</title>
    <script src="/security/js/jquery-1.7.1.min.js"></script>
    <link rel="stylesheet" type="text/css" href="/security/css/register.css">
</head>
<body>
<div class="boxx" id="b1">
    <div class="box1">
        <a href="javascript:;" onclick="jQuery('#b1').hide()" class="close"><img src="http://osuyq1koj.bkt.clouddn.com/17-7-12/6917333.jpg" style="margin-left:500px;margin-top:20px;"/></a>
        <span style="color:#000;font-size:24px;margin-left:30px;margin-top:10px;">验证手机</span><br>
        <span id="smsg" style="color:#171B1E;font-size:20px;margin-left:100px;margin-top:20px;"></span><br>
        <span style="color:#171B1E;font-size:20px;margin-left:100px;margin-top:80px;">手机号：<span id="phonenum"></span></span><br>
        <input type="text" id="vephone" placeholder="请输入验证码" style="height: 32px;width: 250px;border: solid 1px #AAAAAA;background-color: #fff;font-size: 16px;color:#999;margin-left:100px;padding-left:5px;margin-top:20px;">
        <input type="button" id="repely" style="cursor: pointer;" value="重新发送" class="box1button" /><br>
        <button id="submitphone" style="cursor: pointer; width: 258px;margin-left: 100px;">提交</button>
    </div>
</div>
<div class="register-banner">
    <div class="register-nav">
        <div class="logo">
        <#--${logo.data}-->
            <div class="p">
                <input type="button" class="nav-button" value="首页" onclick="window.location.href='/index/portal'">
            </div>
        </div>
    </div>
    <div class="register-box">
        <div class="register-box-reg">
            <span style="font-size: 24px;line-height: 100px;">欢迎注册聚乐云</span><br>
            <span style="font-size: 12px;line-height: 30px;color: #888888;" id="msg"></span><br>
            <input type="text" placeholder="设置用户名" id="username" name="username" required/><br>
            <input type="password" placeholder="设置你的登录密码" id="password" name="password" required/><br>
            <input type="password" placeholder="请再次输入你的密码" id="vepassword" required/><br>
            <input type="email" placeholder="请输入你的邮箱" id="email" name="email"  required/><br>
            <input type="text" placeholder="请输入手机号码" id="phone"  name="phone" required/><br>
            <div style="margin-left: 326px;width: 312px;margin-top: 25px;">
                <div id="captcha1">
                    <p id="wait1" class="show">正在加载验证码......</p>
                </div>
            </div>
            <button id="submit" style="cursor: pointer;">同意条款并注册</button>
        </div>
    </div>
</div>
</body>
<div class="body">

    <footer style="background: #FFF;">
        <div class="footer-box-hole">
            <div class="footer-box-up">
                <div class="footer-box-up-left" style="border-right: solid 1px #AAAAAA;">
                    <img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/3117733.jpg">
                    <div class="footer-box-up-left-line" style="color: #555555;">
                        <h3>客服专线</h3>
                        <h2>110-110-110</h2>
                        <br>
                        <p>人工服务</p>
                        <p>快速处理</p>
                        <p>满意度100%</p>
                    </div>
                </div>
                <div class="footer-box-up-right">
                    <ul style="color: #777777;">
                        <li style="color: #555555;">定制内容</li>
                        <li>门店网站</li>
                        <li>APP界面</li>
                        <li>软件界面</li>
                    </ul>
                    <ul style="color: #777777;">
                        <li style="color: #555555;">云主机</li>
                        <li>基本服务器</li>
                        <li>通用服务器</li>
                        <li>应用服务器</li>
                    </ul>
                    <ul style="color: #777777;">
                        <li style="color: #555555;">人工咨询</li>
                        <li>客服咨询</li>
                        <li>设计师专线</li>
                        <li>程序员专线</li>
                        <li>运维专线</li>
                    </ul>
                    <ul style="color: #777777;">
                        <li style="color: #555555;">关注我们</li>
                        <li><img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/16002364.jpg" height="128px"></li>
                    </ul>
                </div>
            </div>
            <div class="footer-box-middle" style="border-bottom: solid 1px #AAAAAA;"></div>
            <div class="footer-box-down">
                <span>©2012-2017 北京信联创维科技有限公司 版权所有 ICP证：京ICP备16065100号-1</span>
            </div>
        </div>
    </footer>
    <script type="text/javascript" src="/security/js/register01.js" ></script>
    <script src="/security/js/gt.js"></script>
    <script src="/security/js/md5.js"></script>
</html>
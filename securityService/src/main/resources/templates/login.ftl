<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>登录 - 企业级云服务器、弹性云MineCraft服务器租用服务提供商</title>
    <link rel="stylesheet" type="text/css" href="/security/css/login.css">
</head>
	<body>
    <div class="login-banner">
        <div class="login-nav">
            <div class="logo">
			<#--${logo.data}-->
                <div class="p">
                    <input type="button" class="nav-button" value="首页" onclick="window.location.href='/'">
                </div>
            </div>
        </div>
        <div class="login-box">
            <div class="login-box-up-left">
                <div class="login-box-up-left-linebox">
                    <h3>低廉价格，机制配置</h3>
                    <p>弹性云MineCraft服务器，为您打造极致MC体验</p>
                    <p>企业级应用服务器，超高性价比</p>

                </div>
            </div>
            <div class="login-box-up-right">
                <div class="login-box-up-right-loginbox">
                    <span>密码登录</span>
                    <p id="msg">请使用您的用户名或手机号码登录</p>
                    <input type="text" name="username" placeholder="用户名/手机号" id="user" />
                    <input type="password" name="password" placeholder="密码" id="pwd" required/>
                    <div style="margin-left: 25px;width: 312px;margin-top: 25px;">
                        <div id="captcha1">
                            <p id="wait1" class="show">正在加载验证码......</p>
                        </div>
                    </div>
                    <p id="notice1" class="hide">请先完成验证</p>
                    <button style="cursor: pointer;margin-bottom: 10px;" id="submit">登录</button>
                    <p style="display: inline;">忘记密码？</p><p style="display: inline;">免费注册</p>
                    <input style="display: none" id="redirectUrl" type="text" value="${redirectUrl}">
                </div>
            </div>
        </div>
    </div>
    </body>
<footer>
    <div class="footer-box-hole">
        <div class="footer-box-up">
            <div class="footer-box-up-left">
                <img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/3117733.jpg">
                <div class="footer-box-up-left-line">
                    <h3>客服专线</h3>
                    <h2>110-110-110</h2>
                    <br>
                    <p>人工服务</p>
                    <p>快速处理</p>
                    <p>满意度100%</p>
                </div>
            </div>
            <div class="footer-box-up-right">
                <ul>
                    <li>定制内容</li>
                    <li>门店网站</li>
                    <li>APP界面</li>
                    <li>软件界面</li>
                </ul>
                <ul>
                    <li>云主机</li>
                    <li>基本服务器</li>
                    <li>通用服务器</li>
                    <li>应用服务器</li>
                </ul>
                <ul>
                    <li>人工咨询</li>
                    <li>客服咨询</li>
                    <li>设计师专线</li>
                    <li>程序员专线</li>
                    <li>运维专线</li>
                </ul>
                <ul>
                    <li>关注我们</li>
                    <li><img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/16002364.jpg" height="128px"></li>
                </ul>
            </div>
        </div>
        <div class="footer-box-middle"></div>
        <div class="footer-box-down">
            <span>©2012-2017 北京信联创维科技有限公司 版权所有 ICP证：京ICP备16065100号-1</span>
        </div>
    </div>
</footer>

<script src="/security/js/jquery-1.7.1.min.js"></script>
<script src="/security/js/gt.js"></script>
<script src="/security/js/login.js"></script>
</html>

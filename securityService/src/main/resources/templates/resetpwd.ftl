<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>密码找回 - 企业级云服务器、弹性云MineCraft服务器租用服务提供商</title>
        <link rel="stylesheet" type="text/css" href="/ecs/css/nav.css">
		<link rel="stylesheet" type="text/css" href="/ecs/css/createstyle.css">
        <link rel="stylesheet" type="text/css" href="/security/css/login.css">
		<script type="text/javascript" src="/ecs/js/jquery-1.7.1.min.js" ></script>
	</head>
	
	<body>
		<div class="create-banner">
            <div class="nav">
                <div class="logo">
                    <a href="/index"><img src="http://osuyq1koj.bkt.clouddn.com/17-7-19/38186757.jpg"></a>
                    <div class="p" id="ulg">
                        <input type="button" class="nav-button" value="登录" onclick="window.location.href='/security/author/login'">
                        <input type="button" class="nav-button" value="注册有礼" onclick="window.location.href='/ucenter/register'" style="background-color:#FFF; color:#09F; border-color:#e7f0fd;">
                        <input type="button" class="nav-button" value="控制台" onclick="window.location.href='/console/home'">
                    </div>
                    <div class="p" id="lg" style="display: none">
                        <img src=""/>
                        <input id="uname" type="button" class="nav-button"  style="border:none;border:none;width:100px;">
                        <input type="button" class="nav-button" value="最新消息" style="border:none;width:50px;" >
                        <input type="button" class="nav-button" value="控制台" onclick="window.location.href='/console/home'">
                        <input type="button" class="nav-button" value="退出" style="border:none;width:30px;" onclick="logout()">
                    </div>
                </div>
                <nav class="nav-line">
                    <ol>
                        <a href="#" id="firstpage">
                            <li class="firstpage">☰ 首页</li>
                        </a>
                        <a href="#" id="ecspage">
                            <li id="ecs">云服务器</li>
                        </a>
                        <a href="#" id="thirdpage">
                            <li id="begin">定制服务</li>
                        </a>
                        <a href="#" id="fthpage">
                            <li>人工服务</li>
                        </a>
                        <a href="#" id="fifthpage">
                            <li>关于我们</li>
                        </a>
                    </ol>
                </nav>
            </div>
            <div class="nav-slide-down" id="firstpage-nav" style="display: none;">
                <ul>
                    <li><a href="/ecs/enterprise/create">首页</a></li>
                </ul>
            </div>
            <div class="nav-slide-down" id="ecs-nav" style="display: none;">
                <ul>
                    <li>云服务器 ECS</li>
                </ul>
            </div>
            <div class="nav-slide-down" id="third-nav" style="display: none;">
                <ul>
                    <li>网页设计</li>
                    <li>电子商城开发</li>
                    <li>手机APP开发</li>
                </ul>
            </div>
            <div class="nav-slide-down" id="fth-nav" style="display: none;">
                <ul>
                    <li>QQ客服</li>
                    <li>微信客服</li>
                </ul>
            </div>
            <div class="nav-slide-down" id="fifth-nav" style="display: none;">
                <ul>
                    <li>联系我们</li>
                </ul>
            </div>
	            <div class="create-head">
	            	<br><br>
					<h2 style="color: #FFF;">密码找回</h2>
					<br>
					<p style="color: #FFF; font-size: 16px;">忘了又能怎样？</p>
					<p style="color: #FFF; font-size: 16px;">找回就是这么的容易！</p>
				</div>
				<div class="create-cloud" style="height: 700px; background: #FFF;">
                    <div class="login-box-up-right">
                        <div class="login-box-up-right-loginbox">
                            <span id="msg"></span>
                            <div id="userMessage">
                                <span>密码找回</span>
                                <p id="msg">请输入您的用户名</p>

                                <input type="text" name="username" placeholder="用户名/手机号" id="user" />
                                <div style="margin-left: 25px;width: 317px;margin-top: 25px;">
                                    <div id="captcha1">
                                        <p id="wait1" class="show">正在加载验证码......</p>
                                    </div>
                                </div>
                                <p id="notice1" class="hide">请先完成验证</p>
                                <button style="cursor: pointer;margin-bottom: 10px;" id="submit">下一步</button>
                            </div>

                            <div id="phoneMessage" style="display: none">
                                <span >通过手机 <span id="phone"></span></span>
                                <input type="button" id="repely" style="cursor: pointer;width: 312px;" value="发送验证码" class="box1button" /><br>
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
					<div class="login-box-up-left">
                        <div class="login-box-up-left-linebox" style="color: #000">
                            <h3>低廉价格，机制配置</h3>
                            <p>弹性云MineCraft服务器，为您打造极致MC体验</p>
                            <p>企业级应用服务器，超高性价比</p>
                            <p>弹性云MineCraft服务器，为您打造极致MC体验</p>
                            <p>企业级应用服务器，超高性价比</p>
                            <p>弹性云MineCraft服务器，为您打造极致MC体验</p>
                            <p>企业级应用服务器，超高性价比</p>
                            <p>弹性云MineCraft服务器，为您打造极致MC体验</p>
                            <p>企业级应用服务器，超高性价比</p>
                            <p>弹性云MineCraft服务器，为您打造极致MC体验</p>
                            <p>企业级应用服务器，超高性价比</p>
                        </div>
					</div>
                </div>
    	</div>
	</body>
	<footer style="background: #EEEEEE;">
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
	<script type="text/javascript" src="/ecs/js/create.js" ></script>
    <script type="text/javascript" src="/ecs/js/nav.js" ></script>
	<script src="/ecs/js/loginout.js"></script>
    <script src="/security/js/gt.js"></script>
    <script src="/security/js/restpwd.js"></script>
</html>

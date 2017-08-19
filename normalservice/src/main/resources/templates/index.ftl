<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
	<head>
		<meta charset="utf-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
		<title>${index_head_title.label}</title>
		<link rel="stylesheet" type="text/css" href="/css/style.css">
		<link rel="stylesheet" type="text/css" href="/css/bootstrap-grid.min.css">
		<script src="/js/jquery-1.7.1.min.js"></script>
		<script src="/js/banner.js"></script>
		<script src="/js/function.js"></script>
		<script src="/js/headerlogin.js"></script>

	</head>

	<body>
		<div class="banner">
			<div class="banner-info">
				<div id="clan-1">
					<div class="banner-info-img">
						${index_banner_1_img.label}
					</div>
					<div class="banner-info-line">
						${index_banner_1_text_1.label?if_exists}
						${index_banner_1_text_2.label?if_exists}
						${index_banner_1_text_3.label?if_exists}
						${index_banner_1_text_4.label?if_exists}
					</div>
				</div>
				<div id="clan-2">
					<div class="banner-info-img">
					${index_banner_2_img.label}
					</div>
					<div class="banner-info-line">
						${index_banner_2_text_1.label?if_exists}
						${index_banner_2_text_2.label?if_exists}
						${index_banner_2_text_3.label?if_exists}
						${index_banner_2_text_4.label?if_exists}
						${index_banner_2_text_5.label?if_exists}
					</div>
				</div>
				<div id="clan-3">
					<div class="banner-info-img">
					${index_banner_3_img.label}
					</div>
					<div class="banner-info-line">
						${index_banner_3_text_1.label?if_exists}
						${index_banner_3_text_2.label?if_exists}
						${index_banner_3_text_3.label?if_exists}
						${index_banner_3_text_4.label?if_exists}
					</div>
				</div>
				<div class="banner-loc">
					<span id="clan-1-1">▃</span>
					<span id="clan-2-2">▃</span>
					<span id="clan-3-3">▃</span>
				</div>
				<div class="nav">
					<div class="logo">
						<a href="/index/portal"><img src="http://osuyq1koj.bkt.clouddn.com/17-7-19/38186757.jpg"></a>
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
							<a href="/index/portal">
								<li class="firstpage">☰ 首页</li>
							</a>
							<a href="/index/create">
								<li id="ecs">云服务器</li>
							</a>
							<a href="#">
								<li id="begin">定制服务</li>
							</a>
							<a href="#">
								<li>人工服务</li>
							</a>
							<a href="#">
								<li>关于我们</li>
							</a>
						</ol>
					</nav>
				</div>
			</div>
		</div>
		<div class="canus">

			<div class="canus-box" style="border:none;">
				<div class="canus-box-img">
					<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/52482441.jpg">
				</div>
				<div class="canus-box-line">
					<h3>人工客服</h3>
					<p>我们的客服是程序猿和设计狮</p>
					<p>专业，保证客户需求转达的准确</p>
				</div>
			</div>

			<div class="canus-box">
				<div class="canus-box-img">
					<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/19671195.jpg">
				</div>
				<div class="canus-box-line">
					<h3>支付安全</h3>
					<p>支付宝平台安全交易</p>
					<p>确认满意后再付款</p>
				</div>
			</div>

			<div class="canus-box">
				<div class="canus-box-img">
					<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/60949294.jpg">
				</div>
				<div class="canus-box-line">
					<h3>强悍配置</h3>
					<p>深圳机房千兆服务器</p>
					<p>四年运维经验</p>
				</div>
			</div>

		</div>
		<div class="mid">
			<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/62107095.jpg">
			<div class="mid-box">
				<div class="mid-box-minbox" style="border:none; font-size:20px;">
					<p>我们历经四年的沉淀</p>
					<p>只为更好遇见你</p>
				</div>
				<div class="mid-box-minbox">
					<p>从2012年开始服务器运维</p>
					<p>接受并完成多个项目案例</p>
					<p>经验丰富，为项目保驾护航</p>
				</div>
			</div>
		</div>
		<div class="server">
			<div class="server-box">
				<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/27482410.jpg" style=" float:left; margin-right:20px;">
				<div class="server-line">
					<h2>聚乐云服务</h2>
					<p>多种方式，为您的云服务提供优质稳定的支持，即可享受云带来的高可用性！</p>
					<p style=" color:#09F">专业 安全 稳定 快捷</p>
				</div>
			</div>
		</div>
		<div class="server-list">
			<ul id="cardArea" class="card-area clearfix">
				<li class="card-item active">
					<div class="card">
						<div class="card-title title-even">
							<div class="content">
								<div class="zq-product-img">
									<i class="zq-icon icon40x40 crad-area-icon1"></i>
								</div>
								<h1>企业级云服务器</h1>
								<p class="short-info">弹性伸缩 动态调整</p>
							</div>
						</div>
						<div class="card-content content-first bg-e8e8e8">
							<ul class="content-first-list">
								<li>网站与门户</li>
								<li>数据计算</li>
								<li>游戏服务器</li>
							</ul>
						</div>
						<div class="card-content content-second">
							<div class="main-info">
								<a href="#" class="no-effect">
									<p class="main-head">快速创建服务器，一键部署</p>
								</a>
								<p class="main-tip">弹性选择服务器的配置，根据自己的需求定制服务器</p>
								<p class="main-desc">利用快速的部署，动态可调整的服务器，帮助您更快捷地完成业务。</p>
								<a href="#">
									<button class="main-btn">了解详情</button>
								</a>
							</div>
							<ul class="other-info clearfix">
								<li class="other-info-list">
									<a href="#" class="no-effect">
										<h3 class="other-head">网站与门户</h3>
										<p class="other-desc">为您保驾护航</p>
									</a>
									<i class="zq-icon icon17x17 c-a-arrow"></i>
								</li>
								<li class="other-info-list">
									<a href="#" class="no-effect">
										<h3 class="other-head">数据计算</h3>
										<p class="other-desc">大数据弹性计算</p>
									</a>
									<i class="zq-icon icon17x17 c-a-arrow"></i>
								</li>
								<li class="other-info-list">
									<a href="#" class="no-effect">
										<h3 class="other-head">游戏服务器</h3>
										<p class="other-desc">动态调整服务器，实时监控</p>
									</a>
									<i class="zq-icon icon17x17 c-a-arrow"></i>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li class="card-item">
					<div class="card">
						<div class="card-title title-even">
							<div class="content">
								<div class="zq-product-img">
									<i class="zq-icon icon40x40 crad-area-icon2"></i>
								</div>
								<h1>弹性云 MineCraft</h1>
								<p class="short-info">容器级应用 经济之选</p>
							</div>
						</div>
						<div class="card-content content-first bg-e1e1e1">
							<ul class="content-first-list">
								<li>弹性云</li>
								<li>安全监控</li>
								<li>插件定制</li>
							</ul>
						</div>

						<div class="card-content content-second">
							<div class="main-info">
								<a href="#" class="no-effect">
									<p class="main-head">弹性云 Minecraft服务器</p>
								</a>
								<p class="main-tip">高可用性，安全性</p>
								<p class="main-desc">1秒创建服务器，快速响应您的需求，祝您快速运营属于自己的服务器</p>
								<a href="/market/">
									<button class="main-btn">了解详情</button>
								</a>
							</div>
							<ul class="other-info clearfix">
								<li class="other-info-list">
									<a href="#" class="no-effect">
										<h3 class="other-head">弹性云</h3>
										<p class="other-desc">容器级服务器，安全可靠</p>
									</a>
									<i class="zq-icon icon17x17 c-a-arrow"></i>
								</li>
								<li class="other-info-list">
									<a href="#" class="no-effect">
										<h3 class="other-head">安全监控</h3>
										<p class="other-desc">实时监控服务器状态</p>
									</a>
									<i class="zq-icon icon17x17 c-a-arrow"></i>
								</li>
								<li class="other-info-list">
									<a href="#" class="no-effect">
										<h3 class="other-head">插件定制</h3>
										<p class="other-desc">定制属于你的特色</p>
									</a>
									<i class="zq-icon icon17x17 c-a-arrow"></i>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li class="card-item">
					<div class="card">
						<div class="card-title title-even">
							<div class="content">
								<div class="zq-product-img">
									<i class="zq-icon icon40x40 crad-area-icon3"></i>
								</div>
								<h1>外包与业务</h1>
								<p class="short-info">在线业务 轻松实现</p>
							</div>
						</div>
						<div class="card-content content-first bg-e8e8e8">
							<ul class="content-first-list">
								<li>软件外包</li>
							</ul>
						</div>

						<div class="card-content content-second">
							<div class="main-info">
								<a href="#" class="no-effect">
									<p class="main-head">外包定制</p>
								</a>
								<p class="main-tip">为中小企业提供软件外包解决方案。</p>
								<p class="main-desc">提供UI设计，网站制作，软件开发，APP开发，MineCraft插件定制等外包服务，即刻满足您的需求</p>
								<a href="#">
									<button class="main-btn">了解详情</button>
								</a>
							</div>
						</div>
					</div>
				</li>
				<li class="card-item">
					<div class="card">
						<div class="card-title title-even">
							<div class="content">
								<div class="zq-product-img">
									<i class="zq-icon icon40x40 crad-area-icon4"></i>
								</div>
								<h1>协同与管理</h1>
								<p class="short-info">连接互通 简便开放</p>
							</div>
						</div>
						<div class="card-content content-first bg-e1e1e1">
							<ul class="content-first-list">
								<li>多终端管理MC</li>
							</ul>
						</div>

						<div class="card-content content-second">
							<div class="main-info">
								<a href="#" class="no-effect">
									<p class="main-head">多终端管理MC</p>
								</a>
								<p class="main-tip">分权限管理Minecraft服务器</p>
								<p class="main-desc">帮助Minecraft服主更快捷安全的分权限管理服务器</p>
								<a href="#">
									<button class="main-btn mr20">了解详情</button>
								</a>
								<a href="#">
									<button class="main-white-btn">敬请期待</button>
								</a>
							</div>
							<ul class="other-info clearfix">
								<li class="other-info-list">
									<a href="#" class="no-effect">
										<h3 class="other-head">权限管理</h3>
										<p class="other-desc">最安全的管理模式</p>
									</a>
									<i class="zq-icon icon17x17 c-a-arrow"></i>
								</li>
							</ul>
						</div>
					</div>
				</li>
			</ul>
		</div>
		<div class="border"></div>
		<div class="border"></div>
		<div class="web">
			<div class="web-box">
				<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/38924654.jpg" style=" float:left; margin-right:20px;">
				<div class="server-line">
					<h1>UI设计</h1>
					<p style="padding-top:10px;">丰富外包经验 支持一次修改调整</p>
					<p style=" color:#09F">业内最佳用户体验</p>
				</div>

			</div>
		</div>
		<div class="border" style="background:#ededed"></div>
		<div class="web-box-max">
			<div class="web-box-minbox">
				<div class="web-box-miniboxs">
					<h3 class="web-box-miniboxs-font-h3">门面网站</h3>
					<p class="web-box-miniboxs-font-p">公司网站 游戏网站 宣传门户</p>
					<hr style="width:85%;margin:0 auto; margin-top: 20px; margin-bottom:20px;">
					<p class="web-box-miniboxs-font-p2">尊重用户才能获得用户，着眼行业，分析受众，互联网＋时代，追求良好的浏览体验。设计最适合用户的网站页面。</p>
					<hr style="width:85%;margin:0 auto; margin-top: 20px; margin-bottom:20px;">
					<p class="web-box-miniboxs-font-p2"><span style="color:#FC0">￥50</span> 元起</p>
					<input type="button" class="web-box-miniboxs-button" value="立即订制">
				</div>
				<div class="web-box-miniboxs">
					<h3 class="web-box-miniboxs-font-h3">APP界面</h3>
					<p class="web-box-miniboxs-font-p">手机APP 手机网站</p>
					<hr style="width:85%;margin:0 auto; margin-top: 20px; margin-bottom:20px;">
					<p class="web-box-miniboxs-font-p2">尊重用户才能获得用户，着眼行业，分析受众，互联网＋时代，追求良好的浏览体验。设计最适合用户的网站页面。</p>
					<hr style="width:85%;margin:0 auto; margin-top: 20px; margin-bottom:20px;">
					<p class="web-box-miniboxs-font-p2"><span style="color:#FC0">￥200</span> 元起</p>
					<input type="button" class="web-box-miniboxs-button" value="立即订制">
				</div>
				<div class="web-box-miniboxs">
					<h3 class="web-box-miniboxs-font-h3">软件界面</h3>
					<p class="web-box-miniboxs-font-p">Windows 应用程序界面</p>
					<hr style="width:85%;margin:0 auto; margin-top: 20px; margin-bottom:20px;">
					<p class="web-box-miniboxs-font-p2">尊重用户才能获得用户，着眼行业，分析受众，互联网＋时代，追求良好的浏览体验。设计最适合用户的网站页面。</p>
					<hr style="width:85%;margin:0 auto; margin-top: 20px; margin-bottom:20px;">
					<p class="web-box-miniboxs-font-p2"><span style="color:#FC0">￥50</span> 元起</p>
					<input type="button" class="web-box-miniboxs-button" value="立即订制">
				</div>
			</div>
		</div>
		<div class="submit">
			<div class="submit-box">
				<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/74106529.jpg" style=" float:left; margin-right:20px;">
				<div class="server-line">
					<h1>提交需求</h1>
					<p style="padding-top:10px;">客服会在一个工作日内对您的需求进行答复</p>
					<p style=" color:red">耐心等待</p>
				</div>
			</div>
		</div>
		<div class="submit-box-bigbox">
			<div class="submit-box-bigbox-insidebox">
				<div class="submit-box-bigbox-insidebox-left">
					<p class="submit-box-bigbox-insidebox-right-font-1">留下您的联系方式，方便我们尽快答复您</p>
					<p class="submit-box-bigbox-insidebox-right-font-1">请仔细说明需求，以便我们更好的为您解决问题。如有必要可以附以图片外链</p>
					<p class="submit-box-bigbox-insidebox-right-font-2">优质服务源于细节</p>
				</div>
				<div class="submit-box-bigbox-insidebox-right">
					</span><input type="text" placeholder="电话号" class="submit-box-bigbox-insidebox-right-input">
					</span><textarea placeholder="您的需求" class="submit-box-bigbox-insidebox-right-textarea"></textarea>
					</span><input type="text" placeholder="怎样称呼您？" class="submit-box-bigbox-insidebox-right-input">
					<input type="button" class="submit-box-bigbox-insidebox-right-button" value="立即订制">
				</div>
			</div>
		</div>
		<div class="friend">
			<h1>携手方能共赢</h1>
			<p>使用聚乐云服务的相关企业团队以及合作案例</p>
			<div class="friend-box">
				<div class="friend-box-items">
					<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/99429662.jpg">
				</div>
				<div class="friend-box-items">
					<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/67224596.jpg">
				</div>
			</div>
		</div>
	</body>
	<footer style="height: 600px;">
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
		<script src="/js/loginout.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#cardArea").cardArea()
			});
		</script>
	</footer>

</html>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>服务器续费 - 弹性云MineCraft服务器</title>
		<link rel="stylesheet" type="text/css" href="css/style.css">
		<link rel="stylesheet" type="text/css" href="css/jquery.range.css">
		<script type="text/javascript" src="js/jquery-1.7.1.min.js" ></script>
		<script type="text/javascript" src="js/jquery.range.js" ></script>

	</head>
	
	<body>
		<div class="create-banner" style="background: url(http://osuyq1koj.bkt.clouddn.com/17-7-19/47503777.jpg) repeat-x">
			<div class="nav">
                <div class="logo">
                    <a href="/index/portal"><img src="http://osuyq1koj.bkt.clouddn.com/17-7-19/38186757.jpg"></a>
                    <div class="p">
                        <input type="button" class="nav-button" value="登录" style=" border:none;">
                        <input type="button" class="nav-button" value="免费体验" style=" border:none;">
                        <input type="button" class="nav-button" value="注册有礼" style="background-color:#FFF; color:#09F; border-color:#e7f0fd;">
                        <input type="button" class="nav-button" value="控制台">
                    </div>
                </div>
                <nav class="nav-line">
                    <ol>
                        <a href="#"><li class="firstpage">☰ 首页</li></a>
                        <a href="#"><li id="begin">开始定制</li></a>
                        <a href="#"><li id="ecs">云主机</li></a>
                        <a href="#"><li>人工服务</li></a>
                        <a href="#"><li>关于我们</li></a>
                    </ol>  
                </nav>
            </div>
	            <div class="create-head">
	            	<br><br>
					<h2 style="color: #FFF;">续费服务器</h2>
					<br>
					<p style="color: #FFF; font-size: 16px;">快速续费服务器，为您的服务器及时“充电”</p>
					<p style="color: #FFF; font-size: 16px;">让您更专注于业务运营</p>
				</div>
				<div class="create-cloud">
					<span style="margin-left: 100px;line-height: 100px;font-size: 30px;font-weight: bold; color: #555;">配置详情</span>
					<div class="renew-box">
						<div class="renew-box-items"><br><br>
							<span style=" font-weight: bold;color:#555;">实例名称：</span><span id="entityName">${vpsData.othername}</span><br>
							<span style=" font-weight: bold;color:#555;">实例ID：</span><span id="entityId">${vpsData.id}</span><br>
							<span style=" font-weight: bold;color:#555;">实例UUID：</span><span id="entityUUId">${vpsData.name}</span><br>
							<span style=" font-weight: bold;color:#555;">操作系统：</span><span id="entityOS">${vpsData.core}</span><br>
							<span style=" font-weight: bold;color:#555;">月付价格：</span><span id="entityPrice">${vpsData.price}</span><br>
						</div>
						<div class="renew-box-items"><br><br>
							<span style=" font-weight: bold;color:#555;">公网带宽：</span><span id="entityTape">${vpsData.tape}Mb</span><br>
							<span style=" font-weight: bold;color:#555;">内存：</span><span id="entityMem">${vpsData.memory}Mb</span><br>
							<span style=" font-weight: bold;color:#555;">系统盘：</span><span id="entitySys">${vpsData.sysdisk}Mb</span><br>
							<span style=" font-weight: bold;color:#555;">拓展盘：</span><span id="entityMore">${vpsData.moredisk}Mb</span><br>
							<span style=" font-weight: bold;color:#555;">剩余天数：</span><span id="entityLastDay">${vpsData.lastday}天</span><br>
						</div>
						<div class="renew-box-items"><br><br>
							<span style=" font-weight: bold;color:#555;">内网IP：</span><span id="entityIPin">${vpsData.iphostin}</span><br>
							<span style=" font-weight: bold;color:#555;">外网IP：</span><span id="entityIPout">${vpsData.iphostout}</span><br>
							<span style=" font-weight: bold;color:#555;">初次购买时间：</span><span id="entityCreateTime"><fmt:formatDate value="${vpsData.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></span><br>
						</div>

						<span style="line-height: 100px;font-size: 30px;font-weight: bold; color: #555;">续费时间</span>
						<div class="renew-box-items-middle">
							<input type="hidden" class="single-slider" value="1" id="month" />
						</div>
						<div class="renew-box-items-bottom-left">
							请核实您选中的续费服务器，避免出现不必要的损失<br>
							如有任何疑义请提交工单或联系在线客服。
						</div>
						<div class="renew-box-items-bottom-right">
							<span>配置费用：</span><span style="color: #f1a417;font-size: 40px;">￥<span id="price">${vpsData.price}</span></span><br>
							<button class="banner-info-line-button" style="background:#f1a417;border: none;color: #fff;width: 250px;" id="paynow">立即支付</button>
						</div>
					</div>


				</div>
    	</div>
    	<div class="border"></div>
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
	<script src="js/loginout.js"></script>
	<script type="text/javascript" src="js/renew.js" ></script>
</html>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>订单付款 - 弹性云MineCraft服务器</title>
		<link rel="stylesheet" type="text/css" href="/pay/css/style.css">
		<link rel="stylesheet" type="text/css" href="/pay/css/jquery.range.css">
		<link rel="stylesheet" type="text/css" href="/pay/css/orderpay.css">
		<script type="text/javascript" src="/pay/js/jquery-1.7.1.min.js" ></script>
		<script type="text/javascript" src="/pay/js/jquery.range.js" ></script>

	</head>
	
	<body>
		<div class="boxx" id="b1">
			<div class="box1">
            <a href="javascript:;" onclick="jQuery('#b1').hide()" class="close"><img src="http://osuyq1koj.bkt.clouddn.com/17-7-12/6917333.jpg" style="margin-left:500px;margin-top:20px;"/></a>
            <span style="color:#000;font-size:24px;margin-left:30px;margin-top:10px;">验证手机</span><br><br>
            <span id="smsg" style="color:#171B1E;font-size:20px;margin-left:100px;margin-top:20px;"></span>
            <span style="color:#171B1E;font-size:20px;margin-left:100px;margin-top:80px;" id="phonemessge">手机号：<span id="phonenum"></span></span><br>
            <input type="text" id="vephone" placeholder="请输入验证码" style="height: 32px;width: 250px;border: solid 1px #AAAAAA;background-color: #fff;font-size: 16px;color:#999;margin-left:100px;padding-left:5px;margin-top:20px;">
            <input type="button" id="repely" style="cursor: pointer;" value="发送验证码" class="box1button" /><br>
            <button id="submitphone" style="cursor: pointer; width: 258px;margin-left: 100px;">提交</button>
        </div>
		</div>
		<div class="create-banner" style="background: url(http://osuyq1koj.bkt.clouddn.com/17-7-20/11198340.jpg) repeat-x">
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
					<h2 style="color: #FFF;">订单付款</h2>
					<br>
					<p style="color: #FFF; font-size: 16px;">对已选订单进行付款</p>
					<p style="color: #FFF; font-size: 16px;">让您更专注于业务运营</p>
				</div>
				<div class="create-cloud">
					<span style="margin-left: 100px;line-height: 100px;font-size: 30px;font-weight: bold; color: #555;">配置清单</span>
					<div class="renew-box">
						<div class="renew-box-items" style="width: 1000px;"><br><br>

							<input type="hidden" value="${id}" name="uuid" id="uuid">
							<span style=" font-weight: bold;color:#555;">服务器名称：</span><span id="ser_name">${ecsServer.ser_name}</span><br>
							<span style=" font-weight: bold;color:#555;">CPU核心数：</span><span id="cpu">${ecsServer.cpu}</span><br>
                            <span style=" font-weight: bold;color:#555;">内存：</span><span id="memory">${ecsServer.memory}</span><br>
                            <span style=" font-weight: bold;color:#555;">系统盘大小：</span><span id="os_disk">${ecsServer.os_disk}</span><br>
                            <span style=" font-weight: bold;color:#555;">拓展盘大小：</span><span id="expand_disk">${ecsServer.expand_disk}</span><br>
                            <span style=" font-weight: bold;color:#555;">带宽（单位Mb）：</span><span id="tape">${ecsServer.tape}</span><br>
                            <span style=" font-weight: bold;color:#555;">IP数量：</span><span id="ips">${ecsServer.ips}</span><br>
                            <span style=" font-weight: bold;color:#555;">系统镜像：</span><span id="image">${ecsServer.image}</span><br>
                            <span style=" font-weight: bold;color:#555;">每月单价：</span><span id="pricePerMonth">${ecsServer.pricePerMonth}</span><br>
							<span style=" font-weight: bold;color:#555;">创建时间：</span><span id="createTime">${ecsServer.createTime?string("yyyy-MM-dd HH:mm:ss")}</span><br>·
						</div>

						<span style="line-height: 100px;font-size: 30px;font-weight: bold; color: #555;">购买时长</span>
						<div class="renew-box-items-middle">
							<input type="hidden" class="single-slider" value="3"/>
						</div>
						<div class="renew-box-items-bottom-left">
							<#--<div id="infoHelp">
								请核实您选中的订单，避免出现不必要的损失，如果队选中订单不满意，可以重新生成订单！<br>
								如有任何疑义请提交工单或联系在线客服。
                        	</div>-->
							<div id="infoActivit">
									<span>
                                                活动详情
									</span><br>
									<span>
									<#list detail as l>
										<ol>
											<li><input type="radio" name="id" value="${l.id}"onclick="selectedInfo()" >${l.content}</li>
										</ol>
									</#list>
									</span>
									<span>
									<#list details as l>
										<ol>
											<li><input type="checkbox" name="ids" value="${l.id}" onclick="selectedInfo()">${l.content}</li>
										</ol>
									</#list>
									</span>
							</div>
						</div>
						<div class="renew-box-items-bottom-right">
							<div >
								<span id="pzPrice">配置费用：</span><span style="color: #f1a417;font-size: 40px;">￥<span id="price">${ecsServer.pricePerMonth}</span></span><br>
							</div>
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
	<script src="/pay/js/loginout.js"></script>
	<script type="text/javascript" src="/pay/js/orderPay.js" ></script>
</html>

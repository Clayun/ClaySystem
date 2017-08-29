<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>聚乐云 - 弹性云MineCraft服务器 - 产品详情</title>
        <link rel="stylesheet" type="text/css" href="/ecs/css/nav.css">
		<link rel="stylesheet" type="text/css" href="/ecs/css/createstyle.css">
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
                    <li><a href="/index">首页</a></li>
                </ul>
            </div>
            <div class="nav-slide-down" id="ecs-nav" style="display: none;">
                <ul>
                    <li><a href="/ecs/enterprise/create">云服务器 ECS</a></li>
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
					<h2 style="color: #FFF;">弹性云服务器</h2>
					<br>
					<p style="color: #FFF; font-size: 16px;">弹性云服务器是一种弹性可伸缩的计算服务，帮您更快的</p>
					<p style="color: #FFF; font-size: 16px;">部署服务器，让您更专注于业务运营</p>	
				</div>
				<div class="create-cloud">
					<div class="create-table">
						<div class="create-table-left" id="CLOUDMC-BUTTON">全新服务，敬请期待</div>
						<div class="create-table-right" id="VPS-BUTTON">云服务器 ECS</div>
					</div>
					<div id="VPS" style="display: block;">
						<div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/37899009.jpg" style="vertical-align: middle;" />CPU
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<#list ecsProduce.ecsCpuList as item>
										<#if item.id == 1>
                                            <div class="create-cloud-items-right-box-selected" id="cpu-${item.id}" onclick="selectProduct(${item?size},'cpu',${item.id});getvpsprice()">${item.coreNum} 核</div>
										<#else>
                                            <div class="create-cloud-items-right-box" id="cpu-${item.id}" onclick="selectProduct(${item?size},'cpu',${item.id});getvpsprice()">${item.coreNum} 核</div>
										</#if>
									</#list>
									<p>选择合适的CPU核心数，企业级WEB应用服务器推荐4核心</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：内存
	                    -->
						<div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/14082787.jpg" style="vertical-align: middle;" />内存
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<#list ecsProduce.ecsMemoryList as item>
										<#if item.id == 1>
											<div class="create-cloud-items-right-box-selected" id="mem-${item.id}" onclick="selectProduct(${item?size},'mem',${item.id});getvpsprice()">${item.memNum} Gb</div>
										<#else>
											<div class="create-cloud-items-right-box" id="mem-${item.id}" onclick="selectProduct(${item?size},'mem',${item.id});getvpsprice()">${item.memNum} Gb</div>
										</#if>
									</#list>
									<p>选择合适内存，适当为应用留一些空闲内存，避免内存溢出</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：系统硬盘
	                    -->
	                    <div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/34661901.jpg" style="vertical-align: middle;" />系统盘
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<#list ecsProduce.ecsOsDiskList as item>
										<#if item.id == 1>
											<div class="create-cloud-items-right-box-selected" id="osdisk-${item.id}" onclick="selectProduct(${item?size},'osdisk',${item.id});getvpsprice()">${item.osdiskSize} Gb</div>
										<#else>
											<div class="create-cloud-items-right-box" id="osdisk-${item.id}" onclick="selectProduct(${item?size},'osdisk',${item.id});getvpsprice()">${item.osdiskSize} Gb</div>
										</#if>
									</#list>
									<p>选择合适系统硬盘大小</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：拓展硬盘
	                    -->
	                    <div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/34661901.jpg" style="vertical-align: middle;" />拓展硬盘
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<#list ecsProduce.ecsExpandDiskList as item>
										<#if item.id == 1>
											<div class="create-cloud-items-right-box-selected" id="expanddisk-${item.id}" onclick="selectProduct(${item?size},'expanddisk',${item.id});getvpsprice()">${item.expanddiskSize} Gb</div>
										<#else>
											<div class="create-cloud-items-right-box" id="expanddisk-${item.id}" onclick="selectProduct(${item?size},'expanddisk',${item.id});getvpsprice()">${item.expanddiskSize} Gb</div>
										</#if>
									</#list>
									<p>适当选择合适的拓展硬盘</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：带宽
	                    -->
	                    <div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/54511807.jpg" style="vertical-align: middle;" />带宽
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<#list ecsProduce.ecsTapeList as item>
										<#if item.id == 1>
											<div class="create-cloud-items-right-box-selected" id="tape-${item.id}" onclick="selectProduct(${item?size},'tape',${item.id});getvpsprice()">${item.tapeSize} Mb</div>
										<#else>
											<div class="create-cloud-items-right-box" id="tape-${item.id}" onclick="selectProduct(${item?size},'tape',${item.id});getvpsprice()">${item.tapeSize} Mb</div>
										</#if>
									</#list>
									<p>选择您的带宽额度</p>
								</div>
							</div>
						</div>

                        <!--
                            作者：offline
                            时间：2017-07-09
                            描述：ip数量
                        -->
                        <div class="create-cloud-items">
                            <div class="create-cloud-items-left">
                                <img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/54511807.jpg" style="vertical-align: middle;" />IP数量
                            </div>
                            <div class="create-cloud-items-right">
                                <div class="create-cloud-items-right-main-box">
									<#list ecsProduce.ecsIpList as item>
										<#if item.id == 1>
											<div class="create-cloud-items-right-box-selected" id="ip-${item.id}" onclick="selectProduct(${item?size},'ip',${item.id});getvpsprice()">${item.ipNum} 个</div>
										<#else>
											<div class="create-cloud-items-right-box" id="ip-${item.id}" onclick="selectProduct(${item?size},'ip',${item.id});getvpsprice()">${item.ipNum} 个</div>
										</#if>
									</#list>
                                    <p>选择您的服务器的BGPIP数量</p>
                                </div>
                            </div>
                        </div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：OS系统
	                    -->
	                    <div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/54511807.jpg" style="vertical-align: middle;" />镜像
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<select id="choose-core">
										<option id="choose" value="0">请选择</option>
									</select>
									<select id="choose-kid">
										<option>请选择</option>
									</select>
									<p>选择合适的系统镜像</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：系统密码
	                    -->
	                    <div class="create-cloud-items">
						<div class="create-cloud-items-left">
							<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/54511807.jpg" style="vertical-align: middle;" />系统密码
						</div>
						<div class="create-cloud-items-right">
							<div class="create-cloud-items-right-main-box">
								<input type="password" placeholder="系统密码" id="xtmm" />
								<p>请输入您的系统初始化密码</p>
							</div>
						</div>
					</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：价格统计
	                    -->
						<div class="create-cloud-items" style="border: none;">
							<div class="create-cloud-items-left">

							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<span>配置费用：  </span><span id="vpsprice" style="color:#FFA042;font-size: 24px;">正在计算价格..</span><button type="button" style="cursor: pointer;padding: 0;margin-left: 200px;background:#FFA042;border: none; width: 140px; height: 40px; color: #fff;" id="justnowbuyvps" onclick="sendEcsOrder()">立即购买</button>
								</div>
							</div>
						</div>
					</div>
					
					<div id="CLOUDMC" style="display: none;">
						<div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/37899009.jpg" style="vertical-align: middle;" />服务器名称
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<input type="text" placeholder="乐游聚乐服-S2" id="mcservername" />
									<p>如果您使用弹性云服务器搭建BungeeCord群组服务器的话，请尝试使用"XXX-S2"的格式标识出服务器</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：内存
	                    -->
						<div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/54511807.jpg" style="vertical-align: middle;" />服务器内存
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<#--<c:forEach items="${MCMEM}" var="vpsyp">-->
										<#--<c:if test="${vpsyp.sid == 1}">-->
											<#--<div class="create-mc-items-right-box-selected" id="${vpsyp.type}-${vpsyp.sid}" onclick="selectMCProduct(${fn:length(MCMEM)},'${vpsyp.type}',${vpsyp.sid});getcloudmcprice();">${vpsyp.value} Gb</div>-->
										<#--</c:if>-->
										<#--<c:if test="${vpsyp.sid != 1}">-->
											<#--<div class="create-mc-items-right-box" id="${vpsyp.type}-${vpsyp.sid}" onclick="selectMCProduct(${fn:length(MCMEM)},'${vpsyp.type}',${vpsyp.sid});getcloudmcprice();">${vpsyp.value} Gb</div>-->
										<#--</c:if>-->
									<#--</c:forEach>-->
									<p>小游戏服务器推荐您使用4G内存，RPG、生存、枪战服推荐您使用8G内存</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：玩家上线
	                    -->
	                    <div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/54511807.jpg" style="vertical-align: middle;" />玩家上限
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<#--<c:forEach items="${MCPLAYERS}" var="vpsyp">-->
										<#--<c:if test="${vpsyp.sid == 1}">-->
											<#--<div class="create-mc-items-right-box-selected" id="${vpsyp.type}-${vpsyp.sid}" onclick="selectMCProduct(${fn:length(MCPLAYERS)},'${vpsyp.type}',${vpsyp.sid});getcloudmcprice();">${vpsyp.value} 人</div>-->
										<#--</c:if>-->
										<#--<c:if test="${vpsyp.sid != 1}">-->
											<#--<div class="create-mc-items-right-box" id="${vpsyp.type}-${vpsyp.sid}" onclick="selectMCProduct(${fn:length(MCPLAYERS)},'${vpsyp.type}',${vpsyp.sid});getcloudmcprice();">${vpsyp.value} 人</div>-->
										<#--</c:if>-->
									<#--</c:forEach>-->
									<p>小游戏服务器推荐使用64人服务器</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：带宽
	                    -->
	                    <div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/54511807.jpg" style="vertical-align: middle;" />带宽
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<#--<c:forEach items="${MCTAPE}" var="vpsyp">-->
										<#--<c:if test="${vpsyp.sid == 1}">-->
											<#--<div class="create-mc-items-right-box-selected" id="${vpsyp.type}-${vpsyp.sid}" onclick="selectMCProduct(${fn:length(MCTAPE)},'${vpsyp.type}',${vpsyp.sid});getcloudmcprice();">${vpsyp.value} Mb</div>-->
										<#--</c:if>-->
										<#--<c:if test="${vpsyp.sid != 1}">-->
											<#--<div class="create-mc-items-right-box" id="${vpsyp.type}-${vpsyp.sid}" onclick="selectMCProduct(${fn:length(MCTAPE)},'${vpsyp.type}',${vpsyp.sid});getcloudmcprice();">${vpsyp.value} Mb</div>-->
										<#--</c:if>-->
									<#--</c:forEach>-->
									<p>啊手机等哈看稍等哈氪金深度杰卡斯道具卡和数据库的哈氪金深度哈技术肯定</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：应用核心
	                    -->
						<div class="create-cloud-items">
							<div class="create-cloud-items-left">
								<img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/54511807.jpg" style="vertical-align: middle;" />核心
							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<select id="choose-core-mc">
										<option id="choose-mc" value="0">请选择</option>
									</select>
									<select id="choose-kid-mc">
										<option>请选择</option>
									</select>
									<p>选择合适的Minecraft服务器核心</p>
								</div>
							</div>
						</div>
						<!--
	                    	作者：offline
	                    	时间：2017-07-09
	                    	描述：支付
	                    -->
	                    <div class="create-cloud-items" style="border: none;">
							<div class="create-cloud-items-left">

							</div>
							<div class="create-cloud-items-right">
								<div class="create-cloud-items-right-main-box">
									<span>配置费用：  </span><span id="cloudmcprice" style="color:#FFA042;font-size: 24px;">正在计算价格..</span><button type="button" style="cursor: pointer;padding: 0;margin-left: 200px;background:#FFA042;border: none; width: 140px; height: 40px; color: #fff;" id="justnowbuymc" onclick="checkmc()">立即购买</button>
								</div>
							</div>
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
	<script type="text/javascript" src="/ecs/js/create.js" ></script>
    <script type="text/javascript" src="/ecs/js/nav.js" ></script>
	<script src="/ecs/js/loginout.js"></script>
</html>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>服务器信息</title>
        <link href="css/bootstrap.min.css" title="" rel="stylesheet" />
        <link title="" href="css/style.css" rel="stylesheet" type="text/css"  />
        <link title="blue" href="css/dermadefault.css" rel="stylesheet" type="text/css"/>
        <link title="green" href="css/dermagreen.css" rel="stylesheet" type="text/css" disabled="disabled"/>
        <link title="orange" href="css/dermaorange.css" rel="stylesheet" type="text/css" disabled="disabled"/>
        <link href="css/templatecss.css" rel="stylesheet" title="" type="text/css" />
        <script src="js/jquery-3.2.1.min.js" type="text/javascript"></script>
        <script src="js/jquery.cookie.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
	</head>
	<body>
		<#include "/header.ftl">
		<div class="down-main">
		<#include "/lefter.ftl">
			<div class="right-product view-product right-full">
				<div class="container-fluid">
			<div class="info-center">
			<div class="row clearfix">
				<br/>
				<div class="col-md-8 column">
					<h4><span style="font-size:20px; color:blue;">|</span>综述</h4>
					<table class="table table-striped text-center">
						<tr>
							<td>实例<span style="font-size: 40px; color:blue ;">1</span></td>
							<td>运行中<span style="font-size: 40px; color:green ;">1</span></td>
							<td>已过期<span style="font-size: 40px; color:red ;">0</span></td>
							<td>即将过期<span style="font-size: 40px; color:red ;">0</span></td>
						</tr>
					</table>
					<h4><span style="font-size:20px; color:blue;">|</span>安全概览</h4>
					<table class="table table-striped text-center">
						<tr>
							<td><span class="glyphicon glyphicon-check" style="font-size:20px; color: green;"></span>云服务器:<span style="color: green;">正常</span></td>
							<td><span class="glyphicon glyphicon-ok-circle" style="font-size:20px; color: green;"></span>DDos防护</td>
							<td><span class="glyphicon glyphicon-ok-circle" style="font-size:20px; color: green;"></span>主机防护</td>
							<td><span class="glyphicon glyphicon-ok-circle" style="font-size:20px; color: green;"></span>应用防火墙</td>
							<td><span class="glyphicon glyphicon-ok-circle" style="font-size:20px; color: green;"></span>安全体检</td>
						</tr>
					</table>
					<div>
						<span style="font-size: 18px;"><span style="font-size:20px; color:blue;">|</span>我的资源</span>
						<input type="text" placeholder="请输入要搜索的内容" style="height: 32px; margin-left: 208px;">
						<button class="btn btn-primary">搜索</button>
						<button class="btn btn-primary">创建实例</button>
						<button class="btn btn-default"><span class="glyphicon glyphicon-refresh"><span></span></button>
						<button class="btn btn-default">显示全部地域</button>
					</div>
					<br/>
					<table class="table table-striped"  style="width:370px; height: 80px; float: left;">
						<tr>
							<td>
								华北2
							</td>
							<td colspan="3">
								<span class="glyphicon glyphicon-shopping-cart" style="font-size: 20px; "></span>
							</td>
						</tr>
						<tr colspan="3"  style="height: 180px;">
							<td>
								<p style="margin-top:60px;">云服务器<span style="font-size: 40px; color:blue;">   1</span>
								</p>
							</td>
							<td>
								<div style="margin-top: 30px;">
								<input type="radio" checked="checked" style="color:green;">运行中  <span style="color: green;">1</span><br/>
								<input type="radio" checked="checked" style="color:green;">近期创建  <span>0</span><br/>
								<input type="radio" checked="checked" style="color:green;">即将过期  <span style="color: red;">0</span><br/>
								<input type="radio" checked="checked" style="color:green;">已过期  <span style="color: red;">0</span><br/>
								</div>
							</td>
						</tr>
						<tr>
							<td>磁盘  1</td>
							<td>快照  0</td>
							<td>镜像  1</td>
						</tr>
					</table>
					<table class="table table-striped"  style="width:370px; height: 80px;float: right;">
						<tr>
							<td>
								华北2
							</td>
							<td colspan="3">
								<span class="glyphicon glyphicon-shopping-cart" style="font-size: 20px;float: right;"></span>
							</td>
						</tr>
						<tr colspan="3"  style="height:180px;">
							<td>
								<p style="margin-top:60px;">云服务器<span style="font-size: 40px; color:blue;">   1</span>
								</p>
							</td>
							<td>
								<div style="margin-top: 30px;">
								<input type="radio" checked="checked" style="color:green;">运行中  <span style="color: green;">1</span><br/>
								<input type="radio" checked="checked" style="color:green;">近期创建  <span>0</span><br/>
								<input type="radio" checked="checked" style="color:green;">即将过期  <span style="color: red;">0</span><br/>
								<input type="radio" checked="checked" style="color:green;">已过期  <span style="color: red;">0</span><br/>
								</div>
							</td>
						</tr>
						<tr>
							<td>磁盘  1</td>
							<td>快照  0</td>
							<td>镜像  1</td>
						</tr>
					</table>
					
				</div>
				<div class="col-md-4 column" style="border-left:groove;">
					<h4><span style="font-size:20px; color:blue;">|</span>常用操作</h4>
					<div style="width: 440px;">
						 <button type="button" style="width:210px;" class="btn btn-default">续费管理</button>
						 <button type="button" style="width:210px;" class="btn btn-default">设置</button><p></p>
						 <button type="button" style="width:210px;" class="btn btn-default">待处理事件</button>
						 <button type="button" style="width:210px;" class="btn btn-default">查看特权<span class="badge">3</span></button>
					 </div>
					 <br/>
					 <h4><span style="font-size:20px; color:blue;">|</span>重要提醒</h4>
					 <div class="alert alert-success alert-dismissable" style="width: 440px;">
						<button type="button" class="close" data-dismiss="alert" aria-hidden="true">
						<span class="glyphicon glyphicon-remove"></span>
						</button>
						<span class="glyphicon glyphicon-question-sign"></span>
						<span style="font-size: 13px;">ECS发布企业级产品家族19款实例族,性能倍数提升!<a href="#">了解更多<a></a></span>
					</div>
					<h4><span style="font-size:20px; color:blue;">|</span>近期重要功能</h4>
					<table class="table table-striped" style="width: 440px;">
						<tr>
							<td>
								<span style="font-size:10px;">2017</span>
								<ul>
									<li style="list-style:disc; font-size: 12px;"><span class="glyphicon glyphicon-paperclip">按周售卖重磅发布,9折优惠！</span>
									<span style="float: right;" class="badge">hot</span></li>
									<li style="font-size: 10px;">2017/07</li>
								</ul>
								<ul>
									<li style="list-style:disc; font-size: 12px;"><span class="glyphicon glyphicon-paperclip">ECS发布企业级产品家族19款实例族,性能倍数提升!</span>
									<span style="float: right;" class="badge">hot</span></li>
									<li style="font-size: 10px;">2017/06</li>
								</ul>
								<ul>
									<li style="list-style:disc; font-size: 12px;"><span class="glyphicon glyphicon-paperclip">按量实例批量更改网络带宽</span>
									<span style="float: right;" class="badge">hot</span></li>
									<li style="font-size: 10px;">2017/06</li>
								</ul>
								<ul>
									<li style="list-style:disc; font-size: 12px;"><span class="glyphicon glyphicon-paperclip">按量付费转包年包月云盘</span>
									<span style="float: right;" class="badge">hot</span></li>
									<li style="font-size: 10px;">2017/05</li>
								</ul>
								<ul>
									<li style="list-style:disc; font-size: 12px;"><span class="glyphicon glyphicon-paperclip">安全组规则批量添加授权对象</span>
									<span style="float: right;" class="badge">hot</span></li>
									<li style="font-size: 10px;">2017/04</li>
								</ul>
								<ul>
									<li style="list-style:disc; font-size: 12px;"><span class="glyphicon glyphicon-paperclip">ECS-buy 镜像选择页功能更新</span>
									<span style="float: right;" class="badge">hot</span></li>
									<li style="font-size: 10px;">2017/04</li>
								</ul>
								<ul>
									<li style="list-style:disc; font-size: 12px;"><span class="glyphicon glyphicon-paperclip">从入门型到企业型升级实例发布</span>
									<span style="float: right;" class="badge">hot</span></li>
									<li style="font-size: 10px;">2017/04</li>
								</ul>
								<ul>
									<li style="list-style:disc; font-size: 12px;"><span class="glyphicon glyphicon-paperclip">购买历史快速创建资源</span>
									<span style="float: right;" class="badge">hot</span></li>
									<li style="font-size: 10px;">2017/04</li>
								</ul>
							</td>
						</tr>	
					</table>
				</div>
			</div>
		</div>
		</div>
		</div>
		</div>
	</body>
</html>

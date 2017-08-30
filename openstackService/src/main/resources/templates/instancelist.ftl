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
						<div class="row clearfix ">
							<div  style="border-bottom:groove;">
								<h4>
									<span style="font-size:20px; color:blue;">|</span>
									快照列表
									<button class="btn btn-default" style="font-size:10px;">华北1</button>
									<button class="btn btn-default" style="font-size:10px;">华北2</button>
									<button class="btn btn-default" style="font-size:10px;">华北3</button>
									<button class="btn btn-default" style="font-size:10px;">华东1</button>
									<button class="btn btn-default" style="font-size:10px;">华东2</button>
									<button class="btn btn-default" style="font-size:10px;">华南1</button>
									<button class="btn btn-default" style="font-size:10px;">香港</button>
									<button class="btn btn-default" style="font-size:10px;">亚太东北(东京)</button>
									<button class="btn btn-default" style="font-size:10px;">亚太东南(新加坡)</button>
									<button class="btn btn-default" style="font-size:10px;">亚太东南(悉尼)</button>
									<button class="btn btn-default" style="font-size:10px;">美国东部1(弗吉尼亚)</button>
									<button class="btn btn-default" style="font-size:10px;">美国西部1(硅谷)</button>
									<button class="btn btn-info" style="font-size:10px; float: right;">购买预付费存储包</button>
									<button class="btn btn-default" style="float: right; font-size:10px;">
										<span class="glyphicon glyphicon-refresh"></span></button>
								</h4>
								<button class="btn btn-default" style="margin-left:90px; font-size:10px;">中东东部1(迪拜)</button>
								<button class="btn btn-default" style="font-size:10px;">欧洲中部1(法兰福克)</button>
								<p></p>
							</div>
							<p></p>
							<table class="table table-striped table-bordered" style="color: green; font-size: 12px;">
									<tr>
										<td>
											<ul style="list-style: disc;">
												<li>快照产业已于2017年3月28日正式商业化,7月3日起正式开始收费,此次快照服务商业化范围仅包括阿里云官网国内站的客户。其他国际站，日本站等使用ECS云服务器的客户，商业化时间将另行通知，其正在使用的快照服务不受影响;</li>
												<li>在2017年3月7日正式商业化收费之前，您可以选择删除所有快照和自动快照策略，以避免商业化收费后产生相关快照费用;</li>
												<li>您如果已经设置了自动快照策略或曾经创建过手动快照，正式商业化之后，已生成的快照会按照收费标准进行收费，收费模式请见官网块存储价格页面。</li>
											</ul>
										</td>
									</tr>
							</table>
								<button style="width: 105px;" type="button" class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">快照名称
									<span class="caret"></span>
								</button>
								<ul style="margin-left: 15px;" class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
									<li role="presentation">
										<a role="menuitem" tabindex="-1" href="#">快照名称1</a>
									</li>
									<li role="presentation">
										<a role="menuitem" tabindex="-1" href="#">快照名称2</a>
									</li>
									<li role="presentation">
										<a role="menuitem" tabindex="-1" href="#">快照名称3</a>
									</li>
								</ul>
								<input type="text" placeholder="输入快照名称模糊查询" style="width:200px; height: 31px;">
								<button class="btn btn-primary" style="width: 70px;">搜索</button>
								<button class="btn btn-default" style="width: 70px;"><span class="glyphicon glyphicon-tags"></span> 标签</button>
								<span  style="float: right;">
									<button class="btn btn-default"><span class="glyphicon glyphicon-export"></span></button>
									<button class="btn btn-default"><span class="glyphicon glyphicon-cog"></span></button>
									<button class="btn btn-default"><span class="glyphicon glyphicon-question-sign"></span></button>
								</span>
								<p></p>
								<table class="table table-striped table-bordered text-center">
									<tr>
										<td><input type="checkbox">&nbsp;快照ID/名称</td>
										<td>磁盘ID</td>
										<td>磁盘容量</td>
										<td>磁盘属性(全部)</td>
										<td>创建时间</td>
										<td>进度</td>
										<td>状态</td>
										<td>操作</td>
									</tr>
									<tr>
										<td>
											快照一
										</td>
										<td>
											<!--<p style="text-align: center; margin-top: 110px;"><span class="glyphicon glyphicon-question-sign"></span>没有查询到符合条件的记录</p>-->
											1
										</td>
										<td>
											100
										</td>
										<td>
											1TB
										</td>
										<td>
											2017年6月23日 13:23
										</td>
										<td>
											50%
										</td>
										<td>
											使用中
										</td>
										<td>
											<a>修改</a>
										</td>
									</tr>
								</table>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</body>
</html>
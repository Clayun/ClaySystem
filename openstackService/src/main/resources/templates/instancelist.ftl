<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>服务器信息</title>
        <link href="/ecs/css/bootstrap.min.css" title="" rel="stylesheet" />
        <link title="" href="/ecs/css/style.css" rel="stylesheet" type="text/css"  />
        <link title="blue" href="/ecs/css/dermadefault.css" rel="stylesheet" type="text/css"/>
        <link title="green" href="/ecs/css/dermagreen.css" rel="stylesheet" type="text/css" disabled="disabled"/>
        <link title="orange" href="/ecs/css/dermaorange.css" rel="stylesheet" type="text/css" disabled="disabled"/>
        <link href="/ecs/css/templatecss.css" rel="stylesheet" title="" type="text/css" />
        <script src="/ecs/script/jquery-1.11.1.min.js type="text/javascript"></script>
        <script src="/ecs/script/jquery.cookie.js" type="text/javascript"></script>
        <script src="/ecs/script/bootstrap.min.js" type="text/javascript"></script>
	</head>
	<body>
		<#include "/header.ftl">
		<div class="down-main">
			<#include "/lefter.ftl">
			<div class="right-product view-product right-full">
				<div class="container-fluid">
					<div class="info-center">
						<div class="row clearfix ">
							<div class="col-md-12 column">
							<div  style="border-bottom:groove;">
								<h4>
									<span style="font-size:20px; color:blue;">|</span>
									实例列表
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
									<button class="btn btn-info" style="font-size:10px; float: right;" onclick="create()">创建新的实例</button>
									<button onclick="reload()" class="btn btn-default" style="float: right; font-size:10px;">
										<span class="glyphicon glyphicon-refresh"></span>
									</button>
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
												<li>实例产业已于2017年3月28日正式商业化,7月3日起正式开始收费,此次实例服务商业化范围仅包括阿里云官网国内站的客户。其他国际站，日本站等使用ECS云服务器的客户，商业化时间将另行通知，其正在使用的实例服务不受影响;</li>
												<li>在2017年3月7日正式商业化收费之前，您可以选择删除所有实例和自动实例策略，以避免商业化收费后产生相关实例费用;</li>
												<li>您如果已经设置了自动实例策略或曾经创建过手动实例，正式商业化之后，已生成的实例会按照收费标准进行收费，收费模式请见官网块存储价格页面。</li>
											</ul>
										</td>
									</tr>
							</table>
								<button style="width: 105px;" type="button" class="btn btn-default dropdown-toggle" id="dropdownMenu1" data-toggle="dropdown">实例名称
									<span class="caret"></span>
								</button>
								<ul style="margin-left: 15px;" class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
									<li role="presentation">
										<a role="menuitem" tabindex="-1" href="#">实例名称1</a>
									</li>
									<li role="presentation">
										<a role="menuitem" tabindex="-1" href="#">实例名称2</a>
									</li>
									<li role="presentation">
										<a role="menuitem" tabindex="-1" href="#">实例名称3</a>
									</li>
								</ul>
								<input type="text" placeholder="输入实例名称模糊查询" style="width:200px; height: 31px;">
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
										<td><input type="checkbox">&nbsp;实例ID/名称</td>
										<td>实例CPU核心</td>
										<td>实例内存</td>
										<td>系统盘</td>
										<td>带宽</td>
										<td>镜像</td>
                                        <td>剩余天数</td>
                                        <td>月/费用</td>
										<td>操作</td>
									</tr>
										<#list list as l>
                                            <tr>
												<td>${l.ser_uuid?if_exists}</td>
												<td>${l.cpu?if_exists}个</td>
												<td>${l.memory?if_exists}Gb</td>
												<td>${l.os_disk?if_exists}Gb</td>
												<td>${l.tape?if_exists}Mb</td>
												<td>${l.image?if_exists}</td>
												<td>${l.days?if_exists}天</td>
												<td>${l.pricePerMonth?if_exists}元/月</td>
												<td><a href="instance?ser_uuid=${l.ser_name?if_exists}">详情</a></td>
											</tr>
										</#list>
								</table>
                            </div>
						</div>
					</div>
				</div>
			</div>
		</div>	
	</body>
<script>
	function reload(){
	    location.reload();
	}
	function create(){
	    location.href="create";
	}
</script>
</html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>实名认证</title>
    <link href="/ecs/bootstrap-3.3.5-dist/css/bootstrap.min.css" title="" rel="stylesheet" />
    <link title="" href="/ecs/css/style.css" rel="stylesheet" type="text/css"  />
    <link title="blue" href="/ecs/css/dermadefault.css" rel="stylesheet" type="text/css"/>
    <link title="green" href="/ecs/css/dermagreen.css" rel="stylesheet" type="text/css" disabled="disabled"/>
    <link title="orange" href="/ecs/css/dermaorange.css" rel="stylesheet" type="text/css" disabled="disabled"/>
    <link href="/ecs/css/templatecss.css" rel="stylesheet" title="" type="text/css" />
    <script src="/ecs/script/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="/ecs/script/jquery.cookie.js" type="text/javascript"></script>
    <script src="/ecs/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
<#include "/header.ftl">
<div class="down-main">
<#include "/lefter.ftl">
  <div class="right-product view-product right-full">
     <div class="container-fluid">
				<div class="info-center">
					<div class="page-header">
                                      <div class="pull-left">
						<h4>实名认证</h4>      
					</div>
                                   </div>
					<div class="indentify-class padding-lr">
						<p class="margin-big-tb text-sub text-default">
							请选择认证类型，个人认证后续可升级为企业认证，企业认证一旦认证成功，无法变更为个人认证
						</p>
						<ul class="class-content">
							<li class="pull-left margin-large-35">
							<a class="class-detail pull-right " href="#">
							<div class="class-detail-top">
								<div class="text-center indentify-icon">
									<img src="/ecs/img/identify_personal.png">
								</div>
								<h3 class="text-center">个人认证</h3>
								<p class="margin-tb padding-bottom text-justify info">
									用于个人或个体经营户认证，认证通过可获得短信模板自定义及认证用户特权
								</p>
								<ul class="class-detail-has margin-top text-lh-big">
									<li>
									<span class="text-black-gray">自定义短信条数</span>
									<span class="pull-right text-gray-white">5条</span>
									</li>
									<li>
									<span class="text-black-gray">云市场认证优惠</span>
									<span class="pull-right text-gray-white">有</span>
									</li>
									<li>
									<span class="text-black-gray">个人认证勋章</span>
									<span class="pull-right text-gray-white">有</span>
									</li>
								</ul>
							</div>
							<p class="continue text-big">
								选择并继续使用
							</p>
							</a>
							</li>
							<li class="pull-left margin-large-35">
							<a class="class-detail pull-right " href="#">
							<div class="class-detail-top">
								<div class="text-center indentify-icon">
									<img src="/ecs/img/identify_enterprise.png">
								</div>
								<h3 class="text-center">企业认证</h3>
								<p class="margin-tb padding-bottom text-justify info">
									用于企事业单位认证，认证通过可获得短信模板自定义及认证用户特权
								</p>
								<ul class="class-detail-has margin-top text-lh-big">
									<li>
									<span class="text-black-gray">自定义短信条数</span>
									<span class="pull-right text-gray-white">10条</span>
									</li>
									<li>
									<span class="text-black-gray">云市场认证优惠</span>
									<span class="pull-right text-gray-white">有</span>
									</li>
									<li>
									<span class="text-black-gray">企业认证勋章</span>
									<span class="pull-right text-gray-white">有</span>
									</li>
									<li>
									<span class="text-black-gray">免费400电话(含800元话费)</span>
									<span class="pull-right text-gray-white">有</span>
									</li>
								</ul>
							</div>
							<p class="continue text-big">
								选择并继续使用
							</p>
							</a>
							</li>
							<li class="pull-left">
							<a class="class-detail pull-right disabled" href="#">
							<div class="class-detail-top">
								<div class="text-center indentify-icon">
									<img src="/ecs/img/identify_developer.png">
								</div>
								<h3 class="text-center">服务商认证</h3>
								<p class="margin-tb padding-bottom text-justify info">
									服务商认证需先通过个人或企业认证，认证服务商可以入驻云市场，通过某某云市场销售获得报酬
								</p>
								<ul class="class-detail-has margin-top text-lh-big">
									<li>
									<span class="text-black-gray">服务商认证勋章</span>
									<span class="pull-right text-gray-white">有</span>
									</li>
									<li>
									<span class="text-black-gray">云市场插件销售</span>
									<span class="pull-right text-gray-white">有</span>
									</li>
									<li>
									<span class="text-black-gray">云市场模板销售</span>
									<span class="pull-right text-gray-white">有</span>
									</li>
									<li>
									<span class="text-black-gray">云市场模块销售</span>
									<span class="pull-right text-gray-white">有</span>
									</li>
								</ul>
							</div>
							<p class="continue text-big">
								即将推出
							</p>
							</a>
							</li>
						</ul>
					</div>
				</div>            
		</div>
  </div>
</div>
<script type="text/javascript">
$(function(){
/*换肤*/
$(".dropdown .changecolor li").click(function(){
	var style = $(this).attr("id");
    $("link[title!='']").attr("disabled","disabled"); 
	$("link[title='"+style+"']").removeAttr("disabled"); 

	$.cookie('mystyle', style, { expires: 7 }); // 存储一个带7天期限的 cookie 
})
var cookie_style = $.cookie("mystyle"); 
if(cookie_style!=null){ 
    $("link[title!='']").attr("disabled","disabled"); 
	$("link[title='"+cookie_style+"']").removeAttr("disabled"); 
} 
/*左侧导航栏显示隐藏功能*/
$(".subNav").click(function(){				
			/*显示*/
			if($(this).find("span:first-child").attr('class')=="title-icon glyphicon glyphicon-chevron-down")
			{
				$(this).find("span:first-child").removeClass("glyphicon-chevron-down");
			    $(this).find("span:first-child").addClass("glyphicon-chevron-up");
			    $(this).removeClass("sublist-down");
				$(this).addClass("sublist-up");
			}
			/*隐藏*/
			else
			{
				$(this).find("span:first-child").removeClass("glyphicon-chevron-up");
				$(this).find("span:first-child").addClass("glyphicon-chevron-down");
				$(this).removeClass("sublist-up");
				$(this).addClass("sublist-down");
			}	
		// 修改数字控制速度， slideUp(500)控制卷起速度
	    $(this).next(".navContent").slideToggle(300).siblings(".navContent").slideUp(300);
	})
/*左侧导航栏缩进功能*/
$(".left-main .sidebar-fold").click(function(){

	if($(this).parent().attr('class')=="left-main left-full")
	{
		$(this).parent().removeClass("left-full");
		$(this).parent().addClass("left-off");
		
		$(this).parent().parent().find(".right-product").removeClass("right-full");
		$(this).parent().parent().find(".right-product").addClass("right-off");
		
		
		}
	else
	{
		$(this).parent().removeClass("left-off");
		$(this).parent().addClass("left-full");
		
		$(this).parent().parent().find(".right-product").removeClass("right-off");
		$(this).parent().parent().find(".right-product").addClass("right-full");
		
		
		}
	})	
 
  /*左侧鼠标移入提示功能*/
		$(".sBox ul li").mouseenter(function(){
			if($(this).find("span:last-child").css("display")=="none")
			{$(this).find("div").show();}
			}).mouseleave(function(){$(this).find("div").hide();})	
})
</script>
</body>
</html>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>短信</title>
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
				<div class="message-manage info-center">
					<div class="page-header">
                      <div class="pull-left">
						<h4>短信</h4>      
					</div>
                                     </div>
					<div class="manage-detail">
						<h6 class="h5">某某的短信平台只需站点后台绑定账号并开启即可使用，多个站点均可通用短信余额</h6>
						<div class="margin-tb manage-detail-con clearfix">
							<span class="h5 pull-left">短信剩余：<em class="h2">0 </em>条</span>
							<a class="h5 recharge pull-left" href="#">充值</a>
							<a class="h5 margin-large-left custom pull-left" href="#">自定义短信</a>
						</div>
					</div>
					<div class="manage-record">
						<h6 class="margin-big-top">
                        <span class="pull-left manage-title border-bottom-main">发送记录</span>
						<span class="pull-right record-fond">
						<div class="select-table pull-right">
							<div>
								<input readonly="readonly" value="全部站点" type="text">
							</div>
						</div>
						<span class="pull-right margin-small-top">按站点查找：</span>
						</span>
						
						</h6>
						<div class="clearfix"></div>
                        <div class="table-margin">
                          <table class="table table-bordered table-header">
                          <thead>
                             <tr>
                               <td class="w60">发送内容</td>
                               <td class="w10">发送时间</td>
                               <td class="w10">使用站点</td>
                               <td class="w10">条数</td>
                               <td class="w10">状态</td>
                             </tr>
                             </thead>
                             <tbody>
                             <tr>
                              <td>2</td>
                              <td>2</td>
                              <td>2</td>
                              <td>2</td>
                              <td>2</td>
                             </tr>
                             <tr>
                              <td>2</td>
                              <td>2</td>
                              <td>2</td>
                              <td>2</td>
                              <td>2</td>
                             </tr>
                             </tbody>
                          </table>
                        </div>
                    
					</div>
				</div>
				<div class="clearfix"></div>
				<div class="show-page padding-big-right hidden">
					<div class="page">
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

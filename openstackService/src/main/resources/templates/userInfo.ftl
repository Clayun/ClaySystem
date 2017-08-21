<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>用户中心</title>
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
				<div class="manage account-manage info-center">
					<div class="page-header">
                                           <div class="pull-left">
						<h4>用户中心</h4>      
					</div>
                                        </div>
					<dl class="account-basic clearfix">
						<dt class="pull-left">
						<p class="account-head">
							<img src="/ecs/img/noavatar_middle.gif">
						</p>
						</dt>
						<dd class="pull-left margin-large-left margin-small-top">
						<p class="text-small">
							<span class="show pull-left base-name">会员账号</span>:<span class="margin-left">小朱 </span>
						</p>
						<p class="text-small">
							<span class="show pull-left base-name">认证状态</span>:
							<span class="margin-left">已认证</span>
							<!-- <a class="margin-left text-main text-underline" href="#">立即认证</a> -->
						</p>
						<p class="text-small">
							<span class="show pull-left base-name">注册时间</span>:<span class="margin-left">2015-01-12 11:50:22</span>
						</p>
						</dd>
					</dl>
					<div class="account-basic clearfix">
						<span class="pull-left show text-small">您当前的账号安全程度</span>
						<div class="progress-bar pull-left margin-large-left margin-large-35">
							<div style="background: rgb(255, 153, 0) none repeat scroll 0% 0%; width: 180px;" data-width="100">
							</div>
						</div>
						<span class="pull-left show text-small">安全级别: <span style="color: rgb(255, 153, 0);" class="leval-safe">高</span></span>
					</div>
					<ul class="accound-bund">
						<li class="clearfix">
						<span class="bund-class">登录密码</span>
						<span class="w45">安全性高的密码可以使账号更安全，建议您定期更换密码，设置一个包含字母，符号或数字中至少两项且长度超过6位的密码。</span>
						<span class="pull-right margin-large-right">
						<i class="glyphicon glyphicon-ok-circle pull-left"></i>
						<em class="margin-right text-green-deep">已设置</em>
						            		|
						<a href="#" data-panel="modify_pass" data-title="修改密码-修改密码" data-callback="$(&quot;#modify_pass&quot;).submit();" data-btn="下一步,取消" class="button-word1 margin-left btn_ajax_open">修改</a>
						<input data-panel="modify_pass2" data-title="修改密码-修改完成" data-btn="完成" data-callback="layer.closeAll();" class="modify_pass_setup2 btn_ajax_open" value="第三步" type="hidden">
						</span>
						</li>
						
						<li class="clearfix">
						<span class="bund-class">邮箱绑定</span>
						<span class="w45">绑定邮箱可以用于安全验证、找回密码等重要操作</span>
						<span class="pull-right margin-large-right">
						<i class="glyphicon glyphicon-ok-circle pull-left"></i>
						<em class="margin-right text-green-deep">已设置</em>
						            					            		|
						<a href="#" data-panel="modify-email-revise" data-title="修改绑定邮箱-邮箱验证" data-btn="发送验证到邮箱,取消" data-callback="$(&quot;#modify_email&quot;).submit();" class="button-word1 margin-left btn_ajax_open">修改</a>
						<input data-panel="modify-email-revise2" data-title="修改绑定邮箱-修改成功" data-btn="完成" data-callback="layer.closeAll();" class="modif_email_setup2 btn_ajax_open" type="hidden">
						</span>
						</li>
					
						<li class="clearfix border-bottom-none">
						<span class="bund-class">邀请链接</span>
						<span class="w45" id="fe_text">http://www.mycodes.net</span>
						<span class="pull-right margin-large-right">
						<a class="button-word1 margin-left" id="copy_button" data-clipboard-target="fe_text" href="#">复制链接</a>
						</span>
						</li>
					</ul>
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

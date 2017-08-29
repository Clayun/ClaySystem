<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
<title>消息中心</title>
    <link href="/ecs/bootstrap-3.3.5-dist/css/bootstrap.min.css" title="" rel="stylesheet" />
    <link title="" href="/ecs/css/style.css" rel="stylesheet" type="text/css"  />
    <link title="blue" href="/ecs/css/dermadefault.css" rel="stylesheet" type="text/css"/>
    <link title="green" href="/ecs/css/dermagreen.css" rel="stylesheet" type="text/css" disabled="disabled"/>
    <link title="orange" href="/ecs/css/dermaorange.css" rel="stylesheet" type="text/css" disabled="disabled"/>
    <link href="/ecs/css/templatecss.css" rel="stylesheet" title="" type="text/css" />
    <script src="/ecs/script/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="/ecs/script/jquery.cookie.js" type="text/javascript"></script>
    <script src="/ecs/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>

<!--angular ui--->
<link rel="stylesheet" title="" type="text/css" href="ui-layout-0.0.0/ui-layout.css"/>
<script src="script/angular.min.js"></script>
<script src="ui-layout-0.0.0/ui-layout.js"></script>
</head>
<body>
<#include "/header.ftl">
<div class="down-main">
<#include "/lefter.ftl">
  <div class="right-product right-off">
  <section id="layout" ng-app="doc.ui-layout">
    <div ui-layout class="layout-mock"> 
      <ui-layout options="{ flow : 'column' }">
        <!---leftlist--->
        <sidebar class="east-back left-back">
          <ul class="nav nav-pills nav-stacked">
              <li class="active"><a href="#">新闻栏目一</a></li>
              <li><a href="#">新闻栏目二</a></li>
              <li><a href="#">新闻栏目三</a></li>
          </ul>
        </sidebar>
        <!---rightcontent---->    
        <div class="center-back right-back">
        <div class="container-fluid">
          <div class="info-center">
                    <div class="page-header">
                      <div class="pull-left">
						<h4>新闻中心</h4>      
					</div>
                    <div class="pull-right">
                        <button type="button" class="btn btn-mystyle btn-sm">搜索</button>
                         <button type="button" class="btn btn-mystyle btn-sm">返回</button>
                    </div>
                    </div>
				    <div class="search-box row">
                       <div class="col-md-8">
                        <div class="form-group">
                          <span class="pull-left form-span">电子邮件:</span>
                           <input type="email" class="form-control" placeholder="请输入您的电子邮件">
                           </div>
                            <div class="form-group">
                              <input type="email" class="form-control" placeholder="请输件"> 
                           </div>
                           <div class="form-group">
                              <span class="pull-left form-span">状态:</span>
                              <select class="form-control">
                                <option>1</option>
                                <option>2</option>
                                <option>3</option>
                                <option>4</option>
                              </select>
                           </div>
                        <div class="form-group">
                          <input type="email" class="form-control" placeholder="请输件">                    
                       </div>
                       
                       
                       <div class="form-group btn-search">
                            <button class="btn btn-default" ><span class="glyphicon glyphicon-search"></span> 搜索</button>
                        </div>
                        </div>
                        <div class="col-md-4">
                         <div class="btn-group pull-right" role="group" aria-label="...">
                          <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-plus"></span> 新增</button>
                           <div class="btn-group" role="group">
                            <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                              <span class="glyphicon glyphicon-edit"></span> 审核
                              <span class="caret"></span>
                            </button>
                            <ul class="dropdown-menu">
                              <li><a href="#">通过</a></li>
                              <li><a href="#">不通过</a></li>
                            </ul>
                          </div>
                          <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span> 编辑</button>
                         <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span> 删除</button>
                        </div>
                        </div>
                        
                    </div>
                    <div class="clearfix"></div>
                      <div class="table-margin">
                      <table class="table table-bordered table-header">
                      <thead>
                         <tr>
                           <td><input type="checkbox" /></td>
                           <td class="w70">标题内容</td>
                           <td class="w15">提交时间</td>
                           <td class="w15">类型</td>
                         </tr>
                         </thead>
                         <tbody>
                         <tr>
                          <td><input type="checkbox" /></td>
                          <td>2</td>
                          <td>2</td>
                          <td>2</td>
                         </tr>
                         <tr>
                          <td><input type="checkbox" /></td>
                          <td>2</td>
                          <td>2</td>
                          <td>2</td>
                         </tr>
                         </tbody>
                         <tfoot>
                          <tr>
                            <td colspan="4">
                              <div class="pull-right">
                                  <nav>
                                      <ul class="pagination">
                                        <li>
                                          <a href="#" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                          </a>
                                        </li>
                                        <li><a href="#">1</a></li>
                                        <li><a href="#">2</a></li>
                                        <li><a href="#">3</a></li>
                                        <li><a href="#">4</a></li>
                                        <li><a href="#">5</a></li>
                                        <li>
                                          <a href="#" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                          </a>
                                        </li>
                                      </ul>
                                    </nav>
                              </div>
                            </td>
                          </tr>
                         </tfoot>
                      </table>
                    </div>
                    </div>
          </div>
        </div>
      </ui-layout>
   </div>
  </section>   
 </div>
</div>


<script type="text/javascript">
/*Angular-UI-layout*/
angular.module('doc.ui-layout', ['ui.layout']);

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

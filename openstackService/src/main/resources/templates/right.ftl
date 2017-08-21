<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>服务器信息</title>
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
					<h3>**EnterPrise</h3>
					<div class="row clearfix">
					<div class="col-md-6 column">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span class="panel-title">
									基本信息
									<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" style="float: right;">
										更多<span class="caret"></span>
									</button>
									<button class="btn btn-default btn-sm" style="float: right;">远程连接</button>
								</span>
								
							</div>
							<div class="panel-body">
								ID:##############<br/><br/>
								所在可用区:##############<br/><br/>
								名称:####<br/><br/>
								描述:#####<br/><br/>
								地域:#####<br/><br/>
								实例规格:#####<br/><br/>
								实力规格族:#####<br/><br/>
								镜像ID:#####<br/><br/>
								密钥对名称:#####<br/><br/>
								标签:#####
							</div>
						</div>
					</div>
					
					<div class="col-md-6 column">
						<div class="panel panel-default">
							<div class="panel-heading">
								磁盘:#&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								状态:<input type="radio" >运行中<br/><br/>
								快照:#&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								网络类型:###<br/><br/>
								镜像:#<br/><br/>
							</div>
						</div>
					</div>
				</div>
				
				<div class="row clearfix">
					<div class="col-md-6 column">
						<div class="panel panel-default">
							<div class="panel-heading">
								<span class="panel-title">
									配置信息
									<button class="btn btn-default btn-sm dropdown-toggle" data-toggle="dropdown" style="float: right;">
										更多<span class="caret"></span>
									</button>
									<button disabled="disabled" class="btn btn-default btn-sm" style="float: right;">更换系统盘</button>
								</span>
							</div>
							<div class="panel-body">
								CPU:##<br/><br/>
								内存:##<br/><br/>
								实例类型:##<br/><br/>
								操作系统:##<br/><br/>
								公网IP：##<br/><br/>
								弹性公网IP：##<br/><br/>
								私有IP：##<br/><br/>
								宽带计费方式：##<br/><br/>
								当前使用宽带：##<br/><br/>
							</div>
						</div>
					</div>
					<div class="col-md-6 column">
						<div class="panel panel-default">
							<div class="panel-heading">
								<h3 class="panel-title">
									Panel title
								</h3>
							</div>
							<div class="panel-body">
								Panel content
							</div>
							<div class="panel-footer">
								Panel footer
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
			</div>
		<div>
	</body>
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
</html>

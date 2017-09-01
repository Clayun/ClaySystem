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
					<div class="row clearfix">
					<div class="col-md-12 column">
                            <iframe border=0 frameborder=0 width=725 height=450 marginheight=0 marginwidth=0 scrolling=no src="${url}">
                            </iframe>
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

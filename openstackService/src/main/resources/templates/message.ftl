<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
        "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1,maximum-scale=1, user-scalable=no">
    <title>消息中心</title>
    <link href="/ecs/bootstrap-3.3.5-dist/css/bootstrap.min.css" title="" rel="stylesheet"/>
    <link title="" href="/ecs/css/style.css" rel="stylesheet" type="text/css"/>
    <link title="blue" href="/ecs/css/dermadefault.css" rel="stylesheet" type="text/css"/>
    <link title="green" href="/ecs/css/dermagreen.css" rel="stylesheet" type="text/css" disabled="disabled"/>
    <link title="orange" href="/ecs/css/dermaorange.css" rel="stylesheet" type="text/css" disabled="disabled"/>
    <link href="/ecs/css/templatecss.css" rel="stylesheet" title="" type="text/css"/>
    <script src="/ecs/script/jquery-1.11.1.min.js" type="text/javascript"></script>
    <script src="/ecs/script/jquery.cookie.js" type="text/javascript"></script>
    <script src="/ecs/bootstrap-3.3.5-dist/js/bootstrap.min.js" type="text/javascript"></script>
</head>

<body>
<#include "/header.ftl">
<div class="down-main">
<#include "/lefter.ftl">
    <div class="right-product right-full">
        <div class="container-fluid">
            <div class="info-center">
                <div class="page-header">
                    <div class="pull-left">
                        <h4>消息中心</h4>
                    </div>
                    <div class="pull-right">
                        <a href="#">全部已读</a>
                        <a href="#">全部删除</a>
                    </div>
                </div>
                <div class="info-center-title">
					    <span class="padding-large-right manage-title pull-left">
                           <a class="active" href="/ecs/messageInterface">全部消息</a>
                        </span>
                    <span class="padding-large-right pull-left"><a  href="/ecs/readMessage" ">已读消息</a></span>
                    <span class="pull-left"><a  href="/ecs/noReadMessage">未读消息</a></span>
                </div>
                <div class="clearfix"></div>
                <div class="table-margin">
                    <table class="table table-bordered table-header">
                        <thead>
                        <tr>
                            <td><input type="checkbox"  onclick="allSelect()" id="se"></td>
                            <td class="w70">标题内容</td>
                            <td class="w15">提交时间</td>
                            <td class="w15">类型</td>
                        </tr>
                        </thead>
                        <tbody>
						<#list messagesInfoList as msg>
                        <tr>
                            <td><input type="checkbox" value="${msg.recivierUuid}" name="ids"></td>
                            <td>${msg.message}</td>
                            <td>${msg.createTime?string("yyyy年MM月dd天HH时mm分ss秒")}</td>
                            <td>
							${msg.readed}
                            </td>
                        </tr>
						</#list>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="show-page hidden">
                <ul>
                </ul>
            </div>
        </div>
    </div>
</div>


<script type="text/javascript">
   /* function readMessage(){
        $.ajax(function(){
            url:"/ecs/readMessage",
                    data:'',
                    dataType:'json',
        })
    }*/
    function allSelect() {
       // alert()
        //$("input[name='ids']").attr('checked',true)
        $("input[name='ids']").attr('checked',!$("input[name='ids']").attr('checked'))
       // $("#sel").click(function(){//全选/全不选
            /*var $aa=$(":checkbox[name='ids']");
            if($("#se").attr("checked")){
                for(i=0;i<$aa.length;i++){
                    $aa[i].checked=true;
                }
            }else{
                for(i=0;i<$aa.length;i++){
                    $aa[i].checked=false;
                }
            }*/
       // })
    }
    /********************   *********************/
    $(function () {
        /*换肤*/
        $(".dropdown .changecolor li").click(function () {
            var style = $(this).attr("id");
            $("link[title!='']").attr("disabled", "disabled");
            $("link[title='" + style + "']").removeAttr("disabled");

            $.cookie('mystyle', style, {expires: 7}); // 存储一个带7天期限的 cookie
        })
        var cookie_style = $.cookie("mystyle");
        if (cookie_style != null) {
            $("link[title!='']").attr("disabled", "disabled");
            $("link[title='" + cookie_style + "']").removeAttr("disabled");
        }
        /*左侧导航栏显示隐藏功能*/
        $(".subNav").click(function () {
            /*显示*/
            if ($(this).find("span:first-child").attr('class') == "title-icon glyphicon glyphicon-chevron-down") {
                $(this).find("span:first-child").removeClass("glyphicon-chevron-down");
                $(this).find("span:first-child").addClass("glyphicon-chevron-up");
                $(this).removeClass("sublist-down");
                $(this).addClass("sublist-up");
            }
            /*隐藏*/
            else {
                $(this).find("span:first-child").removeClass("glyphicon-chevron-up");
                $(this).find("span:first-child").addClass("glyphicon-chevron-down");
                $(this).removeClass("sublist-up");
                $(this).addClass("sublist-down");
            }
            // 修改数字控制速度， slideUp(500)控制卷起速度
            $(this).next(".navContent").slideToggle(300).siblings(".navContent").slideUp(300);
        })
        /*左侧导航栏缩进功能*/
        $(".left-main .sidebar-fold").click(function () {

            if ($(this).parent().attr('class') == "left-main left-full") {
                $(this).parent().removeClass("left-full");
                $(this).parent().addClass("left-off");

                $(this).parent().parent().find(".right-product").removeClass("right-full");
                $(this).parent().parent().find(".right-product").addClass("right-off");


            }
            else {
                $(this).parent().removeClass("left-off");
                $(this).parent().addClass("left-full");

                $(this).parent().parent().find(".right-product").removeClass("right-off");
                $(this).parent().parent().find(".right-product").addClass("right-full");


            }
        })

        /*左侧鼠标移入提示功能*/
        $(".sBox ul li").mouseenter(function () {
            if ($(this).find("span:last-child").css("display") == "none") {
                $(this).find("div").show();
            }
        }).mouseleave(function () {
            $(this).find("div").hide();
        })
    })
</script>
</body>
</html>

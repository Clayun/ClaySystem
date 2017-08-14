<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <meta charset="utf-8">
        <script src="/console/js/jquery-1.7.1.min.js"></script>
        <title>列表</title>
    </head>

    <body>
    <center>
        <table style="text-align: center;" border="1" cellpadding="2" cellspacing="2">
            <tr>
                <td>ID</td>
                <td>用户名</td>
                <td>联系电话</td>
                <td>用户邮箱</td>
                <td>用户密码</td>
                <td>创建时间</td>
                <td>备注</td>
                <td>
                    <input type="button" value="添加" onclick="toadd()">
                </td>
            </tr>
            <#list list as l>
                <tr>
                    <td>${l.id}<input type="hidden" name="id"  value=""></td>
                    <td id="usernamelabel-${l.id}" onclick="onClickByUsername(${l.id})">
                        <span id="username-${l.id}">${l.username}</span>
                        <input id="change-username-${l.id}" type="text" name="username" value="${l.username}" style="display: none" onblur="onBlurByUsername(${l.id})">
                    </td>
                    <td id="phonelabel-${l.id}" onclick="onClickByPhone(${l.id})">
                        <span id="phone-${l.id}">${l.phone}</span>
                        <input id="change-phone-${l.id}" type="text" name="phone" value="${l.phone}" style="display: none" onblur="onBlurByPhone(${l.id})">
                    </td>
                    <td id="emaillabel-${l.id}" onclick="onClickByEmail(${l.id})">
                        <span id="email-${l.id}">${l.email}</span>
                        <input id="change-email-${l.id}" type="text" name="email" value="${l.email}" style="display: none" onblur="onBlurByEmail(${l.id})">
                    </td>
                    <td id="passwordlabel-${l.id}" onclick="onClickByPassword(${l.id})">
                        <span id="password-${l.id}">***</span>
                        <input id="change-password-${l.id}" placeholder="密码不能为空" type="password" required="required" name="password" style="display: none" onblur="onBlurByPassword(${l.id}) ">
                    </td>
                    <td>${l.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <td id="contentlabel-${l.id}" onclick="onClickByContent(${l.id})">
                        <span id="content-${l.id}">${l.content}</span>
                        <input id="change-content-${l.id}" type="text" name="content" value="${l.content}" style="display: none" onblur="onBlurByContent(${l.id})">
                    </td>
                    <td></td>
                </tr>
            </#list>
        </table>
    </center>
        <form id="form1" style="border: 1px solid; width:250px;">

        </form>
    </body>
    <script>
        function onClickByUsername(id) {
            $("#username-"+id).css("display","none");
            $("#change-username-"+id).css("display","block");
        }
        function onBlurByUsername(id) {
            $("#username-"+id).css("display","block");
            $("#change-username-"+id).css("display","none");
            if($("#change-username-"+id).val()==""){
                alert("密码不能为空");
            }else {
                if (confirm("确定要修改数据吗？")) {
                    $.ajax({
                        type: "POST",
                        url: 'doUpdateUsername',
                        data: {username: $("#change-username-" + id).val(), id: id},
                        success: function (data) {
                            if (data == "success") {
                                $("#username-" + id).html($("#change-username-" + id).val());
                            } else {
                                alert("修改失败");
                            }
                        }
                    });
                }
            }
        }
    </script>
    <script>
        function onClickByPhone(id) {
            $("#phone-"+id).css("display","none");
            $("#change-phone-"+id).css("display","block");
        }
        function onBlurByPhone(id) {
            $("#phone-"+id).css("display","block");
            $("#change-phone-"+id).css("display","none");
            if($("#change-phone-"+id).val()==""){
                alert("手机号不能为空");
            }else{
                if(confirm("确定要修改数据吗？")) {
                    $.ajax({
                        type: "POST",
                        url: 'doUpdatePhone',
                        data:{phone:$("#change-phone-"+id).val(),id:id},
                        success: function (data){
                            if(data == "success"){
                                $("#phone-"+id).html($("#change-phone-"+id).val());
                            }
                        }
                    });
                }
            }
        }
    </script>
    <script>
        function onClickByEmail(id) {
            $("#email-"+id).css("display","none");
            $("#change-email-"+id).css("display","block");
        }
        function onBlurByEmail(id) {
            $("#email-"+id).css("display","block");
            $("#change-email-"+id).css("display","none");
            if($("#change-email-"+id).val()==""){
                alert("邮箱不能为空");
            }else{
                if(confirm("确定要修改数据吗？")) {
                    $.ajax({
                        type: "POST",
                        url: 'doUpdateEmail',
                        data:{email:$("#change-email-"+id).val(),id:id},
                        success: function (data){
                            if(data == "success"){
                                $("#email-"+id).html($("#change-email-"+id).val());
                            }
                        }
                    });
                }
            }
        }
    </script>
    <script>
        function onClickByContent(id) {
            $("#content-"+id).css("display","none");
            $("#change-content-"+id).css("display","block");
        }
        function onBlurByContent(id) {
            $("#content-"+id).css("display","block");
            $("#change-content-"+id).css("display","none");
            if($("#change-content-"+id).val()==""){
                alert("备注不能为空");
            }else{
                if(confirm("确定要修改数据吗？")) {
                    $.ajax({
                        type: "POST",
                        url: 'doUpdateContent',
                        data:{content:$("#change-content-"+id).val(),id:id},
                        success: function (data){
                            if(data == "success"){
                                $("#content-"+id).html($("#change-content-"+id).val());
                            }
                        }
                    });
                }
            }
        }
    </script>
    <script>
        function onClickByPassword(id) {
            $("#password-"+id).css("display","none");
            $("#change-password-"+id).css("display","block");
        }
        function onBlurByPassword(id) {
            $("#password-"+id).css("display","block");
            $("#change-password-"+id).css("display","none");
            if($("#change-password-"+id).val()==""){
                alert("密码不能为空");
            }else{
                if(confirm("确定要修改密码吗？")) {
                    $.ajax({
                        type: "POST",
                        url: 'doUpdatePassword',
                        data:{password:$("#change-password-"+id).val(),id:id},
                            success: function (data){
                        }
                    });
                }
            }

        }
    </script>
    <script>
        $(function(){
            $("#form1").hide();
        })
        function toback(){
            $("#form1").hide(1500);
            $("#form1").empty();
        }
        function toadd(){';'
            $("#form1").show(1500);
            $("#form1").append('<h2 style="margin-left: 80px;">添加</h2>');
            $("#form1").append('用户姓名:<input type="text" name="username" ><br/><br/>');
            $("#form1").append('联系电话:<input type="text" name="phone" ><br/><br/>');
            $("#form1").append('用户邮箱:<input type="text" name="email" ><br/><br/>');
            $("#form1").append('用户密码:<input type="password" name="password" ><br/><br/>');
            $("#form1").append('备注：<input type="text" name="content"><br/><br/>');
            $("#form1").append('<input type="button" value="添加" onclick="add()" style="margin-left: 80px;">');
            $("#form1").append('<input type="button" value="返回" onclick="toback()">');
        }
        function add(){
            var addform=$("#form1").serialize();
            $.ajax({
                url:'uauthadd',
                data:addform,
                dataType:'json',
                type:'post',
                success:function (msg) {
                    if(msg) {
                        alert("添加成功");
                        location.href="uauthlist";
                    }else{
                        alert("添加失败");
                    }
                }
            })
        }
        function todel(id){
            if(confirm("确认删除么？")){
                $.ajax({
                    url:'ucenterdel',
                    data:{id:id},
                    dataType:'json',
                    type:'post',
                    success:function (msg) {
                        if(msg) {
                            alert("删除成功");
                            location.href="ucenterlist";
                        }else{
                            alert("删除失败");
                        }
                    }
                })
            }
        }
    </script>
</html>
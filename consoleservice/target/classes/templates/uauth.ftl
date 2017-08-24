<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
    <head>
        <meta charset="utf-8">
        <script src="/console/js/jquery-3.2.1.min.js"></script>
        <script src="/console/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="/console/css/bootstrap.min.css"/>
        <script src="/console/js/bootstrapValidator.min.js"></script>
        <link href="/console/css/bootstrapValidator.min.css" rel="stylesheet" />
        <script src="/console/js/sweetalert.min.js"></script>
        <script src="/console/js/sweetalert-dev.js"></script>
        <link href="/console/css/sweetalert.css" rel="stylesheet" />
        <title>列表</title>
    </head>
    <script>
        $(function(){
            $('#form1').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields:{
                    username: {
                        message: '用户名验证失败',
                        validators: {
                            notEmpty: {
                                message: '用户名不能为空'
                            },
                            stringLength: {
                                min: 6,
                                max: 18,
                                message: '用户名长度必须在6到18位之间'
                            },
                            regexp: {
                                regexp: /^[a-zA-Z0-9_]+$/,
                                message: '用户名只能包含大写、小写、数字和下划线'
                            }
                        }
                    },
                    phone:{
                        validators: {
                            notEmpty: {
                                message: '手机号不能为空'
                            },
                            stringLength: {
                                min: 11,
                                message: '联系方式应该不少于11位'
                            }
                        }
                    },
                    email: {
                        validators: {
                            notEmpty: {
                                message: '邮件不能为空'
                            },
                            emailAddress: {
                                message: '请输入正确的邮件地址如：123@qq.com'
                            }
                        }
                    },
                    password:{
                        validators: {
                            notEmpty: {
                                message: '密码不能为空'
                            }
                        }
                    },
                    content:{
                        validators: {
                            notEmpty: {
                                message: '账号管理不能为空'
                            }
                        }
                    }
                }
            });
        });
    </script>
    <body>
    <div class="container" style="margin-top: 10px;">
        <div class="row" style="margin-top: 20px;">
            <div>
                <select id="dropdownbox" >
                    <option  value="用户名">用户名</option>
                    <option  value="手机号">手机号</option>
                    <option  value="电子邮箱">电子邮箱</option>
                </select>
                <input type="text" id="content">
                <button class="btn btn-success" type="button" onclick="selectStart()">
                    <span class="glyphicon glyphicon-search "></span>
                    开始查询
                </button>
                    <button class="btn btn-info" data-toggle="modal" data-target="#sheModal" type="button" style="float:right;margin-right:24px">
                        <span class="glyphicon glyphicon-plus"></span>
                        添加
                    </button>
            </div>
            <br/>
        <table class="table table-striped table-bordered text-center" style="vertical-align:middle;">
            <tr>
                <td><strong>ID</strong></td>
                <td><strong>用户名</strong></td>
                <td><strong>联系电话</strong></td>
                <td><strong>用户邮箱</strong></td>
                <td><strong>用户密码</strong></td>
                <td><strong>创建时间</strong></td>
                <td><strong>备注</strong></td>
            </tr>
            <#list list as l>
                <tr>
                    <td>${l.id}<input type="hidden" name="id"  value=""></td>
                    <td id="usernamelabel-${l.id}" onclick="onClickByUsername(${l.id})">
                        <span id="username-${l.id}">${l.username}</span>
                        <input id="change-username-${l.id}" type="text" name="username" value="${l.username}" style="display: none; width: 80px;" onblur="onBlurByUsername(${l.id})">
                    </td>
                    <td id="phonelabel-${l.id}" onclick="onClickByPhone(${l.id})">
                        <span id="phone-${l.id}">${l.phone}</span>
                        <input id="change-phone-${l.id}" type="text" name="phone" value="${l.phone}" style="display:                                none; width: 80px;" onblur="onBlurByPhone(${l.id})">
                    </td>
                    <td id="emaillabel-${l.id}" onclick="onClickByEmail(${l.id})">
                        <span id="email-${l.id}">${l.email}</span>
                        <input id="change-email-${l.id}" type="text" name="email" value="${l.email}" style="display:                                    none; width: 80px;" onblur="onBlurByEmail(${l.id})">
                    </td>
                    <td id="passwordlabel-${l.id}" onclick="onClickByPassword(${l.id})">
                        <span id="password-${l.id}">***</span>
                        <input id="change-password-${l.id}" placeholder="密码不能为空" type="password"  required="required" name="password" style="display: none; width: 90px;"                                             onblur="onBlurByPassword(${l.id}) ">
                    </td>
                    <td>${l.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                    <td id="contentlabel-${l.id}" onclick="onClickByContent(${l.id})">
                        <span id="content-${l.id}">${l.content}</span>
                        <input id="change-content-${l.id}" type="text" name="content" value="${l.content}"  style="display: none; width: 80px;" onblur="onBlurByContent(${l.id})">
                    </td>
                </tr>
            </#list>
            <tr>
                <td colspan="10">${page}&nbsp;&nbsp;
                    <span class="text-primary">到第<input type="text" id="gopage" style="width:50px;">页</span>
                    <input class="btn btn-primary" type="button" value="GO" onclick="GO()">
                    <input type="hidden" id="pageCount" value="${pageCount}">
                </td>
            </tr>
        </table>
            <#--添加模态框-->
            <div class="modal fade" id="sheModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                            <h4 class="modal-title" id="myModalLabel" style="margin-left: 240px; color: red;">添加页面</h4>
                        </div>
                        <div class="modal-body">
                            <form id="form1">
                                <div class="form-group">
                                    <label>用户名称：</label>
                                    <input class="form-control" type="text" name="username" placeholder="用户名称">
                                </div>

                                <div class="form-group">
                                    <label>联系电话：</label>
                                    <input type="text" name="phone" class="form-control" placeholder="联系电话">
                                </div>
                                <div class="form-group">
                                    <label>用户邮箱：</label>
                                    <input type="text" name="email" class="form-control" placeholder="用户邮箱">
                                </div>
                                <div class="form-group">
                                    <label>用户密码：</label>
                                    <input type="password" name="password" class="form-control" placeholder="用户密码">
                                </div>
                                <div class="form-group">
                                    <label>用户备注：</label>
                                    <input type="text" name="content" class="form-control" placeholder="用户备注">
                                </div>
                            <div style="text-align: center">
                                <input type="submit" class="btn btn-primary" value="添加" onclick="doadd()">
                                <input type="button" class="btn btn-danger" data-dismiss="modal"  value="关闭">
                            </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    </body>
    <script>
        //跳转到指定的页数
        function GO(){
            var pageCount=$("#pageCount").val();
            var gopage=$("#gopage").val();
            if(pageCount==0){
                swal("模糊查询时无法跳转页面!")
            }else{
                if(gopage!=null&&gopage!=""){
                    location.href="/console/uauth/uauthlist?cPage="+gopage;
                }else{
                    swal("请输入要跳转的页数!")
                }
            }
        }
        //查询功能
        function selectStart(){
            var dropdownbox=$("#dropdownbox").val();
            var content=$("#content").val();
            if(content!=""){
                location.href="/console/uauth/uauthlist?dropdownbox="+dropdownbox+"&content="+content;
            }else{
                location.href="uauthlist";
            }
        }
        //添加
        function doadd(){
            var addform =$("#form1").serialize();
            if(!$('#form1').data('bootstrapValidator').isValid()){ //判断校检是否通过
                return;
            }else{
                $.ajax({
                    url:'/console/uauth/uauthadd',
                    data:addform,
                    dataType:'json',
                    type:'post',
                    success:function (msg) {
                        if(msg) {
                            swal("添加成功", "您提交的数据已添加成功!", "success");
                            window.setTimeout("window.location.href='/console/uauth/uauthlist'",2000);
                        }else{
                            swal("错误!","您提交的数据添加失败!","error");
                        }
                    }
                })
            }
        }
    </script>
    <script>
        function onClickByUsername(id) {
            $("#username-"+id).css("display","none");
            $("#change-username-"+id).css("display","block");
        }
        function onBlurByUsername(id) {
            $("#username-"+id).css("display","block");
            $("#change-username-"+id).css("display","none");
            if($("#change-username-"+id).val()==""){
                swal("用户名不能为空!")
            }else{
                swal({
                    title: "您确定要执行此操作吗？",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确定",
                    closeOnConfirm: false
                },function(isConfirm){
                    if(isConfirm){
                        $.ajax({
                            type: "POST",
                            url: 'doUpdateUsername',
                            data: {username: $("#change-username-" + id).val(), id: id},
                            success: function (data){
                                if(data == "success"){
                                    swal("修改成功", "您选择的数据已被修改!", "success");
                                    $("#username-" + id).html($("#change-username-" + id).val());
                                }else{
                                    swal("错误!","您的数据修改失败!","error");
                                }
                            }
                        });
                    }
                });
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
                swal("手机号不能为空!")
            }else{
                swal({
                    title: "您确定要执行此操作吗？",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确定",
                    closeOnConfirm: false
                },function(isConfirm){
                    if(isConfirm){
                        $.ajax({
                            type: "POST",
                            url: 'doUpdatePhone',
                            data:{phone:$("#change-phone-"+id).val(),id:id},
                            success: function (data){
                                if(data == "success"){
                                    $("#phone-"+id).html($("#change-phone-"+id).val());
                                    swal("修改成功", "您选择的数据已被修改!", "success");
                                }else{
                                    swal("错误!","您的数据修改失败!","error");
                                }
                            }
                        });
                    }
                });
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
                swal("邮箱不能为空!")
            }else{
                swal({
                    title: "您确定要执行此操作吗？",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确定",
                    closeOnConfirm: false
                },function(isConfirm){
                    if(isConfirm){
                        $.ajax({
                            type: "POST",
                            url: 'doUpdateEmail',
                            data:{email:$("#change-email-"+id).val(),id:id},
                            success: function (data){
                                if(data == "success"){
                                    $("#phone-"+id).html($("#change-phone-"+id).val());
                                    swal("修改成功", "您选择的数据已被修改!", "success");
                                    $("#email-"+id).html($("#change-email-"+id).val());
                                }else{
                                    swal("错误!","您的数据修改失败!","error");
                                }
                            }
                        });
                    }
                });
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
                swal("备注不能为空!")
            }else{
                swal({
                    title: "您确定要执行此操作吗？",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确定",
                    closeOnConfirm: false
                },function(isConfirm){
                    if(isConfirm){
                        $.ajax({
                            type: "POST",
                            url: 'doUpdateContent',
                            data:{content:$("#change-content-"+id).val(),id:id},
                            success: function (data){
                                if(data == "success"){
                                    $("#phone-"+id).html($("#change-phone-"+id).val());
                                    swal("修改成功", "您选择的数据已被修改!", "success");
                                    $("#content-"+id).html($("#change-content-"+id).val());
                                }else{
                                    swal("错误!","您的数据修改失败!","error");
                                }
                            }
                        });
                    }
                });
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
                swal("密码不能为空!")
            }else{
                swal({
                    title: "您确定要执行此操作吗？",
                    type: "warning",
                    showCancelButton: true,
                    confirmButtonColor: "#DD6B55",
                    confirmButtonText: "确定",
                    closeOnConfirm: false
                },function(isConfirm){
                    if(isConfirm){
                        $.ajax({
                            type: "POST",
                            url: 'doUpdatePassword',
                            data:{password:$("#change-password-"+id).val(),id:id},
                            success: function (data){
                                if(data == "success"){
                                    swal("修改成功", "您选择的数据已被修改!", "success");
                                }else{
                                    swal("错误!","您的数据修改失败!","error");
                                }
                            }
                        });
                    }
                });
            }
        }
    </script>
    <script>
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
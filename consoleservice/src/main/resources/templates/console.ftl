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
    <body>
        <div class="container">
            <div class="row" style="margin-top: 30px;">
                <div>
                    <select id="dropdownbox"  >
                        <option  value="ID">ID</option>
                        <option  value="用户名">用户名</option>
                        <option  value="手机号">手机号</option>
                    </select>
                    <input type="text" id="content">
                    <button class="btn btn-success" type="button" onclick="selectStart()">
                        <span class="glyphicon glyphicon-search "></span>
                        开始查询
                    </button>
                </div><br/>
                    <table class="table table-striped table-bordered text-center " style="vertical-align: middle;">
                        <tr>
                            <td><strong>ID</strong></td>
                            <td><strong>用户名</strong></td>
                            <td><strong>联系电话</strong></td>
                            <td><strong>用户密码</strong></td>
                            <td><strong>创建时间</strong></td>
                            <td><strong>权限</strong></td>
                            <td><strong>账号管理</strong></td>
                            <td>
                                <button class="btn btn-info" ng-click="ad()" data-toggle="modal" data-target="#sheModal" type="button" >
                                    <span class="glyphicon glyphicon-plus"></span>
                                    添加
                                </button>
                            </td>
                        </tr>
                    <#list list as l>
                        <tr>
                            <td>${l.id}</td>
                            <td id="usernamelabel-${l.id}" onclick="onClickByUsername(${l.id})">
                                <span id="username-${l.id}">${l.username}</span>
                                <input id="change-username-${l.id}" type="text" name="username" value="${l.username}" style="display: none; width: 80px;" onblur="onBlurByUsername(${l.id})">
                            </td>
                            <td id="phonelabel-${l.id}" onclick="onClickByPhone(${l.id})">
                                <span id="phone-${l.id}">${l.phone}</span>
                                <input id="change-phone-${l.id}" type="text" name="phone" value="${l.phone}" style="display: none; width: 100px;" onblur="onBlurByPhone(${l.id})">
                            </td>
                            <td id="passwordlabel-${l.id}" onclick="onClickByPassword(${l.id})">
                                <span id="password-${l.id}">***</span>
                                <input id="change-password-${l.id}" placeholder="密码不能为空" type="password" required="required" name="password" style="display: none; width: 100px;" onblur="onBlurByPassword(${l.id}) ">
                            </td>
                            <td>${l.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                            <td>${l.permission}</td>
                            <td>${l.bindUser}</td>
                            <td>
                                <button class="btn btn-danger" type="button"  onclick="todel(${l.id})">
                                    <span class="glyphicon glyphicon glyphicon-minus"></span>
                                    删除
                                </button>
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
                    <form id="form1" style="border: 1px solid; width:250px;">
                    </form>

                <!-- 添加模态框-->
                <div class="modal fade" id="sheModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-dialog">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                    &times;
                                </button>
                                <h4 class="modal-title" id="myModalLabel" style="margin-left: 240px; color: red;">
                                    添加页面
                                </h4>
                            </div>
                            <div class="modal-body">
                                <form id="addform">
                                    <div class="form-group">
                                        <label>用户名称：</label>
                                        <input class="form-control" type="text" name="username" >
                                    </div>
                                    <div class="form-group">
                                        <label>联系电话：</label>
                                        <input class="form-control" type="text" name="phone" >
                                    </div>
                                    <div class="form-group">
                                        <label>用户密码:</label>
                                        <input class="form-control" type="password" name="password" >
                                    </div>
                                    <div class="form-group">
                                        <label>权限等级:</label>
                                        <input class="form-control" type="text" name="permission" >
                                    </div>
                                    <div class="form-group">
                                        <label>账号管理:</label>
                                        <input class="form-control" type="text" name="bindUser">
                                    </div>
                                    <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                                    <button type="submit" name="submit" class="btn btn-primary" onclick="add()">
                                        提交
                                    </button>
                                </form>
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
                    location.href="/console/list/ucenterlist?cPage="+gopage;
                }else{
                    swal("请输入要跳转的页数!")
                }
            }
        }
    </script>
    <script>
        //修改用户名功能
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
                            url: 'doUpdateUcenter',
                            data: {username: $("#change-username-" + id).val(), id: id},
                            success: function (data) {
                                if (data == "success") {
                                    $("#username-" + id).html($("#change-username-" + id).val());
                                    swal("修改成功", "您选择的数据已被修改!", "success");
                                } else{
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
        //修改电话号功能
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
        //修改密码功能
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
        //添加
        function add(){
            if(pageCount==0){
                swal("查询时无法添加!");
            }else{
                if(!$('#addform').data('bootstrapValidator').isValid()){ //判断校检是否通过
                    return;
                }else{
                    var addform=$("#form1").serialize();
                    $.ajax({
                        url:'ucenteradd',
                        data:addform,
                        dataType:'json',
                        type:'post',
                        success:function (msg) {
                            if(msg) {
                                swal("添加成功", "您的数据已被添加!", "success");
                                window.setTimeout("window.location.href='ucenterlist'",2000);
                            }else{
                                swal("错误!","您的数据添加失败!","error");
                            }
                        }
                    })
                }
            }
        }
    </script>
    <script>
        $(function(){
            $("#form1").hide();
            $('#addform').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
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
                    password:{
                        validators: {
                            notEmpty: {
                                message: '用户密码不能为空'
                            }
                        }
                    },
                    permission:{
                        validators: {
                            notEmpty: {
                                message: '权限等级不能为空'
                            }
                        }
                    },
                    bindUser:{
                        validators: {
                            notEmpty: {
                                message: '账号管理不能为空'
                            }
                        }
                    }
                }
            });
        })
        function toback(){
            $("#form1").hide(2000);
            $("#form1").empty();
        }
        //删除
        function todel(id){
            swal({
                title: "您确定要执行此操作吗？",
                text: "删除后将无法恢复，请谨慎操作！",
                type: "warning",
                showCancelButton: true,
                confirmButtonColor: "#DD6B55",
                confirmButtonText: "确定",
                closeOnConfirm: false
            },function(isConfirm){
                if(isConfirm){
                    $.ajax({
                        url:'ucenterdel',
                        data:{id:id},
                        dataType:'json',
                        type:'post',
                        success:function (msg) {
                            if(msg) {
                                swal("删除成功", "您选择的数据已被删除!", "success");
                                window.setTimeout("window.location.href='ucenterlist'",2000);
                            }else{
                                swal("错误!","您的数据删除失败!","error");
                            }
                        }
                    })
                }
            });
        }
        //查询功能
        function selectStart(){
            var dropdownbox=$("#dropdownbox").val();
            var content=$("#content").val();
            if(content!=""){
                location.href="/console/list/ucenterlist?dropdownbox="+dropdownbox+"&content="+content;
            }else{
                location.href="ucenterlist";
            }
        }
    </script>
</html>

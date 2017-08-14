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
                    <table class="table table-striped table-bordered text-center " style="vertical-align: middle;">
                        <tr>
                            <td><strong>ID</strong></td>
                            <td><strong>金钱</strong></td>
                            <td><strong>得分</strong></td>
                            <td><strong>消耗</strong></td>
                            <td>
                                <button class="btn btn-info" ng-click="ad()" data-toggle="modal" data-target="#sheModal" type="button" >
                                    <span class="glyphicon glyphicon-plus"></span>
                                    添加
                                </button>
                            </td>
                        </tr>
                        <#list list as l>
                            <tr>
                                <td id="id-${l.id}">${l.id}</td>
                                <td id="money-${l.id}">${l.money}</td>
                                <td id="score-${l.id}">${l.score}</td>
                                <td id="consume-${l.id}">${l.consume}</td>
                                <td>
                                    <button class="btn btn-primary" ng-click="up()" onclick="toupdate(${l.id})" data-toggle="modal" data-target="#upModal" type="button" >
                                        <span class="glyphicon glyphicon-pencil"></span>
                                        修改
                                    </button>
                                    <button class="btn btn-danger" type="button"  onclick="todel(${l.id})">
                                        <span class="glyphicon glyphicon glyphicon-minus"></span>
                                        删除
                                    </button>
                                </td>
                            </tr>
                        </#list>
                    </table>

                    <!-- 修改模态框-->
                    <div class="modal fade" id="upModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                        &times;
                                    </button>
                                    <h4 class="modal-title" id="myModalLabel" style="margin-left: 240px; color: blue;">
                                        修改页面
                                    </h4>
                                </div>
                                <div class="modal-body">
                                    <form id="updateform">
                                        <div class="form-group">
                                            <label>金钱：</label>
                                            <input class="form-control" id="moneylabel" type="text" name="money" >
                                        </div>
                                        <div class="form-group">
                                            <label>得分：</label>
                                            <input class="form-control" id="scorelabel" type="text" name="score" >
                                        </div>
                                        <div class="form-group">
                                            <label>消耗:</label>
                                            <input class="form-control" id="consumelabel" type="text" name="consume" >
                                        </div>
                                        <input type="hidden" class="form-control" id="idlabel" name="id">
                                        <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                                        <button type="button" onclick="update()" name="submit" class="btn btn-primary" >
                                            提交
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>

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
                                            <label>金钱：</label>
                                            <input class="form-control" type="text" name="money" >
                                        </div>
                                        <div class="form-group">
                                            <label>得分：</label>
                                            <input class="form-control" type="text" name="score" >
                                        </div>
                                        <div class="form-group">
                                            <label>消耗:</label>
                                            <input class="form-control" type="text" name="consume" >
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

                </div>
            </div>
        </body>
    <script>
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
                        url:'accountdel',
                        data:{id:id},
                        dataType:'json',
                        type:'post',
                        success:function(msg){
                            if(msg) {
                                swal("删除成功", "您选择的数据已被删除!", "success");
                                window.setTimeout("window.location.href='accountlist'",2000);
                            }else{
                                swal("错误!","您的数据删除失败!","error");
                            }
                        }
                    })
                }
        });
    }

        //修改回显
        function toupdate(id){
            $("#idlabel").val($("#id-"+id).html());
            $("#moneylabel").val($("#money-"+id).html());
            $("#scorelabel").val($("#score-"+id).html());
            $("#consumelabel").val($("#consume-"+id).html());
        }
        function update(){
            var updateform=$("#updateform").serialize();
            $.ajax({
                url:'accountupdate',
                data:updateform,
                dataType:'json',
                type:'post',
                success:function(msg){
                    if(msg){
                        swal("修改成功", "您选择的数据已被修改!", "success");
                        window.setTimeout("window.location.href='accountlist'",2000);
                    }else{
                        swal("错误!","您的数据修改失败!","error");
                    }
                }
            })
        }
    </script>
    <script>
        //BootstarpValidate插件表单验证
        $(function(){
            $('#addform').bootstrapValidator({
                message: 'This value is not valid',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: {
                    money: {
                        message: '验证失败',
                        validators: {
                            notEmpty: {
                                message: '金钱不能为空'
                            },
                        }
                    },
                    score:{
                        validators: {
                            notEmpty: {
                                message: '得分不能为空'
                            },
                        }
                    },
                    consume:{
                        validators: {
                            notEmpty: {
                                message: '消耗不能为空'
                            }
                        }
                    },
                }
            });
        });
    </script>
        <script>
            //添加
            function add(){
                if(!$('#addform').data('bootstrapValidator').isValid()) {//判断校检是否通过
                    return;
                }else{
                    var addform=$("#addform").serialize();
                        $.ajax({
                            url:'accountadd',
                            data:addform,
                            dataType:'json',
                            type:'post',
                            success:function (msg) {
                                if(msg) {
                                    swal("添加成功", "您的数据已被添加!", "success");
                                    window.setTimeout("window.location.href='accountlist'",2000);
                                }else{
                                    swal("错误!","您的数据添加失败!","error");
                                }
                            }
                        })
                }
            }
        </script>
</html>
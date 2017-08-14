<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" type="text/css" href="/console/css/bootstrap.min.css"/>
    <script type="text/javascript" src="/console/My97DatePicker/WdatePicker.js"></script>
    <script src="/console/js/jquery-3.2.1.min.js"></script>
    <script src="/console/js/bootstrap.min.js"></script>
    <title>列表</title>
</head>
<script>
    function s() {
        WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})
    }
    function ss() {
        WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})
    }
</script>
<script>
    function s() {
        WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})
    }
    function ss() {
        WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})
    }
    function update(id) {
        $("#idlabel").val($("#id-"+id).html());
        $("#titlelabel").val($("#title-"+id).html());
        $("#abstractInfolabel").val($("#abstractInfo-"+id).html());
        $("#numlabel").val($("#num-"+id).html());
        $("#contentlabel").val($("#content-"+id).html());
        $("#startTimelabel").val($("#startTime-"+id).html());
        $("#overTimelabel").val($("#overTime-"+id).html());
        $("#statelabel").val($("#state-"+id).html());
        $("#managerNamelabel").val($("#managerName-"+id).html());
        $("#selectedlabel").val($("#selected-"+id).html());
        $("input[name='type'][value='1']").attr("checked",true);
        $("input[name='type'][value='2']").attr("checked",true);
    }
    //执行添加操作
    function doadd(){
        var addform =$("#form1").serialize();
        $.ajax({
            url:'/console/activities/activitiesAdd',
            data:addform,
            dataType:'json',
            type:'post',
            success:function (msg) {
                if(msg) {
                    alert("添加成功");
                    location.href="activitieslist";
                }else{
                    alert("添加失败");
                }
            }
        })
    }

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

</script>
<body>
<div class="container" style="margin-top: 10px;">
    <div class="row" style="margin-top: 20px;">
        <table class="table table-striped table-bordered text-center" style="vertical-align:middle;">
            <tr>
                <td>ID</td>
                <td>活动类型</td>
                <td>说明</td>
                <td>概况</td>
                <td>详情</td>
                <td>具体参数</td>
                <td>起始日期</td>
                <td>截止日期</td>
                <td>负责人</td>
                <td>状态</td>
                <td>selected</td>
                <td>
                    <button class="btn btn-info" data-toggle="modal" data-target="#sheModal"
                            type="button" >
                        <span class="glyphicon glyphicon-plus"></span>
                        添加</button>
                </td>
            </tr>
        <#list list as l>
            <tr>
                <td id="id-${l.id}">${l.id}</td>
                <td id="type-${l.id}">${l.type}</td>
                <td id="title-${l.id}">${l.title}</td>
                <td id="abstractInfo-${l.id}">${l.abstractInfo}</td>
                <td id="content-${l.id}">${l.content}</td>
                <td id="num-${l.id}">${l.num}</td>
                <td id="startTime-${l.id}">${l.startTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td id="overTime-${l.id}">${l.overTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td id="managerName-${l.id}">${l.managerName}</td>
                <td id="state-${l.id}">${l.state}</td>
                <td id="selected-${l.id}">${l.selected}</td>
                <td>
                    <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModalupdate" onclick="update(${l.id})">
                        修改
                    </button>
                </td>
            </tr>
        </#list>
        </table>

        <!-- 添加模态框-->
        <div class="modal fade" id="sheModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        </button>
                        <h4 class="modal-title" id="myModalLabel" style="margin-left:240px; color: red;">
                            添加数据
                        </h4>
                    </div>
                    <div class="modal-body" >
                        <form id="form1">
                            <div style="padding: 10px 100px 10px;">
                                    <div class="input-group">
                                        <span class="input-group-addon">活动标题</span>
                                        <input type="text" name="title" class="form-control" placeholder="活动标题">
                                    </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                    <div class="input-group">
                                        <span class="input-group-addon">活动概述</span>
                                        <input type="text" name="abstractInfo" class="form-control" placeholder="活动概述">
                                    </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                    <div class="input-group">
                                        <span class="input-group-addon">活动详情</span>
                                        <input type="text" name="content" class="form-control" placeholder="活动详情">
                                    </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                    <div class="input-group">
                                        <span class="input-group-addon">具体参数</span>
                                        <input type="text" name="num" class="form-control" placeholder="对应Type的具体参数">
                                    </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                    <div class="input-group">
                                        <span class="input-group-addon">起始日期</span>
                                        <input type="text" name="startTime" class="form-control" placeholder="起始日期" onclick="s()">
                                    </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                    <div class="input-group">
                                        <span class="input-group-addon">截止日期</span>
                                        <input type="text" name="overTime" class="form-control" placeholder="截止日期" onclick="ss()">
                                    </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                    <div class="input-group">
                                        <span class="input-group-addon">截止日期</span>
                                        <input type="text" name="managerName" class="form-control" placeholder="负责人">
                                    </div>
                            </div>
                            <div style="text-align: center">
                                活动类型
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="type" id="type"
                                               value="1" checked> 百分比
                                        　　　
                                        <input type="radio" name="type" id="type"
                                               value="2"> 直　降
                                    </label>
                                </div>

                                <div style="text-align: center">
                                    活动状态
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="state" id="state"
                                                   value="1" checked> 未开始
                                            　　　
                                            <input type="radio" name="state" id="state"
                                                   value="2"> 已开始
                                            　　
                                            <input type="radio" name="state" id="state"
                                                   value="3"> 已结束
                                        </label>
                                    </div>
                                </div>
                                <div style="text-align: center">
                                    selected
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="selected" id="selected"
                                                   value="1" checked> 单　选
                                            　　　　　
                                            <input type="radio" name="selected" id="selected"
                                                   value="2"> 多　选
                                        </label>
                                    </div>
                                </div><br />
                        <button type="button" class="btn btn-primary" onclick="doadd()">添加</button>
                        <button type="button" class="btn btn-danger" data-dismiss="modal">关闭</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        </div>

        <#--修改-->
        <div class="modal fade" id="myModalupdate" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        </button>
                        <h4 class="modal-title" id="myModalLabel" style="margin-left:240px; color: red;">
                            修改数据
                        </h4>
                    </div>
                    <div class="modal-body">
                        <form id="update" action="/console/activities/activitiesUpdate" method="post">
                            <div style="padding: 10px 100px 10px;">
                                <div class="input-group">
                                    <span class="input-group-addon">活动标题</span>
                                    <input type="text" id="titlelabel" name="title" class="form-control">
                                    <input type="hidden" id="idlabel" name="id" class="form-control">
                                </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                <div class="input-group">
                                    <span class="input-group-addon">活动概述</span>
                                    <input type="text" id="abstractInfolabel" name="abstractInfo" class="form-control">
                                </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                <div class="input-group">
                                    <span class="input-group-addon">活动详情</span>
                                    <input type="text" id="contentlabel" name="content" class="form-control" placeholder="活动详情">
                                </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                <div class="input-group">
                                    <span class="input-group-addon">具体参数</span>
                                    <input type="text" id="numlabel" name="num" class="form-control" placeholder="对应Type的具体参数">
                                </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                <div class="input-group">
                                    <span class="input-group-addon">起始日期</span>
                                    <input type="text" id="startTimelabel" name="startTime" class="form-control" placeholder="起始日期" onclick="s()">
                                </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                <div class="input-group">
                                    <span class="input-group-addon">截止日期</span>
                                    <input type="text" id="overTimelabel" name="overTime" class="form-control" placeholder="截止日期" onclick="ss()">
                                </div>
                            </div>
                            <div style="padding: 10px 100px 10px;">
                                <div class="input-group">
                                    <span class="input-group-addon">　负责人</span>
                                    <input type="text" id="managerNamelabel" name="managerName" class="form-control" placeholder="负责人">
                                </div>
                            </div>
                            <div style="text-align: center">
                                活动类型
                                <div class="radio">
                                    <label>
                                        <input type="radio" name="type" id="type"
                                               value="1"> 百分比
                                        　　　
                                        <input type="radio" name="type" id="type"
                                               value="2"> 直　降
                                    </label>
                                </div>

                                <div style="text-align: center">
                                    活动状态
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="state" id="state"
                                                   value="1" checked> 未开始
                                            　　　
                                            <input type="radio" name="state" id="state"
                                                   value="2"> 已开始
                                            　　
                                            <input type="radio" name="state" id="state"
                                                   value="3"> 已结束
                                        </label>
                                    </div>
                                </div>
                                <div style="text-align: center">
                                    selected
                                    <div class="radio">
                                        <label>
                                            <input type="radio" name="selected" id="selected"
                                                   value="1" checked> 单　选
                                            　　　　　
                                            <input type="radio" name="selected" id="selected"
                                                   value="2"> 多　选
                                        </label>
                                    </div>
                                </div><br />
                                <input type="submit" class="btn btn-primary" value="确认修改"></input>
                                <input type="button" class="btn btn-danger" value="关闭" data-dismiss="modal"></input>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </div>
</div>
</body>
</html>

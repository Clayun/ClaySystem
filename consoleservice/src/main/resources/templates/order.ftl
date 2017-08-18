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
    function chakan(ordersUuid){
        location.href="ordersSelect?ordersUuid="+ordersUuid;
      }
</script>
<body>
    <div class="container">
        <div class="row" style="margin-top: 30px;">
            <table class="table table-striped table-bordered text-center" style="vertical-align: middle;">
                <tr>
                    <td><strong>订单编号</strong></td>
                    <td><strong>账单流水号</strong></td>
                    <td><strong>付款金额</strong></td>
                    <td><strong>付款用途</strong></td>
                    <td><strong>备注</strong></td>
                    <td><strong>付款时间</strong></td>
                    <td><strong>实际金额</strong></td>
                    <td><strong>订单状态</strong></td>
                    <td><strong>月份</strong></td>
                    <td><strong>操作</strong></td>
                </tr>
                <#list list as l>
                    <tr>
                        <td>${l.id}</td>
                        <td>${l.ordersUuid}</td>
                        <td>${l.amount}</td>
                        <td>${l.payName}</td>
                        <td>${l.remarks}</td>
                        <td>${l.paymentTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${l.theActualAmount}</td>
                        <td>${l.stateName}</td>
                        <td>${l.month}</td>
                        <td>
                            <button class="btn btn-info" onclick="chakan('${l.ordersUuid}')" type="button" >
                                <span class="glyphicon glyphicon-eye-open"></span>
                                查看详情
                            </button>
                        </td>
                    </tr>
                </#list>
            </table>

           <#-- <!-- 查看详情信息&ndash;&gt;
            <div class="modal fade" id="sheModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                <div class="modal-dialog">
                    <div class="modal-content">
                        <div class="modal-header">
                            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                                &times;
                            </button>
                            <h4 class="modal-title" id="myModalLabel" style="margin-left: 240px; color: blue;">
                                详情信息:${dateils.content}
                            </h4>
                        </div>
                        <div class="modal-body">
                            <form id="addform">
                                购买详情参数:
                                <button type="button" class="btn btn-info" data-dismiss="modal">关闭</button>
                            </form>
                        </div>
                    </div>
                </div>
            </div>-->
        </div>
    </div>
</body>
</html>
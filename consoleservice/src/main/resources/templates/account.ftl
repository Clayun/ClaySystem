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
            <title>列表</title>
        </head>
        <body>
            <div class="container">
                <div class="row" style="margin-top: 30px;">
                    <table class="table table-striped table-bordered text-center " style="vertical-align: middle;">
                        <tr>
                            <th>ID</th>
                            <th>金钱</th>
                            <th>得分</th>
                            <th>消耗</th>
                            <th>
                                <button class="btn btn-info" ng-click="ad()" data-toggle="modal" data-target="#sheModal" type="button" >
                                    <span class="glyphicon glyphicon-plus"></span>
                                    添加
                                </button>
                            </th>
                        </tr>
                        <#list list as l>
                            <tr>
                                <td>${l.id}</td>
                                <td>${l.money}</td>
                                <td>${l.score}</td>
                                <td>${l.consume}</td>
                            </tr>
                        </#list>
                    </table>
                </div>
            </div>
        </body>
</html>
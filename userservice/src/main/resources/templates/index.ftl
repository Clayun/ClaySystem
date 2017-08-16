<!doctype html>
<html xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=2.0, user-scalable=yes" />
    <title>登录 - 企业级云服务器、弹性云MineCraft服务器租用服务提供商</title>
    <link rel="stylesheet" type="text/css" href="/security/css/login.css">
</head>
	<body>
        <div>
            <table>
                <tr>
                    <th>流水号</th>
                    <th>UUID</th>
                    <th>中文名称</th>
                    <th>英文名称</th>
                    <th>出生日期</th>
                    <th>性别</th>
                    <th>职业</th>
                    <th>学历</th>
                    <th>毕业学校</th>
                    <th>收货地址</th>
                    <th>自我介绍</th>
                </tr>
                <#list list as l>
                    <tr>
                        <td>${l.id}</td>
                        <td>${l.uuid}</td>
                        <td>${l.cn_name}</td>
                        <td>${l.en_name}</td>
                        <td>${l.birthday?string("yyyy-MM-dd HH:mm:ss")}</td>
                        <td>${l.sex}</td>
                        <td>${l.job}</td>
                        <td>${l.education}</td>
                        <td>${l.school}</td>
                        <td>${l.locationId}</td>
                        <td>${l.content}</td>
                    </tr>
                </#list>
            </table>
        </div>
    </body>
<footer>
    <div class="footer-box-hole">
        <div class="footer-box-up">
            <div class="footer-box-up-left">
                <img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/3117733.jpg">
                <div class="footer-box-up-left-line">
                    <h3>客服专线</h3>
                    <h2>110-110-110</h2>
                    <br>
                    <p>人工服务</p>
                    <p>快速处理</p>
                    <p>满意度100%</p>
                </div>
            </div>
            <div class="footer-box-up-right">
                <ul>
                    <li>定制内容</li>
                    <li>门店网站</li>
                    <li>APP界面</li>
                    <li>软件界面</li>
                </ul>
                <ul>
                    <li>云主机</li>
                    <li>基本服务器</li>
                    <li>通用服务器</li>
                    <li>应用服务器</li>
                </ul>
                <ul>
                    <li>人工咨询</li>
                    <li>客服咨询</li>
                    <li>设计师专线</li>
                    <li>程序员专线</li>
                    <li>运维专线</li>
                </ul>
                <ul>
                    <li>关注我们</li>
                    <li><img src="http://osuyq1koj.bkt.clouddn.com/17-7-10/16002364.jpg" height="128px"></li>
                </ul>
            </div>
        </div>
        <div class="footer-box-middle"></div>
        <div class="footer-box-down">
            <span>©2012-2017 北京信联创维科技有限公司 版权所有 ICP证：京ICP备16065100号-1</span>
        </div>
    </div>
</footer>

<script src="/security/js/jquery-1.7.1.min.js"></script>
<script src="/security/js/gt.js"></script>
<script src="/security/js/login.js"></script>
</html>

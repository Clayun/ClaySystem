<html>
    <head>
        <title>列表</title>
        <script src="/console/js/jquery-1.7.1.min.js"></script>
    </head>
    <body>
    <table style="text-align: center" border="1">

        <tr>
            <th>ID</th>
            <th>用户名</th>
            <th>联系电话</th>
            <td>创建时间</td>
            <th>几级权限</th>
            <th>账号管理</th>
            <th>操作</th>
        </tr>
        <#list list as l>
            <tr>
                <td>${l.id}</td>
                <td id="usernamelabel-${l.id}" onclick="onClickByUsername(${l.id})">
                    <span id="username-${l.id}">${l.username}</span>
                    <input id="change-username-${l.id}" type="text" name="username" value="${l.username}" style="display: none" onblur="onBlurByUsername(${l.id})">
                </td>
                <td>${l.phone}</td>
                <td>${l.createTime?string("yyyy-MM-dd HH:mm:ss")}</td>
                <td>${l.permission}</td>
                <td>${l.bindUser}</td>
                <td>
                    <input type="button" value="修改" onclick="location='toUpdateUcenter?id=${l.id}'">
                </td>
            </tr>
        </#list>
    </table>
    <script>
        function onClickByUsername(id) {
            $("#username-"+id).css("display","none");
            $("#change-username-"+id).css("display","block");
        }
        function onBlurByUsername(id) {
            $("#username-"+id).css("display","block");
            $("#change-username-"+id).css("display","none");
            $.ajax({
                type: "POST",
                url: 'doUpdateUcenter?username='+$("#change-username-"+id).val(),
                success: function (data) {
                }
            });
        }
    </script>
    </body>
</html>
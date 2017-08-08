<html>
<head>
    <title>修改</title>
</head>
<body>
<table style="text-align:center" border="1">

    <tr>
        <td>用户名</td>
        <td>
            <input  type="text" name="username" value="${u.username}" style="display: none">
        </td>
    </tr>
    <tr>
        <th>联系电话</th>
        <th>
            <input type="text" name="phone" value="${u.phone}">
        </th>
    </tr>
    <tr>
        <td>创建时间</td>
        <td>
            <input type="text" disabled="disabled" name="createTime" value="${u.createTime?string("yyyy-MM-dd HH:mm:ss")}">
        </td>
    </tr>
    <tr>
        <td>几级权限</td>
        <td>几级权限</td>
    </tr>
        <th>账号管理</th>
        <th>操作</th>
</table>
</body>
</html>
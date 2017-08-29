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
    <title>登录页面</title>
</head>
<style>
    body{
        background: #ebebeb;
        font-family: "Helvetica Neue","Hiragino Sans GB","Microsoft YaHei","\9ED1\4F53",Arial,sans-serif;
        color: #222;
        font-size: 12px;
    }
    *{padding: 0px;margin: 0px;}
    .top_div{
        background: #344A80;
        width: 100%;
        height: 360px;
    }
    .ipt{
        border: 1px solid #d3d3d3;
        padding: 10px 10px;
        width: 340px;
        border-radius: 4px;
        padding-left: 35px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
        -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s
    }
    .ipt:focus{
        border-color: #66afe9;
        outline: 0;
        -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6);
        box-shadow: inset 0 1px 1px rgba(0,0,0,.075),0 0 8px rgba(102,175,233,.6)
    }
    #ulogo{
        padding: 10px 10px;
        position: absolute;
        top: 33px;
        left: 56px;
    }
    #plogo{
        padding: 10px 10px;
        position: absolute;
        top: 4px;
        left: 56px;
    }
    a{
        text-decoration: none;
    }
</style>
<script>
    function login(){
       var username=$("#username").val();
       var password=$("#password").val();
       if(username!=""&&username!=null){
            if(password!=""&&password!=null){
                $.ajax({
                    url:'tologin',
                    data:{username:username,password:password},
                    dataType:'json',
                    type:'post',
                    success:function(msg){
                        if(msg){
                            swal("登录成功","","success");
                            window.setTimeout("window.location.href='list/index'",1600);
                        }else{
                            swal("登录出问题啦!","","error");
                        }
                    }
                })
            }else{
                swal("密码不能为空!","","error");
            }
       }else{
           swal("用户名不能为空!","","error");
       }
    }
</script>
<body>
<div class="top_div"></div>
<div style="background: rgb(255, 255, 255); margin: -100px auto auto; border: 1px solid rgb(231, 231, 231); border-image: none; width: 450px; height: 270px; text-align: center;">
    <h3  id="ph">聚乐云内网管理系统</h3>
    <p style="padding: 30px 0px 10px; position: relative;">
        <span id="ulogo" class="glyphicon glyphicon-user"></span>
        <input class="ipt" id="username" type="text" placeholder="请输入用户名">
    </p>
    <p style="position: relative;">
        <span id="plogo" class="glyphicon glyphicon-lock"></span>
        <input class="ipt" id="password" type="password" placeholder="请输入密码">
    </p>
    <div style="height: 50px; line-height: 50px; margin-top: 30px; border-top-color: rgb(231, 231, 231); border-top-width: 1px; border-top-style: solid;">
        <button class="btn btn-primary" style="width: 180px;" onclick="login()">登录</button>
    </div>
</div>
</body>
</html>
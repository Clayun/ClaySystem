/**
 * Created by Mikesam on 2017/7/11.
 */

var handler1 = function (captchaObj) {
    $("#submit").click(function (e) {
        var result = captchaObj.getValidate();
        if (!result) {
            // $("#notice1").show();
            $("#msg").html("请先完成验证");
            $("#msg").css("color","red");
            setTimeout(function () {
                $("#msg").html("");
                /*$("#msg").css("color","green");*/
            }, 2000);
        } else {
            if ($('#user').val()==""){
                $("#msg").html("用户名不能为空");
                $("#msg").css("color","red");
                return;
            }
            if ($('#pwd').val()==""){
                $("#msg").html("密码不能为空");
                $("#msg").css("color","red");
                return ;
            }
            var redirectUrl = $("#redirectUrl").val();
            $.ajax({
                url: '/security/author/doLogin',
                type: 'POST',
                dataType: 'json',
                data: {
                    username: $('#user').val(),
                    password: $('#pwd').val(),
                },
                success: function (data) {
                    if (data.status == '201') {
                        $("#msg").html("登录成功，即将跳转！");
                        $("#msg").css("color","green");
                        var url = "";
                        var token = data.token;
                        var loginType = data.loginType;

                        if (redirectUrl != null && redirectUrl != ''){
                            url = url+redirectUrl;
                        }else{
                            url += "localhost/";
                        }
                        if (url.indexOf('?')!=-1){
                            url += '&';
                        }else{
                            url += '?';
                        }

                        if (token != null && token != ''){
                            url = url+"token="+token;
                        }
                        if (loginType != null && loginType != ''){
                            url = url+"&loginType="+loginType;
                        }
                        window.location.href="http://"+url;
                    } else if (data.status == '510') {
                        $("#msg").css("color","red");
                        $("#msg").html("用户名或密码错误！")
                    }else {
                        $("#msg").css("color","red");
                        $("#msg").html("服务器正在维护！")
                    }
                }
            })
        }
        e.preventDefault();
    });

    // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
    captchaObj.appendTo("#captcha1");
    captchaObj.onReady(function () {
        $("#wait1").hide();
    });
};
$.ajax({
    url: "/security/author/getVerificationCode?datetime=" + (new Date()).getTime(), // 加随机数防止缓存
    type: "get",
    dataType: "json",
    success: function (data) {
        // 调用 initGeetest 初始化参数
        // 参数1：配置参数
        // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
        initGeetest({
            gt: data.gt,
            challenge: data.challenge,
            /* new_captcha: data.new_captcha,*/ // 用于宕机时表示是新验证码的宕机
            /* offline: !data.success,*/ // 表示用户后台检测极验服务器是否宕机，一般不需要关注
            product: "float", // 产品形式，包括：float，popup
            width: "100%"
        }, handler1);
    }
});

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
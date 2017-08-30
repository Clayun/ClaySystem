var check = 0;
var checkedphone = 0;
var phone = "";
var phonever = "";
var handler1 = function (captchaObj) {
    $("#submit").click(function (e) {

        var result = captchaObj.getValidate();
        if (!result) {
            $("#msg").html("请先完成验证！");
            $("#msg").css("color", "red");
            return;
            setTimeout(function () {
                $("#msg").html("")
            }, 2000);
            e.preventDefault();
        } else {

            var user = $("#username").val();
            var pwd = $("#password").val();
            var vpwd = $("#vepassword").val();
            var email = $("#email").val();
            var phone = $("#phone").val();
            if (user == "") {
                $("#msg").html("请先输入用户名！");
                $("#msg").css("color", "red");
                return;
            }
            if (pwd == "") {
                $("#msg").html("请先输入密码！");
                $("#msg").css("color", "red");
                return;
            }
            if (vpwd == "") {
                $("#msg").html("请输入第二次验证密码！");
                $("#msg").css("color", "red");
                return;
            } else if (pwd != vpwd) {
                $("#msg").html("两次输入密码不一致！");
                $("#msg").css("color", "red");
                return;
            }
            if (email == "") {
                $("#msg").html("请输入您注册的邮箱！");
                $("#msg").css("color", "red");
                return;
            }
            /*  var emailRegx = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
             if (emailRegx.test(email)){
             $("#msg").html("请输入正确的邮箱！");
             $("#msg").css("color", "red");
             return;
             }*/
            if (phone == "") {
                $("#msg").html("请输入您的手机号！");
                $("#msg").css("color", "red");
                return;
            }


            $.post("/security/author/verifyRegisterUserInfo", {
                    "userName": $("#username").val(),
                    "phone": $("#phone").val(),
                },
                function (data) {
                    if (data == "n1") {
                        $("#msg").html("用户名已注册！");
                        $("#msg").css("color", "red");
                        return;
                    } else if (data == "p2") {
                        $("#msg").html("手机号已注册！");
                        $("#msg").css("color", "red");
                        return;
                    } else {
                        $("#b1").show();
                        phone = $("#phone").val();
                        $("#phonenum").html(phone);
                    }
                }, 'text');

        }
    });
    // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
    captchaObj.appendTo("#captcha1");
    captchaObj.onReady(function () {
        $("#wait1").hide();
    });


}
//极验验证
$.ajax({
    url: "/security/author/getVerificationCode?dateTime=" + (new Date()).getTime(), // 加随机数防止缓存
    type: "get",
    dataType: "json",
    success: function (data) {
        // 调用 initGeetest 初始化参数
        // 参数1：配置参数
        // 参数2：回调，回调的第一个参数验证码对象，之后可以使用它调用相应的接口
        initGeetest({
            gt: data.gt,
            challenge: data.challenge,
            new_captcha: data.new_captcha, // 用于宕机时表示是新验证码的宕机
            offline: !data.success, // 表示用户后台检测极验服务器是否宕机，一般不需要关注
            product: "float", // 产品形式，包括：float，popup
            width: "312px",
            // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
        }, handler1);
    }
});

//提交验证码，验证
$("#submitverphone").click(function () {
    var vephone = $("#vephone").val();
    alert(vephone);
    if (vephone == "") {
        $("#smsg").html("请输入短信验证码！");
        return;
    }
    $.ajax({
        type: "POST",
        dataType: "text",
        url: '/security/author/verphone',
        data: {verphone: vephone, phonever: phonever},
        success: function (data) {
            if (data == "success") {
                $.post("/security/author/registerUser", {
                    "userName": $("#username").val(),
                    "phone": $("#phone").val(),
                    "email": $("#email").val(),
                    "passWord": $("#password").val(),
                    "vpwd": $("#vepassword").val()
                }, function (data) {
                    if (data) {
                        alert("注册成功！请登录！");
                        var redirectUrl = getQueryString("redirectUrl");//获取redirectUrl
                        var token = getQueryString("token");//获取token
                        var loginType = getQueryString("loginType");//获取logintype
                        var formToken = getQueryString("formToken");//获取formToken
                        var url = "";
                        //判断是否有redirectUrl
                        if (redirectUrl != null && redirectUrl != '') {
                            url = checkParam(url) + "redirectUrl=" + redirectUrl;
                        }
                        //判断是否有token
                        if (token != null && token != '') {
                            url = checkParam(url) + "token=" + token;
                        }
                        //获取loginType
                        if (loginType != null&&loginType!='') {
                            url =checkParam(url) + "loginType="+loginType;
                        }

                        //获取formToken
                        if (formToken != null&&formToken!='') {
                            url = checkParam(url) +"formToken="+formToken;
                        }
                        //跳转路径
                        window.location.href = "http://localhost/security/author/login"+url;
                    } else {
                        alert("注册失败！请冲洗注册！");
                        window.location.href = "http://localhost/security/author/register";
                    }
                }, 'text');
            } else if (data == "failed") {
                $("#msg").html("验证码输入错误！")
            }
        }
    });
});
var wait = 60;
function time(o) {
    if (wait == 59) {
        var pho = $("#phonenum").html();
        $.ajax({
            type: "POST",
            dataType: "json",
            url: '/security/author/valphonewhatever',
            data: {phone: pho},
            success: function (data) {
                if (data != null) {
                    $("#smsg").html("短信已发送至您的手机，请注意查收！");
                    $("#phonenum").html($("#phone").val())
                    jQuery('#b1').show();
                    phonever = data;
                    $("#phonemsg").css("display", "none")

                } else {
                    $("#msg").html("当前手机号已注册！")
                }
            }
        });
    }
    if (wait == 0) {
        o.removeAttribute("disabled");
        o.value = "重新发送";
        wait = 60;
    } else {
        o.setAttribute("disabled", true);
        o.value = "重新发送(" + wait + ")";
        wait--;
        setTimeout(function () {
                time(o)
            },
            1000);
    }
}

document.getElementById("repely").onclick = function () {
    time(this);
}
//获取路径上指定的参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

function checkParam(url) {
    //防止路径符号错误
    if (url.indexOf("?") != -1) {
        url += "&";
    } else {
        url += "?";
    }
    return url;
}
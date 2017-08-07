var check = 0;
var checkedphone = 0;
var handler1 = function (captchaObj) {
    $("#submit").click(function (e) {
        var result = captchaObj.getValidate();
        if (!result) {
            $("#msg").html("请先完成验证！")
            setTimeout(function () {
                $("#msg").html("")
            }, 2000);
            e.preventDefault();
        }else{

            var user = $("#username").val();
            var pwd = $("#password").val();
            var vpwd = $("#vepassword").val();
            var phone = $("#phone").val();

            if(user == ""){$("#msg").html("请先输入用户名！");return;}
            if(pwd == ""){$("#msg").html("请先输入密码！");return;}
            if(vpwd == ""){$("#msg").html("请输入第二次验证密码！");return}
            if(phone == ""){$("#msg").html("请输入您的手机号！");return}

            if(check == 0){
                $.ajax({
                    type: "POST",
                    dataType: "text",
                    url: 'registephone',
                    data:{phone:phone},
                    success: function (data) {
                        if(data == "success"){

                            $("#msg").html("短信已发送至您的手机，请注意查收！");
                            $("#phonenum").html($("#phone").val());
                            jQuery('#b1').show();
                        }else if(data == "failed"){
                            $("#msg").html("当前手机号已注册！")
                        }
                    }
                });
            }else{
                $.ajax({
                    type: "POST",
                    dataType: "text",
                    url: 'registe',
                    data:{phone:checkedphone,user:user,pwd:pwd,vpwd:vpwd},
                    success: function (data) {
                        if(data == "success"){
                            $("#msg").html("注册成功！")
                            window.location.href="/index/home?user="+ hex_md5(user)+"&welcome=";
                        }else if(data == "failed"){
                            $("#msg").html("用户名已存在！")
                        }else if(data == "different"){
                            $("#msg").html("两次密码不一致！")
                        }
                    }
                });
            }

        }
    });
    // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
    captchaObj.appendTo("#captcha1");
    captchaObj.onReady(function () {
        $("#wait1").hide();
    });
};
$.ajax({
    url: "/index/startVal?t=" + (new Date()).getTime(), // 加随机数防止缓存
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

$("#submitphone").click(function () {

        var vephone = $("#vephone").val();
        var phone = $("#phone").val();
        if(vephone == ""){$("#smsg").html("请输入短信验证码！");return}

        $.ajax({
            type: "POST",
            dataType: "text",
            url: 'verphone',
            data: {verphone:vephone},
            success: function (data) {
                if (data == "success") {
                    $("#msg").html("验证成功！")
                    checkedphone = phone;
                    $("#phone").attr("disabled",false);
                    jQuery('#b1').hide();
                    check = 1;
                } else if (data == "failed") {
                    $("#msg").html("验证码输入错误！")
                }
            }
        });
});

var wait=60;
function time(o) {
    if (wait == 0) {
        var phone = $("#phone").val();
        $.ajax({
            type: "POST",
            dataType: "text",
            url: 'registephone',
            data:{phone:phone},
            success: function (data) {
                if(data == "success"){

                    $("#smsg").html("短信已发送至您的手机，请注意查收！");
                    $("#phonenum").html($("#phone").val());
                    jQuery('#b1').show();
                }else if(data == "failed"){
                    $("#msg").html("当前手机号已注册！")
                }
            }
        });
        o.removeAttribute("disabled");
        o.value="重新发送";
        wait = 60;
    } else {
        o.setAttribute("disabled", true);
        o.value="重新发送(" + wait + ")";
        wait--;
        setTimeout(function() {
                time(o)
            },
            1000)
    }
}
document.getElementById("repely").onclick=function(){time(this);}
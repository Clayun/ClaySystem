/**
 * Created by Mikesam on 2017/7/11.
 */
//电话
var phone = "";
//验证码
var phonever = "";
var handler1 = function (captchaObj) {
    $("#submit").click(function (e) {
        var result = captchaObj.getValidate();
        if (!result) {
            // $("#notice1").show();
            $("#msg").html("请先完成验证");
            $("#msg").css("color", "red");
            setTimeout(function () {
                $("#msg").html("");
                /*$("#msg").css("color","green");*/
            }, 2000);
        } else {
            if ($('#user').val() == "") {
                $("#msg").html("用户名不能为空");
                $("#msg").css("color", "red");
                return;
            }
            //验证账号是否存在
            $.ajax({
                url: '/security/author/checkName',
                type: 'POST',
                dataType: 'json',
                data: {
                    username: $('#user').val()
                },
                success: function (data) {
                    if (data == null) {
                        location.reload();
                        $("#msg").css("color", "red");
                        $("#msg").html("账号不存在");

                    }
                    $("#phoneMessage").show();
                    $("#userMessage").css("display", "none");
                    phone = data.phone.toString();
                    phone1 = phone.substr(0, 3)+"****"+phone.substr(8,11);
                    $("#phone").html(phone1);

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


//提交手机号，获取随机码
$("#submitphone").click(function () {
    var vephone = $("#vephone").val();
    alert(vephone);
    $.ajax({
        type: "POST",
        dataType: "text",
        url: '/security/author/verphone',
        data: {verphone: vephone, phonever: phonever},
        success: function (data) {
            if (data == "success") {
                $("#msg").html("验证成功！")
                $("#phoneMessage").css("display", "none");
                $("#passwordMessage").show();
                check = 1;
            } else if (data == "failed") {
                $("#msg").html("验证码输入错误！")
            }
        }
    });
});

//修改密码
$("#submitPassword").click(function () {
    var password = $('#pwd').val();
    var qupwd = $("#qupwd").val();
    if (password == "") {
        $("#msg").html("密码不能为空");
        $("#msg").css("color", "red");
        return;
    }
    if (qupwd == "") {
        $("#msg").html("密码不能为空");
        $("#msg").css("color", "red");
        return;
    }
    if (password != qupwd) {
        $("#msg").html("密码不一致！");
    }

    $.ajax({
        type: "POST",
        dataType: "text",
        url: '/security/author/updatePassword',
        data: {password: password, phone: phone},
        success: function (data) {
            if (data == "success") {
                alert("修改成功，请登录！");
                window.location.href = "http://localhost/security/author/login";
            } else {
                alert("修改失败！")
            }
        }
    });
})

var wait = 60;
function time(o) {
    if (wait == 59) {
        /*var phone = $("#phonenum").html();*/
        if (phone == "") {
            return;
        }
        $.ajax({
            type: "POST",
            dataType: "text",
            url: '/security/author/valphonewhatever',
            data: {phone: phone},
            success: function (data) {
                if (data != null) {
                    alert(data);
                    phonever = data;
                } else {
                    $("#msg").html("验证码发送失败！");
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
            1000)
    }
}
document.getElementById("repely").onclick = function () {
    time(this);
}

//图片验证
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
    if (r != null) return unescape(r[2]);
    return null; //返回参数值
}
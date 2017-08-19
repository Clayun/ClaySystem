/**
 * Created by Mikesam on 2017/7/11.
 */

var handler1 = function (captchaObj) {
    $("#submit").click(function (e) {
        var result = captchaObj.getValidate();
        if (!result) {
            $("#msg").html("请先完成验证！")
            setTimeout(function () {
                $("#msg").html("请使用您的用户名或手机号码登录")
            }, 2000);
            e.preventDefault();
        }else{
            var user = $("#user").val();
            var pwd = $("#pwd").val();
            if(user != "" && pwd != ""){
                $.ajax({
                    type: "POST",
                    dataType: "text",
                    url: '/ucenter/auth',
                    data:{user:user,pwd:pwd},
                    success: function (data) {
                        if(data == "success"){
                            $("#msg").css("color","green");
                            $("#msg").html("登陆成功")

                            if(getUrlParam('from_url') == null){
                                window.location.href="/index/portal?user="+ hex_md5(user)+"&welcome=";
                            }else if(getUrlParam('from_url') != ""){

                                if(getUrlParam('selectproduct_mc') != "" && getUrlParam('selectproduct_mc') != null){
                                    window.location.href="/"+getUrlParam('from_url')+"?selectproduct_mc="+getUrlParam('selectproduct_mc');
                                }else if(getUrlParam('selectproduct_esc') != "" && getUrlParam('selectproduct_esc') != null){
                                    window.location.href="/"+getUrlParam('from_url')+"?selectproduct_esc="+getUrlParam('selectproduct_esc');
                                }
                            }
                            else{
                                window.location.href="/index/portal?user="+ hex_md5(user)+"&welcome=";
                            }

                        }else if(data == "failed"){
                            $("#msg").css("color","red");
                            $("#msg").html("用户名或密码错误！")
                        }else if(data  == "unregisted"){
                            $("#msg").css("color","red");
                            $("#msg").html("用户名未注册！")
                        }else{
                            $("#msg").css("color","red");
                            $("#msg").html("服务器正在维护！")
                        }
                    }
                });
            }else{
                $("#msg").css("color","red");
                $("#msg").html("用户名或密码为空！")
            }
        }
    });
    // 将验证码加到id为captcha的元素里，同时会有三个input的值用于表单提交
    captchaObj.appendTo("#captcha1");
    captchaObj.onReady(function () {
        $("#wait1").hide();
    });
    // 更多接口参考：http://www.geetest.com/install/sections/idx-client-sdk.html
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
            width: "312px"
            // 更多配置参数请参见：http://www.geetest.com/install/sections/idx-client-sdk.html#config
        }, handler1);
    }
});

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}
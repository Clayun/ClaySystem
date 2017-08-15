/**
 * Created by Mikesam on 2017/7/20.
 */
$(function () {
    $('.single-slider').jRange({
        from: 1,//开始于
        to: 12,//结束于
        step: 1,//一次滑动多少
        scale: ['1个月', '2个月', '3个月', '4个月', '5个月', '6个月', '7个月', '8个月', '9个月', '10个月', '11个月', '1年'],//分割点
        format: '%s',//格式化格式
        width: 1000,//宽度
        showLabels: true,
        showScale: true
    });
    $('.range-slider').jRange({
        from: 1,
        to: 12,
        step: 1,
        scale: ['1个月', '2个月', '3个月', '4个月', '5个月', '6个月', '7个月', '8个月', '9个月', '10个月', '11个月', '1年'],
        format: '%s',
        width: 1000,
        showLabels: true,
        isRange: true//是否显示区间
    });
    //计算优惠金额
    $(".slider-container").click(function () {
        alert("sssss");
        var check_val = "";
        $("input:checkbox[name='ids']:checked").each(function () {
            check_val += "," + $(this).val();
        });
        check_val = check_val.substring(1);
        alert(check_val)
        var id = $("input:radio:checked").val();
        alert(id)
        var month = $(".single-slider").val();
        var entityPrice = $("#entityPrice").html();
        if (check_val.length < 0) {
            check_val += "1";
        }
        if (id == "undefined" || id == "" || id == null) {
            id = 1;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: 'getorderMonthPrice',
            data: {month: month, entityPrice: entityPrice, check_val: check_val, id: id},
            success: function (data) {
                $("#price").html(data);
            }
        });
    });
    //总金额会显
    var aa = $(".single-slider").val();
    var serverId = $("#entityPrice").html();
    $.ajax({
        type: "POST",
        dataType: "json",
        url: 'getMonthPrice',
        data: {aa: aa, serverId: serverId},
        success: function (data) {
            $("#price").html(data);
        }
    });
   /* $.ajax({
        type: "POST",
        dataType: "text",
        url: '/getUserPhone',
        data:{date:1},
        success: function (data) {
            $("#phonenum").html(data);
        }
    });*/

});

$("#paynow").click(function () {
    jQuery('#b1').show();
    $("#smsg").hide();
    $("phonemessage").show();
    $("#vephone").attr("placeholder", "请输入手机号！");
});

$("#submitphone").click(function () {
    var vephone = $("#vephone").val();
    var phone = $("#phone").val();
    if (vephone == "") {
        $("#smsg").html("请输入短信验证码！");
        return
    }
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/verphone',
        data: {verphone: vephone},
        success: function (data) {
            alert(data)
            if (data) {
                $("#msg").html("验证成功！")
                checkedphone = phone;
                jQuery('#b1').hide();
                var ordersUuid = $("#entityId").html();
                var uuid = $("#uuid").val();
                var theActualAmount = $("#price").html();
                var month = $(".single-slider").val();
                var serverId = $("#entityId").html();
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: '/payment',
                    data: {ordersUuid: ordersUuid, uuid: uuid, theActualAmount: theActualAmount, month: month},
                    success: function (data) {
                        if (data) {
                            alert("支付成功！");
                            window.location.href = "http://www.baidu.com";
                        } else {
                            alert("支付失败！余额不足！")
                        }
                    }
                });
                check = 1;
            } else {
                $("#msg").html("验证码输入错误！")
            }
        }
    });
});

var wait = 60;
function time(o) {
    var regex = /^1[3-8]+\d{9}$/;
    var vephone = $("#vephone").val().trim();
    if (!regex.test(vephone)) {
        alert("请输入正确的手机号！！！");
        return
    }


    if (wait == 59) {
        var phone = $("#vephone").val();
        $.ajax({
            type: "POST",
            dataType: "text",
            url: '/valphonewhatever',
            data: {phone: phone},
            success: function (data) {
                alert(data);
                if (data == "success") {
                    $("#smsg").show();
                    $("#phonemessge").css("display", "none")
                    $("#vephone").val("");
                    $("#vephone").attr("placeholder", "请输入验证码！");
                    $("#smsg").html("短信已发送至您的手机，请注意查收！");
                    jQuery('#b1').show();
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

//计算价格
function selectedInfo() {
    alert("sssss");
    var check_val = "";
    $("input:checkbox[name='ids']:checked").each(function () {
        check_val += "," + $(this).val();
    });
    check_val = check_val.substring(1);
    alert(check_val)
    var id = $("input:radio:checked").val();
    alert(id)
    var month = $(".single-slider").val();
    var entityPrice = $("#entityPrice").html();
    if (check_val.length < 0) {
        check_val += "1";
    }
    if (id == "undefined" || id == "" || id == null) {
        id = 1;
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: 'getorderMonthPrice',
        data: {month: month, entityPrice: entityPrice, check_val: check_val, id: id},
        success: function (data) {
            $("#pzPrice").html("优惠后的价格：");
            $("#price").html(data);
        }
    });
}
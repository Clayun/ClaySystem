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
        var check_val = "";
        $("input:checkbox[name='ids']:checked").each(function () {
            check_val += "," + $(this).val();
        });
        check_val = check_val.substring(1);
        var id = $("input:radio:checked").val();
        var month = $(".single-slider").val();
        var entityPrice = $("#pricePerMonth").html();
        if (check_val.length < 0) {
            check_val += "1";
        }
        if (id == "undefined" || id == "" || id == null) {
            id = 1;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: '/pay/getorderMonthPrice',
            data: {month: month, entityPrice: entityPrice, check_val: check_val, id: id},
            success: function (data) {
                $("#price").html(data);
            }
        });
    });
    //总金额会显
    var aa = $(".single-slider").val();
    var serverId = $("#pricePerMonth").html();
    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/pay/getMonthPrice',
        data: {aa: aa, serverId: serverId},
        success: function (data) {
            $("#price").html(data);
        }
    });

    var uuid = $("#uuid").val();
    $.ajax({
        type: "POST",
        dataType: "text",
        url: '/pay/getUserPhone',
        data:{uuid:uuid},
        success: function (data) {
            $("#phonenum").html(data);
        }
    });
});

$("#paynow").click(function () {
    jQuery('#b1').show();
    $("#smsg").hide();
    $("phonemessage").show();
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
        url: '/pay/verphone',
        data: {verphone: vephone},
        success: function (data) {
            if (data) {
                $("#msg").html("验证成功！")
                checkedphone = phone;
                jQuery('#b1').hide();
                var ordersUuid = $("#entityId").html();
                var uuid = $("#uuid").val();
                var theActualAmount = $("#price").html();
                var month = $(".single-slider").val();
                var pricePerMonth = $("#pricePerMonth").html();
                var ser_uuid = $("#ser_uuid").html();
                var check_val = "";
                $("input:checkbox[name='ids']:checked").each(function () {
                    check_val += "," + $(this).val();
                });
                check_val = check_val.substring(1);
                var id = $("input:radio:checked").val();
                var entityPrice = $("#pricePerMonth").html();
                if (check_val.length < 0) {
                    check_val += "0";
                }
                if (id == "undefined" || id == "" || id == null) {
                    id = 0;
                }
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: '/pay/payment',
                    data: {ordersUuid: ordersUuid, uuid: uuid, theActualAmount: theActualAmount, month: month,pricePerMonth:pricePerMonth,check_val:check_val,id:id,ser_uuid:ser_uuid},
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
    if (wait == 59) {
        var phone = $("#phonenum").html();
        $.ajax({
            type: "POST",
            dataType: "text",
            url: '/pay/valphonewhatever',
            data: {phone: phone},
            success: function (data) {
                if (data == "success") {
                    $("#smsg").show();
                    $("#phonemessge").css("display", "none")
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
    var check_val = "";
    $("input:checkbox[name='ids']:checked").each(function () {
        check_val += "," + $(this).val();
    });
    check_val = check_val.substring(1);
    var id = $("input:radio:checked").val();
    var month = $(".single-slider").val();
    var entityPrice = $("#pricePerMonth").html();
    if (check_val== "") {
        check_val += "";
    }
    if (id == "undefined" || id == "" || id == null) {
        id = 0;
    }

    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/pay/getorderMonthPrice',
        data: {month: month, entityPrice: entityPrice, check_val: check_val, id: id},
        success: function (data) {
            $("#pzPrice").html("优惠后的价格：");
            $("#price").html(data);
        }
    });
}
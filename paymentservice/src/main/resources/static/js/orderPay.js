/**
 * Created by Mikesam on 2017/7/20.
 */
$(function(){
    $('.single-slider').jRange({
        from: 0,//开始于
        to: 12,//结束于
        step: 1,//一次滑动多少
        scale: [0,'1个月','2个月','3个月','4个月','5个月','6个月','7个月','8个月','9个月','10个月','11个月','1年'],//分割点
        format: '%s',//格式化格式
        width: 1000,//宽度
        showLabels: true,
        showScale: true
    });
    $('.range-slider').jRange({
        from: 0,
        to: 12,
        step: 1,
        scale: [0,'1个月','2个月','3个月','4个月','5个月','6个月','7个月','8个月','9个月','10个月','11个月','1年'],
        format: '%s',
        width: 1000,
        showLabels: true,
        isRange : true//是否显示区间
    });

    $(".slider-container").click(function(){
        var aa = $(".single-slider").val();
           var serverId = $("#entityPrice").html();
           $.ajax({
               type: "POST",
               dataType: "json",
               url: 'getorderMonthPrice',
               data:{aa:aa,serverId:serverId},
               success: function (data) {
                   $("#price").html(data);
               }
           });
    });

    $.ajax({
        type: "POST",
        dataType: "text",
        url: '/getUserPhone',
        data:{date:1},
        success: function (data) {
            $("#phonenum").html(data);
        }
    });

});

$("#paynow").click(function(){
    jQuery('#b1').show();
});

$("#submitphone").click(function () {
    var vephone = $("#vephone").val();
    var phone = $("#phone").val();
    if(vephone == ""){$("#smsg").html("请输入短信验证码！");return}

    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/verphone',
        data: {verphone:vephone},
        success: function (data) {
            if (data) {
                $("#msg").html("验证成功！")
                checkedphone = phone;
                jQuery('#b1').hide();
                var uuid = $("#entityId").html();
                var theActualAmount = $("#price").html();
                var aa = $(".single-slider").val();
                var serverId = $("#entityId").html();
                $.ajax({
                    type: "POST",
                    dataType: "json",
                    url: '/payment',
                    data:{uuid:uuid,theActualAmount:theActualAmount},
                    success: function (data) {
                        if(data){alert("支付成功！");window.location.href="www.baidu.com";}else{alert("支付失败！余额不足！")}
                    }
                });
                check = 1;
            } else{
                $("#msg").html("验证码输入错误！")
            }
        }
    });
});

var wait=60;
function time(o) {
    if (wait == 59){
        var phone = $("#phonenum").html();
        $.ajax({
            type: "POST",
            dataType: "text",
            url: '/valphonewhatever',
            data:{phone:phone},
            success: function (data) {
                if(data == "success"){

                    $("#smsg").html("短信已发送至您的手机，请注意查收！");

                    jQuery('#b1').show();
                }
            }
        });
    }

    if (wait == 0) {

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
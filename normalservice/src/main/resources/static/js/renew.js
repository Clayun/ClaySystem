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
        var serverId = $("#entityId").html();
        $("#price").html("正在计算价格....");
        $.ajax({
            type: "POST",
            dataType: "text",
            url: '/data/getRenewVpsPrice',
            data:{month:aa,serverid:serverId},
            success: function (data) {
                $("#price").html(data);
            }
        });

    });


});

$("#paynow").click(function(){
    var aa = $(".single-slider").val();
    var serverId = $("#entityId").html();
    $.ajax({
        type: "POST",
        dataType: "text",
        url: '/data/payrenewecs',
        data:{month:aa,serverid:serverId},
        success: function (data) {
            if(data == "success"){alert("支付成功！");window.location.href="/console/control/ecs";}else{alert("支付失败！余额不足！")}


        }
    });
});



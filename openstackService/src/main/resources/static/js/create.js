// JavaScript Document
// $("#CLOUDMC-BUTTON").click(function(){
// 		$(".create-table-left").css('color','#0099FF');
// 		$(".create-table-left").css('background','#FFF');
// 		$(".create-table-right").css('color','#FFF');
// 		$(".create-table-right").css('background','#777777');
// 		$("#VPS").css('display','none');
// 		$("#CLOUDMC").css('display','block');
//
// });
$("#VPS-BUTTON").click(function(){
		$(".create-table-right").css('color','#0099FF');
		$(".create-table-right").css('background','#FFF');
		$(".create-table-left").css('color','#FFF');
		$(".create-table-left").css('background','#777777');
		$("#CLOUDMC").css('display','none'); 
		$("#VPS").css('display','block'); 
	
});

function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); //构造一个含有目标参数的正则表达式对象
    var r = window.location.search.substr(1).match(reg);  //匹配目标参数
    if (r != null) return unescape(r[2]); return null; //返回参数值
}

$(document).ready(function () {
    if(getUrlParam('selectproduct_mc') != null){
        var arr = getUrlParam('selectproduct_mc').split(",");
        for(var i = 0; i< arr.length;i++){
            if(arr[i] != "undefined"){
                console.info(arr[i])
                var entity = arr[i].substr(0,arr[i].length-1);
                if($("#"+entity+1).attr("class")=="create-mc-items-right-box-selected"){
                    $("#"+entity+1).attr("class","create-mc-items-right-box")
                }
                $("#"+arr[i]).attr("class","create-mc-items-right-box-selected");
            }

        }
    }else if(getUrlParam('selectproduct_esc') != null){
        var arr = getUrlParam('selectproduct_esc').split(",");
        for(var i = 0; i< arr.length;i++){
            if(arr[i] != "undefined"){
                console.info(arr[i])
                var entity = arr[i].substr(0,arr[i].length-1);
                if($("#"+entity+1).attr("class")=="create-cloud-items-right-box-selected"){
                    $("#"+entity+1).attr("class","create-cloud-items-right-box")
                }
                $("#"+arr[i]).attr("class","create-cloud-items-right-box-selected");
            }

        }
    }
})
function selectProduct(max,type,selected){
	for(var i = 1; i<= max ; i++){
		if($("#"+type+"-"+i).attr("class")=="create-cloud-items-right-box-selected"){
			$("#"+type+"-"+i).attr("class","create-cloud-items-right-box")
		}
	}
	$("#"+type+"-"+selected).attr("class","create-cloud-items-right-box-selected")
	
}

function selectMCProduct(max,type,selected){
    for(var i = 1; i<= max ; i++){
        if($("#"+type+"-"+i).attr("class")=="create-mc-items-right-box-selected"){
            $("#"+type+"-"+i).attr("class","create-mc-items-right-box")
        }
    }
    $("#"+type+"-"+selected).attr("class","create-mc-items-right-box-selected")

}

$(document).ready(function(){
    $.ajax({
        type: "GET",
        dataType: "json",
        url: '/ecs/data/getOsType',
        success: function (data) {
			data=eval(data);

			for(var i=0;i<data.length;i++){

				$("#choose-core").append("<option value='"+data[i].id+"'>"+data[i].osType+"</option>");
			}
        }
    });
});

$("#choose-core").change(function(){
    $("#choose-kid").empty();
    if($("#choose-core").val() != 0){
        $.ajax({
            type: "GET",
            dataType: "json",
            url: '/ecs/data/getOsName',
            data:{typeId:$("#choose-core").val()},
            success: function (data) {
                data=eval(data);

                for(var i=0;i<data.length;i++){

                    $("#choose-kid").append("<option value='"+data[i].osName+"'>"+data[i].osName+"</option>");
                }
            }
        });
	}else{
        $("#choose-kid").append("<option>请选择</option>");
	}


});

$(document).ready(function(){
    $.ajax({
        type: "GET",
        dataType: "json",
        url: 'getMCType',
        success: function (data) {
            data=eval(data);

            for(var i=0;i<data.length;i++){

                $("#choose-core-mc").append("<option value='"+data[i].id+"'>"+data[i].apptype+"</option>");
            }
        }
    });
});

$("#choose-core-mc").change(function(){
    $("#choose-kid-mc").empty();
    if($("#choose-core-mc").val() != 0){
        $.ajax({
            type: "GET",
            dataType: "json",
            url: 'getMCName',
            data:{sid:$("#choose-core-mc").val()},
            success: function (data) {
                data=eval(data);

                for(var i=0;i<data.length;i++){

                    $("#choose-kid-mc").append("<option value='"+data[i].appname+"'>"+data[i].appname+"</option>");
                }
            }
        });
    }else{
        $("#choose-kid").append("<option>请选择</option>");
    }


});

function getvpsprice() {
    $("#vpsprice").html("正在计算价格..");
	var pz = '';
    $(".create-cloud-items-right-box-selected").each(function(index){
        arr = $(this).text().replace(",","").split(" ");
        pz = pz+","+arr[0]
    });

    $.ajax({
        type: "post",
        dataType: "json",
        url: '/ecs/data/getEcsPrice',
        data:{Ecspz:pz},
        success: function (data) {
			$("#vpsprice").html(" ￥"+data+" /月");
        }
    });
}

function getcloudmcprice() {
    $("#cloudmcprice").html("正在计算价格..");
    var pz = '';
    $(".create-mc-items-right-box-selected").each(function(index){
        arr = $(this).text().split(" ");
        pz = pz+","+arr[0]
    });

    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/data/getCloudMcPrice',
        data:{MCPZ:pz},
        success: function (data) {
            $("#cloudmcprice").html(" ￥"+data+" /月");
        }
    });
}

function clickbuyMC() {

    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/ucenter/checklogin',
        data:{MCPZ:1},
        success: function (data) {
            if(data == "success"){
                alert("登陆成功")
                buymc();
            }else if(data == "failed"){
                window.location.href="/ucenter/login?from_url=index/create";
            }

        }
    });
}

function clickbuyvps() {

    $.ajax({
        type: "POST",
        dataType: "json",
        url: '/ucenter/checklogin',
        data:{MCPZ:1},
        success: function (data) {
            if(data == "success"){
                alert("success")
                buyvps();
            }else if(data == "failed"){
                window.location.href='/ucenter/login?from_url=index/create';
            }

        }
    });
}

function buymc() {
    var pz = '';
    $(".create-mc-items-right-box-selected").each(function(index){
        arr = $(this).text().split(" ");
        pz = pz+","+arr[0]
    });
    var name = $("#mcservername").val();
    var core = $('#choose-kid-mc option:selected').val();

    var selected;
    $(".create-mc-items-right-box-selected").each(function (index) {
        arr = $(this).attr("id").split(" ");
        selected = selected+","+arr[0]
    })

    $.ajax({
        type: "POST",
        dataType: "text",
        url: '/data/createmcserver',
        data:{mcpz:pz,name:name,core:core},
        success: function (data) {
            //购买结果
            if(data == "success"){
                $("#smsg2").html("尊敬的用户您好，订单已创建成功，请在控制台支付！");
                $("#submitphone2").css("display","none");
                $("#submitphone2queding").css("display","block");
                jQuery('#b2').show();
            }else if(data == "moneyfailed"){
                $("#smsg2").html("您好，系统正在维护，请稍后再试！");
                $("#submitphone2").css("display","none");
                $("#submitphone2queding").css("display","block");
                jQuery('#b2').show();
            }else if(data == "nologin"){
                window.location.href='/ucenter/login?from_url=index/create&selectproduct_mc='+selected;
            }else if(data == "nocore"){
                $("#smsg2").html("尊敬的用户您好，您未选择MineCraft服务器的核心！");
                $("#submitphone2").css("display","none");
                $("#submitphone2queding").css("display","block");
                jQuery('#b2').show();
            }else if(data == "noname"){
                $("#smsg2").html("尊敬的用户您好，您未输入服务器名称");
                $("#submitphone2").css("display","none");
                $("#submitphone2queding").css("display","block");
                jQuery('#b2').show();
            }else{
                $("#smsg2").html("服务器正在维护");
                jQuery('#b2').show();
            }
        }
    });


}

function sendEcsOrder() {
    var pz = '';
    $(".create-cloud-items-right-box-selected").each(function(index){
        arr = $(this).text().replace(",","").split(" ");
        pz = pz+","+arr[0]
    });
    var core = $('#choose-kid option:selected') .val();
    var pwd = $("#xtmm").val();

    var selected;
    $(".create-cloud-items-right-box-selected").each(function (index) {
        arr = $(this).attr("id").split(" ");
        selected = selected+","+arr[0]
    })

    $.ajax({
        type: "POST",
        dataType: "text",
        url: '/ecs/data/createEcsOrder',
        data:{ecspz:pz,image:core,pwd:pwd},
        success: function (data) {
            var timestamp = new Date().getTime();
            window.location.href="http://localhost/pay/paymentInterface?data="+data+"&token="+getQueryString("token")+"&formToken="+timestamp;
        }
    });

}



//获取路径上指定的参数
function getQueryString(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

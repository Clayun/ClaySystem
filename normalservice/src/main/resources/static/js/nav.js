$(".nav").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
})

$(".nav").mouseout(function(){
	$(".nav").css("background","rgba(0,0,0,0)");
})

//第一个
$("#firstpage").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#firstpage-nav").css("display","block").fadeIn(1000);
})
$("#firstpage-nav").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#firstpage-nav").css("display","block").fadeIn(1000);
})

$("#firstpage-nav").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#firstpage-nav").css("display","none");
})

$("#firstpage").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#firstpage-nav").css("display","none");
})

//ecs部分
$("#ecspage").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#ecs-nav").css("display","block").fadeIn(1000);
})
$("#ecs-nav").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#ecs-nav").css("display","block").fadeIn(1000);
})

$("#ecs-nav").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#ecs-nav").css("display","none");
})

$("#ecspage").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#ecs-nav").css("display","none");
})

//第三个
$("#thirdpage").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#third-nav").css("display","block").fadeIn(1000);
})
$("#third-nav").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#third-nav").css("display","block").fadeIn(1000);
})

$("#third-nav").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#third-nav").css("display","none");
})

$("#thirdpage").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#third-nav").css("display","none");
})


//第四个
$("#fthpage").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#fth-nav").css("display","block").fadeIn(1000);
})
$("#fth-nav").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#fth-nav").css("display","block").fadeIn(1000);
})

$("#fth-nav").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#fth-nav").css("display","none");
})

$("#fthpage").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#fth-nav").css("display","none");
})

//第五个
$("#fifthpage").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#fifth-nav").css("display","block").fadeIn(1000);
})
$("#fifth-nav").mouseover(function(){
	$(".nav").css("background","rgba(0,0,0,0.5)");
	$("#fifth-nav").css("display","block").fadeIn(1000);
})

$("#fifth-nav").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#fifth-nav").css("display","none");
})

$("#fifthpage").mouseout(function(){
	$(".nav").css("background-color","rgba(0,0,0,0)");
	$("#fifth-nav").css("display","none");
})
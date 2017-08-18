// JavaScript Document
$(document).ready(function() { 

		setInterval('runbanner()',5000);
		
	}); 
	
	function runbanner(){
		for(var i = 1 ; i<= 3 ; i++){
			if($("#clan-"+i).css("display")=="block"){
				$("#clan-"+i).animate({left:"95%", opacity:"0.8"},15000);
				$("#clan-"+i).css('display','none'); 
				$("#clan-"+i+"-"+i).css('color','#555'); 
				if(i==3){	
					$("#clan-1").css('display','block'); 
					$(".banner").css('background-color','#171b1e');
					$("#clan-"+1+"-"+1).css('color','#EEE'); 
				}else if(i==2){
					$("#clan-"+(i+1)).css('display','block');
					$(".banner").css('background-color','#312751');
					$("#clan-"+(i+1)+"-"+(i+1)).css('color','#EEE');
				}else if(i==1){
					$("#clan-"+(i+1)).css('display','block');
					$(".banner").css('background-color','#022728');
					$("#clan-"+(i+1)+"-"+(i+1)).css('color','#EEE');
				}
				break;
			}
			
		}
		
		
	}
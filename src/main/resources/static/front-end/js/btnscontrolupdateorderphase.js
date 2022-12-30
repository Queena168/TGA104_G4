
//===========================================================================
	//儲存施工狀態下拉選單之值
// var select = document.getElementById("selection");
//     select.onchange = function() {
// 	 // 儲存下拉式選單的選擇
//     localStorage.setItem("selectoption", select.value);

// }
// var selectoption = localStorage.getItem("selectoption");
//     if (selectoption) {
//     select.value = selectoption;
// }
    
    //=========================================================
    	
   //儲存付款狀態下拉選單之值 	
// var selectpayment = document.getElementById("selectionpayment");
//     selectpayment.onchange = function() {
// 	 // 儲存下拉式選單的選擇
//     localStorage.setItem("selectoptionpayment", selectpayment.value);

// }
// var selectoptionpayment = localStorage.getItem("selectoptionpayment");
//     if (selectoptionpayment) {
//     	selectpayment.value = selectoptionpayment;
// }

//===============================================================
	//點擊施工狀態下拉選單及更新施工狀態下拉選單
var btn1 = document.getElementById("btn1");
var select1 = document.getElementById("selection");
var textarea = document.getElementById("t1");
var form = document.getElementById("form");
//var form2 = document.getElementById("form2");
btn1.addEventListener("click",function(){
	if(select1.hasAttribute("disabled")){
		select1.removeAttribute("disabled");
		textarea.removeAttribute("disabled");
	}else{
		form.setAttribute("action","SendOrderPhase");
		form.submit();
	}
		
});	
	
	
//===============================================================	
	//點擊付款狀態下拉選單及更新付款狀態下拉選單
var btn2 = document.getElementById("btn2");
var select2 = document.getElementById("selectionpayment");
//var form1 = document.getElementById("form1");
btn2.addEventListener("click",function(){
	if(select2.hasAttribute("disabled")){
		select2.removeAttribute("disabled");
	}else{
		form.setAttribute("action","SendOrderPayment");
		form.submit();
	}
		
});
//================================================================
	//實作更新裝潢進度及付款進度按鈕隱藏及出現
	
	
function DisplayAndHiddenBtn(btnName, type) {
	 var currentinputbutton = document.getElementById(btnName);
   if (type == 'true') {
	   //currentinputbutton.style.display = "inline-block"; //style中的display且橫向排列属性
	   document.getElementById("btn1").style.display = "none";	
	   document.getElementById("btn2").style.display = "none";
   }else{
	   currentinputbutton.style.display = "inline-block"; 
   }
	 
}






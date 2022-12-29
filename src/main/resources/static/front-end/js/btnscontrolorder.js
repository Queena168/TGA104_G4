
//控制結案按鈕隱藏及出現
function DisplayAndHiddenBtn(btnName, type) {
	 var currentinputbutton = document.getElementById(btnName);
   if (type == 'false') {
	   //"inline-block",style中的display且橫向排列属性
	   document.getElementById("btn").style.display = "inline-block";	  
   }else{
	   currentinputbutton.style.display = "none"; 
   }
	 
}


//=====================================================================================
	//控制查看進度按鈕隱藏及出現
function DisplayAndHiddenBtn2(btnName, type) {
   if (type == '同意合約') {
	   //"inline-block",style中的display且橫向排列属性	 
	   document.getElementById("btn2").style.display = "inline-block";	
   }else{
	   document.getElementById("btn2").style.display = "none";
   }
   	 
}	



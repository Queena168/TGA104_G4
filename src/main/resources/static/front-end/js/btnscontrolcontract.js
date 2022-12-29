
function DisplayAndHiddenBtn(btnName, type) {
	 var currentinputbutton = document.getElementById(btnName);
   if (type == '未進行合約') {
	   //currentinputbutton.style.display = "inline-block"; //style中的display且橫向排列属性
	   document.getElementById("showorhidden2").style.display = "none";
   }else if(type == '退回合約'){
	   document.getElementById("showorhidden1").style.display = "none";
	   
   }else{
	   currentinputbutton.style.display = "none"; 
   }
	 
}


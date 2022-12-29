

function DisplayAndHiddenBtn(btnName, type) {
	var currentinputbutton = document.getElementById(btnName);
	if (type == '未報價') {
		//currentinputbutton.style.display = "inline-block"; //style中的display且橫向排列属性
		document.getElementById("showorhidden2").style.display = "none";
	} else if (type == '退回報價') {
		document.getElementById("showorhidden1").style.display = "none";

	} else {
		currentinputbutton.style.display = "none";
	}

}



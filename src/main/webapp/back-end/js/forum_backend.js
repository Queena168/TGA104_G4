// 檢舉管理 & 所有文章列表
document.querySelectorAll(".openButton").forEach(function(btn) {
	btn.addEventListener("click", function() {
		var popupwindow = document.getElementsByClassName("pop");
		for (var index = 0; index < popupwindow.length; index++) {
			popupwindow[index].setAttribute("style", "display:none");
		}
		this.nextElementSibling.style.display = "block"
	});
});

document.querySelectorAll(".close_btn").forEach(function(btn) {
	btn.addEventListener("click", function() {
		this.parentElement.parentElement.style.display = "none"
	});
});

document.querySelectorAll(".review_btn").forEach(function(btn) {
	btn.addEventListener("click", function() {
		if (this.parentElement.firstElementChild.value == "") {
			alert("請選擇處理方式");
		} else {
			this.parentElement.parentElement.firstElementChild.submit();
		}
	});
});
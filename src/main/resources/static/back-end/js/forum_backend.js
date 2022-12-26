//檢舉管理 & 所有文章列表
document.querySelectorAll(".openButton").forEach(function(btn) {
	btn.addEventListener("click", function() {
		var popupwindow = document.querySelectorAll(".pop");
		for (var i = 0; i < popupwindow.length; i++) {
			popupwindow[i].setAttribute("style", "display:none");
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
		$.ajax({
			type: "POST",
			url: "forumreport.do",
			data: $("#review_form").serialize(),
			dataType: "JSON",
			success: function(data) {
				if ("error" in data) {
					alert(data.error);
				} else {
					window.location.href = data.success;
				}
			},
		});
	});
});
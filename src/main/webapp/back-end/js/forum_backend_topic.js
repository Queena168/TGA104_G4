//討論區管理
document.querySelector("#add_btn").addEventListener("click", function() {
	document.getElementById("add_topic_div").style.display = "block";
	document.getElementById("update_topic_div").style.display = "none";
	document.getElementById("add_topic_name").focus();
});

document.querySelectorAll(".show_update").forEach(function(btn) {
	btn.addEventListener("click", function() {
		document.getElementById("update_topic_div").style.display = "block";
		document.getElementById("add_topic_div").style.display = "none";
		document.getElementById("update_topic_name").focus();
		document.getElementById("update_topic_no").value = this.parentElement.parentElement.firstElementChild.innerText;
		document.getElementById("update_topic_name").value = this.parentElement.parentElement.firstElementChild.nextElementSibling.innerText;
		document.getElementById("update_admin_no").value = this.parentElement.previousElementSibling.innerText;
	});
});

document.querySelector("#add_submit").addEventListener("click", function() {
	if (document.getElementById("add_topic_name").value == "") {
		alert("請輸入標題")
	} else {
		document.getElementById("add_topic_form").submit();
		alert("新增討論區成功");
	}
});

document.querySelector("#update_submit").addEventListener("click", function() {
	if (document.getElementById("update_topic_name").value == "") {
		alert("請輸入標題")
	} else {
		document.getElementById("update_topic_form").submit();
		alert("修改討論區成功");
	}
});
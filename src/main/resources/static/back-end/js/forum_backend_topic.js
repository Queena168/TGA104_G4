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
	$.ajax({
		type: "POST",
		url: "forumtopic.do",
		data: $("#add_topic_form").serialize(),
		dataType: "JSON",
		success: function(data) {
			if ("error" in data) {
				alert(data.error);
			} else {
				alert("新增討論區成功");
				window.location.href = data.success;
			}
		},
	});
});

document.querySelector("#update_submit").addEventListener("click", function() {
	$.ajax({
		type: "POST",
		url: "forumtopic.do",
		data: $("#update_topic_form").serialize(),
		dataType: "JSON",
		success: function(data) {
			if ("error" in data) {
				alert(data.error);
			} else {
				alert("修改討論區成功");
				window.location.href = data.success;
			}
		},
	});
});
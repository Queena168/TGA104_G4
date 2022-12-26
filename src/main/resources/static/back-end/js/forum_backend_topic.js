//討論區管理
document.querySelector("#add_btn").addEventListener("click", function() {
	document.querySelector("#add_topic_div").style.display = "block";
	document.querySelector("#update_topic_div").style.display = "none";
	document.querySelector("#add_topic_name").focus();
});

document.querySelectorAll(".show_update").forEach(function(btn) {
	btn.addEventListener("click", function() {
		document.querySelector("#update_topic_div").style.display = "block";
		document.querySelector("#add_topic_div").style.display = "none";
		document.querySelector("#update_topic_name").focus();
		document.querySelector("#update_topic_no").value = this.parentElement.parentElement.firstElementChild.innerText;
		document.querySelector("#update_topic_name").value = this.parentElement.parentElement.firstElementChild.nextElementSibling.innerText;
		document.querySelector("#update_admin_no").value = this.parentElement.previousElementSibling.innerText;
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
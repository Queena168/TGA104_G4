var url = "forumreply.do";

//POST modify button
document.querySelector(".post_modify_btn").addEventListener("click", function() {
	$('#summernote').summernote('focus');
	if ($('#summernote').summernote(!'isEmpty')) {
		$('#summernote').summernote('reset');
	} //設定summernote focus & 清空
	window.alert("您現在在修改模式");
	document.querySelector("#mode").style.display = "block"; //顯示修改模式提醒
	document.querySelector("#limit").style.display = "block"; //顯示標題字數提醒

	let postContent = this.parentElement.firstElementChild.innerHTML; //抓取原有文章內容
	$('#summernote').summernote('pasteHTML', postContent); //將文章內容貼入summernote
	url = "forumpost.do";

	document.querySelector("#post_title").value = document.querySelector("#anchor_title").innerText; //抓取文文章標題
	document.querySelector("#post_title").type = "text"; //顯示文章標題修改欄位
	document.querySelector("#act").value = "update"; //form action改為update

	document.querySelector("#modify_replyNo").value = "";
});

//REPLY modify button
document.querySelectorAll(".reply_modify_btn").forEach(function(btn) {
	btn.addEventListener("click", function() {
		$('#summernote').summernote('focus');
		if ($('#summernote').summernote(!'isEmpty')) {
			$('#summernote').summernote('reset');
		} //設定summernote focus & 清空
		window.alert("您現在在修改模式");
		document.querySelector("#mode").style.display = "block"; //顯示修改模式提醒
		document.querySelector("#limit").style.display = "none"; //隱藏標題字數提醒

		let replyContent = this.parentElement.firstElementChild.innerHTML; //抓取原有文章內容
		$('#summernote').summernote('pasteHTML', replyContent); //將文章內容貼入summernote
		url = "forumreply.do"

		document.querySelector("#post_title").value = document.querySelector("#anchor_title").innerText; //抓取文文章標題
		document.querySelector("#post_title").type = "hidden"; //隱藏文章標題修改欄位
		document.querySelector("#act").value = "update"; //form action改為update

		document.querySelector("#modify_replyNo").value = this.parentElement.parentElement.previousElementSibling.value;//抓取回覆編號
	});
});

//SUBMIT button
document.querySelector("#submit_btn").addEventListener("click", function() {
	$.ajax({
		type: "POST",
		url: url,
		data: $("#submit_form").serialize(),
		dataType: "JSON",
		success: function(data) {
			if ("error" in data) {
				alert(data.error);
			} else if ("updatesuccess" in data) {
				alert("修改成功");
				window.location.href = data.updatesuccess;
			} else {
				alert("新增成功");
				window.location.href = data.success;
			}
		},
	});
});

//POST report button
document.querySelector(".post_report_btn").addEventListener("click", function() {
	if (this.parentElement.nextElementSibling.firstElementChild.classList.contains("post_spn_no")) {
		alert("本文已經管理員處理下架") //確認文章是否已下架
	} else {
		document.querySelector(".report_area").style.display = "block";
		document.querySelector("#report_replyNo").value = "";
	}
});

//REPLY report button
document.querySelectorAll(".reply_report_btn").forEach(function(btn) {
	btn.addEventListener("click", function() {
		if (this.parentElement.nextElementSibling.firstElementChild.classList.contains("reply_spn_no")) {
			alert("本文已經管理員處理下架") //確認文章是否已下架
		} else {
			document.querySelector(".report_area").style.display = "block";
			document.querySelector("#report_replyNo").value = this.parentElement.parentElement.previousElementSibling.value;
		}
	});
});

//REPORT SUBMIT button
document.querySelector("#report_submit_btn").addEventListener("click", function() {
	$.ajax({
		type: "POST",
		url: "forumreport.do",
		data: $("#report_form").serialize(),
		dataType: "JSON",
		success: function(data) {
			if ("error" in data) {
				alert(data.error);
			} else {
				alert("新增新增檢舉成功，管理者會進行審核");
				window.location.href = data.success;
			}
		},
	});
});

//REPORT CLOSE button
document.querySelector(".report_close_btn").addEventListener("click", function() {
	document.querySelector(".report_area").style.display = "none";
});
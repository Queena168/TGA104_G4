var url = "forumreply.do";

// POST modify button
let post_modify_btn = document.querySelector(".post_modify_btn");
post_modify_btn.addEventListener("click", function() {
	$('#summernote').summernote('focus');
	if ($('#summernote').summernote(!'isEmpty')) {
		$('#summernote').summernote('reset');
	} //設定summernote focus & 清空
	let postContent = this.parentElement.parentElement.firstElementChild.innerHTML; //抓取原有文章內容
	window.alert("您現在在修改模式");
	document.getElementById("mode").style.display = "block"; //顯示修改模式提醒
	document.getElementById("limit").style.display = "block"; //顯示標題字數提醒

	$('#summernote').summernote('pasteHTML', postContent); //將文章內容貼入summernote
	url = "forumpost.do";
	let anchor_title = document.getElementById("anchor_title").innerText;
	document.getElementById("post_title").value = anchor_title; //抓取文文章標題
	document.getElementById("post_title").type = "text"; //顯示文章標題修改欄位
	document.querySelector("#act").value = "update"; //form action改為update
});

// REPLY modify button
let reply_modify_btn = document.querySelectorAll(".reply_modify_btn");
reply_modify_btn.forEach(function(btn) {
	btn.addEventListener("click", function() {
		$('#summernote').summernote('focus');
		if ($('#summernote').summernote(!'isEmpty')) {
			$('#summernote').summernote('reset');
		} //設定summernote focus & 清空
		let replyContent = this.parentElement.parentElement.firstElementChild.innerHTML; //抓取原有文章內容
		window.alert("您現在在修改模式");
		document.getElementById("mode").style.display = "block"; //顯示修改模式提醒
		document.getElementById("limit").style.display = "none"; //隱藏標題字數提醒
		$('#summernote').summernote('pasteHTML', replyContent); //將文章內容貼入summernote
		url = "forumreply.do"
		let anchor_title = document.getElementById("anchor_title").innerText;
		document.getElementById("post_title").value = anchor_title; //抓取文文章標題
		document.getElementById("post_title").type = "hidden"; //隱藏文章標題修改欄位
		document.querySelector("#act").value = "update"; //form action改為update
		let replyNo = this.parentElement.parentElement.parentElement.previousElementSibling.value; //抓取回覆編號
		document.getElementsByName("replyNo")[0].value = replyNo;
	});
});

// SUBMIT button
document.querySelector("#submit_btn").addEventListener("click", function() {
	$.ajax({
		type: "POST",
		url: url,
		data: $("#submitform").serialize(),
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

// POST report button
let post_report_btn = document.querySelector(".post_report_btn");
post_report_btn.addEventListener("click", function() {
	console.log("123")
	if (this.parentElement.nextElementSibling.firstElementChild.classList.contains("post_spn_no")) {
		alert("本文已經管理員處理下架") //確認文章是否已下架
	} else {
		document.getElementById("replyNo").value = "";
		document.getElementById("modalOne").style.display = "block";
	}
});

// REPLY report button
let reply_report_btn = document.querySelectorAll(".reply_report_btn");
reply_report_btn.forEach(function(btn) {
	btn.addEventListener("click", function() {
		console.log("123")
		let replyNo = this.parentElement.parentElement.previousElementSibling.value;
		if (this.parentElement.nextElementSibling.firstElementChild.classList.contains("reply_spn_no")) {
			alert("本文已經管理員處理下架") //確認文章是否已下架
		} else {
			document.getElementById("replyNo").value = replyNo;
			document.getElementById("modalOne").style.display = "block";
		}
	});
});

// REPORT SUBMIT button
document.querySelector("#report_submit").addEventListener("click", function() {
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

// REPORT CLOSE button
document.querySelector(".close").addEventListener("click", function() {
	document.getElementById("modalOne").style.display = "none";
});
//submit button
document.querySelector("#submit_btn").addEventListener("click", function () {
	if (($('#summernote').summernote('code') == "<p><br></p>" && document.getElementById("post_title").value == "") || ($('#summernote').summernote('code') == "" && document.getElementById("post_title").value == "")) {
		alert("請輸入標題及文章內容");
	} else if ($('#summernote').summernote('code') == "<p><br></p>" || $('#summernote').summernote('code') == "") {
		alert("請輸入內容");
	} else if (document.getElementById("post_title").value == "") {
		alert("請輸入標題")
	} else if ((document.getElementById("post_title")).value.length > 50) {
		alert("標題請勿超過50個字")
	} else {
		document.querySelector("#submitform").submit();
		if (document.querySelector("#act").value == "insert") {
			alert("新增成功");
		} else {
			alert("修改成功");
		}
	}
});

// post modify button
let post_modify_btn = document.querySelector(".post_modify_btn");
post_modify_btn.addEventListener("click", function () {
	$('#summernote').summernote('focus');
	if ($('#summernote').summernote(!'isEmpty')) {
		$('#summernote').summernote('reset');
	} //設定summernote focus & 清空

	let postContent = this.parentElement.parentElement.firstElementChild.innerHTML; //抓取原有文章內容
	window.alert("您現在在修改模式");
	document.getElementById("mode").setAttribute("style", "color:red; display:"); //顯示修改模式提醒
	document.getElementById("limit").setAttribute("style", "display:"); //顯示標題字數提醒
	$('#summernote').summernote('pasteHTML', postContent); //將文章內容貼入summernote
	document.getElementById("submitform").setAttribute("action", "forumpost.do"); // form action 設為forumpost.do

	let anchor_title = document.getElementById("anchor_title").innerText;
	document.getElementById("post_title").value = anchor_title; //抓取文文章標題
	document.getElementById("post_title").setAttribute("type", "text"); //顯示文章標題修改欄位
	document.querySelector("#act").value = "update"; //form action改為update
});

// reply modify button
let reply_modify_btn = document.querySelectorAll(".reply_modify_btn");
reply_modify_btn.forEach(function (btn) {
	btn.addEventListener("click", function () {
		$('#summernote').summernote('focus');
		if ($('#summernote').summernote(!'isEmpty')) {
			$('#summernote').summernote('reset');
		} //設定summernote focus & 清空
		let replyContent = this.parentElement.parentElement.firstElementChild.innerHTML; //抓取原有文章內容
		window.alert("您現在在修改模式");
		document.getElementById("mode").setAttribute("style", "color:red; display:"); //顯示修改模式提醒
		document.getElementById("limit").setAttribute("style", "display: none"); //隱藏標題字數提醒
		$('#summernote').summernote('pasteHTML', replyContent); //將文章內容貼入summernote
		document.getElementById("submitform").setAttribute("action", "forumreply.do"); // form action 設為forumreply.do

		let anchor_title = document.getElementById("anchor_title").innerText;
		document.getElementById("post_title").value = anchor_title; //抓取文文章標題
		document.getElementById("post_title").setAttribute("type", "hidden"); //隱藏文章標題修改欄位
		document.querySelector("#act").value = "update"; //form action改為update

		let replyNo = this.parentElement.parentElement.parentElement.previousElementSibling.value; //抓取回覆編號
		document.getElementsByName("replyNo")[0].value = replyNo;
	});
});

// post report button
let post_report_btn = document.querySelector(".post_report_btn");
post_report_btn.addEventListener("click", function () {
	if (this.parentElement.nextElementSibling.firstElementChild.classList.contains("post_spn_no")) {
		alert("本文已經管理員處理下架") //確認文章是否已下架
	} else {
		document.getElementById("replyNo").value = "";
		document.getElementById("modalOne").style.display = "block";
	}
});

// reply report button
let reply_report_btn = document.querySelectorAll(".reply_report_btn");
reply_report_btn.forEach(function (btn) {
	btn.addEventListener("click", function () {
		let replyNo = this.parentElement.parentElement.previousElementSibling.value;
		if (this.parentElement.nextElementSibling.firstElementChild.classList.contains("reply_spn_no")) {
			alert("本文已經管理員處理下架") //確認文章是否已下架
		} else {
			document.getElementById("replyNo").value = replyNo;
			document.getElementById("modalOne").style.display = "block";
		}
	});
});

// posts.jsp report close button
document.querySelector(".close").addEventListener("click", function () {
	document.getElementById("modalOne").style.display = "none";
});


// posts.jsp report submit button
document.querySelector("#report_submit").addEventListener("click", function () {
	if (document.querySelector("#reason").value == "") {
		alert("請輸入檢舉內容");
	} else {
		document.querySelector("#report_form").submit();
		alert("新增檢舉成功，管理者會進行審核");
	}
});


//// summernote
//$('#summernote').summernote({
//	lang: 'zh-TW',
//	placeholder: '輸入文字... 或將圖片拖曳至此',
//	height: 300,
//	fontNames: ['Arial', 'Comic Sans MS', 'Courier New', 'Impact', 'Times New Roman', '新細明體', '微軟正黑體', '標楷體'],
//	toolbar: [
//		['style', ['bold', 'italic', 'underline']],
//		['font', ['strikethrough', 'superscript', 'subscript']],
//		['fontname', ['fontname']],
//		['fontsize', ['fontsize']],
//		['height', ['height']],
//		['color', ['color']],
//		['para', ['ul', 'ol', 'paragraph']],
//		['insert', ['picture']],
//		['view', ['codeview']],
//	],
//});
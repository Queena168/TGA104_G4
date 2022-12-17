//foorumIndex.jsp search button
function search() {
	if (document.getElementsByName("keyword")[0].value == "") {
		alert("請輸入文字");
	} else {
		document.querySelector("#form").submit();
	}
}

//posting.jsp submit button
function add() {
	let content = $('#summernote').summernote('code');
	let title = document.getElementById("posting_title").value;
	if ((content == "<p><br></p>" && title == "") || (content == "" && title == "")) {
		alert("請輸入標題及文章內容");
	} else if (content == "<p><br></p>" || content == "") {
		alert("請輸入文章內容");
	} else if (title == "") {
		alert("請輸入標題")
	} else if (title.length > 50) {
		alert("標題請勿超過50個字")
	} else {
		document.querySelector("#form").submit();
		alert("新增成功");
	}
}
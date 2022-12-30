//foorumIndex.jsp search button
function search() {
	if (document.querySelector("#keyword").value.trim() == "") {
		alert("請輸入文字");
	} else {
		document.querySelector("#search_form").submit();
	}
}

//posting.jsp submit button
function add() {
	$.ajax({
		type: "POST",
		url: "addPost",
//		url: "forumpost.do",
		data: $("#add_form").serialize(),
		dataType: "JSON",
		success: function(data) {
			if ("error" in data) {
				alert(data.error);
			} else {
				alert("新增成功");
				window.location.href = data.success;
			}
		},
	});
}
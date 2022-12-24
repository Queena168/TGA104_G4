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
	$.ajax({
		type: "POST",
		url: "forumpost.do",
		data: $("#form").serialize(),
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
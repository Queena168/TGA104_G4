//foorumIndex.jsp search button
function search() {
	$.ajax({
		type: "POST",
		url: "search",
		data: $("#search_form").serialize(),
		dataType: "JSON",
		success: function(data) {
			if ("error" in data) {
				alert(data.error);
			} else {
				window.location.href = data.success;
			}
		},
	});
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
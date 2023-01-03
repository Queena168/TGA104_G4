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

document.querySelector("#keyword").addEventListener("keydown", function(e) {
	if (e.which == 13) {
		document.querySelector(".search_btn").click();
	}
})


//posting.jsp submit button
function add() {
	$.ajax({
		type: "POST",
		url: "addPost",
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
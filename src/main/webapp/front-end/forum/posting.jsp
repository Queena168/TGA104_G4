<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../CSS/forum_style.css">
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote-lite.min.js"></script>
<script src="../js/summernote-zh-TW.js"></script>
<style>
    .note-editable {
        background-color: white;
    }
    /* 蓋掉summernote原本的css */
    p {
        display: block;
        margin-block-start: 0em;
        margin-block-end: 0em;
        margin-inline-start: 0px;
        margin-inline-end: 0px;
    }
    /* 蓋掉summernote原本的css */
</style>
<title>Insert title here</title>
</head>

<body>
        <div class="navigate">
            <span>
                <a href="forumIndex.do">論壇首頁</a> >>
                <a href="topic.do?topicNo=${param.topicNo}"> ${forumTopicVO.topicName} </a><%--從posting.do傳來的forumTopicVO--%>
            </span>

        </div>
		<form method="post" id="form" action="forumpost.do">
		<input id="post_title" type="text" placeholder="請輸入標題" name="title" value="${forumPostVO.title}"><%--若發文格式，顯示從forumPostController回傳的forumPostVO--%>
		<div class="comment-area" id="reply-area">
		<textarea name="content" id="summernote">${forumPostVO.content}</textarea>
		<button id="add_btn" type="button">送出</button>
<!-- 		<input type="submit" value="送出"> -->
		</div>
		<input type="hidden" name="action" value="insert">
		<input type="hidden" name="topicNo" value="${param.topicNo}">
		<input type="hidden" name="memberNo" value=1>
		</form>

<script>
document.querySelector("#add_btn").addEventListener("click", function(){
	let content = $('#summernote').summernote('code');
	let title = document.getElementById("post_title").value;
	if ((content == "<p><br></p>" && title == "") || (content == "" && title =="")){
		alert("請輸入標題及文章內容");
	}else if (content == "<p><br></p>" || content == ""){
		alert("請輸入文章內容");
	}else if(title==""){
		alert("請輸入標題")
	}else{
		document.querySelector("#form").submit();
		alert("新增成功");
	}
});



$('#summernote').summernote({
	lang: 'zh-TW',
    placeholder: '輸入文字... 或將圖片拖曳至此',
	height: 400,
	fontNames: ['Arial', 'Comic Sans MS', 'Courier New', 'Impact', 'Times New Roman', '新細明體', '微軟正黑體', '標楷體'],
	toolbar: [
		['style',['bold', 'italic', 'underline']],
		['font',['strikethrough','superscript','subscript']],
		['fontname',['fontname']],
		['fontsize',['fontsize']],
		['height',['height']],
		['color',['color']],
		['para', ['ul', 'ol', 'paragraph']],
		['insert', ['picture']],
		['view', ['codeview']],
	],
});

</script>

</body>
</html>
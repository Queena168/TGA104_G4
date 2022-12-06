<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../css/forum_style.css">
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
    <div class="container">
        <!--Navigation-->
        <div class="navigate">
            <span>
                <a href="forumIndex.do">論壇首頁</a> >>
                <a href="topic.do?topicNo=${param.topicNo}"> ${forumTopicVO.topicName} </a> >>
                <a href="posts.do?topicNo=${param.topicNo}&postNo=${param.postNo}">${forumPostVO.title}</a>
            </span>
            <input type="button" value="我要發文" onclick="location.href='posting.do?topicNo=${param.topicNo}'">
		

        </div>
        <!--Topic Section-->
        <div class="topic-container">
            <!--Original thread-->
            <div class="head">
                <div class="authors">發文者</div>
                <div class="content">${forumPostVO.title}</div>
				<div class="view">瀏覽次數: ${view}次</div>
            </div>

            <div class="body">
                <div class="authors">
                    <div class="username">
                        <a href="">${forumPostVO.memberNo}</a>
                    </div>
                    <div>Role</div>
                    <img src="https://cdn.pixabay.com/photo/2015/11/06/13/27/ninja-1027877_960_720.jpg" alt="">
                    <div>
                        Posts: <u>45</u>
                    </div>
                    <div>
                        Points: <u>4586</u>
                    </div>
                </div>
                <div class="content">
                    ${forumPostVO.content}
                    <br>發文時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumPostVO.postTime}" />
                    <br>最終修改時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumPostVO.modificationTime}" />
                    <div class="comment">
                    <form method="post" action="forumpost/forumpost.do">
                    	<button type="submit" value="update">修改內容</button>
                   	</form>
                   <form method="post" action="">
                    	<button type="submit" value="update">加到我的最愛</button>
                   	</form>
                   	<form method="post" action="">
                    	<button type="submit" value="update">檢舉</button>
                   	</form>
                        <button onclick="showReply()">我要回覆</button>
                    </div>
                </div>
            </div>
        </div>

        <!--Comments Section-->
        <c:forEach var="forumReplyVO" items="${forumReplyVOList}">
        <div class="comments-container">
            <div class="body">
                <div class="authors">
                    <div class="username">
                        <a href="">${forumReplyVO.memberNo}</a>
                    </div>
                    <div>Role</div>
                    <img src="https://cdn.pixabay.com/photo/2015/11/06/13/27/ninja-1027877_960_720.jpg"
                        alt="">
                    <div>Posts: <u>455</u></div>
                    <div>Points: <u>4586</u></div>
                </div>
                <div class="content">
                    ${forumReplyVO.content}
                    <br>回應時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumReplyVO.replyTime}" />
                    <br>最終修改時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumReplyVO.modificationTime}" />
                    <div class="comment">
                    <form method="post" action = "forumreply/forumreply.do">
                 		<input type="button" value="修改內容">
                    	<input type="button" value="加到我的最愛">
						<input type="button" value="檢舉文章">
                   	</form>
                        <button onclick="showReply()">我要回覆</button>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
        <!--Reply Area-->
        <form method="post" action="forumreply/forumreply.do">
         <div class="comment-area hide" id="reply-area">
             <textarea name="content" id="summernote"></textarea>
             <input type="submit" value="送出">
         </div>
		<input type="hidden" name="action" value="insert">
		<input type="hidden" name="memberNo" value=1>
		<input type="hidden" name="topicNo" value="${param.topicNo}">
		<input type="hidden" name="replyTo" value="${param.postNo}">
         </form>
    </div>

<script>
function showReply(){
document.getElementById("reply-area").classList.remove("hide");
document.getElementsByClassName("note-editable")[0].focus();
}
</script>

<script>
$('#summernote').summernote({
	lang: 'zh-TW',
    placeholder: '輸入文字... 或將圖片拖曳至此',
	height: 200,
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
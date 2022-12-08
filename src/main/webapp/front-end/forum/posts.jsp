<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<c:if test="${not empty errorMessages}">
<ul>
<c:forEach var="message" items="${errorMessages}">
<li style="color: red">${message}</li>
</c:forEach>
</ul>
</c:if>
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
                <div class=content>${forumPostVO.title}</div>
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
                    <span class="post">${forumPostVO.content}</span>
                    <div class="time">
                		<br>發文時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumPostVO.postTime}" />
                		<br>最終修改時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumPostVO.modificationTime}" />
                		<br>原PO
                	</div>
                    <div class="comment">
                        <button class="post_modify_btn">我要修改</button>
						<button class="report_btn">我要檢舉</button>
                    </div>
                </div>
            </div>
        </div>

        <!--Comments Section-->
        <c:forEach var="forumReplyVO" items="${forumReplyVOList}" varStatus="status">
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
                    <span class="reply_spn">${forumReplyVO.content}</span>
            		<input type="hidden" class="hidden_replyNo" value="${forumReplyVO.replyNo}">
					<div class="time">
	                   <br>回應時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumReplyVO.replyTime}" />
	                   <br>最終修改時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumReplyVO.modificationTime}" />
	                   <br>${status.count}樓
                	</div>
                    <div class="comment">
                        <button class="reply_modify_btn">我要修改</button>
						<button class="report_btn">我要檢舉</button>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
        
        <!--Reply Area-->
        <form method="post" id="form" action="forumreply.do">
		<input type="hidden" id="title" name="title" value="${forumPostVO.title}">
        <div class="comment-area" id="reply-area">
			<textarea name="content" id="summernote"></textarea>
			<input type="submit" value="送出">
        </div>
		<input type="hidden" name="action" value="insert">
		<input type="hidden" name="memberNo" value=1>
		<input type="hidden" name="replyNo" value="">
		<input type="hidden" name="topicNo" value="${param.topicNo}">
		<input type="hidden" name="postNo" value="${param.postNo}">
         </form>
              
    </div>
    
	   <div id="modalOne" class="modal">
        <div class="modal-content">
            <div class="contact-form">
                <a class="close">&times;</a>
                <form action="/">
                    <h2>檢舉</h2>
                    <div>
                        <input type="text" name="postNo" placeholder="發文號碼" />
                        <input type="text" name="replyNo" placeholder="回應號碼" />
                        <input type="text" name="memberNo" placeholder="會員編號" />
                    </div>
                    <span>檢舉原因</span>
                    <div>
                        <textarea rows="4"></textarea>
                    </div>
                    <button type="submit" href="/">Submit</button>
                </form>
            </div>
        </div>
    </div>

<script>
var report_btn = document.querySelectorAll(".report_btn");
report_btn.forEach(function (btn){
	btn.addEventListener("click", function(){
        document.getElementById("modalOne").style.display = "block";
	});
});


document.querySelector(".close").addEventListener("click", function(){
    document.getElementById("modalOne").style.display = "none";
});


var reply_modify_btn = document.querySelectorAll(".reply_modify_btn");
reply_modify_btn.forEach(function (btn){
	btn.addEventListener("click", function(){
 		$('#summernote').summernote('focus');	 	
	 	if ($('#summernote').summernote(!'isEmpty')) {
	 		$('#summernote').summernote('reset');
	 	}
		var replyContent = this.parentElement.parentElement.firstElementChild.innerHTML;
		window.alert("您現在是修改模式");
		$('#summernote').summernote('pasteHTML', replyContent);
		document.getElementById("form").setAttribute("action","forumreply.do");
		document.getElementById("title").setAttribute("type","hidden");
		document.getElementsByName("action")[0].setAttribute("value","update");
		
		var replyNo = this.parentElement.parentElement.firstElementChild.nextElementSibling.value;
		document.getElementsByName("replyNo")[0].setAttribute("value", replyNo);
	});
});

var post_modify_btn = document.querySelector(".post_modify_btn");
post_modify_btn.addEventListener("click", function(){
	$('#summernote').summernote('focus');	 	
 	if ($('#summernote').summernote(!'isEmpty')) {
 		$('#summernote').summernote('reset');
 	}
	var postContent = this.parentElement.parentElement.firstElementChild.innerHTML;
	window.alert("您現在是修改模式");
	$('#summernote').summernote('pasteHTML', postContent);
	document.getElementById("form").setAttribute("action","forumpost.do");
	document.getElementById("title").setAttribute("type","text");
	document.getElementsByName("action")[0].setAttribute("value","update");
	
});

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
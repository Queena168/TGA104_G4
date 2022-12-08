<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="../CSS/forum_style.css">
</head>

<body>
<c:if test="${not empty errorMessages}">
<ul>
<c:forEach var="message" items="${errorMessages}">
<li style="color: red">${message}</li>
</c:forEach>
</ul>
</c:if>

<form method="post" action="forumpost.do">
<span>
<input type="text" name="keyword" placeholder="搜尋論壇發文">
<input type="hidden" name="action" value="search">
<button>確認</button></span>
</form>


<c:forEach var="forumTopicVO" items="${forumTopicVOList}" varStatus="status">
	<div class="subforum-row">

		<div class="subforum-icon subforum-column center">
			<i class="fa fa-car center"></i>
		</div>
		
		<div class="subforum-description subforum-column">
			<h4><a href="topic.do?topicNo=${forumTopicVO.topicNo}">${forumTopicVO.topicName}</a></h4>
		</div>
		
		<div class="subforum-stats subforum-column center">
			<span>開版日期 <br>${forumTopicVO.startDate}</span>
		</div>
	
		<div class="subforum-info subforum-column">
			<b>最新:<a href="posts.do?topicNo=${forumPostVOList[status.index].topicNo}&postNo=${forumPostVOList[status.index].postNo}">${forumPostVOList[status.index].title}</a></b> by (會員暱稱) ${forumPostVOList[status.index].memberNo}</a>
			<br>on <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumPostVOList[status.index].postTime}"/>
		</div>
	</div>
	</c:forEach>

</body>
</html>
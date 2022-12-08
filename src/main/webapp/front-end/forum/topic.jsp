<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<link rel="stylesheet" href="../CSS/forum_style.css">
</head>

<body>

	<div class="container">
		<!--Navigation-->
		<div class="navigate">
			<span><a href="forumIndex.do">論壇首頁</a> >> <a href="topic.do?topicNo=${param.topicNo}">${forumTopicVO.topicName}</a></span>
		<input type="button" value="我要發文" onclick="location.href='posting.do?topicNo=${param.topicNo}'">
		</div>
		<!--Display posts table-->
		<div class="posts-table">
			<div class="table-head">
				<div class="status">筆數</div>
				<div class="subjects">主題</div>
				<div class="replies">回應/瀏覽次數</div>
				<div class="last-reply">最新回應</div>
			</div>

		<c:forEach var="forumPostVO" items="${forumPostVOList}" varStatus="status">
		
			<div class="table-row">
				<div class="status">第${status.count}篇</div>
				<div class="subjects">
					<a href="posts.do?topicNo=${param.topicNo}&postNo=${forumPostVO.postNo}">${forumPostVO.title}</a> <br>
					<span>Started by <b><a href="">${forumPostVO.memberNo}</a></b>
					<br><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumPostVO.postTime}" /></span>
				</div>
				
				<div class="replies">
					${(countList[status.index] == null) ? 0: countList[status.index]} 次回應 <br>
					${(viewList[status.index] == null) ? 0: viewList[status.index]} 次瀏覽
				</div>
				<div class="last-reply">
		<c:choose>  <%-- 用JSTL的choose --%>
		<c:when test="${countList[status.index] != null}">
				<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumReplyVOList[status.index].replyTime}"/> <br>By <b><a href="">${forumReplyVOList[status.index].memberNo}</a></b>
		</c:when>
		<c:otherwise>
				暫無人回應
		</c:otherwise>
		</c:choose>
				</div>
			</div>
		</c:forEach>
		</div>
	</div>
	
</body>
</html>
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
			<span><a href="forumIndex.do">論壇首頁</a> >> 搜尋結果：

		</div>
		<!--Display posts table-->
		<div class="posts-table">
			<div class="table-head">
				<div class="status">筆數</div>
				<div class="subjects">主題</div>
				<div class="content">內容</div>
				<div class="topic">所屬討論區</div>
			</div>
		
		<c:choose>	
		<c:when test="${empty resultList}">
		<div>查無資料</div>
		</c:when>
		<c:otherwise>
		<c:forEach var="forumPostVO" items="${resultList}" varStatus="status">
		
			<div class="table-row">
				<div class="status">第${status.count}筆</div>
				<div class="subjects">
					<a href="posts.do?topicNo=${forumPostVO.topicNo}&postNo=${forumPostVO.postNo}">${forumPostVO.title}</a> <br>
					<span>Started by <b>${forumPostVO.nickName}</b>
					<br><fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumPostVO.postTime}" /></span>
				</div>
				<c:choose>
				<c:when test="${forumPostVO.reviewResult =='下架'}">
                 <span class="content">本文因違反論壇規定，已被管理員下架</span>
				</c:when>
				<c:otherwise>
				<div class="content">${forumPostVO.content}</div>
				</c:otherwise>
				</c:choose>
				<div class="topic">${topicNameList[status.index]}</div>
			</div>	
		</c:forEach>
		</c:otherwise>
		
		</c:choose>	
		</div>
	</div>
	
</body>
</html>
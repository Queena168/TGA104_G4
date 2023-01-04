<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">

	<!-- summernote -->
	<link href="../css/summernote-lite.css" rel="stylesheet">

	<!-- Favicon -->
	<link rel="icon" href="../images/favicon.ico" sizes="32x32">
	<!-- Bootstrap core CSS -->
	<link rel="stylesheet" href="../css/bootstrap.min.css">
	<!-- Font Awesome -->
	<link rel='stylesheet' href='../css/fontawesome.min.css'>
	<!-- Animate -->
	<link href="../css/animate.css" rel="stylesheet">
	<!-- Owl Carousel -->
	<link rel="stylesheet" href="../css/owl.carousel.min.css">
	<link rel="stylesheet" href="../css/owl.theme.default.min.css">
	<!-- light box -->
	<link rel="stylesheet" href="../css/lightbox.min.css">
	<!-- jquery ui -->
	<link rel="stylesheet" href="../css/jquery-ui.min.css">
	<!--    <link rel="stylesheet" href="//basehold.it/24">-->

	<!-- nice select -->
	<link rel="stylesheet" href="../css/nice-select.min.css">
	<!-- Main Styles -->
	<link rel="stylesheet" href="../scss/main.css">
	<link rel="stylesheet" href="../css/forum_style.css">

	<title>文章列表</title>

</head>

<body>
<!-- main header navbar -->
<nav class="navbar navbar-expand-lg navbar-light custom-navbar" id="mainMenu">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/front-end/index.html">    
            <img src="../images/MatDesignLogo.png" alt="">
        </a>
        <!--  navbar actions -->
        <div class="main-navbar-action">
            <div id="mainNavbarDropdown">
                <!-- navbar user account dropdown -->
                <div class="dropdown-wrapper" id="usermenu" data-collapse="false">
                    <div class="account-wrapper">
                        <!-- login form wrapper -->
                        
                        <div class="account-wrapper__content">
                            <form class="custom-form">
                                <div class="custom-form__btn">
                                    <a class="dropdown-item nav-link" href="../member/login.jsp">會員登入/註冊</a>
                                    <a class="dropdown-item nav-link" href="../designer_protfolio/login.jsp">設計師登入/註冊</a>
                                </div>
                                
                            </form>
                        </div>
                        <!-- account links when user is logged in-->
                        <!--                    <a class="dropdown-item" href="account.html#v-pills-profile-tab"><span><i-->
                        <!--                            class="icon-user-profile"></i></span>Profile</a>-->
                        <!--                    <a class="dropdown-item" href="account.html#v-pills-order-tab"><span><i-->
                        <!--                            class="icon-shopping-basket"></i></span>Orders</a>-->
                        <!--                    <a class="dropdown-item" href="account.html#v-pills-address-tab"><span><i-->
                        <!--                            class="icon-sign"></i></span>Addresses</a>-->
                        <!--                    <a class="dropdown-item" href="account.html#v-pills-wishlist-tab"><span><i-->
                        <!--                            class="icon-wish-list"></i></span>wishlist</a>-->
                        <!--                    <a class="dropdown-item" href="#"><span><i class="icon-log-out"></i></span>Log out</a>-->

                    </div>
                </div>
                <!-- navbar cart dropdown -->
                <div class="" id="cartmenu" data-collapse="false"></div>
            </div>
            <!-- navbar user account icon -->
            <div class="main-navbar-action__btn nav-dropdown">
                <a class="dropdown-link" data-target="usermenu">
                    <i class="icon-user"></i>
                </a>
            </div>
            <!-- navbar cart icon -->
            <div class="main-navbar-action__btn nav-dropdown">
                <a class="dropdown-link" data-target="cartmenu">
                    <span class="cart-badge">2</span>
                    <i class="icon-shopping-bag"></i>
                </a>
            </div>
            <!-- navbar actions content -->
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#mainNavbar"
                aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
       <div class="collapse navbar-collapse" id="mainNavbar">
            <ul class="navbar-nav main-navbar">
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="${pageContext.request.contextPath}/front-end/designer_protfolio/memFindPortfolio.jsp" >找作品</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="${pageContext.request.contextPath}/ShowDesignerPage" >找設計師</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="${pageContext.request.contextPath}/ShowShop" >商城</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="${pageContext.request.contextPath}/front-end/forum/forumIndex.do" >論壇</a>
                </li>
                <!-- <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="#" data-toggle="dropdown">報導文章</a>
                </li> -->
                <li class="nav-item main-navbar__item">
                    <a class="nav-link" href="">關於我們</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<!-- end main header navbar -->

	<!-- Posts Start -->
	<div class="forum_container">
		<!--Navigation-->
		<div class="navigate AutoSkip">
			<span><a href="forumIndex.do">論壇首頁</a> >> <a
					href="topic.do?topicNo=${param.topicNo}&page=1">${forumTopicVO.topicName} </a> >> <a
					href="posts.do?topicNo=${param.topicNo}&postNo=${param.postNo}&page=1">${forumPostVO.title}</a></span>
			<c:choose>
				<c:when test="${memberVO.memberAccount!=null}">
					<button type="button" class="add_post_btn"
						onclick="location.href='posting.do?topicNo=${param.topicNo}'">我要發文</button>
				</c:when>
				<c:otherwise>
					<button type="button" class="add_post_btn" onclick="alert('請先登入')">我要發文</button>
				</c:otherwise>
			</c:choose>
		</div>

		<!--Post Section-->
		<div class="head">
			<div class="title" id="anchor_title">${forumPostVO.title}</div>
			<div class="view">瀏覽次數: ${view}次</div>
		</div>
		<div class="body">
			<div class="authors">
				發文者：
				<div class="username">
					<b>${forumPostVO.nickName}</b>
				</div>
				原PO<br><br><br>
				<c:choose>
					<c:when test="${(memberVO.memberAccount!=null) and (memberVO.memberNo!= forumPostVO.memberNo)}">
						<button class="post_report_btn">檢舉此文</button>
					</c:when>
					<c:when test="${(memberVO.memberAccount!=null) and (memberVO.memberNo== forumPostVO.memberNo)}">
						<button class="post_report_btn" style="display: none"></button>
					</c:when>
					<c:otherwise>
						<button class="post_report_btn" style="display: none"></button>
						<button class="post_report_btn no" onclick="alert('請先登入')">檢舉此文</button>
					</c:otherwise>
				</c:choose>
			</div>
			<div class="content">
				<c:choose>
					<c:when test="${forumPostVO.reviewResult =='下架'}">
						<span class="post_spn_no">本文因違反論壇規定，已被管理員下架</span>
					</c:when>
					<c:otherwise>
						<span class="post_spn">${forumPostVO.content}</span>
					</c:otherwise>
				</c:choose>
				<br><br><br><div class="time">
					<c:if test="${not empty forumPostVO.modificationTime}">
						修改時間
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumPostVO.modificationTime}" /><br>
					</c:if>
					發文時間
					<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumPostVO.postTime}" />
				</div>
				<c:choose>
					<c:when
						test="${(memberVO.memberNo == forumPostVO.memberNo)&&(forumPostVO.reviewResult !='下架')}">
						<button class="post_modify_btn">我要修改</button>
					</c:when>
					<c:otherwise>
						<button class="post_modify_btn" style="display: none"></button>
					</c:otherwise>
				</c:choose>
			</div>
		</div>

		<!--Reply Section-->
		<c:choose>
			<c:when test="${not empty forumReplyVOList}">
				<c:forEach var="forumReplyVO" items="${forumReplyVOList}" varStatus="status" begin="${pageStart}"
					end="${pageEnd}">
					<input type="hidden" class="hidden_replyNo" value="${forumReplyVO.replyNo}">
					<div class="body">
						<div class="authors">
							回文者：
							<div class="username">
								<b>${forumReplyVO.nickName}</b>
							</div>
							#${pageStart+status.count}樓<br><br><br>
							<c:choose>
								<c:when
									test="${(memberVO.memberAccount!=null) and (memberVO.memberNo!= forumReplyVO.memberNo)}">
									<button class="reply_report_btn">檢舉此文</button>
								</c:when>
								<c:when
									test="${(memberVO.memberAccount!=null) and (memberVO.memberNo== forumReplyVO.memberNo)}">
									<button class="reply_report_btn" style="display: none"></button>
								</c:when>
								<c:otherwise>
									<button class="reply_report_btn" style="display: none"></button>
									<button class="reply_report_btn_no" onclick="alert('請先登入')">檢舉此文</button>
								</c:otherwise>
							</c:choose>
						</div>
						<div class="content">
							<c:choose>
								<c:when test="${forumReplyVO.reviewResult =='下架'}">
									<span class="reply_spn_no">本文因違反論壇規定，已被管理員下架</span>
								</c:when>
								<c:otherwise>
									<span class="reply_spn">${forumReplyVO.content}</span>
								</c:otherwise>
							</c:choose>
							<br><br><br><div class="time">
								<c:if test="${not empty forumReplyVO.modificationTime}">
									修改時間
									<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
										value="${forumReplyVO.modificationTime}" /><br>
								</c:if>
								回應時間
								<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${forumReplyVO.replyTime}" />
							</div>
							<c:choose>
								<c:when
									test="${memberVO.memberNo == forumReplyVO.memberNo&&(forumReplyVO.reviewResult !='下架')}">
									<button class="reply_modify_btn">我要修改</button>
								</c:when>
								<c:otherwise>
									<button class="reply_modify_btn" style="display: none"></button>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</c:forEach>
				<div class="next_page">
					<c:if test="${param.page>1}">
						<a href="posts.do?topicNo=${param.topicNo}&postNo=${param.postNo}&page=${param.page-1}">上一頁</a>
					</c:if>
					<c:if test="${param.page<totalPage}">
						<a href="posts.do?topicNo=${param.topicNo}&postNo=${param.postNo}&page=${param.page+1}">下一頁</a>
					</c:if>
					<div class="paging">
						<a href="posts.do?topicNo=${param.topicNo}&postNo=${param.postNo}&page=1">至第一頁</a>
						<span>第${param.page}頁 / 共${totalPage}頁</span>
						<a href="posts.do?topicNo=${param.topicNo}&postNo=${param.postNo}&page=${totalPage}">至最後一頁</a>
					</div>
				</div>
			</c:when>
			<c:otherwise>
			<div class="body">
				<h4>暫無人回應...</h4>
			</div><br>
			</c:otherwise>
		</c:choose>

		<!--Comment & Modify Area-->
		<c:choose>
			<c:when test="${memberVO.memberAccount ==null}">
				<h4> 登入後可留言... </h4>
				<button id="submit_btn" type="button" style="display: none">送出</button>
			</c:when>
			<c:otherwise>
				<div>
					<h2 id="mode" style="display:none">您現在是修改模式</h2>
					<form id="submit_form">
						<span id="limit" style="display:none">
							<input type="hidden" id="post_title" name="title" value="${forumPostVO.title}" size="40">
							標題請勿超過50個字</span>
						<textarea name="content" id="summernote"></textarea>
						<button id="submit_btn" type="button">送出</button>
						<input id="act" type="hidden" name="action"><!-- value="insert"> --> 
						<input type="hidden" name="memberNo" value="${memberVO.memberNo}">
						<input type="hidden" id="modify_replyNo" name="replyNo" value="">
						<input type="hidden" name="topicNo" value="${param.topicNo}">
						<input type="hidden" name="postNo" value="${param.postNo}">
						<input type="hidden" name="page" value="${param.page}">
						<input type="hidden" name="totalPage" value="${totalPage}">
					</form>
				</div>
			</c:otherwise>
		</c:choose>

		<!--Report Area-->
		<div class="report_area">
			<div class="modal_report">
				<a class="report_close_btn">&times;</a>
				<form id="report_form">
					<h3>檢舉</h3>
					<div>
						<input type="hidden" name="topicNo" value="${param.topicNo}">
						<input type="hidden" name="postNo" value="${param.postNo}">
						<input type="hidden" id="report_replyNo" name="replyNo" value="">
						<input type="hidden" name="informant" value="${memberVO.memberNo}">
						<input type="hidden" name="action"><!-- value="insertReport"> --> 
						<input type="hidden" name="page" value="${param.page}">
					</div>
					<span>檢舉原因(請勿超過50字)</span>
					<div>
						<textarea rows="4" name="reportReason"></textarea>
					</div>
					<button id="report_submit_btn" type="button">送出檢舉</button>
				</form>
			</div>
		</div>
	</div>
	<!-- Posts End -->

	<!-- footer -->
	<footer class="footer">
		<div class="container">
			<div class="footer__top-row">
				<div class="row">
					<div class="col-lg-4 col-md-6 footer__content">
						<div class="footer-logo">
							<img src="../images/MatDesignLogo.png" alt="">
						</div>
						<p></p>

					</div>
					<div class="col-lg-2 col-md-6 footer__content">
						<h5 class="footer-heading">關於我們</h5>
						<ul class="footer-list">
							<li class="footer-list__item"><a href="">關於我們</a></li>
						</ul>
					</div>
					<div class="col-lg-3 col-md-6 footer__content">
						<h5 class="footer-heading">網站地圖</h5>
                 	     <ul class="footer-list">
                            <li class="footer-list__item"><a href="${pageContext.request.contextPath}/front-end/designer_protfolio/memFindPortfolio.jsp">找作品</a></li>
                            <li class="footer-list__item"><a href="${pageContext.request.contextPath}/ShowDesignerPage">找設計師</a></li>
                            <li class="footer-list__item"><a href="${pageContext.request.contextPath}/ShowShop">商城</a></li>
                            <li class="footer-list__item"><a href="${pageContext.request.contextPath}/front-end/forum/forumIndex.do">論壇</a></li>
                        </ul>
					</div>
					<div class="col-lg-3 col-md-6 footer__content">
						<h5 class="footer-heading">Keep in touch</h5>
						<ul class="footer-list footer-list-info">
							<li class="footer-list__item">
								<span><i class="fas fa-envelope"></i></span>
								<span>MatDesign@gmail.com</span>
							</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="copyright">
				<p>&#169; copyright 2022. Designed by MatDesign </p>
			</div>
		</div>
	</footer>
	<!-- end footer -->

	<!-- scroll up btn -->
	<a class="back-to-top-btn" id="back-to-top"></a>
	<!-- end scroll up btn -->

	<!-- All Jquery -->
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/popper.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<!-- owl carousel js -->
	<script type="text/javascript" src="../js/owl.carousel.min.js"></script>
	<!-- Jquery ui -->
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<!-- light box js -->
	<script type="text/javascript" src="../js/lightbox.min.js"></script>
	<!-- typeahead js -->
	<script type="text/javascript" src="../js/typeahead.jquery.min.js"></script>
	<!-- master zoom image js -->
	<script type="text/javascript" src="../js/jquery.zoom.min.js"></script>
	<!-- countdown js -->
	<script type="text/javascript" src="../js/countdown.jquery.min.js"></script>
	<!-- nice select js -->
	<script type="text/javascript" src="../js/nice-select.min.js"></script>
	<!-- wow js -->
	<script type="text/javascript" src="../js/wow.min.js"></script>
	<!-- custom js -->
	<script type="text/javascript" src="../js/custom.js"></script>

	<script src="../js/forum_posts.js"></script>
	
	<!-- summernote -->
	<script src="../js/summernote-lite.js"></script>
	<script src="../js/summernote-zh-TW.js"></script>

	<script>
		$('#summernote').summernote({
			lang: 'zh-TW',
			placeholder: '輸入文字... 或將圖片拖曳至此',
			height: 300,
			fontNames: ['Arial', 'Comic Sans MS', 'Courier New', 'Impact', 'Times New Roman', '新細明體', '微軟正黑體', '標楷體'],
			toolbar: [
				['style', ['bold', 'italic', 'underline']],
				['font', ['strikethrough', 'superscript', 'subscript']],
				['fontname', ['fontname']],
				['fontsize', ['fontsize']],
				['height', ['height']],
				['color', ['color']],
				['para', ['ul', 'ol', 'paragraph']],
				['insert', ['picture']],
			],
		});
	</script>

</body>

</html>
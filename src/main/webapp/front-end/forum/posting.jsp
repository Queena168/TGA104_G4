<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

	<title>發文</title>

</head>

<body>
	<!-- main header navbar -->
	<nav class="navbar navbar-expand-lg navbar-light custom-navbar" id="mainMenu">
		<div class="container">
			<a class="navbar-brand" href="index.html">
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
										<a href="login.html">
											<button type="button" class="btn submit-btn">登入/註冊</button>
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
				aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
			<div class="collapse navbar-collapse" id="mainNavbar">
				<ul class="navbar-nav main-navbar">
					<li class="nav-item main-navbar__item dropdown">
						<a class="nav-link " href="./designer_protfolio/listAll.html">找作品</a>
					</li>
					<li class="nav-item main-navbar__item dropdown">
						<a class="nav-link " href="#">找設計師</a>
					</li>
					<li class="nav-item main-navbar__item dropdown">
						<a class="nav-link " href="./product/productListAll.html">商城</a>
					</li>
					<li class="nav-item main-navbar__item dropdown">
						<a class="nav-link " href="forumIndex.do">論壇</a>
					</li>
					<!-- <li class="nav-item main-navbar__item dropdown">
                        <a class="nav-link " href="#" data-toggle="dropdown">報導文章</a>
                    </li> -->
					<li class="nav-item main-navbar__item">
						<a class="nav-link" href="contact.html">關於我們</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- end main header navbar -->

	<!-- Posting Start -->
	<div class="forum_container">
        <!--Navigation-->
		<div class="navigate AutoSkip">
			<span>
				<a href="forumIndex.do">論壇首頁</a> >> <a href="topic.do?topicNo=${param.topicNo}&page=1">
					${forumTopicVO.topicName}</a>
			</span>
		</div>
		
		<div class="posting_background">
			<form id="add_form">
				<input type="text" name="title" size="35" placeholder="請輸入標題">
				標題請勿超過50個字
				<br>
				<textarea name="content" id="summernote"></textarea>
				<button type="button" class="new_post_btn" onclick="add()">送出</button>
<!-- 				<input type="hidden" name="action" value="insert"> -->
				<input type="hidden" name="topicNo" value="${param.topicNo}">
				<input type="hidden" name="memberNo" value="${memberVO.memberNo}">
			</form>
		</div>
	</div>
	<!-- Posting End -->

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
							<li class="footer-list__item"><a href="index.html">關於我們</a></li>
						</ul>
					</div>
					<div class="col-lg-3 col-md-6 footer__content">
						<h5 class="footer-heading">網站地圖</h5>
						<ul class="footer-list">
							<li class="footer-list__item"><a href="#">找作品</a></li>
							<li class="footer-list__item"><a href="#">找設計師</a></li>
							<li class="footer-list__item"><a href="#">商城</a></li>
							<li class="footer-list__item"><a href="#">論壇</a></li>
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

	<script src="../js/forum.js"></script>

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
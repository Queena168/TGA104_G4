<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.util.*"%>
<%@ page import="com.portfolio.model.*"%>

<%
PortfolioService portfolioSvc = new PortfolioService();
List<PortfolioVO> list = portfolioSvc.getAll();
pageContext.setAttribute("list", list);

%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>MatDesign</title>
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
<!-- nice select -->
<link rel="stylesheet" href="../css/nice-select.min.css">
<!-- Main Styles -->
<link rel="stylesheet" href="../scss/main.css">
</head>

<body>
	<!-- main header navbar -->
	<nav class="navbar navbar-expand-lg navbar-light custom-navbar"
		id="mainMenu">
		<div class="container">
			<a class="navbar-brand" href="../index.html"> <img
				src="../images/MatDesignLogo.png" alt="">
			</a>
			<!--  navbar actions -->
			<div class="main-navbar-action">
				<div id="mainNavbarDropdown">
					<!-- navbar user account dropdown -->
					<div class="dropdown-wrapper" id="usermenu" data-collapse="false">
						<div class="account-wrapper">
							<!-- login form wrapper -->

							<div class="account-wrapper__content">
								<div class="custom-form__btn custom-form__input">
									<div class="account-wrapper__heading">
										<span>${designerVO.designerAccount}</span>
										<%-- <span
											class="account-wrapper__heading--link">${designerVO.memberName}
										</span> --%>
									</div>
								</div>
								<div class="account-wrapper__content">
									<div class="form-group custom-form__input">
										<a class="dropdown-item " href="designerPorfile.jsp"> <span><i
												class="icon-user-profile"></i></span>設計師資料
										</a>

									</div>
									<div class="form-group custom-form__input">
										<a class="dropdown-item  " href="../index.html"><span><i
												class="icon-log-out"></i></span>登出</a>
									</div>
								</div>

							</div>
							<!-- account links when user is logged in-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-order-tab"><span><i-->
							<!--                            class="icon-shopping-basket"></i></span>Orders</a>-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-address-tab"><span><i-->
							<!--                            class="icon-sign"></i></span>Addresses</a>-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-wishlist-tab"><span><i-->
							<!--                            class="icon-wish-list"></i></span>wishlist</a>-->

						</div>
					</div>
					<!-- navbar cart dropdown -->
					<div class="" id="cartmenu" data-collapse="false"></div>
				</div>
				<!-- navbar user account icon -->
				<div class="main-navbar-action__btn nav-dropdown">
					<a class="dropdown-link" data-target="usermenu"> <i
						class="icon-user"></i>
					</a>
				</div>
				<!-- navbar cart icon -->
				<div class="main-navbar-action__btn nav-dropdown">
					<a class="dropdown-link" data-target="cartmenu"> <span
						class="cart-badge">2</span> <i class="icon-shopping-bag"></i>
					</a>
				</div>
				<!-- navbar actions content -->
			</div>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#mainNavbar" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="mainNavbar">
				<ul class="navbar-nav main-navbar">
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="listAll.html">找作品</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="#">找設計師</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="#">商城</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="#">論壇</a></li>
					<!-- <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="#" data-toggle="dropdown">報導文章</a>
                </li> -->
					<li class="nav-item main-navbar__item"><a class="nav-link"
						href="contact.html">關於我們</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- end main header navbar -->

	<!-- header slider -->
	<div class="container">
		<div class="slider-area hero-header"></div>
	</div>
	<!-- end header slider -->
	<!-- main content -->
	<div class="main-content pt-50 pb-80">
		<div class="container">
			<!-- toolbox -->
			<div class="row">
				<div class="col-12">
					<div class="shop-toolbox">
						<div class="col-12">
							<h2 class="main-title wow fadeIn">最新作品</h2>
						</div>
						<!-- <div class="toolbox-sort">
							<form>
								<div class="form-group">
									<select class="form-control" id="sortOption">
										<option selected>Sort by</option>
										<option>Newest</option>
										<option>Best sellers</option>
										<option>Lowest price</option>
										<option>Highest price</option>
									</select>
								</div>
							</form>
						</div> -->
					</div>
				</div>
			</div>
			<!-- end toolbox -->
			<!-- product list -->
			<div class="row">
				<c:forEach var="portfolioVO" items="${list}">
					<div class="col-lg-4 col-md-6">
						<div class="blog-post blog-post--grid">
							<div class="blog-post__img">
								<div class="blog-post__img--overlay"></div>
								<form method="post" action="PortfolioListOne">
									<img
										src="<%=request.getContextPath()%>/PortfolioPic1?portfolioNo=${ portfolioVO.portfolioNo}"
										alt="">
									<button type="submit" class="btn blog-post__btn">Read
										more</button>
									<input type="submit" class="account-file-input" hidden /> <input
										type="hidden" name="portfolioNo"
										value="${portfolioVO.portfolioNo}"> <input
										type="hidden" name="action" value="portfolio_GetOne">
								</form>
							</div>
							<div class="blog-post__inner">
								<div class="blog-post__inner--title">
									<h4>${portfolioVO.portfolioName}</h4>
								</div>
								<div class="blog-post__inner--details">
									<span class="author">${portfolioVO.designerVO.designerName}</span>
									<span class="date"><fmt:formatDate
											pattern="yyyy-MM-dd HH:mm:ss"
											value="${portfolioVO.createTime}" /></span>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		<!-- pagination -->
		<!-- <div class="row">
			<div class="col-12">
				<div class="shop-pagination">
					<nav aria-label="Page navigation">
						<ul class="pagination custom-pagination">
							<li class="page-item"><a class="page-link" href="#"><i class="fas fa-chevron-left"></i></a></li>
							<li class="page-item active"><a class="page-link" href="#">1</a></li>
							<li class="page-item"><a class="page-link" href="#">2</a></li>
							<li class="page-item"><a class="page-link" href="#">3</a></li>
							<li class="page-item"><a class="page-link" href="#"><i
									class="fas fa-chevron-right"></i></a></li>
						</ul>
					</nav>
					<span class="result"> Showing 1-8 of 12 result </span>
				</div>
			</div>
		</div> -->
		<!-- end pagination -->
	</div>
	<!-- end main content -->
	<!-- Modal search content -->
	<div class="modal fade modal-search" id="searchModal" tabindex="-1"
		aria-labelledby="searchModal" aria-hidden="true">
		<div class="modal-dialog search1" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<i class="fas fa-times"></i>
					</button>
				</div>
				<div class="modal-body">
					<div class="container">
						<ul class="category">
							<li class="category-option active"><a href="#"
								class="product-cat">All</a></li>
							<li class="category-option"><a href="#" class="product-cat">Bedroom</a>
							</li>
							<li class="category-option"><a href="#" class="product-cat">Dining</a>
							</li>
							<li class="category-option"><a href="#" class="product-cat">Living
									room</a></li>
						</ul>
						<form class="search-form form-row" role="search">
							<div class="form-group col-12">
								<input type="search" class="form-control" placeholder="Search">
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end Modal search content -->
	</div>
	<!-- end main content -->
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
							<li class="footer-list__item"><span><i
									class="fas fa-envelope"></i></span> <span>MatDesign@gmail.com</span></li>
						</ul>
					</div>
				</div>
			</div>
			<div class="copyright">
				<p>&#169; copyright 2022. Designed by MatDesign</p>
			</div>
		</div>
	</footer>
	<!-- end footer -->
	<!-- scroll up btn -->
	<a id="back-to-top"></a>
	<!-- end scroll up btn -->
	<!-- loader -->
	<div class="loader">
		<div class="spinner">
			<div class="cube1"></div>
			<div class="cube2"></div>
		</div>
	</div>
	<!-- end loader -->

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


</body>
</html>
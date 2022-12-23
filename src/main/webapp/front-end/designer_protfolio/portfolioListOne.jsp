<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.portfolio.model.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
PortfolioVO portfolioVO = (PortfolioVO) request.getAttribute("portfolioVoSelect");
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
<script src="https://kit.fontawesome.com/6a35b80892.js"
	crossorigin="anonymous"></script>
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
<!-- Boxicon -->
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<!-- Core CSS -->
<link rel="stylesheet" href="/back-end/assets/vendor/css/core.css"
	class="template-customizer-core-css" />

<!-- <link rel='stylesheet'
	href='https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css'> -->
<link rel="stylesheet" href="../css/portfoliotable.css">

</head>

<body>
	<!-- main header navbar -->
	<nav class="navbar navbar-expand-lg navbar-light custom-navbar"
		id="mainMenu">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"> <img
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
										<span class="dropdown-item">${designerVO.designerAccount}</span>
										<%-- <span
											class="account-wrapper__heading--link">${memberVO.memberName}
										</span> --%>
									</div>
								</div>
								<div class="account-wrapper__content">
									<div class="form-group custom-form__input">
										<a class="dropdown-item " href="memberPorfile.jsp"> <span><i
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
						class="nav-link " href="./designer_protfolio/listAll.html">找作品</a>
					</li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="#">找設計師</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="./product/productListAll.html">商城</a></li>
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
	<!-- breadcrumb -->
	<div class="container header-mt">
		<div class="row">
			<div class="col-12">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb custom-breadcrumb">
						<li class="breadcrumb-item"><a href="index.jsp">首頁</a></li>
						<li class="breadcrumb-item"><a href="designerPorfile.jsp">作品管理</a></li>
						<li class="breadcrumb-item active" aria-current="page">${portfolioVoSelect.portfolioName}</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<!-- end breadcrumb -->
	<!-- main content -->
<div class="main-content pb-80">
    <div class="container">
        <div class="row">
            <!-- product image gallery -->
            <div class="col-lg-7">
                <div class="gallery-on-top">
                    <a href="<%=request.getContextPath()%>/PortfolioPic1?portfolioNo=<%=portfolioVO.getPortfolioNo()%>" data-toggle="lightbox"
                       data-gallery="example-gallery">
                        <img src="<%=request.getContextPath()%>/PortfolioPic1?portfolioNo=<%=portfolioVO.getPortfolioNo()%>" alt="">
                    </a>
                </div>
                <!-- product thumbnails -->
                <div class="owl-carousel gallery-thumbs ltr">
                    <div class="item exclude" data-target="<%=request.getContextPath()%>/PortfolioPic1?portfolioNo=<%=portfolioVO.getPortfolioNo()%>">
                        <img src="<%=request.getContextPath()%>/PortfolioPic1?portfolioNo=<%=portfolioVO.getPortfolioNo()%>" alt=""
                             data-target="<%=request.getContextPath()%>/PortfolioPic1?portfolioNo=<%=portfolioVO.getPortfolioNo()%>">
                    </div>
                    <a class="item" data-target="<%=request.getContextPath()%>/PortfolioPic2?portfolioNo=<%=portfolioVO.getPortfolioNo()%>">
                        <img src="<%=request.getContextPath()%>/PortfolioPic2?portfolioNo=<%=portfolioVO.getPortfolioNo()%>" alt=""
                             data-target="<%=request.getContextPath()%>/PortfolioPic2?portfolioNo=<%=portfolioVO.getPortfolioNo()%>">
                    </a>
                    <a class="item" data-target="<%=request.getContextPath()%>/PortfolioPic3?portfolioNo=<%=portfolioVO.getPortfolioNo()%>">
                        <img src="<%=request.getContextPath()%>/PortfolioPic3?portfolioNo=<%=portfolioVO.getPortfolioNo()%>" alt=""
                             data-target="<%=request.getContextPath()%>/PortfolioPic3?portfolioNo=<%=portfolioVO.getPortfolioNo()%>">
                    </a>
                    <a class="item" data-target="<%=request.getContextPath()%>/PortfolioPic4?portfolioNo=<%=portfolioVO.getPortfolioNo()%>">
                        <img src="<%=request.getContextPath()%>/PortfolioPic4?portfolioNo=<%=portfolioVO.getPortfolioNo()%>" alt=""
                             data-target="<%=request.getContextPath()%>/PortfolioPic4?portfolioNo=<%=portfolioVO.getPortfolioNo()%>">
                    </a>
                    
                </div>
            </div>
            <!-- single blog posts -->
            <div class="col-lg-9 col-md-8 single-post">
                <h1 class="single-post__title">${portfolioVoSelect.portfolioName}</h1>
                <div class="single-post__body">
                    <p>${portfolioVoSelect.description}</p>
                </div>
                <div class="single-post__body">
                	<h4 >房屋資訊</h4>
                    <p style="margin-bottom: 0px;">房屋區域：${portfolioVoSelect.houseArea}</p>
                    <p style="margin-bottom: 0px;">屋齡：${portfolioVoSelect.houseAge}</p>
                    <p style="margin-bottom: 0px;">坪數：${portfolioVoSelect.houseSize}</p>
                </div>
                <div class="single-post__footer">
                    <div class="post-details">
                        <span class="author">Post by: <a href="#"><%=portfolioVO.getDesignerVO().getDesignerName()%></a></span>
                        <br>
                        <span class="author">發布時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
														value="${portfolioVoSelect.createTime}" /></span>
                        <span>最新修改時間<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss"
														value="${portfolioVoSelect.modificationTime}" /></span>
                    </div>
                </div>
                <!-- end single blog post -->
                <!-- blog post comments -->
                <!--  comments -->
                <div class="comments mt-70">
                    <!-- comments list -->
                    <!-- comments form -->
                    <form class="comments__form" method="POST" action="PortfolioUpdate">
                        <div class="row">
                            <div class="col-12 comments__form--btn">
                                <button type="submit" class="btn">編輯作品</button>
                                <input type="hidden" name="action" value="getOne_For_Update">
                                <input type="hidden" name="portfolioNo" value="${portfolioVoSelect.portfolioNo}"/>
                            </div>
                        </div>
                    </form>
                    <!-- end comments form -->
                    <!--  end comments list -->
                </div>
                <!--  end comments -->
            </div>
            <!-- end blog post comments -->
        </div>
    </div>
</div>
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
	<!-- table js -->

	<script src="../js/portfoliotable.js"></script>

</body>
</html>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibame.cart.model.*, com.tibame.productorder.model.*"%>

<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>login.jsp</title>

 
 <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Favicon -->
    <link rel="icon" href="../images/favicon.ico" sizes="32x32">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="front-end/css/bootstrap.min.css">
    <!-- Font Awesome -->
    <link rel='stylesheet' href='front-end/css/fontawesome.min.css'>
    <!-- Animate -->
    <link href="front-end/css/animate.css" rel="stylesheet">
    <!-- Owl Carousel -->
    <link rel="stylesheet" href="front-end/css/owl.carousel.min.css">
    <link rel="stylesheet" href="front-end/css/owl.theme.default.min.css">
    <!-- light box -->
    <link rel="stylesheet" href="front-end/css/lightbox.min.css">
    <!-- jquery ui -->
    <link rel="stylesheet" href="front-end/css/jquery-ui.min.css">
    <!--    <link rel="stylesheet" href="//basehold.it/24">-->

    <!-- nice select -->
    <link rel="stylesheet" href="front-end/css/nice-select.min.css">
    <!-- Main Styles -->
    <link rel="stylesheet" href="front-end/scss/main.css">
    <link rel="stylesheet" href="front-end/css/forum_style.css">

    <title>商城首頁</title>
<style type="text/css">
.btn-orange {
    color: #fff;
    background-color: #ff7c07;
    border-color: #ff7c07;
    padding: 5px 20px
}  
</style>  
</head>
<body bgcolor="#FFFFFF">
<!-- main header navbar -->
    <nav class="navbar navbar-expand-lg navbar-light custom-navbar" id="mainMenu">
        <div class="container">
            <a class="navbar-brand" href="index.html">
                <img src="front-end/images/MatDesignLogo.png" alt="">
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
                <a class="nav-link " href="/front-end/order/SelectOrder" >訂單</a>
                <!-- navbar user account icon -->
                <div class="main-navbar-action__btn nav-dropdown">
                    <a class="dropdown-link" data-target="usermenu">
                        <i class="icon-user"></i>
                    </a>
                </div>
                <!-- navbar cart icon -->
                <div class="main-navbar-action__btn nav-dropdown">
                    <a class="dropdown-link" data-target="cartmenu" href="ShowCart">
                        <span class="cart-badge">${cart_list.size()}</span>
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
                        <a class="nav-link " href="/ShowShop">商城</a>
                    </li>
                    <li class="nav-item main-navbar__item dropdown">
                        <a class="nav-link " href="forumIndex.do?">論壇</a>
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
<br>
<br>
<br>
	<div class="main-content pb-80">
		<div class="container">
			<div class="row">
				<div class="col-lg-6 col-md-8 col-12 mx-auto ">
					<div class="custom-form custom-form--box sing-up">

						<%-- 錯誤表列 --%>
						<c:if test="${not empty errorMsgs}">
							<div class="mb-3">
								<ul class="list-unstyled mt-2">
									<li class="card-header">請修正以下錯誤
										<ul>
											<c:forEach var="message" items="${errorMsgs}">
												<li class="form-text" style="color: red">${message}</li>
											</c:forEach>
										</ul>
									</li>
								</ul>
							</div>
						</c:if>
						<%-- /錯誤表列 --%>
						<h3 class="custom-form__title">登入</h3>
						<form action="/TGA104_G4/LoginServlet" method="post">
							<div class="form-group custom-form__input">
								<label for="inputEmail">Email 信箱</label> <input type="email"
									class="form-control ltr" id="inputEmail" placeholder=""
									name="login-email" required>
							</div>
							<div class="form-group custom-form__input">
								<label for="password">密碼</label>
								<div class="input-box password-box">
									<input type="password" class="form-control ltr" id="password"
										placeholder="*****" name="login-password" required>
									<div class="input-box__icon">
										<span class="showhidepassword"><i
											class="far fa-eye-slash"></i></span>
									</div>
								</div>
							</div>
							<div class="forgot-pass">
								<a href="resetpass.html">忘記密碼？</a>
							</div>
							
								<div class="custom-form__btn">
									<button type="submit" class="btn submit-btn">會員登入</button>
								</div>
							

							<div class="custom-form__footer">
								<!-- form footer -->
								<div class="custom-form__footer--link">
									<h6>尚未註冊</h6>
										<div class="custom-form__footer--link">
											<a href="signup.jsp" class="btn ">註冊會員</a>
										</div>
								</div>
							</div>
						</form>
					</div>
				</div>
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
                            <img src="front-end/images/MatDesignLogo.png" alt="">
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
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
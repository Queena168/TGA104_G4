<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tibame.productpic.model.*"%>
<%@ page import="com.tibame.cart.model.*"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>shopProduct.jsp (shopping index)</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
}

table, th, td {
	border: 1px solid #CCCCFF;
}

th, td {
	padding: 5px;
	text-align: center;
		
}
</style>




<!-- 新模板開始 -->
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <!-- Favicon -->
    <link rel="icon" href="front-end/images/favicon.ico" sizes="32x32">
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
<!-- 新模板結束 -->

<style>
.btn-orange {
    color: #fff;
    background-color: #ff7c07;
    border-color: #ff7c07;
    padding: 5px 15px
}
.btn-black {
    color: #fff;
    background-color: #000;
    border-color: #000;
    padding: 5px 15px
}
</style>
    
</head>
<body bgcolor="#FFFFFF">
<nav class="navbar navbar-expand-lg navbar-light custom-navbar" id="mainMenu">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/front-end/index.html">    
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
                                    <a href="./member/login.jsp">
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
                
<!--             <a class="nav-link " href="/front-end/order/SelectOrder" >訂單</a> -->
            
            </div>
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
                aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="mainNavbar">
            <ul class="navbar-nav main-navbar">
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="./designer_protfolio/listAll.html" >找作品</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="#" >找設計師</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="${pageContext.request.contextPath}/ShowShop" >商城</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="#" >論壇</a>
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
<br>
<br>
<br>
	<div class="container">
		<div class="row">
		<c:forEach var="shopProductVO" items="${list}">
			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="<%=request.getContextPath()%>/PicReadServlet?productNo=${shopProductVO.productNo}" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${shopProductVO.productName}</h5>
<%-- 						<h5 class="productNo">${shopProductVO.productNo}</h5> --%>
						<h6 class="price">$${shopProductVO.price}</h6>
<!-- 						<div align="left"> -->
<!-- 							數量： <input type="text" name="quantity" size="1" value=1> -->
<!-- 						</div> -->
						<div class="mt-3 d-flex justify-content-between">
							<a href="${pageContext.request.contextPath}/CartServlet?id=${shopProductVO.productNo}" class="btn btn-black">加入購物車</a>
							<a href="${pageContext.request.contextPath}/OrderNowServlet?id=${shopProductVO.productNo}" class="btn btn-orange">直接購買</a>
<%-- 							<a href="<%=request.getContextPath()%>/OrderNowServlet?quantity=1&id=${shopProductVO.productNo}" class="btn btn-primary">直接購買</a> --%>
<!-- 							<input class="btn btn-dark" type="submit" name="Submit" value="加入購物車"> -->
<!-- 							<input class="btn btn-primary" type="submit" name="Submit" value="直接購買"> -->
						</div>
					</div>
				</div>
			</div>
		</c:forEach>	
		</div>
	</div>
<br>	
<br>	
<br>	
<!-- Footer Start -->
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
		
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>	


</body>
</html>
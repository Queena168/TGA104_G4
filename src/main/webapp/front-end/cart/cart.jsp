<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.* , com.tibame.cart.model.*"%>

<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>cart.jsp</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
 <style type="text/css">
 .table tbody td{
 	vartical-align: middle;
 }
 
 .btn-incre, .btn-decre{
 	box-shadow: none;
 	font-size: 18px;
 	color: #ff7c07;	
 }
 
 .btn-primary {
    color: #fff;
    background-color: #ff7c07;
    border-color: #ff7c07;
}
 </style>
 
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
<!--                 <a class="nav-link " href="/front-end/order/SelectOrder" >訂單</a> -->
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
                        <a class="nav-link " href="${pageContext.request.contextPath}/ShowShop">商城</a>
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
<div class="container">
<div class="d-flex py-3">
<h3>目前累積價格：$ ${(total>0)?total:0}</h3>
<!-- <a class="mx-3 btn btn-primary" href="/TGA104G4/CheckOutServlet">結帳</a> -->
<a class="mx-3 btn btn-orange" href="ShowOrderDetail">結帳</a>
<!-- <a class="mx-3 btn btn-primary" href="http://localhost:8081/TGA104G4/CheckOutServlet">結帳測試選擇</a> -->
</div>
<table class="table table-Lought">
<thead>
<tr>
<th scope="col">商品編號</th>
<th scope="col">商品名稱</th>
<th scope="col">商品價格</th>
<th scope="col">數量</th>

</tr>
</thead>
<tbody>
    <c:forEach var="c" items="${cart_list}">
		<tr>
		<td>${c.productNo}</td>
		<td>${c.productName}</td>
		<td>${c.price}</td>
		<td>${c.quantity}</td>
		<td>
		<form action="OrderNowServlet" method="post" class="form-inline">
		<input type="hidden" name="id" value="${c.productNo}" class="form-input">
		<div class="form-group d-flex justify-content-between w-50">
		<a class="btn-sm btn-decre" href="QuantityIncDecServlet?action=dec&id=${c.productNo}"><i class="fas fa-minus-square"></i></a>
		<input type="text" name="quantity" class="form-control w-50" value="${c.quantity}" readonly>
		<a class="btn-sm btn-incre" href="QuantityIncDecServlet?action=inc&id=${c.productNo}"><i class="fas fa-plus-square"></i></a>
		</div>
<!-- 		<button type="submit" class="btn btn-primary btn-sm">直接購買</button> -->
		</form>
		</td>
		<td><a class="btn btn-sm btn-danger" href="RemoveFromCartServlet?id=${c.productNo}">刪除</a></td>
		</tr>
	</c:forEach>
</tbody>
</table>
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
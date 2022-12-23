<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.* , com.cart.model.*, com.productorder.model.*, com.productorderdetail.model.*"%>
<%
User auth = (User)request.getSession().getAttribute("auth");
List<ProductOrderDetailVO> orders = (List<ProductOrderDetailVO>)request.getAttribute("ordersDetail");
if(auth!=null){
	request.setAttribute("auth", auth);
//     orders = new ProductOrderJDBCDAO().useOrders(auth.getUserNo());
//  	   orders = new ProductOrderJDBCDAO().findOrdersById(30);
}else{
	response.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/login.jsp");
}
%>

<%
ShopProduct shopProduct = (ShopProduct) request.getAttribute("shopProduct");

Cart cart = (Cart) request.getAttribute("cart");
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list"); 
List<Cart> cartProduct = null;
if(cart_list != null){
	ShopProductService shopProductService = new ShopProductService();
	cartProduct = shopProductService.getCartProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
}
%>
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
                    <a class="dropdown-link" data-target="cartmenu" href="http://localhost:8080/TGA104_G4/front-end/cart/cart.jsp">
                        <span class="cart-badge">${cart_list.size()}</span>
                        <i class="icon-shopping-bag"></i>
                    </a>
                </div>
                <div class="main-navbar-action__btn nav-dropdown">
                	<a class="dropdown-link" data-target="cartmenu" href="http://localhost:8080/TGA104_G4/front-end/order/order.jsp">
                    	<span class="cart-badge">訂單</span>
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
                        <a class="nav-link " href="/TGA104_G4/front-end/cart/shopProduct.jsp">商城</a>
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
<div class="card-header my-3">所有訂單</div>
	<table class="table table-light">
		<thead> 
			<tr>
				<th scope="col">訂單編號</th>
				<th scope="col">商品編號</th>
				<th scope="col">商品名稱</th>
				<th scope="col">單價</th>
				<th scope="col">數量</th>
				<th scope="col">金額</th>
			</tr>
		</thead>
		<tbody>
		<%
 			for(ProductOrderDetailVO o:orders){%> 
			<tr>
				<td><%= o.getOrderNo()%></td>
				<td><%= o.getProductNo()%></td>
				<td><%= o.getProductName()%></td>
				<td><%= o.getPrice()%></td>
				<td><%= o.getQty()%></td>
				<td><%= o.getPrice()*o.getQty()%></td>
			</tr>	
			<%}
 		%> 
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


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>	
</body>
</html>
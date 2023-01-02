<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibame.designer.model.*"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>設計師註冊頁 -addDesigner.jsp</title>


<meta charset="utf-8" />
<title>MatDesign</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="Free HTML Templates" name="keywords" />
<meta content="Free HTML Templates" name="description" />

<!-- Favicon -->
<link href="img/favicon.ico" rel="icon" />

<!-- Google Web Fonts -->
<link rel="preconnect" href="https://fonts.gstatic.com" />
<link
	href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600;700&display=swap"
	rel="stylesheet" />

<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css"
	rel="stylesheet" />

<!-- Libraries Stylesheet -->
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/style.css" rel="stylesheet" />
<link href="css/MatDesign.css" rel="stylesheet" />

<!-- Favicon -->
    <link rel="icon" href="<%=request.getContextPath()%>/front-end/images/favicon.ico" sizes="32x32">


    <!-- Font Awesome -->
    <link rel='stylesheet' href='<%=request.getContextPath()%>/front-end/css/fontawesome.min.css'>
    <!-- Animate -->
    <link href="<%=request.getContextPath()%>/front-end/css/animate.css" rel="stylesheet">
    <!-- Owl Carousel -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/owl.carousel.min.css">
    <link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/owl.theme.default.min.css">
    <!-- light box -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/lightbox.min.css">
    <!-- jquery ui -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/jquery-ui.min.css">
    <!--    <link rel="stylesheet" href="//basehold.it/24">-->

    <!-- nice select -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/nice-select.min.css">
    <!-- Main Styles -->
    <link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/scss/main.css">

  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>


<style>
table#table-1 {
	background-color: #CCCCFF;
	border: 2px solid black;
	text-align: center;
}

table#table-1 h4 {
	color: red;
	display: block;
	margin-bottom: 1px;
}

h4 {
	color: blue;
	display: inline;
}
</style>

<style>
table {
	width: 800px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>


<style>
#preview {
	border: 1px solid lightgray;
	display: inline-block;
	width: 150px;
	min-height: 200px;
	position: relative;
	

	
}

#preview span.text {
	position: absolute;
	display: inline-block;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	z-index: -1;
	color: lightgray;
}

#preview img.preview_img {
	width: 100%;
}


.wrap{
    margin: auto;
    margin-left: 500px;
}
.wrap1{
    margin: auto;
    margin-left: 300px;
}


#block1{
margin-left: 200px;
}
#block2{
margin-left: 500px;
}

img{
    max-width:100%; /*不使用width:100% 是因避免圖片解析度不好，隨父元素被放大時會糊掉*/
    height:auto;
}

.intro{
margin-left: 200px;

}
/*
.h2regisiter{
margin-left: 200px;
}
*/


</style>

</head>
<body bgcolor='white'>
	
<!-- main header navbar -->
<nav class="navbar navbar-expand-lg navbar-light custom-navbar" id="mainMenu">
    <div class="container">
        <a class="navbar-brand" href="<%=request.getContextPath()%>/front-end/index.html">    
            <img src="<%=request.getContextPath()%>/front-end/images/MatDesignLogo.png" alt="">
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
                                    <a class="dropdown-item nav-link" href="<%=request.getContextPath()%>/front-end/member/login.jsp">會員登入/註冊</a>
                                    <a class="dropdown-item nav-link" href="<%=request.getContextPath()%>/front-end/designer_protfolio/login.jsp">設計師登入/註冊</a>
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
                    <a class="nav-link " href="<%=request.getContextPath()%>/front-end/designer_protfolio/memFindPortfolio.jsp" >找作品</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="<%=request.getContextPath()%>/ShowDesignerPage" >找設計師</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="<%=request.getContextPath()%>/ShowShop" >商城</a>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="./forum/forumIndex.do" >論壇</a>
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
<!-- main header slider -->
<div class="hero-header-slider">
    <div class="owl-carousel ltr" id="heroHeaderSlider">
        <div class="item">
            <div class="hero-header-slider__img slider-img"
                 style="background-image: url('https://via.placeholder.com/1920x800')">
                <div class="hero-header-slider__wrapper">
                    <div class="slider-inner">
                        <div class="container overflow-hidden">
                            <div class="inner-content inner-content--dark slider-animated">
                                <h5 class="slider-subtitle">New Trend</h5>
                                <h1 class="slider-title animated">A new way to design</h1>
                                <p class="slider-text animated">Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit. Quam, vel.</p>
                                <div class="slider-btn">
                                    <a class="btn animated" href="#">Shop now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="item">
            <div class="hero-header-slider__img slider-img"
                 style="background-image: url('https://via.placeholder.com/1920x800')">
                <div class="hero-header-slider__wrapper">
                    <div class="slider-inner">
                        <div class="container overflow-hidden">
                            <div class="inner-content inner-content--dark slider-animated">
                                <h5 class="slider-subtitle">New Trend</h5>
                                <h1 class="slider-title animated">Stay on trend in new year</h1>
                                <p class="slider-text animated">Lorem ipsum dolor sit amet, consectetur adipisicing
                                    elit. Quam, vel.</p>
                                <div class="slider-btn">
                                    <a class="btn animated" href="#">View more</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- end of main header -->

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	
		


<FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/designer/designer.do"  enctype="multipart/form-data">
<div id="container">
     <!-- <div class="h2regisiter"><h2 >設計師註冊</h2></div> -->
     <div style="text-align: center;"><h2 >設計師註冊</h2></div>  
   <div class="wrap">
  
        <div id="preview">
			<span class="text">預覽圖</span>
		</div> 
   </div>
   <br>
<div id="block1">
<table>
	<tr>
		<td>帳號:</td>
		<td><input type="email" name="designerAccount" size="45" 
			 value="${param.designerAccount}"/></td>
	</tr>
	<tr>
		<td>密碼:</td>
		<td><input type="password" name="designerPassword" size="45"
			 value="${param.designerPassword}"/></td>
	</tr>

	<tr>
		<td>姓名:</td>
		<td><input type="TEXT" name="designerName" size="45"
			 value="${param.designerName}"/></td>
	</tr>
	<tr>
		<td>公司:</td>
		<td><input type="TEXT" name="designerCompany" size="45"
			 value="${param.designerCompany}"/></td>
	</tr>
	
	<tr>
		<td>手機號碼:</td>
		<td><input type="TEXT" name="phone" size="45"
			 value="${param.phone}"/></td>
	</tr>
	
	<tr>
		<td>設計師照片上傳</td>
		<td><input type="file" name="designerPic" id="p_file">
	</tr>
	
	</table>
  <br>
  </div>
  
  <table class=intro>
    <tr>
      <td>簡介</td>
    </tr>
  </table>
  <div class="wrap1">
	 <textarea rows="10" cols="60" placeholder="關於我!" name="designerDetail"></textarea>
  </div>

	
		    
		

<div id="block2">
<input type="hidden" name="action" value="insertdesigner">
<input type="submit" value="送出註冊資料">
</div>
</div>

</FORM>


<!-- footer -->
	<footer class="footer">
		<div class="container">
			<div class="footer__top-row">
				<div class="row">
					<div class="col-lg-4 col-md-6 footer__content">
						<div class="footer-logo">
							<img src="<%=request.getContextPath()%>/front-end/images/MatDesignLogo.png" alt="">
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

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script src="js/MatDesign.js"></script>


</body>
</html>
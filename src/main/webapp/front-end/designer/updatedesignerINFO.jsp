<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibame.designer.model.*"%>
	<%
	DesignerVO designerVO=(DesignerVO) session.getAttribute("designerVO");
	%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>設計師資料修改頁面 -UpdateDesignerINFO.jsp</title>


<meta charset="utf-8" />
<title>MatDesign</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="Free HTML Templates" name="keywords" />
<meta content="Free HTML Templates" name="description" />

<!-- Favicon -->
<link href="<%=request.getContextPath()%>/front-end/designer/img/favicon.ico" rel="icon" />

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
<link href="<%=request.getContextPath()%>/front-end/designer/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->

<link href="<%=request.getContextPath()%>/front-end/designer/css/style.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/front-end/designer/css/MatDesign.css" rel="stylesheet" />

<!-- Favicon -->
<link rel="icon" href="<%=request.getContextPath()%>/front-end/images/favicon.ico" sizes="32x32">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/bootstrap.min.css">
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
<!-- nice select -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/css/nice-select.min.css">
<!-- Main Styles -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/front-end/scss/main.css">
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

</style>

</head>

<body>


<!-- main header navbar -->
	<nav class="navbar navbar-expand-lg navbar-light custom-navbar"
		id="mainMenu">
		<div class="container">
			<a class="navbar-brand" href="<%=request.getContextPath()%>/front-end/index.html"> <img
				src="<%=request.getContextPath()%>/front-end/images/MatDesignLogo.png" alt="" >
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
										<span>${designerVO.designerAccount}</span> <span
											class="account-wrapper__heading--link">${designerVO.designerName}
										</span>
									</div>
								</div>
								<div class="account-wrapper__content">
<!-- 									<div class="form-group custom-form__input"> -->
<!-- 										<a class="dropdown-item " href="memberPorfile.jsp"> <span><i -->
<!-- 												class="icon-user-profile"></i></span>設計師資料 -->
<!-- 										</a> -->
<!-- 									</div> -->
									<div class="form-group custom-form__input">
										<a class="dropdown-item  " href="<%=request.getContextPath()%>/front-end/index.html"><span><i
												class="icon-log-out"></i></span>登出</a>
									</div>
								</div>

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
						class="nav-link " href="<%=request.getContextPath()%>/DesignerEdit?designerNo=${designerVO.designerNo}">編輯簡介</a>
					</li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="<%=request.getContextPath()%>/DesignerOrder?designerNo=${designerVO.designerNo}">案件管理</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="<%=request.getContextPath()%>/DesignerQuotationController?designerNo=${designerVO.designerNo}">報價管理</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="<%=request.getContextPath()%>/DesignerContractController?designerNo=${designerVO.designerNo}">合約管理</a></li>
					<!-- <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="#" data-toggle="dropdown">報導文章</a>
                </li> -->
					<li class="nav-item main-navbar__item"><a class="nav-link"
						href="contact.html">作品管理</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- end main header navbar -->






<!-- 	<!-- Topbar Start --> 
<!-- 	<div class="container-fluid d-none d-lg-block"> -->
<!-- 		<div class="row align-items-center py-4 px-xl-5"> -->
<!-- 			<div class="align-item-center-right"> -->
<%-- 				<form method="post" action="<%=request.getContextPath()%>/DesignerLogout"> --%>
<!-- 			    <input type="hidden" name="logout" value="desginerlogout"> -->
<!-- 				<input  type="submit" class="btn btn-primary py-2 px-4 d-none d-lg-block"  -->
<!-- 				 value="登出" style=" color: #fff; background-color: #FF6600; border-color: #FF6600;" -->
<!-- 			    /> -->
<!-- 			    </form> -->
<!-- 			</div> -->
			
<!-- 			<div class="col-lg-0"> -->
<%-- 				<a href="<%=request.getContextPath()%>/front-end/designer/index.jsp" class="text-decoration-none"> --%>
<!-- 					<h1 class="m-0"> -->
<!-- 						<span class="text-primary">M</span>atDesign -->
<!-- 					</h1> -->
<!-- 				</a> -->
<!-- 			</div> -->

<!-- 		</div> -->
<!-- 	</div> -->
<!-- 	<!-- Topbar End --> 

<!-- 	<!-- Navbar Start --> 
<!-- 	<div class="container-fluid"> -->
<!-- 		<div class="row border-top px-xl-5"> -->

<!-- 			<div class="col-lg-9"> -->
<!-- 				<nav -->
<!-- 					class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0"> -->
<%-- 					<a href="<%=request.getContextPath()%>/front-end/designer/index.jsp" class="text-decoration-none d-block d-lg-none"> --%>
<!-- 						<h1 class="m-0"> -->
<!-- 							<span class="text-primary">M</span>atDesign -->
<!-- 						</h1> -->
<!-- 					</a> -->
<!-- 					<button type="button" class="navbar-toggler" data-toggle="collapse" -->
<!-- 						data-target="#navbarCollapse"> -->
<!-- 						<span class="navbar-toggler-icon"></span> -->
<!-- 					</button> -->
<!-- 					<div class="collapse navbar-collapse justify-content-between" -->
<!-- 						id="navbarCollapse"> -->
<!-- 						<div class="navbar-nav py-0"> -->
<%-- 							<div id="selfedit" style="width: 200px"><a href="<%=request.getContextPath()%>/DesignerEdit?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>編輯簡介</b></a></div> --%>
<%-- 							<div id="ordermanage" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerOrder?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>案件管理</b></a></div> --%>
<!-- 							<div id="quotation" style="width: 200px"><a  href="course.html" class="nav-item nav-link"><b>報價</b></a></div> -->
<!-- 							<div id="contract" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>合約</b></a></div> -->
<!-- 							<div id="portfolio" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>作品管理</b></a></div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 				</nav> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	<!-- Navbar End -->
<hr size="8px" align="center" width="100%" >

<div style="text-align: center;"><h2>基本資料修改</h2></div> 

<FORM METHOD="post" ACTION="check" name="form1"  enctype="multipart/form-data">
<div id="container">


   <div class="wrap">
  
        <div id="preview">
			<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100% alt="" />
		</div> 
   </div>
<div id="block1">
<table>
    <tr>
		<td><input type="hidden"></td>
		<td><input type="hidden" name="designerAccount" size="45" 
		   value="${designerVO.designerNo}" readonly/></td>
	</tr>
	
	<tr>
		<td>設計師帳號:<font color=red><b>*</b></font></td>
		<td><input type="TEXT" name="designerAccount" size="45" 
			 value="${designerVO.designerAccount}" readonly/></td>
		
	</tr>
		
	<tr>
		<td>設計師姓名:</td>
		<td><input type="TEXT" name="designerName" size="45" 
			 value="${designerVO.designerName}"/></td><td>${errorMsgs.designerName}</td>
	</tr>

	<tr>
		<td>設計師密碼:</td>
		<td><input type="PASSWORD" name="designerPassword" size="45"
			 value="${designerVO.designerPassword}"/></td><td>${errorMsgs.designerPassword}</td>
	</tr>
	<tr>
		<td>公司:</td>
		<td><input type="TEXT" name="designerCompany" size="45"
			 value="${designerVO.designerCompany}"/></td><td>${errorMsgs.designerCompany}</td>
	</tr>
	
	
	
	<tr>
		<td>設計師照片上傳</td>
		<td><input type="file" name="designerPic" id="p_file">
	</tr>
	</table>
</div>	


  <table class=intro>
    <tr>
      <td>簡介</td>
    </tr>
  </table>

 <div class="wrap1">
	 <textarea rows="10" cols="60"  name="designerDetail">${designerVO.designerDetail}</textarea>
	  <!--  <textarea rows="10" cols="60" name="自我介紹" placeholder="關於我!" name="designerDetail"></textarea>-->
  </div>

        <div id="block2">
              <input type="hidden" name="action" value="update">
              <input type="hidden" name="designerNo" value="${param.designerNo}">
              <input type="submit" value="送出修改">
              
              <input type="hidden" name="action" value="cancel">
              <input type="hidden" name="designerNo" value="${param.designerNo}">
              <input type ="button" onclick="history.back()" value="取消"></input>
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
<script src="<%=request.getContextPath()%>/front-end/designer/js/MatDesign.js"></script>

<!-- All Jquery -->
 <script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/jquery.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/popper.min.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/bootstrap.min.js"></script>
<!-- owl carousel js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/owl.carousel.min.js"></script>
<!-- Jquery ui -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/jquery-ui.min.js"></script>
<!-- light box js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/lightbox.min.js"></script>
<!-- typeahead js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/typeahead.jquery.min.js"></script>
<!-- master zoom image js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/jquery.zoom.min.js"></script>
<!-- countdown js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/countdown.jquery.min.js"></script>
<!-- nice select js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/nice-select.min.js"></script>
<!-- <!-- wow js  -->
 <script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/wow.min.js"></script> 
<!-- <!-- custom js  -->
 <script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/custom.js"></script>
	
</body>
</html>
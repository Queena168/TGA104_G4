<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibame.designer.model.*" %>



<html>
<head>
<title>合約 - listOneContract.jsp</title>

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
	width: 1300px;
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
margin-left: 50px;
}

img{
    max-width:100%; /*不使用width:100% 是因避免圖片解析度不好，隨父元素被放大時會糊掉*/
    height:auto;
}

.intro{
margin-left: 200px;

}

</style>



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
	width: 1300px;
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
  
 .block{
  width: 1263px;
  height: 75px;
  }
</style>

</head>
<body bgcolor='white'>

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
	
	<div class="block"></div>	
<hr size="8px" align="center" width="100%" >
<div style="text-align:center"><h3>案件合約</h3></div>
<div align="center">
<form action="AddContract">
<table>
		<tr><th>案件編號</th><td>${designerOrderVO.orderNo}</td></tr>
		<tr><th>客戶</th><td>${designerOrderVO.memberVO.memberName}</td></tr>
		<tr><th>案件設計師</th><td>${designerOrderVO.designerVO.designerName}</td></tr>
	    <!--<tr><th>報價狀態</th><td>${designerOrderVO.quotationStatus}  </td></tr>	  
	    <tr><th>報價同意時間</th><td>${designerOrderVO.quotationApprovalTime}</td></tr>-->    
	   <tr>
	     <th>報價金額</th>
	      <c:choose>
				<c:when test="${designerOrderVO.quotationAmount==0}">
	                <td> 元</td>
	            </c:when>
	            <c:when test="${designerOrderVO.quotationAmount!=0}">
	                <td>${designerOrderVO.quotationAmount}元</td>
	            </c:when>
	      </c:choose>	    
	    </tr>
		<tr><th>報價內容</th><td>${designerOrderVO.quotationDetail}</td></tr>
		
        <tr><th>合約附件</th>
        <c:choose>
        <c:when test="${designerOrderVO.contractAtt!=null}">
        <td><a href="#" onclick="window.open(
	    '<%=request.getContextPath()%>/Contractinfo?orderNo=${designerOrderVO.orderNo}'
	    , '_blank').focus();">下載合約</a></td>
	    </c:when>
	    
	    <c:when test="${designerOrderVO.contractAtt==null}">
	    <td>無合約附件</td>
	    </c:when>
	    </c:choose>
	    </tr> 
	    <tr><th>合約狀態</th><td>${designerOrderVO.contractStatus}</td></tr>
	    <tr><th>合約內容</th><td>${designerOrderVO.contractDetail}</td></tr>
	  

</table>
     <div id="block2">
              <input type="hidden" name="action" value="insertcontract">
              <input type="hidden" name="orderNo" value="${designerOrderVO.orderNo}">
              <input id="showorhidden1" type="submit" value="製作合約" style="display: inline-block;">
              
               <input type="hidden" name="action" value="updatecontract">
              <input type="hidden" name="orderNo" value="${designerOrderVO.orderNo}">
              <input id="showorhidden2" type="submit" value="修改合約" style="display: inline-block;">
              
              <input type ="button" onclick="history.back()" value="回上一頁" >
     </div> 
</form>
</div>


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
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/designer/js/btnscontrolcontract.js"></script>
<script type="text/javascript">
var log1 = '${designerOrderVO.orderNo}';
var type='${designerOrderVO.contractStatus}';
DisplayAndHiddenBtn("showorhidden1",type);
DisplayAndHiddenBtn("showorhidden2",type);
</script>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibame.designer.model.*" %>

<html>
<head>
<title>案件進度更新 - UpdatelistOneOrderPhase.jsp</title>

<meta charset="utf-8" />
<title>MatDesign</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="Free HTML Templates" name="keywords" />
<meta content="Free HTML Templates" name="description" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge">

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


#t1 {
   height: 100%; /*高度填充*/
   width: 100%;
   padding: 0; /*防止textarea超過td邊框*/
   vertical-align: bottom; /*chrome的td有margin-top情況 用此CSS調整*/
   border: none; /*border用td的*/
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
	width: 1100px;
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
  
  
    .logintitle{
  position: absolute;
  width:100px;
  right: 180px;
  }
  
  #t1 {
   height: 100%; /*高度填充*/
   width: 100%;
   padding: 0; /*防止textarea超過td邊框*/
   vertical-align: bottom; /*chrome的td有margin-top情況 用此CSS調整*/
   border: none; /*border用td的*/
}
</style>

</head>
<body bgcolor='white'>

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
                aria-expanded="false" aria-label="Toggle navigation"><span
                class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="mainNavbar">
            <ul class="navbar-nav main-navbar">
                <li class="nav-item main-navbar__item dropdown">
                   <div id="selfedit" style="width: 200px"><a href="<%=request.getContextPath()%>/DesignerEdit?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>編輯簡介</b></a></div>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <div id="ordermanage" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerOrder?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>案件管理</b></a></div>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <div id="quotation" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerQuotationController?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>報價管理</b></a></div>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                   <div id="contract" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerContractController?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>合約管理</b></a></div>
                </li>
                <li class="nav-item main-navbar__item dropdown">
                    <div id="portfolio" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>作品管理</b></a></div>
                </li>
                <!-- <li class="nav-item main-navbar__item">
                    <a class="nav-link" href="contact.html">關於我們</a>
                </li> -->
            </ul>
        </div>
    </div>
</nav>
<!-- end main header navbar -->

<hr size="8px" align="center" width="100%" >
<div style="text-align:center"><h3>案件進度查看</h3></div>
<div align="center">
<form id="form" method="post">
<table> 
        <c:forEach var="designerOrderPhaseVO" items="${list}" begin="0" end="0">
		<tr><th>案件編號:</th><td>${designerOrderPhaseVO.orderNo}</td></tr>
		
		<tr><th>客戶:</th><td>${designerOrderVO.memberVO.memberName}</td></tr>
		<tr><th>案件設計師</th><td>${designerOrderVO.designerVO.designerName}</td></tr> 
		<tr><th>合約總期數</th><td>${designerOrderPhaseVO.totalOrderPhase}期</td></tr>  
        </c:forEach>
		<tr>
		<th>裝潢進度</th>
		<td>
		
		   <select id="selection" name="constructionStatus" disabled="disabled">
		   <c:forEach var="designerOrderPhaseVO" items="${list}">
               <option  value="未開始">請選擇進度</option>
               <option value="第一期施工開始" ${designerOrderPhaseVO.constructionStatus=="第一期施工開始"?'selected':''}>第一期施工開始</option>
               <option value="第一期施工結束" ${designerOrderPhaseVO.constructionStatus=="第一期施工結束"?'selected':''}>第一期施工結束</option>
               <option value="第二期施工開始" ${designerOrderPhaseVO.constructionStatus=="第二期施工開始"?'selected':''}>第二期施工開始</option>
               <option value="第二期施工結束" ${designerOrderPhaseVO.constructionStatus=="第二期施工結束"?'selected':''}>第二期施工結束</option>
               <option value="第三期施工開始" ${designerOrderPhaseVO.constructionStatus=="第三期施工開始"?'selected':''}>第三期施工開始</option>
               <option value="第三期施工結束" ${designerOrderPhaseVO.constructionStatus=="第三期施工結束"?'selected':''}>第三期施工結束</option>
            </c:forEach>
           </select>
       
        </td>
		</tr>	
		 
	    
	    
	    <tr>
		<th>付款進度</th>
		<td>
		
		   <select id="selectionpayment" name="paymentStatus" disabled="disabled">
		   <c:forEach var="designerOrderPhaseVO" items="${list}" >
               <option value="未付款">未付款</option>
               <option value="第一期付款完成" ${designerOrderPhaseVO.paymentStatus=="第一期付款完成"?'selected':''}>第一期付款完成</option>
               <option value="第二期付款完成" ${designerOrderPhaseVO.paymentStatus=="第二期付款完成"?'selected':''}>第二期付款完成</option>
               <option value="第三期付款完成" ${designerOrderPhaseVO.paymentStatus=="第三期付款完成"?'selected':''}>第三期付款完成</option>
           </c:forEach>
           </select>
         
        </td>
		</tr>	
	
	    
</table>
     <div id="block2">
              <input type="hidden" name="finishstatus" value="${designerOrderVO.finishStatus}">
              <input type="hidden" name="orderNo" value="${designerOrderVO.orderNo}">
              <input id="btn1" type="button" value="更新裝潢進度" style="display: inline-block;"> 
              
              <input type="hidden" name="orderNo" value="${designerOrderPhaseVO.orderNo}">
              <input id="btn2" type="button" value="更新付款進度" style="display: inline-block;">       
              
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


<!-- All Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/popper.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- owl carousel js -->
<script type="text/javascript" src="js/owl.carousel.min.js"></script>
<!-- Jquery ui -->
<script type="text/javascript" src="js/jquery-ui.min.js"></script>
<!-- light box js -->
<script type="text/javascript" src="js/lightbox.min.js"></script>
<!-- typeahead js -->
<script type="text/javascript" src="js/typeahead.jquery.min.js"></script>
<!-- master zoom image js -->
<script type="text/javascript" src="js/jquery.zoom.min.js"></script>
<!-- countdown js -->
<script type="text/javascript" src="js/countdown.jquery.min.js"></script>
<!-- nice select js -->
<script type="text/javascript" src="js/nice-select.min.js"></script>
<!-- wow js -->
<script type="text/javascript" src="js/wow.min.js"></script>
<!-- custom js -->
<script type="text/javascript" src="js/custom.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/designer/js/btnscontrolupdateorderphase.js"></script>
<script type="text/javascript">
var type='${designerOrderVO.finishStatus}';
DisplayAndHiddenBtn("btn1",type);
DisplayAndHiddenBtn("btn2",type);
</script>

</body>
</html>
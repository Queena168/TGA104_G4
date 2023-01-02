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


#t1 {
   height: 100%; /*高度填充*/
   width: 100%;
   padding: 0; /*防止textarea超過td邊框*/
   vertical-align: bottom; /*chrome的td有margin-top情況 用此CSS調整*/
   border: none; /*border用td的*/
}

</style>


<style>
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
  
  
  #t1 {
   height: 100%; /*高度填充*/
   width: 100%;
   padding: 0; /*防止textarea超過td邊框*/
   vertical-align: bottom; /*chrome的td有margin-top情況 用此CSS調整*/
   border: none; /*border用td的*/
}



  .block{
  width: 1263px;
  height: 70px;
  }
</style>

</head>
<body bgcolor='white'>

<!-- main header navbar -->
<nav class="navbar navbar-expand-lg navbar-light custom-navbar" id="mainMenu">
    <div class="container">
        <a class="navbar-brand" href="index.html">    
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
<div class="block"></div>	
<hr size="8px" align="center" width="100%" >
<div style="text-align:center"><h3>案件進度查看</h3></div>
<div align="center">
<form id="form" method="post" action="SendOrderPhase">
<table>        
		<tr><th>案件編號</th><td>${designerOneOrderPhaseVO.orderNo}</td></tr>		
		<tr><th>客戶</th><td>${designerOrderVO.memberVO.memberName}</td></tr>
		<tr><th>案件設計師</th><td>${designerOrderVO.designerVO.designerName}</td></tr> 		
		<tr><th>合約總期數</th><td>${designerOneOrderPhaseVO.totalOrderPhase}期</td></tr>  
		<tr>
		<th>當前裝潢進度</th>
		<td>
		<input id="phasenumber" name="phasenumber" type="number" style="width: 50px" min="1" max="10" value="${designerOneOrderPhaseVO.orderPhase}" disabled="disabled">期
     	   <select id="selection" name="constructionStatus" disabled="disabled">		   
               <option  value="尚未施工" ${designerOneOrderPhaseVO.constructionStatus=="尚未施工"?'selected':''}>尚未施工</option>
               <option value="進行中" ${designerOneOrderPhaseVO.constructionStatus=="進行中"?'selected':''}>進行中</option>
               <option value="完成施工" ${designerOneOrderPhaseVO.constructionStatus=="完成施工"?'selected':''}>完成施工</option>
           </select>       
        </td>
		</tr>	
		
        <tr>
		<th>進度說明</th>
		<td>
		    <textarea id="t1" placeholder="請輸入內容!" name="orderPhaseDetail" disabled="disabled">${designerOneOrderPhaseVO.orderPhaseDetail}</textarea>		
		</td>
		</tr>

	
	    
</table>
     <div id="block2">
              <input type="hidden" name="finishstatus" value="${designerOrderVO.finishStatus}">
              <input type="hidden" name="orderNo" value="${designerOrderVO.orderNo}">
              <input type="hidden" name="totalOrderPhase" value="${designerOneOrderPhaseVO.totalOrderPhase}">
              <input id="btncontrust" type="button" value="更新裝潢進度" style="display: inline-block;"> 
              <input id="cancel1" type="button" value="取消" style="display: inline-block;">            
     </div> 
</form>
</div>


<div align="center">
<form  id="form2" action="SendOrderPayment">
<table>
 <tr>
		 <th>付款金額</th>
		 <td>
		     <input id="paymentnumber" name="paymentnumber" type="number" style="width: 150px"  value="${designerOneOrderPhaseVO.amount}" disabled="disabled">元
		 </td>
		 </tr>
		     
	    <tr>
		<th>付款進度</th>
		<td>
		   <select id="selectionpayment" name="paymentStatus" disabled="disabled">
               <option value="尚未付款" ${designerOneOrderPhaseVO.paymentStatus=="尚未付款"?'selected':''}>尚未付款</option>
               <option value="完成付款" ${designerOneOrderPhaseVO.paymentStatus=="完成付款"?'selected':''}>完成付款</option>
           </select>        
        </td>
		</tr>	
 </table>
        <div id="block2">	
            <input id="btnpayment" type="button" value="更新付款進度" style="display: inline-block;"> 
            <input id="cancel2" type="button" value="取消" style="display: inline-block;">      
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


<!-- All Jquery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
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
<!-- wow js -->
<script type="text/javascript" src="<%=request.getContextPath()%>/front-end/js/wow.min.js"></script>


<script type="text/javascript">

var btn1 = document.getElementById("btncontrust");
var select1 = document.getElementById("selection");
var phasenumber = document.getElementById("phasenumber");
var textarea = document.getElementById("t1");
var form = document.getElementById("form");
var form2 = document.getElementById("form2");
var cancel1 = document.getElementById("cancel1");
var cancel2 = document.getElementById("cancel2");
btn1.addEventListener("click",function(){
	if(select1.hasAttribute("disabled")){
		select1.removeAttribute("disabled");
		phasenumber.removeAttribute("disabled");
		textarea.removeAttribute("disabled");
		select1.setAttribute("test","test");
		phasenumber.setAttribute("test","test");
		textarea.setAttribute("test","test");
		
	}else{
		//form.setAttribute("action","SendOrderPhase");
		form.submit();
	}
		
});	


cancel1.addEventListener("click",function(){
	if(select1.hasAttribute("test")){
		select1.removeAttribute("test");
		phasenumber.removeAttribute("test");
		textarea.removeAttribute("test");
		select1.setAttribute("disabled","disabled");
		phasenumber.setAttribute("disabled","disabled");
		textarea.setAttribute("disabled","disabled");		
	}
});	
	
	
//===============================================================	
	//點擊付款狀態下拉選單及更新付款狀態下拉選單
var btn2 = document.getElementById("btnpayment");
var select2 = document.getElementById("selectionpayment");
var paymentnumber =  document.getElementById("paymentnumber");
//var form1 = document.getElementById("form1");
btn2.addEventListener("click",function(){
	if(select2.hasAttribute("disabled")){
		paymentnumber.removeAttribute("disabled");
		select2.removeAttribute("disabled");
		paymentnumber.setAttribute("test","test");
		select2.setAttribute("test","test");
	}else{
		//form2.setAttribute("action","SendOrderPayment");
		form2.submit();
	}
		
});



cancel2.addEventListener("click",function(){
	if(select2.hasAttribute("test")){
		paymentnumber.removeAttribute("test");
		select2.removeAttribute("test");
		paymentnumber.setAttribute("disabled","disabled");
		select2.setAttribute("disabled","disabled");	
	}
});	
//================================================================
	//狀態為結案時實作更新裝潢進度及付款進度按鈕隱藏及出現
	
	
function DisplayAndHiddenBtn(btnName, type) {
	 var currentinputbutton = document.getElementById(btnName);
   if (type == 'true') {
	   //currentinputbutton.style.display = "inline-block"; //style中的display且橫向排列属性
	   document.getElementById("btncontrust").style.display = "none";	
	   document.getElementById("btnpayment").style.display = "none";
	   document.getElementById("cancel1");
	   document.getElementById("cancel2");
   }else{
	   currentinputbutton.style.display = "inline-block"; 
   }
	 
}


</script>



<script type="text/javascript">
var type='${designerOrderVO.finishStatus}';
DisplayAndHiddenBtn("btncontrust",type);
DisplayAndHiddenBtn("btnpayment",type);
</script>

</body>
</html>
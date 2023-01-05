<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="com.tibame.designer.model.*" %>





<html>
<head>
<title>所有設計師資料-findDesigner.jsp</title>
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
      crossorigin="anonymous"></script>

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
  

  
  .content_box_grey {
    display: block;
    width: 100%;
    background-color: #ededed;
    overflow: hidden;
    padding-bottom: 60px;
}
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



<!--<table id="table-1"> -->
<!--	<tr><td> -->
<!--		 <h3>所有設計師資料</h3> -->
<!--		 <h4><a href="select_designer_page.jsp">回設計師查詢頁面</a></h4> -->
	<!--</td></tr> -->
<!--</table> -->

<!--<table>-->

<!-- Topbar Start -->
<!-- 	<div class="container-fluid d-none d-lg-block"> -->
<!-- 		<div class="row align-items-center py-4 px-xl-5"> -->
		
<!-- 		<div class="align-item-center-right"> -->
<!-- 				<a href="#" type="button" -->
<!-- 					class="btn btn-primary py-2 px-4 d-none d-lg-block" -->
<!-- 					data-bs-toggle="modal" data-bs-target="#loginModal" style=" color: #fff; background-color: #FF6600; border-color: #FF6600;">登入/註冊</a> -->
<!-- 			</div> -->
		
		
		
<!-- 			<div class="modal fade" id="loginModal"> -->
<!-- 				<div class="modal-dialog"> -->
<!-- 					<div class="modal-content"> -->
<!-- 						Registration Start -->
						
<!-- 						<div class="container-fluid bg-registration py-5" -->
<!-- 							style="margin: 30px 0"> -->
<!-- 							<div class="col-lg-5"> -->
<!-- 								<div id="cardborder" class="card border-0"> -->
<!-- 									tab標籤開始 -->
<!-- 									<div class="h-swicher-wrapper container"> -->
<!-- 										<div class="row justify-content-center"> -->
<!-- 											<div class="col-md-10 d-flex justify-content-center py-4"> -->
<!-- 												<div class="h-swicher"> -->
<!-- 												<input type="hidden" name="action" value="memberlogin"> -->
<!-- 												 <input type="radio" name="login" id="memberlogin" checked="checked" class="swicher-input swicher-input-memberlogin" /> -->
<!-- 												 <label	for="memberlogin" class="swicher-label">會員登入</label>  -->
<!-- 												 <input type="hidden" name="action" value="designerlogin"> -->
<!-- 												 <input	type="radio" name="login" id="designerlogin" class="swicher-input swicher-input-designerlogin" />  -->
<!-- 												 <label	for="designerlogin" class="swicher-label">設計師登入</label> -->
<!-- 												        <span	class="switcher-toggle"></span> -->
<!-- 												</div> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->

<!-- 									tab標籤結束 -->
<%-- 									<form method="post" action="<%=request.getContextPath()%>/Login" enctype="multipart/form-data"> --%>
<!-- 									<div class="card-body rounded-bottom bg-primary p-5"> -->
<!-- 									<form> -->
<!-- 											<div class="form-group"> -->
<!-- 												<input type="email" class="form-control border-0 p-4" -->
<!-- 													placeholder="帳號" required="required" name="account"/> -->
<!-- 											</div> -->
<!-- 											<div class="form-group"> -->
<!-- 												<input type="password" class="form-control border-0 p-4" -->
<!-- 													placeholder="密碼" required="required"  name="password"/> -->
<!-- 											</div> -->
<!-- 										<div class="form-group"></div>	 -->
<!-- 											<input type="checkbox" class="remember" />記住我的密碼	 -->
<!-- 											<div> -->
<!-- 											    <input type="hidden" id="loginattr" name="login" value="memberlogin"/>  -->
<!-- 												<input  class="btn btn-dark btn-block border-0 py-3" -->
<!-- 													type="submit" value="登入"  style=" color: #fff; -->
<!--                                                     background-color: #44425A;border-color: #44425A;"> -->
<!-- 											</div> -->
<!-- 										</form> -->
<!-- 										Footer -->
<!-- 										<div class="modal-footer"> -->
<!-- 											<div class="signup"> -->
<!-- 												<span style="color: black; font-weight: bold">尚未成為會員</span> -->
<!-- 												<a href="#" type="button" class="member" -->
<!-- 													style="color: black; font-weight: bold"> <u>加入會員</u></a> -->
<!-- 											</div> -->
											
<!-- 											<div class="signup"> -->
<!-- 												<span style="color: black; font-weight: bold">加入設計團隊</span> -->
<!-- 												<a href="addDesigner.jsp" type="button" class="designer" -->
<!-- 													style="color: black; font-weight: bold"><u> 成為夥伴 </u></a> -->
<!-- 											</div> -->
<!-- 										</div> -->
<!-- 									</div> -->
<!-- 									</form> -->
<!-- 								</div> -->
<!-- 							</div> -->
<!-- 						</div> -->
						
<!-- 						Registration End -->
<!-- 					</div> -->
<!-- 				</div> -->
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
<!-- 							<div id="selfedit" style="width: 200px"><a  href="index.html" class="nav-item nav-link"><b>找作品</b></a></div> -->
<%-- 							<div id="ordermanage" style="width: 200px"><a  href="<%=request.getContextPath()%>/ShowDesignerPage" class="nav-item nav-link"><b>找設計師</b></a></div> --%>
<!-- 							<div id="quotation" style="width: 200px"><a  href="course.html" class="nav-item nav-link"><b>商城</b></a></div> -->
<!-- 							<div id="contract" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>論壇</b></a></div> -->
<!-- 							<div id="portfolio" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>報導文章</b></a></div> -->
<!-- 						</div> -->
<!-- 					</div> -->
					
<!-- 				</nav> -->
<!-- 			</div> -->
<!-- 		</div> -->
<!-- 	</div> -->
	
	
	
	
	<!-- Navbar End -->
	
<!--  -->

<hr color="gray">
<div style="text-align:center"><h3>找設計師</h3></div>
<div class="content_box_grey">
  <div>&emsp;&emsp;<font size="4px" color="black">設計強項</font></div>
  <div>
     <div align="center">
      <ul style="display: inline-flex;">
       <c:forEach var="expertoseVOlist" items="${expertoseVOlist}">
       
         <form id="expertiseform" METHOD="get" action="ExpertiseSearch?expertiseNo=${expertoseVOlist.expertiseNo }">
           
        
            <input type="hidden" name="expertiseno" value="${expertoseVOlist.expertiseNo}">
            <input type="submit" value="${expertoseVOlist.expertiseName}" /> &emsp;&emsp;
   
         
        </form>
        
        </c:forEach> 
         </ul> 
     </div>
  </div>
 
</div>

<!-- Team Start -->
	
		<div class="container pt-5 pb-3">
			<div class="text-center mb-5">
				<h2 class="text-primary text-uppercase mb-3"
					style="letter-spacing: 5px">設計師</h2>
				<!--  <h1>熱門設計師</h1>-->
			</div>
		
			<div class="row">
		<c:forEach var="designerExpertiseVO"  items="${set}" begin="0" end="7">
				<div class="col-md-6 col-lg-3 text-center team mb-4">	
				
					<form method="post" ACTION="<%=request.getContextPath()%>/designerExpertise?designerNo=${designerExpertiseVO.designerNo}" >		
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">				
	<!-- 設計師圖片 -->		<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerExpertiseVO.designerNo}" width=100% alt="" />
							<div class="team-social">		
							<input type="hidden" name="action" value="designerinfo">
							<input type="submit" class="btn btn-outline-light" value="查看">
							</div>
						</div>
						<div class="bg-secondary p-4">					
	<!-- 設計師姓名 -->						<h5>${designerExpertiseVO.designerVO.designerName}</h5>		
	<!-- 設計師公司 -->						<p class="m-0">${designerExpertiseVO.designerVO.designerCompany}</p>  
	                               <input type="hidden" name="designerNo" size="45" 
		                                      value="${designerExpertiseVO.designerNo}"/>                               	   
		                                    
	  
						</div>
					</div>
				</form>
				</div>
			</c:forEach>
		</div>
	</div>
	<!-- Team End -->
	
	
	
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
	
	
	
		<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/designer/lib/easing/easing.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/designer/lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Contact Javascript File -->
	<script src="<%=request.getContextPath()%>/front-end/designer/mail/jqBootstrapValidation.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/designer/mail/contact.js"></script>

	<!-- Template Javascript -->
	<script src="<%=request.getContextPath()%>/front-end/designer/js/main.js"></script>
	<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>	
	<script src="<%=request.getContextPath()%>/front-end/designer/js/login.js"></script>
	
	
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
	
<!-- 	<script type="text/javascript"> -->
// 	var btn3 =  document.getElementById("btn3");
// 	var expertiseform =  document.getElementById("expertiseform");
// 	btn3.addEventListener("click",function(){
// 		expertiseform.submit();
			
// 	});
	
<!-- 	</script> -->

	
	
</body>
</html>
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


<!--<table id="table-1"> -->
<!--	<tr><td> -->
<!--		 <h3>所有設計師資料</h3> -->
<!--		 <h4><a href="select_designer_page.jsp">回設計師查詢頁面</a></h4> -->
	<!--</td></tr> -->
<!--</table> -->

<!--<table>-->

<!-- Topbar Start -->
	<div class="container-fluid d-none d-lg-block">
		<div class="row align-items-center py-4 px-xl-5">
		
		<div class="align-item-center-right">
				<a href="#" type="button"
					class="btn btn-primary py-2 px-4 d-none d-lg-block"
					data-bs-toggle="modal" data-bs-target="#loginModal" style=" color: #fff; background-color: #FF6600; border-color: #FF6600;">登入/註冊</a>
			</div>
		
		
		
			<div class="modal fade" id="loginModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- Registration Start -->
						
						<div class="container-fluid bg-registration py-5"
							style="margin: 30px 0">
							<div class="col-lg-5">
								<div id="cardborder" class="card border-0">
									<!-- tab標籤開始 -->
									<div class="h-swicher-wrapper container">
										<div class="row justify-content-center">
											<div class="col-md-10 d-flex justify-content-center py-4">
												<div class="h-swicher">
												<input type="hidden" name="action" value="memberlogin">
												 <input type="radio" name="login" id="memberlogin" checked="checked" class="swicher-input swicher-input-memberlogin" />
												 <label	for="memberlogin" class="swicher-label">會員登入</label> 
												 <input type="hidden" name="action" value="designerlogin">
												 <input	type="radio" name="login" id="designerlogin" class="swicher-input swicher-input-designerlogin" /> 
												 <label	for="designerlogin" class="swicher-label">設計師登入</label>
												        <span	class="switcher-toggle"></span>
												</div>
											</div>
										</div>
									</div>

									<!-- tab標籤結束 -->
									<form method="post" action="<%=request.getContextPath()%>/Login" enctype="multipart/form-data">
									<div class="card-body rounded-bottom bg-primary p-5">
									<!-- <form> -->
											<div class="form-group">
												<input type="email" class="form-control border-0 p-4"
													placeholder="帳號" required="required" name="account"/>
											</div>
											<div class="form-group">
												<input type="password" class="form-control border-0 p-4"
													placeholder="密碼" required="required"  name="password"/>
											</div>
										<!-- <div class="form-group"></div> -->	
										<!--	<input type="checkbox" class="remember" />記住我的密碼 -->	
											<div>
											    <input type="hidden" id="loginattr" name="login" value="memberlogin"/> 
												<input  class="btn btn-dark btn-block border-0 py-3"
													type="submit" value="登入"  style=" color: #fff;
                                                    background-color: #44425A;border-color: #44425A;">
											</div>
									<!-- 	</form> -->
										<!-- Footer -->
										<div class="modal-footer">
											<div class="signup">
												<span style="color: black; font-weight: bold">尚未成為會員</span>
												<a href="#" type="button" class="member"
													style="color: black; font-weight: bold"> <u>加入會員</u></a>
											</div>
											
											<div class="signup">
												<span style="color: black; font-weight: bold">加入設計團隊</span>
												<a href="addDesigner.jsp" type="button" class="designer"
													style="color: black; font-weight: bold"><u> 成為夥伴 </u></a>
											</div>
										</div>
									</div>
									</form>
								</div>
							</div>
						</div>
						
						<!-- Registration End -->
					</div>
				</div>
			</div>

			<div class="col-lg-0">
				<a href="<%=request.getContextPath()%>/front-end/designer/index.jsp" class="text-decoration-none">
					<h1 class="m-0">
						<span class="text-primary">M</span>atDesign
					</h1>
				</a>
			</div>

		</div>
	</div>
	<!-- Topbar End -->

	<!-- Navbar Start -->
	
	<div class="container-fluid">
		<div class="row border-top px-xl-5">

			<div class="col-lg-9">
				<nav
					class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
					<a href="<%=request.getContextPath()%>/front-end/designer/index.jsp" class="text-decoration-none d-block d-lg-none">
						<h1 class="m-0">
							<span class="text-primary">M</span>atDesign
						</h1>
					</a>
					<button type="button" class="navbar-toggler" data-toggle="collapse"
						data-target="#navbarCollapse">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse justify-content-between"
						id="navbarCollapse">
						<div class="navbar-nav py-0">
							<div id="selfedit" style="width: 200px"><a  href="index.html" class="nav-item nav-link"><b>找作品</b></a></div>
							<div id="ordermanage" style="width: 200px"><a  href="<%=request.getContextPath()%>/ShowDesignerPage" class="nav-item nav-link"><b>找設計師</b></a></div>
							<div id="quotation" style="width: 200px"><a  href="course.html" class="nav-item nav-link"><b>商城</b></a></div>
							<div id="contract" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>論壇</b></a></div>
							<div id="portfolio" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>報導文章</b></a></div>
						</div>
					</div>
					
				</nav>
			</div>
		</div>
	</div>
	
	
	
	
	<!-- Navbar End -->
	
<!--  -->

<hr color="gray">
<div style="text-align:center"><h3>找設計師</h3></div>
<div class="content_box_grey">
  <div>&emsp;&emsp;<font size="4px" color="black">設計強項</font></div>
  <div>
     <div>
       
         <form METHOD="post">
           <ul>
            <input type="button" value="小坪數" /> &emsp;&emsp;
            <input type="button" value="大坪數" /> &emsp;&emsp;
            <input type="button" value="輕奢新古典"/> &emsp;&emsp;
            <input type="button" value="格局動線"/> &emsp;&emsp;
            <input type="button" value="透天設計"/> &emsp;&emsp;
            <input type="button" value="退休樂活"/> &emsp;&emsp;
            <input type="button" value="小資裝潢"/> &emsp;&emsp;
            <input type="button" value="老屋翻新"/> &emsp;&emsp;
            <input type="button" value="奢華裝修"/> 
           </ul>
        </form>
        
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
	
	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="com.designer.model.*" %>
	<%
	DesignerVO designerVO=(DesignerVO) session.getAttribute("designerVO");
	System.out.println(designerVO);
	%>
<!DOCTYPE html>
<html>
<head>
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
<link href="<%=request.getContextPath()%>/front-end/designer/lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="<%=request.getContextPath()%>/front-end/designer/css/style.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/front-end/designer/css/MatDesign.css" rel="stylesheet" />

  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous">
  </script>
  
  
</head>

<body>
	<!-- Topbar Start -->
	<div class="container-fluid d-none d-lg-block">
		<div class="row align-items-center py-4 px-xl-5">
			<div class="align-item-center-right">
			<form method="post" action="<%=request.getContextPath()%>/DesignerLogout">
			    <input type="hidden" name="logout" value="desginerlogout">
				<input  type="submit" class="btn btn-primary py-2 px-4 d-none d-lg-block" 
				 value="登出" style=" color: #fff; background-color: #FF6600; border-color: #FF6600;"
			    />
			    </form>
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
				<!-- 	<form method="post" action="<%=request.getContextPath()%>/DesignerEdit">  -->	
					<!--	<input type="hidden" name="designerNo" value="${designerVO.designerNo}"> -->
	<%
	session.setAttribute("designerVO",designerVO);
	System.out.println(designerVO);
	%>
							<div id="selfedit" style="width: 200px"><a href="<%=request.getContextPath()%>/DesignerEdit?${designerVO.designerNo}" class="nav-item nav-link"><b>編輯簡介</b></a></div>
						<!--	</form>-->
							<div id="ordermanage" style="width: 200px"><a  href="<%=request.getContextPath()%>/front-end/designer/orderManage.jsp" class="nav-item nav-link"><b>訂單管理</b></a></div>
							<div id="quotation" style="width: 200px"><a  href="course.html" class="nav-item nav-link"><b>製作報價</b></a></div>
							<div id="contract" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>製作合約</b></a></div>
							<div id="portfolio" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>作品管理</b></a></div>
						</div>
					</div>
					
				</nav>
			</div>
		</div>
	</div>
	
	<!-- Navbar End -->
<hr size="8px" align="center" width="100%" >
	<!-- Carousel Start -->
	<div class="container-fluid p-0 pb-5 mb-5">
		<div id="header-carousel" class="carousel slide carousel-fade"
			data-ride="carousel">
			
			<div class="carousel-inner">
				<div class="carousel-item active" style="min-height: 300px">
				
				</div>
				<div class="carousel-item" style="min-height: 300px">
				
				</div>
				<div class="carousel-item" style="min-height: 300px">
				
				</div>
			</div>
		</div>
	</div>
	<!-- Carousel End -->


	<!-- Category Start -->
	<div class="container-fluid py-5">
		<div class="container pt-5 pb-3">
			
			<div class="row">
				<div class="col-lg-3 col-md-6 mb-4">
				
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
				
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
				
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
				
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
				
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
				
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
				
				</div>
			
			</div>
		</div>
	</div>
	<!-- Category Start -->

	<!-- Team Start -->
	<div class="container-fluid py-5">
		<div class="container pt-5 pb-3">
			
			<div class="row">
				<div class="col-md-6 col-lg-3 text-center team mb-4">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							
						</div>
						
					</div>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
					<div class="team-item rounded overflow-hidden mb-2">
						
						
					</div>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
					<div class="team-item rounded overflow-hidden mb-2">
						
						
					</div>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
					<div class="team-item rounded overflow-hidden mb-2">
						
						
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Team End -->

	<!-- Courses Start -->
	<div class="container-fluid py-5">
		<div class="container py-5">
			
			<div class="row">
				<div class="col-lg-4 col-md-6 mb-4">
					
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					
				</div>
			</div>
		</div>
	</div>
	<!-- Courses End -->

	<!-- Footer Start -->
	<div id="footer"
		class="container-fluid bg-dark text-white py-5 px-sm-3 px-lg-5"
		style="margin-top: 10px">
		<div class="row pt-5">
			<div class="col-lg-7 col-md-12">
				<div class="row">
					<div class="col-md-6 mb-5">
						<h5 class="text-primary text-uppercase mb-4"
							style="letter-spacing: 5px">關於我們</h5>

						<a href="#" style="font-weight: bold">關於我們</a>

					</div>
					<div class="col-md-6 mb-5"></div>
				</div>
			</div>

		</div>
	</div>
	
	 <!-- <input type="hidden" value="${errorFlag}" id="errorFlag"/> -->
	<!-- Back to Top -->
	<a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i
		class="fa fa-angle-double-up"></i></a>

	<!-- JavaScript Libraries -->
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
	<script src="lib/easing/easing.min.js"></script>
	<script src="lib/owlcarousel/owl.carousel.min.js"></script>

	<!-- Contact Javascript File -->
	<script src="mail/jqBootstrapValidation.min.js"></script>
	<script src="mail/contact.js"></script>

	<!-- Template Javascript -->
	<script src="/js/main.js"></script>


</body>
</html>
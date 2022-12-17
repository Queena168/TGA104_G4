<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
<link href="<%=request.getContextPath()%>/front-end/designer/lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->

<link href="<%=request.getContextPath()%>/front-end/designer/css/style.css" rel="stylesheet" />
<link href="<%=request.getContextPath()%>/front-end/designer/css/MatDesign.css" rel="stylesheet" />


  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>
</head>

<body>
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
												<a href="<%=request.getContextPath()%>/front-end/designer/addDesigner.jsp" type="button" class="designer"
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
							<div id="ordermanage" style="width: 200px"><a  href="<%=request.getContextPath()%>/designer.do" class="nav-item nav-link"><b>找設計師</b></a></div>
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

	<!-- Carousel Start -->
	<div class="container-fluid p-0 pb-5 mb-5">
		<div id="header-carousel" class="carousel slide carousel-fade"
			data-ride="carousel">
			<ol class="carousel-indicators">
				<li data-target="#header-carousel" data-slide-to="0" class="active"></li>
				<li data-target="#header-carousel" data-slide-to="1"></li>
				<li data-target="#header-carousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="carousel-item active" style="min-height: 300px">
					<img class="position-relative w-100" src="./img/matdesign001.jpg"
						style="min-height: 300px; object-fit: cover" />
					<div
						class="carousel-caption d-flex align-items-center justify-content-center">
						<div class="p-5" style="width: 100%; max-width: 900px">
							<h5 class="text-white text-uppercase mb-md-3">Best Online
								Courses</h5>
							<h1 class="display-3 text-white mb-md-4">Best Education From
								Your Home</h1>
							<a href=""
								class="btn btn-primary py-md-2 px-md-4 font-weight-semi-bold mt-2">Learn
								More</a>
						</div>
					</div>
				</div>
				<div class="carousel-item" style="min-height: 300px">
					<img class="position-relative w-100" src="./img/matdesign002.jpg"
						style="min-height: 300px; object-fit: cover" />
					<div
						class="carousel-caption d-flex align-items-center justify-content-center">
						<div class="p-5" style="width: 100%; max-width: 900px">
							<h5 class="text-white text-uppercase mb-md-3">Best Online
								Courses</h5>
							<h1 class="display-3 text-white mb-md-4">Best Online
								Learning Platform</h1>
							<a href=""
								class="btn btn-primary py-md-2 px-md-4 font-weight-semi-bold mt-2">Learn
								More</a>
						</div>
					</div>
				</div>
				<div class="carousel-item" style="min-height: 300px">
					<img class="position-relative w-100" src="./img/matdesign003.jpg"
						style="min-height: 300px; object-fit: cover" />
					<div
						class="carousel-caption d-flex align-items-center justify-content-center">
						<div class="p-5" style="width: 100%; max-width: 900px">
							<h5 class="text-white text-uppercase mb-md-3">Best Online
								Courses</h5>
							<h1 class="display-3 text-white mb-md-4">New Way To Learn
								From Home</h1>
							<a href=""
								class="btn btn-primary py-md-2 px-md-4 font-weight-semi-bold mt-2">Learn
								More</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Carousel End -->


	<!-- Category Start -->
	<div class="container-fluid py-5">
		<div class="container pt-5 pb-3">
			<div class="text-center mb-5">
				<h2 class="text-primary text-uppercase mb-3"
					style="letter-spacing: 5px">商品</h2>

				<h1>熱銷商品</h1>
			</div>
			<div class="row">
				<div class="col-lg-3 col-md-6 mb-4">
					<div
						class="cat-item position-relative overflow-hidden rounded mb-2">
						<img class="img-fluid" src="img/cat-1.jpg" alt="" /> <a
							class="cat-overlay text-white text-decoration-none" href="">
							<h4 class="text-white font-weight-medium">種類</h4> <span>100
								Courses</span>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
					<div
						class="cat-item position-relative overflow-hidden rounded mb-2">
						<img class="img-fluid" src="img/cat-2.jpg" alt="" /> <a
							class="cat-overlay text-white text-decoration-none" href="">
							<h4 class="text-white font-weight-medium">種類</h4> <span>100
								Courses</span>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
					<div
						class="cat-item position-relative overflow-hidden rounded mb-2">
						<img class="img-fluid" src="img/cat-3.jpg" alt="" /> <a
							class="cat-overlay text-white text-decoration-none" href="">
							<h4 class="text-white font-weight-medium">種類</h4> <span>100
								Courses</span>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
					<div
						class="cat-item position-relative overflow-hidden rounded mb-2">
						<img class="img-fluid" src="img/cat-4.jpg" alt="" /> <a
							class="cat-overlay text-white text-decoration-none" href="">
							<h4 class="text-white font-weight-medium">種類</h4> <span>100
								Courses</span>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
					<div
						class="cat-item position-relative overflow-hidden rounded mb-2">
						<img class="img-fluid" src="img/cat-5.jpg" alt="" /> <a
							class="cat-overlay text-white text-decoration-none" href="">
							<h4 class="text-white font-weight-medium">種類</h4> <span>100
								Courses</span>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
					<div
						class="cat-item position-relative overflow-hidden rounded mb-2">
						<img class="img-fluid" src="img/cat-6.jpg" alt="" /> <a
							class="cat-overlay text-white text-decoration-none" href="">
							<h4 class="text-white font-weight-medium">種類</h4> <span>100
								Courses</span>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
					<div
						class="cat-item position-relative overflow-hidden rounded mb-2">
						<img class="img-fluid" src="img/cat-7.jpg" alt="" /> <a
							class="cat-overlay text-white text-decoration-none" href="">
							<h4 class="text-white font-weight-medium">種類</h4> <span>100
								Courses</span>
						</a>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 mb-4">
					<div
						class="cat-item position-relative overflow-hidden rounded mb-2">
						<img class="img-fluid" src="img/cat-8.jpg" alt="" /> <a
							class="cat-overlay text-white text-decoration-none" href="">
							<h4 class="text-white font-weight-medium">種類</h4> <span>100
								Courses</span>
						</a>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Category Start -->

	<!-- Team Start -->
	<div class="container-fluid py-5">
		<div class="container pt-5 pb-3">
			<div class="text-center mb-5">
				<h2 class="text-primary text-uppercase mb-3"
					style="letter-spacing: 5px">設計師</h2>
				<h1>熱門設計師</h1>
			</div>
			<div class="row">
				<div class="col-md-6 col-lg-3 text-center team mb-4">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="img/team-1.jpg" alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-twitter"></i></a> <a
									class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-facebook-f"></i></a> <a
									class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-linkedin-in"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
							<h5>Jhon Doe</h5>
							<p class="m-0">Web Designer</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="img/team-2.jpg" alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-twitter"></i></a> <a
									class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-facebook-f"></i></a> <a
									class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-linkedin-in"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
							<h5>Jhon Doe</h5>
							<p class="m-0">Web Designer</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="img/team-3.jpg" alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-twitter"></i></a> <a
									class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-facebook-f"></i></a> <a
									class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-linkedin-in"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
							<h5>Jhon Doe</h5>
							<p class="m-0">Web Designer</p>
						</div>
					</div>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="img/team-4.jpg" alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-twitter"></i></a> <a
									class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-facebook-f"></i></a> <a
									class="btn btn-outline-light btn-square mx-1" href="#"><i
									class="fab fa-linkedin-in"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
							<h5>Jhon Doe</h5>
							<p class="m-0">Web Designer</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Team End -->

	<!-- Courses Start -->
	<div class="container-fluid py-5">
		<div class="container py-5">
			<div class="text-center mb-5">
				<h2 class="text-primary text-uppercase mb-3"
					style="letter-spacing: 5px">作品</h2>
				<h1>作品精選</h1>
			</div>
			<div class="row">
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="rounded overflow-hidden mb-2">
						<img class="img-fluid" src="./img/product600400/product001.jpg"
							alt="" />
						<div class="bg-secondary p-4">
							<div class="d-flex justify-content-between mb-3">
								<small class="m-0"><i
									class="fa fa-users text-primary mr-2"></i>25 Students</small> <small
									class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h
									30m</small>
							</div>
							<a class="h5" href="">作品名稱</a>
							<div class="border-top mt-4 pt-4">
								<div class="d-flex justify-content-between">
									<h6 class="m-0">
										<i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
									</h6>
									<h5 class="m-0">$99</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="rounded overflow-hidden mb-2">
						<img class="img-fluid" src="./img/product600400/product002.jpg"
							alt="" />
						<div class="bg-secondary p-4">
							<div class="d-flex justify-content-between mb-3">
								<small class="m-0"><i
									class="fa fa-users text-primary mr-2"></i>25 Students</small> <small
									class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h
									30m</small>
							</div>
							<a class="h5" href="">作品名稱</a>
							<div class="border-top mt-4 pt-4">
								<div class="d-flex justify-content-between">
									<h6 class="m-0">
										<i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
									</h6>
									<h5 class="m-0">$99</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="rounded overflow-hidden mb-2">
						<img class="img-fluid" src="./img/product600400/product003.jpg"
							alt="" />
						<div class="bg-secondary p-4">
							<div class="d-flex justify-content-between mb-3">
								<small class="m-0"><i
									class="fa fa-users text-primary mr-2"></i>25 Students</small> <small
									class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h
									30m</small>
							</div>
							<a class="h5" href="">作品名稱</a>
							<div class="border-top mt-4 pt-4">
								<div class="d-flex justify-content-between">
									<h6 class="m-0">
										<i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
									</h6>
									<h5 class="m-0">$99</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="rounded overflow-hidden mb-2">
						<img class="img-fluid" src="./img/product600400/product004.jpg"
							alt="" />
						<div class="bg-secondary p-4">
							<div class="d-flex justify-content-between mb-3">
								<small class="m-0"><i
									class="fa fa-users text-primary mr-2"></i>25 Students</small> <small
									class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h
									30m</small>
							</div>
							<a class="h5" href="">作品名稱</a>
							<div class="border-top mt-4 pt-4">
								<div class="d-flex justify-content-between">
									<h6 class="m-0">
										<i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
									</h6>
									<h5 class="m-0">$99</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="rounded overflow-hidden mb-2">
						<img class="img-fluid" src="./img/product600400/product005.jpg"
							alt="" />
						<div class="bg-secondary p-4">
							<div class="d-flex justify-content-between mb-3">
								<small class="m-0"><i
									class="fa fa-users text-primary mr-2"></i>25 Students</small> <small
									class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h
									30m</small>
							</div>
							<a class="h5" href="">作品名稱</a>
							<div class="border-top mt-4 pt-4">
								<div class="d-flex justify-content-between">
									<h6 class="m-0">
										<i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
									</h6>
									<h5 class="m-0">$99</h5>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="col-lg-4 col-md-6 mb-4">
					<div class="rounded overflow-hidden mb-2">
						<img class="img-fluid" src="./img/product600400/product006.jpg"
							alt="" />
						<div class="bg-secondary p-4">
							<div class="d-flex justify-content-between mb-3">
								<small class="m-0"><i
									class="fa fa-users text-primary mr-2"></i>25 Students</small> <small
									class="m-0"><i class="far fa-clock text-primary mr-2"></i>01h
									30m</small>
							</div>
							<a class="h5" href="">作品名稱</a>
							<div class="border-top mt-4 pt-4">
								<div class="d-flex justify-content-between">
									<h6 class="m-0">
										<i class="fa fa-star text-primary mr-2"></i>4.5 <small>(250)</small>
									</h6>
									<h5 class="m-0">$99</h5>
								</div>
							</div>
						</div>
					</div>
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
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
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
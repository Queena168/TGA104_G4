<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.tibame.portfolio.model.*"%>

<%
PortfolioService portfolioSvc = new PortfolioService();
List<PortfolioVO> list = portfolioSvc.getAll();
pageContext.setAttribute("list", list);

%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>MatDesign</title>
<!-- Favicon -->
<link rel="icon" href="../images/favicon.ico" sizes="32x32">
<!-- Bootstrap core CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel='stylesheet' href='../css/fontawesome.min.css'>
<script src="https://kit.fontawesome.com/6a35b80892.js"
	crossorigin="anonymous"></script>
<!-- Animate -->
<link href="../css/animate.css" rel="stylesheet">
<!-- Owl Carousel -->
<link rel="stylesheet" href="../css/owl.carousel.min.css">
<link rel="stylesheet" href="../css/owl.theme.default.min.css">
<!-- light box -->
<link rel="stylesheet" href="../css/lightbox.min.css">
<!-- jquery ui -->
<link rel="stylesheet" href="../css/jquery-ui.min.css">
<!-- nice select -->
<link rel="stylesheet" href="../css/nice-select.min.css">
<!-- Main Styles -->
<link rel="stylesheet" href="../scss/main.css">
<!-- Boxicon -->
<script src="https://unpkg.com/boxicons@2.1.4/dist/boxicons.js"></script>
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<!-- Core CSS -->
<link rel="stylesheet" href="/back-end/assets/vendor/css/core.css"
	class="template-customizer-core-css" />

<!-- <link rel='stylesheet'
	href='https://cdn.datatables.net/1.10.12/css/dataTables.bootstrap.min.css'> -->
<link rel="stylesheet" href="../css/portfoliotable.css">

</head>

<body>
	<!-- main header navbar -->
	<nav class="navbar navbar-expand-lg navbar-light custom-navbar"
		id="mainMenu">
		<div class="container">
			<a class="navbar-brand" href="index.jsp"> <img
				src="../images/MatDesignLogo.png" alt="">
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
										<span class="dropdown-item">${designerVO.designerAccount}</span>
										<%-- <span
											class="account-wrapper__heading--link">${memberVO.memberName}
										</span> --%>
									</div>
								</div>
								<div class="account-wrapper__content">
									<div class="form-group custom-form__input">
										<a class="dropdown-item " href="memberPorfile.jsp"> <span><i
												class="icon-user-profile"></i></span>設計師資料
										</a>
									</div>
									<div class="form-group custom-form__input">
										<a class="dropdown-item  " href="../index.html"><span><i
												class="icon-log-out"></i></span>登出</a>
									</div>
								</div>

							</div>
							<!-- account links when user is logged in-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-order-tab"><span><i-->
							<!--                            class="icon-shopping-basket"></i></span>Orders</a>-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-address-tab"><span><i-->
							<!--                            class="icon-sign"></i></span>Addresses</a>-->
							<!--                    <a class="dropdown-item" href="account.html#v-pills-wishlist-tab"><span><i-->
							<!--                            class="icon-wish-list"></i></span>wishlist</a>-->

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
						class="nav-link " href="memFindPortfolio.jsp">找作品</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="#">找設計師</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="./product/productListAll.html">商城</a></li>
					<li class="nav-item main-navbar__item dropdown"><a
						class="nav-link " href="#">論壇</a></li>
					<!-- <li class="nav-item main-navbar__item dropdown">
                    <a class="nav-link " href="#" data-toggle="dropdown">報導文章</a>
                </li> -->
					<li class="nav-item main-navbar__item"><a class="nav-link"
						href="contact.html">關於我們</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- end main header navbar -->
	<!-- breadcrumb -->
	<div class="container header-mt">
		<div class="row">
			<div class="col-12">
				<nav aria-label="breadcrumb">
					<ol class="breadcrumb custom-breadcrumb">
						<li class="breadcrumb-item"><a href="../index.html">首頁</a></li>
						<li class="breadcrumb-item active" aria-current="page">作品管理</li>
					</ol>
				</nav>
			</div>
		</div>
	</div>
	<!-- end breadcrumb -->
	<!-- main content -->
	<div class="main-content pb-80">
		<div class="container">
			<div class="row">
				<div class="col-lg-3">
					<div class="nav flex-column nav-pills account-pills account-tabs"
						id="v-pills-tab" role="tablist" aria-orientation="vertical">
						<a class="nav-link active" id="v-pills-profile-tab"
							data-toggle="pill" href="#v-pills-portfolioListAll" role="tab"
							aria-controls="v-pills-profile" aria-selected="true"> <span><i
								class="icon-user-profile"></i></span>作品列表
						</a> <a class="nav-link" id="v-pills-order-tab" data-toggle="pill"
							href="#v-pills-portfolioSelect" role="tab"
							aria-controls="v-pills-order" aria-selected="false"> <span><i
								class='bx bx-shopping-bag'></i></span>作品查詢
						</a> <a class="nav-link" id="v-pills-wishlist-tab" data-toggle="pill"
							href="#v-pills-portfolioAdd" role="tab"
							aria-controls="v-pills-wishlist" aria-selected="false"> <span><i
								class='bx bx-file'></i></span>新增作品
						</a>

					</div>
				</div>
				<div class="col-lg-9">
					<div class="tab-content account-content" id="v-pills-tabContent">
						<!-- portfolioListAll tab -->
						<div class="tab-pane fade show active"
							id="v-pills-portfolioListAll" role="tabpanel"
							aria-labelledby="v-pills-order-tab">
							<div class="order-table order-table__collapse">
								<div class="panel">
									<div class="panel-body">
										<table
											class="table table-bordered bordered table-striped table-condensed datatable">
											<thead>
												<tr>
													<th>作品編號</th>
													<th>作品名稱</th>
													<th>新增時間</th>
													<th>最新修改時間</th>
													<th>作品明細</th>
												</tr>
											</thead>
											<tbody>
												<%-- <c:set var="flag" value="true" /> --%>
												<c:forEach var="portfolioListByNo"
													items="${portfolioListByNo}">
													<%-- <c:if test="${(portfolioVO.designerNo == designerVO.designerNo) && flag==true} ">
														<c:set var="flag" value="false" />
														<c:forEach var="portfolioVO" items="${list}"> --%>
													<tr>
														<td><strong>${portfolioListByNo.portfolioNo}</strong></td>
														<td>${portfolioListByNo.portfolioName}</td>
														<td><small><fmt:formatDate
																	pattern="yyyy-MM-dd HH:mm:ss"
																	value="${portfolioListByNo.createTime}" /></small></td>
														<td><small><fmt:formatDate
																	pattern="yyyy-MM-dd HH:mm:ss"
																	value="${portfolioListByNo.modificationTime}" /></small></td>

														<td>
															<form method="post" action="PortfolioListOne">
																<label class="btn btn-primary" tabindex="0"> <span
																	class="d-none d-sm-block">作品明細</span> <i
																	class="fa-regular fa-pen-to-square d-block d-sm-none"></i>
																	<input type="submit" class="account-file-input" hidden />
																	<input type="hidden" name="portfolioNo"
																	value="${portfolioListByNo.portfolioNo}"> <input
																	type="hidden" name="action" value="portfolio_GetOne">
																</label>
															</form>
														</td>
														<%-- <td>${portfolioVO.designerNo}</td> --%>
													</tr>
													<%-- </c:forEach>
													</c:if> --%>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>
							</div>

						</div>
						<!-- portfolioSelect tab -->
						<div class="tab-pane fade " id="v-pills-portfolioSelect"
							role="tabpanel" aria-labelledby="v-pills-profile-tab">
							<!-- select form -->
							<div class="row">
								<div class="col-md-12">
									<div class="custom-form">
										<%-- 錯誤表列 --%>
										<c:if test="${not empty errorMsgs}">
											<div class="custom-form__title">
												<ul>
													<li>
														<ul>
															<c:forEach var="message" items="${errorMsgs}">
																<li class="form-text" style="color: red"><small>${message}</small></li>
															</c:forEach>
														</ul>
													</li>
												</ul>

											</div>
										</c:if>
										<%-- /錯誤表列 --%>
										<form class="change-pass" method="post"
											action="PortfolioListOne">
											<!-- <p class="custom-form__title">作品查詢</p> -->
											<div class="form-group custom-form__input"
												style="padding-bottom: 0px;">
												<label for="oldPassInput">輸入作品名稱</label>
												<div class="input-box row">
													<div class="col-md-6">
														<input type="text" class="form-control ltr"
															id="oldPassInput" placeholder="" name="portfolioName">
													</div>
													<div class="col-md-6 profile-address__card--footer select"
														style="padding-top: 0px;">
														<input type="hidden" name="action"
															value="inputPortfolioName_For_Display">
														<button type="submit" class="btn btn-blue"
															style="margin-top: 0">送出</button>
													</div>
												</div>
											</div>
										</form>
										<jsp:useBean id="portfolioSelectSvc" scope="page"
											class="com.tibame.portfolio.model.PortfolioService" />
										<form class="change-pass" method="post"
											action="PortfolioListOne">
											<div class="form-group custom-form__input"
												style="padding-bottom: 0px;">
												<label for="oldPassInput">選擇作品名稱</label>
												<div class="input-box row">
													<div class="col-md-6">
														<select class="form-control ltr" id="oldPassInput"
															name="portfolioNo">
															<c:forEach var="portfolioListByNo"
																items="${portfolioListByNo}">
																<option value="${portfolioListByNo.portfolioNo}">${portfolioListByNo.portfolioName}
															</c:forEach>
														</select>
													</div>
													<div class="col-md-6 profile-address__card--footer"
														style="padding-top: 0px;">
														<button type="submit" class="btn btn-blue"
															style="margin-top: 0">送出</button>
														<input type="hidden" name="action"
															value="portfolio_GetOne">
													</div>
												</div>
											</div>
										</form>

									</div>
								</div>
							</div>
						</div>

						<!-- portfolioAdd tab -->
						<div class="tab-pane fade" id="v-pills-portfolioAdd"
							role="tabpanel" aria-labelledby="v-pills-order-tab">
							<div class="col-xxl">
								<div class="card mb-4">
									<div
										class="card-header d-flex align-items-center justify-content-between">
										<h5 class="mb-0">新增作品</h5>
									</div>
									<div class="card-body">
										<form method="post" action="InsertPortfolio"
											enctype="multipart/form-data">
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name">作品名稱</label>
												<div class="col-sm-10">
													<input type="text" class="form-control"
														id="basic-default-name" name="portfolioName"
														value="${portfolioUpdate.portfolioName}" />
												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label" for="houseArea">房屋區域</label>
												<div class="col-sm-10">
													<select class="form-control" id="houseArea" name="houseArea" >
														<option value="北部">北部
														<option value="中部">中部
														<option value="南部">南部
														<option value="東部">東部
														<option value="離島">離島
													</select>
												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label" for="houseAge">屋齡</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" id="houseAge"
														name="houseAge" value="${portfolioUpdate.houseAge}" />
												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label" for="houseSize">坪數</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" id="houseSize"
														name="houseSize" value="${portfolioUpdate.houseSize}" />
												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label" for="description">作品內文</label>
												<div class="col-sm-10">
													<textarea id="description" class="form-control"
														name="description" rows="8"
														aria-describedby="basic-icon-default-message2">${portfolioUpdate.description}</textarea>
												</div>
											</div>
											<div class="row mb-3">
												<label for="formFile " class=" col-sm-2 col-form-label">圖片1</label>
												<div class="col-sm-10">
													<input class="form-control" type="file" id="formFile"
														name="portfolioPic1" accept="image/png, image/jpeg" />
												</div>
												<div class="col-sm-10">
													<img
														src="<%=request.getContextPath()%>/PortfolioPic1?portfolioNo=${portfolioUpdate.portfolioNo}"
														height="20%" width="20%" alt="">
												</div>
											</div>
											<div class="row mb-3">
												<label for="portfolioPic2 " class=" col-sm-2 col-form-label">圖片2</label>
												<div class="col-sm-10">
													<input class="form-control" type="file" id="portfolioPic2"
														name="portfolioPic2" accept="image/png, image/jpeg" />
												</div>
											</div>
											<div class="row mb-3">
												<label for="portfolioPic3 " class=" col-sm-2 col-form-label">圖片3</label>
												<div class="col-sm-10">
													<input class="form-control" type="file" id="portfolioPic3"
														name="portfolioPic3" accept="image/png, image/jpeg" />
												</div>
											</div>
											<div class="row mb-3">
												<label for="portfolioPic4 " class=" col-sm-2 col-form-label">圖片4</label>
												<div class="col-sm-10">
													<input class="form-control" type="file" id="portfolioPic4"
														name="portfolioPic4" accept="image/png, image/jpeg" />
												</div>
											</div>
											<div class="row justify-content-end">
												<!-- <div class="col-sm-10"> -->
												<button type="submit" class="btn btn-primary" style="margin-right: 15px;">送出</button>
												<input type="hidden" name="action" value="insert"> 
												<input type="hidden" name="designerNo"
													value="${designerVO.designerNo}" />
												<!-- </div> -->
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- end main content -->
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
	<!-- scroll up btn -->
	<a id="back-to-top"></a>
	<!-- end scroll up btn -->
	<!-- loader -->
	<!-- <div class="loader">
		<div class="spinner">
			<div class="cube1"></div>
			<div class="cube2"></div>
		</div>
	</div> -->
	<!-- end loader -->

	<!-- stopPropagation -->
	<script>
		$("div.select").on("click", function(e) {
			// 停止冒泡狀況
			e.stopPropagation();
			console.log("點擊送出 停止冒泡");
		});
	</script>

	<!-- All Jquery -->
	<script type="text/javascript" src="../js/jquery.min.js"></script>
	<script type="text/javascript" src="../js/popper.min.js"></script>
	<script type="text/javascript" src="../js/bootstrap.min.js"></script>
	<!-- owl carousel js -->
	<script type="text/javascript" src="../js/owl.carousel.min.js"></script>
	<!-- Jquery ui -->
	<script type="text/javascript" src="../js/jquery-ui.min.js"></script>
	<!-- light box js -->
	<script type="text/javascript" src="../js/lightbox.min.js"></script>
	<!-- typeahead js -->
	<script type="text/javascript" src="../js/typeahead.jquery.min.js"></script>
	<!-- master zoom image js -->
	<script type="text/javascript" src="../js/jquery.zoom.min.js"></script>
	<!-- countdown js -->
	<script type="text/javascript" src="../js/countdown.jquery.min.js"></script>
	<!-- nice select js -->
	<script type="text/javascript" src="../js/nice-select.min.js"></script>
	<!-- wow js -->
	<script type="text/javascript" src="../js/wow.min.js"></script>
	<!-- custom js -->
	<script type="text/javascript" src="../js/custom.js"></script>
	<!-- table js -->

	<script src="../js/portfoliotable.js"></script>

</body>
</html>
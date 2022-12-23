<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.portfolio.model.*"%>
<%@ page import="com.portfolio.controller.*"%>

<%

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
						class="nav-link " href="./designer_protfolio/listAll.html">找作品</a>
					</li>
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
												<c:forEach var="portfolioVO" items="${selectlist}">
													<tr>
														<td><strong>${portfolioVO.portfolioNo}</strong></td>
														<td>${portfolioVO.portfolioName}</td>
														<td><small><fmt:formatDate
																	pattern="yyyy-MM-dd HH:mm:ss"
																	value="${portfolioVO.createTime}" /></small></td>
														<td><small><fmt:formatDate
																	pattern="yyyy-MM-dd HH:mm:ss"
																	value="${portfolioVO.modificationTime}" /></small></td>

														<td>
															<form method="post" action="PortfolioListOne">
																<label class="btn btn-primary" tabindex="0"> <span
																	class="d-none d-sm-block">作品明細</span> <i
																	class="fa-regular fa-pen-to-square d-block d-sm-none"></i>
																	<input type="submit" class="account-file-input" hidden />
																	<input type="hidden" name="portfolioNo"
																	value="${portfolioVO.portfolioNo}"> <input
																	type="hidden" name="action" value="portfolio_GetOne">
																</label>
															</form>
														</td>
													</tr>
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
														<input type="hidden" name="action"
															value="inputPortfolioName_For_Display">
													</div>
													<div class="col-md-6 profile-address__card--footer select"
														style="padding-top: 0px;">
														<input type="hidden" name="action"
															value="inputPortfolioName_For_Display">
														<button type="submit" class="btn btn-blue"
															style="margin-top: 0">送出</button>
														<!-- <input type="hidden" name="action"
														value="inputPortfolioName_For_Display"> -->

													</div>
												</div>
											</div>
										</form>
										<jsp:useBean id="portfolioSelectSvc" scope="page"
											class="com.portfolio.model.PortfolioService" />
										<form class="change-pass">
											<div class="form-group custom-form__input"
												style="padding-bottom: 0px;">
												<label for="oldPassInput">選擇作品名稱</label>
												<div class="input-box row">
													<div class="col-md-6">
														<select class="form-control ltr" id="oldPassInput">
															<c:forEach var="portfolioVO"
																items="${portfolioSelectSvc.all}">
																<option value="${portfolioVO.portfolioNo}">${portfolioVO.portfolioName}
															</c:forEach>
														</select>
													</div>
													<div class="col-md-6 profile-address__card--footer"
														style="padding-top: 0px;">
														<button type="submit" class="btn btn-blue"
															style="margin-top: 0">送出</button>

													</div>
												</div>
											</div>
										</form>
										<form class="change-pass">
											<div class="form-group custom-form__input ">
												<label for="oldPassInput">選擇作品房屋區域</label>
												<div class="input-box row">
													<div class="col-md-6">
														<select class="form-control ltr" id="oldPassInput">
															<c:forEach var="portfolioVO"
																items="${portfolioSelectSvc.all}">
																<option value="${portfolioVO.portfolioNo}">${portfolioVO.houseArea}
															</c:forEach>
														</select>
													</div>
													<div class="col-md-6 profile-address__card--footer"
														style="padding-top: 0px;">
														<button type="submit" class="btn btn-blue"
															style="margin-top: 0">送出</button>
													</div>
												</div>
											</div>
										</form>
									</div>
								</div>
							</div>
							<!-- Modal edit profile -->
							<div class="modal fade profile-info__modal" id="editProfileModal"
								tabindex="-1" role="dialog"
								aria-labelledby="editProfileModalTitle" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered modal-lg"
									role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="editProfileModalTitle">Edit
												your Information</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<form class="custom-form">
												<div class="row">
													<div class="col-md-6">
														<div class="form-group custom-form__input">
															<label for="firstName">First Name</label> <input
																type="text" class="form-control" id="firstName"
																placeholder="">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group custom-form__input">
															<label for="lastName">Last Name</label> <input
																type="text" class="form-control" id="lastName"
																placeholder="">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group custom-form__input">
															<label for="email">Email Address</label> <input
																type="email" class="form-control ltr" id="email"
																placeholder="">
														</div>
													</div>
													<div class="col-md-6">
														<div class="form-group custom-form__input">
															<label for="userName">Username</label> <input type="text"
																class="form-control" id="userName" placeholder="">
														</div>
													</div>
												</div>
											</form>
										</div>
										<div class="modal-footer custom-form__btn">
											<button type="button" class="btn btn-close"
												data-dismiss="modal">Close</button>
											<button type="button" class="btn btn-green">Save
												changes</button>
										</div>
									</div>
								</div>
							</div>
							<!-- end Modal edit profile -->
						</div>

						<!-- portfolioAdd tab -->
						<div class="tab-pane fade" id="v-pills-portfolioAdd"
							role="tabpanel" aria-labelledby="v-pills-order-tab">
							<div class="order-table order-table__collapse">
								<div class="order-table__head">
									<div class="order-table__row order-table__row--head">
										<div class="order-table__cell order-table__cell--hash">#</div>
										<div class="order-table__cell order-table__cell--id">Order
											Number</div>
										<div class="order-table__cell order-table__cell--date">Order
											Date</div>
										<div class="order-table__cell order-table__cell--receive">Deliver
											date</div>
										<div class="order-table__cell order-table__cell--price">Total
											price</div>
										<div class="order-table__cell order-table__cell--payment">Payment</div>
										<div class="order-table__cell order-table__cell--details">Details</div>
									</div>
								</div>
								<div class="order-table__body">
									<div class="order-table__row">
										<div class="order-table__cell order-table__cell--hash">1</div>
										<div class="order-table__cell order-table__cell--id">
											<div class="order-table__cell--heading">Order number</div>
											<div class="order-table__cell--content id-content">
												123456789</div>
										</div>
										<div class="order-table__cell order-table__cell--date">
											<div class="order-table__cell--heading">Order Date</div>
											<div class="order-table__cell--content date-content">22/06/2019</div>
										</div>
										<div class="order-table__cell order-table__cell--receive">
											<div class="order-table__cell--heading">Deliver State</div>
											<div class="order-table__cell--content receive-content">
												<span
													class="badge order-table__status order-table__status--progress">In
													progress</span>
											</div>
										</div>
										<div class="order-table__cell order-table__cell--price">
											<div class="order-table__cell--heading">Total price</div>
											<div class="order-table__cell--content  price-content">$1,500</div>
										</div>
										<div class="order-table__cell order-table__cell--payment">
											<div class="order-table__cell--heading">Payment</div>
											<div class="order-table__cell--content  payment-content">Master
												card</div>
										</div>
										<div class="order-table__cell order-table__cell--details">
											<div class="order-table__cell--heading">Details</div>
											<div class="order-table__cell--content  details-content">
												<a href="order-details.html#v-pills-order-tab">View more</a>
											</div>
										</div>
									</div>
									<div class="order-table__row">
										<div class="order-table__cell order-table__cell--hash">2</div>
										<div class="order-table__cell order-table__cell--id">
											<div class="order-table__cell--heading">Order number</div>
											<div class="order-table__cell--content id-content">
												123456789</div>
										</div>
										<div class="order-table__cell order-table__cell--date">
											<div class="order-table__cell--heading">Order Date</div>
											<div class="order-table__cell--content date-content">1/03/2019</div>
										</div>
										<div class="order-table__cell order-table__cell--receive">
											<div class="order-table__cell--heading">Deliver State</div>
											<div class="order-table__cell--content receive-content">
												<span
													class="badge order-table__status order-table__status--cancel">Canceled</span>
											</div>
										</div>
										<div class="order-table__cell order-table__cell--price">
											<div class="order-table__cell--heading">Total price</div>
											<div class="order-table__cell--content  price-content">$500</div>
										</div>
										<div class="order-table__cell order-table__cell--payment">
											<div class="order-table__cell--heading">Payment</div>
											<div class="order-table__cell--content  payment-content">Paypal</div>
										</div>
										<div class="order-table__cell order-table__cell--details">
											<div class="order-table__cell--heading">Details</div>
											<div class="order-table__cell--content  details-content">
												<a href="order-details.html#v-pills-order-tab">View more</a>
											</div>
										</div>
									</div>
									<div class="order-table__row">
										<div class="order-table__cell order-table__cell--hash">3</div>
										<div class="order-table__cell order-table__cell--id">
											<div class="order-table__cell--heading">Order number</div>
											<div class="order-table__cell--content id-content">
												123456789</div>
										</div>
										<div class="order-table__cell order-table__cell--date">
											<div class="order-table__cell--heading">Order Date</div>
											<div class="order-table__cell--content date-content">12/02/2019</div>
										</div>
										<div class="order-table__cell order-table__cell--receive">
											<div class="order-table__cell--heading">Deliver State</div>
											<div class="order-table__cell--content receive-content">
												<span
													class="badge order-table__status order-table__status--success">Delivered</span>
											</div>
										</div>
										<div class="order-table__cell order-table__cell--price">
											<div class="order-table__cell--heading">Total price</div>
											<div class="order-table__cell--content  price-content">$1,850</div>
										</div>
										<div class="order-table__cell order-table__cell--payment">
											<div class="order-table__cell--heading">Payment</div>
											<div class="order-table__cell--content  payment-content">Master
												card</div>
										</div>
										<div class="order-table__cell order-table__cell--details">
											<div class="order-table__cell--heading">Details</div>
											<div class="order-table__cell--content  details-content">
												<a href="order-details.html#v-pills-order-tab">View more</a>
											</div>
										</div>
									</div>
								</div>
							</div>
							<!-- empty account tab -->
							<!--                        <div class="row">-->
							<!--                            <div class="col-12">-->
							<!--                                <div class="notice-wrapper">-->
							<!--                                    <p>There is no item added here. <a href="shop-sidebar-right.html" class="notice-wrapper__link">GO Shop</a></p>-->
							<!--                                </div>-->
							<!--                            </div>-->
							<!--                        </div>-->
							<!-- empty account tab -->
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
	<div class="loader">
		<div class="spinner">
			<div class="cube1"></div>
			<div class="cube2"></div>
		</div>
	</div>
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
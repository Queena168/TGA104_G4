<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%-- <%@ page import="java.util.Locale" %>
<%@ page import="java.util.*"%>
<%@ page import="java.text.NumberFormat"%>
<%
NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.TAIWAN);
%> --%>

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
<style>
td {
	vertical-align: middle;
}
</style>
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
										<span>${memberVO.memberAccount}</span> <span
											class="account-wrapper__heading--link">${memberVO.memberName}
										</span>
									</div>
								</div>
								<div class="account-wrapper__content">
									<div class="form-group custom-form__input">
										<a class="dropdown-item " href="memberPorfile.jsp"> <span><i
												class="icon-user-profile"></i></span>會員資料
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
						<li class="breadcrumb-item active" aria-current="page">會員資料</li>
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
						<a class="nav-link " id="v-pills-profile-tab" data-toggle="pill"
							href="#v-pills-profile" role="tab"
							aria-controls="v-pills-profile" aria-selected="true"> <span><i
								class="icon-user-profile"></i></span>會員資料
						</a> <a class="nav-link" id="v-pills-order-tab" data-toggle="pill"
							href="#v-pills-productorder" role="tab"
							aria-controls="v-pills-order" aria-selected="false"> <span><i
								class='bx bx-shopping-bag'></i></span>商品訂單
						</a> <a class="nav-link active" id="v-pills-wishlist-tab"
							data-toggle="pill" href="#v-pills-designorder" role="tab"
							aria-controls="v-pills-wishlist" aria-selected="false"> <span><i
								class='bx bx-file'></i></span>合約案件
						</a>
						<%-- <form method="post"
									action="<%=request.getContextPath()%>/front-end/chat/intochatServlet"> 
							<label class="nav-link profile-info__action">
							
								<span><i class='bx bx-message-square-dots'></i> </span>聊天室
								<input type="hidden" name="memberNo" value="${memberVO.memberNo}">
								<input type="submit" hidden>
								<button type="submit" class="btn"></button>
							
							</label>
						</form>  --%>
						<a class="nav-link" href="../index.html" role="tab"
							aria-selected="false"> <span><i class="icon-log-out"></i></span>登出
						</a>
					</div>
				</div>
				<div class="col-lg-9">
					<div class="tab-content account-content" id="v-pills-tabContent">
						<!-- profile tab -->
						<div class="tab-pane fade" id="v-pills-profile" role="tabpanel"
							aria-labelledby="v-pills-profile-tab">
							<!-- profile information -->
							<div class="row">
								<div class="col-12">
									<div class="profile-info profile-info--main">
										<div class="profile-info__row">
											<div class="profile-info__col">
												<span class="content"> <span>會員帳號</span> <span>${memberVO.memberAccount}</span>
												</span>
											</div>
											<div class="profile-info__col">
												<span class="content"> <span>會員名稱</span> <span
													class="profile-info__col--value ltr">${memberVO.memberName}</span>
												</span>
											</div>
										</div>
										<div class="profile-info__row">
											<div class="profile-info__col">
												<span class="content"> <span>暱稱</span> <span
													class="profile-info__col--value">${memberVO.nickName}</span>
												</span>
											</div>
											<div class="profile-info__col">
												<span class="content"> <span>性別</span> <span>${memberVO.gender}</span>
												</span>
											</div>
										</div>
										<div class="profile-info__row">
											<div class="profile-info__col">
												<span class="content"> <span>生日</span> <span
													class="profile-info__col--value">${memberVO.birthDate}</span>
												</span>
											</div>
											<div class="profile-info__col">
												<span class="content"> <span>會員頭貼</span> <span></span>
												</span>
											</div>
										</div>
										<div class="profile-info__action">
											<button type="button" data-toggle="modal"
												data-target="#editProfileModal" class="btn">
												<span><i class="icon-edit"></i></span>修改個人資料
											</button>
										</div>
									</div>
								</div>
							</div>
							<!-- end profile information -->

							<!-- edit profile -->
							<div class="modal fade profile-info__modal" id="editProfileModal"
								tabindex="-1" role="dialog"
								aria-labelledby="editProfileModalTitle" aria-hidden="true">
								<div class="modal-dialog modal-dialog-centered modal-lg"
									role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="editProfileModalTitle">修改個人資料</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body">
											<div class="card-body">

												<%-- 錯誤表列 --%>
												<c:if test="${not empty errorMsgs}">
													<div class="mb-3">
														<ul class="list-unstyled mt-2">
															<li class="">
																<ul>
																	<c:forEach var="message" items="${errorMsgs}">
																		<li class="form-text" style="color: red">${message}</li>
																	</c:forEach>
																</ul>
															</li>
														</ul>
													</div>
												</c:if>
												<%-- /錯誤表列 --%>

												<form method="post" action="MemberServlet"
													class="change-pass">
													<div class="mb-3">
														<label class="form-label" for="basic-default-fullname">會員帳號</label>
														<div>${memberVO.memberAccount}</div>
													</div>
													<div class="mb-3">
														<label class="form-label" for="memberPassword">密碼</label>
														<input name="memberPassword" type="text"
															class="form-control" id="memberPassword"
															value="${memberVO.memberPassword}" />
													</div>
													<div class="mb-3">
														<label class="form-label" for="memberName">會員名稱</label> <input
															type="text" class="form-control" id="memberName"
															name="memberName" value="${memberVO.memberName}" />
													</div>
													<div class="mb-3">
														<label class="form-label" for="nickName">暱稱</label> <input
															type="text" class="form-control" id="nickName"
															name="nickName" value="${memberVO.nickName}" />
													</div>
													<div class="mb-3">
														<label class="form-label" for="gender">性別</label>
														<div class="row">
															<div class="col-md">
																<c:choose>
																	<c:when test="${memberVO.gender =='男性' }">
																		<div class="form-check form-check-inline mt-3">
																			<input class="form-check-input" type="radio"
																				name="gender" id="inlineRadio1" value="男性" checked />
																			<label class="form-check-label" for="inlineRadio1"
																				style="font-size: 15px;">男性</label>
																		</div>
																		<div class="form-check form-check-inline">
																			<input class="form-check-input" type="radio"
																				name="gender" id="inlineRadio2" value="女性" /> <label
																				class="form-check-label" for="inlineRadio2"
																				style="font-size: 15px;">女性</label>
																		</div>
																		<div class="form-check form-check-inline">
																			<input class="form-check-input" type="radio"
																				name="gender" id="inlineRadio3" value="其他" /> <label
																				class="form-check-label" for="inlineRadio3"
																				style="font-size: 15px;">不願透露</label>
																		</div>
																	</c:when>
																	<c:when test="${memberVO.gender =='女性' }">
																		<div class="form-check form-check-inline mt-3">
																			<input class="form-check-input" type="radio"
																				name="gender" id="inlineRadio1" value="男性" /> <label
																				class="form-check-label" for="inlineRadio1"
																				style="font-size: 15px;">男性</label>
																		</div>
																		<div class="form-check form-check-inline">
																			<input class="form-check-input" type="radio"
																				name="gender" id="inlineRadio2" value="女性" checked />
																			<label class="form-check-label" for="inlineRadio2"
																				style="font-size: 15px;">女性</label>
																		</div>
																		<div class="form-check form-check-inline">
																			<input class="form-check-input" type="radio"
																				name="gender" id="inlineRadio3" value="其他" /> <label
																				class="form-check-label" for="inlineRadio3"
																				style="font-size: 15px;">不願透露</label>
																		</div>
																	</c:when>
																	<c:otherwise>
																		<div class="form-check form-check-inline mt-3">
																			<input class="form-check-input" type="radio"
																				name="gender" id="inlineRadio1" value="男性" /> <label
																				class="form-check-label" for="inlineRadio1"
																				style="font-size: 15px;">男性</label>
																		</div>
																		<div class="form-check form-check-inline">
																			<input class="form-check-input" type="radio"
																				name="gender" id="inlineRadio2" value="女性" /> <label
																				class="form-check-label" for="inlineRadio2"
																				style="font-size: 15px;">女性</label>
																		</div>
																		<div class="form-check form-check-inline">
																			<input class="form-check-input" type="radio"
																				name="gender" id="inlineRadio3" value="其他" checked />
																			<label class="form-check-label" for="inlineRadio3"
																				style="font-size: 15px;">不願透露</label>
																		</div>
																	</c:otherwise>
																</c:choose>
															</div>
														</div>
													</div>
													<div class="mb-3">
														<label class="form-label" for="nickName">生日</label>
														<div class="">
															<input class="form-control" type="date"
																value="${memberVO.birthDate}" id="html5-date-input"
																name="birthDate" />
														</div>
													</div>
													<div class="mb-3">
														<label class="form-label" for="basic-default-phone">大頭貼</label>
														<input type="file" id="basic-default-phone"
															class="form-control phone-mask" />
													</div>
													<div class="modal-footer custom-form__btn">
														<button type="button" class="btn btn-close"
															data-dismiss="modal">取消</button>
														<div>
															<button type="submit" class="btn btn-green">修改</button>
															<input type="hidden" name="action" value="updatemember">
															<input type="hidden" name="memberNo"
																value="${memberVO.memberNo}"> <input
																type="hidden" name=memberAccount
																value="${memberVO.memberNo}"> <input
																type="hidden" name="activaction"
																value="${memberVO.activaction}">
														</div>
													</div>
												</form>
											</div>
										</div>

									</div>
								</div>
							</div>
							<!-- end edit profile -->
						</div>
						<!-- ProductOrder tab -->
						<div class="tab-pane fade" id="v-pills-productorder"
							role="tabpanel" aria-labelledby="v-pills-order-tab">
							<div class="order-table order-table__collapse">
								<div class="order-table__head">
									<div class="order-table__row order-table__row--head">
										<div class="order-table__cell order-table__cell--hash">#1111</div>
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

						</div>
						<!-- DesignerOrder tab -->
						<div class="tab-pane fade  show active" id="v-pills-designorder"
							role="tabpanel" aria-labelledby="v-pills-wishlist-tab">
							<div class="order-table order-table__collapse">
								<div class="panel">
									<div class="panel-body">
										<table
											class="table table-bordered bordered table-striped table-condensed datatable">
											<thead>
												<tr>
													<th>案件編號</th>
													<th>設計師名稱</th>
													<th>報價單狀態</th>
													<th>合約狀態</th>
													<th>工程進度</th>
													<th>案件狀態</th>
													<th>明細</th>
												</tr>
											</thead>
											<tbody>
												<c:forEach var="desOrderList" items="${desOrderList}">
													<tr>
														<td><strong>${desOrderList.orderNo}</strong></td>
														<td>${desOrderList.designerVO.designerName}</td>

														<%-- <td>${desOrderList.quotationStatus}</td> --%>
														<c:choose>
															<c:when test="${desOrderList.quotationStatus =='報價確認' }">
																<td>報價確認</td>
															</c:when>
															<c:when test="${desOrderList.quotationStatus =='確認中' }">
																<td>確認中</td>
															</c:when>
															<c:when test="${desOrderList.quotationStatus =='退回報價' }">
																<td>退回報價</td>
															</c:when>
															<c:otherwise>
																<td>未報價</td>
															</c:otherwise>
														</c:choose>
														<c:choose>
															<c:when test="${desOrderList.contractStatus =='合約確認' }">
																<td>合約確認</td>
															</c:when>
															<c:when test="${desOrderList.contractStatus =='確認中' }">
																<td>確認中</td>
															</c:when>
															<c:when test="${desOrderList.contractStatus =='退回合約' }">
																<td>退回合約</td>
															</c:when>
															<c:otherwise>
																<td>尚未進行</td>
															</c:otherwise>
														</c:choose>

														<td>工程進度</td>

														<c:choose>
															<c:when test="${desOrderList.finishStatus =='true' }">
																<td>已結案</td>
															</c:when>
															<c:otherwise>
																<td>未結案</td>
															</c:otherwise>
														</c:choose>
														<td>
															<form method="post" action="MemberServlet">
																<label class="btn btn-primary" tabindex="0"> <span
																	class="d-none d-sm-block">明細</span> <i
																	class="fa-regular fa-pen-to-square d-block d-sm-none"></i>
																	<input type="submit" class="account-file-input" hidden />
																	<input type="hidden" name="orderNo"
																	value="${desOrderList.orderNo}"> <input
																	type="hidden" name="action" value="desOrder_GetOne">
																</label>
															</form>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
								</div>

								<div class="card mb-4">
									<div
										class="card-header d-flex align-items-center justify-content-between">
										<h5 class="mb-0">案件編號：${findDesignerOrder.orderNo}</h5>
										<small class="text-muted float-end">設計師：${findDesignerOrder.designerVO.designerName}</small>
										<input type="hidden" name="orderNo"
											value="${findDesignerOrder.designerNo}"> <input
											type="hidden" name="designerNo"
											value="${findDesignerOrder.designerNo}">
									</div>
									<div class="card-body">
										<form method="post" action="MemberOrderServlet">
											<!-- 諮詢 -->
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label"
													for="basic-default-name"><h5>諮詢明細</h5></label>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label" for="inquiryBudget">諮詢預算</label>
												<div class="col-sm-10">
													<fmt:setLocale value="zh_TW" />
													<input type="text" class="form-control"
														name="inquiryBudget" id="inquiryBudget"
														value="<fmt:formatNumber value="${findDesignerOrder.inquiryBudget}" 
															type="currency" maxFractionDigits="0" />"
														readonly />
												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label" for="inquirySize">諮詢坪數</label>
												<div class="col-sm-10">
													<input type="text" class="form-control" name="inquirySize"
														id="inquirySize" value="${findDesignerOrder.inquirySize}"
														readonly />
												</div>
											</div>
											<div class="row mb-3">
												<label class="col-sm-2 col-form-label" for="inquiryDetail">諮詢構想描述</label>
												<div class="col-sm-10">
													<textarea id="inquiryDetail" class="form-control"
														name="inquiryDetail" readonly
														aria-describedby="basic-icon-default-message2">${findDesignerOrder.inquiryDetail}</textarea>
												</div>
											</div>
											<div class="modal-footer"></div>
											<!-- /諮詢 -->

											<!-- 報價 -->
											<c:choose>
												<c:when test="${findDesignerOrder.quotationStatus =='未提供' }">
												</c:when>

												<c:otherwise>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="basic-default-name"><h5>報價明細</h5></label>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="quotationAmount">報價金額</label>
														<div class="col-sm-10">
															<fmt:setLocale value="zh_TW" />
															<input type="text" class="form-control"
																name="quotationAmount" id="quotationAmount"
																value="<fmt:formatNumber value="${findDesignerOrder.quotationAmount}" 
															type="currency" maxFractionDigits="0" />"
																readonly />
														</div>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="quotationDetail">報價單內容</label>
														<div class="col-sm-10">
															<textarea id="quotationDetail" class="form-control"
																name="quotationDetail" readonly
																aria-describedby="basic-icon-default-message2">${findDesignerOrder.quotationDetail}</textarea>
														</div>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="basic-default-name">報價單附檔</label>
														<div class="col-sm-10" style="line-height: 38px">
															<c:choose>
																<c:when test="${findDesignerOrder.quotationAtt!=null}">
																	<span> <a href="#" class="btn add-to-cart-btn"
																		onclick="window.open(
	    																'<%=request.getContextPath()%>/Quotationinfo?orderNo=${findDesignerOrder.orderNo}'
	    																, '_blank').focus();">預覽報價單</a></span>
																</c:when>
																<c:when test="${findDesignerOrder.quotationAtt==null}">
																	無報價附件
																</c:when>
															</c:choose>
															<input type="hidden" class="form-control"
																name="quotationAtt" id="basic-default-name"
																value="${findDesignerOrder.quotationAtt}" />
														</div>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label" for="quotationNote">報價單備註</label>
														<div class="col-sm-10">
															<textarea id="quotationNote" class="form-control"
																name="quotationNote" readonly
																aria-describedby="basic-icon-default-message2">${findDesignerOrder.quotationNote}</textarea>
														</div>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="quotationStatus">報價單狀態</label>
														<div class="col-sm-10">
															<input type="text" class="form-control" readonly
																name="quotationStatus" id="quotationStatus"
																value="${findDesignerOrder.quotationStatus}" />
														</div>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="basic-default-name">報價成立時間</label>
														<div class="col-sm-10 col-form-label">
															${findDesignerOrder.quotationApprovalTime} <input
																type="hidden" name="quotationApprovalTime"
																value="${findDesignerOrder.quotationApprovalTime}">
														</div>
													</div>
													<div class="row justify-content-end custom-form__btn"
														style="padding-bottom: 20px;">
														<div>
															<button type="submit" class="btn btn-primary"
																style="margin-right: 10px;" name="action"
																value="confirmedQuotation">確認報價單</button>
															<input type="hidden" name="orderNo"
																value="${findDesignerOrder.designerNo}"> <input
																type="hidden" name="memberNo"
																value="${findDesignerOrder.memberNo}">
															<button type="submit" class="btn btn-close"
																style="margin-right: 10px;" name="action"
																value="rejectQuotation">退回報價單</button>
															<input type="hidden" name="memberNo"
																value="${findDesignerOrder.memberNo}">
														</div>
													</div>
													<div class="modal-footer"></div>
												</c:otherwise>
											</c:choose>
											<!-- /報價 -->

											<!-- 合約 -->
											<c:choose>
												<c:when test="${findDesignerOrder.contractStatus =='尚未進行' }">
												</c:when>

												<c:otherwise>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="basic-default-name"><h5>合約明細</h5></label>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="contractDetail">合約內容</label>
														<div class="col-sm-10">
															<textarea id="contractDetail" class="form-control"
																readonly aria-describedby="basic-icon-default-message2">${findDesignerOrder.contractDetail}</textarea>
														</div>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label" for="contractAtt">合約附檔</label>
														<div class="col-sm-10" style="line-height: 38px">
															<c:choose>
																<c:when test="${findDesignerOrder.contractAtt!=null}">
																	<span> <a href="#" class="btn add-to-cart-btn"
																		onclick="window.open(
	    																'<%=request.getContextPath()%>/Quotationinfo?orderNo=${findDesignerOrder.orderNo}'
	    																, '_blank').focus();">預覽合約</a></span>
																</c:when>
																<c:when test="${findDesignerOrder.contractAtt==null}">
																	無合約附件
																</c:when>
															</c:choose>
															<input type="hidden" class="form-control"
																name="contractAtt" id="basic-default-name"
																value="${findDesignerOrder.contractAtt}" />
														</div>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label" for="contractNote">合約備註</label>
														<div class="col-sm-10">
															<textarea id="contractNote" class="form-control"
																name="contractNote" readonly
																aria-describedby="basic-icon-default-message2">${findDesignerOrder.contractNote}</textarea>
														</div>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="contractStatus">合約狀態</label>
														<div class="col-sm-10">
															<input type="text" class="form-control"
																name="contractStatus" readonly id="contractStatus"
																value="${findDesignerOrder.contractStatus}" />
														</div>
													</div>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="contractApprovalTime">合約成立時間</label>
														<div class="col-sm-10 col-form-label">
															${findDesignerOrder.contractApprovalTime}</div>
													</div>
													<div class="row justify-content-end custom-form__btn"
														style="padding-bottom: 20px;">
														<div>
															<button type="submit" class="btn btn-primary"
																style="margin-right: 10px;" name="action"
																value="confirmedContract">確認合約</button>
															<input type="hidden" name="orderNo"
																value="${findDesignerOrder.designerNo}"> <input
																type="hidden" name="memberNo"
																value="${findDesignerOrder.memberNo}">
															<button type="submit" class="btn btn-close"
																style="margin-right: 10px;" name="action"
																value="rejectContract">退回合約</button>
														</div>
													</div>
													<div class="modal-footer"></div>
												</c:otherwise>
											</c:choose>
											<!-- /合約 -->

											<!-- 工程進度 -->
											<c:choose>
												<c:when test="${findDesignerOrder.contractStatus =='尚未進行' }">
												</c:when>

												<c:otherwise>
													<div class="row mb-3">
														<label class="col-sm-2 col-form-label"
															for="basic-default-name"><h5>工程進度</h5></label>
													</div>
													<div class="card">
														<div class="table-responsive text-nowrap">
															<table class="table table-striped">
																<thead>
																	<tr>
																		<th>工程期數</th>
																		<th>工程金額</th>
																		<th>施工狀態</th>
																		<th>施工圖片</th>
																		<th>付款狀態</th>
																		<th>上傳付款證明</th>
																		<th></th>
																	</tr>
																</thead>
																<tbody class="table-border-bottom-0">
																	<c:forEach var="designerOrderList"
																		items="${designerOrderList}">
																		<tr>
																			<td style="vertical-align: middle;"><strong>${designerOrderList.orderPhase}</strong></td>
																			<fmt:setLocale value="zh_TW" />
																			<td style="vertical-align: middle;"><fmt:formatNumber
																				value="${designerOrderList.amount}"
																				type="currency" maxFractionDigits="0" /></td>
																			<td style="vertical-align: middle;">${designerOrderList.constructionStatus}</td>
																			<td style="vertical-align: middle;">
																				<%-- <img
																				src="<%=request.getContextPath()%>/AdminPicReader?adminNo=${adminVoList.adminNo}"
																				alt class="avatar w-px-40 rounded-circle" /> --%>施工圖片
																			</td>
																			<td style="vertical-align: middle;">${designerOrderList.paymentStatus}</td>
																			<td style="vertical-align: middle;"><input
																				type="file" name="upfilequotation" id="fileinp"></td>
																			<td style="vertical-align: middle;"><label
																				class="btn btn-primary" tabindex="0"> <span
																					class="d-none d-sm-block">上傳</span> <i
																					class="fa-regular fa-pen-to-square d-block d-sm-none"></i>
																					<%-- <input type="submit" class="account-file-input"
																					hidden /> <input type="hidden" name="phaseNo"
																					value="${desOrderList.phaseNo}"> <input
																					type="hidden" name="action" value="desOrder_GetOne"> --%>
																			</label></td>
																		</tr>
																	</c:forEach>
																</tbody>
															</table>
														</div>
													</div>
												</c:otherwise>
											</c:choose>
											<!-- /工程進度 -->
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


</body>
</html>
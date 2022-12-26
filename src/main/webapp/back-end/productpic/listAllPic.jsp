<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.productpic.model.*"%>
<%@ page import="com.product.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<!DOCTYPE html>

<html lang="en" class="light-style layout-menu-fixed" dir="ltr"
	data-theme="theme-default" data-assets-path="../assets/"
	data-template="vertical-menu-template-free">
<head>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, user-scalable=no, minimum-scale=1.0, maximum-scale=1.0" />

<title>MatDesign ListAllAdmin</title>

<meta name="description" content="" />

<!-- Favicon -->
<link rel="icon" type="image/x-icon"
	href="../assets/img/favicon/favicon.ico" />

<!-- Fonts -->
<script src="https://kit.fontawesome.com/6a35b80892.js"
	crossorigin="anonymous"></script>
<link rel="preconnect" href="https://fonts.googleapis.com" />
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
<link
	href="https://fonts.googleapis.com/css2?family=Public+Sans:ital,wght@0,300;0,400;0,500;0,600;0,700;1,300;1,400;1,500;1,600;1,700&display=swap"
	rel="stylesheet" />

<!-- Icons. Uncomment required icon fonts -->
<link rel="stylesheet" href="../assets/vendor/fonts/boxicons.css" />

<!-- Core CSS -->
<link rel="stylesheet" href="back-end/assets/vendor/css/core.css"
	class="template-customizer-core-css" />
<link rel="stylesheet" href="/assets/vendor/css/theme-default.css"
	class="template-customizer-theme-css" />
<link rel="stylesheet" href="/assets/css/demo.css" />

<!-- Vendors CSS -->
<link rel="stylesheet"
	href="back-end/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.css" />

<link rel="stylesheet"
	href="back-end/assets/vendor/libs/apex-charts/apex-charts.css" />

<!-- Page CSS -->

<!-- Helpers -->
<script src="back-end/assets/vendor/js/helpers.js"></script>

<!--! Template customizer & Theme config files MUST be included after core stylesheets and helpers.js in the <head> section -->
<!--? Config:  Mandatory theme config file contain global vars & default theme options, Set your preferred theme option in this file.  -->
<script src="back-end/assets/js/config.js"></script>
</head>
<body bgcolor='white'>

<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>


<h3>所有商品圖片 - listAllPic.jsp</h3>


<jsp:useBean id="productPicSrc" scope="page" class="com.productpic.model.ProductPicService" />
<a href='http://localhost:8080/TGA104_G4/back-end/productpic/addPic.jsp'>新增圖片</a>

<table>
	<tr>
		<th>商品圖片編號</th>
		<th>商品編號</th>
		<th>商品圖片</th>
		<th>修改</th>
	</tr>

	<c:forEach var="productPicVO" items="${list}">
			<td>${productPicVO.productPicNo}</td>
			<td>${productPicVO.productNo}</td>
			<td>
			<img src="<%=request.getContextPath()%>/PicAllReadServlet?productPicNo=${productPicVO.productPicNo}"
     			 alt="image" style="width: 100px; height: 100px;">
     		</td>
     		<td>
			  <FORM METHOD="post" ACTION="http://localhost:8080/TGA104_G4/PicServlet" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="productPicNo"  value="${productPicVO.productPicNo}">
			     <input type="hidden" name="action"	value="getProductPic_For_Update">
			  </FORM>
			</td>
            <tr></tr>
	</c:forEach>

</table>
<a href="http://localhost:8081/TGA104G4/back-end/product/product.jsp">回首頁</a>
					<!-- Footer -->
					<footer class="content-footer footer bg-footer-theme">
						<div
							class="container-xxl d-flex flex-wrap justify-content-between py-2 flex-md-row flex-column">
							<div class="mb-2 mb-md-0">
								©
								<script>
									document.write(new Date().getFullYear());
								</script>
								, made by <a href="#" target="_blank"
									class="footer-link fw-bolder">MatDesign</a>
							</div>
						</div>
					</footer>
					<!-- / Footer -->

					<div class="content-backdrop fade"></div>
				</div>
				<!-- Content wrapper -->
			</div>
			<!-- / Layout page -->
		</div>

		<!-- Overlay -->
		<div class="layout-overlay layout-menu-toggle"></div>
	</div>
	<!-- / Layout wrapper -->

	<!-- Core JS -->
	<!-- build:js assets/vendor/js/core.js -->
	<script src="back-end/assets/vendor/libs/jquery/jquery.js"></script>
	<script src="back-end/assets/vendor/libs/popper/popper.js"></script>
	<script src="back-end/assets/vendor/js/bootstrap.js"></script>
	<script
		src="back-end/assets/vendor/libs/perfect-scrollbar/perfect-scrollbar.js"></script>

	<script src="back-end/assets/vendor/js/menu.js"></script>
	<!-- endbuild -->

	<!-- Vendors JS -->
	<script src="back-end/assets/vendor/libs/apex-charts/apexcharts.js"></script>

	<!-- Main JS -->
	<script src="back-end/assets/js/main.js"></script>
	<script src="back-end/assets/js/main.js"></script>


	<!-- Page JS -->
	<script src="back-end/assets/js/dashboards-analytics.js"></script>

	<!-- Place this tag in your head or just before your close body tag. -->
	<script async defer src="https://buttons.github.io/buttons.js"></script>
</body>
</html>
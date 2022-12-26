<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>設計師查詢頁</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="Free HTML Templates" name="keywords" />
<meta content="Free HTML Templates" name="description" />

<style>
table#table-1 {
	width: 550px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 3px ridge Gray;
	height: 80px;
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


<link href="css/MatDesign.css" rel="stylesheet" />
<!-- Favicon -->
<link href="img/favicon.ico" rel="icon" />

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
<link href="lib/owlcarousel/assets/owl.carousel.min.css"
	rel="stylesheet" />

<!-- Customized Bootstrap Stylesheet -->
<link href="css/style.css" rel="stylesheet" />

  <script
      src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js"
      integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4"
      crossorigin="anonymous"
    ></script>

</head>
<body bgcolor='white'>

<!-- Topbar Start -->
	<div class="container-fluid d-none d-lg-block">
		<div class="row align-items-center py-4 px-xl-5">
			<div class="align-item-center-right">
			</div>
			<div class="modal fade" id="loginModal">
				<div class="modal-dialog">
					<div class="modal-content">
					</div>
				</div>
			</div>
			<div class="col-lg-0">
				<a href="index.jsp" class="text-decoration-none">
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
					<a href="" class="text-decoration-none d-block d-lg-none">
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
							<a id="product" href="index.html" class="nav-item nav-link">找作品</a>
							<a id="design" href="select_designer_page.jsp" class="nav-item nav-link">找設計師</a>
							<a id="store" href="course.html" class="nav-item nav-link">商城</a>
							<a id="fourm" href="teacher.html" class="nav-item nav-link">論壇</a>
							<a id="topic" href="teacher.html" class="nav-item nav-link">報導文章</a>
						</div>

					</div>
				</nav>
			</div>
		</div>
	</div>
	<!-- Navbar End -->
	
	
<hr>


	<table id="table-1">
		<tr>
			<td><h3>設計師查詢頁面( MVC model )</h3></td>
		</tr>
	</table>
	
	
	<h3>資料查詢:</h3>

	<%-- 錯誤表列 --%>
	<%-- <c:if test="${not empty errorMsgs}"> --%>
	<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
	<!-- 	<ul> -->
	<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
	<%-- 			<li style="color:red">${message.value}</li> --%>
	<%-- 		</c:forEach> --%>
	<!-- 	</ul> -->
	<%-- </c:if> --%>

	<ul>
		<li><a href='listAllDesigner.jsp'>查看所有設計師</a>  <br>
			<br></li>

        <li>  <a>以下單一查詢設計師</a></li>

 	<li>
			<FORM METHOD="post" ACTION="designer.do">
 			<b>輸入設計師編號 (如1、2):</b> <input type="text" name="designerNo"
				value="${param.designerNo}"><font color=red>${errorMsgs.designerNo}</font>
	 			<input type="hidden" name="action" value="getOne_For_Display">
	 			<input type="submit" value="送出">
			</FORM>
		</li>

		<jsp:useBean id="designerSvc" scope="page"
			class="com.tibame.designer.service.DesignerService" />

		<li>
			<FORM METHOD="post" ACTION="designer.do">
				<b>選擇設計師編號:</b> <select size="1" name="designerNo">
					<c:forEach var="designerVO" items="${designerSvc.all}">
						<option value="${designerVO.designerNo}">${designerVO.designerNo}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>

		<li>
			<FORM METHOD="post" ACTION="designer.do">
				<b>選擇設計師姓名:</b> <select size="1" name="designerNo">
					<c:forEach var="designerVO" items="${designerSvc.all}">
						<option value="${designerVO.designerNo}">${designerVO.designerName}
					</c:forEach>
				</select> <input type="hidden" name="action" value="getOne_For_Display">
				<input type="submit" value="送出">
			</FORM>
		</li>
	</ul>


	<h3>設計師管理</h3>

	<ul>
		<li><a href='addDesigner.jsp'>新增設計師資料</a></li>
	</ul>



</body>
</html>
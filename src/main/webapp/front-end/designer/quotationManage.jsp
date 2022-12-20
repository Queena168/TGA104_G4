<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>






<!DOCTYPE html>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>報價管理 -	QuotationManage.jsp</title>


<meta charset="utf-8" />
<title>報價資料</title>
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
  
  .logintitle{
  position: absolute;
  width:100px;
  right: 180px;
  }
</style>

</head>
<body bgcolor='white'>

<!-- Topbar Start -->
	<div class="container-fluid d-none d-lg-block">
		<div class="row align-items-center py-4 px-xl-5">
			<div class="align-item-center-right">
			<form method="post" action="<%=request.getContextPath()%>/DesignerLogout">
			<div class="logintitle"><p>設計師${designerVO.designerName}您好</p></div>
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
							<div id="selfedit" style="width: 200px"><a href="<%=request.getContextPath()%>/DesignerEdit?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>編輯簡介</b></a></div>
							<div id="ordermanage" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerOrder?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>案件管理</b></a></div>
							<div id="quotation" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerQuotationController?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>報價管理</b></a></div>
							<div id="contract" style="width: 200px"><a  href="<%=request.getContextPath()%>/DesignerContractController?designerNo=${designerVO.designerNo}" class="nav-item nav-link"><b>合約管理</b></a></div>
							<div id="portfolio" style="width: 200px"><a  href="teacher.html" class="nav-item nav-link"><b>作品管理</b></a></div>
						</div>
					</div>
					
				</nav>
			</div>
		</div>
	</div>
	
	<!-- Navbar End -->
	
<hr size="8px" align="center" width="100%" color="gray">

<div style="text-align:center"><h3>報價管理</h3></div>
<div class="content_box_grey">
  <div>
     <div>
<!-- =============================================================================================== -->

<!-- =============================================================================================== -->
   
     </div>
  </div>
 
</div>
<div align="center">
<table>
	<tr>
	 	<th>案件編號</th>
	 	<th>客戶</th>
	 	<th>接案設計師</th>
		<th>案件報價狀態</th>
		<th>查看詳細資訊</th>
	</tr>

	<c:forEach var="designerOrderVO" items="${list}" >	
		
		<tr>
		 	<td>${designerOrderVO.orderNo}</td>
		 	<td>${designerOrderVO.memberVO.memberName}</td>
		 	<td>${designerOrderVO.designerVO.designerName}</td>
			<td>${designerOrderVO.quotationStatus}</td>
		 		
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/ShowOneQuotationDetail" style="margin-bottom: 0px;">
			     <input type="submit" value="查看">
			     <input type="hidden" name="orderNo"  value="${designerOrderVO.orderNo}">
			     <input type="hidden" name="action"	value="getMyQuotation">
			  </FORM>
			</td>					
		</tr>
		</c:forEach>
</table>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>


</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.tibame.designer.model.*" %>


<%
  DesignerVO designerVO=(DesignerVO) session.getAttribute("designerVO");
  DesignerOrderVO designerOrderVO = (DesignerOrderVO) request.getAttribute("designerOrderVO"); //DesignerServlet.java(Concroller), 存入req的empVO物件
%>


<html>
<head>
<title>報價 - listOneQuotation.jsp</title>

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
	width: 800px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
}

table, th, td {
	border: 0px solid #CCCCFF;
}

th, td {
	padding: 1px;
}
</style>


<style>
#preview {
	border: 1px solid lightgray;
	display: inline-block;
	width: 150px;
	min-height: 200px;
	position: relative;
	

	
}

#preview span.text {
	position: absolute;
	display: inline-block;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
	z-index: -1;
	color: lightgray;
}

#preview img.preview_img {
	width: 100%;
}


.wrap{
    margin: auto;
    margin-left: 500px;
}
.wrap1{
    margin: auto;
    margin-left: 300px;
}


#block1{
margin-left: 200px;
}
#block2{
margin-left: 50px;
}

img{
    max-width:100%; /*不使用width:100% 是因避免圖片解析度不好，隨父元素被放大時會糊掉*/
    height:auto;
}

.intro{
margin-left: 200px;

}

</style>



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
<hr size="8px" align="center" width="100%" >
<div style="text-align:center"><h3>案件報價</h3></div>
<div align="center">
<form method="post" action="AddQuotation" >
<table>

		<tr><th>案件編號:</th><td>${designerOrderVO.orderNo}</td></tr>
		<tr><th>客戶:</th><td>${designerOrderVO.memberVO.memberName}</td></tr>
		<tr><th>案件設計師</th><td>${designerOrderVO.designerVO.designerName}</td></tr>
		<tr><th>諮詢預算</th><td>${designerOrderVO.inquiryBudget}元</td></tr>
		<tr><th>諮詢坪數</th><td>${designerOrderVO.inquirySize}坪</td></tr>
		<tr><th>諮詢內容</th><td>${designerOrderVO.inquiryDetail}</td></tr>
	    <tr><th>報價狀態</th><td>${designerOrderVO.quotationStatus}</td></tr>
	    <tr><th>報價時間</th><td>${designerOrderVO.quotationSendTime}</td> </tr>
	    <tr>
	    <th>報價金額</th>
	      <c:choose>
				<c:when test="${designerOrderVO.quotationAmount==0}">
	                <td> 元</td>
	            </c:when>
	            <c:when test="${designerOrderVO.quotationAmount!=0}">
	                <td>${designerOrderVO.quotationAmount}元</td>
	            </c:when>
	      </c:choose>
	   
	    
	    </tr>
		<tr><th>報價內容</th><td>${designerOrderVO.quotationDetail}</td></tr>
	    <tr><th>報價同意時間</th><td>${designerOrderVO.quotationApprovalTime}</td></tr>

	 
</table>
     <div id="block2">
     	
              <input type="hidden" name="action" value="insertquotation">
              <input type="hidden" name="orderNo" value="${designerOrderVO.orderNo}">
              <input id="showorhidden1" type="submit" value="製作報價"  style="display: inline-block;">
              
              <input type="hidden" name="action" value="updatequotation">
              <input type="hidden" name="orderNo" value="${designerOrderVO.orderNo}">
              <input id="showorhidden2" type="submit" value="修改報價"  style="display: inline-block;">
       
              <input type="hidden" name="cancel" value="cancel">
              <input type="hidden" name="orderNo">
              <input type ="button" onclick="history.back()" value="回上一頁" >
              
              
             
     </div> 
</form>
</div>

   

<script type="text/javascript">

function DisplayAndHiddenBtn(btnName, type) {
   var currentinputbutton = document.getElementById(btnName);
   if (type == '未報價') {
	   //currentinputbutton.style.display = "inline-block"; //style中的display且橫向排列属性
	   document.getElementById("showorhidden2").style.display = "none";
   }else if(type == '退回報價'){
	   document.getElementById("showorhidden1").style.display = "none";
	   
   }else{
	   currentinputbutton.style.display = "none"; 
   }
	 
}


</script>


      <script> 
              var type='${designerOrderVO.quotationStatus}';
	          DisplayAndHiddenBtn("showorhidden1",type);
	          DisplayAndHiddenBtn("showorhidden2",type);
	  </script>
</body>
</html>
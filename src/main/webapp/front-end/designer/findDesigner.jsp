<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>
<%@ page import="com.designer.model.*" %>
<%@ page import="com.designer.service.*" %>
<%@ page import="com.designer.controller.*" %>
<%@ page import="com.designerExpertise.model.*" %>



<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    DesignerService designerSvc = new DesignerService();
    List<DesignerVO> list = designerSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有設計師資料</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport" />
<meta content="Free HTML Templates" name="keywords" />
<meta content="Free HTML Templates" name="description" />
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
			<div class="modal fade" id="loginModal">
				<div class="modal-dialog">
					<div class="modal-content">
						<!-- Registration Start -->
						<div class="container-fluid bg-registration py-5"
							style="margin: 30px 0">
							<div class="col-lg-5">
								<div id="cardborder" class="card border-0">
									<!-- tab標籤開始 -->
									

									<!-- tab標籤結束 -->
									<div class="card-body rounded-bottom bg-primary p-5"><!-- 動這行會影響到左上角LOGO -->
							
										<!-- Footer -->
										<div class="modal-footer"><!-- 動這行會影響到左上角LOGO -->
											<div class="signup"><!-- 動這行會影響到左上角LOGO -->
												
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- Registration End -->
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
							<a id="design" href="findDesigner.jsp" class="nav-item nav-link">找設計師</a>
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
	
<!--  -->

<hr color="gray">
<div style="text-align:center"><h3>找設計師</h3></div>
<div class="content_box_grey">
  <div>&emsp;&emsp;<font size="4px" color="black">設計強項</font></div>
  <div>
     <div>
         <ul>
         <form METHOD="post">
            <input type="button" value="小坪數" /> &emsp;&emsp;
            <input type="button" value="大坪數" /> &emsp;&emsp;
            <input type="button" value="輕奢新古典"/> &emsp;&emsp;
            <input type="button" value="格局動線"/> &emsp;&emsp;
            <input type="button" value="透天設計"/> &emsp;&emsp;
            <input type="button" value="退休樂活"/> &emsp;&emsp;
            <input type="button" value="小資裝潢"/> &emsp;&emsp;
            <input type="button" value="老屋翻新"/> &emsp;&emsp;
            <input type="button" value="奢華裝修"/> 
        </form>
         </ul>
     </div>
  </div>
 
</div>

<!-- Team Start -->
	<div class="container-fluid py-5">
		<div class="container pt-5 pb-3">
			<div class="text-center mb-5">
				<h2 class="text-primary text-uppercase mb-3"
					style="letter-spacing: 5px">設計師</h2>
				<!--  <h1>熱門設計師</h1>-->
			</div>
		
			<div class="row">
				<div class="col-md-6 col-lg-3 text-center team mb-4">
				<c:forEach var="designerVO"  items="${list}" begin="0" end="0">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
	<!-- 設計師圖片 -->						<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100% alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light " href="#">查看<i
									class="fab fa-twitter"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
						
	<!-- 設計師姓名 -->						<h5>${designerVO.designerName}</h5>
						
	<!-- 設計師公司 -->						<p class="m-0">${designerVO.designerCompany}</p>
						</div>
					</div>
					</c:forEach>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
				<c:forEach var="designerVO"  items="${list}" begin="1" end="1">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100% alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light " href="#">查看<i
									class="fab fa-twitter"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
							
							<h5>${designerVO.designerName}</h5>
						
							<p class="m-0">${designerVO.designerCompany}</p>
						</div>
					</div>
					</c:forEach>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
				<c:forEach var="designerVO"  items="${list}" begin="2" end="2">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100% alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light " href="#">查看<i
									class="fab fa-twitter"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
						
							<h5>${designerVO.designerName}</h5>
						
							<p class="m-0">${designerVO.designerCompany}</p>
						</div>
					</div>
					</c:forEach>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
				<c:forEach var="designerVO"  items="${list}" begin="3" end="3">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100% alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light " href="#">查看<i
									class="fab fa-twitter"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
						
							<h5>${designerVO.designerName}</h5>
						
							<p class="m-0">${designerVO.designerCompany}</p>
						</div>
					</div>
					</c:forEach>
				</div>
			</div>
			
			<!--第二列開始  -->
			
					<div class="row">
				<div class="col-md-6 col-lg-3 text-center team mb-4">
				<c:forEach var="designerVO"  items="${list}" begin="4" end="4">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100% alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light " href="#">查看<i
									class="fab fa-twitter"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
							
							<h5>${designerVO.designerName}</h5>
						
							<p class="m-0">${designerVO.designerCompany}</p>
						</div>
					</div>
					</c:forEach>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
				<c:forEach var="designerVO"  items="${list}" begin="5" end="5">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100% alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light " href="#">查看<i
									class="fab fa-twitter"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
							
							<h5>${designerVO.designerName}</h5>
						
							<p class="m-0">${designerVO.designerCompany}</p>
						</div>
					</div>
					</c:forEach>
				</div>
				<div class="col-md-6 col-lg-3 text-center team mb-4">
				<c:forEach var="designerVO"  items="${list}" begin="6" end="6">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
							<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100%  alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light " href="#">查看<i
									class="fab fa-twitter"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
							
							<h5>${designerVO.designerName}</h5>
						
							<p class="m-0">${designerVO.designerCompany}</p>
						</div>
					</div>
					</c:forEach>
				</div>
				<c:forEach var="designerVO"  items="${list}" begin="7" end="7">
				<div class="col-md-6 col-lg-3 text-center team mb-4">
					<div class="team-item rounded overflow-hidden mb-2">
						<div class="team-img position-relative">
						
							<img class="img-fluid" src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}" width=100%  alt="" />
							<div class="team-social">
								<a class="btn btn-outline-light " href="#">查看<i
									class="fab fa-twitter"></i></a>
							</div>
						</div>
						<div class="bg-secondary p-4">
							
							<h5>${designerVO.designerName}</h5>
						
							<p class="m-0">${designerVO.designerCompany}</p>
						</div>
					</div>
				</div>
				</c:forEach>
			</div>
			
		
		</div>
	</div>
	<!-- Team End -->



	 <!--<tr>-->
	 <!--	<th>設計師編號</th>-->
	 <!--	<th>設計師帳號</th>-->
	 <!--	<th>設計師密碼</th>-->
	<!--	<th>設計師姓名</th>-->
	<!--	<th>公司</th>-->
	<!--	<th>設計師照片</th>-->
		<!--<th>專長</th>-->
	 <!--	<th>審核狀態</th>-->
	 <!--	<th>審核成功時間</th>-->
	 <!--	<th>審核人</th>-->
	 <!--	<th>設計師狀態</th>-->
	 <!--	<th>修改</th>-->
	  <!--	<th>刪除</th>-->
	 <!--</tr>-->

	
		
	 <!--	<tr>-->
		 <!--	<td>${designerVO.designerNo}</td>-->
		 <!--	<td>${designerVO.designerAccount}</td>-->
		 <!--	<td>${designerVO.designerPassword}</td>-->
			 <!--<td>${designerVO.designerName}</td>-->
			 <!--<td>${designerVO.designerCompany}</td>-->
		 <!--	<td><img src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}"></td>-->
			 <!--	<td>${designerVO.approvalStatus}</td>-->
			 <!--	<td>${designerVO.approvalTime}</td>-->
			 <!--	<td>${designerVO.approver}</td>-->
			 <!--	<td>${designerVO.designerStatus}</td> -->
			
			
		
			
			<!--<td>-->
			<!--  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/designer/designer.do" style="margin-bottom: 0px;">-->
			 <!--    <input type="submit" value="修改">-->
			  <!--   <input type="hidden" name="designerNo"  value="${designerVO.designerNo}">-->
			  <!--   <input type="hidden" name="action"	value="getOne_For_Update">-->
			 <!--   </FORM>-->
			<!--</td>-->
			
			
			
	    <!--  	<td>   -->
		<!--	  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/designer/designer.do" style="margin-bottom: 0px;">-->
		<!--	     <input type="submit" value="刪除">-->
		<!--	     <input type="hidden" name="designerNo"  value="${designerVO.designerNo}">-->
		<!--	     <input type="hidden" name="action" value="delete"></FORM>-->
		<!--	</td>-->
			
		
	 <!--	</tr>-->
	
<!--</table>  -->


</body>
</html>
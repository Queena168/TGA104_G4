<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.productpic.model.*"%>
<%@ page import="com.cart.model.*"%>

<%
User auth = (User)request.getSession().getAttribute("auth");
if(auth!=null){
	request.setAttribute("auth", auth);
}
%>

<%
ShopProductService shopProductService = new ShopProductService();
ShopProduct shopProductVO = (ShopProduct) request.getAttribute("shopProductVO");
List<Map<String, Object>> list = shopProductService.getAll();
pageContext.setAttribute("list", list);



ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list"); 
if(cart_list != null){
	request.setAttribute("cart_list", cart_list);
}
%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>shopProduct.jsp (shopping index)</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<style>
table {
	width: 800px;
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
</style>
<style>
.btn-primary {
    color: #fff;
    background-color: #ff7c07;
    border-color: #ff7c07;
}
</style>

</head>
<body bgcolor="#FFFFFF">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
<div class="container">
  <a class="navbar-brand" href="http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp">
  	<img src="/TGA104_G4/front-end/order/images/MatDesign.JPG" alt="" width="100%" height="45">
  </a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav ml-auto">
      <li class="nav-item active"><a class="nav-link" href="http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp">首頁</a></li>
      <li class="nav-item"><a class="nav-link" href="http://localhost:8080/TGA104_G4/front-end/cart/cart.jsp">購物車<span class="badge badge-danger px-1">${cart_list.size()}</span></a></li>
      <% 
      if(auth != null){%>
      	<li class="nav-item"><a class="nav-link" href="http://localhost:8080/TGA104_G4/front-end/order/order.jsp">訂單</a></li>
        <li class="nav-item"><a class="nav-link" href="/TGA104_G4/LogoutServlet">登出</a></li>
      <%}else{%>
      	<li class="nav-item"><a class="nav-link" href="http://localhost:8080/TGA104_G4/front-end/cart/login.jsp">登入</a></li>
      <%}
      %>
    </ul>
  </div>
  </div>
</nav>







<div id="carouselExampleIndicators" class="carousel slide" data-ride="carousel">
  <ol class="carousel-indicators">
    <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
    <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
  </ol>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img class="d-block w-100" src="/TGA104_G4/front-end/cart/images/home.jpeg" width="100%" height="400px" alt="First slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="/TGA104_G4/front-end/cart/images/sofa1.jpg" width="100%" height="400px" alt="Second slide">
    </div>
    <div class="carousel-item">
      <img class="d-block w-100" src="/TGA104_G4/front-end/cart/images/curtain.jpg" width="100%" height="400px" alt="Third slide">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
<br>
<br>
<br>
	<div class="container">
		<div class="card-headermy-3"><h3>商品列表</h3></div>
		<div class="row">
		<c:forEach var="shopProductVO" items="${list}">
			<div class="col-md-3 my-3">
				<div class="card w-100" style="width: 18rem;">
					<img class="card-img-top" src="<%=request.getContextPath()%>/PicReadServlet?productNo=${shopProductVO.productNo}" alt="Card image cap">
					<div class="card-body">
						<h5 class="card-title">${shopProductVO.productName}</h5>
<%-- 						<h5 class="productNo">${shopProductVO.productNo}</h5> --%>
						<h6 class="price">$${shopProductVO.price}</h6>
<!-- 						<div align="left"> -->
<!-- 							數量： <input type="text" name="quantity" size="1" value=1> -->
<!-- 						</div> -->
						<div class="mt-3 d-flex justify-content-between">
							<a href="<%=request.getContextPath()%>/CartServlet?id=${shopProductVO.productNo}" class="btn btn-dark">加入購物車</a>
							<a href="<%=request.getContextPath()%>/OrderNowServlet?id=${shopProductVO.productNo}" class="btn btn-primary">直接購買</a>
<%-- 							<a href="<%=request.getContextPath()%>/OrderNowServlet?quantity=1&id=${shopProductVO.productNo}" class="btn btn-primary">直接購買</a> --%>
<!-- 							<input class="btn btn-dark" type="submit" name="Submit" value="加入購物車"> -->
<!-- 							<input class="btn btn-primary" type="submit" name="Submit" value="直接購買"> -->
						</div>	
					</div>
				</div>
			</div>
		</c:forEach>	
		</div>
	</div>
	
	


    <!-- Footer Start -->
    <div
      id="footer"
      class="container-fluid bg-dark text-white py-5 px-sm-3 px-lg-5"
      style="margin-top: 250PX"
    >
      <div class="row pt-5">
        <div class="col-lg-7 col-md-12">
          <div class="row">
            <div class="col-md-6 mb-5">
              <h5
                class="text-primary text-uppercase mb-4"
                style="letter-spacing: 5px"
              >
                關於我們
              </h5>
              <a href="#" style="font-weight: bold">關於我們</a>
            </div>
            <div class="col-md-6 mb-5">
            </div>
          </div>
        </div>
      </div>
    </div>
		
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>	


</body>
</html>
<%@ page import="java.util.*"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cart.model.*, com.productorder.model.*"%>
<%
User auth = (User)request.getSession().getAttribute("auth");
if(auth!=null){
	response.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/shopProduct.jsp");
}
%>
<%
// ShopProductService shopProductService = new ShopProductService();
// ShopProduct shopProductVO = (ShopProduct) request.getAttribute("shopProductVO");

// List<Map<String, Object>> list = shopProductService.getAll();
// pageContext.setAttribute("list", list);

// ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list");
// if (cart_list != null) {
// 	request.setAttribute("cart_list", cart_list);
// }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<style type="text/css">
.table tbody td {
	vartical-align: middle;
}

.btn-incre, .btn-decre {
	box-shadow: none;
	font-size: 18px;
	color: #ff7c07;
}

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

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">用戶登入</div>
			<div class="card-body">
				<form action="/TGA104_G4/LoginServlet" method="post">

					<div class="form-group">
						<label>信箱</label> <input type="email" class="form-control"
							name="login-email" placeholder="請輸入信箱" required>
					</div>
					<div class="form-group">
						<label>密碼</label> <input type="password" class="form-control"
							name="login-password" placeholder="*****" required>
					</div>

					<div class="text-center">
						<button type="submit" class="btn btn-primary">登入</button>
					</div>

				</form>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
</body>
</html>
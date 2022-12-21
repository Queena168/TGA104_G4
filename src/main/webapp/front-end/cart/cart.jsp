<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.* , com.cart.model.*"%>
<%
User auth = (User)request.getSession().getAttribute("auth");
if(auth!=null){
	request.setAttribute("auth", auth);
}
%>

<%
Cart cart = (Cart) request.getAttribute("cart");
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart_list"); 
List<Cart> cartProduct = null;
if(cart_list != null){
	ShopProductService shopProductService = new ShopProductService();
	cartProduct = shopProductService.getCartProducts(cart_list);
	request.setAttribute("cart_list", cart_list);
	
	Integer total = shopProductService.getTotalCartPrice(cart_list);
	request.setAttribute("total", total);
}
%>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>cart.jsp</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
 <style type="text/css">
 .table tbody td{
 	vartical-align: middle;
 }
 
 .btn-incre, .btn-decre{
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
<div class="d-flex py-3">
<h3>目前累積價格：$ ${(total>0)?total:0}</h3>
<!-- <a class="mx-3 btn btn-primary" href="/TGA104G4/CheckOutServlet">結帳</a> -->
<a class="mx-3 btn btn-primary" href="http://localhost:8080/TGA104_G4/front-end/order/orderDetail.jsp">結帳</a>
<!-- <a class="mx-3 btn btn-primary" href="http://localhost:8081/TGA104G4/CheckOutServlet">結帳測試選擇</a> -->
</div>
<table class="table table-Lought">
<thead>
<tr>
<th scope="col">商品編號</th>
<th scope="col">商品名稱</th>
<th scope="col">商品價格</th>
<th scope="col">數量</th>
<th scope="col">取消</th>
</tr>
</thead>
<tbody>
<% 
if(cart_list != null){
	for(Cart c:cart_list){%>
		<tr>
		<td><%= c.getProductNo() %></td>
		<td><%= c.getProductName() %></td>
		<td><%= c.getPrice() * c.getQuantity()%></td>
		<td>
		<form action="/TGA104_G4/OrderNowServlet" method="post" class="form-inline">
		<input type="hidden" name="id" value="<%= c.getProductNo() %>" class="form-input">
		<div class="form-group d-flex justify-content-between w-50">
		<a class="btn btn-sm btn-decre" href="/TGA104_G4/QuantityIncDecServlet?action=dec&id=<%= c.getProductNo()%>"><i class="fas fa-minus-square"></i></a>
		<input type="text" name="quantity" class="form-control w-50" value="<%= c.getQuantity()%>" readonly>
		<a class="btn btn-sm btn-incre" href="<%=request.getContextPath()%>/QuantityIncDecServlet?action=inc&id=<%= c.getProductNo()%>"><i class="fas fa-plus-square"></i></a>
		</div>
<!-- 		<button type="submit" class="btn btn-primary btn-sm">直接購買</button> -->
		</form>
		</td>
		<td><a class="btn btn-sm btn-danger" href="<%=request.getContextPath()%>/RemoveFromCartServlet?id=<%= c.getProductNo()%>">刪除</a></td>
		</tr>
			<%}
	    }
		%>
</tbody>
</table>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>	
</body>
</html>
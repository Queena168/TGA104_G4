<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.* , com.cart.model.*, com.productorder.model.*"%>
<%
User auth = (User)request.getSession().getAttribute("auth");
List<ProductOrderVO> orders = null;
if(auth!=null){
	request.setAttribute("auth", auth);
    orders = new ProductOrderJDBCDAO().userOrders(auth.getUserNo());
}else{
	response.sendRedirect("http://localhost:8080/TGA104_G4/front-end/cart/login.jsp");
}
%>

<%
ShopProduct shopProduct = (ShopProduct) request.getAttribute("shopProduct");

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
<%
ProductOrderVO productOrderVO = (ProductOrderVO) request.getAttribute("productOrderVO");
%>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>orderDetail.jsp</title>
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
<br>
<h3>本次消費金額：$ ${(total>0)?total:0}</h3>
<br>
<h3>收貨資訊</h3>
<form METHOD="get" ACTION="/TGA104_G4/CheckOutServlet">
  <div class="form-row">
    <div class="form-group col-md-6">
      <label>收件人姓名</label>
      <input type="text" class="form-control" name="rname" value="<%=(productOrderVO == null) ? "姓名" : productOrderVO.getReceiverName()%>" placeholder="請輸入">
    </div>
    <div class="form-group col-md-6">
      <label>收件人電話</label>
      <input type="text" class="form-control" name="rphone" value="<%=(productOrderVO == null) ? "電話" : productOrderVO.getReceiverPhone()%>" placeholder="請輸入">
    </div>
  </div>
  <div class="form-group">
    <label>收件人地址</label>
    <input type="text" class="form-control" name="raddress" value="<%=(productOrderVO == null) ? "地址" : productOrderVO.getReceiverPhone()%>" placeholder="請輸入">
  </div>
<br>
<h3>付款方式</h3>
<div class="custom-control custom-radio custom-control-inline">
  <input type="radio" id="customRadioInline1" name="customRadioInline1" class="custom-control-input">
  <label class="custom-control-label" for="customRadioInline1">貨到付款</label>
</div>
<!-- <div class="custom-control custom-radio custom-control-inline"> -->
<!--   <input type="radio" name="radioDisabled" id="customRadioDisabled1" class="custom-control-input" disabled> -->
<!--   <label class="custom-control-label" for="customRadioDisabled1">銀行轉帳</label> -->
<!-- </div> -->
<!-- <div class="custom-control custom-radio custom-control-inline"> -->
<!--   <input type="radio" name="radioDisabled" id="customRadioDisabled2" class="custom-control-input" disabled> -->
<!--   <label class="custom-control-label" for="customRadioDisabled2">信用卡支付</label> -->
<!-- </div> -->
  <div class="d-flex justify-content-center">
<!--   <a class="mx-3 btn btn-primary" href="/TGA104G4/CheckOutServlet">確定送出</a> -->
<input type="hidden" name="action" value="insertReceive">
<input type="submit" value="確定送出">
  </div>
</form>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>	
</body>
</html>
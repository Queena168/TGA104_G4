<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>

<%
    ProductService productService = new ProductService();
    List<ProductVO> list = productService.getAll();
    pageContext.setAttribute("list",list);
%>

<html>
<head>
<title>所有商品資料 - listAllProduct.jsp</title>

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

</head>
<body bgcolor='white'>

<h3>所有商品資料 - listAllProduct.jsp</h3>
<a href='http://localhost:8080/TGA104_G4/back-end/product/addProduct.jsp'>新增商品</a>

<table>
	<tr>
		<th>商品編號</th>
		<th>商品類別編號</th>
		<th>商品名稱</th>
		<th>商品庫存量</th>
		<th>商品單價</th>
		<th>商品描述</th>
		<th>商品狀態</th>
		<th>管理員編號</th>
		<th>修改</th>
	</tr>
	<c:forEach var="productVO" items="${list}">
		<tr>
			<td>${productVO.productNo}</td>
			<td>${productVO.productTypeNo}</td>
			<td>${productVO.productName}</td>
			<td>${productVO.stock}</td>
			<td>${productVO.price}</td>
			<td>${productVO.productDescription}</td> 
			<td>${productVO.productStatus}</td>
			<td>${productVO.adminNo}</td>
	     
			<td>
			  <FORM METHOD="post" ACTION="http://localhost:8080/TGA104_G4/UpdateProductServlet" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="productNo"  value="${productVO.productNo}">
			     <input type="hidden" name="action"	value="getProduct_For_Update">
			  </FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<a href="http://localhost:8080/TGA104_G4/back-end/product/product.jsp">回首頁</a>
</body>
</html>
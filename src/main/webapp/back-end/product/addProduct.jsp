<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.product.model.*"%>

<%
ProductVO productVO = (ProductVO) request.getAttribute("productVO");
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>商品資料新增 - addProduct.jsp</title>

<style>
table {
	width: 450px;
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

</head>
<body bgcolor='white'>

<h3>商品資料新增 - addProduct.jsp</h3>

<h3>新增商品:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="/TGA104_G4/AddProductServlet" name="form1">
		<table>
		    <tr>
				<td>商品類別編號:</td>
				<td><input type="TEXT" name="productTypeNo"
					value="<%=(productVO == null) ? "1" : productVO.getProductTypeNo()%>" /></td>
			</tr>
			<tr>
				<td>商品名稱:</td>
				<td><input type="TEXT" name="productName"
					value="<%=(productVO == null) ? "" : productVO.getProductName()%>" /></td>
			</tr>
			<tr>
				<td>商品庫存量:</td>
				<td><input type="TEXT" name="stock"
					value="<%=(productVO == null) ? "" : productVO.getStock()%>" /></td>
			</tr>
			<tr>
				<td>商品價格:</td>
				<td><input type="TEXT" name="price"
					value="<%=(productVO == null) ? "" : productVO.getPrice()%>" /></td>
			</tr>
			<tr>
				<td>商品描述:</td>
				<td><input type="TEXT" name="productDescription"
					value="<%=(productVO == null) ? "" : productVO.getProductDescription()%>" /></td>
			</tr>
			<tr>
				<td>商品狀態:</td>
				<td><input type="TEXT" name="productStatus"
					value="<%=(productVO == null) ? "" : productVO.getProductStatus()%>" /></td>
			</tr>
			<tr>
				<td>管理員:</td>
				<td><input type="TEXT" name="adminNo"
					value="<%=(productVO == null) ? "1" : productVO.getAdminNo()%>" /></td>
			</tr>
		</table>
		<input type="hidden" name="action" value="insertProduct"> 
		<input type="submit" value="送出新增">
	</FORM>
	<a href="http://localhost:8080/TGA104_G4/back-end/product/listAllProduct.jsp">上一頁</a>
</body>
</html>
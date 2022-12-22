<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.product.model.*"%>
<%@ page import="com.productpic.model.*"%>


<%
ProductPicService productPicService = new ProductPicService();
    
    List<Map<String, Object>> list = productPicService.listAllProduct();
    pageContext.setAttribute("list",list);
%>
<%
  ProductPicVO productPicVO = (ProductPicVO) request.getAttribute("productPicVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>


<html>
<head>
<title>所有商品資料 - product.jsp</title>


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
<h3>所有商品資料 - product.jsp</h3>
<a href='http://localhost:8080/TGA104_G4/back-end/producttype/listAllProductType.jsp'>顯示所有商品類別</a><br>
<a href='http://localhost:8080/TGA104_G4/back-end/product/listAllProduct.jsp'>顯示所有商品</a><br>
<a href='http://localhost:8080/TGA104_G4/back-end/productpic/listAllPic.jsp'>顯示所有商品圖片</a>

<table>
	<tr>
		<th>商品編號</th>
		<th>商品類別名稱</th>
		<th>商品名稱</th>
		<th>商品庫存量</th>
		<th>商品單價</th>
		<th>商品描述</th>
		<th>商品狀態</th>
		<th>商品圖片</th>
		<th>管理員編號</th>
		
	</tr>
	<c:forEach var="productPicVO" items="${list}">
		<tr>
			<td>${productPicVO.productNo}</td>
			<td>${productPicVO.productTypeName}</td>
			<td>${productPicVO.productName}</td>
			<td>${productPicVO.stock}</td>
			<td>${productPicVO.price}</td>
			<td>${productPicVO.productDescription}</td> 
			<td>${productPicVO.productStatus}</td>
			<td>
				<img src="<%=request.getContextPath()%>/PicReadServlet?productNo=${productPicVO.productNo}"
     			     alt="image" style="width: 100px; height: 100px;">
     		</td>
			<td>${productPicVO.adminNo}</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
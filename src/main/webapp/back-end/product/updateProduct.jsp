<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@ page import="com.productpic.model.*"%> --%>
<%@ page import="com.product.model.*"%>

<%
  ProductVO productVO = (ProductVO) request.getAttribute("productVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>商品資料修改 - update_product_input.jsp</title>

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

<table id="table-1">
	<tr><td>
		 <h3>商品資料修改 - update_product_input.jsp</h3>
		 <h4><a href="/TGA104_G4/back-end/product/selectProduct_page.jsp"><img src="/TGA104G4/back-end/product/images/back.png" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="/TGA104_G4/UpdateProductServlet" name="form1">
<table>

    <tr>
		<td>商品編號:<font color=red><b>*</b></font></td>
		<td><%=productVO.getProductNo()%></td>
	</tr>

	<tr>
		<td>商品類別編號:</td>
		<td><input type="TEXT" name="productTypeNo" size="45" value="<%=productVO.getProductTypeNo()%>" /></td>
	</tr>
	
	<tr>
		<td>商品名稱:</td>
		<td><input type="TEXT" name="productName" size="45" value="<%=productVO.getProductName()%>" /></td>
	</tr>
	
	<tr>
		<td>商品庫存量:</td>
		<td><input type="TEXT" name="stock" size="45" value="<%=productVO.getStock()%>" /></td>
	</tr>
	<tr>
		<td>商品單價:</td>
		<td><input type="TEXT" name="price" size="45" value="<%=productVO.getPrice()%>" /></td>
	</tr>
	<tr>
		<td>商品描述:</td>
		<td><input type="TEXT" name="productDescription" size="45" value="<%=productVO.getProductDescription()%>" /></td>
	</tr>
	<tr>
		<td>商品狀態:</td>
		<td><input type="TEXT" name="productStatus" size="45" value="<%=productVO.getProductStatus()%>" /></td>
	</tr>
	<tr>
		<td>管理員編號:</td>
		<td><input type="TEXT" name="adminNo" size="45" value="<%=productVO.getAdminNo()%>" /></td>
	</tr>



</table>
<br>
<input type="hidden" name="action" value="updateProduct">
<input type="hidden" name="productNo" value="<%=productVO.getProductNo()%>">
<input type="submit" value="送出修改"></FORM>
</body>


</html>
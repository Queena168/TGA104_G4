<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.producttype.model.*"%>

<%
  ProductTypeVO productTypeVO = (ProductTypeVO) request.getAttribute("productTypeVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>商品類別資料修改 - updateProductType.jsp</title>

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

<h3>商品類別資料修改 - updateProductType.jsp</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="/TGA104_G4/UpdateProductTypeServlet" name="form1">
<table>

    <tr>
		<td>商品類別編號:<font color=red><b>*</b></font></td>
		<td><%=productTypeVO.getProductTypeNo()%></td>
	</tr>
	
	<tr>
		<td>商品類別名稱:</td>
		<td><input type="TEXT" name="productTypeName" size="45" value="<%=productTypeVO.getProductTypeName()%>" /></td>
	</tr>



</table>
<br>
<input type="hidden" name="action" value="updateProductType">
<input type="hidden" name="productTypeNo" value="<%=productTypeVO.getProductTypeNo()%>">
<input type="submit" value="送出修改">
</FORM>
<a href="http://localhost:8080/TGA104_G4/back-end/producttype/listAllProductType.jsp">上一頁</a>
</body>
</html>
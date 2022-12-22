<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.productpic.model.*"%>

<%
ProductPicVO productPicVO = (ProductPicVO) request.getAttribute("productPicVO");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Big5">
<title>商品圖片新增 - addPic.jsp</title>

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
<h3>商品圖片資料新增 - addPic.jsp</h3> 
	
	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>
	
	<form METHOD="post" ACTION="/TGA104_G4/PicServlet" enctype="multipart/form-data">
        <table>
            <tr>
		    	<td>商品編號:</td>
				<td><input type="TEXT" name="productNo"
					value="<%=(productPicVO == null) ? "0" : productPicVO.getProductNo()%>" /></td>
			</tr>
			<tr>
	    		<td>上傳圖片:</td>
				<td>
				<input type="file" name="photo" value="<%=(productPicVO == null) ? "" : productPicVO.getPic()%>" />
				</td>
			</tr>
		</table>
		<input type="hidden" name="action" value="addPic"><br>
		<input type="submit" value="送出新增">
	</form>
	<a href="http://localhost:8080/TGA104_G4/back-end/productpic/listAllPic.jsp">回首頁</a>
</body>
</html>
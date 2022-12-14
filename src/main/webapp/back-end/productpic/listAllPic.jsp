<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.productpic.model.*"%>
<%@ page import="com.product.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
  ProductPicVO productPicVO = (ProductPicVO) request.getAttribute("productPicVO"); //EmpServlet.java (Concroller) 存入req的empVO物件 (包括幫忙取出的empVO, 也包括輸入資料錯誤時的empVO物件)
%>

<%
    ProductPicService productPicService = new ProductPicService();
    List<ProductPicVO> list1 = productPicService.getAll();
    pageContext.setAttribute("list1",list1);
%>


<html>
<head>
<title>所有商品圖片資料 - listAllProduct.jsp</title>

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

<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>


<h3>所有商品圖片 - listAllPic.jsp</h3>


<jsp:useBean id="productPicSrc" scope="page" class="com.productpic.model.ProductPicService" />
<a href='http://localhost:8080/TGA104_G4/back-end/productpic/addPic.jsp'>新增圖片</a>

<table>
	<tr>
		<th>商品圖片編號</th>
		<th>商品編號</th>
		<th>商品圖片</th>
		<th>修改</th>
	</tr>

	<c:forEach var="productPicVO" items="${list1}">
			<td>${productPicVO.productPicNo}</td>
			<td>${productPicVO.productNo}</td>
			<td>
			<img src="<%=request.getContextPath()%>/PicAllReadServlet?productPicNo=${productPicVO.productPicNo}"
     			 alt="image" style="width: 100px; height: 100px;">
     		</td>
     		<td>
			  <FORM METHOD="post" ACTION="http://localhost:8080/TGA104_G4/PicServlet" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="productPicNo"  value="${productPicVO.productPicNo}">
			     <input type="hidden" name="action"	value="getProductPic_For_Update">
			  </FORM>
			</td>
            <tr></tr>
	</c:forEach>

</table>
<a href="http://localhost:8080/TGA104_G4/back-end/product/product.jsp">回首頁</a>
</body>
</html>
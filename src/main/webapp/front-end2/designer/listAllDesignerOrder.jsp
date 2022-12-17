<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*" %>




<%-- 此頁練習採用 EL 的寫法取值 --%>



<html>
<head>
<title>所有案件資料</title>

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
	width: 1100px;
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


<table id="table-1">
	<tr><td>
		 <h3>所有案件資料</h3>
		 <h4><a href="index.jsp">回首頁面</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>案件編號</th>
		<th>負責設計師</th>
		<th>客戶</th>
		<th>預算</th>
		<th>環境坪數</th>
		<th>諮詢內容</th>
		<th>報價金額</th>
		<th>報價起始時間</th>
		<th>報價同意時間</th>
		<th>合約狀態</th>
		<th>是否結案</th>
		<th>修改</th>
	</tr>

	<c:forEach var="designerVO" items="${list}" >	
		
		<tr>
			<td>${designerOrderVO.designerOrderNo}</td>
			<td>${designerOrderVO.designerAccount}</td>
			<td>${designerOrderVO.designerPassword}</td>
			<td>${designerOrderVO.designerName}</td>
			<td>${designerOrderVO.designerCompany}</td>
			<!--  <td><img src="<%/*=request.getContextPath()*/%>/DesignerShowPic?designerNo=${designerVO.designerNo}"></td>-->
			 <!--	<td>${designerVO.approvalStatus}</td>-->
			 <!--	<td>${designerVO.approvalTime}</td>-->
			 <!--	<td>${designerVO.approver}</td>-->
			 <!--	<td>${designerVO.designerStatus}</td> -->
			
		
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/front-end/designer/designer.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="designerNo"  value="${designerVO.designerNo}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			
			
			
	    <!--  	<td>   -->
		<!--	  <FORM METHOD="post" ACTION="<%/*=request.getContextPath()*/%>/front-end/designer/designer.do" style="margin-bottom: 0px;">-->
		<!--	     <input type="submit" value="刪除">-->
		<!--	     <input type="hidden" name="designerNo"  value="${designerVO.designerNo}">-->
		<!--	     <input type="hidden" name="action" value="delete"></FORM>-->
		<!--	</td>-->
			
		
		</tr>
		</c:forEach>
</table>


</body>
</html>
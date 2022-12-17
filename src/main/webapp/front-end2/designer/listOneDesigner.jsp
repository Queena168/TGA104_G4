<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ page import="com.designer.model.*"  %>


<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  DesignerVO designerVO = (DesignerVO) request.getAttribute("designerVO"); //DesignerServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>設計師資料 - listOneDesigner.jsp</title>

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
		 <h3>設計師資料 - ListOneDesigner.jsp</h3>
		 <h4><a href="select_designer_page.jsp">回設計師查詢頁面</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>設計師編號</th>
		<th>設計師帳號</th>
		<th>設計師密碼</th>
		<th>設計師姓名</th>
		<th>公司</th>
		<th>設計師照片</th>
	    <th>審核狀態</th>
		<th>審核成功時間</th>
		<th>審核人</th>
		<th>設計師狀態</th>
	</tr>
	<tr>
		    <td>${designerVO.designerNo}</td>
			<td>${designerVO.designerAccount}</td>
			<td>${designerVO.designerPassword}</td>
			<td>${designerVO.designerName}</td>
			<td>${designerVO.designerCompany}</td>
			<td><img src="<%=request.getContextPath()%>/DesignerShowPic?designerNo=${designerVO.designerNo}"></td>
			<td>${designerVO.approvalStatus}</td>
			<td>${designerVO.approvalTime}</td>
			<td>${designerVO.approver}</td>
			<td>${designerVO.designerStatus}</td> 
			
		
	</tr>
</table>

</body>
</html>
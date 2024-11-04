<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.counter.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    CounterService couSvc = new CounterService();
    List<CounterVO> list = couSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有櫃位資料 - listAllCounter.jsp</title>

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

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有櫃位資料 - listAllCounter.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="<%= request.getContextPath() %>/back-end/images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>櫃位編號</th>
		<th>帳號</th>
		<th>管理者姓名</th>
		<th>密碼</th>
		<th>地址</th>
		<th>電話</th>
		<th>管理者生分證</th>
		<th>信箱</th>
		<th>統一編號</th>
		<th>櫃位名稱</th>
		<th>櫃位類型</th>
		<th>櫃位資訊</th>
		<th>圖標</th>
		<th>營運狀態</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="counterVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${counterVO.counterNo}</td>
			<td>${counterVO.counterAccount}</td>
			<td>${counterVO.counterName}</td>
			<td>${counterVO.counterPassword}</td>
			<td>${counterVO.counterAddress}</td>
			<td>${counterVO.counterPhone}</td>
			<td>${counterVO.counterUid}</td> 
			<td>${counterVO.counterEmail}</td>
			<td>${counterVO.counterUbn}</td>
			<td>${counterVO.counterCName}</td>
			<td>${counterVO.counterTypeNo}</td>
			<td>${counterVO.counterInform}</td>
			<td><img src="<%= request.getContextPath() %>/CounterImageReader?No=${counterVO.counterNo}"></td>
			<td>${counterVO.counterStatus}</td>
			
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/back-end/counter/counter.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="counterNo"  value="${counterVO.counterNo}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
<!-- 			<td> -->
<%-- 			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do" style="margin-bottom: 0px;"> --%>
<!-- 			     <input type="submit" value="刪除"> -->
<%-- 			     <input type="hidden" name="empno"  value="${empVO.empno}">  <!-- 跑FOR EACH 7001~70xx --> --%>
<!-- 			     <input type="hidden" name="action" value="delete"></FORM> -->
<!-- 			</td> -->
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.counter.model.*"%>

<%
//見com.emp.controller.EmpServlet.java第238行存入req的empVO物件 (此為輸入格式有錯誤時的empVO物件)
CounterVO counterVO = (CounterVO) request.getAttribute("counterVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>櫃位資料新增 - addCounter.jsp</title>

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
	padding: 10px;
}
</style>

</head>
<body bgcolor='white'>

	<table id="table-1">
		<tr>
			<td>
				<h3>櫃位資料新增 - addCounter.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>資料新增:</h3>

	<%-- 錯誤表列 --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">請修正以下錯誤:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="counter.do"  enctype="multipart/form-data" name="form1">
		<table>

			<tr>
				<td>櫃位帳號:</td>
				<td><input type="TEXT" name="counterAccount"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterAccount()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>管理者姓名:</td>
				<td><input type="TEXT" name="counterName"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterName()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>密碼:</td>
				<td><input type="PASSWORD" name="counterPassword"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterPassword()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>地址:</td>
				<td><input type="TEXT" name="counterAddress"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterAddress()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>電話:</td>
				<td><input type="TEXT" name="counterPhone"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterPhone()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>管理者身分證字號:</td>
				<td><input type="TEXT" name="counterUid"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterUid()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>電子信箱:</td>
				<td><input type="TEXT" name="counterEmail"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterEmail()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>統一編號:</td>
				<td><input type="TEXT" name="counterUbn"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterUbn()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>櫃位名稱:</td>
				<td><input type="TEXT" name="counterCName"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterCName()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>櫃位類別:</td>
				<td><select size="1" name="counterTypeNo">
				<option value="1" >精品
			
				<option value="2" >藥妝
			
				<option value="3" >家電
			
				<option value="4" >服飾
				
				<option value="5" >運動
			
				<option value="6" >娛樂
			
				<option value="7" >超市
			
				</select></td>
			</tr>
		<tr>
				<td>櫃位資訊:</td>
				<td><input type="TEXT" name="counterInform"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterInform()%>"
					size="45" /></td>
			</tr>
			<tr>	
				<td>櫃位圖片:</td>
        		<td><input type="file"  name="counterPic" accept="image/*"  /></td>
			</tr>
		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="送出新增"> 
		
	</FORM>
	
</body> 

</html>




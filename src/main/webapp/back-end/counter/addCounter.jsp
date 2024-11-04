<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.counter.model.*"%>

<%
//��com.emp.controller.EmpServlet.java��238��s�Jreq��empVO���� (������J�榡�����~�ɪ�empVO����)
CounterVO counterVO = (CounterVO) request.getAttribute("counterVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>�d���Ʒs�W - addCounter.jsp</title>

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
				<h3>�d���Ʒs�W - addCounter.jsp</h3>
			</td>
			<td>
				<h4>
					<a href="select_page.jsp">�^����</a>
				</h4>
			</td>
		</tr>
	</table>

	<h3>��Ʒs�W:</h3>

	<%-- ���~��C --%>
	<c:if test="${not empty errorMsgs}">
		<font style="color: red">�Эץ��H�U���~:</font>
		<ul>
			<c:forEach var="message" items="${errorMsgs}">
				<li style="color: red">${message}</li>
			</c:forEach>
		</ul>
	</c:if>

	<FORM METHOD="post" ACTION="counter.do"  enctype="multipart/form-data" name="form1">
		<table>

			<tr>
				<td>�d��b��:</td>
				<td><input type="TEXT" name="counterAccount"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterAccount()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�޲z�̩m�W:</td>
				<td><input type="TEXT" name="counterName"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterName()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�K�X:</td>
				<td><input type="PASSWORD" name="counterPassword"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterPassword()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�a�}:</td>
				<td><input type="TEXT" name="counterAddress"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterAddress()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�q��:</td>
				<td><input type="TEXT" name="counterPhone"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterPhone()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�޲z�̨����Ҧr��:</td>
				<td><input type="TEXT" name="counterUid"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterUid()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�q�l�H�c:</td>
				<td><input type="TEXT" name="counterEmail"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterEmail()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�Τ@�s��:</td>
				<td><input type="TEXT" name="counterUbn"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterUbn()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�d��W��:</td>
				<td><input type="TEXT" name="counterCName"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterCName()%>"
					size="45" /></td>
			</tr>
			<tr>
				<td>�d�����O:</td>
				<td><select size="1" name="counterTypeNo">
				<option value="1" >��~
			
				<option value="2" >�ħ�
			
				<option value="3" >�a�q
			
				<option value="4" >�A��
				
				<option value="5" >�B��
			
				<option value="6" >�T��
			
				<option value="7" >�W��
			
				</select></td>
			</tr>
		<tr>
				<td>�d���T:</td>
				<td><input type="TEXT" name="counterInform"
					value="<%=(counterVO == null) ? "" : counterVO.getCounterInform()%>"
					size="45" /></td>
			</tr>
			<tr>	
				<td>�d��Ϥ�:</td>
        		<td><input type="file"  name="counterPic" accept="image/*"  /></td>
			</tr>
		</table>
		<br> <input type="hidden" name="action" value="insert"> <input
			type="submit" value="�e�X�s�W"> 
		
	</FORM>
	
</body> 

</html>




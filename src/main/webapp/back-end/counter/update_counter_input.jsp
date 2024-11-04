<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.counter.model.*"%>

<% //��com.emp.controller.EmpServlet.java��163��s�Jreq��empVO���� (�����q��Ʈw���X��empVO, �]�i�H�O��J�榡�����~�ɪ�empVO����)
   CounterVO counterVO = (CounterVO) request.getAttribute("counterVO");
%>
<%-- --<%= empVO==null %>--  ${empVO.deptno}-- <!-- 100line -->   --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>���u��ƭק� - update_emp_input.jsp</title>

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
		 <h3>���u��ƭק� - update_emp_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="<%= request.getContextPath() %>/back-end/images/back1.gif"" width="100" height="32" border="0">�^����</a></h4>
	</td></tr>
</table>

<h3>��ƭק�:</h3>

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">�Эץ��H�U���~:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="counter.do"  enctype="multipart/form-data" name="form1">
<table>
	<tr>
		<td>�d��s��:<font color=red><b>*</b></font></td>
		<td><%=counterVO. getCounterNo()%></td>
	</tr>
	        <tr>
            <td>�b��:</td>
            <td><input type="text" name="counterAccount" value="<%= counterVO.getCounterAccount() %>" size="45" /></td>
        </tr>
        <tr>
            <td>�޲z�̩m�W:</td>
            <td><input type="text" name="counterName" value="<%= counterVO.getCounterName() %>" size="45" /></td>
        </tr>
        <tr>
            <td>�K�X:</td>
            <td><input type="password" name="counterPassword" value="<%= counterVO.getCounterPassword() %>" size="45" /></td>
        </tr>
        <tr>
            <td>�a�}:</td>
            <td><input type="text" name="counterAddress" value="<%= counterVO.getCounterAddress() %>" size="45" /></td>
        </tr>
        <tr>
            <td>�q��:</td>
            <td><input type="text" name="counterPhone" value="<%= counterVO.getCounterPhone() %>" size="45" /></td>
        </tr>
        <tr>
            <td>�޲z�̨�����:</td>
            <td><input type="text" name="counterUid" value="<%= counterVO.getCounterUid() %>" size="45" /></td>
        </tr>
        <tr>
            <td>�H�c:</td>
            <td><input type="email" name="counterEmail" value="<%= counterVO.getCounterEmail() %>" size="45" /></td>
        </tr>
        <tr>
            <td>�Τ@�s��:</td>
            <td><input type="text" name="counterUbn" value="<%= counterVO.getCounterUbn() %>" size="45" /></td>
        </tr>
        <tr>
            <td>�d��W��:</td>
            <td><input type="text" name="counterCName" value="<%= counterVO.getCounterCName() %>" size="45" /></td>
        </tr>
        <tr>
            <td>�d������:</td>
            <td><select size="1" name="counterTypeNo">
			    <option value="1" <%= counterVO != null && counterVO.getCounterTypeNo() == 1 ? "selected" : "" %>>��~</option>
			    <option value="2" <%= counterVO != null && counterVO.getCounterTypeNo() == 2 ? "selected" : "" %>>�ħ�</option>
			    <option value="3" <%= counterVO != null && counterVO.getCounterTypeNo() == 3 ? "selected" : "" %>>�a�q</option>
			    <option value="4" <%= counterVO != null && counterVO.getCounterTypeNo() == 4 ? "selected" : "" %>>�A��</option>
			    <option value="5" <%= counterVO != null && counterVO.getCounterTypeNo() == 5 ? "selected" : "" %>>�B��</option>
			    <option value="6" <%= counterVO != null && counterVO.getCounterTypeNo() == 6 ? "selected" : "" %>>�T��</option>
			    <option value="7" <%= counterVO != null && counterVO.getCounterTypeNo() == 7 ? "selected" : "" %>>�W��</option>
				</select>
			</td>
        </tr>
        <tr>
            <td>�d���T:</td>
            <td><input type="text" name="counterInform" value="<%= counterVO.getCounterInform() %>" size="100" /></td>
        </tr>
        <tr>
            <td>�ϼ�:</td>
            <td><img src="<%= request.getContextPath() %>/CounterImageReader?No=${counterVO.counterNo}"></td>
            <td><input type="file" name="counterPic" accept="image/*" /></td>
        </tr>
        <tr>
            <td>��B���A:</td>
            <td>
                <select name="counterStatus">
                    <option value="0" <%= counterVO.getCounterStatus() == 0 ? "selected" : "" %>>���`</option>
                    <option value="1" <%= counterVO.getCounterStatus() == 1 ? "selected" : "" %>>�Ȯɰ��vOR�f��</option>
                    <option value="2" <%= counterVO.getCounterStatus() == 2 ? "selected" : "" %>>���v</option>
                </select>
            </td>
        </tr>
	

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="counterNo" value="<%=counterVO. getCounterNo()%>">  <!-- �ݭn�L�~��e�^�쥻����m -->
<input type="submit" value="�e�X�ק�"></FORM>
</body>



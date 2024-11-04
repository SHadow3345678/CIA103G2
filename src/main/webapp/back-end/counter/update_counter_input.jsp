<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.counter.model.*"%>

<% //見com.emp.controller.EmpServlet.java第163行存入req的empVO物件 (此為從資料庫取出的empVO, 也可以是輸入格式有錯誤時的empVO物件)
   CounterVO counterVO = (CounterVO) request.getAttribute("counterVO");
%>
<%-- --<%= empVO==null %>--  ${empVO.deptno}-- <!-- 100line -->   --%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料修改 - update_emp_input.jsp</title>

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
		 <h3>員工資料修改 - update_emp_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="<%= request.getContextPath() %>/back-end/images/back1.gif"" width="100" height="32" border="0">回首頁</a></h4>
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

<FORM METHOD="post" ACTION="counter.do"  enctype="multipart/form-data" name="form1">
<table>
	<tr>
		<td>櫃位編號:<font color=red><b>*</b></font></td>
		<td><%=counterVO. getCounterNo()%></td>
	</tr>
	        <tr>
            <td>帳號:</td>
            <td><input type="text" name="counterAccount" value="<%= counterVO.getCounterAccount() %>" size="45" /></td>
        </tr>
        <tr>
            <td>管理者姓名:</td>
            <td><input type="text" name="counterName" value="<%= counterVO.getCounterName() %>" size="45" /></td>
        </tr>
        <tr>
            <td>密碼:</td>
            <td><input type="password" name="counterPassword" value="<%= counterVO.getCounterPassword() %>" size="45" /></td>
        </tr>
        <tr>
            <td>地址:</td>
            <td><input type="text" name="counterAddress" value="<%= counterVO.getCounterAddress() %>" size="45" /></td>
        </tr>
        <tr>
            <td>電話:</td>
            <td><input type="text" name="counterPhone" value="<%= counterVO.getCounterPhone() %>" size="45" /></td>
        </tr>
        <tr>
            <td>管理者身分證:</td>
            <td><input type="text" name="counterUid" value="<%= counterVO.getCounterUid() %>" size="45" /></td>
        </tr>
        <tr>
            <td>信箱:</td>
            <td><input type="email" name="counterEmail" value="<%= counterVO.getCounterEmail() %>" size="45" /></td>
        </tr>
        <tr>
            <td>統一編號:</td>
            <td><input type="text" name="counterUbn" value="<%= counterVO.getCounterUbn() %>" size="45" /></td>
        </tr>
        <tr>
            <td>櫃位名稱:</td>
            <td><input type="text" name="counterCName" value="<%= counterVO.getCounterCName() %>" size="45" /></td>
        </tr>
        <tr>
            <td>櫃位類型:</td>
            <td><select size="1" name="counterTypeNo">
			    <option value="1" <%= counterVO != null && counterVO.getCounterTypeNo() == 1 ? "selected" : "" %>>精品</option>
			    <option value="2" <%= counterVO != null && counterVO.getCounterTypeNo() == 2 ? "selected" : "" %>>藥妝</option>
			    <option value="3" <%= counterVO != null && counterVO.getCounterTypeNo() == 3 ? "selected" : "" %>>家電</option>
			    <option value="4" <%= counterVO != null && counterVO.getCounterTypeNo() == 4 ? "selected" : "" %>>服飾</option>
			    <option value="5" <%= counterVO != null && counterVO.getCounterTypeNo() == 5 ? "selected" : "" %>>運動</option>
			    <option value="6" <%= counterVO != null && counterVO.getCounterTypeNo() == 6 ? "selected" : "" %>>娛樂</option>
			    <option value="7" <%= counterVO != null && counterVO.getCounterTypeNo() == 7 ? "selected" : "" %>>超市</option>
				</select>
			</td>
        </tr>
        <tr>
            <td>櫃位資訊:</td>
            <td><input type="text" name="counterInform" value="<%= counterVO.getCounterInform() %>" size="100" /></td>
        </tr>
        <tr>
            <td>圖標:</td>
            <td><img src="<%= request.getContextPath() %>/CounterImageReader?No=${counterVO.counterNo}"></td>
            <td><input type="file" name="counterPic" accept="image/*" /></td>
        </tr>
        <tr>
            <td>營運狀態:</td>
            <td>
                <select name="counterStatus">
                    <option value="0" <%= counterVO.getCounterStatus() == 0 ? "selected" : "" %>>正常</option>
                    <option value="1" <%= counterVO.getCounterStatus() == 1 ? "selected" : "" %>>暫時停權OR審核</option>
                    <option value="2" <%= counterVO.getCounterStatus() == 2 ? "selected" : "" %>>停權</option>
                </select>
            </td>
        </tr>
	

</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="counterNo" value="<%=counterVO. getCounterNo()%>">  <!-- 需要他才能送回原本的位置 -->
<input type="submit" value="送出修改"></FORM>
</body>



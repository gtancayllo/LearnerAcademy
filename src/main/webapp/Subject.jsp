<%@page import="com.learnerAcademy.dao.SubjectDAO"%>
<%@page import="com.learnerAcademy.domain.Subject"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%
 SubjectDAO subjectDAO = new SubjectDAO();
 List<Subject> subjectList = subjectDAO.list();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Learner Academy Management System</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome-free-5.3.1-web/css/all.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mon-style.css">	
</head>
<body>
	<h1 class="sr-only">Learner Academy</h1>
	<jsp:include page="Header.jsp"></jsp:include>
	<br>
	<br>
	<TABLE style="margin-left: auto;margin-right: auto;width: 50%">
	<tr>
		<th align="center" style="background-color:#2589a9;color:white">Id</th>
		<th align="center" style="background-color:#2589a9;color:white">Name</th>
	</tr>
	<%
		for(Subject subject : subjectList){
	%>	
		<tr>
  		<td><%=subject.getId()%></td>
    	<td align="center"><%=subject.getName()%></td>
    </tr>
	<%
		}
	%>
	</TABLE>
	<br>
	<br>
	<form action="<%= request.getContextPath() %>/subject/insert" method="post">
	<table id="classroom_form"  width="50%"  border="1" callspacing="0" cellpadding="2" style="margin-left: auto;margin-right: auto">
		<tr>
			<th align="center" colspan="2" style="background-color:#2589a9;color:white">Subject Registration</th>
		</tr>
		<tr>
		<td>Name:</td>
		<td><input type="text" name="name" style="width: 100%;"/></td>
		</tr>
    </table>
    <br/>
	<div style="text-align: center">
		<input type="submit" value="Register">
	</div>
	</form>    	
</body>
</html>
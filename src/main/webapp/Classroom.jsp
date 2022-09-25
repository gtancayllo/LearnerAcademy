<%@page import="com.learnerAcademy.dao.ClassroomDAO"%>
<%@page import="com.learnerAcademy.domain.Classroom"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%
 ClassroomDAO classroomDAO = new ClassroomDAO();
 List<Classroom> classroomList = classroomDAO.list();
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
		for(Classroom classroom : classroomList){
	%>	
		<tr>
  		<td><%=classroom.getId()%></td>
    	<td align="center"><%=classroom.getName()%></td>
    </tr>
	<%
		}
	%>
	</TABLE>
	<br>
	<br>
	<form action="<%= request.getContextPath() %>/classroom/insert" method="post">
	<table id="classroom_form"  width="50%"  border="1" callspacing="0" cellpadding="2" style="margin-left: auto;margin-right: auto">
		<tr>
			<th align="center" colspan="2" style="background-color:#2589a9;color:white">Classroom Registration</th>
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
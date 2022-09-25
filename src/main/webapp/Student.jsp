<%@page import="com.learnerAcademy.dao.StudentDAO"%>
<%@page import="com.learnerAcademy.domain.Student"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%
 StudentDAO studentDAO = new StudentDAO();
 List<Student> studentList = studentDAO.list();
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
	<div style="overflow-y: scroll;height: 180px">
	<TABLE style="margin-left: auto;margin-right: auto;width: 75%">
	<tr>
		<th align="center" style="background-color:#2589a9;color:white;">Id</th>
		<th align="center" style="background-color:#2589a9;color:white;">Name</th>
		<th align="center" style="background-color:#2589a9;color:white;">Email</th>
		<th align="center" style="background-color:#2589a9;color:white;">Phone</th>
	</tr>
	<%
		for(Student student : studentList){
	%>	
		<tr>
  		<td ><%=student.getId()%></td>
    	<td><%=student.getLastName()%>, <%=student.getFirtName()%></td>
    	<td><%=student.getEmail()%></td>
    	<td><%=student.getPhone()%></td>
    </tr>
	<%
		}
	%>
	</TABLE>
	</div>
	<br>
	<br>
	<form action="<%= request.getContextPath() %>/student/insert" method="post">
	<table id="student_form"  width="50%"  border="1" callspacing="0" cellpadding="2" style="margin-left: auto;margin-right: auto">
		<tr>
			<th align="center" colspan="2" style="background-color:#2589a9;color:white">Student Registration</th>
		</tr>
		<tr>
		
		<td>First Name:</td>
		<td><input type="text" name="firstName" style="width: 100%;"/></td>
		
		</tr>
		<tr>		
		<td>Last Name: </td>
		<td><input type="text" name="lastName" style="width: 100%;"/></td>		
		</tr>
		
		<tr>		
		<td>Email ID: </td>
		<td><input type="email" name="emailId" style="width: 100%;"/></td>		
		</tr>
    </table>
    <br/>
	<div style="text-align: center">
		<input type="submit" value="Register">
	</div>
	</form>    	
</body>
</html>
<%@page import="com.learnerAcademy.domain.Teacher"%>
<%@page import="com.learnerAcademy.dao.TeacherDAO"%>
<%@page import="com.learnerAcademy.domain.Subject"%>
<%@page import="com.learnerAcademy.dao.SubjectDAO"%>
<%@page import="com.learnerAcademy.domain.ClassroomSubject"%>
<%@page import="com.learnerAcademy.dao.ClassroomDAO"%>
<%@page import="com.learnerAcademy.domain.Classroom"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<%
 
 TeacherDAO teacherDAO = new TeacherDAO();
 SubjectDAO subjectDAO = new SubjectDAO();
 ClassroomDAO classroomDAO = new ClassroomDAO();
 List<Classroom> classroomList = classroomDAO.list();
 List<Subject> subjectList = subjectDAO.list();
 
 List<Teacher> teachers = teacherDAO.list();
 
 List<ClassroomSubject> classroomSubjects= null;
 int classroomId = -1;
 if(request.getParameter("classroomId")!=null)
 {
	 classroomId = Integer.parseInt(request.getParameter("classroomId"));
	 classroomSubjects =  classroomDAO.listClassroomSubjects(classroomId); 
 }
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Learner Academy Management System</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/fontawesome-free-5.3.1-web/css/all.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/mon-style.css">
	<script src="${pageContext.request.contextPath}/js/script.js"></script>	
</head>
<body>
	<h1 class="sr-only">Learner Academy</h1>
	<jsp:include page="Header.jsp"></jsp:include>
	
	<form action="<%= request.getContextPath() %>/classroom/assign" method="post">
	<div style="margin-left: auto;margin-right: auto;width: 50%">
	Classroom: 
	<select name="classroomId" onchange="selectTeacher(this)">
		<option value="0">-- Select one --</option>
		<% for(Classroom classroom : classroomList) { %>
			<option <%=classroom.getId()==classroomId?"selected":"" %> value="<%=classroom.getId()%>"><%=classroom.getName() %></option>
		<% } %>	
	</select>
	</div>
	
	<%
		if(classroomId>0)
		{
	%>
	<br>
	<div style="margin-left: auto;margin-right: auto;width: 50%">
	Subject/Teacher:
	</div>
	<input type="hidden" id="classroomId" name="classroomId" value="<%=classroomId%>" />
	<TABLE style="margin-left: auto;margin-right: auto;width: 50%">
	<tr>
		<th align="center" style="background-color:#2589a9;color:white">Subject</th>
		<th align="center" style="background-color:#2589a9;color:white">Teacher</th>
	</tr>
	<%
	for(ClassroomSubject classSubject : classroomSubjects){
	%>	
		<tr>
    	<td align="center"><%=classSubject.getSubject().getName()%></td>
    	<td align="center"><select name="teacherId">
		<option value="0">-- Select one --</option>
		<% for(Teacher teacher : teachers) { %>
			<option <%=classSubject.getTeacher()!=null && teacher.getId()==classSubject.getTeacher().getId()?"selected":"" %> value="<%=teacher.getId()%>"><%=teacher.getLastName()+", "+teacher.getFirtName() %></option>
		<% } %>	
	</select></td>
    </tr>
	<%
		}
	%>
	</TABLE>
	
	<div style="margin-left: auto;margin-right: auto;width: 50%">
	<input type="submit" value="Assign">
	</div>
	<%
		}
	%>
	</form>
</body>
</html>
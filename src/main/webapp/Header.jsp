<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String url = request.getRequestURL().toString();
%>
    <header id="entete">
		<div class="wrapper-navigation">
			<div id="logo" style="display: flex;align-items: baseline;">
			    <img src="${pageContext.request.contextPath}/image/owl.png" style="float:left">
				<h1 style="color:white; margin-bottom: 0" style="float:right">Learner's Academy</h1>												
			</div>
			<nav id="menu">
					<ul>
						<li class="<%=url.indexOf("Student.jsp")>0 ? "active":"" %>"><a href="${pageContext.request.contextPath}/Student.jsp">Register<span> Students</span></a></li>
						<li class="<%=url.indexOf("/Teacher.jsp")>0 ? "active":"" %>"><a href="${pageContext.request.contextPath}/Teacher.jsp"><span>Register</span>Teachers</a></li>
						<li class="<%=url.indexOf("Subject.jsp")>0 ? "active":"" %>"><a href="${pageContext.request.contextPath}/Subject.jsp"><span>Register</span>Subjects</a></li>
						<li class="<%=url.indexOf("/Classroom.jsp")>0 ? "active":"" %>"><a href="${pageContext.request.contextPath}/Classroom.jsp">Register<span>classes</span></a></li>
						<li class="<%=url.indexOf("AssignClassroom.jsp")>0 ? "active":"" %>"><a href="${pageContext.request.contextPath}/AssignClassroom.jsp"><span>Assign</span> Classes</a></li>
						<li class="<%=url.indexOf("AssignTeacher.jsp")>0 ? "active":"" %>"><a href="${pageContext.request.contextPath}/AssignTeacher.jsp"><span>Assign</span>Teachers</a></li>
					</ul>
			</nav>
		</div>
	</header>
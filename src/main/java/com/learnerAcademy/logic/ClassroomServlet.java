package com.learnerAcademy.logic;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.learnerAcademy.dao.ClassroomDAO;
import com.learnerAcademy.dao.SubjectDAO;
import com.learnerAcademy.domain.Classroom;
import com.learnerAcademy.domain.ClassroomSubject;
import com.learnerAcademy.domain.Subject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
public class ClassroomServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ClassroomDAO classroomDAO = null;
	private SubjectDAO subjectDAO = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassroomServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	classroomDAO = new ClassroomDAO();
    	subjectDAO = new SubjectDAO();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void saveData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("************************START-saveData()**************************************");
		
		String name = (String)request.getParameter("name");
		System.out.println("Name "+name);
		
		Classroom classroom = new Classroom(name);
		classroomDAO.saveClassroom(classroom);
		
		RequestDispatcher rd = request.getRequestDispatcher("../Classroom.jsp");
		rd.forward(request, response);
			
		System.out.println("************************END-saveData()**************************************");
	}
	
	public void assign(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] subjects = request.getParameterValues("subjects");
		Integer classroomId = Integer.parseInt(request.getParameter("classroomId"));
		
		List<Integer> subjectIds = new ArrayList<>();
		
		for(String subjectId : subjects)
			subjectIds.add(Integer.parseInt(subjectId));
		
		classroomDAO.assignSubjects(classroomId, subjectIds);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("************************START-doPost()**************************************");
		
		String path=request.getServletPath();
		path = path.substring(path.lastIndexOf("/"));
		System.out.println("Path "+path); 
	
		switch(path) {
			case "/insert":
					saveData(request,response);
				break;
			case "/assign":
					assign(request, response);
					break;
			}
		System.out.println("************************END-doPost()**************************************");
	}
}
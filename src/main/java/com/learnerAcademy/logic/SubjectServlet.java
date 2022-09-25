package com.learnerAcademy.logic;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.learnerAcademy.dao.SubjectDAO;
import com.learnerAcademy.domain.Subject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private SubjectDAO subjectDAO = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
        super();
    }

    @Override
    public void init() throws ServletException {
    	super.init();
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
		
		Subject subject = new Subject(name);
		subjectDAO.saveSubject(subject);
		
		RequestDispatcher rd = request.getRequestDispatcher("../Subject.jsp");
		rd.forward(request, response);
			
		System.out.println("************************END-saveData()**************************************");
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
			}
		System.out.println("************************END-doPost()**************************************");
	}
}
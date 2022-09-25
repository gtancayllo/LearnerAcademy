package com.learnerAcademy.logic;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;
import com.learnerAcademy.dao.StudentDAO;
import com.learnerAcademy.domain.Student;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private StudentDAO studentDAO = null;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	studentDAO = new StudentDAO();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	public void saveData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("************************START-saveData()**************************************");
		
		String firstname = (String)request.getParameter("firstName");
		String lastName  = (String)request.getParameter("lastName");
		String emailId = (String)request.getParameter("emailId");
		
		System.out.println("First Name "+firstname);
		System.out.println("Last Name "+lastName);
		System.out.println("Email "+emailId);
		
		Student student = new Student(firstname, lastName, emailId, "");
		studentDAO.saveStudent(student);
		
		RequestDispatcher rd = request.getRequestDispatcher("../Student.jsp");
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

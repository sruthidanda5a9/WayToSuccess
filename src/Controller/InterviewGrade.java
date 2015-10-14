package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.StuInformationDTO;
import DataLayer.CourseStudentDataLayer;
import Model.CourseStudentModel;
import Model.StudentModel;
import Repository.CourseStudentInterface;

/**
 * Servlet implementation class InterviewGrade
 */
@WebServlet("/InterviewGrade")
public class InterviewGrade extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public InterviewGrade() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("hello");
		StudentModel studentModel = new StudentModel();
		StuInformationDTO stuInformationDTO = (StuInformationDTO) request.getSession().getAttribute("stuInformationDTO");
		CourseStudentModel courseStudentModel =  new CourseStudentModel();
		String studentId=null,choice = null,interviewgradeOne = null,interviewgradeTwo = null;
		choice = request.getParameter("choice");
		studentId = request.getParameter("studentId");
		interviewgradeOne = request.getParameter("interviewgradeOne");
		interviewgradeTwo = request.getParameter("interviewgradeTwo");
		studentModel.setStudentID(Integer.parseInt(studentId));
		courseStudentModel.setStudentID(Integer.parseInt(studentId));
		courseStudentModel.setChoice(Integer.parseInt(choice));
		if( interviewgradeOne != null)
		{
		courseStudentModel.setInterviewGrade(Integer.parseInt(interviewgradeOne));
		}
		else
		{
			courseStudentModel.setInterviewGrade(Integer.parseInt(interviewgradeTwo));
		}
		CourseStudentInterface details = new CourseStudentDataLayer();
		 
		/*
		 * Inserting the gardes of each Student for cerresponding course choice.
		 */
		details.insertInterviewGrade(courseStudentModel);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

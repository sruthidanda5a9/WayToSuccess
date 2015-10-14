package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.RankCalculation;
import Business.WaitStatusEligibility;
import DTO.StuInformationDTO;
import DataLayer.CourseStudentDataLayer;
import DataLayer.ProgramDataLayer;
import DataLayer.StudentDataLayer;
import Model.CourseStudentModel;
import Model.ProgramModel;
import Model.StudentModel;
import Repository.CourseStudentInterface;
import Repository.ProgramInterface;
import Repository.StudentInterface;

/**
 * Servlet implementation class WaitList
 */
@WebServlet("/WaitList")
public class WaitList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WaitList() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		WaitStatusEligibility waitEligible = new WaitStatusEligibility();
		StudentModel studentModel = new StudentModel();
		StuInformationDTO stuInformationDTO = (StuInformationDTO) request.getSession().getAttribute("stuInformationDTO");
		CourseStudentModel courseStudentModel =  new CourseStudentModel();
		String studentId=null,choice = null,programId = null;
		choice = request.getParameter("choice");
		programId = request.getParameter("programId");
		studentId = request.getParameter("studentId");
		studentModel.setStudentID(Integer.parseInt(studentId));
		courseStudentModel.setStudentID(Integer.parseInt(studentId));
		courseStudentModel.setChoice(Integer.parseInt(choice));
		CourseStudentInterface details = new CourseStudentDataLayer();
		courseStudentModel.progarmModel.setProgramID(Integer.parseInt(programId));
		/*
		 * Checking the eligiblity of stduents to place them in waitlist
		 */
		
		Boolean eligible = waitEligible.eligibility(studentModel);
		
		if( eligible == true)
			
		{
			
		/*
		 * updating the status to waitlisted for the course
		 */
		
		HttpSession session = request.getSession(true); 
		
		
		
		/*
		 *Waitlisted ID = 3 , updating the Status of the Student
		 */
		
		courseStudentModel.statusModel.setStatusID(3);
		
		details.updateStatus(courseStudentModel);
		session.setAttribute("courseStudentModel", courseStudentModel);
		
		/*
		 * calucating the ranks to the students who are waitlisted.
		 */
		
		RankCalculation rank = new RankCalculation();
		rank.findRank(courseStudentModel);
		
		/*
		 * Getting the current student details after rank calculation
		 */
		
		courseStudentModel = details.getRankOfStudent(courseStudentModel);
		

		//courseStudentModel.progarmModel.getProgramName()
		response.setContentType("text/html; charset=UTF-8");
		stuInformationDTO.setFirstProgramName(courseStudentModel.progarmModel.getProgramName());
		stuInformationDTO.setFirstProgramStatus(courseStudentModel.statusModel.getStatusName());
		stuInformationDTO.setFirstProgramRank(courseStudentModel.getRank());
		PrintWriter out = response.getWriter();
		if(courseStudentModel.getChoice() == 1)
		{
			out.println("<b>Program Choice One</b><br>");
		}
		else
		{
			out.println("<b>Program Choice Two</b><br>");
		}
		out.println("Name : "+courseStudentModel.progarmModel.getProgramName() +"<br>");
		out.println("Status :"+courseStudentModel.statusModel.getStatusName()+"<br>");
		out.println("Rank : "+courseStudentModel.getRank()+"<br>");
		}
		else
		{
			courseStudentModel = details.getRankOfStudent(courseStudentModel);
			response.setContentType("text/html; charset=UTF-8");
			stuInformationDTO.setFirstProgramName(courseStudentModel.progarmModel.getProgramName());
			stuInformationDTO.setFirstProgramStatus(courseStudentModel.statusModel.getStatusName());
			stuInformationDTO.setFirstProgramRank(courseStudentModel.getRank());
			PrintWriter out = response.getWriter();
			if(courseStudentModel.getChoice() == 1)
			{
				out.println("<b>Program Choice One</b><br>");
				out.println("Student can't be placed in waitlist.<br>");
			}
			else
			{
				out.println("<b>Program Choice Two</b><br>");
				out.println("Student can't be placed in waitlist.<br>");
			}
			out.println("Name : "+courseStudentModel.progarmModel.getProgramName() +"<br>");
			out.println("Status :"+courseStudentModel.statusModel.getStatusName()+"<br>");
			out.println("Rank : "+courseStudentModel.getRank()+"<br>");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

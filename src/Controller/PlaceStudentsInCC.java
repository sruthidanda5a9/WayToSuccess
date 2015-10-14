package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.WaitStatusEligibility;
import DTO.StuInformationDTO;
import DataLayer.CourseStudentDataLayer;
import Model.CourseStudentModel;
import Model.StudentModel;
import Repository.CourseStudentInterface;
/**
 * Servlet implementation class PlaceStudentsInCC
 */
@WebServlet("/PlaceStudentsInCC")
public class PlaceStudentsInCC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PlaceStudentsInCC() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		WaitStatusEligibility eligibility = new WaitStatusEligibility();
		
		HttpSession session = request.getSession(true);
		String name=null,choice = null,programId = null,status = null,programName=null;
		CourseStudentModel courseStudentModel = (CourseStudentModel) request.getSession().getAttribute("courseStudentModel");
		StudentModel studentModel = (StudentModel) request.getSession().getAttribute("studentModel");
		choice = request.getParameter("choice");
		programId = request.getParameter("programId");
		name = request.getParameter("studentId");
		studentModel.setStudentID(Integer.parseInt(name));
		boolean check = eligibility.eligibility(studentModel);
		CourseStudentInterface getDetails = new CourseStudentDataLayer();
		if(choice.equals("1"))
		{
			courseStudentModel = getDetails.getCurrentStudentCourseOneStatus(studentModel);
		}
		else
		{
			courseStudentModel = getDetails.getCurrentStudentCourseTwoStatus(studentModel);
		}
		programName = request.getParameter("programName");
		StuInformationDTO stuInformationDTO = (StuInformationDTO) request.getSession().getAttribute("stuInformationDTO");
		if(courseStudentModel.statusModel.getStatusName().equals("WAITLISTED") && check == true)
		{
			courseStudentModel.setStudentID(Integer.parseInt(name));
			courseStudentModel.statusModel.setStatusID(4);
			getDetails.updateStatus(courseStudentModel);
			studentModel.courseStudentModel.setChoice(Integer.parseInt(choice));
			studentModel.courseStudentModel.setRank(0);
			getDetails.updateRank(studentModel);
			if(choice.equals("1"))
			{
				courseStudentModel = getDetails.getCurrentStudentCourseOneStatus(studentModel);
			}
			else
			{
				courseStudentModel = getDetails.getCurrentStudentCourseTwoStatus(studentModel);
			}
			
			response.setContentType("text/html; charset=UTF-8");
			stuInformationDTO.setSecondProgramName(courseStudentModel.progarmModel.getProgramName());
			stuInformationDTO.setSecondProgramStatus(courseStudentModel.statusModel.getStatusName());
			stuInformationDTO.setSecondProgramRank(studentModel.courseStudentModel.getRank());
			PrintWriter out = response.getWriter();
			if(choice.equals("1"))
			{
			out.println("<b>Program Choice One</b><br>");
			out.println("Name : "+courseStudentModel.progarmModel.getProgramName() +"<br>");
			out.println("Status :"+courseStudentModel.statusModel.getStatusName()+"<br>");
			out.println("Rank : "+courseStudentModel.getRank()+"<br>");
			}
			if(choice.equals("2"))
			{
				out.println("<b>Program Choice Two</b><br>");
				out.println("Name : "+courseStudentModel.progarmModel.getProgramName() +"<br>");
				out.println("Status :"+courseStudentModel.statusModel.getStatusName()+"<br>");
				out.println("Rank : "+courseStudentModel.getRank()+"<br>");
			}
		}
		else
		{
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			if(choice.equals("2"))
			{
			out.println("<b>Program Choice Two</b><br>");
			out.println("Student can't be placed, Student is not in waitlist.<br>");
			out.println("Name : "+courseStudentModel.progarmModel.getProgramName() +"<br>");
			out.println("Status :"+courseStudentModel.statusModel.getStatusName()+"<br>");
			out.println("Rank : "+courseStudentModel.getRank()+"<br>");
			}
			if(choice.equals("1"))
			{
				out.println("<b>Program Choice One</b><br>");
				out.println("Student can't be placed, Student is not in waitlist.<br>");
				out.println("Name : "+courseStudentModel.progarmModel.getProgramName() +"<br>");
				out.println("Status :"+courseStudentModel.statusModel.getStatusName()+"<br>");
				out.println("Rank : "+courseStudentModel.getRank()+"<br>");
			}
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

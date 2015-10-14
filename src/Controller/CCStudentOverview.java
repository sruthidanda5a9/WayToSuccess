package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Common.PopulatingCCStudentOverView;
import Common.PopulatingStudentInformation;
import DTO.CCStudentOverviewDTO;
import DTO.CurrentGradeDTO;
import DTO.EthnicityDTO;
import DTO.GenderDTO;
import DTO.ProgramsDTO;
import DTO.SchoolsDTO;

/**
 * Servlet implementation class CCStudentOverview
 */
@WebServlet("/CCStudentOverview")
public class CCStudentOverview extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CCStudentOverview() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		ArrayList<CCStudentOverviewDTO> ccStudentOverview = (ArrayList<CCStudentOverviewDTO>) request.getSession().getAttribute("ccStudentOverview");
		CCStudentOverviewDTO completeDetailsCheck = new CCStudentOverviewDTO();
		completeDetailsCheck.setDisplay(true);
		request.getSession().setAttribute("completeDetailsCheck", completeDetailsCheck);
		CCStudentOverviewDTO ccStudentOverviewDTO = new CCStudentOverviewDTO();
		ccStudentOverviewDTO.setGPA(Integer.parseInt(request.getParameter("GPA")));
		ccStudentOverviewDTO.setGrade(Integer.parseInt(request.getParameter("grade")));
		ccStudentOverviewDTO.setInterviewNeeded(Integer.parseInt(request.getParameter("interviewNeeded")));
		ccStudentOverviewDTO.setSchoolID(Integer.parseInt(request.getParameter("school")));
		if(request.getParameter("status") != null)
			ccStudentOverviewDTO.setStatusID(Integer.parseInt(request.getParameter("status")));
		PopulatingCCStudentOverView populatingDetails = new PopulatingCCStudentOverView ();
		ccStudentOverview= populatingDetails.getDetails(ccStudentOverviewDTO);
		request.getSession().setAttribute("ccStudentOverview", ccStudentOverview);
		CCStudentOverviewDTO[] temp;
		int size = ccStudentOverview.size();
		int count=0;
		int controller = 0;
		if(size >= 10)
		{
			temp =  new CCStudentOverviewDTO[10];
			controller=10;
		}
		else
		{
			temp =   new CCStudentOverviewDTO[size];
			controller=size;
		}

			for(int i=0;i<controller;i++)
			{
				temp[i] = ccStudentOverview.get(i);
				count++;
			}

		String message;
		if(size > 10)
		{
			message = "Displaying " +count + " of them plesae click next to see few more.";
		}
		else
		{
			message =" Displaying all the records";
		}
		if(size == 0)
		{
			temp = null;
		}
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("size", size);
		request.getSession().setAttribute("tempStudents", temp);
		request.getSession().setAttribute("message", message);
		request.getSession().setAttribute("ccStudentOverview", ccStudentOverview);
		PopulatingStudentInformation populateDetails = new PopulatingStudentInformation();
		ArrayList<SchoolsDTO> schools = populateDetails.populatingSchool();
		request.setAttribute("school", schools);
		ArrayList<ProgramsDTO> program = populateDetails.populatingProgram();
		request.setAttribute("program", program);
		ArrayList<GenderDTO> gender = populateDetails.populatingGender();
		request.setAttribute("gender", gender);
		ArrayList<EthnicityDTO> ethnicity = populateDetails.populatingEthnicity();
		request.setAttribute("ethnicity", ethnicity);
		ArrayList<CurrentGradeDTO> grade = populateDetails.populatingGrade();
		request.setAttribute("grade", grade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CCStudentOverView.jsp"); 
		dispatcher.forward(request, response);
	}
}



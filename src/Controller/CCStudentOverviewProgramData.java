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
import DTO.InterviewNeededDTO;
import DTO.ProgramsDTO;
import DTO.SchoolsDTO;

/**
 * Servlet implementation class CCStudentOverviewProgram
 */
@WebServlet("/CCStudentOverviewProgramData")
public class CCStudentOverviewProgramData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CCStudentOverviewProgramData() {
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
		/*CCStudentOverviewDTO ccStudentOverview[] = new CCStudentOverviewDTO[50];
		for( int i=0; i<50; i++ )
		{
			ccStudentOverview[i] = new CCStudentOverviewDTO();
		}*/
		
		PopulatingStudentInformation populateDetails = new PopulatingStudentInformation();
		ArrayList<SchoolsDTO> schools = populateDetails.populatingSchool();
		request.setAttribute("school", schools);
		ArrayList<ProgramsDTO> program = populateDetails.populatingProgram();
		request.setAttribute("program", program);
		ArrayList<InterviewNeededDTO> interviewNeeded = populateDetails.populatingInterviewNeeded();
		request.setAttribute("interviewNeeded", interviewNeeded);
		ArrayList<CurrentGradeDTO> grade = populateDetails.populatingGrade();
		request.setAttribute("grade", grade);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CCStudentOverView.jsp"); 
		dispatcher.forward(request, response);
	}
	}



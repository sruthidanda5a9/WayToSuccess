package Controller;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Business.AuthenticationBusiness;
import Common.PopulatingCCStudentOverView;
import Common.PopulatingContactInformationDTO;
import Common.PopulatingStudentInformation;
import Common.PopulatingStudentInformationDTO;
import DTO.AuthenticationDTO;
import DTO.CCStudentOverviewDTO;
import DTO.ContactInformationDTO;
import DTO.CurrentGradeDTO;
import DTO.EthnicityDTO;
import DTO.GenderDTO;
import DTO.InterviewNeededDTO;
import DTO.ProgramsDTO;
import DTO.SchoolsDTO;
import DTO.StuInformationDTO;
import DTO.studentStatusDTO;
import Model.StudentModel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Servlet implementation class CraeerCenterLoginCheck
 * for validating the Login of Careercenter portal.
 */
@WebServlet("/CraeerCenterLoginCheck")
public class CraeerCenterLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CraeerCenterLoginCheck() {
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
		//doGet(request, response);
		String errorMessage;
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		ArrayList<CCStudentOverviewDTO> ccStudentOverview = new ArrayList<CCStudentOverviewDTO>();
		AuthenticationDTO authenticationDTO = new AuthenticationDTO();
		authenticationDTO.setUserName(request.getParameter("userName"));
		authenticationDTO.setPassword(request.getParameter("passWord"));
		/*
		 * id from form we are setting it into DTO.
		 */
		AuthenticationBusiness authenticationBusiness = new AuthenticationBusiness();
		boolean check = authenticationBusiness.ccLoginAuthenitication(authenticationDTO);
		if(check == true)
		{
			CCStudentOverviewDTO ccStudentOverviewDTO = new CCStudentOverviewDTO();
			ccStudentOverviewDTO.setGPA(0);
			ccStudentOverviewDTO.setGrade(0);
			ccStudentOverviewDTO.setInterviewNeeded(0);
			ccStudentOverviewDTO.setSchoolID(0);
			PopulatingCCStudentOverView populatingDetails = new PopulatingCCStudentOverView ();
			
			/*
			 * Populating studentOverview details.
			 */
			
			ccStudentOverview= populatingDetails.getDetails(ccStudentOverviewDTO);
			
			/*
			 * we need to set the details in json objcet as string and we need to send them to the jsp for formating
			 */
		
			request.getSession().setAttribute("ccStudentOverview", ccStudentOverview);
			int size = ccStudentOverview.size();int count=0;
			CCStudentOverviewDTO[] tempStudents = null ;
			if(size>10)
			{
				tempStudents =  new CCStudentOverviewDTO[10];
			
			for(int i=0;i<10;i++)
			{
				tempStudents[i] = ccStudentOverview.get(i);
				count++;
			}
			}
			if(size<=10)
			{
				tempStudents =  new CCStudentOverviewDTO[size];
				
				for(int i=0;i<size;i++)
				{
					tempStudents[i] = ccStudentOverview.get(i);
					count++;
				}	
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
			request.getSession().setAttribute("count", count);
			request.getSession().setAttribute("size", size);
			request.getSession().setAttribute("tempStudents", tempStudents);
			request.getSession().setAttribute("message", message);
			PopulatingStudentInformation populateDetails = new PopulatingStudentInformation();
			ArrayList<SchoolsDTO> schools = populateDetails.populatingSchool();
			request.getSession().setAttribute("school", schools);
			ArrayList<ProgramsDTO> program = populateDetails.populatingProgram();
			request.getSession().setAttribute("program", program);
			ArrayList<InterviewNeededDTO> interviewNeeded = populateDetails.populatingInterviewNeeded();
			request.getSession().setAttribute("interviewNeeded", interviewNeeded);
			ArrayList<CurrentGradeDTO> grade = populateDetails.populatingGrade();
			request.getSession().setAttribute("grade", grade);
			request.getSession().setAttribute("ccStudentOverview", ccStudentOverview);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CCStudentOverView.jsp"); 
			dispatcher.forward(request, response);
		}
		else
		{
			errorMessage = "Please enter the valid userName and Password.";
			request.setAttribute("errorMessage", errorMessage);
			RequestDispatcher dispatcher = request.getRequestDispatcher("CareerCenterLogin.jsp"); 
			dispatcher.forward(request, response);
		}
		
		//dispatcher.forward(request, response);
		/*
		 * in forward only the request will be forward to another page.clinet will 
		 * not know to which page the control is going
		 * in sendRedirect the client will know to which page the control is going.
		 */
	}

}



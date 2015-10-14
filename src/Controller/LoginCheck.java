package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.AuthenticationBusiness;
import Common.PopulatingContactInformationDTO;
import Common.PopulatingStudentInformation;
import Common.PopulatingStudentInformationDTO;
import DTO.AuthenticationDTO;
import DTO.ContactInformationDTO;
import DTO.CurrentGradeDTO;
import DTO.EthnicityDTO;
import DTO.GenderDTO;
import DTO.ProgramsDTO;
import DTO.SchoolsDTO;
import DTO.StuInformationDTO;
import DTO.studentStatusDTO;
import DataLayer.AddressDataLayer;
import DataLayer.CourseStudentDataLayer;
import DataLayer.StudentDataLayer;
import Model.*;
import Repository.AddressInterface;
import Repository.CourseStudentInterface;
import Repository.StudentInterface;

/**
 * Servlet implementation class LoginCheck
 */
@WebServlet("/LoginCheck")
public class LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String message = null;
		String stuInfomessage = null;
		HttpSession session = request.getSession(true);
		PopulatingStudentInformationDTO populatingStuInfoDTO = new PopulatingStudentInformationDTO();
		StuInformationDTO stuInformationDTO = new StuInformationDTO();
		AuthenticationDTO authenticationDTO = new AuthenticationDTO();
		authenticationDTO.setUserName(request.getParameter("userName"));
		authenticationDTO.setPassword(request.getParameter("passWord"));
		/*
		 * id from form we are setting it into DTO.
		 */
		PopulatingStudentInformation populateDetails = new PopulatingStudentInformation();
		PopulatingContactInformationDTO populatingContactDetails = new PopulatingContactInformationDTO();
		AuthenticationBusiness authenticationBusiness = new AuthenticationBusiness();
		boolean check = authenticationBusiness.loginAuthenitication(authenticationDTO);
		if(check == true)
		{

			studentStatusDTO studentStatusDTO=new studentStatusDTO();
			StudentModel studentModel = new StudentModel();
			ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
			studentStatusDTO.setUserName(request.getParameter("userName"));
			studentModel.setStudentEmailID(studentStatusDTO.getUserName()); 
			/*
			 *1)  Now i need to find the status of the students 
			 *2)  and i need to get the details in to the Models
			 */
			boolean status = authenticationBusiness.courseStatusCheck(studentModel);
			if( status == true)
			{

				ArrayList<SchoolsDTO> schools = populateDetails.populatingSchool();
				request.getSession().setAttribute("school", schools);
				ArrayList<ProgramsDTO> program = populateDetails.populatingProgram();
				request.getSession().setAttribute("program", program);
				ArrayList<GenderDTO> gender = populateDetails.populatingGender();
				request.getSession().setAttribute("gender", gender);
				ArrayList<EthnicityDTO> ethnicity = populateDetails.populatingEthnicity();
				request.getSession().setAttribute("ethnicity", ethnicity);
				ArrayList<CurrentGradeDTO> grade = populateDetails.populatingGrade();
				request.getSession().setAttribute("grade", grade);
				stuInformationDTO = populatingStuInfoDTO.populatingDetails(studentModel);
				contactInformationDTO = populatingContactDetails.populatingDetails(studentModel);
				session.setAttribute("studentModel",studentModel);
				session.setAttribute("contactInformationDTO", contactInformationDTO);
				session.setAttribute("stuInformationDTO", stuInformationDTO);
				request.setAttribute("stuInformationDTO", stuInformationDTO); 
				request.setAttribute("contactInformationDTO", contactInformationDTO);
				stuInfomessage = "Your application is incomplete.Please fill all the details.";
				request.getSession().setAttribute("stuInfomessage", stuInfomessage);
				RequestDispatcher dispatcher = request.getRequestDispatcher("StuInformation.jsp"); 
				dispatcher.forward(request, response);
			}
			else
			{
				String smessage ="Congratulations,Your application submitted successfully .";
				request.getSession().setAttribute("smessage", smessage);
				stuInformationDTO = populatingStuInfoDTO.populatingDetailsStatus(studentModel);
				request.getSession().setAttribute("stuInformationDTO", stuInformationDTO);
				response.sendRedirect("display.jsp");
				//dispatcher.forward(request, response);
				/*
				 * in forward only the request will be forward to another page.clinet will 
				 * not know to which page the control is going
				 * in sendRedirect the client will know to which page the control is going.
				 */
			}
		}
		else
		{
			request.setAttribute("errorMessage", "Entered Usename and password are not valid.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		} 
	}

}

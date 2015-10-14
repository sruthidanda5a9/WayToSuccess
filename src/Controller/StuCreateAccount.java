package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.AuthenticationBusiness;
import Business.StuCreateAccountBusiness;
import Common.CreateAccountValidations;
import Common.PopulatingStudentInformation;
import DTO.CurrentGradeDTO;
import DTO.EthnicityDTO;
import DTO.GenderDTO;
import DTO.ProgramsDTO;
import DTO.SchoolsDTO;
import DTO.StuCreateAccountDTO;
import DTO.StuInformationDTO;
import DataLayer.AuthenticationDataLayer;
import DataLayer.CurrentGradeDataLayer;
import DataLayer.EthnicityDataLayer;
import DataLayer.GenderDataLayer;
import DataLayer.ProgramDataLayer;
import DataLayer.SchoolDataLayer;
import DataLayer.StudentDataLayer;
import Model.AuthenticationModel;
import Model.CurrentGradeModel;
import Model.EthnicityModel;
import Model.GenderModel;
import Model.ProgramModel;
import Model.SchoolModel;
import Model.StudentModel;
import Repository.AuthenticationInterface;
import Repository.CurrentGradeInterface;
import Repository.EthnicityInterface;
import Repository.GenderInterface;
import Repository.ProgramInterface;
import Repository.SchoolInterface;
import Repository.StudentInterface;

/**
 * Servlet implementation class StuCreateAccount
 */
@WebServlet("/StuCreateAccount")
public class StuCreateAccount extends HttpServlet {
	StuCreateAccountDTO stuCreateAccountDTO = new StuCreateAccountDTO();
	StuCreateAccountBusiness stuCreateAccountBusiness = new StuCreateAccountBusiness();
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StuCreateAccount() {
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
		HttpSession session = request.getSession(true);
		AuthenticationInterface authentication = new AuthenticationDataLayer();
		CreateAccountValidations createAccountValidations =  new CreateAccountValidations();
		StudentInterface student = new StudentDataLayer();
		AuthenticationModel authenticationModel = new AuthenticationModel();
		StudentModel studentModel = new StudentModel();
		AuthenticationBusiness authenticationBusiness = new AuthenticationBusiness();
		StuCreateAccountDTO stuCreateAccountDTO = new StuCreateAccountDTO();
		/*
		 * to use the model throught out the session
		 */
		session.setAttribute("studentModel",studentModel);
		stuCreateAccountDTO.setFirstName(request.getParameter("FirstName"));
		stuCreateAccountDTO.setLastName(request.getParameter("LastName"));
		stuCreateAccountDTO.setMiddleInitial(request.getParameter("MiddleInitial"));
		stuCreateAccountDTO.setEmail(request.getParameter("Email"));
		stuCreateAccountDTO.setPassWord(request.getParameter("PassWord"));
		stuCreateAccountDTO.setConfirmPassWord(request.getParameter("ConfirmPassWord"));

		boolean check  = createAccountValidations.incompleteDetailsCheck(stuCreateAccountDTO) && createAccountValidations.passwordVerification(stuCreateAccountDTO);
		/*
		 * Validating such that all the details are filled properly or not.
		 */
		if ( check   == false)
		{
		if ( !createAccountValidations.incompleteDetailsCheck(stuCreateAccountDTO) )
		{
			request.setAttribute("errorMessage", "Fill all the details.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("StuCreateAccount.jsp");
			dispatcher.forward(request, response);
		}
		if ( !createAccountValidations.passwordVerification(stuCreateAccountDTO) )
		{
			request.setAttribute("errorMessage", "Enter valid Password.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("StuCreateAccount.jsp");
			dispatcher.forward(request, response);
		}
		}
		else
		{
		request.getSession().setAttribute("stuCreateAccountDTO", stuCreateAccountDTO);
		boolean passWordCheck = stuCreateAccountBusiness.validatePassWord(stuCreateAccountDTO);
		if(passWordCheck == false)
		{
			/*
			 * Password and Confirm password are not equal so redirecting to stuCreateAcount.jsp page with error message.
			 */
			request.setAttribute("errorMessage", "Password and ConfirmPassword both are not same.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("StuCreateAccount.jsp");
			dispatcher.forward(request, response);

		}
		boolean userAccountCheck = false;
		try {
			userAccountCheck = stuCreateAccountBusiness.validate(stuCreateAccountDTO);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(userAccountCheck == false)
		{
			/*
			 * redirecting to the same page saying that user already exists.
			 * 
			 */
			request.setAttribute("errorMessage", "User already exists.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("StuCreateAccount.jsp");
			dispatcher.forward(request, response);
		}
		/*
		 * Seeting the DTO values to model.
		 */
		if( passWordCheck == true && userAccountCheck == true)
		{
			authenticationModel.setUserName(stuCreateAccountDTO.getEmail());
			authenticationModel.setPassword(stuCreateAccountDTO.getPassWord());
			studentModel.setFirstName(stuCreateAccountDTO.getFirstName());
			studentModel.setLastName(stuCreateAccountDTO.getLastName());
			studentModel.setMiddileInitial(stuCreateAccountDTO.getMiddleInitial());
			studentModel.setStudentEmailID(stuCreateAccountDTO.getEmail());

			/*
			 *call to encrypt the password. 
			 */

			authenticationModel = authenticationBusiness.encryptPassword(authenticationModel);

			/*
			 * Inserting the username and password into Authentication table.
			 */
			authentication.insert(authenticationModel);
			/*
			 * Inserting the student details into student details table.
			 */
			student.insert(studentModel);
			StuInformationDTO stuInformationDTO= new StuInformationDTO();
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
			request.setAttribute("studentModel", studentModel);
			request.setAttribute("stuInformationDTO", stuInformationDTO);
			RequestDispatcher dispatcher = request.getRequestDispatcher("StuInformation.jsp");
			dispatcher.forward(request, response);
		}
	}
	}
}

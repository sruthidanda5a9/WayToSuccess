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

import Common.PopulatingContactInformationDTO;
import Common.PopulatingStudentInformation;
import Common.PopulatingStudentInformationDTO;
import Common.StudentInformationValidation;
import DTO.ContactInformationDTO;
import DTO.CurrentGradeDTO;
import DTO.EthnicityDTO;
import DTO.GenderDTO;
import DTO.ProgramsDTO;
import DTO.SchoolsDTO;
import DTO.StuInformationDTO;
import DataLayer.AddressDataLayer;
import DataLayer.CourseStudentDataLayer;
import DataLayer.StudentDataLayer;
import Model.AddressModel;
import Model.CourseStudentModel;
import Model.ProgramModel;
import Model.StudentModel;
import Repository.AddressInterface;
import Repository.CourseStudentInterface;
import Repository.StudentInterface;

/**
 * Servlet implementation class StuInformation
 */
@WebServlet("/StuInformation")
public class StuInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StuInformation() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		StuInformationDTO stuInformationDTO = new StuInformationDTO();
		StudentInformationValidation studentInformationValidation = new StudentInformationValidation();
		ProgramModel progarmModel = new ProgramModel();
		/*
		 * in stuCreateAccount servlet assigned the studentmodel to complete
		 * session
		 */
		HttpSession session = request.getSession(true);
		StudentModel studentModel = (StudentModel) session
				.getAttribute("studentModel");
		String schoolID = request.getParameter("school");
		String currentGRADE = request.getParameter("grade");
		String programOne = request.getParameter("programOne");
		String programTwo = request.getParameter("programTwo");
		String genderDTO = request.getParameter("gender");
		String ethnicityDTO = request.getParameter("ethnicity");
		String date = request.getParameter("DOB");
		String GPA = request.getParameter("GPA");
		/*
		 * setting the retrived values into the cersponding DTO.
		 */
		stuInformationDTO.setGPA(Integer.parseInt(GPA));
		stuInformationDTO.setSchoolID(Integer.parseInt(schoolID));
		stuInformationDTO.setCurrentGrade(Integer.parseInt(currentGRADE));
		stuInformationDTO.setEthnicity(Integer.parseInt(ethnicityDTO));
		stuInformationDTO.setGender(Integer.parseInt(genderDTO));
		stuInformationDTO.setFirstProgram(Integer.parseInt(programOne));
		stuInformationDTO.setSecondProgram(Integer.parseInt(programTwo));
		stuInformationDTO.setDOB(date);
		request.getSession().setAttribute("stuInformationDTO", stuInformationDTO);

		/*
		 * If java script is off verification should be done in server side too so that if java script is off in browser
		 * here validation will be perofrmed
		 */

		boolean check  = studentInformationValidation.fillingDetails(stuInformationDTO) && studentInformationValidation.validateGPA(stuInformationDTO);

		/*
		 * Transferring the values from DTO to models for internal operations
		 * the following instructions to insert code into student table.
		 */


		if ( check == false )
		{
			PopulatingStudentInformation populateDetails = new PopulatingStudentInformation();
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
			if ( studentInformationValidation.fillingDetails(stuInformationDTO) == false )
			{
				request.setAttribute("stuInformationDTO", stuInformationDTO);
				request.setAttribute("stuInfomessage", "Fill all the details.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("StuInformation.jsp");
				dispatcher.forward(request, response);	
			}
			if ( studentInformationValidation.validateGPA(stuInformationDTO) == false )
			{
				request.setAttribute("stuInformationDTO", stuInformationDTO);
				request.setAttribute("stuInfomessage", "Enter valid GPA in between 1 and 5.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("StuInformation.jsp");
				dispatcher.forward(request, response);
			}
		}
		else
		{
			StudentInterface studentDetails = new StudentDataLayer();
			studentModel.setCurrentGPA(stuInformationDTO.getGPA());
			studentModel.setDOB(stuInformationDTO.getDOB());
			studentModel.setCurrentSchool(stuInformationDTO.getSchoolID());
			studentModel.setEthnticity(stuInformationDTO.getEthnicity());
			studentModel.setCurrentGrade(stuInformationDTO.getCurrentGrade());
			studentModel.setGender(stuInformationDTO.getGender());
			studentDetails.update(studentModel);
			/*
			 * inserting programs and its choices of the student into
			 */
			studentModel = studentDetails.getStudentId(studentModel);
			CourseStudentInterface insertDetails = new CourseStudentDataLayer();
			CourseStudentModel courseStudentModel = new CourseStudentModel();
			courseStudentModel.setStudentID(studentModel.getStudentID());
			/*
			 * inserted choice one and program
			 */
			courseStudentModel.progarmModel.setProgramID(stuInformationDTO.getFirstProgram());
			courseStudentModel.setChoice(1);
			insertDetails.insert(courseStudentModel);
			/*
			 * inserted choice 2 and program
			 */
			courseStudentModel.progarmModel.setProgramID(stuInformationDTO.getSecondProgram());
			courseStudentModel.setChoice(2);
			insertDetails.insert(courseStudentModel);
			/*
			 * Redirecting to Contact Information page
			 */
			ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
			PopulatingContactInformationDTO populatingContactDetails = new PopulatingContactInformationDTO();
			contactInformationDTO = populatingContactDetails.populatingDetails(studentModel);
			session.setAttribute("studentModel",studentModel);
			session.setAttribute("contactInformationDTO", contactInformationDTO);
			session.setAttribute("stuInformationDTO", stuInformationDTO);
			request.setAttribute("stuInformationDTO", stuInformationDTO); 
			request.setAttribute("contactInformationDTO", contactInformationDTO);
			request.getSession().setAttribute("studentModel",studentModel);
			RequestDispatcher dispatcher = request.getRequestDispatcher("ContactInformation.jsp");
			dispatcher.forward(request, response);

		}}
}

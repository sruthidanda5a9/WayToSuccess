package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Common.ContactInformationValidation;
import DTO.ContactInformationDTO;
import DTO.StuInformationDTO;
import DTO.StudentVerificationDTO;
import DataLayer.AddressDataLayer;
import DataLayer.CourseStudentDataLayer;
import DataLayer.ProgramDataLayer;
import DataLayer.StudentDataLayer;
import Model.AddressModel;
import Model.CourseStudentModel;
import Model.ProgramModel;
import Model.StudentModel;
import Repository.AddressInterface;
import Repository.CourseStudentInterface;
import Repository.ProgramInterface;
import Repository.StudentInterface;

/**
 * Servlet implementation class ContactInformation
 */
@WebServlet("/ContactInformation")
public class ContactInformation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ContactInformation() {
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
		ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
		ContactInformationValidation contactInformationValidation =  new ContactInformationValidation();
		/*
		 * in "stuCreateAccount" servlet assigned the studentmodel to complete session
		 */
		HttpSession session = request.getSession(true);  
		AddressModel addressModel = new AddressModel();
		session.setAttribute("addressModel",addressModel);
		StudentModel studentModel = (StudentModel) session.getAttribute("studentModel"); 
		contactInformationDTO.setAddressLineOne(request. getParameter("addressLineOne"));
		contactInformationDTO.setStreet(request.getParameter("street"));
		contactInformationDTO.setCity(request.getParameter("city"));
		contactInformationDTO.setState(request.getParameter("state"));
		contactInformationDTO.setZipCode(request.getParameter("zip"));
		contactInformationDTO.setStudentCellNumber(request.getParameter("studentPhone"));
		contactInformationDTO.setHomePhoneNumber(request.getParameter("studentHomePhone"));
		contactInformationDTO.setAdditionalEmail(request.getParameter("additionalEmail"));
		
		/*
		 * if java script is disabled in client side we need to validate them in the server side too.
		 */
		
		boolean check = contactInformationValidation.fillingDetails(contactInformationDTO) && 
							contactInformationValidation.validatingPhoneNumber(contactInformationDTO) &&
							contactInformationValidation.validatingZipCode(contactInformationDTO) ;
		if ( check == false )
		{
			if ( contactInformationValidation.fillingDetails(contactInformationDTO) == false)
			{
				request.setAttribute("ContactInfoError", "Fill all the details.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("ContactInformation.jsp");
				dispatcher.forward(request, response);
			}
			if ( contactInformationValidation.validatingPhoneNumber(contactInformationDTO) == false)
			{
				request.setAttribute("ContactInfoError", "Enter valid phone number.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("ContactInformation.jsp");
				dispatcher.forward(request, response);
			}
			if( contactInformationValidation.validatingZipCode(contactInformationDTO) ==  false)
			{
				request.setAttribute("ContactInfoError", "Enter valid zip code.");
				RequestDispatcher dispatcher = request.getRequestDispatcher("ContactInformation.jsp");
				dispatcher.forward(request, response);
			}
		}
		else
		{
		/*
		 * Transfering the details from DTO to student model
		 */
		studentModel.setCellNumber(contactInformationDTO.getStudentCellNumber());
		studentModel.setHomePhone(contactInformationDTO.getHomePhoneNumber());
		/*
		 * transfering details from DTO to Address Model
		 */
		addressModel.setAddressLineOne(contactInformationDTO.getAddressLineOne());
		addressModel.setAddressLineTwo(contactInformationDTO.getAddressLineTwo());
		addressModel.setCity(contactInformationDTO.getCity());
		addressModel.setStreet(contactInformationDTO.getStreet());
		addressModel.setState(contactInformationDTO.getState());
		addressModel.setZipCode(contactInformationDTO.getZipCode());
		AddressInterface addressDetails = new AddressDataLayer();
		/*
		 * inserting details into address table
		 */
		addressDetails.insert(addressModel);
		/*
		 * inserting student details.
		 */
		StudentInterface studentDetails = new StudentDataLayer();
		studentDetails.update(studentModel);
		addressModel = addressDetails.getAddressID();
		studentModel.addressModel.setAddressID(addressModel.getAddressID());
		studentDetails.insertAddressID(studentModel);
		StudentVerificationDTO studentVerificationDTO = new StudentVerificationDTO();
		session.setAttribute("studentVerificationDTO", studentVerificationDTO);
		/*
		 * setting the details into student verification DTO to display on the verification page.
		 */
		studentModel = studentDetails.getCurrentStudent(studentModel);
		addressModel = addressDetails.getAddressID();
		CourseStudentModel courseStudentModelOne = new CourseStudentModel();
		CourseStudentModel courseStudentModelTwo = new CourseStudentModel();
		CourseStudentInterface currentprogramDetails = new CourseStudentDataLayer();
		studentVerificationDTO.setFirstName(studentModel.getFirstName());
		studentVerificationDTO.setLastName(studentModel.getLastName());
		studentVerificationDTO.setAddressLineOne(addressModel.getAddressLineOne());
		studentVerificationDTO.setStreet(addressModel.getStreet());
		studentVerificationDTO.setCity(addressModel.getCity());
		studentVerificationDTO.setState(addressModel.getState());
		studentVerificationDTO.setZipCode(addressModel.getZipCode());
		studentVerificationDTO.setStudentCellNumebr(studentModel.getCellNumber());
		studentVerificationDTO.setStudentHomePhone(studentModel.getHomePhone());
		studentVerificationDTO.setCurrentGrade(studentModel.gradeModel.getCurrentGrade());
		studentVerificationDTO.setCurrentSchool(studentModel.schoolModel.getSchoolName());
		studentVerificationDTO.setGender(studentModel.genderModel.getGenderName());
		studentVerificationDTO.setDOB(studentModel.getDOB());
		courseStudentModelOne = currentprogramDetails.getCurrentStudentCourseOne(studentModel);
		courseStudentModelOne.setStudentID(studentModel.getStudentID());
		session.setAttribute("courseStudentModelOne",courseStudentModelOne);
		courseStudentModelTwo = currentprogramDetails.getCurrentStudentCourseTwo(studentModel);
		courseStudentModelTwo.setStudentID(studentModel.getStudentID());
		session.setAttribute("courseStudentModelTwo",courseStudentModelTwo);
		studentVerificationDTO.setProgramOne(courseStudentModelOne.progarmModel.getProgramName());
		studentVerificationDTO.setProgramTwo(courseStudentModelTwo.progarmModel.getProgramName());
		studentVerificationDTO.setEthnicity(studentModel.ethnicityModel.getEthnicityName());
		request.setAttribute("verification", studentVerificationDTO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("StudentVerification.jsp");
		dispatcher.forward(request, response);
	}
}
}

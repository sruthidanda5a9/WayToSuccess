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

import Common.PopulatingContactInformationDTO;
import Common.PopulatingStudentInformation;
import Common.PopulatingStudentInformationDTO;
import DTO.ContactInformationDTO;
import DTO.CurrentGradeDTO;
import DTO.EthnicityDTO;
import DTO.GenderDTO;
import DTO.ProgramsDTO;
import DTO.SchoolsDTO;
import DTO.StuInformationDTO;
import DataLayer.AddressDataLayer;
import Model.AddressModel;
import Model.StudentModel;
import Repository.AddressInterface;

/**
 * Servlet implementation class CCContactInfoProfileUpdate
 */
@WebServlet("/CCContactInfoProfileUpdate")
public class CCContactInfoProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CCContactInfoProfileUpdate() {
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
		/*
		 * In Creer Center Profile page updating the contact information details.
		 */
		HttpSession session = request.getSession(true);  
		AddressModel addressModel = new AddressModel();
		ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
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
		 * Address update
		 */
		addressDetails.update(addressModel);
		PopulatingStudentInformationDTO populatingStuInfoDTO = new PopulatingStudentInformationDTO();
		StuInformationDTO stuInformationDTO = new StuInformationDTO();
		PopulatingStudentInformation populateDetails = new PopulatingStudentInformation();
		PopulatingContactInformationDTO populatingContactDetails = new PopulatingContactInformationDTO();
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
		stuInformationDTO = populatingStuInfoDTO.populatingDetails(studentModel);
		contactInformationDTO = populatingContactDetails.populatingDetails(studentModel);
		session.setAttribute("studentModel",studentModel);
		session.setAttribute("contactInformationDTO", contactInformationDTO);
		session.setAttribute("stuInformationDTO", stuInformationDTO);
		request.setAttribute("stuInformationDTO", stuInformationDTO); 
		request.setAttribute("contactInformationDTO", contactInformationDTO);
		request.getSession().setAttribute("studentModel",studentModel);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CareerCenterProfile.jsp");
		dispatcher.forward(request, response);
	}

}

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
import DataLayer.CourseStudentDataLayer;
import DataLayer.StudentDataLayer;
import Model.CourseStudentModel;
import Model.ProgramModel;
import Model.StudentModel;
import Repository.CourseStudentInterface;
import Repository.StudentInterface;

/**
 * Servlet implementation class CCStuInformationProfileUpdate
 */
@WebServlet("/CCStuInformationProfileUpdate")
public class CCStuInformationProfileUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CCStuInformationProfileUpdate() {
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
		StuInformationDTO stuInformationDTO = new StuInformationDTO();
		ProgramModel progarmModel = new ProgramModel();
		/*
		 * Student model contains student id which is already in session
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
		/*
		 * Transferring the values from DTO to models for internal operations
		 * the following instructions to insert code into student table.
		 */
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
		 * update choice one and program
		 */
		courseStudentModel.progarmModel.setProgramID(stuInformationDTO.getFirstProgram());
		courseStudentModel.setChoice(1);
		insertDetails.updateCourseDetails(courseStudentModel);
		/*
		 * update choice 2 and program
		 */
		courseStudentModel.progarmModel.setProgramID(stuInformationDTO.getSecondProgram());
		courseStudentModel.setChoice(2);
		insertDetails.updateCourseDetails(courseStudentModel);
		PopulatingStudentInformationDTO populatingStuInfoDTO = new PopulatingStudentInformationDTO();
		ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
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
		stuInformationDTO = populatingStuInfoDTO.populatingDetailsStatus(studentModel);
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

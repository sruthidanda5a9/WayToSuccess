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
import Model.StudentModel;

/**
 * Servlet implementation class HomeSchoolStudentProfile
 */
@WebServlet("/HomeSchoolStudentProfile")
public class HomeSchoolStudentProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSchoolStudentProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession(true);
		StudentModel studentModel = new StudentModel();
		studentModel.setStudentID(Integer.parseInt(request.getParameter("sid")));
		PopulatingStudentInformationDTO populatingStuInfoDTO = new PopulatingStudentInformationDTO();
		ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
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
		stuInformationDTO = populatingStuInfoDTO.populatingDetailsStatus(studentModel);
		contactInformationDTO = populatingContactDetails.populatingDetails(studentModel);
		session.setAttribute("studentModel",studentModel);
		session.setAttribute("contactInformationDTO", contactInformationDTO);
		session.setAttribute("stuInformationDTO", stuInformationDTO);
		request.setAttribute("stuInformationDTO", stuInformationDTO); 
		request.setAttribute("contactInformationDTO", contactInformationDTO);
		request.getSession().setAttribute("studentModel",studentModel);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomeSchoolStudentProfile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		

	}

}

package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Common.PopulatingStudentInformationDTO;
import DTO.StuInformationDTO;
import DataLayer.CourseStudentDataLayer;
import DataLayer.StatusDataLayer;
import DataLayer.StudentDataLayer;
import Model.CourseStudentModel;
import Model.StatusModel;
import Model.StudentModel;
import Repository.CourseStudentInterface;
import Repository.StatusInterface;
import Repository.StudentInterface;

/**
 * Servlet implementation class StudentVerification
 */
@WebServlet("/StudentVerification")
public class StudentVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentVerification() {
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
		HttpSession session = request.getSession(true);
		String message = " Congratulations, Your application is submitted successfully.";
		PopulatingStudentInformationDTO populatingStuInfoDTO = new PopulatingStudentInformationDTO();
		StuInformationDTO stuInformationDTO = new StuInformationDTO();
		StudentModel studentModel = (StudentModel) session.getAttribute("studentModel"); 
		CourseStudentModel courseStudentModelOne = (CourseStudentModel) session.getAttribute("courseStudentModelOne"); 
		CourseStudentModel courseStudentModelTwo = (CourseStudentModel) session.getAttribute("courseStudentModelTwo");
		StudentInterface studentdetails = new StudentDataLayer();
		studentModel = studentdetails.getCurrentStudent(studentModel);
		StatusModel statusModel = new StatusModel();
		StatusInterface statusDetails = new StatusDataLayer();
		statusModel = statusDetails.getPendingStatusID();
		courseStudentModelOne.statusModel.setStatusID(statusModel.getStatusID());
		courseStudentModelTwo.statusModel.setStatusID(statusModel.getStatusID());
		CourseStudentInterface courseStudentDetails = new CourseStudentDataLayer();
		courseStudentDetails.updateStatus(courseStudentModelOne);
		courseStudentDetails.updateStatus(courseStudentModelTwo);
		stuInformationDTO = populatingStuInfoDTO.populatingDetailsStatus(studentModel);
		request.getSession().setAttribute("smessage", message);
		request.getSession().setAttribute("stuInformationDTO", stuInformationDTO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("display.jsp"); 
		dispatcher.forward(request, response);
	}

}

package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.PopulatingStudentInformationDTO;
import DTO.StuInformationDTO;
import DataLayer.StudentDataLayer;
import Model.StudentModel;
import Repository.StudentInterface;

/**
 * Servlet implementation class InterviewRequired
 */
@WebServlet("/InterviewRequired")
public class InterviewRequired extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InterviewRequired() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=null;
		int val;
		StuInformationDTO stuInformationDTO = (StuInformationDTO) request.getSession().getAttribute("stuInformationDTO");
		PopulatingStudentInformationDTO populatingStuInfoDTO = new PopulatingStudentInformationDTO();
		name = request.getParameter("studentId");
		val = Integer.parseInt(request.getParameter("val"));
		StudentModel studentModel = new StudentModel();
		studentModel.setStudentID(Integer.parseInt(name));
		studentModel.setInterviewNeeded(val);
		StudentInterface studentDetails = new StudentDataLayer();
		studentDetails.insertInterview(studentModel);
		stuInformationDTO = populatingStuInfoDTO.populatingDetailsStatus(studentModel);
		request.getSession().setAttribute("studentInformationDTO", stuInformationDTO);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Interview Required : ");
		out.println(stuInformationDTO.getInterviewStatus());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

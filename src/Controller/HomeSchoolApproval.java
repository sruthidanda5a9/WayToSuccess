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
import DataLayer.HomeSchoolContactDatatLayer;
import Model.StudentModel;
import Repository.HomeScoolContactInterface;

/**
 * Servlet implementation class HomeSchoolApproval
 */
@WebServlet("/HomeSchoolApproval")
public class HomeSchoolApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSchoolApproval() {
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
		studentModel.homeSchoolContactModel.setHomeSchoolContactId(val);
		HomeScoolContactInterface homeSchoolContact = new HomeSchoolContactDatatLayer();
		homeSchoolContact.insertHomeSchoolContact(studentModel);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("Contact Home School :");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

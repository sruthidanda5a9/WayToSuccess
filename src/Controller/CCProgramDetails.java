package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Common.PopulatingStudentInformation;
import DTO.CCProgramsDTO;
import DTO.CCStudentOverviewDTO;
import DTO.ProgramsDTO;
import DataLayer.CourseStudentDataLayer;
import Model.StudentModel;
import Repository.CourseStudentInterface;

/**
 * Servlet implementation class CCProgramDetails
 */
@WebServlet("/CCProgramDetails")
public class CCProgramDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CCProgramDetails() {
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
		HttpSession session = request.getSession(true);
		CCProgramsDTO ccProgramsDTO = new CCProgramsDTO();
		PopulatingStudentInformation populateDetails = new PopulatingStudentInformation();
		ArrayList<ProgramsDTO> program = populateDetails.populatingProgram();
		request.getSession().setAttribute("program", program);
		ccProgramsDTO.setProgramID(Integer.parseInt(request.getParameter("program"))); 
		ArrayList<CCProgramsDTO> ccProgramsDetails = new ArrayList<CCProgramsDTO>();
		ArrayList<StudentModel> studentModel = new ArrayList<StudentModel>();
		CourseStudentInterface courseStudentDetails = new CourseStudentDataLayer();
		studentModel = courseStudentDetails.getCourseStudentDetails(ccProgramsDTO);
		for(int i=0;i<studentModel.size();i++)
		{
			CCProgramsDTO  ccPrograms = new CCProgramsDTO();
			ccPrograms.setFirstName(studentModel.get(i).getFirstName());
			ccPrograms.setLastName(studentModel.get(i).getLastName());
			ccPrograms.setStudentID(studentModel.get(i).getStudentID());
			ccPrograms.setStatusName(studentModel.get(i).statusModel.getStatusName());
			ccPrograms.setChoice(studentModel.get(i).courseStudentModel.getChoice());
			ccPrograms.setProgramName((studentModel.get(i).courseStudentModel.progarmModel.getProgramName()));
			ccProgramsDetails.add(ccPrograms);
		}
		
		int sizePrograms = ccProgramsDetails.size();
		int countPrograms=0;
		int controller =0;
		if(sizePrograms >10)
		{
			controller = 10;
		}
		else
		{
			controller = sizePrograms;
		}
		CCProgramsDTO[] tempPrograms =  new CCProgramsDTO[controller];
			for(int i=0;i<controller;i++)
			{
				tempPrograms[i] = ccProgramsDetails.get(i);
				countPrograms++;
			}
		String message;
		if(sizePrograms > 10)	
		{
			message = "Displaying " +countPrograms + " of them plesae click next to see few more.";
		}
		else
		{
			message ="Displaying all the records";
		}
		request.getSession().setAttribute("countPrograms", countPrograms);
		request.getSession().setAttribute("sizePrograms", sizePrograms);
		request.getSession().setAttribute("tempPrograms", tempPrograms);
		request.getSession().setAttribute("message", message); 
		request.getSession().setAttribute("ccProgramsDTO", ccProgramsDTO);
		request.getSession().setAttribute("ccProgramsDetails", ccProgramsDetails);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CCPrograms.jsp"); 
		dispatcher.forward(request, response);
	}

}

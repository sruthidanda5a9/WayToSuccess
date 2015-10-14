package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Common.PopulatingStudentInformation;
import DTO.CCProgramsDTO;
import DTO.ProgramsDTO;
import DataLayer.CourseStudentDataLayer;
import Repository.CourseStudentInterface;

/**
 * Servlet implementation class CCProgram
 */
@WebServlet("/CCProgram")
public class CCProgram extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CCProgram() {
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
		CCProgramsDTO ccProgramsDTO = new CCProgramsDTO();
		CCProgramsDTO ccProgramsOneDTO= new CCProgramsDTO();
		CCProgramsDTO ccProgramsTwoDTO= new CCProgramsDTO();
		CCProgramsDTO ccProgramsThreeDTO= new CCProgramsDTO();
		CCProgramsDTO ccProgramsFourDTO= new CCProgramsDTO();
		CCProgramsDTO ccProgramsFiveDTO= new CCProgramsDTO();
		CCProgramsDTO ccProgramsSixDTO= new CCProgramsDTO();
		CCProgramsDTO ccProgramsSevenDTO= new CCProgramsDTO();
		CCProgramsDTO ccProgramsEightDTO= new CCProgramsDTO();
		ccProgramsDTO.setProgramID(0);
		PopulatingStudentInformation populateDetails = new PopulatingStudentInformation();
		ArrayList<ProgramsDTO> program = populateDetails.populatingProgram();
		request.getSession().setAttribute("program", program);
		CourseStudentInterface courseStudentDetails = new CourseStudentDataLayer();
		/*
		 * getting ProgramOne details.
		 */
		ccProgramsOneDTO.setProgramID(1);
		ccProgramsTwoDTO.setProgramID(2);
		ccProgramsThreeDTO.setProgramID(3);
		ccProgramsFourDTO.setProgramID(4);
		ccProgramsFiveDTO.setProgramID(5);
		ccProgramsSixDTO.setProgramID(6);
		ccProgramsSevenDTO.setProgramID(7);
		ccProgramsEightDTO.setProgramID(8);
		ccProgramsOneDTO = courseStudentDetails.getProgramDetails(ccProgramsOneDTO);
		ccProgramsTwoDTO = courseStudentDetails.getProgramDetails(ccProgramsTwoDTO);
		ccProgramsThreeDTO = courseStudentDetails.getProgramDetails(ccProgramsThreeDTO);
		ccProgramsFourDTO = courseStudentDetails.getProgramDetails(ccProgramsFourDTO);
		ccProgramsFiveDTO = courseStudentDetails.getProgramDetails(ccProgramsFiveDTO);
		ccProgramsSixDTO = courseStudentDetails.getProgramDetails(ccProgramsSixDTO);
		ccProgramsSevenDTO = courseStudentDetails.getProgramDetails(ccProgramsSevenDTO);
		ccProgramsEightDTO = courseStudentDetails.getProgramDetails(ccProgramsEightDTO);
		request.getSession().setAttribute("ccProgramsOneDTO", ccProgramsOneDTO);
		request.getSession().setAttribute("ccProgramsTwoDTO", ccProgramsTwoDTO);
		request.getSession().setAttribute("ccProgramsThreeDTO", ccProgramsThreeDTO);
		request.getSession().setAttribute("ccProgramsFourDTO", ccProgramsFourDTO);
		request.getSession().setAttribute("ccProgramsFiveDTO", ccProgramsFourDTO);
		request.getSession().setAttribute("ccProgramsSixDTO", ccProgramsFourDTO);
		request.getSession().setAttribute("ccProgramsSevenDTO", ccProgramsFourDTO);
		request.getSession().setAttribute("ccProgramsEightDTO", ccProgramsFourDTO);
		request.getSession().setAttribute("ccProgramsDTO", ccProgramsDTO);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CCPrograms.jsp"); 
		dispatcher.forward(request, response);
	}

}

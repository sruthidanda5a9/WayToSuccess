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

import Business.AuthenticationBusiness;
import Common.PopulatingCCStudentOverView;
import Common.PopulatingHomeSchoolStudents;
import DTO.AuthenticationDTO;
import DTO.CCStudentOverviewDTO;

/**
 * Servlet implementation class HomeSchoolLoginCheck
 */
@WebServlet("/HomeSchoolLoginCheck")
public class HomeSchoolLoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeSchoolLoginCheck() {
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
		response.setContentType("text/html");
		HttpSession session = request.getSession(true);
		ArrayList<CCStudentOverviewDTO> ccStudentOverview = new ArrayList<CCStudentOverviewDTO>();
		AuthenticationDTO authenticationDTO = new AuthenticationDTO();
		authenticationDTO.setUserName(request.getParameter("userName"));
		authenticationDTO.setPassword(request.getParameter("passWord"));
		
		/*
		 * id from form we are setting it into DTO.
		 */
		AuthenticationBusiness authenticationBusiness = new AuthenticationBusiness();
		boolean check = authenticationBusiness.loginAuthenitication(authenticationDTO);
		if(check == true)
		{
			CCStudentOverviewDTO ccStudentOverviewDTO = new CCStudentOverviewDTO();
			ccStudentOverviewDTO.setUserName(authenticationDTO.getUserName());
			PopulatingHomeSchoolStudents populatingDetails = new PopulatingHomeSchoolStudents ();
			ccStudentOverview= populatingDetails.getHomeSchoolApproval(ccStudentOverviewDTO);
			request.getSession().setAttribute("ccStudentOverview", ccStudentOverview);
			int size = ccStudentOverview.size();int count=0;
			CCStudentOverviewDTO[] tempStudents = null ;
			if(size>10)
			{
				tempStudents =  new CCStudentOverviewDTO[10];
			
			for(int i=0;i<10;i++)
			{
				tempStudents[i] = ccStudentOverview.get(i);
				count++;
			}
			}
			if(size<=10)
			{
				tempStudents =  new CCStudentOverviewDTO[size];
				
				for(int i=0;i<size;i++)
				{
					tempStudents[i] = ccStudentOverview.get(i);
					count++;
				}	
			}
			
			String message;
			if(size > 10)
			{
				message = "Displaying " +count + " of them plesae click next to see few more.";
			}
			else
			{
				message =" Displaying all the records";
			}
			request.getSession().setAttribute("count", count);
			request.getSession().setAttribute("size", size);
			request.getSession().setAttribute("tempStudents", tempStudents);
			request.getSession().setAttribute("message", message);
			request.getSession().setAttribute("ccStudentOverview", ccStudentOverview);
			RequestDispatcher dispatcher = request.getRequestDispatcher("HomeSchoolStudentOverView.jsp"); 
			dispatcher.forward(request, response);
		}
	}
}



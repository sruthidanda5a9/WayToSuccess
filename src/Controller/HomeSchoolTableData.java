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
import DTO.CCStudentOverviewDTO;
import DTO.CurrentGradeDTO;
import DTO.InterviewNeededDTO;
import DTO.ProgramsDTO;
import DTO.SchoolsDTO;

/**
 * Servlet implementation class HomeSchoolTableData
 */
@WebServlet("/HomeSchoolTableData")
public class HomeSchoolTableData extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeSchoolTableData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int size = (Integer) request.getSession().getAttribute("size");
		int count =(Integer) request.getSession().getAttribute("count");
		int controll=0;
		int start = 0;
		int arraysize=0;
		int x=0;
		int temp =0;
		String buttonClicked = request.getParameter("buttonCheck");
		if(size < 10 || size == 10)
		{
			arraysize = size;
			count = 0;
			controll = arraysize;
		}
		if(size > 10)
		{
			if("next".equals(buttonClicked))
			{
				if(size - count < 10)
				{
					arraysize = size - count;
					controll = arraysize;
				}
				else
				{
					arraysize = 10;
					controll = arraysize;
				}
			}
			else
			{
				if(count == 10 || count < 10)
				{
					arraysize = count;
					controll = arraysize;
				}
				else
				{
					arraysize = 10;
					controll = 10;
					start =( count - (count%10));

				}
				if("Previous".equals(buttonClicked) )
				{
				x= count%10;
				if(x!=0)
				{
				temp =  count-(count%10);
				}
				else
				{
					temp =  count-10;
				}
				count = temp;
				}
				
			}
		}
		ArrayList<CCStudentOverviewDTO> ccStudentOverview = (ArrayList<CCStudentOverviewDTO>) request.getSession().getAttribute("ccStudentOverview");
		CCStudentOverviewDTO[] tempStudents =  new CCStudentOverviewDTO[controll];
		if(size > 10)
		{
		for(int i=0;i<controll;i++)
		{

			if("next".equals(buttonClicked))
			{
				tempStudents[i] = ccStudentOverview.get(count);
				count++;
				temp = count;
			}
			else
			{
				if( x != 0)
				{
					
					tempStudents[i] = ccStudentOverview.get(temp);
					temp--;
				}
				else
				{
					
					tempStudents[i] = ccStudentOverview.get(temp);
					temp++;
				}
			}
		}
		}
		else
		{
			for(int i=0;i<controll;i++)
			{
				tempStudents[i] = ccStudentOverview.get(count);
				count++;
				temp = count;
			}
		}
		String message;
		if(size > 10)
		{
			message = "displaying " +controll  + " of them plesae click next to see few more.";
		}
		else
		{
			message =" Displaying all the records";
		}
		request.getSession().setAttribute("count", count);
		request.getSession().setAttribute("size", size);
		request.getSession().setAttribute("tempStudents", tempStudents);
		request.getSession().setAttribute("message", message);
		PopulatingStudentInformation populateDetails = new PopulatingStudentInformation();
		ArrayList<SchoolsDTO> schools = populateDetails.populatingSchool();
		request.getSession().setAttribute("school", schools);
		ArrayList<ProgramsDTO> program = populateDetails.populatingProgram();
		request.getSession().setAttribute("program", program);
		ArrayList<InterviewNeededDTO> interviewNeeded = populateDetails.populatingInterviewNeeded();
		request.getSession().setAttribute("interviewNeeded", interviewNeeded);
		ArrayList<CurrentGradeDTO> grade = populateDetails.populatingGrade();
		request.getSession().setAttribute("grade", grade);
		request.getSession().setAttribute("ccStudentOverview", ccStudentOverview);
		RequestDispatcher dispatcher = request.getRequestDispatcher("HomeSchoolStudentOverView.jsp"); 
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

package Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DTO.CCProgramsDTO;
import DTO.CCStudentOverviewDTO;

/**
 * Servlet implementation class DisplayTableDataPrograms
 */
@WebServlet("/DisplayTableDataPrograms")
public class DisplayTableDataPrograms extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DisplayTableDataPrograms() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("Served at: ").append(request.getContextPath());
		int sizePrograms = (Integer) request.getSession().getAttribute("sizePrograms");
		int countPrograms =(Integer) request.getSession().getAttribute("countPrograms");
		int controll=0;
		int start = 0;
		int size=0;
		int x=0;
		int temp =0;
		int startTransfer =0;
		String buttonClicked = request.getParameter("buttonCheck");
		if(sizePrograms < 10 || sizePrograms == 10)
		{
			size = sizePrograms;
			countPrograms = 0;
			controll = size;
		}
		if(sizePrograms > 10)
		{
			if("next".equals(buttonClicked))
			{
				if(sizePrograms - countPrograms < 10)
				{
					size = sizePrograms - countPrograms;
					controll = size;
					startTransfer = countPrograms;
				}
				else
				{
					size = 10;
					controll = size;
					startTransfer = countPrograms;
				}
			}
			else
			{
				if(countPrograms == 10 || countPrograms < 10)
				{
					size = countPrograms;
					controll = size;
				}
				else
				{
					size = 10;
					controll = 10;
					start =( countPrograms - (countPrograms%10));
					startTransfer = start;

				}
				if("Previous".equals(buttonClicked) )
				{
				x= countPrograms%10;
				if(x!=0)
				{
				temp =  countPrograms-(countPrograms%10);
				}
				else
				{
					temp =  countPrograms-10;
				}
				countPrograms = temp;
				}
				
			}
		}
		ArrayList<CCProgramsDTO> ccProgramsDetails = (ArrayList<CCProgramsDTO>) request.getSession().getAttribute("ccProgramsDetails");
		CCProgramsDTO[] tempPrograms =  new CCProgramsDTO[size];
		if(sizePrograms > 10)
		{
		for(int i=0;i<controll;i++)
		{

			if("next".equals(buttonClicked))
			{
				tempPrograms[i] = ccProgramsDetails.get(countPrograms);
				countPrograms++;
				temp = countPrograms;
			}
			else
			{
				if( x != 0)
				{
					
					tempPrograms[i] = ccProgramsDetails.get(temp);
					temp--;
				}
				else
				{
					
					tempPrograms[i] = ccProgramsDetails.get(temp);
					temp++;
					countPrograms = temp;
				}
			}
		}
		}
		else
		{
			for(int i=0;i<controll;i++)
			{
				tempPrograms[i] = ccProgramsDetails.get(countPrograms);
				countPrograms++;
				temp = countPrograms;
			}
		}
		String message;
		if(sizePrograms > 10)
		{
			message = "Displaying " +size  + " of them plesae click next to see few more.";
		}
		else
		{
			message =" Displaing all the records";
		}
		request.getSession().setAttribute("countPrograms", countPrograms);
		request.getSession().setAttribute("sizePrograms", sizePrograms);
		request.getSession().setAttribute("tempPrograms", tempPrograms);
		request.getSession().setAttribute("message", message); 
		request.getSession().setAttribute("ccProgramsDetails", ccProgramsDetails);
		RequestDispatcher dispatcher = request.getRequestDispatcher("CCPrograms.jsp"); 
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

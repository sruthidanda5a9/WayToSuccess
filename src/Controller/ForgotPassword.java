package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Common.PopulatingStudentInformation;
import Common.PopulatingStudentInformationDTO;
import DTO.AuthenticationDTO;
import DTO.ForgotPasswordDTO;
import DTO.StuInformationDTO;
import Model.AuthenticationModel;

/**
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
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
		response.setContentType("text/html");
		AuthenticationModel authenticationModel = new AuthenticationModel();
		PopulatingStudentInformation populatingForgotPassword = new PopulatingStudentInformation();
		ForgotPasswordDTO forgotPasswordDTO = new ForgotPasswordDTO();
		forgotPasswordDTO.setUserName(request.getParameter("userName"));
		forgotPasswordDTO.setDOB(request.getParameter("DOB"));
		authenticationModel.setUserName(forgotPasswordDTO.getUserName());
		if( populatingForgotPassword.validateDOB(forgotPasswordDTO))
		{
			request.getSession().setAttribute("authenticationModel", authenticationModel);
			response.sendRedirect("resetPassword.jsp");
		}
		else
		{
			request.setAttribute("errorMessageFP", "Entered Usename and DOB are not matching.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("forgotPassword.jsp");
			dispatcher.forward(request, response);
		}
	}

}

package Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Business.AuthenticationBusiness;
import Common.PopulatingStudentInformation;
import DTO.ForgotPasswordDTO;
import DTO.ResetPasswordDTO;
import DataLayer.AuthenticationDataLayer;
import Model.AuthenticationModel;
import Model.StudentModel;
import Repository.AuthenticationInterface;

/**
 * Servlet implementation class ResetPassword
 */
@WebServlet("/ResetPassword")
public class ResetPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPassword() {
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
		HttpSession session = request.getSession(true);
		AuthenticationModel authenticationModel = (AuthenticationModel) session
				.getAttribute("authenticationModel");
		ResetPasswordDTO resetPasswordDTO = new ResetPasswordDTO();
		resetPasswordDTO.setPassword(request.getParameter("password"));
		resetPasswordDTO.setConfirmPassword(request.getParameter("confirmPassword"));
		
		/*
		 * This method is to verify your confirm password and password are same or not.
		 */
		
		resetPasswordDTO.setConfirmPassword(request.getParameter("confirmPassword"));
		if( resetPasswordDTO.getPassword() != null && resetPasswordDTO.getConfirmPassword() !=null && resetPasswordDTO.getPassword().equals(resetPasswordDTO.getConfirmPassword()))
		{
			AuthenticationBusiness encryptPassword = new AuthenticationBusiness();
			authenticationModel.setPassword(resetPasswordDTO.getPassword());
			authenticationModel = encryptPassword.encryptPassword(authenticationModel);
			AuthenticationInterface resetPassword = new AuthenticationDataLayer();
			
			/*
			 * Updating the password in the database.
			 */
			resetPassword.resetPassword(authenticationModel);
			request.setAttribute("MessageRP", "Your Password reset successfull.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
		else
		{
			/*
			 * If password and confirm password are not same then redirects to the same page with error message.
			 */
			request.setAttribute("errorMessageRP", "Entered password and confirmPassword are not same.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("resetPassword.jsp");
			dispatcher.forward(request, response);
		}
	}

	}

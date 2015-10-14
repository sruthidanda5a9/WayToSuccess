package Business;
import Model.*;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import DTO.*;
import DataLayer.*;
import Repository.*;

public class AuthenticationBusiness {
	/*
	 * Verifing the authentication for Users
	 */
	AuthenticationInterface authenticationinterface = new AuthenticationDataLayer();
	public boolean  loginAuthenitication(AuthenticationDTO authenticationDTO)
	{
		/*
		 * We encrypted the passwords and we stored them in the database, so before comparing the passowrds we need to encrypt them again.
		 */
		authenticationDTO = encryptPasswordDTO(authenticationDTO);
		AuthenticationModel authenticationModel = authenticationinterface.getUsers(authenticationDTO.getUserName());
		if(authenticationModel.getUserName()!=null && authenticationModel.getUserName().equals(authenticationDTO.getUserName())
				&& authenticationModel.getPassword()!=null && authenticationModel.getPassword().equals(authenticationDTO.getPassword()))
		{
			authenticationDTO.setUserName(authenticationModel.getUserName());
			authenticationDTO.setPassword(authenticationModel.getPassword());
			return true;
		}
		else 
			return false;
	}
	public boolean courseStatusCheck(StudentModel studentModel)
	{
		
		/*
		 * This method retrives the status of each and every course.
		 */
		
		CourseStudentModel[] courseStudentModel = new CourseStudentModel[2];
		CourseStudentModel courseStudentModelOne = new CourseStudentModel();
		CourseStudentModel courseStudentModelTwo = new CourseStudentModel();
		courseStudentModel[0] = courseStudentModelOne;
		courseStudentModel[1] = courseStudentModelTwo;
		studentStatusDTO studentStatusDTO = new studentStatusDTO();
		StudentInterface studentDetails = new StudentDataLayer(); 
		CourseStudentInterface statusDetails = new CourseStudentDataLayer();
		studentModel = studentDetails.getStudentId(studentModel);
		studentModel = studentDetails.getCurrentLoginStudent(studentModel);
		courseStudentModel[0] = statusDetails.getCurrentStudentStatusOne(studentModel);
		studentStatusDTO.setCourseNameOne(courseStudentModel[0].progarmModel.getProgramName());
		studentStatusDTO.setStatusOne(courseStudentModel[0].statusModel.getStatusName());
		courseStudentModel[1] = statusDetails.getCurrentStudentStatusTwo(studentModel);
		studentStatusDTO.setCourseNameTwo(courseStudentModel[1].progarmModel.getProgramName());
		studentStatusDTO.setStatusTwo(courseStudentModel[1].statusModel.getStatusName()); 
		if(studentStatusDTO.getCourseNameOne() == null || studentStatusDTO.getStatusOne() == null  
				|| studentStatusDTO.getCourseNameTwo() ==null ||studentStatusDTO.getStatusTwo()==null)
		{
			return true;
		}
		else return false;
	}
	
	/*
	 * To verify the authetication for Career center
	 */
	
	public boolean  ccLoginAuthenitication(AuthenticationDTO authenticationDTO)
	{
		authenticationDTO = encryptPasswordDTO(authenticationDTO);
		AuthenticationModel authenticationModel = authenticationinterface.getUsers(authenticationDTO.getUserName());
		if(authenticationModel.getUserName()!=null && authenticationModel.getUserName().equals(authenticationDTO.getUserName()) &&
				authenticationDTO.getUserName().equals("way@wts.edu")
				&& authenticationModel.getPassword()!=null && 
				authenticationModel.getPassword().equals(authenticationDTO.getPassword()))
		{
			authenticationDTO.setUserName(authenticationModel.getUserName());
			authenticationDTO.setPassword(authenticationModel.getPassword());
			return true;
		}
		else 
			return false;
	}

	/*
	 * Method to encrypt the password.
	 */

	public AuthenticationModel encryptPassword(AuthenticationModel authenticationModel)
	{
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(authenticationModel.getPassword().getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			authenticationModel.setPassword(number.toString(16));
			while (authenticationModel.getPassword().length() < 32) {
				authenticationModel.setPassword("0" + authenticationModel.getPassword());
			}
			return authenticationModel;
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}
	public AuthenticationDTO encryptPasswordDTO(AuthenticationDTO authenticationModel)
	{
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(authenticationModel.getPassword().getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			authenticationModel.setPassword(number.toString(16));
			while (authenticationModel.getPassword().length() < 32) {
				authenticationModel.setPassword("0" + authenticationModel.getPassword());
			}
			return authenticationModel;
		}
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}

	}
}



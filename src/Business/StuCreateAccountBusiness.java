package Business;

import java.sql.ResultSet;
import java.sql.SQLException;

import Controller.StuCreateAccount;
import DTO.StuCreateAccountDTO;
import DataLayer.AuthenticationDataLayer;
import Model.AuthenticationModel;
import Repository.AuthenticationInterface;

/**
 * @author Sruthi Danda
 *
 */
public class StuCreateAccountBusiness {
	public boolean validatePassWord(StuCreateAccountDTO stuCreateAccountDTO)
	{
		if(stuCreateAccountDTO.getPassWord().equals(stuCreateAccountDTO.getConfirmPassWord()))
			/*
			 * checking password and confirm password both are equal or not.
			 */
		{
			return true;
		}
		else return false;
	}
	public boolean validate(StuCreateAccountDTO stuCreateAccountDTO) throws SQLException
	{
		
		/*
		 *To check  user is already in the data base or not.
		 */
		
		AuthenticationInterface authentication = new AuthenticationDataLayer();
		ResultSet myRes=authentication.getAllUsers();
		while(myRes.next())
		{
			if(myRes.getString("UserName").equals(stuCreateAccountDTO.getEmail()))
			{
				return false;
			}
		}
		return true;
	}

}

/**
 * 
 */
package Common;

import Controller.StuCreateAccount;
import DTO.StuCreateAccountDTO;

/**
 * @author Sruthi danda.
 *
 */
public class CreateAccountValidations {
	
	public boolean incompleteDetailsCheck(StuCreateAccountDTO stuCreateAccountDTO)
	{
		if ( stuCreateAccountDTO.getFirstName() == null || stuCreateAccountDTO.getLastName() == null
				|| stuCreateAccountDTO.getEmail() == null || stuCreateAccountDTO.getPassWord() == null
				|| stuCreateAccountDTO.getConfirmPassWord() == null )
		{
		return false;
		}
		else
			return true;
	}
	
	public boolean passwordVerification(StuCreateAccountDTO stuCreateAccountDTO)
	{
		String regularExpression = "(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%*]).{6,20}";
		if ( stuCreateAccountDTO.getPassWord().matches(regularExpression))
		{
		return true;
		}
		else
			return false;
	}

}

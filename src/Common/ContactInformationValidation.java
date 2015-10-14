/**
 * 
 */
package Common;

import DTO.ContactInformationDTO;

/**
 * @author Sruthi danda
 *
 */
public class ContactInformationValidation {
	
	/*
	 * For validation such that all the fields are filled properly or not.
	 */
	public boolean fillingDetails(ContactInformationDTO contactInformationDTO)
	{
		if( contactInformationDTO.getAddressLineOne() == null || contactInformationDTO.getCity() == null
				|| contactInformationDTO.getState() == null || contactInformationDTO.getStreet() == null 
				|| contactInformationDTO.getZipCode() == null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	public boolean validatingZipCode(ContactInformationDTO contactInformationDTO)
	{
		if( contactInformationDTO.getZipCode() != null && contactInformationDTO.getZipCode().length() == 5)
		{
			return true;
		}
		else
			return false;
	}
	public boolean validatingPhoneNumber( ContactInformationDTO contactInformationDTO)
	{
		String regularExpression = "\\d{10}";
		
		if ( contactInformationDTO.getHomePhoneNumber() != null && contactInformationDTO.getHomePhoneNumber().matches(regularExpression)
				&& contactInformationDTO.getStudentCellNumber() != null && contactInformationDTO.getStudentCellNumber().matches(regularExpression) )
			return true;
		else if( contactInformationDTO.getHomePhoneNumber() == null)
			return true;
		else if( contactInformationDTO.getStudentCellNumber() == null)
			return true;
		else 
			return false;
	}

}

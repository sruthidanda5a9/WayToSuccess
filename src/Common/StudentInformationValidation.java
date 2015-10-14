/**
 * 
 */
package Common;

import DTO.StuInformationDTO;

/**
 * @author Sruthi danda
 *
 */
public class StudentInformationValidation {
	
	public boolean fillingDetails(StuInformationDTO stuInformationDTO)
	{
		if ( stuInformationDTO.getCurrentGrade() == 0  || stuInformationDTO.getDOB() == null ||
				stuInformationDTO.getEthnicity() == 0 || stuInformationDTO.getFirstProgram() == 0 ||
				stuInformationDTO.getSecondProgram() == 0 || stuInformationDTO.getGender() == 0 )
		{
		return false;
		}
		
		else
			return true;
	}
	
	public boolean validateGPA(StuInformationDTO stuInformationDTO)
	{
		if ( stuInformationDTO.getGPA() >= 1 && stuInformationDTO.getGPA() <= 5 )
		{
			return true;
		}
		else
			return false;
	}

}

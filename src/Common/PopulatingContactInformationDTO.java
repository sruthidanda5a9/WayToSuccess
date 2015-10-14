/**
 * 
 */
package Common;

import DTO.ContactInformationDTO;
import DTO.StuInformationDTO;
import DataLayer.AddressDataLayer;
import DataLayer.CourseStudentDataLayer;
import Model.CourseStudentModel;
import Model.StudentModel;
import Repository.AddressInterface;
import Repository.CourseStudentInterface;

/**
 * @author sruthi.danda
 *
 */
public class PopulatingContactInformationDTO {
	
	/*
	 *Populates Contact information detials. 
	 */
	
	public ContactInformationDTO populatingDetails(StudentModel studentModel)
	{
		ContactInformationDTO contactInformationDTO = new ContactInformationDTO();
		AddressInterface addressDetails= new AddressDataLayer();
		studentModel.addressModel = addressDetails.getCurrentAddressID(studentModel); 
		contactInformationDTO.setAddressLineOne(studentModel.addressModel.getAddressLineOne());
		contactInformationDTO.setStreet(studentModel.addressModel.getStreet());
		contactInformationDTO.setCity(studentModel.addressModel.getCity());
		contactInformationDTO.setState(studentModel.addressModel.getState());
		contactInformationDTO.setZipCode(studentModel.addressModel.getZipCode());
		contactInformationDTO.setStudentCellNumber(studentModel.getCellNumber());
		contactInformationDTO.setHomePhoneNumber(studentModel.getHomePhone());
		return contactInformationDTO;
	}


}

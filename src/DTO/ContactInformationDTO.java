/**
 * 
 */
package DTO;

import java.io.Serializable;

/**
 * @author sruthi danda
 *
 */
public class ContactInformationDTO implements Serializable {
	private String addressLineOne;
	private String addressLineTwo;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String studentCellNumber;
	private String homePhoneNumber;
	private String additionalEmail;
	public String getAdditionalEmail() {
		return additionalEmail;
	}
	public void setAdditionalEmail(String additionalEmail) {
		this.additionalEmail = additionalEmail;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getStudentCellNumber() {
		return studentCellNumber;
	}
	public void setStudentCellNumber(String studentCellNumber) {
		this.studentCellNumber = studentCellNumber;
	}
	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}
	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

}

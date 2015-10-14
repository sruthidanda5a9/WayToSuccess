/**
 * 
 */
package DTO;

import java.io.Serializable;

/**
 * @author Sruthi danda
 *
 */
public class StudentVerificationDTO implements Serializable{
	private String firstName;
	private String lastName;
	private String addressLineOne;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String studentCellNumebr;
	private String studentHomePhone;
	private String currentSchool;
	private String currentGrade;
	private String programOne;
	private String programTwo;
	private String gender;
	private String ethnicity;
	private String DOB;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
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
	public String getStudentCellNumebr() {
		return studentCellNumebr;
	}
	public void setStudentCellNumebr(String studentCellNumebr) {
		this.studentCellNumebr = studentCellNumebr;
	}
	public String getStudentHomePhone() {
		return studentHomePhone;
	}
	public void setStudentHomePhone(String studentHomePhone) {
		this.studentHomePhone = studentHomePhone;
	}
	public String getCurrentSchool() {
		return currentSchool;
	}
	public void setCurrentSchool(String currentSchool) {
		this.currentSchool = currentSchool;
	}
	public String getCurrentGrade() {
		return currentGrade;
	}
	public void setCurrentGrade(String currentGrade) {
		this.currentGrade = currentGrade;
	}
	public String getProgramOne() {
		return programOne;
	}
	public void setProgramOne(String programOne) {
		this.programOne = programOne;
	}
	public String getProgramTwo() {
		return programTwo;
	}
	public void setProgramTwo(String programTwo) {
		this.programTwo = programTwo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
}

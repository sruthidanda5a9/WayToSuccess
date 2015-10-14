/**
 * 
 */
package Model;

import java.io.Serializable;

/**
 * @author Sruthi danda
 *
 */
public class SchoolModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int schoolID;
	private String schoolName;
	private String schoolPhoneNumber;
	private String schoolEmailAddress;
	private int authentication_AuthenticationID;
	public int getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public String getSchoolPhoneNumber() {
		return schoolPhoneNumber;
	}
	public void setSchoolPhoneNumber(String schoolPhoneNumber) {
		this.schoolPhoneNumber = schoolPhoneNumber;
	}
	public String getSchoolEmailAddress() {
		return schoolEmailAddress;
	}
	public void setSchoolEmailAddress(String schoolEmailAddress) {
		this.schoolEmailAddress = schoolEmailAddress;
	}
	public int getAuthentication_AuthenticationID() {
		return authentication_AuthenticationID;
	}
	public void setAuthentication_AuthenticationID(
			int authentication_AuthenticationID) {
		this.authentication_AuthenticationID = authentication_AuthenticationID;
	}

}

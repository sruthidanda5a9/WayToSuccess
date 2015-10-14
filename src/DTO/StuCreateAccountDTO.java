/**
 * 
 */
package DTO;

import java.io.Serializable;

/**
 * @author Sruthi danda
 *
 */
public class StuCreateAccountDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String firstName;
	public String middleInitial;
	public String lastName;
	public String email;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getConfirmPassWord() {
		return confirmPassWord;
	}
	public void setConfirmPassWord(String confirmPassWord) {
		this.confirmPassWord = confirmPassWord;
	}
	public String passWord;
	public String confirmPassWord;

}

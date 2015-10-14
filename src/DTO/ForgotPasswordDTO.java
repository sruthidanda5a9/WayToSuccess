/**
 * 
 */
package DTO;

import java.io.Serializable;

/**
 * @author Sruthi danda
 *
 */
public class ForgotPasswordDTO implements Serializable{
	
		private String userName;
		private String DOB;
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getDOB() {
			return DOB;
		}
		public void setDOB(String DOB) {
			this.DOB = DOB;
		}
	}


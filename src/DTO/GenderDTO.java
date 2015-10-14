package DTO;

import java.io.Serializable;

/**
 * @author sruthi danda
 *
 */
public class GenderDTO implements Serializable {
	private int genderID;
	private String genderName;
	public int getGenderID() {
		return genderID;
	}
	public void setGenderID(int genderID) {
		this.genderID = genderID;
	}
	public String getGenderName() {
		return genderName;
	}
	public void setGenderName(String genderName) {
		this.genderName = genderName;
	}

}

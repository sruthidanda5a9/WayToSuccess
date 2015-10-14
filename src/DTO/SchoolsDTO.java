package DTO;

import java.io.Serializable;
/**
 * @author sruthi danda
 *
 */
public class SchoolsDTO implements Serializable{
	private int schoolID;
	private String schoolName;
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
}

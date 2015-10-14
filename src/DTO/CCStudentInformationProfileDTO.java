/**
 * 
 */
package DTO;

import java.io.Serializable;

/**
 * @author sruthi danda.
 *
 */
public class CCStudentInformationProfileDTO implements Serializable{
	private int schoolID;
	private int currentGrade;
	private int firstProgram;
	private int secondProgram;
	private int gender;
	private String DOB;
	private int GPA;
	private int ethnicity;
	public int getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}
	public int getCurrentGrade() {
		return currentGrade;
	}
	public void setCurrentGrade(int currentGrade) {
		this.currentGrade = currentGrade;
	}
	public int getFirstProgram() {
		return firstProgram;
	}
	public void setFirstProgram(int firstProgram) {
		this.firstProgram = firstProgram;
	}
	public int getSecondProgram() {
		return secondProgram;
	}
	public void setSecondProgram(int secondProgram) {
		this.secondProgram = secondProgram;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public int getGPA() {
		return GPA;
	}
	public void setGPA(int gPA) {
		GPA = gPA;
	}
	public int getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(int ethnicity) {
		this.ethnicity = ethnicity;
	}
}

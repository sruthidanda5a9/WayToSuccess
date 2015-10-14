/**
 * 
 */
package DTO;

import java.io.Serializable;
/**
 * @author sruthi danda
 *
 */
public class StuInformationDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int schoolID;
	private int currentGrade;
	private int firstProgram;
	private int secondProgram;
	private int gender;
	private String DOB;
	private int GPA;
	private int ethnicity;
	private String studentFirstName;
	private String studentLastName;
	private String firstProgramName;
	private String firstProgramStatus;
	private String secondProgramName;
	private String secondProgramStatus;
	private int firstProgramRank;
	private int secondProgramRank;
	private int studentID;
	private int interviewNeeded;
	private String interviewStatus;
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public int getInterviewNeeded() {
		return interviewNeeded;
	}
	public void setInterviewNeeded(int interviewNeeded) {
		this.interviewNeeded = interviewNeeded;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public int getFirstProgramRank() {
		return firstProgramRank;
	}
	public void setFirstProgramRank(int firstProgramRank) {
		this.firstProgramRank = firstProgramRank;
	}
	public int getSecondProgramRank() {
		return secondProgramRank;
	}
	public void setSecondProgramRank(int secondProgramRank) {
		this.secondProgramRank = secondProgramRank;
	}
	public String getFirstProgramStatus() {
		return firstProgramStatus;
	}
	public void setFirstProgramStatus(String firstProgramStatus) {
		this.firstProgramStatus = firstProgramStatus;
	}
	public String getSecondProgramStatus() {
		return secondProgramStatus;
	}
	public void setSecondProgramStatus(String secondProgramStatus) {
		this.secondProgramStatus = secondProgramStatus;
	}
	public String getFirstProgramName() {
		return firstProgramName;
	}
	public void setFirstProgramName(String firstProgramName) {
		this.firstProgramName = firstProgramName;
	}
	public String getSecondProgramName() {
		return secondProgramName;
	}
	public void setSecondProgramName(String secondProgramName) {
		this.secondProgramName = secondProgramName;
	}
	public int getGPA() {
		return GPA;
	}
	public void setGPA(int gPA) {
		GPA = gPA;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String DOB) {
		this.DOB = DOB;
	}
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
	public int getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(int ethnicity) {
		this.ethnicity = ethnicity;
	}
	

}

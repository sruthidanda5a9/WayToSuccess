/**
 * 
 */
package DTO;

import java.io.Serializable;

/**
 * @author sruthi danda.
 *
 */
public class CCStudentOverviewDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String programName;
	private int schoolID;
	private int programm;
	private int GPA;
	private int interviewNeeded;
	private int grade;
	private String gradeValue;
	private String lastName;
	private String firstName;
	private String FirstProgram;
	private String interviewStatus;
	private int statusID;
	private String statusName;
	private int studentID;
	private String schoolName;
	private String SecondProgram;
	public String statusCheck[];
	private String status;
	private String userName;
	
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private boolean display;
	public boolean getDisplay() {
		return display;
	}
	public void setDisplay(boolean display) {
		this.display = display;
	}
	public String getGradeValue() {
		return gradeValue;
	}
	public void setGradeValue(String gradeValue) {
		this.gradeValue = gradeValue;
	}
	public int getStatusID() {
		return statusID;
	}
	public void setStatusID(int statusID) {
		this.statusID = statusID;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getFirstProgram() {
		return FirstProgram;
	}
	public void setFirstProgram(String firstProgram) {
		FirstProgram = firstProgram;
	}
	public String getSecondProgram() {
		return SecondProgram;
	}
	public void setSecondProgram(String secondProgram) {
		SecondProgram = secondProgram;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String[] getStatusCheck() {
		return statusCheck;
	}
	public void setStatusCheck(String[] statusCheck) {
		this.statusCheck = statusCheck;
	}
	public int getSchoolID() {
		return schoolID;
	}
	public void setSchoolID(int schoolID) {
		this.schoolID = schoolID;
	}
	public int getProgramm() {
		return programm;
	}
	public void setProgramm(int programm) {
		this.programm = programm;
	}
	public int getGPA() {
		return GPA;
	}
	public void setGPA(int gPA) {
		GPA = gPA;
	}
	public int getInterviewNeeded() {
		return interviewNeeded;
	}
	public void setInterviewNeeded(int interviewNeeded) {
		this.interviewNeeded = interviewNeeded;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
}

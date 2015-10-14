/**
 * 
 */
package DTO;

import java.io.Serializable;

/**
 * @author sruthi.danda
 *
 */
public class CCProgramsDTO implements Serializable{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int programID;
private int studentID;
 private String firstName;
 private String lastName;
 private String statusName;
 private String programName;
 private int placed;
 private int waitlist;
 private int applicants;
 private int firstChoice;
 private int secondChoice;
 private int choice;
public int getChoice() {
	return choice;
}
public int getStudentID() {
	return studentID;
}
public void setStudentID(int studentID) {
	this.studentID = studentID;
}
public void setChoice(int choice) {
	this.choice = choice;
}
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
public String getStatusName() {
	return statusName;
}
public void setStatusName(String statusName) {
	this.statusName = statusName;
}
public int getProgramID() {
	return programID;
}
public void setProgramID(int programID) {
	this.programID = programID;
}
public String getProgramName() {
	return programName;
}
public void setProgramName(String programName) {
	programName = programName;
}
public int getPlaced() {
	return placed;
}
public void setPlaced(int placed) {
	this.placed = placed;
}
public int getWaitlist() {
	return waitlist;
}
public void setWaitlist(int waitlist) {
	this.waitlist = waitlist;
}
public int getApplicants() {
	return applicants;
}
public void setApplicants(int applicants) {
	this.applicants = applicants;
}
public int getFirstChoice() {
	return firstChoice;
}
public void setFirstChoice(int firstChoice) {
	this.firstChoice = firstChoice;
}
public int getSecondChoice() {
	return secondChoice;
}
public void setSecondChoice(int secondChoice) {
	this.secondChoice = secondChoice;
}
 
}

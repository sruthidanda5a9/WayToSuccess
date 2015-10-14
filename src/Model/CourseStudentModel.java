/**
 * 
 */
package Model;

import java.io.Serializable;

/**
 * @author sruthi danda
 *
 */
public class CourseStudentModel implements Serializable {
	public ProgramModel progarmModel = new ProgramModel();
	//public StudentModel studentModel = new StudentModel();
	public StatusModel statusModel = new StatusModel();
	private int choice;
	private int rank;
	private int studentID;
	private int interviewGrade;
	public int getInterviewGrade() {
		return interviewGrade;
	}
	public void setInterviewGrade(int interviewGrade) {
		this.interviewGrade = interviewGrade;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentId) {
		this.studentID = studentId;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}

}

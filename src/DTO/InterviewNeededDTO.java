/**
 * 
 */
package DTO;

import java.io.Serializable;

/**
 * @author sruthi danda
 *
 */
public class InterviewNeededDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int interviewID;
	private String interviewStatus;
	public int getInterviewID() {
		return interviewID;
	}
	public void setInterviewID(int interviewID) {
		this.interviewID = interviewID;
	}
	public String getInterviewStatus() {
		return interviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		this.interviewStatus = interviewStatus;
	}
	}

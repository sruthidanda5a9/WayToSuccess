/**
 * 
 */
package Model;

import java.io.Serializable;

/**
 * @author sruthi danda
 *
 */
public class InterviewNeededModel implements Serializable {
	private int interviewID;
	private String InterviewStatus;
	public int getInterviewID() {
		return interviewID;
	}
	public void setInterviewID(int interviewID) {
		this.interviewID = interviewID;
	}
	public String getInterviewStatus() {
		return InterviewStatus;
	}
	public void setInterviewStatus(String interviewStatus) {
		InterviewStatus = interviewStatus;
	}
	}

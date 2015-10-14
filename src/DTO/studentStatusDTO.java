package DTO;

import java.io.Serializable;

public class studentStatusDTO implements Serializable {
	private String courseNameOne;
	private String statusOne;
	private String courseNameTwo;
	private String statusTwo;
	private String userName;
	public String getCourseNameOne() {
		return courseNameOne;
	}
	public void setCourseNameOne(String courseNameOne) {
		this.courseNameOne = courseNameOne;
	}
	public String getStatusOne() {
		return statusOne;
	}
	public void setStatusOne(String statusOne) {
		this.statusOne = statusOne;
	}
	public String getCourseNameTwo() {
		return courseNameTwo;
	}
	public void setCourseNameTwo(String courseNameTwo) {
		this.courseNameTwo = courseNameTwo;
	}
	public String getStatusTwo() {
		return statusTwo;
	}
	public void setStatusTwo(String statusTwo) {
		this.statusTwo = statusTwo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}

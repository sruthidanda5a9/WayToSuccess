package Model;

import java.io.Serializable;

/**
 * @author sruthi danda
 *
 */
public class CurrentGradeModel implements Serializable {
	private int currentGradeId;
	private String currentGrade;
	public int getCurrentGradeId() {
		return currentGradeId;
	}
	public void setCurrentGradeId(int currentGradeId) {
		this.currentGradeId = currentGradeId;
	}
	public String getCurrentGrade() {
		return currentGrade;
	}
	public void setCurrentGrade(String currentGrade) {
		this.currentGrade = currentGrade;
	}

}

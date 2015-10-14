package Model;

import java.io.Serializable;

/**
 * @author sruthi danda
 *
 */
public class ProgramModel implements Serializable{
	private int programID;
	private String programName;
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
		this.programName = programName;
	}

}

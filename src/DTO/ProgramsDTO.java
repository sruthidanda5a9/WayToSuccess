package DTO;

import java.io.Serializable;
/**
 * @author sruthi danda
 *
 */
public class ProgramsDTO implements Serializable {
	private int progarmID;
	private String programName;
	public int getProgarmID() {
		return progarmID;
	}
	public void setProgarmID(int progarmID) {
		this.progarmID = progarmID;
	}
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
}

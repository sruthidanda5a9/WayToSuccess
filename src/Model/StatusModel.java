/**
 * 
 */
package Model;

import java.io.Serializable;

/**
 * @author sruthi danda
 *
 */
public class StatusModel implements Serializable{
	private int statusID;
	private String statusName;
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

}

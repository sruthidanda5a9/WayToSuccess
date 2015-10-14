/**
 * 
 */
package DTO;

import java.io.Serializable;

/**
 * @author sruthi danda
 *
 */
public class EthnicityDTO implements Serializable{
 private int ethnicityID;
 private String ethnicityName;
public int getEthnicityID() {
	return ethnicityID;
}
public void setEthnicityID(int ethnicityID) {
	this.ethnicityID = ethnicityID;
}
public String getEthnicityName() {
	return ethnicityName;
}
public void setEthnicityName(String ethnicityName) {
	this.ethnicityName = ethnicityName;
}
}

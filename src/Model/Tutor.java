package Model;
/**
 * @author sruthi danda
 *
 */
public class Tutor {
	private String tutorFirstName;
	private String tutorLastName;
	public String getTutorLastName() {
		return tutorLastName;
	}
	public void setTutorLastName(String tutorLastName) {
		this.tutorLastName = tutorLastName;
	}
	public String getTutorName() {
		return tutorFirstName;
	}
	public void setTutorName(String tutorFirstName) {
		this.tutorFirstName = tutorFirstName;
	}
	public String getTutorEmailId() {
		return tutorEmailId;
	}
	public void setTutorEmailId(String tutorEmailId) {
		this.tutorEmailId = tutorEmailId;
	}
	public String getTutorCellNumber() {
		return tutorCellNumber;
	}
	public void setTutorCellNumber(String tutorCellNumber) {
		this.tutorCellNumber = tutorCellNumber;
	}
	private String tutorEmailId;
	private String tutorCellNumber;
}

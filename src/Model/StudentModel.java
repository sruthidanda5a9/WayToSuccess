package Model;
import java.io.Serializable;
import java.util.Date;
public class StudentModel implements Serializable {
	/**
	 * @author sruthi danda
	 *
	 */
	private static final long serialVersionUID = 1L;
	public StatusModel statusModel = new StatusModel();
	public AddressModel addressModel = new AddressModel();
	public EthnicityModel ethnicityModel = new EthnicityModel();
	public GenderModel genderModel = new GenderModel();
	public CurrentGradeModel gradeModel =  new CurrentGradeModel();
	public SchoolModel schoolModel = new SchoolModel();
	public InterviewNeededModel interviewNeededModel = new InterviewNeededModel();
	public CourseStudentModel courseStudentModel = new CourseStudentModel();
	public HomeSchoolContactModel homeSchoolContactModel =  new HomeSchoolContactModel();
	public AuthenticationModel authenticationModel =  new AuthenticationModel();
	public int interviewGrde;
	private int studentID;
	private String cellNumber;
	private String homePhone;
	private String firstName;
	private String lastName;
	private String middileInitial;
	private String DOB;
	private int ethnticity; 
	private int currentSchool;
	private int currentGPA;
	private String studentEmailID;
	private int currentGrade;
	private int gender;
	private int interviewNeeded;
	public int getInterviewNeeded() {
		return interviewNeeded;
	}
	public void setInterviewNeeded(int interviewNeeded) {
		this.interviewNeeded = interviewNeeded;
	}
	public AddressModel getAddressModel() {
		return addressModel;
	}
	public void setAddressModel(AddressModel addressModel) {
		this.addressModel = addressModel;
	}
	public EthnicityModel getEthnicityModel() {
		return ethnicityModel;
	}
	public void setEthnicityModel(EthnicityModel ethnicityModel) {
		this.ethnicityModel = ethnicityModel;
	}
	public GenderModel getGenderModel() {
		return genderModel;
	}
	public void setGenderModel(GenderModel genderModel) {
		this.genderModel = genderModel;
	}
	public CurrentGradeModel getGradeModel() {
		return gradeModel;
	}
	public void setGradeModel(CurrentGradeModel gradeModel) {
		this.gradeModel = gradeModel;
	}
	public SchoolModel getSchoolModel() {
		return schoolModel;
	}
	public void setSchoolModel(SchoolModel schoolModel) {
		this.schoolModel = schoolModel;
	}
	
	public int getGender() {
		return gender;
	}
	public int getStudentID() {
		return studentID;
	}

	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getCurrentGrade() {
		return currentGrade;
	}
	public void setCurrentGrade(int currentGrade) {
		this.currentGrade = currentGrade;
	}
	public String getStudentEmailID() {
		return studentEmailID;
	}
	public void setStudentEmailID(String studentEmailID) {
		this.studentEmailID = studentEmailID;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMiddileInitial() {
		return middileInitial;
	}
	public void setMiddileInitial(String middileInitial) {
		this.middileInitial = middileInitial;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public int getEthnticity() {
		return ethnticity;
	}
	public void setEthnticity(int ethnticity) {
		this.ethnticity = ethnticity;
	}	
	public int getCurrentSchool() {
		return currentSchool;
	}
	public void setCurrentSchool(int currentSchool) {
		this.currentSchool = currentSchool;
	}
	public int getCurrentGPA() {
		return currentGPA;
	}
	public void setCurrentGPA(int currentGPA) {
		this.currentGPA = currentGPA;
	}
	public String getCellNumber() {
		return cellNumber;
	}
	public void setCellNumber(String cellNumber) {
		this.cellNumber = cellNumber;
	}
	public String getHomePhone() {
		return homePhone;
	}
	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}
	public int getInterviewGrde() {
		return interviewGrde;
	}
	public void setInterviewGrde(int interviewGrde) {
		this.interviewGrde = interviewGrde;
	}
	
	
}

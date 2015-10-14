/**
 * 
 */
package Repository;

import java.util.ArrayList;

import Model.AddressModel;
import Model.AuthenticationModel;
import Model.CourseStudentModel;
import Model.StudentModel;

/**
 * @author sruthi danda
 *
 */
public interface StudentInterface {
	public void insert(StudentModel studentModel);
	public void update(StudentModel studentModel);
	public StudentModel getStudentId(StudentModel studentModel); 
	public void insertAddressID(StudentModel studentModel);
	public StudentModel getCurrentStudent(StudentModel studentModel);
	public StudentModel getCurrentLoginStudent(StudentModel studentModel);
	public ArrayList<StudentModel> getCCStudentOverview(StudentModel studentModel);
	public void insertInterview(StudentModel studentModel);
	public ArrayList<StudentModel> getHomeSchoolStuendts(StudentModel studentModel);
	public StudentModel getDOB(AuthenticationModel authenticationModel);
}

/**
 * 
 */
package Repository;

import java.util.List;

import Model.CourseStudentModel;
import Model.ProgramModel;
import Model.StudentModel;

/**
 * @author sruthi danda
 *
 */
public interface ProgramInterface {
	public List<ProgramModel> getAllPrograms();
	public void insert(ProgramModel ProgarmModel);
}

/**
 * 
 */
package Repository;
import Model.InterviewNeededModel;
import Model.StudentModel;

import java.util.*;
/**
 * @author sruthi danda
 *
 */
public interface InterviewNeededIntrface {
	
		public List<InterviewNeededModel> getAllInterviewStatus();
		public StudentModel getInterviewNeeded(StudentModel studentModel);
}

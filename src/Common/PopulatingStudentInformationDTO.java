/**
 * 
 */
package Common;

import java.io.Serializable;

import javax.servlet.http.HttpSession;

import DTO.StuInformationDTO;
import DataLayer.CourseStudentDataLayer;
import DataLayer.StudentDataLayer;
import Model.CourseStudentModel;
import Model.ProgramModel;
import Model.StudentModel;
import Repository.CourseStudentInterface;
import Repository.StudentInterface;

/**
 * @author sruthi danda
 *
 */
public class PopulatingStudentInformationDTO implements  Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2632853562105876147L;

	public StuInformationDTO populatingDetails(StudentModel studentModel)
	{
		StudentInterface studentDetails = new StudentDataLayer();
		studentModel = studentDetails.getCurrentLoginStudent(studentModel);
		CourseStudentInterface statusDetails = new CourseStudentDataLayer(); 
		CourseStudentModel[] courseStudentModel = new CourseStudentModel[2];
		CourseStudentModel courseStudentModelOne = new CourseStudentModel();
		CourseStudentModel courseStudentModelTwo = new CourseStudentModel();
		courseStudentModel[0] = courseStudentModelOne;
		courseStudentModel[1] = courseStudentModelTwo;
		courseStudentModel[0] = statusDetails.getCurrentStudentCourseOne(studentModel);
		courseStudentModel[1] = statusDetails.getCurrentStudentCourseTwo(studentModel);
		StuInformationDTO stuInformationDTO = new StuInformationDTO();
		stuInformationDTO.setStudentID(studentModel.getStudentID());
		stuInformationDTO.setStudentFirstName(studentModel.getFirstName());
		stuInformationDTO.setStudentLastName(studentModel.getLastName());
		stuInformationDTO.setSchoolID(studentModel.schoolModel.getSchoolID());
		stuInformationDTO.setCurrentGrade(studentModel.getCurrentGrade());
		stuInformationDTO.setFirstProgram(courseStudentModel[0].progarmModel.getProgramID());
		stuInformationDTO.setFirstProgramName(courseStudentModel[0].progarmModel.getProgramName());
		stuInformationDTO.setFirstProgramRank(courseStudentModel[0].getRank());
		stuInformationDTO.setSecondProgram(courseStudentModel[1].progarmModel.getProgramID());
		stuInformationDTO.setSecondProgramName(courseStudentModel[1].progarmModel.getProgramName());
		stuInformationDTO.setSecondProgramRank(courseStudentModel[1].getRank());
		stuInformationDTO.setGender(studentModel.genderModel.getGenderID());
		stuInformationDTO.setEthnicity(studentModel.ethnicityModel.getEthnicityID());
		stuInformationDTO.setDOB(studentModel.getDOB());
		stuInformationDTO.setGPA(studentModel.getCurrentGPA());
		stuInformationDTO.setInterviewNeeded(studentModel.getInterviewNeeded());
		stuInformationDTO.setInterviewStatus(studentModel.interviewNeededModel.getInterviewStatus());
		stuInformationDTO.setFirstProgramStatus(courseStudentModel[0].statusModel.getStatusName());
		stuInformationDTO.setSecondProgramStatus(courseStudentModel[1].statusModel.getStatusName());
		return stuInformationDTO;
	}
	public StuInformationDTO populatingDetailsStatus(StudentModel studentModel)
	{
		StudentInterface studentDetails = new StudentDataLayer();
		studentModel = studentDetails.getCurrentLoginStudent(studentModel);
		CourseStudentInterface statusDetails = new CourseStudentDataLayer(); 
		CourseStudentModel[] courseStudentModel = new CourseStudentModel[2];
		CourseStudentModel courseStudentModelOne = new CourseStudentModel();
		CourseStudentModel courseStudentModelTwo = new CourseStudentModel();
		courseStudentModel[0] = courseStudentModelOne;
		courseStudentModel[1] = courseStudentModelTwo;
		courseStudentModel[0] = statusDetails.getCurrentStudentCourseOneStatus(studentModel);
		courseStudentModel[1] = statusDetails.getCurrentStudentCourseTwoStatus(studentModel);
		StuInformationDTO stuInformationDTO = new StuInformationDTO();
		stuInformationDTO.setStudentID(studentModel.getStudentID());
		stuInformationDTO.setSchoolID(studentModel.schoolModel.getSchoolID());
		stuInformationDTO.setCurrentGrade(studentModel.getCurrentGrade());
		stuInformationDTO.setFirstProgram(courseStudentModel[0].progarmModel.getProgramID());
		stuInformationDTO.setFirstProgramName(courseStudentModel[0].progarmModel.getProgramName());
		stuInformationDTO.setFirstProgramStatus(courseStudentModel[0].statusModel.getStatusName());
		stuInformationDTO.setFirstProgramRank(courseStudentModel[0].getRank());
		stuInformationDTO.setSecondProgram(courseStudentModel[1].progarmModel.getProgramID());
		stuInformationDTO.setSecondProgramName(courseStudentModel[1].progarmModel.getProgramName());
		stuInformationDTO.setSecondProgramStatus(courseStudentModel[1].statusModel.getStatusName());
		stuInformationDTO.setSecondProgramRank(courseStudentModel[1].getRank());
		stuInformationDTO.setGender(studentModel.genderModel.getGenderID());
		stuInformationDTO.setEthnicity(studentModel.ethnicityModel.getEthnicityID());
		stuInformationDTO.setDOB(studentModel.getDOB());
		stuInformationDTO.setGPA(studentModel.getCurrentGPA());
		stuInformationDTO.setInterviewNeeded(studentModel.interviewNeededModel.getInterviewID());
		stuInformationDTO.setInterviewStatus(studentModel.interviewNeededModel.getInterviewStatus());
		stuInformationDTO.setStudentFirstName(studentModel.getFirstName());
		stuInformationDTO.setStudentLastName(studentModel.getLastName());
		return stuInformationDTO;
	}
	

}

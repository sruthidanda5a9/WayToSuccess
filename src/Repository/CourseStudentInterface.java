package Repository;

import java.util.ArrayList;

import Controller.CCStudentOverview;
import DTO.CCProgramsDTO;
import DTO.CCStudentOverviewDTO;
import Model.CourseStudentModel;
import Model.StudentModel;

/*
 * @author : sruthi danda
 */
public interface CourseStudentInterface {
	public void insert(CourseStudentModel courseStudentModel);
	public CourseStudentModel getCurrentStudentCourseOne(StudentModel studentModel);
	public CourseStudentModel getCurrentStudentCourseTwo(StudentModel studentModel);
	public void updateStatus(CourseStudentModel courseStudentModel);
	public CourseStudentModel getCurrentStudentStatusOne(StudentModel studetModel);
	public CourseStudentModel  getCurrentStudentStatusTwo(StudentModel studetModel);
	public ArrayList<CourseStudentModel> getStudentCourseTwo(ArrayList<CCStudentOverviewDTO> ccStudentOverview);
	public ArrayList<CourseStudentModel> getStudentCourseOne(ArrayList<CCStudentOverviewDTO> ccStudentOverview);
	public CCProgramsDTO getProgramDetails(CCProgramsDTO ccProgramsDTO);
	public ArrayList<StudentModel> getCourseStudentDetails(CCProgramsDTO ccProgramsDTO);
	public void updateCourseDetails(CourseStudentModel courseStudentModel);
	public ArrayList<StudentModel> getwaitListedStudents(CourseStudentModel courseStudent);
	public void updateRank(StudentModel studentModel);
	public CourseStudentModel getRankOfStudent(CourseStudentModel courseStudentModel);
	public CourseStudentModel getCurrentStudentCourseOneStatus(StudentModel studentModel);
	public CourseStudentModel getCurrentStudentCourseTwoStatus(StudentModel studentModel);
	public void insertInterviewGrade(CourseStudentModel courseStudentModel);
}

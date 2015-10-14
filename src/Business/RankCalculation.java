/**
 * 
 */
package Business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import DataLayer.CourseStudentDataLayer;
import DataLayer.StudentDataLayer;
import Model.CourseStudentModel;
import Model.StudentModel;
import Repository.CourseStudentInterface;
import Repository.StudentInterface;

/**
 * @author sruthi danda
 *
 */
public class RankCalculation {

	/*
	 * findRank :  Caluclates the ranks of waitlisted students.
	 */

	public void findRank(CourseStudentModel courseStudent)
	{
		CourseStudentInterface details = new CourseStudentDataLayer();
		ArrayList<CourseStudentModel> courseStudentModel = new ArrayList<CourseStudentModel>();
		ArrayList<StudentModel> studentModel = new ArrayList<StudentModel>();
		StudentInterface getData = new StudentDataLayer();

		/*
		 * getwaitListedStudents  :  Retrives the waitlisted students in sorted order according to there
		 *  interview garde and GPA.
		 * 
		 */

		studentModel = details.getwaitListedStudents(courseStudent);

		/*
		 *   caluclate the ranks based on GPA and interview grade
		 */

		for(int k = 0 ;k<studentModel.size();k++)
		{
			studentModel.get(k).courseStudentModel.setRank(k+1);
			details.updateRank(studentModel.get(k));
		}
	}

}

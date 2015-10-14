/**
 * 
 */
package Common;

import java.util.ArrayList;

import DTO.CCStudentOverviewDTO;
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
public class PopulatingCCStudentOverView {
	public 	ArrayList<CCStudentOverviewDTO> getDetails(CCStudentOverviewDTO ccStudentOverviewDTO)
	{
		/*
		 *Populates complte details of students who applied for careercenter. 
		 */
		
		StudentModel studentModel = new StudentModel();
		ArrayList<StudentModel> studentOverView = new ArrayList<StudentModel>();
		ArrayList<CCStudentOverviewDTO> ccStudentOverview = new ArrayList<CCStudentOverviewDTO>();
		StudentInterface studentDetails = new StudentDataLayer();
		studentModel.setCurrentGPA(ccStudentOverviewDTO.getGPA());
		studentModel.setCurrentGrade(ccStudentOverviewDTO.getGrade());
		studentModel.setCurrentSchool(ccStudentOverviewDTO.getSchoolID());
		studentModel.setInterviewNeeded(ccStudentOverviewDTO.getInterviewNeeded());
		studentModel.statusModel.setStatusID(ccStudentOverviewDTO.getStatusID());
		studentModel.schoolModel.setSchoolID(ccStudentOverviewDTO.getSchoolID());
		studentOverView = studentDetails.getCCStudentOverview(studentModel);
		for(int i =0; i<studentOverView.size() ;i++)
		{
			CCStudentOverviewDTO ccStudentOverviewDTODetails = new CCStudentOverviewDTO();
			ccStudentOverviewDTODetails.setStudentID(studentOverView.get(i).getStudentID());
			ccStudentOverviewDTODetails.setFirstName(studentOverView.get(i).getFirstName());
			ccStudentOverviewDTODetails.setLastName(studentOverView.get(i).getLastName());
			ccStudentOverviewDTODetails.setGPA(studentOverView.get(i).getCurrentGPA());
			ccStudentOverviewDTODetails.setGrade(studentOverView.get(i).getCurrentGrade());
			ccStudentOverviewDTODetails.setSchoolName(studentOverView.get(i).getSchoolModel().getSchoolName());
			ccStudentOverviewDTODetails.setGradeValue(studentOverView.get(i).gradeModel.getCurrentGrade());
			ccStudentOverviewDTODetails.setStatusName(studentOverView.get(i).statusModel.getStatusName());
			ccStudentOverviewDTODetails.setProgramName(studentOverView.get(i).courseStudentModel.progarmModel.getProgramName());
			ccStudentOverview.add(ccStudentOverviewDTODetails);
		}
		return ccStudentOverview;
	}
	


}

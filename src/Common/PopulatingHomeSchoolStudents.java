/**
 * 
 */
package Common;

import java.util.ArrayList;

import DTO.CCStudentOverviewDTO;
import DataLayer.StudentDataLayer;
import Model.StudentModel;
import Repository.StudentInterface;

/**
 * @author sruthi danda
 *
 */
public class PopulatingHomeSchoolStudents {
	public 	ArrayList<CCStudentOverviewDTO> getHomeSchoolApproval(CCStudentOverviewDTO ccStudentOverviewDTO)
	{
		/*
		 * Getting the list of students who requires Home school approval
		 */
		
		StudentModel studentModel = new StudentModel();
		ArrayList<StudentModel> studentOverView = new ArrayList<StudentModel>();
		ArrayList<CCStudentOverviewDTO> ccStudentOverview = new ArrayList<CCStudentOverviewDTO>();
		StudentInterface studentDetails = new StudentDataLayer();
		studentModel.authenticationModel.setUserName(ccStudentOverviewDTO.getUserName());
		studentModel.setInterviewNeeded(ccStudentOverviewDTO.getInterviewNeeded());
		studentOverView = studentDetails.getHomeSchoolStuendts(studentModel);
		for(int i =0; i<studentOverView.size() ;i++)
		{
			CCStudentOverviewDTO ccStudentOverviewDTODetails = new CCStudentOverviewDTO();
			ccStudentOverviewDTODetails.setStudentID(studentOverView.get(i).getStudentID());
			ccStudentOverviewDTODetails.setFirstName(studentOverView.get(i).getFirstName());
			ccStudentOverviewDTODetails.setLastName(studentOverView.get(i).getLastName());
			ccStudentOverviewDTODetails.setGPA(studentOverView.get(i).getCurrentGPA());
			ccStudentOverviewDTODetails.setGrade(studentOverView.get(i).getCurrentGrade());
			ccStudentOverviewDTODetails.setGradeValue(studentOverView.get(i).gradeModel.getCurrentGrade());
			ccStudentOverviewDTODetails.setStatusName(studentOverView.get(i).statusModel.getStatusName());
			ccStudentOverviewDTODetails.setProgramName(studentOverView.get(i).courseStudentModel.progarmModel.getProgramName());
			ccStudentOverview.add(ccStudentOverviewDTODetails);
		}
		return ccStudentOverview;
	}

}

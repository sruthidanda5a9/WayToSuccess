/**
 * 
 */
package Common;

import java.util.ArrayList;
import java.util.List;

import DTO.CurrentGradeDTO;
import DTO.EthnicityDTO;
import DTO.ForgotPasswordDTO;
import DTO.GenderDTO;
import DTO.InterviewNeededDTO;
import DTO.ProgramsDTO;
import DTO.SchoolsDTO;
import DataLayer.CurrentGradeDataLayer;
import DataLayer.EthnicityDataLayer;
import DataLayer.GenderDataLayer;
import DataLayer.InterviewNeedeDataLayer;
import DataLayer.ProgramDataLayer;
import DataLayer.SchoolDataLayer;
import DataLayer.StudentDataLayer;
import Model.AuthenticationModel;
import Model.CurrentGradeModel;
import Model.EthnicityModel;
import Model.GenderModel;
import Model.InterviewNeededModel;
import Model.ProgramModel;
import Model.SchoolModel;
import Model.StudentModel;
import Repository.CurrentGradeInterface;
import Repository.EthnicityInterface;
import Repository.GenderInterface;
import Repository.InterviewNeededIntrface;
import Repository.ProgramInterface;
import Repository.SchoolInterface;
import Repository.StudentInterface;

/**
 * @author sruthi danda
 *
 */
public class PopulatingStudentInformation {
	public ArrayList<SchoolsDTO> populatingSchool()
	{
		SchoolInterface studentDetails = new SchoolDataLayer();
		List<SchoolModel> schoolModel = new ArrayList<SchoolModel>();
		ArrayList<SchoolsDTO> schools = new ArrayList<SchoolsDTO>();
		schoolModel = studentDetails.getAllSchools();
		for(int i=0;i<schoolModel.size();i++)
		{
			SchoolsDTO schoolDTO = new SchoolsDTO();
			schoolDTO.setSchoolID(schoolModel.get(i).getSchoolID());
			schoolDTO.setSchoolName(schoolModel.get(i).getSchoolName());
			schools.add(schoolDTO);
			/*
			 * assigning Schoolmodal arraylist values to schoolsDTO to transfer to the jsp page.
			 */
		}
		return schools;
	}
	
		public ArrayList<ProgramsDTO> populatingProgram()
		{
		ProgramInterface programDetails = new ProgramDataLayer();
		List<ProgramModel> programModel = new ArrayList<ProgramModel>();
		ArrayList<ProgramsDTO> programs = new ArrayList<ProgramsDTO>();
		programModel = programDetails.getAllPrograms();
		for(int i=0;i<programModel.size();i++)
		{
			ProgramsDTO programDTO = new ProgramsDTO();
			programDTO.setProgarmID(programModel.get(i).getProgramID());
			programDTO.setProgramName(programModel.get(i).getProgramName());
			programs.add(programDTO);
			/*
			 * assigning program modal arraylist values to programsDTO to transfer to the jsp page.
			 */
		}
		return programs;
		}
		public ArrayList<GenderDTO> populatingGender()
		{
		GenderInterface genderDetails = new GenderDataLayer();
		List<GenderModel> genderModel = new ArrayList<GenderModel>();
		ArrayList<GenderDTO> gender = new ArrayList<GenderDTO>();
		genderModel = genderDetails.getAllGenders();
		for(int i=0;i<genderModel.size();i++)
		{
			GenderDTO genderDTO = new GenderDTO();
			genderDTO.setGenderID(genderModel.get(i).getGenderID());
			genderDTO.setGenderName(genderModel.get(i).getGenderName());
			gender.add(genderDTO);
			/*
			 * assigning gender modal arraylist values to genderDTO to transfer to the jsp page.
			 */
		}
		return gender;
		}
		public ArrayList<EthnicityDTO> populatingEthnicity()
		{
		EthnicityInterface ethnicityDetails = new EthnicityDataLayer();
		List<EthnicityModel> ethnicityModel = new ArrayList<EthnicityModel>();
		ArrayList<EthnicityDTO> ethnicity = new ArrayList<EthnicityDTO>();
		ethnicityModel = ethnicityDetails.getAllEthnicity();
		for(int i=0;i<ethnicityModel.size();i++)
		{
			EthnicityDTO ethnicityDTO = new EthnicityDTO();
			ethnicityDTO.setEthnicityID(ethnicityModel.get(i).getEthnicityID());
			ethnicityDTO.setEthnicityName(ethnicityModel.get(i).getEthnicityName());
			ethnicity.add(ethnicityDTO);
			/*
			 * assigning ethnicity modal arraylist values to ethnicityDTO to transfer to the jsp page.
			 */
		}
		return ethnicity;
		}
		public ArrayList<CurrentGradeDTO> populatingGrade()
		{
		CurrentGradeInterface gradeDetails = new CurrentGradeDataLayer();
		List<CurrentGradeModel> currentGradeModel = new ArrayList<CurrentGradeModel>();
		ArrayList<CurrentGradeDTO> grade = new ArrayList<CurrentGradeDTO>();
		currentGradeModel = gradeDetails.getAllGrades();
		for(int i=0;i<currentGradeModel.size();i++)
		{
			CurrentGradeDTO currentGradeDTO = new CurrentGradeDTO();
			currentGradeDTO.setCurrentGradeId(currentGradeModel.get(i).getCurrentGradeId());
			currentGradeDTO.setCurrentGrade(currentGradeModel.get(i).getCurrentGrade());
			grade.add(currentGradeDTO);
			/*
			 * assigning Grade modal arraylist values to gradeDTO to transfer to the jsp page.
			 */
		}
		return grade;
		}
		public ArrayList<InterviewNeededDTO> populatingInterviewNeeded()
		{
			/*
			 * Assigning interviewNeededModel arraylist values to interviewNeededDTO to transfer to the JSP PAGE.
			 */
			InterviewNeededIntrface interviewNeededDetails = new InterviewNeedeDataLayer();
			List<InterviewNeededModel> interviewNeededModel = new ArrayList<InterviewNeededModel>();
			ArrayList<InterviewNeededDTO> interviewNeeded = new ArrayList<InterviewNeededDTO>();
			interviewNeededModel = interviewNeededDetails.getAllInterviewStatus();
			for(int i=0;i<interviewNeededModel.size();i++)
			{
				InterviewNeededDTO interviewNeededDTO = new InterviewNeededDTO();
				interviewNeededDTO.setInterviewID(interviewNeededModel.get(i).getInterviewID());
				interviewNeededDTO.setInterviewStatus(interviewNeededModel.get(i).getInterviewStatus());
				interviewNeeded.add(interviewNeededDTO);
				/*
				 * assigning Grade modal arraylist values to gradeDTO to transfer to the jsp page.
				 */
			}
			return interviewNeeded;
		}
		public boolean validateDOB(ForgotPasswordDTO forgotPassword)
		{
			/*
			 * For resetting the password if you forgot it this is security validation
			 */
			StudentInterface studentDetails = new StudentDataLayer();
			StudentModel studentModel = new StudentModel();
			AuthenticationModel authenticationModel = new AuthenticationModel();
			authenticationModel.setUserName(forgotPassword.getUserName());
			studentModel = studentDetails.getDOB(authenticationModel);
			if( studentModel.getDOB() == null && forgotPassword.getDOB() == "")
			{
				return true;
			}
			if (studentModel.getDOB() != null && forgotPassword.getDOB() != "" && studentModel.getDOB().equals( forgotPassword.getDOB()))
			{
				return true;
			}
			else
				return false;
		}
	}



/**
 * 
 */
package Business;

import DataLayer.InterviewNeedeDataLayer;
import Model.StudentModel;
import Repository.InterviewNeededIntrface;

/**
 * @author Sruthi danda
 *
 */
public class WaitStatusEligibility {
	
	/*
	 * Check the eligibility of student to place them in waitlist
	 */
	
	public boolean eligibility(StudentModel studentModel)
	{
		InterviewNeededIntrface interviewDetails = new InterviewNeedeDataLayer();
		studentModel = interviewDetails.getInterviewNeeded(studentModel);
		if(studentModel.getInterviewNeeded() != 0 && studentModel.getInterviewNeeded() == 2  )
		{
		return true;
		}
		else
			return false;
		
	}
}

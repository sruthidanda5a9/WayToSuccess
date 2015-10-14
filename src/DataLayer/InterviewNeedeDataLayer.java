/**
 * 
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.InterviewNeededModel;
import Model.ProgramModel;
import Model.StudentModel;
import Repository.InterviewNeededIntrface;

/**
 * @author sruthi danda.
 *
 */
public class InterviewNeedeDataLayer implements InterviewNeededIntrface {

	@Override
	public List<InterviewNeededModel> getAllInterviewStatus() {
		// TODO Auto-generated method stub
		ArrayList<InterviewNeededModel> interviewNeededModel = new ArrayList<InterviewNeededModel>();
		int i=0;
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes  = myStmt.executeQuery("SELECT * from InterviewNeeded");
			while(myRes.next())
			{
				InterviewNeededModel interviewNeeded= new InterviewNeededModel();	
				interviewNeeded.setInterviewStatus(myRes.getString("InterviewStatus"));
				interviewNeeded.setInterviewID(myRes.getInt("InterviewID"));
				interviewNeededModel.add(interviewNeeded);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return interviewNeededModel;
	}
	public StudentModel getInterviewNeeded(StudentModel studentModel)
	{
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes  = myStmt.executeQuery("SELECT InterviewNeeded_InterviewID from studentInformation where studentId = "+
             + studentModel.getStudentID());
			while(myRes.next())
			{
					studentModel.setInterviewNeeded(myRes.getInt("InterviewNeeded_InterviewID"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentModel;
		
	}

}

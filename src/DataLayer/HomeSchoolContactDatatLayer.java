/**
 * 
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import Model.StudentModel;
import Repository.HomeScoolContactInterface;

/**
 * @author Sruthi danda
 *
 */
public class HomeSchoolContactDatatLayer implements HomeScoolContactInterface{

	@Override
	public void updateHomeSchoolContact(StudentModel studedntModel) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("UPDATE  studentInformation set "
					+ "`HomeSchollContact_HomeSchollContactID` ="
					+ "'"+studedntModel.homeSchoolContactModel.getHomeSchoolContactId()+"'"+ 
					 "  WHERE  `studentId` = '"+studedntModel.getStudentID()+"'");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void insertHomeSchoolContact(StudentModel studedntModel) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("UPDATE  studentInformation set "
					+ "`HomeSchollContact_HomeSchollContactID` ="
					+ "'"+studedntModel.homeSchoolContactModel.getHomeSchoolContactId()+"'"+ 
					 "  WHERE  `studentId` = '"+studedntModel.getStudentID()+"'");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}

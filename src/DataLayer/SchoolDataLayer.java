package DataLayer;
/*
 * author Sruthi danda
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.SchoolModel;
import Repository.SchoolInterface;

public class SchoolDataLayer implements SchoolInterface{

	@Override
	public List<SchoolModel> getAllSchools() {
		// TODO Auto-generated method stub
		ArrayList<SchoolModel> schoolModel = new ArrayList<SchoolModel>();
		int i=0;
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes  = myStmt.executeQuery("SELECT * from School ");
			while(myRes.next())
			{
			SchoolModel school= new SchoolModel();	
			school.setSchoolName(myRes.getString("schoolName"));
			school.setSchoolID(myRes.getInt("schoolId"));
			schoolModel.add(school);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return schoolModel;
	}

}

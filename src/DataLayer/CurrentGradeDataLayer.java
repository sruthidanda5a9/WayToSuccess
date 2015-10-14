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

import Model.CurrentGradeModel;
import Model.GenderModel;
import Repository.CurrentGradeInterface;

/**
 * @author sruthi danda
 *
 */
public class CurrentGradeDataLayer implements CurrentGradeInterface{

	@Override
	public List<CurrentGradeModel> getAllGrades() {
		// TODO Auto-generated method stub
		ArrayList<CurrentGradeModel> currentGradeModel = new ArrayList<CurrentGradeModel>();
		int i=0;
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes  = myStmt.executeQuery("SELECT * from currentGrade ");
			while(myRes.next())
			{
				CurrentGradeModel grade= new CurrentGradeModel();	
				grade.setCurrentGrade(myRes.getString("currentGrade"));
				grade.setCurrentGradeId(myRes.getInt("currentGradeId"));
				currentGradeModel.add(grade);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return currentGradeModel;
	}

}

package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.GenderModel;
import Model.ProgramModel;
import Repository.GenderInterface;

/*
 * author sruthi danda
 */
public class GenderDataLayer implements GenderInterface {

	@Override
	public List<GenderModel> getAllGenders() {
		// TODO Auto-generated method stub
		ArrayList<GenderModel> genderModel = new ArrayList<GenderModel>();
		int i=0;
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes  = myStmt.executeQuery("SELECT * from Gender ");
			while(myRes.next())
			{
				GenderModel gender= new GenderModel();	
				gender.setGenderName(myRes.getString("genderName"));
				gender.setGenderID(myRes.getInt("genderId"));
				genderModel.add(gender);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return genderModel;
	}
	

}

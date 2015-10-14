package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Model.CourseStudentModel;
import Model.ProgramModel;
import Model.SchoolModel;
import Model.StudentModel;
import Repository.ProgramInterface;

public class ProgramDataLayer implements ProgramInterface{

	@Override
	public List<ProgramModel> getAllPrograms() {
		// TODO Auto-generated method stub
		ArrayList<ProgramModel> programModel = new ArrayList<ProgramModel>();
		int i=0;
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes  = myStmt.executeQuery("SELECT * from Course ");
			while(myRes.next())
			{
				ProgramModel program= new ProgramModel();	
				program.setProgramName(myRes.getString("courseName"));
				program.setProgramID(myRes.getInt("courseId"));
				programModel.add(program);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return programModel;
	}

	@Override
	public void insert(ProgramModel ProgarmModel) {
		// TODO Auto-generated method stub
		
	}
	
}



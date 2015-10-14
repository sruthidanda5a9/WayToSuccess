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

import Model.EthnicityModel;
import Model.GenderModel;
import Repository.EthnicityInterface;

/**
 * @author sruthi danda
 *
 */
public class EthnicityDataLayer implements EthnicityInterface {

	@Override
	public List<EthnicityModel> getAllEthnicity() {
		// TODO Auto-generated method stub
		ArrayList<EthnicityModel> ethnicityModel = new ArrayList<EthnicityModel>();
		int i=0;
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes  = myStmt.executeQuery("SELECT * from Ethnicity ");
			while(myRes.next())
			{
				EthnicityModel ethnicity= new EthnicityModel();	
				
				ethnicity.setEthnicityID(myRes.getInt("ethnicityId"));
				ethnicity.setEthnicityName(myRes.getString("ethnicityName"));
				ethnicityModel.add(ethnicity);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return ethnicityModel;
	}

}

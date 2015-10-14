/**
 * 
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import Model.AddressModel;
import Model.StatusModel;
import Repository.StatusInterface;

/**
 * @author sruthi danda
 *
 */
public class StatusDataLayer implements StatusInterface{

	@Override
	public StatusModel getPendingStatusID() {
		// TODO Auto-generated method stub
		StatusModel statusmodel = new StatusModel();
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
		myRes = myStmt.executeQuery("SELECT * FROM Status");
			while(myRes.next())
			{
				if(myRes.getString("statusName").equals("PENDING"))
				{
					statusmodel.setStatusID(myRes.getInt("statusID"));
					statusmodel.setStatusName(myRes.getString("statusName"));
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return statusmodel;
	}

}

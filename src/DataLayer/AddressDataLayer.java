/**
 * 
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import Model.AddressModel;
import Model.StudentModel;
import Repository.AddressInterface;

/**
 * @author sruthi danda
 *
 */
public class AddressDataLayer implements AddressInterface{

	@Override
	public void insert(AddressModel addressModel) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("INSERT INTO Address (`addressLineOne`, `street`, `city`, `state`, `zipcode`) "
					+ "VALUES ('"+addressModel.getAddressLineOne()+"', '"+addressModel.getStreet()+
					"', '"+addressModel.getCity()+"', '"+addressModel.getState()+"', '"+ addressModel.getZipCode() +"')");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public AddressModel getAddressID() {
		// TODO Auto-generated method stub
		/*
		 * This is the foreign key in students table for address.
		 */
		AddressModel addressModel = new AddressModel();
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM Address where addressId =(Select MAX(addressId) FROM Address)");
			while(myRes.next())
			{
				addressModel.setAddressID(Integer.parseInt(myRes.getString("addressId")));
				addressModel.setAddressLineOne(myRes.getString("addressLineOne"));
				addressModel.setCity(myRes.getString("city"));
				addressModel.setState(myRes.getString("state"));
				addressModel.setStreet(myRes.getString("street"));
				addressModel.setZipCode(myRes.getString("zipcode"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return addressModel;
	}
	public AddressModel getCurrentAddressID(StudentModel studentModel) {
		// TODO Auto-generated method stub
		/*
		 * This is the foreign key in students table for address.
		 */
		AddressModel addressModel = new AddressModel();
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM Address where addressId =(Select `Address_addressId` from studentInformation where `studentEmail`='"+studentModel.getStudentEmailID()+"')");
			while(myRes.next())
			{
				addressModel.setAddressID(Integer.parseInt(myRes.getString("addressId")));
				addressModel.setAddressLineOne(myRes.getString("addressLineOne"));
				addressModel.setCity(myRes.getString("city"));
				addressModel.setState(myRes.getString("state"));
				addressModel.setStreet(myRes.getString("street"));
				addressModel.setZipCode(myRes.getString("zipcode"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		return addressModel;
	}

	@Override
	public void update(AddressModel addressModel) {
		// TODO Auto-generated method stub
		/*
		 * Career center updating the address details
		 */
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("UPDATE  Address set `addressLineOne` ='"+addressModel.getAddressLineOne()+"', `street` = "
					+ "', "+addressModel.getStreet()+"' , `city`='"+addressModel.getCity()+"',"
							+ " `state` ='"+addressModel.getState()+"' , `zipcode`='"+addressModel.getZipCode()+"' "
					+ "WHERE  `addressId` = '"+addressModel.getAddressID()+"'");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}

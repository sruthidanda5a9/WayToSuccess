package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.CCStudentOverviewDTO;
import Model.AddressModel;
import Model.AuthenticationModel;
import Model.CourseStudentModel;
import Model.StudentModel;
import Repository.StudentInterface;

public class StudentDataLayer implements StudentInterface{

	@Override
	public void insert(StudentModel studentModel) {
		// TODO Auto-generated method stub
		ResultSet myRes = null;
		int id = 0;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes  = myStmt.executeQuery("SELECT * from Authentication where userName='"+studentModel.getStudentEmailID()+"'");
			while(myRes.next())
			{
				id = myRes.getInt("authenticationID");
			}
			myStmt.executeUpdate("INSERT INTO studentInformation (`studentFirstName`, "
					+ "`studentLastName`,`studentMiddleInitial`,`studentEmail`,`Authentication_authenticationID`) "
					+ "VALUES ('"+studentModel.getFirstName()+"', '"+studentModel.getLastName()+
					"', '"+studentModel.getMiddileInitial()+"', '"+studentModel.getStudentEmailID()+"', '"+ id +"')");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public void update(StudentModel studentModel) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("UPDATE  studentInformation set `currentGPA`=' "+ 
					studentModel.getCurrentGPA()+"',`studentDOB`='"+studentModel.getDOB()+"',`studentCellNumber`='"+studentModel.
					getCellNumber()+"',`studentHomePhone`='"+studentModel.getHomePhone()+"',`Ethnicity_ethnicityId`='"
					+studentModel.getEthnticity()+"',`School_schoolId`='"+studentModel.getCurrentSchool()+
					"',`Gender_genderId`='"+studentModel.getGender()+"',"+ "`CurrentGrade_currentGradeId`='"+studentModel.
					getCurrentGrade()+"' WHERE `studentEmail`="+"'"+studentModel.getStudentEmailID()+"'");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public StudentModel getStudentId(StudentModel studentModel) {
		// TODO Auto-generated method stub
		/*
		 * this is the foreign key in progarmsstudents table.
		 */
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes =  myStmt.executeQuery("SELECT * from studentInformation where studentEmail='"+studentModel.getStudentEmailID()+"'");
			while(myRes.next())
			{
				studentModel.setStudentID(Integer.parseInt(myRes.getString("studentID")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentModel;
	}

	@Override
	public void insertAddressID(StudentModel studentModel) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("UPDATE  studentInformation set `Address_addressId`=' "+ 
					studentModel.addressModel.getAddressID()+"' WHERE `studentEmail`="+"'"+studentModel.getStudentEmailID()+"'");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public StudentModel getCurrentStudent(StudentModel studentModel) {
		// TODO Auto-generated method stub
		/*
		 * Retriving the newly entered student details.
		 */
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM Gender,studentInformation,Ethnicity,School,CurrentGrade "
					+ "where studentInformation.studentId =  '"+studentModel.getStudentID() +"' AND "+
					"studentInformation.Ethnicity_ethnicityId =  Ethnicity.ethnicityId AND "+
					"School.schoolId = studentInformation.School_schoolId AND  "+
					"studentInformation.Gender_genderId = Gender.genderId AND "+
					"CurrentGrade.currentGradeId = studentInformation.CurrentGrade_currentGradeId");
			while(myRes.next())
			{
				studentModel.setStudentID(Integer.parseInt(myRes.getString("studentInformation.studentId")));
				studentModel.setFirstName(myRes.getString("studentInformation.studentFirstName"));
				studentModel.setLastName(myRes.getString("studentInformation.studentLastName"));
				studentModel.setCurrentGPA(myRes.getInt("studentInformation.currentGPA"));
				studentModel.setCellNumber(myRes.getString("studentInformation.studentCellNumber"));
				studentModel.setHomePhone(myRes.getString("studentInformation.studentHomePhone"));
				studentModel.setDOB(myRes.getString("studentInformation.studentDOB"));
				studentModel.genderModel.setGenderName(myRes.getString("Gender.genderName"));
				studentModel.genderModel.setGenderID(myRes.getInt("Gender.genderId"));
				studentModel.ethnicityModel.setEthnicityName(myRes.getString("Ethnicity.ethnicityName"));
				studentModel.ethnicityModel.setEthnicityID(myRes.getInt("Ethnicity.ethnicityId"));
				studentModel.schoolModel.setSchoolName(myRes.getString("School.schoolName"));
				studentModel.schoolModel.setSchoolID(myRes.getInt("School.schoolId"));
				studentModel.gradeModel.setCurrentGrade(myRes.getString("CurrentGrade.currentGrade"));
				studentModel.gradeModel.setCurrentGradeId(myRes.getInt("CurrentGrade.currentGradeId"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentModel;
	}

	@Override
	public StudentModel getCurrentLoginStudent(StudentModel studentModel) {
		// TODO Auto-generated method stub
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM studentInformation , InterviewNeeded  "
					+ "where studentInformation.studentId = '"+studentModel.getStudentID() +"'  and  "
					+ "studentInformation.InterviewNeeded_InterviewID =  InterviewNeeded.InterviewID");
			while(myRes.next())
			{
				studentModel.setStudentID(Integer.parseInt(myRes.getString("studentInformation.studentId")));
				studentModel.setFirstName(myRes.getString("studentInformation.studentFirstName"));
				studentModel.setLastName(myRes.getString("studentInformation.studentLastName"));
				studentModel.setCurrentGPA(myRes.getInt("studentInformation.currentGPA"));
				studentModel.setCellNumber(myRes.getString("studentInformation.studentCellNumber"));
				studentModel.setHomePhone(myRes.getString("studentInformation.studentHomePhone"));
				studentModel.setDOB(myRes.getString("studentInformation.studentDOB"));
				studentModel.setCurrentGrade(myRes.getInt("studentInformation.CurrentGrade_currentGradeId"));
				studentModel.setStudentEmailID(myRes.getString("studentInformation.studentEmail"));
				studentModel.interviewNeededModel.setInterviewID(myRes.getInt("studentInformation.InterviewNeeded_InterviewID"));
				studentModel.interviewNeededModel.setInterviewStatus(myRes.getString("InterviewNeeded.InterviewStatus"));
			}
			myRes = myStmt.executeQuery("SELECT * FROM Gender,studentInformation,Ethnicity,School,CurrentGrade "
					+ "where studentInformation.studentId = '"+studentModel.getStudentID() +"' AND "+
					"studentInformation.Ethnicity_ethnicityId =  Ethnicity.ethnicityId AND "+
					"School.schoolId = studentInformation.School_schoolId AND  "+
					"studentInformation.Gender_genderId = Gender.genderId AND "+
					"CurrentGrade.currentGradeId = studentInformation.CurrentGrade_currentGradeId");

			while(myRes.next())
			{
				studentModel.setStudentID(Integer.parseInt(myRes.getString("studentInformation.studentId")));
				studentModel.setFirstName(myRes.getString("studentInformation.studentFirstName"));
				studentModel.setLastName(myRes.getString("studentInformation.studentLastName"));
				studentModel.setCurrentGPA(myRes.getInt("studentInformation.currentGPA"));
				studentModel.setCellNumber(myRes.getString("studentInformation.studentCellNumber"));
				studentModel.setHomePhone(myRes.getString("studentInformation.studentHomePhone"));
				studentModel.setDOB(myRes.getString("studentInformation.studentDOB"));
				studentModel.setCurrentGrade(myRes.getInt("studentInformation.CurrentGrade_currentGradeId"));
				studentModel.genderModel.setGenderName(myRes.getString("Gender.genderName"));
				studentModel.genderModel.setGenderID(myRes.getInt("Gender.genderId"));
				studentModel.ethnicityModel.setEthnicityName(myRes.getString("Ethnicity.ethnicityName"));
				studentModel.ethnicityModel.setEthnicityID(myRes.getInt("Ethnicity.ethnicityId"));
				studentModel.schoolModel.setSchoolName(myRes.getString("School.schoolName"));
				studentModel.schoolModel.setSchoolID(myRes.getInt("School.schoolId"));
				studentModel.gradeModel.setCurrentGrade(myRes.getString("CurrentGrade.currentGrade"));
				studentModel.gradeModel.setCurrentGradeId(myRes.getInt("CurrentGrade.currentGradeId"));
				studentModel.setStudentEmailID(myRes.getString("studentInformation.studentEmail"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentModel;
	}

	@Override
	public ArrayList<StudentModel> getCCStudentOverview(StudentModel studentModel) {
		// TODO Auto-generated method stub
		ResultSet myRes = null;
		ArrayList<StudentModel> ccStduentView = new ArrayList<StudentModel>();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			/*
			 * Query for finding the all students first name , last name, grade value, gpa, status in studentoverview page.
			 */
			String query = "SELECT DISTINCT studentInformation.studentId, "+
					 "studentInformation.studentFirstName," +
					 "studentInformation.studentLastName," +
					 "studentInformation.currentGPA," +
					 "studentInformation.CurrentGrade_currentGradeId," +
					 "Course.courseName ," +
					 "Status.statusName," +
					 "CurrentGrade.currentGrade ," +
					 "School.schoolName " +
					 "from studentInformation , School ,CurrentGrade ,Course_has_Student , Status ,Course " + 
					" where studentInformation.School_schoolId = School.schoolId and  "+
					"studentInformation.CurrentGrade_currentGradeId = CurrentGrade.currentGradeId  and  "  +
					" Course_has_Student.Status_statusID = Status.statusID and  "+
					 "Course_has_Student.Course_courseId = Course.courseId and  "+
					"Course_has_Student.studentInformation_studentId = studentInformation.studentId ";
			if(studentModel.getCurrentGPA() != 0)
			{
				query =query.concat(" and studentInformation.currentGPA >=  '" +studentModel.getCurrentGPA() + "'");
			}
			if(studentModel.getCurrentGrade()  != 0 )
			{
				query =query.concat(" and studentInformation.CurrentGrade_currentGradeId =  '"+ studentModel.getCurrentGrade() + "' ");
			}
			if(studentModel.getStudentID() != 0)
			{
				query =query.concat(" and  studentInformation.School_schoolId = ' " + studentModel.getStudentID()+ "'");
			}
			if(studentModel.getInterviewNeeded() != 0)
			{
				query =query.concat(" and  studentInformation.InterviewNeeded_InterviewID = '" + studentModel.getInterviewNeeded()+ "'  and"
						+ "studentInformation.InterviewNeeded_InterviewID = InterviewNeeded.InterviewID ");
			}
			if(studentModel.statusModel.getStatusID() != 0)
			{
				query =query.concat(" and  Course_has_Student.Status_statusID = " + studentModel.statusModel.getStatusID());
			} 
			if(studentModel.schoolModel.getSchoolID() != 0)
			{
				query =query.concat(" and  School.schoolId = " + studentModel.schoolModel.getSchoolID());
			}
			myRes = myStmt.executeQuery(query+";");
			while(myRes.next())
			{

				StudentModel studentModelDetails = new StudentModel();
				studentModelDetails.setStudentID(Integer.parseInt(myRes.getString("studentInformation.studentId")));
				studentModelDetails.setFirstName(myRes.getString("studentInformation.studentFirstName"));
				studentModelDetails.setLastName(myRes.getString("studentInformation.studentLastName"));
				studentModelDetails.setCurrentGPA(myRes.getInt("studentInformation.currentGPA"));
				studentModelDetails.setCurrentGrade(myRes.getInt("studentInformation.CurrentGrade_currentGradeId"));
				studentModelDetails.schoolModel.setSchoolName(myRes.getString("School.schoolName"));
				studentModelDetails.statusModel.setStatusName(myRes.getString("Status.statusName"));
				studentModelDetails.gradeModel.setCurrentGrade(myRes.getString("CurrentGrade.currentGrade"));
				studentModelDetails.courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				ccStduentView.add(studentModelDetails);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return ccStduentView;
	}

	@Override
	public void insertInterview(StudentModel studentModel) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("UPDATE  studentInformation set `InterviewNeeded_InterviewID`= "+ 
					studentModel.getInterviewNeeded()+" WHERE `studentId`="+""+studentModel.getStudentID()+"");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public ArrayList<StudentModel> getHomeSchoolStuendts(StudentModel studentModel) {
		// TODO Auto-generated method stub
		ResultSet myRes = null;
		ArrayList<StudentModel> homeSchoolStudents = new ArrayList<StudentModel>();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			/*
			 * Query for finding the all students first name , last name, grade value, gpa, status in studentoverview page.
			 */
			String query = "SELECT DISTINCT studentInformation.studentId,"
					+ "Course.courseName , "+
					" studentInformation.studentFirstName,"
					+ "studentInformation.studentLastName, "+
					" studentInformation.currentGPA,"
					+ "studentInformation.CurrentGrade_currentGradeId,"+
					"Status.statusName,"
					+ "CurrentGrade.currentGrade ,"
					+ "School.schoolName"+
					" from studentInformation , School ,Authentication,CurrentGrade ,Course_has_Student , Status , Course  "+
					" where studentInformation.HomeSchollContact_HomeSchollContactID = 1  and "+
					" studentInformation.School_schoolId = School.schoolId and  Authentication.userName = '"+
					studentModel.authenticationModel.getUserName() +"'  and  "+
					"Authentication.authenticationID = School.Authentication_authenticationID and "
					+ "studentInformation.School_schoolId = School.schoolId and "+
					"studentInformation.CurrentGrade_currentGradeId = CurrentGrade.currentGradeId  and   "+
					"Course_has_Student.Status_statusID = Status.statusID and  " +
					 "Course_has_Student.Course_courseId = Course.courseId and  "+
					"Course_has_Student.studentInformation_studentId = studentInformation.studentId ";


			myRes = myStmt.executeQuery(query);
			while(myRes.next())
			{

				StudentModel studentModelDetails = new StudentModel();
				studentModelDetails.setStudentID(Integer.parseInt(myRes.getString("studentInformation.studentId")));
				studentModelDetails.setFirstName(myRes.getString("studentInformation.studentFirstName"));
				studentModelDetails.setLastName(myRes.getString("studentInformation.studentLastName"));
				studentModelDetails.setCurrentGPA(myRes.getInt("studentInformation.currentGPA"));
				studentModelDetails.setCurrentGrade(myRes.getInt("studentInformation.CurrentGrade_currentGradeId"));
				studentModelDetails.schoolModel.setSchoolName(myRes.getString("School.schoolName"));
				studentModelDetails.statusModel.setStatusName(myRes.getString("Status.statusName"));
				studentModelDetails.gradeModel.setCurrentGrade(myRes.getString("CurrentGrade.currentGrade"));
				studentModelDetails.courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				homeSchoolStudents.add(studentModelDetails);

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return homeSchoolStudents;
	}

	@Override
	public StudentModel getDOB(AuthenticationModel authenticationModel) {
		// TODO Auto-generated method stub
		StudentModel studentModel = new StudentModel();
		studentModel.setStudentEmailID(authenticationModel.getUserName());
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes =  myStmt.executeQuery("SELECT `studentDOB` from studentInformation where studentEmail='"+studentModel.getStudentEmailID()+"'");
			while(myRes.next())
			{
				studentModel.setDOB(myRes.getString("studentDOB"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentModel;
	}}



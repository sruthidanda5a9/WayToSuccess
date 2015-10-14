/**
 * 
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

import Controller.CCStudentOverview;
import DTO.CCProgramsDTO;
import DTO.CCStudentOverviewDTO;
import Model.CourseStudentModel;
import Model.ProgramModel;
import Model.StatusModel;
import Model.StudentModel;
import Repository.CourseStudentInterface;

/**
 * @author sruthi danda
 *
 */
public class CourseStudentDataLayer implements CourseStudentInterface{

	@Override
	public void insert(CourseStudentModel courseStudentModel) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("INSERT INTO Course_has_Student (`Course_courseId`, `studentInformation_studentId`,`Choice`)"
					+ " VALUES ('"+courseStudentModel.progarmModel.getProgramID()+"',"
					+ " '"+courseStudentModel.getStudentID()+
					"','"+courseStudentModel.getChoice()+"')");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public CourseStudentModel getCurrentStudentCourseOne(StudentModel studentModel) {
		// TODO Auto-generated method stub
		CourseStudentModel courseStudentModel = new CourseStudentModel();
		ResultSet myRes =  null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM Course_has_Student , Course  "+
					" where Course_has_Student.studentInformation_studentId = "+studentModel.getStudentID()+"  "
					+ "AND Course_has_Student.Choice= 1 AND Course.courseId = Course_has_Student.Course_courseId ;");
			while(myRes.next())
			{
				courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				courseStudentModel.progarmModel.setProgramID(myRes.getInt("Course.courseId"));
				courseStudentModel.setChoice(Integer.parseInt(myRes.getString("Course_has_Student.Choice")));
				courseStudentModel.setRank(Integer.parseInt(myRes.getString("Course_has_Student.Rank")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return courseStudentModel;
	}

	@Override
	public CourseStudentModel getCurrentStudentCourseTwo(StudentModel studentModel) {
		// TODO Auto-generated method stub
		CourseStudentModel courseStudentModel = new CourseStudentModel();
		ResultSet myRes =  null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM Course_has_Student , Course  "+
					" where Course_has_Student.studentInformation_studentId = "+studentModel.getStudentID()+"  "
					+ "AND Course_has_Student.Choice= 2 AND Course.courseId = Course_has_Student.Course_courseId  ;");
			while(myRes.next())
			{
				courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				courseStudentModel.progarmModel.setProgramID(myRes.getInt("Course.courseId"));
				courseStudentModel.setChoice(Integer.parseInt(myRes.getString("Course_has_Student.Choice")));
				courseStudentModel.setRank(Integer.parseInt(myRes.getString("Course_has_Student.Rank")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return courseStudentModel;
	}
	public CourseStudentModel getCurrentStudentCourseOneStatus(StudentModel studentModel) {
		// TODO Auto-generated method stub
		CourseStudentModel courseStudentModel = new CourseStudentModel();
		ResultSet myRes =  null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM Course_has_Student , Course ,Status   "+
					" where Course_has_Student.studentInformation_studentId = "+studentModel.getStudentID()+"  "
					+ "AND Course_has_Student.Choice= 1 AND Course.courseId = Course_has_Student.Course_courseId  and "
					+ "Course_has_Student.Status_statusID = Status.statusID;");
			while(myRes.next())
			{
				courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				courseStudentModel.progarmModel.setProgramID(myRes.getInt("Course.courseId"));
				courseStudentModel.setChoice(Integer.parseInt(myRes.getString("Course_has_Student.Choice")));
				courseStudentModel.statusModel.setStatusName(myRes.getString("Status.statusName"));
				courseStudentModel.setRank(Integer.parseInt(myRes.getString("Course_has_Student.Rank")));

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return courseStudentModel;
	}

	@Override
	public CourseStudentModel getCurrentStudentCourseTwoStatus(StudentModel studentModel) {
		// TODO Auto-generated method stub
		CourseStudentModel courseStudentModel = new CourseStudentModel();
		ResultSet myRes =  null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM Course_has_Student , Course ,Status  "+
					" where Course_has_Student.studentInformation_studentId = "+studentModel.getStudentID()+"  "
					+ "AND Course_has_Student.Choice= 2 AND Course.courseId = Course_has_Student.Course_courseId and "
					+ "Course_has_Student.Status_statusID = Status.statusID;");
			while(myRes.next())
			{
				courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				courseStudentModel.progarmModel.setProgramID(myRes.getInt("Course.courseId"));
				courseStudentModel.setChoice(Integer.parseInt(myRes.getString("Course_has_Student.Choice")));
				courseStudentModel.statusModel.setStatusName(myRes.getString("Status.statusName"));
				courseStudentModel.setRank(Integer.parseInt(myRes.getString("Course_has_Student.Rank")));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return courseStudentModel;
	}
	@Override
	public void updateStatus(CourseStudentModel courseStudentModel) {
		// TODO Auto-generated method stub
		/*
		 * to update the student course status information in the Course has student table.
		 */
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("UPDATE  Course_has_Student set `Status_statusID`=' "+ 
					courseStudentModel.statusModel.getStatusID()+
					"' WHERE `Course_courseId`='"+courseStudentModel.progarmModel.getProgramID() +"' AND `studentInformation_studentId` ='" +courseStudentModel.getStudentID()+"'");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}


	}

	@Override
	public CourseStudentModel getCurrentStudentStatusOne(StudentModel studetModel) {
		// TODO Auto-generated method stub
		CourseStudentModel courseStudentModel = new CourseStudentModel();
		ResultSet myRes =  null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM Course_has_Student , Course , Status "+
					" where Course_has_Student.studentInformation_studentId = '"+studetModel.getStudentID()+
					"'  AND Status.statusID = Course_has_Student.Status_statusID AND "
					+ "Course_has_Student.Choice= 1 AND Course.courseId = Course_has_Student.Course_courseId ");
			while(myRes.next())
			{
				courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				courseStudentModel.statusModel.setStatusName(myRes.getString("Status.statusName"));
				courseStudentModel.progarmModel.setProgramID(myRes.getInt("Course.courseId"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return courseStudentModel;
	}

	@Override
	public CourseStudentModel getCurrentStudentStatusTwo(StudentModel studetModel) {
		// TODO Auto-generated method stub
		CourseStudentModel courseStudentModel = new CourseStudentModel();
		ResultSet myRes =  null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("SELECT * FROM Course_has_Student , Course , Status "+
					" where Course_has_Student.studentInformation_studentId = '"+studetModel.getStudentID()+
					"'  AND Status.statusID = Course_has_Student.Status_statusID AND "
					+ "Course_has_Student.Choice= 2 AND Course.courseId = Course_has_Student.Course_courseId ");
			while(myRes.next())
			{
				courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				courseStudentModel.statusModel.setStatusName(myRes.getString("Status.statusName"));
				courseStudentModel.progarmModel.setProgramID(myRes.getInt("Course.courseId"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return courseStudentModel;
	}

	@Override
	public ArrayList<CourseStudentModel> getStudentCourseOne(ArrayList<CCStudentOverviewDTO> ccStudentOverview) {
		// TODO Auto-generated method stub
		ArrayList<CourseStudentModel> courseStudentModel = new ArrayList<CourseStudentModel>();

		ResultSet myRes =  null;
		for(int i=0;i<ccStudentOverview.size();i++)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
				Statement myStmt = myCon.createStatement();
				myRes = myStmt.executeQuery("SELECT * FROM Course_has_Student , Course , Status "+
						" where Course_has_Student.studentInformation_studentId = '"+ccStudentOverview.get(i).getStudentID()+
						"'  AND Status.statusID = Course_has_Student.Status_statusID AND "
						+ "Course_has_Student.Choice= 1 AND Course.courseId = Course_has_Student.Course_courseId ");
				while(myRes.next())
				{
					CourseStudentModel courseStudentModelDetails = new CourseStudentModel();
					courseStudentModelDetails.progarmModel.setProgramName(myRes.getString("Course.courseName"));
					courseStudentModelDetails.statusModel.setStatusName(myRes.getString("Status.statusName"));
					courseStudentModelDetails.progarmModel.setProgramID(myRes.getInt("Course.courseId"));
				}
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}}
		return courseStudentModel;
	}

	@Override
	public ArrayList<CourseStudentModel> getStudentCourseTwo(ArrayList<CCStudentOverviewDTO> ccStudentOverview) {
		// TODO Auto-generated method stub
		ArrayList<CourseStudentModel> courseStudentModel = new ArrayList<CourseStudentModel>();

		ResultSet myRes =  null;
		for(int i=0;i<ccStudentOverview.size();i++)
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
				Statement myStmt = myCon.createStatement();
				myRes = myStmt.executeQuery("SELECT * FROM Course_has_Student , Course , Status "+
						" where Course_has_Student.studentInformation_studentId = '"+ccStudentOverview.get(i).getSchoolID()+
						"'  AND Status.statusID = Course_has_Student.Status_statusID AND "
						+ "Course_has_Student.Choice= 2 AND Course.courseId = Course_has_Student.Course_courseId ");
				while(myRes.next())
				{
					CourseStudentModel courseStudentModelDetails = new CourseStudentModel();
					courseStudentModelDetails.progarmModel.setProgramName(myRes.getString("Course.courseName"));
					courseStudentModelDetails.statusModel.setStatusName(myRes.getString("Status.statusName"));
					courseStudentModelDetails.progarmModel.setProgramID(myRes.getInt("Course.courseId"));
				}
			}

			catch(Exception e)
			{
				e.printStackTrace();
			}}
		return courseStudentModel;
	}

	@Override
	public CCProgramsDTO getProgramDetails(CCProgramsDTO ccProgramsDTO) {
		// TODO Auto-generated method stub
		ResultSet myRes =  null;
		int i =ccProgramsDTO.getProgramID();

		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			
			myRes = myStmt.executeQuery("SELECT *  FROM Course where courseId= "+i +" ;");
			while(myRes.next())
			{
				ccProgramsDTO.setProgramName(myRes.getString("courseName"));
			}
			/*
			 * Query to get the comlete number of applicants for programs one.
			 */
			myRes = myStmt.executeQuery("SELECT COUNT(*)  As count FROM Course_has_Student where Course_courseId= "+i +" ;");
			while(myRes.next())
			{
				ccProgramsDTO.setApplicants(myRes.getInt("count"));
			}
			/*
			 * query to get the students with program one as choice one
			 */
			myRes = myStmt.executeQuery("SELECT COUNT(*)  As count FROM Course_has_Student where Course_courseId= "+i +" AND Choice = 1;");
			while(myRes.next())
			{
				ccProgramsDTO.setFirstChoice(myRes.getInt("count"));
			}
			/*
			 * query to find this program as second choice
			 */
			myRes = myStmt.executeQuery("SELECT COUNT(*)  As count FROM Course_has_Student where Course_courseId= "+i +" AND Choice = 2;");
			while(myRes.next())
			{
				ccProgramsDTO.setSecondChoice(myRes.getInt("count"));
			}
			/*
			 * query to find the cound how many are placed.
			 */
			myRes = myStmt.executeQuery("SELECT COUNT(Course_has_Student.Course_courseId)  As count FROM Course_has_Student , Status where "
					+ "Course_has_Student.Course_courseId= "+i +" AND Status.statusID = Course_has_Student.Status_statusID AND  "
					+ "Status.statusName = 'PLACED'");


			while(myRes.next())
			{
				ccProgramsDTO.setPlaced(myRes.getInt("count"));
			}
			/*
			 * qUERY TO Find how may students are waitlisted 
			 */
			myRes = myStmt.executeQuery("SELECT COUNT(Course_has_Student.Course_courseId)  As count FROM Course_has_Student , Status where "
					+ "Course_has_Student.Course_courseId= "+ccProgramsDTO.getProgramID() +" AND Status.statusID = Course_has_Student.Status_statusID AND "
					+ "Status.statusName = 'WAITLISTED';");
			while(myRes.next())
			{
				ccProgramsDTO.setWaitlist(myRes.getInt("count"));
			}
		}

		catch(Exception e)
		{
			e.printStackTrace();
		}
		ccProgramsDTO.setProgramID(ccProgramsDTO.getProgramID());
		return ccProgramsDTO;
	}

	@Override
	public ArrayList<StudentModel> getCourseStudentDetails(CCProgramsDTO ccProgramsDTO) {
		// TODO Auto-generated method stub
		ArrayList<StudentModel> studentModel = new ArrayList<StudentModel>();
		ResultSet myRes =  null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("select distinct studentInformation.studentFirstName,studentInformation.studentId,studentInformation.studentLastName,Status.statusName,Course_has_Student.Choice , Course.courseName  "
					+ " from Course_has_Student , studentInformation ,Status ,Course  where Course_has_Student.studentInformation_studentId "
					+ "= studentInformation.studentId and Course_has_Student.Status_statusID "
					+ "= status.statusID and Course_has_Student.Course_courseId = '"+ccProgramsDTO.getProgramID()+"' and "
					+ "  Course.courseId= Course_has_Student.Course_courseId;");
			while(myRes.next())
			{
				StudentModel studentDetails = new StudentModel();
				studentDetails.setFirstName(myRes.getString("studentInformation.studentFirstName"));
				studentDetails.statusModel.setStatusName(myRes.getString("Status.statusName"));
				studentDetails.setLastName(myRes.getString("studentInformation.studentLastName"));
				studentDetails.setStudentID(Integer.parseInt(myRes.getString("studentInformation.studentId")));
				studentDetails.courseStudentModel.setChoice(Integer.parseInt(myRes.getString("Course_has_Student.Choice")));
				studentDetails.courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				studentModel.add(studentDetails);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentModel;
	}

	@Override
	public void updateCourseDetails(CourseStudentModel courseStudentModel) {
		// TODO Auto-generated method stub
		/*
		 * Updating the Course, student and Choice details. 
		 */
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("UPDATE Course_has_Student set `Course_courseId` = '"+ courseStudentModel.progarmModel.getProgramID()
			+"'Where  `Choice`='"+courseStudentModel.getChoice()+"'"
			+ " and   `studentInformation_studentId` ='" +courseStudentModel.getStudentID()+"'");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<StudentModel> getwaitListedStudents(CourseStudentModel courseStudent) {
		// TODO Auto-generated method stub
		ArrayList<StudentModel>  studentModel = new ArrayList<StudentModel>();
		ResultSet myRes =  null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes = myStmt.executeQuery("select *  "
					+ " from Course_has_Student ,studentInformation where  "
					+ "Status_statusID =  "+courseStudent.statusModel.getStatusID() 
					+ "  and choice =  '"+courseStudent.getChoice()+"'"
							+ "   AND studentInformation.studentId= Course_has_Student.studentInformation_studentId  group by interviewGrade;");
			while(myRes.next())
			{
				StudentModel details = new StudentModel();
				details.courseStudentModel.setChoice(myRes.getInt("Course_has_Student.Choice"));
				details.courseStudentModel.setRank(myRes.getInt("Course_has_Student.Rank"));
				details.setStudentID(myRes.getInt("Course_has_Student.studentInformation_studentId"));
				details.courseStudentModel.progarmModel.setProgramID(myRes.getInt("Course_has_Student.Course_courseId"));
				details.courseStudentModel.setInterviewGrade(myRes.getInt("Course_has_Student.interviewGrade"));
				details.setCurrentGPA(myRes.getInt("studentInformation.currentGPA"));
				studentModel.add(details);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return studentModel;
	}

	@Override
	public void updateRank(StudentModel studentModel) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myStmt.executeUpdate("UPDATE Course_has_Student set `Rank` = '"+ studentModel.courseStudentModel.getRank()
			+"'Where  `Choice`='"+studentModel.courseStudentModel.getChoice()+"'"
			+ " and   `studentInformation_studentId` ='" +studentModel.getStudentID()+"'");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	public CourseStudentModel getRankOfStudent(CourseStudentModel courseStudentModel) {
		// TODO Auto-generated method stub
		ResultSet myRes = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			myRes =  myStmt.executeQuery("SELECT * from Course_has_Student,Course,Status  where "
					+ "Course_has_Student.studentInformation_studentId="+courseStudentModel.getStudentID()+
					" and Course_has_Student.Choice = "+courseStudentModel.getChoice()+" and"
					+ "  Course_has_Student.Status_statusID =Status.statusID and "
					+ " Course_has_Student.Course_courseId = Course.courseId");
			while(myRes.next())
			{
				courseStudentModel.progarmModel.setProgramName(myRes.getString("Course.courseName"));
				courseStudentModel.setRank(Integer.parseInt((myRes.getString("Course_has_Student.Rank"))));
				courseStudentModel.statusModel.setStatusName(myRes.getString("Status.statusName"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return courseStudentModel;
	}

	@Override
	public void insertInterviewGrade(CourseStudentModel courseStudentModel) {
		// TODO Auto-generated method stub
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection myCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/EnrollTrackDB", "root","");
			Statement myStmt = myCon.createStatement();
			String q= "UPDATE Course_has_Student set interviewGrade =" + courseStudentModel.getInterviewGrade()
					+"   Where  `Choice`="+courseStudentModel.getChoice()+
					 "   and   `studentInformation_studentId` =" +courseStudentModel.getStudentID();
			myStmt.executeUpdate(q+";");

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}


}

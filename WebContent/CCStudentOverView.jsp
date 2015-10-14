<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<%@ page import="DTO.*"%>
<%@ page import="Model.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Enroll track</title>
<link href="CSS/StyleSheet2.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-latest.js">
	
</script>
<script type="text/javascript">
	function formValid() {
		var gpa = document.getElementById("GPA").value;
		var status = document.getElementById("status").value;
		if (gpa == '') {
			document.getElementById("GPA").value = 0;
		}
		return true;
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$('input').each(function(event) {
			$(this).focus(function() {
				$(this).addClass("textBoxColor");
			});
			$(this).blur(function() {
				$(this).removeClass("textBoxColor");
			});
		});
	});
</script>
</head>
<body>
<noscript class="noJavascript">JavaScript is off. Javascript must be enabled to use this site .</noscript>
	<div class="header">
		<h1>Way to Success</h1>
	</div>

	<div class="cccontent">
		<div style="float: left;">
			<div style="width: 80px; height: 30px; color: gray">
				<form action="CCProgram" method="post">
					<input type="submit" value="progarms" name="programs" id="button">
				</form>
			</div>
			<div style="width: 10px; height: 30px; color: gray;">
				<form action="CCStudentOverviewProgramData" method="post">
					<input type="submit" value="student" name="student" id="button">
				</form>
			</div>
			<div style="width: 10px; height: 30px; color: gray;">
				<form action="CCLogOut" method="post">
					<input type="submit" value="Logout" id="button" />
				</form>
			</div>
		</div>
		<div class="search">
			<h1>Student Overview Page</h1>
			<div class="error">
				<span id="errorGPA"></span><br />
			</div>
			<form action="CCStudentOverview" method="Post">
				<div style="float: left">
					<table>
						<tr>
							<td>Current School*</td>
							<%
								List<SchoolsDTO> school = (ArrayList) request.getAttribute("school");
							%>
							<td><select name="school" id="school" required="required">
									<option value="0">All</option>
									<c:forEach items="${school}" var="school">
										<option value="${school.schoolID}">${school.schoolName}</option>
									</c:forEach>
							</select> <br></td>
						</tr>
						<tr>
							<td>Current Grade Level*</td>
							<%
								List<CurrentGradeDTO> grade = (ArrayList) request.getAttribute("grade");
							%>
							<td><select name="grade" id="grade">
									<option value="0">All</option>
									<c:forEach items="${grade}" var="grade">
										<option value="${grade.currentGradeId}">${grade.currentGrade}</option>
									</c:forEach>
							</select> <br /></td>
						</tr>
						<tr>
							<td>GPA* :</td>
							<td><input type="text" id="GPA" name="GPA"> <br /></td>
						</tr>
					</table>
				</div>
				<div style="clear: right;">
					<table>
						<tr>
							<td>Interview Needed*:</td>
							<%
								InterviewNeededDTO interviewNeededDTO = new InterviewNeededDTO();
								List<InterviewNeededDTO> interview = (ArrayList) request.getAttribute("interviewNeeded");
							%>
							<td><select name="interviewNeeded" id="interviewNeeded">
									<option value="0" selected="selected">All</option>
									<c:forEach items="${interviewNeeded}" var="interviewNeeded">
										<option value="${interviewNeeded.interviewID}">${interviewNeeded.interviewStatus}</option>
									</c:forEach>
							</select> <br></td>
						</tr>
						<tr>
							<td>Select Status :<br></td>
							<td><INPUT TYPE="radio" NAME="status" VALUE="1" id="status">
								PENDING <BR> <INPUT TYPE="radio" NAME="status" VALUE="3"
								id="status"> WAITLISTED <BR> <INPUT TYPE="radio"
								NAME="status" VALUE="4" id="status"> PLACED <BR> <br /></td>
						</tr>
					</table>
				</div>
				<input type="submit" onclick="return formValid()">
			</form>

		</div>
		<div class="displayData">
			<c:choose>
				<c:when test="${empty tempStudents}">
					<div style="margin-left: 40px">No results to display.</div>
				</c:when>
				<c:otherwise>
					<div style="padding-left: 50px; padding-right: 150px;">
						We have ${size} records. ${message}.
						<form action="DisplayTableData" method="get">
							<input type="submit" value="next" name="buttonCheck"
								style="float: right" id="button" /> <input type="submit"
								value="Previous" name="buttonCheck" style="float: right"
								id="button" />
						</form>
					</div>
					<br>
					<table class="overviewTable"
						style="width: 860px; height: 30px; border: 1px solid black">
						<tr>
							<th>FirstName</th>
							<th>lastName</th>
							<th>GPA</th>
							<th>Grade</th>
							<th>Programm Name</th>
							<th>Status</th>
						</tr>
						<c:forEach items="${tempStudents}" var="tempStudents">
							<tr>
								<td><a
									href="CCStudentProfile?sid=${tempStudents.studentID}">${tempStudents.firstName}</a></td>
								<td>${tempStudents.lastName}</td>
								<td>${tempStudents.GPA}</td>
								<td>${tempStudents.gradeValue}</td>
								<td>${tempStudents.programName }</td>
								<td>${tempStudents.statusName}</td>
							</tr>
						</c:forEach>
					</table>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

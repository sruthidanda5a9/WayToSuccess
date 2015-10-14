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
		<div style="width: 10px; height: 30px; color: gray;">
			<form action="HomeSchoolLogOut" method="post">
				<input type="submit" value="Logout" id="button" />
			</form>
		</div>
	</div>
		<div class="search">
			<h1>Student Overview Page</h1>
		</div>
		<div class="displayData">
			<c:choose>
				<c:when test="${empty tempStudents}">
		No results to display
		</c:when>
				<c:otherwise>
				<div style="padding-left: 50px; padding-right: 150px;">
				We have ${size} records.
				${message}.
				<form action="HomeSchoolTableData" method="get">
				<input type="submit" value="next" name="buttonCheck" style="float: right" id="button" />
				<input type="submit" value="Previous" name="buttonCheck" style="float: right" id="button" />
				</form>
				</div><br>
					
						<table  class="overviewTable"
							style="width: 860px; height: 30px;">
							<tr>
								<th>FirstName</th>
								<th>lastName</th>
								<th>GPA</th>
								<th>grade</th>
								<th>Programm Name</th>
								<th>status</th>
							</tr>
							<c:forEach items="${tempStudents}" var="tempStudents">
								<tr>
									<td><a
										href="HomeSchoolStudentProfile?sid=${tempStudents.studentID}">${tempStudents.firstName}</a></td>
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

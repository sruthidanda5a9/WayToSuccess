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
		var check = document.getElementById("program").value;
		if(check == 'Select')
			{
			return false;
			}
	}
</script>
<script type="text/javascript">
	$(document).ready(function() {

	});
</script>
</head>
<body>
<noscript class="noJavascript">JavaScript is off. Javascript must be enabled to use this site .</noscript>
	<div class="header">
		<h1>Way to Success</h1>
	</div>

	<div class="hscontent">
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
		<div style="padding-left: 200px;">
			<form method="Post" action="CCProgramDetails">
				Select your choice of Program*:
				<%
					List<ProgramsDTO> program = (ArrayList) request.getAttribute("program");
				%>
				<select name="program" id="program">
					<option value="Select" selected="selected">Select</option>
					<c:forEach items="${program}" var="program">
						<option value="${program.progarmID}">${program.programName}</option>
					</c:forEach>
				</select> <br> <br>
				<div style="margin-left: 250px">
					<input type="submit" onclick="return formValid();">
				</div>
			</form>
			<c:choose>
				<c:when test="${ccProgramsDTO.programID == 0}">
					<%
									CCProgramsDTO ccProgramsOneDTO = (CCProgramsDTO) request.getAttribute("ccProgramsOneDTO");
									CCProgramsDTO ccProgramsTwoDTO = (CCProgramsDTO) request.getAttribute("ccProgramsTwoDTO");
									CCProgramsDTO ccProgramsThreeDTO = (CCProgramsDTO) request.getAttribute("ccProgramsThreeDTO");
									CCProgramsDTO ccProgramsFourDTO = (CCProgramsDTO) request.getAttribute("ccProgramsFourDTO");
									CCProgramsDTO ccProgramsFiveDTO = (CCProgramsDTO) request.getAttribute("ccProgramsFiveDTO");
									CCProgramsDTO ccProgramsSixDTO = (CCProgramsDTO) request.getAttribute("ccProgramsSixDTO");
									CCProgramsDTO ccProgramsSevenDTO = (CCProgramsDTO) request.getAttribute("ccProgramsSevenDTO");
									CCProgramsDTO ccProgramsEightDTO = (CCProgramsDTO) request.getAttribute("ccProgramsEightDTO");
									
						%>
					<table class="overviewTable">
						<tr>
							<th>Program Name</th>
							<th>Placed</th>
							<th>WaitListed</th>
							<th>FirstChoice</th>
							<th>SecondChoice</th>
							<th>Applications</th>
						</tr>
						<tr>
							<td>Animal Care</td>
							<td>${ccProgramsOneDTO.placed}</td>
							<td>${ccProgramsOneDTO.waitlist}</td>
							<td>${ccProgramsOneDTO.firstChoice}</td>
							<td>${ccProgramsOneDTO.secondChoice}</td>
							<td>${ccProgramsOneDTO.applicants}</td>
						</tr>

						<tr>
							<td>Art</td>
							<td>${ccProgramsTwoDTO.placed}</td>
							<td>${ccProgramsTwoDTO.waitlist}</td>
							<td>${ccProgramsTwoDTO.firstChoice}</td>
							<td>${ccProgramsTwoDTO.secondChoice}</td>
							<td>${ccProgramsTwoDTO.applicants}</td>
						</tr>
						<tr>
							<td>Crafts</td>
							<td>${ccProgramsThreeDTO.placed}</td>
							<td>${ccProgramsThreeDTO.waitlist}</td>
							<td>${ccProgramsThreeDTO.firstChoice}</td>
							<td>${ccProgramsThreeDTO.secondChoice}</td>
							<td>${ccProgramsThreeDTO.applicants}</td>
						</tr>
						<tr>
							<td>Fitness</td>
							<td>${ccProgramsFourDTO.placed}</td>
							<td>${ccProgramsFourDTO.waitlist}</td>
							<td>${ccProgramsFourDTO.firstChoice}</td>
							<td>${ccProgramsFourDTO.secondChoice}</td>
							<td>${ccProgramsFourDTO.applicants}</td>
						</tr>
						<tr>
							<td>Health and wellness</td>
							<td>${ccProgramsFiveDTO.placed}</td>
							<td>${ccProgramsFiveDTO.waitlist}</td>
							<td>${ccProgramsFiveDTO.firstChoice}</td>
							<td>${ccProgramsFiveDTO.secondChoice}</td>
							<td>${ccProgramsFiveDTO.applicants}</td>
						</tr>
						<tr>
							<td>Home and Garden</td>
							<td>${ccProgramsSixDTO.placed}</td>
							<td>${ccProgramsSixDTO.waitlist}</td>
							<td>${ccProgramsSixDTO.firstChoice}</td>
							<td>${ccProgramsSixDTO.secondChoice}</td>
							<td>${ccProgramsSixDTO.applicants}</td>
						</tr>

						<tr>
							<td>Kids klasses</td>
							<td>${ccProgramsSevenDTO.placed}</td>
							<td>${ccProgramsSevenDTO.waitlist}</td>
							<td>${ccProgramsSevenDTO.firstChoice}</td>
							<td>${ccProgramsSevenDTO.secondChoice}</td>
							<td>${ccProgramsSevenDTO.applicants}</td>
						</tr>

						<tr>
							<td>Languages</td>
							<td>${ccProgramsEightDTO.placed}</td>
							<td>${ccProgramsEightDTO.waitlist}</td>
							<td>${ccProgramsEightDTO.firstChoice}</td>
							<td>${ccProgramsEightDTO.secondChoice}</td>
							<td>${ccProgramsEightDTO.applicants}</td>
						</tr>
					</table>
				</c:when>
				<c:otherwise>
					<%
						List<CCProgramsDTO> studentDetails = (ArrayList) request.getAttribute("ccProgramsDetails");
						List<CCProgramsDTO> tempPrograms = (ArrayList) request.getAttribute("tempPrograms");
						%>
					<c:if test="${empty tempPrograms}">
						<div style="margin-left: 40px">No results to display.</div>
					</c:if>
					<c:if test="${!empty  tempPrograms}">
						<div style="padding-right: 300px;">
							We have ${sizePrograms} records. ${message}.
							<form action="DisplayTableDataPrograms" method="get">
								<input type="submit" value="next" name="buttonCheck"
									style="float: right" id="button" /> <input type="submit"
									value="Previous" name="buttonCheck" style="float: right"
									id="button" />
							</form>
							<br>

							<table class="overviewTable">
								<tr>
									<th>FirstName</th>
									<th>LastName</th>
									<th>Status</th>
									<th>Choice</th>
								</tr>
								<c:forEach items="${tempPrograms}" var="tempPrograms">
									<tr>
										<td><a
											href="CCStudentProfile?sid=${tempPrograms.studentID}">${tempPrograms.firstName}</a></td>
										<td>${tempPrograms.lastName}</td>
										<td>${tempPrograms.statusName}</td>
										<td>${tempPrograms.choice}</td>
									</tr>
								</c:forEach>
							</table>
						</div>
					</c:if>
				</c:otherwise>
			</c:choose>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

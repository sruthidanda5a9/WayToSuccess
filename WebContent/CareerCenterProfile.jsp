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
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<script>



$(function() {
    $ ( "#DOB" ).datepicker();
  });
  </script>
<script type="text/javascript">
	
	function populateDropdown() {
		//alert('${genderd}');
		<%StuInformationDTO stuInfoDTO = (StuInformationDTO) request.getAttribute("stuInformationDTO");%>
		  document.getElementById("school").value = "<%=stuInfoDTO.getSchoolID()%>";
		  document.getElementById("grade").value = "<%=stuInfoDTO.getCurrentGrade()%>";
		  document.getElementById("programOne").value = "<%=stuInfoDTO.getFirstProgram()%>";
		  document.getElementById("programTwo").value = "<%=stuInfoDTO.getSecondProgram()%>";
		  document.getElementById("gender").value ="<%=stuInfoDTO.getGender()%>";
		  document.getElementById("ethnicity").value ="<%=stuInfoDTO.getEthnicity()%>";
	}
</script>
<script>
	$(document).ready(function() {
		$('#waitListOne').click(function(event) {
			var studentId = "<%=stuInfoDTO.getStudentID()%>";
			var choice = '1';
			var programId = "<%=stuInfoDTO.getFirstProgram()%>";
			var status = "${stuInformationDTO.firstProgramStatus}";
			$.get('WaitList', {
				studentId : studentId ,choice :choice ,
				programId : programId , status : status
			}, function(responseText) {
				$('#One').html(responseText);
			});
		});
	});
</script>
<script>
	$(document).ready(function() {
		$('#placedOne').click(function(event) {
			var studentId = "<%=stuInfoDTO.getStudentID()%>";
			var choice = '1';
			var programId = "<%=stuInfoDTO.getFirstProgram()%>";
			var status = "${stuInformationDTO.firstProgramStatus}";
			var programName = "${stuInformationDTO.firstProgramName}";
			$.get('PlaceStudentsInCC', {
				studentId : studentId ,choice :choice ,
				programId : programId ,status : status ,programName :programName
			}, function(responseText) {
				$('#One').html(responseText);
			});
		});
	});
</script>
<script>
	$(document).ready(function() {
		$('#waitListTwo').click(function(event) {
			var studentId = "<%=stuInfoDTO.getStudentID()%>";
			var choice = '2';
			var programId = "<%=stuInfoDTO.getSecondProgram()%>";
			var status = "${stuInformationDTO.secondProgramStatus}";
			$.get('WaitList', {
				studentId : studentId ,choice :choice ,
				programId : programId , status : status
			}, function(responseText) {
				$('#Two').html(responseText);
			});
		});
	});
</script>
<script>
	$(document).ready(function() {
		$('#placedTwo').click(function(event) {
			var studentId = "<%=stuInfoDTO.getStudentID()%>";
			var choice = '2';
			var programId = "<%=stuInfoDTO.getFirstProgram()%>";
			var status = "${stuInformationDTO.secondProgramStatus}";
			var programName = "${stuInformationDTO.secondProgramName}";
			$.get('PlaceStudentsInCC', {
				studentId : studentId,
				choice : choice,
				programId : programId,
				status : status,
				programName : programName
			}, function(responseText) {
				$('#Two').html(responseText);
			});
		});
	});
</script>
<script>
	$(document).ready(function() {
		$('#interviewYes').click(function(event) {
			var studentId = "<%=stuInfoDTO.getStudentID()%>";
			$.get('InterviewRequired', {
				studentId : studentId,
			}, function(responseText) {
				$('#interviewRequired').html(responseText);
			});
		});
	});
</script>
<script>
	$(document).ready(function() {
		$('input:radio[name=homeschool]').change(function(event) {
			var studentId = "<%=stuInfoDTO.getStudentID()%>";
			var val = $('input:radio[id=homeschool]:checked').val();
			$.get('HomeSchoolApproval', {
				studentId : studentId,val : val,
			}, function(responseText) {
				$('#homeSchoolApproval').html(responseText);
			});
		});
	});
</script>
<script>
	$(document).ready(function() {
		$('input:radio[name=interview]').change(function(event) {
			var studentId = "<%=stuInfoDTO.getStudentID()%>";
			var val = $('input:radio[id=interview]:checked').val();
			$.get('InterviewRequired', {
				studentId : studentId,
				val : val,
			}, function(responseText) {
				$('#interviewRequiredChange').html(responseText);

			});
			if($('input:radio[name=interview]:checked').val() == 2)
			{
				$("#interviewGrade").css("visibility", "visible");
				
			}
			if($('input:radio[name=interview]:checked').val() == 1)
			{
				$("#interviewGrade").css("visibility", "hidden");
			}
		});
	});
	$(document).ready(function() {
		$('#interviewgradeOne').change(function(event){
			var interviewgradeOne = $('#interviewgradeOne option:selected').val();
			var studentId = "<%=stuInfoDTO.getStudentID()%>";
			var choice = 1;
			$.get('InterviewGrade', {
				interviewgradeOne : interviewgradeOne,
				studentId : studentId,
				choice : choice
			});
		});
	});
	
	$(document).ready(function() {
		$('#interviewgradeTwo').change(function(event){
			var interviewgradeTwo = $('#interviewgradeTwo option:selected').val();
			var studentId = "<%=stuInfoDTO.getStudentID()%>";
			var choice = 2;
			$.get('InterviewGrade', {
				interviewgradeTwo : interviewgradeTwo,
				studentId : studentId,
				choice : choice
							});
					});
					});
</script>

<script>
	
</script>
<script type="text/javascript">
	function interviewGrade() {
		alert("hi");
		var visibility = document.getElementById("interviewGrade");
		alert(visibility)
		visibility.style.visibility = "visible";
	}
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
		<div style="width: 100%; margin-left: 350px">
			Career Center Profile<br> First Name :
			${stuInformationDTO.studentFirstName}<br> Last Name :
			${stuInformationDTO.studentLastName}<br>
		</div>
		<br>

		<div>
			<form action="CCStuInformationProfileUpdate" method="Post"
				name="stuInformation">
				<div
					style="background-color: #A52A2A; color: #FAEBD7; text-align: center">
					<b>Personal Information</b>
				</div>
				<div
					style="float: left; width: 45%; margin-left: 5%; Padding-top: 15px;">
					Current School*
					<%
					SchoolsDTO schoolsDTO = new SchoolsDTO();
					List<SchoolsDTO> school = (ArrayList) request.getAttribute("school");
				%>
					<select name="school" id="school" required="required">
						<option value="0">Select</option>
						<c:forEach items="${school}" var="school">
							<option value="${school.schoolID}">${school.schoolName}</option>
						</c:forEach>
					</select> <br> Current Grade Level*
					<%
 	CurrentGradeDTO currentGradeDTO = new CurrentGradeDTO();
 	List<CurrentGradeDTO> grade = (ArrayList) request.getAttribute("grade");
 %>
					<select name="grade" id="grade">
						<option value="0">Select</option>
						<c:forEach items="${grade}" var="grade">
							<option value="${grade.currentGradeId}">${grade.currentGrade}</option>
						</c:forEach>
					</select> <br /> GPA* :
					<c:choose>
						<c:when test="${stuInformationDTO.GPA != 0}">
							<input type="text" id="GPA" name="GPA" required="required"
								value="${stuInformationDTO.GPA}">
						</c:when>
						<c:otherwise>
							<input type="text" id="GPA" name="GPA" required="required">
						</c:otherwise>
					</c:choose>
					<br> 1st choice of Program*:
					<%
						ProgramsDTO programsDTO = new ProgramsDTO();
						List<ProgramsDTO> program = (ArrayList) request.getAttribute("program");
					%>
					<select name="programOne" id="programOne">
						<option value="0" selected="selected">Select</option>
						<c:forEach items="${program}" var="program">
							<option value="${program.progarmID}">${program.programName}</option>
						</c:forEach>
					</select>
				</div>
				<div style="float: right; width: 50%; Padding-top: 15px;">
					2nd choice of Program* : <select name="programTwo" id="programTwo">
						<option value="0">Select</option>
						<c:forEach items="${program}" var="program">
							<option value="${program.progarmID}">${program.programName}</option>
						</c:forEach>
					</select><br> Gender*:
					<%
						GenderDTO genderDTO = new GenderDTO();
						List<GenderDTO> gender = (ArrayList) request.getAttribute("gender");
					%>
					<select name="gender" id="gender">
						<option value="0" selected="selected">Select</option>
						<c:forEach items="${gender}" var="gender">
							<option value="${gender.genderID}">${gender.genderName}</option>
						</c:forEach>
					</select> <br> Ethnicity*:
					<%
 	EthnicityDTO ethnicityDTO = new EthnicityDTO();
 	List<EthnicityDTO> ethnicity = (ArrayList) request.getAttribute("ethnicity");
 %>
					<select name="ethnicity" id="ethnicity">
						<option value="0">Select</option>
						<c:forEach items="${ethnicity}" var="ethnicity">
							<option value="${ethnicity.ethnicityID}">${ethnicity.ethnicityName}</option>
						</c:forEach>

					</select> <br> DOB: <input type="text" name="DOB" id="DOB"
						required="required" value="${stuInformationDTO.DOB}">
					<c:if test="${stuInformationDTO != null }">
						<script type="text/javascript">
							populateDropdown();
						</script>
					</c:if>
				</div>
				<center>
					*Required <input type="submit" value="Update"
						onclick="return validate_page()">
				</center>
			</form>
		</div>
		<!-- Personal Information div  -->

		<div>
			<form action="CCContactInfoProfileUpdate" method="post" name="form">
				<div
					style="background-color: #A52A2A; color: #FAEBD7; text-align: center">
					<b>Contact Information</b>
				</div>
				<div
					style="float: left; width: 45%; margin-left: 5%; Padding-top: 15px;">
					Address Line 1*: <input type="text" id="addressLineOne"
						maxlength="12" name="addressLineOne" required="required"
						value='${contactInformationDTO.addressLineOne}'><br />
					Street*: <input type="text" id="street" name="street"
						maxlength="32" required="required"
						value='${contactInformationDTO.street}'><br /> City*: <input
						type="text" maxlength="8" id="city" name="city"
						value="${contactInformationDTO.city}" required="required"><br />
					State*: <input type="text" maxlength="2" id="state" name="state"
						value="${contactInformationDTO.state}" required="required"><br />
				</div>


				<div style="float: right; width: 50%; Padding-top: 15px;">
					Zip*:<input type="text" id="zip" maxlength="5" name="zip"
						required="required" value="${contactInformationDTO.zipCode}">
					<br /> Student Phone:
					<c:choose>
						<c:when
							test="${contactInformationDTO.studentCellNumber != 'null'}">
							<input type="tel" name="studentPhone" id="studentPhone"
								value='${contactInformationDTO.studentCellNumber}'>
						</c:when>
						<c:otherwise>
							<input type="tel" name="studentPhone" id="studentPhone">
						</c:otherwise>
					</c:choose>
					<br /> Student Home Phone:
					<c:choose>
						<c:when test="${contactInformationDTO.homePhoneNumber != 'null'}">
							<input type="tel" name="studentHomePhone" id="studentHomePhone"
								value='${contactInformationDTO.homePhoneNumber}'>
						</c:when>
						<c:otherwise>
							<input type="tel" name="studentHomePhone" id="studentHomePhone">
						</c:otherwise>
					</c:choose>
				</div>

				*Required <input type="submit" value="Update" name="Next"
					onclick="return validate();">
			</form>
		</div>
		<!-- Contac Information div -->

		<div style="width: 100%; height: 250px;">
			<div
				style="background-color: #A52A2A; color: #FAEBD7; text-align: center">
				<b>Home School and Interview</b>
			</div>
			
			<div id="interviewGrade" style="visibility: hidden; float: right;padding-top : 15px">
				Select interview performance for
				${stuInformationDTO.firstProgramName} <select id="interviewgradeOne">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select><br> Select interview performance for
				${stuInformationDTO.secondProgramName} <select
					id="interviewgradeTwo">
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
					<option value="6">6</option>
					<option value="7">7</option>
					<option value="8">8</option>
					<option value="9">9</option>
					<option value="10">10</option>
				</select>
			</div>
			
			<div
				style="float: left; margin-left: 35px; width: 45%; padding-top: 15px;"
				id="interviewRequired">
				<div id="interviewRequiredChange">
					Interview Required :
					<c:if test="${! empty stuInformationDTO.interviewStatus}">${stuInformationDTO.interviewStatus}</c:if>
					<c:if test="${ empty stuInformationDTO.interviewStatus}">Unknown Status</c:if>
				</div>
				<input type="radio" id="interview" name="interview" value="1">Interview
				Required.<br> <input type="radio" id="interview"
					name="interview" value="2">Interview done.<br> <br>
					
			</div>
			<div
				style="float: left; margin-left: 35px; width: 45%;clear : both;"
				id="homeSchool">
				<div id="homeSchoolApproval">Contact Home School :</div>
				<input type="radio" id="homeschool" name="homeschool" value="1">Contact
				Home School<br> <input type="radio" id="homeschool"
					name="homeschool" value="4">Don't Contact Home School<br>
			</div>

			

		</div>
		<!-- Home school and interview div -->


		<div>
			<div
				style="background-color: #A52A2A; color: #FAEBD7; text-align: center">
				<b>Student and Course Information</b>
			</div>
			
			<div style="float: left; width: 45%; margin-left: 5%">
				<div id="One" style="padding-top: 15px;">
					<b>Program Choice One</b><br /> Name :
					${stuInformationDTO.firstProgramName}<br> Status :
					${stuInformationDTO.firstProgramStatus}<br> Rank :
					${stuInformationDTO.firstProgramRank} <br>
				</div>
				<input type="submit" value="waitlist" id="waitListOne"> <input
					type="submit" value="placed" id="placedOne">
			</div>
			<div style="float: right; width: 45%; margin-left: 5%">
				<div id="Two" style="padding-top: 15px;">
					<b>ProgramChoice Two</b><br /> Name :
					${stuInformationDTO.secondProgramName}<br> Status :
					${stuInformationDTO.secondProgramStatus}<br> Rank :
					${stuInformationDTO.secondProgramRank} <br>
				</div>
				<input type="submit" value="waitlist" id="waitListTwo"> <input
					type="submit" value="placed" id="placedTwo">
			</div>
		</div>
		<!--  Student and course information -->

	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

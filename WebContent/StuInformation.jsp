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


<script>
	$(document).ready(function() {
		$('input').each(function(event) {
			$(this).focus(function(){
				$(this).addClass("textBoxColor");
			});
			$(this).blur(function(){
				$(this).removeClass("textBoxColor");
			});
		});
		$("#imgOne").mouseover(function() {
			$("#dataOne").fadeIn(500);
		});
		$("#imgOne").mouseout(function() {
			$("#dataOne").fadeOut(500);
		});
		$("#imgTwo").mouseover(function() {
			$("#dataTwo").fadeIn(500);
		});
		$("#imgTwo").mouseout(function() {
			$("#dataTwo").fadeOut(500);
		});
		$("#imgThree").mouseover(function() {
			$("#dataThree").fadeIn(500);
		});
		$("#imgThree").mouseout(function() {
			$("#dataThree").fadeOut(500);
		});
		$("#imgFour").mouseover(function() {
			$("#dataFour").fadeIn(500);
		});
		$("#imgFour").mouseout(function() {
			$("#dataFour").fadeOut(500);
		});
		$("#imgFive").mouseover(function() {
			$("#dataFive").fadeIn(500);
		});
		$("#imgFive").mouseout(function() {
			$("#dataFive").fadeOut(500);
		});
		$("#imgSix").mouseover(function() {
			$("#dataSix").fadeIn(500);
		});
		$("#imgSix").mouseout(function() {
			$("#dataSix").fadeOut(500);
		});
		$("#imgSeven").mouseover(function() {
			$("#dataSeven").fadeIn(500);
		});
		$("#imgSeven").mouseout(function() {
			$("#dataSeven").fadeOut(500);
		});
		$("#imgEight").mouseover(function() {
			$("#dataEight").fadeIn(500);
		});
		$("#imgEight").mouseout(function() {
			$("#dataEight").fadeOut(500);
		});
	});
</script>

<script type="text/javascript">


function validateGPA() {
	var gpa = document.getElementById("GPA").value;
	if (isNaN(gpa)) {
		return false;
	}
	if (gpa<1 || gpa >5) {
		return false;
	}
	if (gpa >= 1 && gpa <= 5) {
		return true;
	}
}


function validateValues() {
	var school = document.getElementById("school").value;
	var grade = document.getElementById("grade").value;
	var programOne = document.getElementById("programOne").value;
	var programTwo = document.getElementById("programTwo").value;
	var gender = document.getElementById("gender").value;
	var ethnicity = document.getElementById("ethnicity").value;
	if (school == 0 || grade == 0 || programOne == 0 || programTwo == 0 || gender == 0 || ethnicity == 0) {
		return false;
	}
	return true;
}


function validate_page() {

	var values = validateValues();
	var gpa = validateGPA();
	
	if(values == false)
	{
	document.getElementById("error").innerHTML = "Fill all the details.";
	return false;
	}
	else
		{
		document.getElementById("error").innerHTML = " ";
		}
	
	if(gpa == false)
	{
		document.getElementById("error").innerHTML = "Enter a valid GPA between 1 and 5.";
		return false;
	}
	else
		{
		document.getElementById("error").innerHTML = ( " " );
		}
	
	if (gpa == false || values == false)
		return false;
	else
		{
		document.getElementById("error").innerHTML = '';
		return true;
		}
}


function populateDropdown() {
	<%StuInformationDTO stuInfoDTO = (StuInformationDTO) request.getAttribute("stuInformationDTO");%>
	  document.getElementById("school").value = "<%=stuInfoDTO.getSchoolID()%>";
	  document.getElementById("grade").value = "<%=stuInfoDTO.getCurrentGrade()%>";
	  document.getElementById("programOne").value = "<%=stuInfoDTO.getFirstProgram()%>";
	  document.getElementById("programTwo").value = "<%=stuInfoDTO.getSecondProgram()%>";
	  document.getElementById("gender").value ="<%=stuInfoDTO.getGender()%>";
	  document.getElementById("ethnicity").value ="<%=stuInfoDTO.getEthnicity()%>";
	}
</script>

</head>

<body>

	<div class="header">
		<h1>Way to Success</h1>
	</div>

	<div class="content">

		<div style="width: 10px; height: 30px; color: gray; float: left;">
			<form action="Logout" method="post">
				<input type="submit" value="Logout" id="button" />
			</form>
		</div>

		<h1>Student Information</h1>

		<div class="alignleft">
			${stuInfomessage}<br>

			<form action="StuInformation" method="Post" name="stuInformation">
				<div class="error">
					<span id="error"></span>
				</div>


				<table>
					<tr>
						<td>Current School*</td>
						<%
							SchoolsDTO schoolsDTO = new SchoolsDTO();
							List<SchoolsDTO> school = (ArrayList) request.getAttribute("school");
						%>
						<td><select name="school" id="school" required="required">
								<option value="0">Select</option>
								<c:forEach items="${school}" var="school">
									<option value="${school.schoolID}">${school.schoolName}</option>
								</c:forEach>
						</select></td>
						<td><img id="imgOne" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataOne" style="display: none">Select your
								Home school.</div></td>
					</tr>
					<tr>
						<td>Current Grade Level*</td>
						<%
							CurrentGradeDTO currentGradeDTO = new CurrentGradeDTO();
							List<CurrentGradeDTO> grade = (ArrayList) request.getAttribute("grade");
						%>
						<td><select name="grade" id="grade">
								<option value="0">Select</option>
								<c:forEach items="${grade}" var="grade">
									<option value="${grade.currentGradeId}">${grade.currentGrade}</option>
								</c:forEach>
						</select> <br></td>
						<td><img id="imgTwo" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataTwo" style="display: none">Select your
								current grade.</div></td>
					<tr>
						<td>GPA* :</td>
						<td><c:choose>
								<c:when test="${stuInformationDTO.GPA != 0}">
									<input type="text" id="GPA" name="GPA" required="required"
										value="${stuInformationDTO.GPA}">
								</c:when>
								<c:otherwise>
									<input type="text" id="GPA" name="GPA" required="required">
								</c:otherwise>
							</c:choose></td>
						<td><img id="imgThree" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataThree" style="display: none">Enter
								your GPA in between 1 and 5.</div></td>
					</tr>
					<tr>
						<td>1st choice of Program*:</td>
						<%
							ProgramsDTO programsDTO = new ProgramsDTO();
							List<ProgramsDTO> program = (ArrayList) request.getAttribute("program");
						%>
						<td><select name="programOne" id="programOne">
								<option value="0" selected="selected">Select</option>
								<c:forEach items="${program}" var="program">
									<option value="${program.progarmID}">${program.programName}</option>
								</c:forEach>
						</select></td>
						<td><img id="imgFour" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataFour" style="display: none">Select
								your First choice of program.</div></td>
					</tr>
					<tr>
						<td>2nd choice of Program* :</td>
						<td><select name="programTwo" id="programTwo">
								<option value="0">Select</option>
								<c:forEach items="${program}" var="program">
									<option value="${program.progarmID}">${program.programName}</option>
								</c:forEach>
						</select></td>
						<td><img id="imgFive" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataFive" style="display: none">Select
								your Second choice of program.</div></td>
					</tr>
					<tr>
						<td>Gender*:</td>
						<%
							GenderDTO genderDTO = new GenderDTO();
							List<GenderDTO> gender = (ArrayList) request.getAttribute("gender");
						%>
						<td><select name="gender" id="gender">
								<option value="0" selected="selected">Select</option>
								<c:forEach items="${gender}" var="gender">
									<option value="${gender.genderID}">${gender.genderName}</option>
								</c:forEach>
						</select></td>
						<td><img id="imgSix" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataSix" style="display: none">Select your
								gender.</div></td>
					</tr>
					<tr>
						<td>Ethnicity*:</td>
						<%
							EthnicityDTO ethnicityDTO = new EthnicityDTO();
							List<EthnicityDTO> ethnicity = (ArrayList) request.getAttribute("ethnicity");
						%>
						<td><select name="ethnicity" id="ethnicity">
								<option value="0">Select</option>
								<c:forEach items="${ethnicity}" var="ethnicity">
									<option value="${ethnicity.ethnicityID}">${ethnicity.ethnicityName}</option>
								</c:forEach>
						</select></td>
						<td><img id="imgSeven" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataSeven" style="display: none">Select
								your Ethnicity.</div></td>
					</tr>
					<tr>
						<td>DOB:</td>
						<td><input type="text" name="DOB" id="DOB"
							required="required" value="${stuInformationDTO.DOB }"></td>
						<td><img id="imgEight" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataEight" style="display: none">Enter
								your DOB.</div></td>
					</tr>
					<tr>
						<td>* Required <input type="submit" value="Next" name="next"
							id="next" onclick="return validate_page()"></td>
					</tr>
				</table>


				<c:if test="${stuInformationDTO != null }">
					<script type="text/javascript">
						populateDropdown();
					</script>
				</c:if>
				<!--  This is java script call to populate the details. -->

			</form>

		</div>
		<!-- Close of left float  -->

	</div>
	<!--  Contect close -->
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

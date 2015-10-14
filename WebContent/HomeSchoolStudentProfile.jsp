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
<script src="ScrollImages.js"></script>
<script src="http://code.jquery.com/jquery-latest.js">
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

</head>
<body>
<noscript class="noJavascript">JavaScript is off. Javascript must be enabled to use this site .</noscript>
	<div class="header">
		<h1>Way to Success</h1>
	</div>
	
	<div class="hscontent">
	<div style="float: left;">
		<div style="width: 10px; height: 30px; color: gray;">
			<form action="HomeSchoolLogOut" method="post">
				<input type="submit" value="Logout" id="button" />
			</form>
		</div>
	</div>
		<div style=" width: 100%;margin-left: 350px">
			Student Profile<br>
			First Name : ${stuInformationDTO.studentFirstName}<br> 
			Last Name  : ${stuInformationDTO.studentLastName}<br>
		</div>
		<div>
			<form action="CCStuInformationProfileUpdate" method="Post"
				name="stuInformation">
				<div
					style="background-color: #A52A2A; color: #FAEBD7; text-align: center">
					<b>Personal Information</b>
				</div>
				<div style="float: left; width: 45%; margin-left: 5%">
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
				<div style="float: right; width: 50%">
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

					</select> <br> DOB: <input type="text" value="DOB" name="DOB"
						required="required" value="${stuInformationDTO.DOB}">
					<c:if test="${stuInformationDTO != null }">
						<script type="text/javascript">
							populateDropdown();
						</script>
					</c:if>
				</div>
				<center>
					<input type="submit" value="Update"
						onclick="return validate_page()">
				</center>
			</form>
		</div>
		<div>
			<form action="CCContactInfoProfileUpdate" method="post" name="form">
				<div
					style="background-color: #A52A2A; color: #FAEBD7; text-align: center">
					<b>Contact Information</b>
				</div>
				<div style="float: left; width: 45%; margin-left: 5%">
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
				<div style="float: right; width: 50%">
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
					<!-- 	<br /> Additional Email: <input type="email"
						name="additionalEmail" id="additionalEmail"><br />  -->
				</div>

				*Required <input type="submit" value="Update" name="Next"
					onclick="return validate();">

			</form>
		</div>
		<div style="width: 100%; height: 180px;">
			<div
				style="background-color: #A52A2A; color: #FAEBD7; text-align: center">
				<b>Home School Updates</b>
			</div>
			
			<div style="float: left; margin-left: 35px; width: 45%"
				id="homeSchool">
				<div id="homeSchoolApproval">
				Contact Home School :
				</div>
								<input type="radio"
					id="homeschool" name="homeschool" value="3">Approved.<br> 
							<input type="radio"
					id="homeschool" name="homeschool" value="5">Details are not valid.<br> 
							</div>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

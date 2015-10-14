<%@page import="DTO.ContactInformationDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Enroll track</title>
<link href="CSS/StyleSheet2.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-latest.js">
	
</script>

<script>
	$(document).ready(function() {
		$('input').each(function(event) {
			$(this).focus(function() {
				$(this).addClass("textBoxColor");
			});
			$(this).blur(function() {
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
	function validateZip() {
		var zip = document.getElementById("zip").value;
		if (isNaN(zip)) {
			return false;
		}
		if (zip.length != 5) {
			return false;
		} else {
			return true;
		}

	}
	//end of validate zip

	function validatePhoneNumber() {
		var studentPhoneNumber = document.getElementById("studentPhone").value;
		var studentHomePhone = document.getElementById("studentHomePhone").value;
		var cellnunber = /^\d{10}$/;
		if ((studentPhoneNumber.match(cellnunber))
				&& studentHomePhone.match(cellnunber)) {
			return true;
		} else {

			return false;
		}
	}
	// end of valida phone

	function validate() {
		var zip = validateZip();
		var phone = validatePhoneNumber();
		var addressLineOne = document.getElementById("addressLineOne").value;
		var street = document.getElementById("street").value;
		var city = document.getElementById("city").value;
		var state = document.getElementById("state").value;
		var zipCode = document.getElementById("zip").value;
		var studentPhone = document.getElementById("studentPhone").value;
		var homePhone = document.getElementById("studentHomePhone").value;
		if (addressLineOne == '' || street == '' || city == '' || state == ''
				|| zipCode == '') 
		{
			document.getElementById("error").innerHTML
					= ("Fill all the details.");
			return false;
		}
		else if (zip) {
				}
		else
			{
			alert("else1")
			document.getElementById("error").innerHTML
					= ("Enter a valid ZIP code.");
			return false;
		}
		if (phone){}
		else {
			alert("else2")
			document.getElementById("error").innerHTML
					= ("Enter valid phone number.");
			return false;
		}
	}
</script>

</head>

<body>
<noscript class="noJavascript">JavaScript is off. Javascript must be enabled to use this site .</noscript>
	<div class="header">
		<h1>Way to Success</h1>
	</div>

	<div class="content">
		<div style="width: 10px; height: 30px; color: gray; float: left;">
			<form action="Logout" method="post">
				<input type="submit" value="Logout" id="button" />
			</form>
		</div>
		<h1>Contact Information</h1>
		<div class="alignleft">
			<form action="ContactInformation" method="post" name="form">
				<div class="error">
					<span id="error"></span>
				</div>
				<div class="error">
					${ContactInfoError}<br>
					</div>
				<table>
					<tr>
						<td>Address Line 1*:</td>
						<td><input type="text" id="addressLineOne" maxlength="12"
							name="addressLineOne" required="required"
							value='${contactInformationDTO.addressLineOne}'></td>
						<td><img id="imgOne" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataOne" style="display: none">Enter your
								address line one.</div></td>
					</tr>
					<tr>
						<td>Street*:</td>
						<td><input type="text" id="street" name="street"
							maxlength="32" required="required"
							value='${contactInformationDTO.street}'></td>
						<td><img id="imgTwo" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataTwo" style="display: none">Enter your
								stree name.</div></td>
					</tr>
					<tr>
						<td>City*:</td>
						<td><input type="text" maxlength="8" id="city" name="city"
							value="${contactInformationDTO.city}" required="required"></td>
						<td><img id="imgThree" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataThree" style="display: none">Enter
								your City name.</div></td>
					</tr>
					<tr>
						<td>State*:</td>
						<td><input type="text" maxlength="2" id="state" name="state"
							value="${contactInformationDTO.state}" required="required"></td>
						<td><img id="imgEight" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataEight" style="display: none">Enter
								your State Code.</div></td>
					</tr>
					<tr>
						<td>Zip*:</td>
						<td><input type="text" id="zip" maxlength="5" name="zip"
							required="required" value="${contactInformationDTO.zipCode}">
						</td>
						<td><img id="imgFour" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataFour" style="display: none">Enter your
								Zip code of 5 digits.</div></td>
					</tr>
					<tr>
						<td>Student Phone:</td>
						<td><c:choose>
								<c:when
									test="${contactInformationDTO.studentCellNumber != 'null'}">
									<input type="tel" name="studentPhone" id="studentPhone"
										value='${contactInformationDTO.studentCellNumber}'>
								</c:when>
								<c:otherwise>
									<input type="tel" name="studentPhone" id="studentPhone">
								</c:otherwise>
							</c:choose></td>
						<td><img id="imgFive" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataFive" style="display: none">Enter your
								student Phone number.</div></td>
					</tr>
					<tr>
						<td>Student Home Phone:</td>
						<td><c:choose>
								<c:when
									test="${contactInformationDTO.homePhoneNumber != 'null'}">
									<input type="tel" name="studentHomePhone" id="studentHomePhone"
										value='${contactInformationDTO.homePhoneNumber}'>
								</c:when>
								<c:otherwise>
									<input type="tel" name="studentHomePhone" id="studentHomePhone">
								</c:otherwise>
							</c:choose></td>
						<td><img id="imgSix" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataSix" style="display: none">Enter your
								student HomePhone number.</div></td>
					</tr>
					<tr>
						<td>*Required <input type="submit" value="Next" name="Next"
							onclick="return validate();"></td>
					</tr>
				</table>

			</form>

		</div>
		<!-- end of  -->
	</div>
	<!-- end of content -->

	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

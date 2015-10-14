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

<script>
	$(document).ready(
			function() {
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
				$('#PasswordCheck').click(
						function() {
							$('#password').attr(
									'type',
									$(this).is(':checked') ? 'text'
											: 'password');
						});
				$('#ConfirmPasswordCheck').click(
						function() {
							$('#confirmPassword').attr(
									'type',
									$(this).is(':checked') ? 'text'
											: 'password');
						});
			});
	$(document).ready(function() {
		$("#passwordInfo").hide();
		$("#password").focus(function(e) {
			$("#passwordInfo").toggle();
			e.preventDefault();
		});
		$("#password").blur(function(e) {
			$("#passwordInfo").hide();
			e.preventDefault();
		});
	});
</script>

<script type="text/javascript">
	function validateForm() {
		var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
		var firstName = document.getElementById("firstName").value;
		var middleInitials = document.getElementById("middleInitials").value;
		var lastName = document.getElementById("lastName").value;
		var email = document.getElementById("email").value;
		var password = document.getElementById("password").value;
		var confirmPassword = document.getElementById("confirmPassword").value;
		if (firstName == '' ||  lastName == ''
				|| email == '' || password == '' || confirmPassword == '')
		{
			document.getElementById("error").innerHTML = "Fill all the details.";
			return false;
		} else {
		}
		if (re.test(password)) {
			return true;
		} else {
			document.getElementById("errorPassword").innerHTML = ("Enter the valid password.");
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
		<h1>Register Now</h1>

		<div class="alignleft">

			<form action="StuCreateAccount" method="Post">

				<div class="error">
					<span id="error"></span> <span id="errorPassword"></span>
				</div>

				<div class="error">${errorMessage}</div>


				<table>
					<tr>
						<td>First name*:</td>
						<td><input type="text" name="FirstName" id="firstName"
							required="required" value='${stuCreateAccountDTO.firstName}'></td>
						<td><img id="imgOne" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataOne" style="display: none">Enter your
								First name associated with your ID.</div></td>
					</tr>
					<tr>
						<td>Middle Initial:</td>
						<td><input type="text" name="MiddleInitial"
							id="middleInitials" value='${stuCreateAccountDTO.middleInitial}'></td>
						<td><img id="imgTwo" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataTwo" style="display: none">Enter your
								Middle Initials associated with your ID.</div></td>
					</tr>
					<tr>
						<td>Last name* :</td>
						<td><input type="text" name="LastName" id="lastName"
							required="required" value='${stuCreateAccountDTO.lastName}'></td>
						<td><img id="imgThree" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataThree" style="display: none">Enter
								your Last name associated with your ID.</div></td>
					</tr>
					<tr>
						<td>Email Address*:</td>
						<td><input type="email" name="Email" id="email"
							required="required" value='${stuCreateAccountDTO.email}'></td>
						<td><img id="imgFour" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataFour" style="display: none">Enter your
								email address.</div></td>
					</tr>
					<tr>
						<td>Password*:</td>
						<td><input type="password" name="PassWord" id="password"
							required="required" value='${stuCreateAccountDTO.passWord}'></td>
						<td><img id="imgFive" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataFive" style="display: none">Enter
								Password.</div></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" id="PasswordCheck"
							value="ShowPassword" />Show Password.</td>
					</tr>
					<tr>
						<td>ConfirmPassword*:</td>
						<td><input type="password" name="ConfirmPassWord"
							id="confirmPassword" required="required"
							value='${stuCreateAccountDTO.confirmPassWord}'></td>
						<td><img id="imgSix" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataSix" style="display: none">Password
								and Confirm password both should be equal.</div></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" id="ConfirmPasswordCheck"
							value="ConfirmShowPassword" />Show Password.</td>
					</tr>
					<tr>
						<td>*Required <input type="submit" name="Create"
							value="Register" onclick="return validateForm();"></td>
					</tr>

				</table>

				<div class="passwordBoxDecoration" id="passwordInfo">Password
					should contain atleast one Special charecter, atlest one captial
					letter , atlest one small letter and minimum length of 6.</div>

			</form>

		</div>
		<!-- Float left for placing the contect left side div clised. -->

	</div>
	<!--  Content div close -->

	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

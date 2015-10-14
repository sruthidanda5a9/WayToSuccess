<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
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
				$('#PasswordCheck').click(
						function() {
							$('#passWord').attr(
									'type',
									$(this).is(':checked') ? 'text'
											: 'password');
						});
			});
</script>

</head>
<body>
<noscript class="noJavascript">JavaScript is off. Javascript must be enabled to use this site .</noscript>
	<div class="header">
		<h1>Way to Success</h1>
	</div>
	<div class="content">
		<h1>Career Center</h1>
		<h1>Login</h1>
		<div class="alignCenter">
			<div class="error">${errorMessage}</div>
			<form action="CraeerCenterLoginCheck" method="post">
				<table>
					<tr>
						<td>UserName/Email :</td>
						<td><input type="email" name="userName" required="required">
						</td>
						<td><img id="imgOne" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataOne" style="display: none">Enter your
								registered email address</div></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="password" name="passWord"
							required="required"></td>
						<td><img id="imgTwo" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataTwo" style="display: none">Enter your
								Password</div></td>

					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" id="PasswordCheck"
							value="ShowPassword" />Show Password</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="SIGN IN" class="SubmitButton"></td>
					</tr>
				</table>

			</form>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

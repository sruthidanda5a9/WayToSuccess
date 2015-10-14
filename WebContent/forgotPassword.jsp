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
	});
</script>

<script>
	$(function() {
		$("#DOB").datepicker();
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
		<h1>Forgot Password</h1>
		<div class="alignCenter">
			<div class="error">${errorMessageFP}</div>
			<form action="ForgotPassword" method="post">
				<table>
					<tr>
						<td>Email :
						<td><input type="email" name="userName" required="required"></td>
						<td><img id="imgOne" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataOne" style="display: none">Enter your
								registered email address.</div></td>
					</tr>
					<tr>
						<td>DOB :</td>
						<td><input type="text" name="DOB" 
							id="DOB"></td>
						<td><img id="imgTwo" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataTwo" style="display: none">Enter your
								DOB.</div></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" value="Submit" class="SubmitButton"></td>
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

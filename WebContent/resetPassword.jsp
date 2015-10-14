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
	$('#PasswordCheck').click(
			function() {
				$('#password').attr('type',
						$(this).is(':checked') ? 'text' : 'password');
			});
	$('#ConfirmPasswordCheck').click(
			function() {
				$('#confirmPassword').attr('type',
						$(this).is(':checked') ? 'text' : 'password');
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
	function validatePassword() {
		var re = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
		var password = document.getElementById("password").value;
		var test = re.test(password);
		if (re.test(password)) {
			return true;
		}
		else
			{
			document.getElementById("error").innerHTML = ("Enter the valid password.");
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
		<h1>Career Center</h1>
		<h1>Reset Password</h1>
		<div class="alignCenter">
			<div class="error">
				<span id="error"></span>
			</div>
			<div class="error">${errorMessageRP}</div>
			<form action="ResetPassword" method="post">
				<table>
					<tr>
						<td>Password*:</td>
						<td><input type="password" name="password" id="password"
							required="required"></td>
						<td><img id="imgOne" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataOne" style="display: none">Enter
								Password.</div></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" id="PasswordCheck"
							value="ShowPassword" />Show Password.</td>
					</tr>
					<tr>
						<td>ConfirmPassword*:</td>
						<td><input type="password" name="confirmPassword"
							id="confirmPassword" required="required"></td>
						<td><img id="imgTwo" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataTwo" style="display: none">Password
								and Confirm password both should be equal.</div></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="checkbox" id="ConfirmPasswordCheck"
							value="ConfirmShowPassword" />Show Password.</td>
					</tr>
					<tr>
						<td>*Required <input type="submit" name="Submit"
							value="Submit" onclick="return validatePassword();"></td>
					</tr>

				</table>

				<div class="passwordBoxDecoration" id="passwordInfo">Password
					should contain atleast one Special charecter, atlest one captial
					letter , atlest one small letter and minimum length of 6.</div>

			</form>

		</div>
	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

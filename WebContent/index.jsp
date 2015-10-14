<html>
<head>
<title>Enroll track</title>
<link href="CSS/StyleSheet2.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script type="text/javascript">var switchTo5x=true;</script>
<script type="text/javascript" src="http://w.sharethis.com/button/buttons.js"></script>
<script type="text/javascript">stLight.options({publisher: "05fead7f-660c-423e-beef-24de2f467a03", doNotHash: false, doNotCopy: false, hashAddressBar: false});</script>
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
		$('#PasswordCheck').click(function(){
			$('#passWord').attr('type',$(this).is(':checked') ? 'text' : 'password');
		});
	});
</script>
</head>
<body>
<noscript class="noJavascript">JavaScript is off. Javascript must be enabled to use this site .</noscript>
<div class="header">
		<h1>Way to Success</h1>
</div>
	<!-- Links to Facebook , google+ , twitter -->
	<div style="padding-left:10px;padding-top:100px;float:left">
	<span class='st_facebook_large' displayText='Facebook'></span><br>
	<span class='st_twitter_large' displayText='Tweet'></span><br>
	<span class='st_linkedin_large' displayText='LinkedIn'></span><br>
	<span class='st_pinterest_large' displayText='Pinterest'></span><br>
	<span class='st_email_large' displayText='Email'></span><br>
	<span class='st_googleplus_large' displayText='Google +'></span><br>
	</div>
	<div class="content">
	<h1>Career Center</h1>
		<h1>Login</h1>
		<div class="alignCenter">
			<div class="error">${errorMessage}</div>
			 <div class="message">${MessageRP}</div>
			<form action="LoginCheck" method="post">
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
						<td>Password :</td>
						<td><input type="password" name="passWord"
							required="required" id="passWord"></td>
						<td><img id="imgTwo" src="question.png"
							style="width: 15px; height: 15px" /></td>
						<td><div id="dataTwo" style="display: none">Enter your
								Password.</div></td>
					</tr>
					<tr><td></td><td><input type="checkbox" id="PasswordCheck" value ="ShowPassword"/>Show Password.</td></tr>
					<tr>
						<td></td>
						<td><input type="submit" value="SIGN IN" class="SubmitButton"></td>
					</tr>
					<tr>
					<td></td>
					<td> <a href="forgotPassword.jsp">Forgot Password </a></td>
					</tr>
				</table>
			</form>
			If you don't have an Account please click on APPLY NOW to create an
			account.<br> <br>
			<div class="loginPageBoxDecoration" ><a href="StuCreateAccount.jsp">APPLY NOW</a></div>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

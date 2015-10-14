<html>
<head>
<title>Enroll track</title>
<link href="CSS/StyleSheet2.css" rel="stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-latest.js">
</script>
<script>
	$(document).ready(function() {
		$('#submit').click(function(event) {
			var username = $('#user').val();
			$.get('AjaxTest', {
				user : username
			}, function(responseText) {
				$('#welcometext').text(responseText);
			});
		});
	});
</script>
</head>
<body>
	<div class="header">
		<h1>Testing AJAX with JQUERY AND JASON</h1>
	</div>
	<div class="content">
		<h1>Login</h1>
		<div class="alignleft">
			<div class="error">${errorMessage}</div>
			<form action="LoginCheck" method="post">
				<table>
					<tr>
						<td>UserName/Email :
						<td><input type="email" id="user" name="user" required="required"></td>
					</tr>
				</table>
				 <input type="button"
					id="submit" value="Ajax Submit" /> <br />
				<div id="welcometext">
				This is the present test before submit
				</div>
			</form>
		</div>
		<div class="alignright">
			<div class="information" id="ajaxTest"></div>
		</div>

	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

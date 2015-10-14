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
	$(document).ready(function() {
		$("#form").hide();
		$("#scheduleselect").click(function(e) {
			$("#form").toggle();
			e.preventDefault();
		});
	});
</script>
<script>
	$(function() {
		$("#date").datepicker({
			dateFormat : 'yyy-dd-mm HH:MM:SS'
		}).val();
	});
</script>
</head>
<body onload="SlideImages()">
	<div class="header">
		<h1>Way to Success</h1>
	</div>
	<div class="content">
		<h1>Status Information</h1>
		<div style="margin-left: 300px; margin-top: 60px;">
			 <div class="statusmessage"><b>${smessage}</b></div>
			 	 ProgramOne Applies :
				${stuInformationDTO.firstProgramName}<br> ProgramOne Status :
				${stuInformationDTO.firstProgramStatus}<br> ProgramTwo Applied
				: ${stuInformationDTO.secondProgramName}<br> ProgramTwo Status
				: ${stuInformationDTO.secondProgramStatus}<br></b>
			<c:if test="${ stuInformationDTO.interviewNeeded == 1}">We request you to schedule an interview with us.  <button id="scheduleselect">Schedule
					interview</button>
			</c:if>

		</div>
		<div id="form" style="margin-left: 300px; margin-top: 10px;">
			<form action="MAILTO:sdanda@neiu.edu" method="post">
				Date    : <input type="text" id="date" size="40" name="date"><br>
				Comment : <textarea rows="4" cols="50" name="comment"></textarea> <input
					type="submit" value="submit">
			</form>
		</div>
	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

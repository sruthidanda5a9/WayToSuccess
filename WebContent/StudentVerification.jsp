<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="DTO.*"%>
<html>
<head>
<title>Enroll track</title>
<link href="CSS/StyleSheet2.css" rel="stylesheet" type="text/css" />
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
		<h1>Verification</h1>

		<form action="StudentVerification" method="Post">
			Name :
			<c:out value='${verification.firstName}'></c:out>
			<c:out value='${verification.lastName}'></c:out>
			<div class="alignleftver" style="width: 300px">
				<h3>Contact Information :</h3>
				<br> Address :
				<c:out value="${verification.addressLineOne}"></c:out>
				<br />
				<c:out value="${verification.street}"></c:out>
				<br />
				<c:out value="${verification.city}"></c:out>
				<br />
				<c:out value="${verification.state}"></c:out>
				<br />
				<c:out value="${verification.zipCode}"></c:out>
				<br /> Student Cell Phone :
				<c:out value="${verification.studentCellNumebr}"></c:out>
				<br /> Student Home Phone :
				<c:out value="${verification.studentHomePhone}"></c:out>
				<br />
			</div>
			<div class="alignrightver" style="width: 300px">
				<h3>Student Information :</h3>
				Current School :
				<c:out value="${verification.currentSchool}"></c:out>
				<br /> Current Standing :
				<c:out value="${verification.currentGrade}"></c:out>
				<br /> Program Choice One:
				<c:out value="${verification.programOne}"></c:out>
				<br /> Program Choice Two:
				<c:out value="${verification.programTwo}"></c:out>
				<br /> Gender :
				<c:out value="${verification.gender}"></c:out>
				Ethnicity :
				<c:out value="${verification.ethnicity}"></c:out>
				<br /> DOB :
				<c:out value="${verification.DOB}"></c:out>
				<br /> <br> <input type="submit" name="Submit" value="Submit">
			</div>
		</form>
	</div>
	<div class="footer">
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>
</body>
</html>

<!-- sbammidi -->
<!-- This page displays the result of data related t a student when clicked on the corresponding student id  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="sbammidi_ServletHW4.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student data</title>
<style type="text/css">
h1 {
	color: blue;
	text-shadow: -4px 4px 6px dimgrey; 
	font-size: 200%;
}

body {
	background-color: #ffeebb;
}

.bgimg {
	position: absolute;
	top: 0px;
	left: 0px;
	z-index: 1;
}

.centerClass {
	text-align: center;
}

.fixed_anchor {
	position: fixed;
	bottom: 0px;
	right: 0px;
}
</style>
</head>
<body>
	<p>
		<a id="anchorId" title="Please visit http://www.gmu.edu for more information" href="https://www2.gmu.edu/" class="fixed_anchor">
			<img src="mason-logo.png" class="fixed_anchor" alt="George Mason Logo" width="260" height="180" />
		</a>
	</p>
	<br />
	
	<div>
		<h4>Student Id: ${studentdata.getStudentId()}</h4><br/>
	</div>
	<table  width="80%" align="center">	
		<tr>
			<td>Name: </td>
			<td>${studentdata.getFirstName()} ${studentdata.getLastName()}</td>
		</tr>
		<tr>
			<td>Address: </td>
			<td>${studentdata.getAddressLine1()} ,${studentdata.getAddressLine2()}, ${studentdata.getCity()}, ${studentdata.getState()}, ${studentdata.getZip()}</td>
		</tr>			
		<tr>
			<td>Telephone number: </td>
			<td>${studentdata.getTelephoneNumber()}</td>
		</tr>
		<tr>
			<td>Email: </td>
			<td>${studentdata.getEmail()}</td>
		</tr>
		<tr>
			<td>URL: </td>
			<td>${studentdata.getUrl()}</td>
		</tr>		
		<tr>
			<td>Data entered for raffle: </td>
			<td>${studentdata.getData()}</td>
		</tr>
		<tr>
			<td>Likelihood to recommend this university: </td>
			<td>${studentdata.getLikelihoodSelectOneMenu()}</td>
		</tr>
		<tr>
			<td>${studentdata.getFirstName()}'s expected graduation month and year: </td>
			<td>${studentdata.getGraduationMonth()}, ${studentdata.getGraduationYear()}</td>
		</tr>
		<tr>
			<td>Additional Comments: </td>
			<td>${studentdata.getAdditionalComments()}</td>
		</tr>
	</table>

</body>
</html>
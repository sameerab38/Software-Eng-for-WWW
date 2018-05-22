<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="sbammidi_ServletHW4.*"%>
<%@page import=" java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!-- Sameera Bammidi -->
<!-- This page displays the winning result, when mean of the data is greater than 90 and acknowledgment for filling the survey-->
<html>
<head>
<title>Winner Acknowledgment</title>

<style>
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
	<form>
		<h1>You won two movie tickets</h1>
		<h2>Thank you for completing the survey!</h2>
		<!-- br /> ${studentBean.getFirstName()} ${studentBean.getLastName()} <br / -->
		<p>Your mean for the raffle numbers is: ${dataBean.getMean()}</p>
		<br />
		<p>Your standard deviation for the raffle numbers is: ${dataBean.getStandardDeviation()}</p>
		<br />
		<p>The information entered on the form was saved to the database
			successfully.</p>
		<br />
		<h4>Select Id's from the following list:</h4>
	
		<ul>
			<%
			String[] studentIdLinks = (String[])request.getAttribute("ackId");
						
			for(String studentId : studentIdLinks)
			{
			%>		
			<li><a href="/sbammidi_ServletHW4/Servlet?id=<%=studentId%>"><%=studentId%></a></li>
			<%
			}
			%>
		</ul>
	</form>
</body>
</html>
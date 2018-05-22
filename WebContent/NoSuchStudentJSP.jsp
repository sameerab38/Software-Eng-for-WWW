<!-- sbammidi -->
<!-- This form is displayed when no such student exists -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>No such Student</title>

<style type = "text/css">

h1
{
	color: blue;
	text-shadow: -4px 4px 6px dimgrey;
	font-size: 200%;
}

body
{
	background-color: #ffeebb;
}

.bgimg { position: absolute;
top: 0px;
left: 0px;
z-index: 1; }

.centerClass
{
text-align: center;
}
.fixed_anchor
{
position: fixed;
bottom: 0px;
right: 0px;
}
</style>
</head>
<body>
	<p><a id="anchorId" title="Please visit http://www.gmu.edu for more information" href = "https://www2.gmu.edu/"   class="fixed_anchor" >
		<img src = "mason-logo.png" class = "fixed_anchor" alt = "George Mason Logo" width="260" height="180"/></a>
	</p>
	<br/>
	<h1>There exists no student with matching student ID!!!</h1>
</body>
</html>
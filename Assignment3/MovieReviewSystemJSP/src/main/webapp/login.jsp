<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean"/>
	<jsp:setProperty name="lb" property="*"/>
	<% lb.authentication(); %>
	
	<% 
	if(lb.getStatus()) {
		out.println("Welecome User!!");
	} else {
		out.println("Invalid Login Credentials, Try Again!");
	}
	%>
</body>
</html>
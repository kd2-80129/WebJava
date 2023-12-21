<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:useBean id="ab" class="com.sunbeam.beans.AddUserBeans"/>
	<jsp:setProperty property="*" name="ab"/>
	
	<% ab.saveUser(); %>
	
	<% 
	if(ab.getStatus()) {
		out.println("User Registered Successfully!!");
	} else {
		out.println("User Could not be Registered!!");
	}
	%>
	
	<br/><br/>
	<a href="index.jsp">Login</a>
</body>
</html>
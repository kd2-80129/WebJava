<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User vote Status</title>
</head>
<body>
	
	<jsp:useBean id="vb" class="com.sunbeam.beans.VoteStatusBean" />
	<jsp:setProperty name="vb" property="candId" param="candidate"/>
	<jsp:setProperty name="vb" property="userId" value="${lb.user.id}"/>
	
	${vb.vote()}
	<h4>${vb.message}</h4>
	<a href="logout.jsp">Log Out</a>
	
</body>
</html>
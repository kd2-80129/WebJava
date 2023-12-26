<%@page import="com.sunbeam.beans.LoginBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Authentication</title>
</head>
<body>
	<jsp:useBean id="lb" class="com.sunbeam.beans.LoginBean" scope="session"/>
	<jsp:setProperty name="lb" property="*"/>
	${ lb.authentication()}
	<c:choose>
		<c:when test="${empty lb.user}"> 
			Invalid Credentials for Login
			<a href="index.jsp" >LogIn Again</a> 
		</c:when>
		
		<c:when test="${lb.user.role == 'admin'}"> 
			Invalid Credentials for Login 
			<c:redirect url ="result.jsp"/>
		</c:when>
		
		<c:when test="${lb.user.role == 'voter'}"> 
			<c:redirect url ="candlist.jsp"/> 
		</c:when>
		<c:otherwise>
			<c:redirect url="index.jsp"/>
		</c:otherwise>
	</c:choose>
</body>
</html>
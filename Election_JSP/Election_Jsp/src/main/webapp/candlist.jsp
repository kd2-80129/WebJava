<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Candidate List</title>
</head>
<body>
	Hello, ${lb.user.firstName} ${ lb.user.lastName } <hr/>
	<jsp:useBean id="cd" class="com.sunbeam.beans.CandidateList" />
	${ cd.displayAll()}
	<form method="post" action="vote.jsp">
		<c:forEach var="c" items="${cd.list}">
			<input type="radio" value="${c.id}" name="candidate"/> ${c.name} -- ${c.party} <br/>
		</c:forEach>
		<input type="submit" value="Vote" />	
	</form>
</body>
</html>
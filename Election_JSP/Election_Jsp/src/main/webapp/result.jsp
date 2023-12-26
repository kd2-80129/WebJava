<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Voting Result</title>
</head>
<body>
		Hello, ${lb.user.firstName} ${lb.user.lastName} <br/><hr/>
		<jsp:useBean id="rb" class="com.sunbeam.beans.ResultBean"/>
		${rb.displayAll()}
		<table border="1">
			<thead>
				<tr>
					<th>Candidate Id</th>
					<th>Name</th>
					<th>Party</th>
					<th>Votes</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="c" items="${rb.list}">
						<tr>
							<td>${c.id}</td>
							<td>${c.name}</td>
							<td>${c.party}</td>
							<td>${c.votes}</td>
							<td>
								<a href="edit.jsp?id=${c.id}">Edit</a> &nbsp;&nbsp;&nbsp;
								<a href="delete.jsp?id=${c.id}">Delete</a>
							</td>
						</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="logout.jsp">Sign Out</a>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Signup</title>
</head>
<body>
	<%
		String firstNameValue=(String) request.getAttribute("firstNameValue");
		String lastNameValue=(String) request.getAttribute("lastNameValue");
		String emailValue=(String) request.getAttribute("emailValue");
		String genderValue=(String) request.getAttribute("genderValue");
		String passwordValue=(String) request.getAttribute("passwordValue");
	%>
	
	FirstName:<%=firstNameValue %><br>
	LastName:<%=lastNameValue %><br>
	Email:<%=emailValue %><br>
	Gender:<%=genderValue %><br>
	Password:<%=passwordValue %>
	
	<a href="ListSignupUsersController">ListSignupUser</a>
</body>
<jsp:include page="Js.jsp"></jsp:include>
</html>
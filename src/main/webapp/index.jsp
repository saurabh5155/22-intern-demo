<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup Page</title>
</head>
<body>
<%
		String firstnameError=(String) request.getAttribute("firstNameError");
		String lastnameError=(String) request.getAttribute("lastNameError");
		String emailError=(String) request.getAttribute("emailError");
		String genderError=(String) request.getAttribute("genderError");
		String passwordError=(String) request.getAttribute("passwordError");
		
%>

<%
		String firstnameValue=(String) request.getAttribute("firstNameValue");
		String lastNameValue=(String) request.getAttribute("lastNameValue");
		String emailValue=(String) request.getAttribute("emailValue");
		String genderValue=(String) request.getAttribute("genderValue");
		String passwordValue=(String) request.getAttribute("passwordValue");
%>
	
	<form method="post" action="SignupController">
		firstname:<input type="text" name='firstName' value="${firstNameValue }"/>
		<%=firstnameError==null?"":firstnameError %>
		<br><br>
		
		lastname:<input type="text" name='lastName' value="${lastNameValue }"/>
		${lastNameError }
		<br><br>
		
		email:<input type="text" name='email' value="${emailValue }"/>
		<%=emailError==null?"":emailError %>
		<br><br>
		
		gender:    
			Male:<input type="radio" name='gender' value="male" <%=genderValue!=null&&genderValue.equals("male")?"checked":"" %>/><br>
			Female:<input type="radio" name='gender' value="female" <%=genderValue!=null&&genderValue.equals("female")?"checked":"" %>/>
			${genderError}
			<br><br>
				
		Password:<input type="password" name="password" value="${passwordValue }"/>
		<%=passwordError==null?"":passwordError%>
		<br><br>
		<input type="submit">
	</form>
</body>
</html> 
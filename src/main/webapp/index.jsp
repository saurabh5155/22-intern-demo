<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup Page</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<style type="text/css">
	#row-margin-top{
		margin-top: 20px;
		background-color: #F8F8FF;
	}
	#login{
		text-align: center;
		font-size: 50px;
	}
	body{
		background-color: #EBF4FA;
	}
</style>
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
	<div class="container-fluid">
		<div class="row" >
			<div class="col-md-4"></div>
			<div class="col-md-4" id="row-margin-top">
		<form method="post" action="SignupController">
		<div class="text-secondary" id="login">
						Sign up
					</div>
			<div class="form-group">
				firstname:<input type="text" name='firstName' value="${firstNameValue }" class="form-control"/>
				<%=firstnameError==null?"":firstnameError %>
			</div>
			
			<div class="form-group">
			lastname:<input type="text" name='lastName' value="${lastNameValue }" class="form-control"/>
			${lastNameError }
			</div>
			
			<div class="form-group">
			email:<input type="text" name='email' value="${emailValue }" class="form-control"/>
			<%=emailError==null?"":emailError %>
			</div>
			
			<div class="form-group">
			gender:    
				Male:<input type="radio" name='gender' value="male"  <%=genderValue!=null&&genderValue.equals("male")?"checked":"" %>/><br>
				Female:<input type="radio" name='gender' value="female" <%=genderValue!=null&&genderValue.equals("female")?"checked":"" %>/>
				${genderError}
			</div>
			
			<div class="form-group">		
			Password:<input type="password" name="password" value="${passwordValue }" class="form-control"/>
			<%=passwordError==null?"":passwordError%>
			</div>
			<input type="submit" class="btn btn-primary">
			
			<div>
					<a href="Login.jsp" class="text-primary">login?</a>
			</div>
		</form>
		</div>
	</div>
	</div>
</body>
</html> 
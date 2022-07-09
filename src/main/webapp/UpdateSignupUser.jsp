<%@page import="ism.bean.SignupBean"%>
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
	<% SignupBean signupBean = (SignupBean)request.getAttribute("signupBean");
		String genderValue = signupBean.getGender();
	%>
	<div class="container-fluid">
		<div class="row" >
			<div class="col-md-4"></div>
			<div class="col-md-4" id="row-margin-top">
				<form method="post" action="UpdateSignupUser">
					<div class="text-secondary" id="login">
									Update Profile
								</div>
								
						<input type="text" hidden="" name="userId" value="${signupBean.userId }" >
						<div class="form-group">
							firstname:<input type="text" name='firstName' value="${signupBean.firstName }" class="form-control"/>
						</div>
						
						<div class="form-group">
						lastname:<input type="text" name='lastName' value="${signupBean.lastName }" class="form-control"/>
						</div>
						
						<div class="form-group">
						gender:    
							Male:<input type="radio" name='gender' value="male"  <%=genderValue!=null&&genderValue.equals("male")?"checked":"" %>/><br>
							Female:<input type="radio" name='gender' value="female" <%=genderValue!=null&&genderValue.equals("female")?"checked":"" %>/>
						</div>
						<input type="submit" class="btn btn-primary">
						
						<div class="row"><div class="col-md-4"></div></div>
				</form>
		</div>
	</div>
	</div>
	<jsp:include page="Js.jsp"></jsp:include>
</body>
</html> 
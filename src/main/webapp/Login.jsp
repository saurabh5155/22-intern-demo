<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">

<style type="text/css">
	#row-margin-top{
		margin-top: 200px;
		background-color:  #EBF4FA;
	}
	#login{
		text-align: center;
		font-size: 50px;
	}
	body{
		background-color: #F8F8FF;
	}
</style>
</head>
<body>
	<%  %>
	
<div class="container-fluid">
	
	<div class="row" >
		<div class="col-md-4 " ></div>
			<div class="col-md-4 " id="row-margin-top">
				<form action="LoginController" method="post">
					<div class="text-secondary" id="login">
						Login
					</div>
					
					<div class="form-group">		
						Email:<input type="text" name="email" class="form-control"/><br>
					</div>
					
					<div class="form-group">
						Password:<input type="password" class="form-control" name="password"/><br>
					</div>
					
					${errorMSG }
					<div>
						<input type="submit" class="btn btn-primary"/>
					</div>
					<div>
						<a href="ForgotPassword.jsp" class="text-primary">forgot password?</a>
					</div>
					<div>
						<a href="index.jsp" class="text-primary">register user?</a>
					</div>
				</form>
		</div>
	</div>
</div>
<jsp:include page="Js.jsp"></jsp:include>
</body>
</html>
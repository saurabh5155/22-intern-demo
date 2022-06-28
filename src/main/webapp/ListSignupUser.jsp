<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="ism.bean.SignupBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css" integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.1.1/css/all.min.css" integrity="sha512-KfkfwYDsLkIlwQp6LFnl8zNdLGxu9YAA1QvwINks4PhcElQSvqcyVLLD9aMhXd13uQjoXtEKNosOWaZqXgel0g==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<% ArrayList<SignupBean> signupinfo = (ArrayList<SignupBean>)request.getAttribute("signup"); %>
	<div class="container">
	<div class="row">
		<div class="col-md-2"></div>
	</div>
	<div class="row" >
		<div class="col-md-2"></div>
			<div class="col-md-8" >
		<table class="table display table-striped " id="users">
			<thead>
				<tr>
					<th>UserId</th>
					<th>FirstName</th>
					<th>LastName</th>
					<th>Email</th>
					<th>Gender</th>
					<th>Action</th>
				</tr>
			</thead>
				<tbody>
				<%
				
					for(SignupBean sn : signupinfo){ 
				
				%>
				<tr>
					<td><%=sn.getUserId()%></td>
					<td><%=sn.getFirstName()%></td>
					<td><%=sn.getLastName()%></td>
					<td><%=sn.getEmail()%></td>
					<td><%=sn.getGender()%></td>
					<td>
							<a href="DeleteSignupUser?userid=<%=sn.getUserId()%>"><i class="fa-solid fa-trash-can"></i></a>
							<a href="UpdateSignupUserPage?userid=<%=sn.getUserId()%>"><i class="fas fa-edit"></i></a>
					</td>
				</tr>
				<% 
				
					} 
					
				%>
				</tbody>
			</table>
		</div>
		</div>
		</div>
		<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>
</body>
</html>
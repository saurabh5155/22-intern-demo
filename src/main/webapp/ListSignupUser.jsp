<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@page import="ism.bean.SignupBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% ArrayList<SignupBean> signupinfo = (ArrayList<SignupBean> ) request.getAttribute("signup"); %>
	
	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Gender</th>
		</tr>
		<%
		
			for(SignupBean sn : signupinfo){ 
		
		%>
		<tr>
			<td><%=sn.getUserId()%></td>
			<td><%=sn.getFirstName()%></td>
			<td><%=sn.getLastName()%></td>
			<td><%=sn.getEmail()%></td>
			<td><%=sn.getGender()%></td>
		</tr>
		<% 
		
			} 
			
		%>
	</table>
</body>
</html>
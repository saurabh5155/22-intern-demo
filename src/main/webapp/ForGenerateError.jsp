<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ERRORJSP.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		int a=10;
		int b=0;
		int c=a/b;
	%>
	<form action="errorController">
		<input type="submit" value="submit">
	</form>
</body>
</html>
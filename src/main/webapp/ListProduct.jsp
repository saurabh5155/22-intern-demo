<%@page import="ism.bean.ProductBean"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="Css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="AdminNavbar.jsp"></jsp:include>
	<% %>
	<div class="container">
		<div class="row">
			<div class="col-md-2"></div>
		</div>
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8">
				<table class="table display table-striped " id="users">
					<thead>
						<tr>
							<th>ProductId</th>
							<th>Product Name</th>
							<th>Product Discription</th>
							<th>Product Price</th>
							<th>Product Qty</th>
							<!-- <th>Product Img Address</th> -->
							<th>Action</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${products}" var="it">
							<tr>
								<td>${it.productId}</td>
								<td>${it.productName}</td>
								<td>${it.productDiscription }</td>
								<td>${it.productPrice }</td>
								<td>${it.productQty}</td>
								<%-- <td>${ it.productImg}</td> --%>
								<td><a href="DeleteProducts?productid=${it.productId }">delete<i
										class="fa-solid fa-trash-can"></i></a>
									<a href="UpdateProducts?productid=${it.productId }">update<i class="fas fa-edit"></i></a>		
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx" crossorigin="anonymous"></script> 
	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>
	
</body>
</html>
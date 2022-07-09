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
	<jsp:include page="CoustomerNavbar.jsp"></jsp:include>
	
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
							<th>Order Detail Id</th>
							<th>Product Id</th>
							<th>Product Name</th>
							<th>Product Price</th>
							<th>Product Img</th>

						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listOrderDetail}" var="it">
							<tr>
								<td>${it.orderDetailId }</td>
								<td>${it.productId}</td>
								<td>${it.productName}</td>
								<td>${it.productPrice }</td>
								<td><img src="${it.productImg}" height="100px" width="100px"/></td>
								
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
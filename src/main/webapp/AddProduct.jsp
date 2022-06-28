<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
	
	<div class="row" >
		<div class="col-md-4 " ></div>
			<div class="col-md-4 " id="row-margin-top">
				<form action="AddProduct" method="post">
					<div class="text-secondary" id="login">
						Add Products
					</div>
					
					<div class="form-group">		
						Product Name:<input type="text" name="productName" class="form-control"/><br>
					</div>
					
					<div class="form-group">
						Product Discription:<input type="text" class="form-control" name="productDiscription"/><br>
					</div>
					<div class="form-group">
						Product Price:<input type="text" class="form-control" name="productPrice"/><br>
					</div>
					
					<div class="form-group">
						Product Available Qty:<input type="number" class="form-control" name="productQty"/><br>
					</div>
					
					<div>
						<input type="submit" class="btn btn-primary"/>
					</div>
					${Success }
				</form>
		</div>
	</div>
</div>
</body>
</html>
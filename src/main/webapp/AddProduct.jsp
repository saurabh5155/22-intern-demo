<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<jsp:include page="Css.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="AdminNavbar.jsp"></jsp:include>
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
					
					<div class="form-group">
						Product Img URL:<input type="text" class="form-control" name="productImg"/><br>
					</div>
					
					<div>
						<input type="submit" class="btn btn-primary"/>
					</div>
					${Success }
				</form>
				
				<a href="ListProduct">product list?</a>
		</div>
	</div>
</div>
<jsp:include page="Js.jsp"></jsp:include>
</body>
</html>
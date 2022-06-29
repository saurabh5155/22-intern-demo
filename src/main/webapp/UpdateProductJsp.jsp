<%@page import="ism.bean.ProductBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
#row-margin-top {
	margin-top: 20px;
	background-color: #F8F8FF;
}

#login {
	text-align: center;
	font-size: 30px;
}

body {
	background-color: #EBF4FA;
}
</style>
<jsp:include page="Css.jsp"></jsp:include>
</head>
<body>
	<%
	ProductBean productBean = (ProductBean) request.getAttribute("productBean");
	%>
	<jsp:include page="AdminNavbar.jsp"></jsp:include>
	<div class="container-fluid">

		<div class="row">
			<div class="col-md-4 "></div>
			<div class="col-md-4 " id="row-margin-top">
				<form action="UpdateProductController" method="post">
					<div class="text-secondary" id="login">Update Product Details
					</div>
					
					<div class="form-group">
						Product Name:<input type="text" name="productId"
							class="form-control" value="${productBean.productId}" hidden="" /><br>
					</div>

					<div class="form-group">
						Product Name:<input type="text" name="productName"
							class="form-control" value="${productBean.productName}" /><br>
					</div>

					<div class="form-group">
						Product Discription:<input type="text" class="form-control"
							name="productDiscription"
							value="${productBean.productDiscription }" /><br>
					</div>
					<div class="form-group">
						Product Price:<input type="text" class="form-control"
							name="productPrice" value="${ productBean.productPrice }" /><br>
					</div>

					<div class="form-group">
						Product Available Qty:<input type="number" class="form-control"
							name="productQty" value="${productBean.productQty }" /><br>
					</div>

					<div class="form-group">
						Product Img URL:<input type="text" class="form-control"
							name="productImg" value="${productBean.productImg }"/><br>
					</div>

					<div>
						<input type="submit" class="btn btn-primary" value="Update" />
					</div>
					${Success }
				</form>


			</div>
		</div>
	</div>
	<jsp:include page="Js.jsp"></jsp:include>
</body>
</html>
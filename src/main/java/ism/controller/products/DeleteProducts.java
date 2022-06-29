package ism.controller.products;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.dao.ProductDao;

@WebServlet("/DeleteProducts")
public class DeleteProducts extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int productId=Integer.parseInt( request.getParameter("productid"));
	
		ProductDao productDao = new ProductDao();
		
		boolean result = productDao.deleteProducts(productId);
		RequestDispatcher rd= null;
		if(result==true) {
			rd = request.getRequestDispatcher("ListProduct");
		}
		rd.forward(request, response);
	}
}

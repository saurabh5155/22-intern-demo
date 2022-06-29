package ism.controller.products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.ProductBean;
import ism.dao.ProductDao;

public class UpdateProducts extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productid"));

		ProductDao productDao = new ProductDao();
		ProductBean productBean = productDao.getProductById(productId);
		
		request.setAttribute("productBean", productBean);
		
		request.getRequestDispatcher("UpdateProductJsp.jsp").forward(request, response);;
	}

}

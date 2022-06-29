package ism.controller.products;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ism.bean.ProductBean;
import ism.dao.ProductDao;

@WebServlet("/ListProductForUsers")
public class ListProductForUsers extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<ProductBean> product = null;

		ProductDao productDao = new ProductDao();

		product = productDao.listProduct();

		request.setAttribute("products", product);

		RequestDispatcher rd = null;

		rd = request.getRequestDispatcher("ListProductForUsers.jsp");

		rd.forward(request, response);
	}
}

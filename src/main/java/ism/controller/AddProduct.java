package ism.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.ProductBean;
import ism.dao.ProductDao;

@WebServlet("/AddProduct")
public class AddProduct extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName=	request.getParameter("productName");
		String productDiscription = request.getParameter("productDiscription");
		int productPrice =Integer.parseInt( request.getParameter("productPrice"));
		int productQty =Integer.parseInt(request.getParameter("productQty"));
		
		ProductBean productBean = new ProductBean();
		productBean.setProductName(productName);
		productBean.setProductDiscription(productDiscription);
		productBean.setProductPrice(productPrice);
		productBean.setProductQty(productQty);
		
		ProductDao productDao = new ProductDao();
		productDao.insertProduct(productBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("AddProduct.jsp");
		request.setAttribute("Success", "Product Added Successfull");
		rd.forward(request, response);
	}
}

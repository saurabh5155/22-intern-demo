package ism.controller.addToCart;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.AddToCartBean;
import ism.dao.AddToCartDao;


public class DeleteAddToCart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cartId =Integer.parseInt( request.getParameter("cartid"));
		
		AddToCartDao addToCartDao = new AddToCartDao();
		boolean flag = addToCartDao.deleteAddToCart(cartId);
		RequestDispatcher rd = null;
		if(flag==true) {
			rd= request.getRequestDispatcher("ListAddToCart");
		}
		rd.forward(request, response);
	}

}

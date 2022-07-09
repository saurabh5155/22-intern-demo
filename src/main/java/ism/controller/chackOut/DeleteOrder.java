package ism.controller.chackOut;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.dao.OrderDao;


public class DeleteOrder extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId =Integer.parseInt( request.getParameter("orderid"));
		OrderDao orderDao = new OrderDao();
		boolean flag=orderDao.deleteOrder(orderId);
		
		request.getRequestDispatcher("ListOrderController").forward(request, response);
	}

}

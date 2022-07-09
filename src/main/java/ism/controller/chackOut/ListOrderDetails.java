package ism.controller.chackOut;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.OredrDetailProductBean;
import ism.dao.OrderDetailDao;

public class ListOrderDetails extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId =Integer.parseInt( request.getParameter("orderid"));
		
		OrderDetailDao orderDetailDao = new OrderDetailDao();
		ArrayList<OredrDetailProductBean> listOrderDetail= orderDetailDao.getOrderDetailsById(orderId);
		System.out.println("ListOrderDetail"+listOrderDetail);
		request.setAttribute("listOrderDetail", listOrderDetail);
		request.getRequestDispatcher("ListOrderDetails.jsp").forward(request, response);
	}
}

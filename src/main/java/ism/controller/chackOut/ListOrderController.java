package ism.controller.chackOut;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ism.bean.OrderBean;
import ism.dao.OrderDao;

public class ListOrderController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		int userId=	(Integer) session.getAttribute("userId");
		
		OrderDao orderDao = new OrderDao();
		ArrayList<OrderBean> listOrder = orderDao.listOrderByUserId(userId);
		System.out.println(listOrder);
		request.setAttribute("listOrder", listOrder);
		
		request.getRequestDispatcher("ListOrder.jsp").forward(request, response);
	}

}

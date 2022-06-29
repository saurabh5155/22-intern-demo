package ism.controller.addToCart;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import ism.bean.AddToCartBean;
import ism.dao.AddToCartDao;

public class AddToCartController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int productId =Integer.parseInt( request.getParameter("productId"));
		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		
		AddToCartBean cart = new AddToCartBean();
		cart.setProductId(productId);
		cart.setUserId(userId);
		
		AddToCartDao addToCartDao = new AddToCartDao();
		addToCartDao.addtocart(cart);
		request.getRequestDispatcher("ListProductForUsers").forward(request, response);
	}

}

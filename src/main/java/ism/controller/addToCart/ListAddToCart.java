package ism.controller.addToCart;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ism.bean.AddToCartBean;
import ism.bean.CartProductBean;
import ism.dao.AddToCartDao;

public class ListAddToCart extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		HttpSession session = request.getSession();
		int userId = (Integer) session.getAttribute("userId");
		
		AddToCartDao addToCartDao = new AddToCartDao();
		ArrayList<CartProductBean> cartproduct =addToCartDao.listAddToCart(userId);
		
		int total=0;
		CartProductBean cartProductBean = new CartProductBean();
		for(CartProductBean ca :cartproduct) {
			total = total+ca.getProductPrice();
		}
		cartProductBean.setTotal(total);
		request.setAttribute("total", total);
		request.setAttribute("cartproduct", cartproduct);
		request.getRequestDispatcher("ListAddToCart.jsp").forward(request, response);;
	}

}

package ism.controller.products;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.ProductBean;
import ism.dao.ProductDao;


public class UpdateProductController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			int productId=Integer.parseInt(	request.getParameter("productId"));
			String productName=	request.getParameter("productName");
			String productDiscription = request.getParameter("productDiscription");
			int productPrice =Integer.parseInt( request.getParameter("productPrice"));
			int productQty =Integer.parseInt(request.getParameter("productQty"));
			String productImg=request.getParameter("productImg");
			
			ProductBean productBean = new ProductBean();
			productBean.setProductId(productId);
			productBean.setProductName(productName);
			productBean.setProductDiscription(productDiscription);
			productBean.setProductPrice(productPrice);
			productBean.setProductQty(productQty);
			productBean.setProductImg(productImg);
			
			ProductDao productDao = new ProductDao();
			productDao.updateProduct(productBean);
			
			request.getRequestDispatcher("ListProduct").forward(request, response);
	}

}

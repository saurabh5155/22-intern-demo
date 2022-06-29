package ism.controller.signup;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.SignupBean;
import ism.dao.SignupDao;

@WebServlet("/UpdateSignupUserPage")
public class UpdateSignupUserPage extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId =Integer.parseInt( request.getParameter("userid"));
		
		System.out.println("UserId"+userId);
		
		SignupBean signupBean = new SignupBean();
		SignupDao signDao = new SignupDao();
		
		signupBean = signDao.getSignupUserById(userId);
		
		request.setAttribute("signupBean", signupBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("UpdateSignupUser.jsp");
		rd.forward(request, response);
	}
}

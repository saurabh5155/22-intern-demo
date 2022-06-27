package ism.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.SignupBean;
import ism.dao.SignupDao;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NullPointerException {
		
		SignupBean signupBean = new SignupBean();	

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		SignupDao signupDao = new SignupDao();
		signupBean= signupDao.login(email,password);
		
		
		RequestDispatcher rd = null;
		
		if(signupBean==null) {
			request.setAttribute("errorMSG", "Invalid Email or Password");
			rd = request.getRequestDispatcher("Login.jsp");
		} else {
			if(signupBean.getUserType().equals("customer")) {
				System.out.println(signupBean.getUserType());
				rd = request.getRequestDispatcher("CoustomerDashboard.jsp");
			}else if(signupBean.getUserType().equals("admin")) {
				rd = request.getRequestDispatcher("AdminDashboard.jsp");
			}else {
				rd = request.getRequestDispatcher("404Error.jsp");
			}
		}
		rd.forward(request, response);
		
	}
}

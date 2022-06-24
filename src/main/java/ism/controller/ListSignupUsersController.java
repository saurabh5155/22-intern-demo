package ism.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.bean.SignupBean;
import ism.dao.SignupDao;

@WebServlet("/ListSignupUsersController")
public class ListSignupUsersController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SignupDao signupDao = new SignupDao();
		ArrayList<SignupBean> signup= signupDao.ListSignupUsers();
		
		request.setAttribute("signup", signup);
		
		RequestDispatcher rd = request.getRequestDispatcher("ListSignupUser.jsp");
		rd.forward(request, response);
	}
}

package ism.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ism.dao.SignupDao;

//DeleteSignupUser

@WebServlet("/DeleteSignupUser")
public class DeleteSignupUser extends HttpServlet
{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userId = Integer.parseInt( request.getParameter("userid"));
		
		System.out.println("Deleted=>"+userId);
		SignupDao signupDao = new SignupDao();
		boolean flag=signupDao.deleteUser(userId);
		
		//RequestDispatcher rd = null;
		
		if(flag==true) {
			
			request.setAttribute("successfullDelete", "successfull Deleted");
		}
		else {
			request.setAttribute("unsuccessfullDelete", "unsuccessfull");
		}
		
		request.getRequestDispatcher("ListSignupUsersController").forward(request, response);
	}
}

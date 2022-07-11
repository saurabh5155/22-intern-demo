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

@WebServlet("/SignupController")

public class SignupController extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Hello we are in SignupController");
		
		String firstNameValue =  request.getParameter("firstName");
		String lastNameValue = request.getParameter("lastName");
		String emailValue = request.getParameter("email");
		String genderValue = request.getParameter("gender");
		String passwordValue =  request.getParameter("password");
		
		System.out.println("Firstname"+firstNameValue);
		System.out.println("Lastname"+lastNameValue);
		System.out.println("email"+emailValue);
		System.out.println("password"+passwordValue);
		System.out.println("gender"+genderValue);
			
		SignupDao signupDao = new SignupDao();
		SignupBean signupBean = new SignupBean();
//			signupDao.insertUsers(firstNameValue,lastNameValue,emailValue,genderValue,passwordValue);
			
			signupBean.setFirstName(firstNameValue);
			signupBean.setLastName(lastNameValue);
			signupBean.setEmail(emailValue);
			signupBean.setGender(genderValue);
			signupBean.setPassword(passwordValue);
			signupBean.setUserType("customer");
			
			signupDao.insertUsers(signupBean);
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		
	}
}

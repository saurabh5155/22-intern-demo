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

		
		boolean isError=false;
		RequestDispatcher rd=null;
		
			if(firstNameValue==null || firstNameValue.trim().length()==0) {
				request.setAttribute("firstNameError", "Please Enter Firstname");
				isError=true;
			}else {			
				request.setAttribute("firstNameValue", firstNameValue);
			}
			
			if(lastNameValue == null || lastNameValue.trim().length()==0) {
				request.setAttribute("lastNameError", "Please enter lastname");
				isError=true;
			}else {
				request.setAttribute("lastNameValue", lastNameValue);	
			}
			
			if(emailValue==null||emailValue.trim().length()==0) {
				request.setAttribute("emailError", "Please enter email");
				isError=true;
			}else {
				request.setAttribute("emailValue", emailValue);
			}
			
			if(genderValue==null||genderValue.trim().length()==0) {
				request.setAttribute("genderError", "Please enter gender");
				isError=true;
			}else {
				request.setAttribute("genderValue", genderValue);
			}
			
			if(passwordValue == null|| passwordValue.trim().length()==0) {
				request.setAttribute("passwordError", "Please enter password");
				isError=true;
			}else {
				request.setAttribute("passwordValue", passwordValue);
			}
			
		SignupDao signupDao = new SignupDao();
		SignupBean signupBean = new SignupBean();
		
		if(isError==true) {
			rd = request.getRequestDispatcher("index.jsp");
		}else {
//			signupDao.insertUsers(firstNameValue,lastNameValue,emailValue,genderValue,passwordValue);
			
			signupBean.setFirstName(firstNameValue);
			signupBean.setLastName(lastNameValue);
			signupBean.setEmail(emailValue);
			signupBean.setGender(genderValue);
			signupBean.setPassword(passwordValue);
			signupBean.setUserType("customer");
			
			signupDao.insertUsers(signupBean);
			rd = request.getRequestDispatcher("Login.jsp");
		}
		
		rd.forward(request, response);
		
	}
}

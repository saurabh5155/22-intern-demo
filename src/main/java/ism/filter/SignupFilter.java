package ism.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import ism.bean.SignupBean;
import ism.dao.SignupDao;

public class SignupFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("destroy() in SignupFilter");
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
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
			
		
		if(isError) {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("init() in SignupFilter");
	}
	
}

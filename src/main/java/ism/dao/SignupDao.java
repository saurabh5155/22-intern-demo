package ism.dao;

import java.awt.im.InputMethodRequests;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.security.auth.message.callback.SecretKeyCallback.Request;

import ism.bean.SignupBean;
import ism.util.PgAdmin4Connection;

public class SignupDao {
	
	
	public void insertUsers(SignupBean signupBean) {

		try {

			Connection con = PgAdmin4Connection.getConnection();
			
			PreparedStatement ptmt = con.prepareStatement("insert into users (firstname,lastname,email,gender,password) values (?,?,?,?,?)");
			
			ptmt.setString(1, signupBean.getFirstName());
			ptmt.setString(2, signupBean.getLastName());
			ptmt.setString(3, signupBean.getEmail());
			ptmt.setString(4, signupBean.getGender());
			ptmt.setString(5, signupBean.getPassword());
			
			int records = ptmt.executeUpdate();
			System.out.println("Data inserted"+records);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}
	
	public ArrayList<SignupBean> ListSignupUsers(){
		
		ArrayList<SignupBean> signup = new ArrayList<SignupBean>();
		
		
		try {
			Connection con = PgAdmin4Connection.getConnection();
			
			PreparedStatement ptmt = con.prepareStatement("select * from users");
			
			ResultSet rs =ptmt.executeQuery();
			while(rs.next()==true) {
				int  userId =rs.getInt("userid");
				String firstName =rs.getString("firstname");
				String lastName = rs.getString("lastname");
				String email = rs.getString("email");
				String gender = rs.getString("gender");
				
				SignupBean signupBean = new SignupBean();
				
				signupBean.setUserId(userId);
				signupBean.setFirstName(firstName);
				signupBean.setLastName(lastName);
				signupBean.setEmail(email);
				signupBean.setGender(gender);
				
				signup.add(signupBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in ListSignupUsers() in Dao");
		}
		return signup;
		
	}
	
}

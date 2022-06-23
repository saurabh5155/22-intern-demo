package ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	
}

package ism.dao;

import java.awt.im.InputMethodRequests;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.security.auth.message.callback.SecretKeyCallback.Request;

import org.apache.catalina.mbeans.MemoryUserDatabaseMBean;
import org.eclipse.jdt.internal.compiler.flow.TryFlowContext;

import ism.bean.SignupBean;
import ism.util.PgAdmin4Connection;

public class SignupDao {
	
	
	public void insertUsers(SignupBean signupBean) {

		try {
			Connection con = PgAdmin4Connection.getConnection();
			
			PreparedStatement ptmt = con.prepareStatement("insert into users (firstname,lastname,email,gender,password,usertype) values (?,?,?,?,?,?)");
			
			ptmt.setString(1, signupBean.getFirstName());
			ptmt.setString(2, signupBean.getLastName());
			ptmt.setString(3, signupBean.getEmail());
			ptmt.setString(4, signupBean.getGender());
			ptmt.setString(5, signupBean.getPassword());
			ptmt.setString(6, signupBean.getUserType());
			
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
				String userType = rs.getString("usertype");
				
				SignupBean signupBean = new SignupBean();
				
				signupBean.setUserId(userId);
				signupBean.setFirstName(firstName);
				signupBean.setLastName(lastName);
				signupBean.setEmail(email);
				signupBean.setGender(gender);
				signupBean.setUserType(userType);
				
				signup.add(signupBean);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error in ListSignupUsers() in Dao");
		}
		return signup;
		
	}
	
	public SignupBean login(String email,String password) {
		
		
		
		SignupBean signupBean=null;
		try {
			Connection con = PgAdmin4Connection.getConnection();
			PreparedStatement ptmt = con.prepareStatement("select * from users where email=? and password=?");
			
			ptmt.setString(1, email);
			ptmt.setString(2, password);
			
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				int userId = rs.getInt("userId");				
				String emaildatabase = rs.getString("email");
				String lastname = rs.getString("lastname");
				String gender = rs.getString("gender");
				String firstname = rs.getString("firstname");
				String passworddatabse = rs.getString("password");
				String userType = rs.getString("usertype");
				 signupBean = new SignupBean();
				
				signupBean.setUserId(userId); 
				signupBean.setFirstName(firstname);
				signupBean.setLastName(lastname);
				signupBean.setEmail(emaildatabase);
				signupBean.setGender(gender);
				signupBean.setPassword(passworddatabse);
				signupBean.setUserType(userType);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return signupBean;
	}
	
	public boolean deleteUser(int userid) {
		boolean flag=false;
		
		try(Connection con = PgAdmin4Connection.getConnection();
			PreparedStatement ptmt = con.prepareStatement("delete from users where userid = ?");
				) {
			ptmt.setInt(1, userid);
			
			int deleterow = ptmt.executeUpdate();
			if (deleterow == 1) {
				flag=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	
	public SignupBean getSignupUserById(int userid) {
		SignupBean signupBean= null;
		try(Connection con = PgAdmin4Connection.getConnection();
			PreparedStatement ptmt = con.prepareStatement("select * from users where userid=?");	
				) {
			ptmt.setInt(1, userid);
			
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) { 
				signupBean = new SignupBean();
			signupBean.setUserId(rs.getInt("userid"));
			signupBean.setFirstName(rs.getString("firstname"));
			signupBean.setLastName(rs.getString("lastname"));
			signupBean.setGender(rs.getString("gender"));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return signupBean;
	}
	
	public Boolean UpdateSignupUser(SignupBean signupBean) {
		boolean flag =false;
		try (Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("update users set firstname=?,lastname=?,gender=? where userid =?");
				){	
			ptmt.setString(1, signupBean.getFirstName());
			ptmt.setString(2, signupBean.getLastName());
			ptmt.setString(3, signupBean.getGender());
			ptmt.setInt(4, signupBean.getUserId());
			
			int updateCount = ptmt.executeUpdate();
			if(updateCount == 1) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return flag;
	}
}

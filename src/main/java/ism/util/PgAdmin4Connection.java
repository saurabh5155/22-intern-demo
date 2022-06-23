package ism.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PgAdmin4Connection {
	static String driver="org.postgresql.Driver";
	static String url="jdbc:postgresql://localhost:5432/ism2022";
	static String userName="postgres";
	static String password="root";
	
	public static Connection getConnection (){
		
		try {
			Class.forName(driver);
			
			Connection con = DriverManager.getConnection(url, userName, password);
			
			if(con!=null) {
				System.out.println("Database Connected");
			}else {
				System.out.println("Database is NOT Connected");
			}
			return con;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}

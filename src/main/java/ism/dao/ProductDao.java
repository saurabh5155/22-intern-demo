package ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ism.bean.ProductBean;
import ism.util.PgAdmin4Connection;

public class ProductDao {
	
	public void insertProduct(ProductBean productBean) {
		try(Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("insert into products (product_name,product_discription,product_price,product_qty) values (?,?,?,?) ")
				) {
			ptmt.setString(1, productBean.getProductName());
			ptmt.setString(2, productBean.getProductDiscription());
			ptmt.setInt(3, productBean.getProductPrice());
			ptmt.setInt(4, productBean.getProductQty());
			
			int records =  ptmt.executeUpdate();
			System.out.println(records);
		} catch (Exception e) {
			System.out.println("Exception -> ProductDao -> InsertProduct");
			e.printStackTrace();
		}
	}
}

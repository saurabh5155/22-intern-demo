package ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ism.bean.AddToCartBean;
import ism.util.PgAdmin4Connection;

public class AddToCartDao {

	public void addtocart(AddToCartBean addToCartBean) {
		try (Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con
						.prepareStatement("insert into carts (product_id,user_id) values (?,?) ");) {
			ptmt.setInt(1, addToCartBean.getProductId());
			ptmt.setInt(2, addToCartBean.getUserId());

			int records = ptmt.executeUpdate();

			System.out.println("Data inserted" + records);
		} catch (Exception e) {
			System.out.println("SW In AddtoCartDao in addtocart()");
			e.printStackTrace();
		}
	}

	public ArrayList<AddToCartBean> listAddToCart(int userId) {
		ArrayList<AddToCartBean> cart = new ArrayList<>();
		try (Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement(
						"select * from carts where user_id = ? ");
				) {
			ptmt.setInt(1, userId);

			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				AddToCartBean addToCartBean = new AddToCartBean();
				addToCartBean.setProductId(rs.getInt("product_id"));
				addToCartBean.setCartId(rs.getInt("cart_id"));
				cart.add(addToCartBean);
			}
		} catch (Exception e) {
			System.out.println("SW In AddToCart -> ListAddToCarts");
			e.printStackTrace();
		}
		return cart;
	}
	
	public Boolean deleteAddToCart(int cartId) {
		boolean flag=false;
		try(Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("delete from carts where cart_id =?");
				) {
			ptmt.setInt(1, cartId);
			int record = ptmt.executeUpdate();
			
			if(record == 1) {
				flag=true;
			}
		} catch (Exception e) {

		}
		
		return flag;
	}
}

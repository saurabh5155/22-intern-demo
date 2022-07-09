package ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import ism.bean.AddToCartBean;
import ism.bean.CartProductBean;
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

	public ArrayList<CartProductBean> listAddToCart(int userId) {
		ArrayList<CartProductBean> cartproduct = new ArrayList<>();
		CartProductBean cartProductBean=null;
		try (Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement(
						"select p.product_name , p.product_price , c.cart_id , p.product_id , c.user_id ,p.product_discription,p.product_img,p.product_qty from products p,carts c where c.user_id = ? and c.product_id = p.product_id ");
				) {
			ptmt.setInt(1, userId);

			ResultSet rs = ptmt.executeQuery();
		
			while(rs.next()) {
				cartProductBean = new CartProductBean();
				cartProductBean.setProductId(rs.getInt("product_id"));
				cartProductBean.setProductName(rs.getString("product_name"));
				cartProductBean.setProductPrice(rs.getInt("product_price"));
				cartProductBean.setProductDiscription(rs.getString("product_discription"));
				cartProductBean.setProductImg(rs.getString("product_img"));
				cartProductBean.setProductQty(rs.getInt("product_qty"));
				cartProductBean.setCartId(rs.getInt("cart_id"));
				cartProductBean.setUserId(rs.getInt("user_id"));
				cartproduct.add(cartProductBean);
			}
		} catch (Exception e) {
			System.out.println("SW In AddToCart -> ListAddToCarts");
			e.printStackTrace();
		}
		return cartproduct;
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
	
	public Boolean DeteteAddToCartByUserId(int userId) {
		boolean flag = false;
		try(Connection con =PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("delete from carts where user_id=?");
				) {
			ptmt.setInt(1, userId);
			int result = ptmt.executeUpdate();
			if(result ==1) {
				flag=true;
			}
			
		} catch (Exception e) {
			System.out.print("SW in AddToCart -> deleteAddToCartByUserId()");
			e.printStackTrace();
		}
		
		return flag;
	}
}























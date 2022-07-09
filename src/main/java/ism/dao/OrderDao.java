package ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import ism.bean.CartProductBean;
import ism.bean.OrderBean;
import ism.bean.OrderDetailsBean;
import ism.util.PgAdmin4Connection;

public class OrderDao {
	
	public void insertOrder(int userId) {
		int total=0;
		AddToCartDao addToCartDao = new AddToCartDao();
		ArrayList<CartProductBean> cp = addToCartDao.listAddToCart(userId);
		for(CartProductBean cpb:cp) {
			total = cpb.getProductPrice()+total;
		}
		
		try(Connection con = PgAdmin4Connection.getConnection();
			PreparedStatement ptmt = con.prepareStatement("insert into orders (user_id,amount,order_status,payment_mode,payment_status) values (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
				) {
			ptmt.setInt(1, userId);
			ptmt.setInt(2, total);
			ptmt.setString(3, "pending");
			ptmt.setString(4, "cod");
			ptmt.setString(5, "pending");
			ptmt.executeUpdate(); 
			ResultSet rs = ptmt.getGeneratedKeys();
	
			rs.next();
			int orderId = rs.getInt("order_id");
			System.out.println("orderId"+orderId);

			OrderDetailDao orderDetailDao = new OrderDetailDao();
			for(CartProductBean cpb:cp) {
				OrderDetailsBean orderDetailsBean = new OrderDetailsBean();
				orderDetailsBean.setProductId(cpb.getProductId());
				orderDetailsBean.setPrice(cpb.getProductPrice());
				orderDetailsBean.setOrderId(orderId);
				orderDetailDao.insertOrderDetails(orderDetailsBean);
			}
			
			boolean flag=addToCartDao.DeteteAddToCartByUserId(userId);
			System.out.println(flag);
			
		} catch (Exception e) {
			System.out.println("SW in OrderDao -> insertOrder()");
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<OrderBean> listOrderByUserId(int userId){
		ArrayList<OrderBean> listOrder = new ArrayList<>();
		try(Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("select * from orders where user_id=?");
				) {
			ptmt.setInt(1, userId);
			ResultSet rs = ptmt.executeQuery();
			
			OrderBean orderBean = null;
			while(rs.next()) {
				orderBean = new OrderBean();
				orderBean.setOrderId(rs.getInt("order_id"));
				orderBean.setAmount(rs.getInt("amount"));
				orderBean.setOrderStatus(rs.getString("order_status"));
				orderBean.setPaymentMode(rs.getString("payment_mode"));
				orderBean.setPaymentStatus(rs.getString("payment_status"));
				
				listOrder.add(orderBean);
			}
			System.out.println(listOrder);
			
		} catch (Exception e) {
			System.out.println("SW in orderDao -> listOrderByUserId()");
			e.printStackTrace();
		}
		return listOrder;
	}
	
	public Boolean deleteOrder(int orderId) {
		boolean flag=false;
		try(Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("delete from orders where order_id = ?");
				) {
			ptmt.setInt(1, orderId);
			int result = ptmt.executeUpdate();
			if(result == 1) {
				flag=true;
			}
		} catch (Exception e) {
			System.out.println("SW in orderDao -> deleteOrder()");
			e.printStackTrace();
		}
		return flag;
	}
}

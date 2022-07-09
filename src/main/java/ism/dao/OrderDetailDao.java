package ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import ism.bean.OrderDetailsBean;
import ism.bean.OredrDetailProductBean;
import ism.util.PgAdmin4Connection;

public class OrderDetailDao {
	
	public void insertOrderDetails(OrderDetailsBean orderDetailsBean) {
		try(Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("insert into order_details (product_id,order_id,product_price) values (?,?,?)");
				) {
			ptmt.setInt(1, orderDetailsBean.getProductId());
			ptmt.setInt(2, orderDetailsBean.getOrderId());
			ptmt.setInt(3, orderDetailsBean.getPrice());
			
			ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("SW in OrderDetailDao -> insertOrderDetails");
			e.printStackTrace();
		}
	}
	
	public ArrayList<OredrDetailProductBean> getOrderDetailsById(int orderId){
		ArrayList<OredrDetailProductBean> listOrderDetailProduct= new ArrayList<>();
		try(Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("select p.product_img,p.product_name,od.order_details_id,od.order_id,od.product_price,p.product_id from order_details od , products p where p.product_id = od.product_id and od.order_id = ?");
				) {
			ptmt.setInt(1, orderId);
			
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				OredrDetailProductBean oredrDetailProductBean = new OredrDetailProductBean();
				oredrDetailProductBean.setProductId(rs.getInt("product_id"));
				oredrDetailProductBean.setOrderDetailId(rs.getInt("order_details_id"));
				oredrDetailProductBean.setProductName(rs.getString("product_name"));
				oredrDetailProductBean.setProductPrice(rs.getInt("product_price"));
				oredrDetailProductBean.setProductImg(rs.getString("product_img"));
				listOrderDetailProduct.add(oredrDetailProductBean);
				}
		} catch (Exception e) {
			System.out.println("SW in OrderDetailDao -> getOrderDetailById()");
			e.printStackTrace();
		}
		return listOrderDetailProduct;
	}
}

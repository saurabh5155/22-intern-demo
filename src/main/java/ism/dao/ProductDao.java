package ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.text.StyledEditorKit.BoldAction;

import ism.bean.ProductBean;
import ism.util.PgAdmin4Connection;

public class ProductDao {

	public void insertProduct(ProductBean productBean) {
		try (Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement(
						"insert into products (product_name,product_discription,product_price,product_qty,product_img) values (?,?,?,?,?) ")) {
			ptmt.setString(1, productBean.getProductName());
			ptmt.setString(2, productBean.getProductDiscription());
			ptmt.setInt(3, productBean.getProductPrice());
			ptmt.setInt(4, productBean.getProductQty());
			ptmt.setString(5, productBean.getProductImg());
			int records = ptmt.executeUpdate();
			System.out.println(records);
		} catch (Exception e) {
			System.out.println("Exception -> ProductDao -> InsertProduct");
			e.printStackTrace();
		}
	}

	public ArrayList<ProductBean> listProduct() {
		ArrayList<ProductBean> product = new ArrayList<>();
		try (Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("select * from products");) {

			ProductBean productBean = null;
			ResultSet rs = ptmt.executeQuery();
			while (rs.next()) {
				productBean = new ProductBean();
				productBean.setProductId(rs.getInt("product_id"));
				productBean.setProductName(rs.getString("product_name"));
				productBean.setProductDiscription(rs.getString("product_discription"));
				productBean.setProductPrice(rs.getInt("product_price"));
				productBean.setProductQty(rs.getInt("product_qty"));
				productBean.setProductImg(rs.getString("product_img"));

				product.add(productBean);
			}

		} catch (Exception e) {
			System.out.println("Exception in ProductDao -> ListProduct");
			e.printStackTrace();
		}
		return product;
	}

	public boolean deleteProducts(int productId) {
		Boolean flag = false;

		try (Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("delete from products where product_id = ?");) {
			ptmt.setInt(1, productId);

			int Result = ptmt.executeUpdate();
			if (Result == 1) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Execption -> ProductDao -> DeleteProducts");
		}
		return flag;
	}
	
	public ProductBean getProductById(int productId) {
		ProductBean productBean=null;
		try(Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("select * from products where product_id = ?");
				) {
			ptmt.setInt(1, productId);
			
			ResultSet rs = ptmt.executeQuery();
			while(rs.next()) {
				 productBean =new ProductBean();
				productBean.setProductId(rs.getInt("product_id"));
				productBean.setProductName(rs.getString("product_name"));
				productBean.setProductDiscription(rs.getString("product_discription"));
				productBean.setProductPrice(rs.getInt("product_price"));
				productBean.setProductQty(rs.getInt("product_qty"));
				productBean.setProductImg(rs.getString("product_img"));
				
			}
		} catch (Exception e) {
			System.out.println("SW In ProductDao -> getProductById");
			e.printStackTrace();
		}
		return productBean;
		
	}
	
	public void updateProduct(ProductBean productBean) {
		
		try(Connection con = PgAdmin4Connection.getConnection();
				PreparedStatement ptmt = con.prepareStatement("update products set product_name=?,product_discription=?,product_price=?,product_qty=?,product_img=? where product_id = ?")
				) {
			ptmt.setString(1, productBean.getProductName());
			ptmt.setString(2, productBean.getProductDiscription());
			ptmt.setInt(3, productBean.getProductPrice());
			ptmt.setInt(4, productBean.getProductQty());
			ptmt.setString(5, productBean.getProductImg());
			ptmt.setInt(6, productBean.getProductId());
			
			int record=	ptmt.executeUpdate();
			System.out.println(record);
		} catch (Exception e) {
			System.out.println("SW in ProductDao -> updateProduct()");
			e.printStackTrace();
		}
	}
}

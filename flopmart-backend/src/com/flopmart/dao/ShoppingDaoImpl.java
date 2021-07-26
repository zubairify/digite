package com.flopmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.flopmart.bean.LoginBean;
import com.flopmart.bean.ProductBean;
import com.flopmart.bean.RegisterBean;
import com.flopmart.util.JdbcFactory;

public class ShoppingDaoImpl implements ShoppingDao {

	@Override
	public boolean persist(RegisterBean user) throws SQLException {
		String sql = "insert into users values (?,?,?,?,?,?,?)";
		Connection conn = null;
		
		conn = JdbcFactory.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, user.getEmail());
		stmt.setString(2, user.getPassword());
		stmt.setString(3, user.getName());
		stmt.setInt(4, user.getAge());
		stmt.setString(5, user.getGender());
		stmt.setString(6, user.getCity());
		stmt.setString(7, user.getMobile());
		stmt.executeUpdate();
		return true;
	}

	@Override
	public String validate(LoginBean login) throws SQLException {
		String sql = "select name from users where email=? and password=?";
		Connection conn = null;
		
		conn = JdbcFactory.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, login.getEmail());
		stmt.setString(2, login.getPassword());
		ResultSet rs = stmt.executeQuery();
		if(rs.next())
			return rs.getString(1);
		else
			return null;
	}

	@Override
	public ProductBean fetchProduct(int code) throws SQLException {
		String sql = "select * from products where code=" + code;
		Connection conn = null;
		ProductBean product = null;
		
		conn = JdbcFactory.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		if(rs.next()) {
			product = new ProductBean();
			product.setCode(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setPrice(rs.getDouble(3));
			product.setStock(rs.getInt(4));
			product.setImage(rs.getString(5));
		}
		return product;
	}

	@Override
	public List<ProductBean> fetchProducts() throws SQLException {
		String sql = "select * from products";
		Connection conn = null;
		List<ProductBean> catalog = new ArrayList<ProductBean>();
		
		conn = JdbcFactory.getConnection();
		ResultSet rs = conn.createStatement().executeQuery(sql);
		while(rs.next()) {
			ProductBean product = new ProductBean();
			product.setCode(rs.getInt(1));
			product.setName(rs.getString(2));
			product.setPrice(rs.getDouble(3));
			product.setStock(rs.getInt(4));
			product.setImage(rs.getString(5));
			catalog.add(product);
		}
		return catalog;
	}

}

package com.flopmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.flopmart.bean.LoginBean;
import com.flopmart.bean.ProductBean;
import com.flopmart.bean.RegisterBean;
import com.flopmart.util.JdbcFactory;

public class ShoppingDaoImpl implements ShoppingDao {

	@Override
	public boolean persist(RegisterBean user) throws SQLException {
		String sql = "insert into users values (?,?,?,?,?,?,?)";
		Connection conn = null;
		
		try {
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
		} finally {
			conn.close();
		}
	}

	@Override
	public RegisterBean validate(LoginBean login) throws SQLException {
		String sql = "select * from users where email=? and password=?";
		Connection conn = null;
		RegisterBean user = null;
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, login.getEmail());
			stmt.setString(2, login.getPassword());
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				user = new RegisterBean();
				user.setEmail(rs.getString(1));
				user.setPassword(rs.getString(2));
				user.setName(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setGender(rs.getString(5));
				user.setCity(rs.getString(6));
				user.setMobile(rs.getString(7));
			}
			return user;
		} finally {
			conn.close();
		}
	}

	@Override
	public ProductBean fetchProduct(int code) throws SQLException {
		String sql = "select * from products where code=" + code;
		Connection conn = null;
		ProductBean product = null;
		
		try {
			conn = JdbcFactory.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				product = new ProductBean();
				product.setCode(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setStock(rs.getInt(4));
				product.setImage(rs.getString(5));
			}
			return product;
		} finally {
			conn.close();
		}
	}

	@Override
	public List<ProductBean> fetchProducts() throws SQLException {
		String sql = "select * from products";
		Connection conn = null;
		List<ProductBean> catalog = new ArrayList<ProductBean>();
		
		try {
			conn = JdbcFactory.getConnection();
			ResultSet rs = conn.createStatement().executeQuery(sql);
			while (rs.next()) {
				ProductBean product = new ProductBean();
				product.setCode(rs.getInt(1));
				product.setName(rs.getString(2));
				product.setPrice(rs.getDouble(3));
				product.setStock(rs.getInt(4));
				product.setImage(rs.getString(5));
				catalog.add(product);
			}
			return catalog;
		} finally {
			conn.close();
		}
	}

	@Override
	public void updateStock(String codes) throws SQLException {
		String sql = "update product set stock=stock-1 where code IN (" + codes + ")";
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			conn.createStatement().executeUpdate(sql);
		} finally {
			conn.close();
		}
	}
}

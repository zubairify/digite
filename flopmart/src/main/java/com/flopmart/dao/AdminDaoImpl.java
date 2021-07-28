package com.flopmart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.flopmart.bean.ProductBean;
import com.flopmart.util.JdbcFactory;

public class AdminDaoImpl implements AdminDao {

	@Override
	public boolean saveProduct(ProductBean product) throws SQLException {
		String sql = "insert into products values (?,?,?,?,?)";
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, product.getCode());
			stmt.setString(2, product.getName());
			stmt.setDouble(3, product.getPrice());
			stmt.setInt(4, product.getStock());
			stmt.setString(5, product.getImage());
			stmt.executeUpdate();
			return true;
		} finally {
			conn.close();
		}
	}

	@Override
	public boolean updateStock(int code, int stock) throws SQLException {
		String sql = "update products set stock="+stock+" where code="+code;
		Connection conn = null;
		
		try {
			conn = JdbcFactory.getConnection();
			conn.createStatement().executeUpdate(sql);
			return true;
		} finally {
			conn.close();
		}
	}
}

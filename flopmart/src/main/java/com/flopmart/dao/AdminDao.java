package com.flopmart.dao;

import java.sql.SQLException;

import com.flopmart.bean.ProductBean;

public interface AdminDao {
	
	boolean saveProduct(ProductBean product) throws SQLException;
	
	boolean updateStock(int code, int stock) throws SQLException;
}

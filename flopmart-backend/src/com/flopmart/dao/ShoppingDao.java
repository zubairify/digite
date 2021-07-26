package com.flopmart.dao;

import java.sql.SQLException;
import java.util.List;

import com.flopmart.bean.LoginBean;
import com.flopmart.bean.ProductBean;
import com.flopmart.bean.RegisterBean;

public interface ShoppingDao {

	boolean persist(RegisterBean user) throws SQLException;
	
	String validate(LoginBean login) throws SQLException;
	
	ProductBean fetchProduct(int code) throws SQLException;
	
	List<ProductBean> fetchProducts() throws SQLException;
}

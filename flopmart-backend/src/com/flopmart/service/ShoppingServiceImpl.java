package com.flopmart.service;

import java.sql.SQLException;
import java.util.List;

import com.flopmart.bean.LoginBean;
import com.flopmart.bean.ProductBean;
import com.flopmart.bean.RegisterBean;
import com.flopmart.dao.ShoppingDao;
import com.flopmart.dao.ShoppingDaoImpl;
import com.flopmart.util.FlopEncoder;

public class ShoppingServiceImpl implements ShoppingService {
	private ShoppingDao dao;
	
	public ShoppingServiceImpl() {
		dao = new ShoppingDaoImpl();
	}
	
	@Override
	public boolean addUser(RegisterBean user) {
		user.setPassword(FlopEncoder.encode(user.getPassword()));
		try {
			return dao.persist(user);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public String authenticate(LoginBean login) {
		login.setPassword(FlopEncoder.encode(login.getPassword()));
		try {
			return dao.validate(login);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public ProductBean getProduct(int code) {
		try {
			return dao.fetchProduct(code);
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<ProductBean> getCatalog() {
		try {
			return dao.fetchProducts();
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}

}

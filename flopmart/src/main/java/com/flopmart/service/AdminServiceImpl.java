package com.flopmart.service;

import java.sql.SQLException;

import com.flopmart.bean.ProductBean;
import com.flopmart.dao.AdminDao;
import com.flopmart.dao.AdminDaoImpl;

public class AdminServiceImpl implements AdminService {
	private AdminDao dao;
	
	public AdminServiceImpl() {
		dao = new AdminDaoImpl();
	}
	
	@Override
	public boolean addProduct(ProductBean product) {
		try {
			return dao.saveProduct(product);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean updateStock(int code, int stock) {
		try {
			return dao.updateStock(code, stock);
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}

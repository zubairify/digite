package com.flopmart.service;

import java.util.List;

import com.flopmart.bean.LoginBean;
import com.flopmart.bean.ProductBean;
import com.flopmart.bean.RegisterBean;

public interface ShoppingService {
	
	boolean addUser(RegisterBean user);
	
	String authenticate(LoginBean login);
	
	ProductBean getProduct(int code);
	
	List<ProductBean> getCatalog();
}

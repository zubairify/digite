package com.flopmart.service;

import com.flopmart.bean.ProductBean;

public interface AdminService {
	
	boolean addProduct(ProductBean product);
	
	boolean updateStock(int code, int stock);
}

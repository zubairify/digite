package com.flopmart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flopmart.bean.ProductBean;
import com.flopmart.service.AdminService;
import com.flopmart.service.AdminServiceImpl;
import com.flopmart.service.ShoppingService;
import com.flopmart.service.ShoppingServiceImpl;

@WebServlet(name = "Admin", urlPatterns = { "/Admin.fm" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminService adminService;
	private ShoppingService shopService;
	
	@Override
	public void init() {
		adminService = new AdminServiceImpl();
		shopService = new ShoppingServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("referer");
		if(referer.contains("product")) {
			ProductBean product = new ProductBean();
			product.setCode(Integer.parseInt(request.getParameter("code")));
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setStock(Integer.parseInt(request.getParameter("stock")));
			product.setImage(request.getParameter("image"));
			
			if(!adminService.addProduct(product)) 
				response.sendRedirect("product.jsp?failed=yes");
			
		}
		if(request.getParameter("stock") != null) {
			int code = Integer.parseInt(request.getParameter("code"));
			int stock = Integer.parseInt(request.getParameter("stock"));
			adminService.updateStock(code, stock);
		}
		List<ProductBean> products = shopService.getCatalog();
		request.setAttribute("PRODUCTS", products);
		getServletContext().getRequestDispatcher("/admin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

package com.flopmart.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.flopmart.bean.ProductBean;
import com.flopmart.service.ShoppingService;
import com.flopmart.service.ShoppingServiceImpl;

@WebServlet(name = "/Checkout", urlPatterns = {"/Checkout.fm"})
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingService service;
	
	@Override
	public void init() throws ServletException {
		service = new ShoppingServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String referer = request.getHeader("referer");
		if(referer.contains("cart")) {
			// Request coming from cart for checkout
			double amount = Double.parseDouble(request.getParameter("amount"));
			request.setAttribute("TOTAL", amount);
			getServletContext().getRequestDispatcher("/payment.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			List<ProductBean> products = (List<ProductBean>) session.getAttribute("CART");
			service.updateStock(products);
			session.removeAttribute("CART");
			response.sendRedirect("summary.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

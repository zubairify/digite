package com.flopmart.web;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet(name = "Cart", urlPatterns = { "/Cart.fm" })
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoppingService service;
	
	@Override
	public void init() throws ServletException {
		service = new ShoppingServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String code = request.getParameter("code");
		
		if(code != null) {
			// Request is received for adding product to cart
			HttpSession session = request.getSession();
			ProductBean product = service.getProduct(Integer.parseInt(code));
			
			List<ProductBean> cart = (List<ProductBean>) session.getAttribute("CART");
			
			if(cart == null)	// session is new, no existing cart found
				cart = new ArrayList<ProductBean>(); // Instantiating cart for first use
			
			cart.add(product);	// adding product to cart
			session.setAttribute("CART", cart);	// Adding/Updating cart into session
			
			response.sendRedirect("cart.jsp");
			
		} else {
			// Request is for populating product catalogue
			List<ProductBean> catalog = service.getCatalog();
			System.out.println("Product Fetched: " + catalog.size());
			
			// Adding product list to request scope
			request.setAttribute("CATALOG", catalog);
	
			// Forward to catalog page along with product list in request scope
			getServletContext().getRequestDispatcher("/catalog.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}

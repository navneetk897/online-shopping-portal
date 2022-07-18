package com.shoppingPortal.servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingPortal.DAO.DataBaseService;
import com.shoppingPortal.Model.Product;

public class CartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DataBaseService dataBaseService = new DataBaseService();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws IOException {
		PrintWriter writer = response.getWriter();
		String userId = request.getParameter("userId");
		List<Product> products = dataBaseService.getProducts(userId);
		for (Product product : products) {
			writer.println(product.getProductId() + "," 
							+ product.getProductName() + ","
							+ product.getProductDesc() + ","
							+ product.getPrice());
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String userId = request.getParameter("userId");
		String productId = request.getParameter("productId");
		dataBaseService.addToCart(userId, productId);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
		String userId = request.getParameter("userId");
		String productId = request.getParameter("productId");
		dataBaseService.deleteFromCart(userId, productId);
	}
}

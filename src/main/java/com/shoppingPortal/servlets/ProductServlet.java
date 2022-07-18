package com.shoppingPortal.servlets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.shoppingPortal.DAO.DataBaseService;
import com.shoppingPortal.Model.Product;

public class ProductServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private DataBaseService dataBaseService = new DataBaseService();
	
	@Override
	protected void doGet(HttpServletRequest reqquest, HttpServletResponse response)
	throws IOException {
		List<Product> products = dataBaseService.getProducts();
		PrintWriter writer = response.getWriter();
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
		BufferedReader reader = request.getReader();
		String[] productData = reader.readLine().split(",");
		String productId = dataBaseService.getProductId();
		Product product = new Product(productId, productData[0],
							productData[1], productData[2]);
		dataBaseService.addProduct(product);
	}
	
	@Override
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) {
		String productId = request.getHeader("productId");
		dataBaseService.deleteProduct(productId);
	}
}

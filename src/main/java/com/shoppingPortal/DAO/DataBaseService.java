package com.shoppingPortal.DAO;


import java.util.List;

import com.shoppingPortal.Model.Product;
import com.shoppingPortal.Model.Session;

public class DataBaseService {
	
	public Session getSession(String userName, String password) {
		return null;
	}
	
	public Session getSession(String sessionId) {
		return null;
	}
	
	public void deleteSession(String sessionId) {
		
	}
	
	public String getProductId() {
		return null;
	}
	
	public void addProduct(Product product) {
		
	}
	
	public void deleteProduct(String productId) {
		
	}
	
	public List<Product> getProducts() {
		return null;
	}
	
	public List<Product> getProducts(String userId) {
		return null;
	}

	public void addToCart(String userId, String productId) {
		
	}
	
	public void deleteFromCart(String userId, String productId) {
		
	}
}

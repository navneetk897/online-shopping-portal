package com.shoppingPortal.Model;

public class Product {
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDesc() {
		return productDesc;
	}

	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	private String productId;
	private String productName;
	private String productDesc;
	private String price;
	
	public Product(String productId, String productName, String productDesc, String price) {
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.price = price;
	}
	
}

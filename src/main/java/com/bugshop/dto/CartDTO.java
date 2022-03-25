package com.bugshop.dto;

public class CartDTO {

	private int quantity;
	private double totalprice;
	private ProductDTO products;
	
	public CartDTO() {
		
	}
	public CartDTO(int quantity, double totalprice, ProductDTO products) {
		super();
		this.quantity = quantity;
		this.totalprice = totalprice;
		this.products = products;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}
	public ProductDTO getProducts() {
		return products;
	}
	public void setProducts(ProductDTO products) {
		this.products = products;
	}
	
}

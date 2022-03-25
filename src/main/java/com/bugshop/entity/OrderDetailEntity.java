package com.bugshop.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_detail")
public class OrderDetailEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_details_id;


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id")
	private OrderEntity order;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	@Column(name = "product_price")
	private Double product_price;
	@Column(name = "product_sales_quantity")
	private int product_sales_quantity;
	@Column(name="product_name", columnDefinition = "nvarchar(255)")
	private String product_name;
	
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public long getOrder_details_id() {
		return order_details_id;
	}
	public void setOrder_details_id(long order_details_id) {
		this.order_details_id = order_details_id;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	public ProductEntity getProduct() {
		return product;
	}
	public void setProduct(ProductEntity product) {
		this.product = product;
	}
	public Double getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Double product_price) {
		this.product_price = product_price;
	}
	public int getProduct_sales_quantity() {
		return product_sales_quantity;
	}
	public void setProduct_sales_quantity(int product_sales_quantity) {
		this.product_sales_quantity = product_sales_quantity;
	}


}

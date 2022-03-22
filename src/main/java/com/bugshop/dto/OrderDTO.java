package com.bugshop.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Transient;

import com.bugshop.entity.ProductEntity;

public class OrderDTO extends AbstractDTO<OrderDTO>{

	
	private long order_id ;
	
	
	private Date CreateDate;
	
	
	@Transient
	private long customer_id;
	
	private int Status;
	
	private String shipping_name;
	
	private String shipping_email;

	private String shipping_address;
	
	private String order_note;
	
	private String order_code;
	
	private int shipping_type;

	private String shipping_phone;
	
	
    private List<ProductEntity> products = new ArrayList<>();


	public long getOrder_id() {
		return order_id;
	}


	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}


	public Date getCreateDate() {
		return CreateDate;
	}


	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}


	public long getCustomer_id() {
		return customer_id;
	}


	public void setCustomer_id(long customer_id) {
		this.customer_id = customer_id;
	}


	public int getStatus() {
		return Status;
	}


	public void setStatus(int status) {
		Status = status;
	}


	public String getShipping_name() {
		return shipping_name;
	}


	public void setShipping_name(String shipping_name) {
		this.shipping_name = shipping_name;
	}


	public String getShipping_email() {
		return shipping_email;
	}


	public void setShipping_email(String shipping_email) {
		this.shipping_email = shipping_email;
	}


	public String getShipping_address() {
		return shipping_address;
	}


	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}


	public String getOrder_note() {
		return order_note;
	}


	public void setOrder_note(String order_note) {
		this.order_note = order_note;
	}


	public String getOrder_code() {
		return order_code;
	}


	public void setOrder_code(String order_code) {
		this.order_code = order_code;
	}


	public int getShipping_type() {
		return shipping_type;
	}


	public void setShipping_type(int shipping_type) {
		this.shipping_type = shipping_type;
	}


	public String getShipping_phone() {
		return shipping_phone;
	}


	public void setShipping_phone(String shipping_phone) {
		this.shipping_phone = shipping_phone;
	}


	public List<ProductEntity> getProducts() {
		return products;
	}


	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}
    
	
}

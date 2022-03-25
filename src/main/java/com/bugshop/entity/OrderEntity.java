package com.bugshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "tbl_order")
public class OrderEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long order_id;

	@Column(name = "CreateDate")
	@CreatedDate
	private Date CreateDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private UserEntity user;
	@Column(name = "order_status")
	private int Status;
	@Column(name = "shipping_name", columnDefinition = "nvarchar(255)")
	private String shipping_name;
	@Column(name = "shipping_email", columnDefinition = "nvarchar(255)")
	private String shipping_email;
	@Column(name = "shipping_address", columnDefinition = "ntext")
	private String shipping_address;
	@Column(name = "order_note", columnDefinition = "ntext")
	private String order_note;
	@Column(name = "order_code", columnDefinition = "varchar(5)")
	private String order_code;
	@Column(name = "shipping_type")
	private int shipping_type;
	@Column(name = "shipping_phone", columnDefinition = "varchar(11)")
	private String shipping_phone;

	public Date getCreateDate() {
		return CreateDate;
	}

	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
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



	public long getOrder_id() {
		return order_id;
	}

}

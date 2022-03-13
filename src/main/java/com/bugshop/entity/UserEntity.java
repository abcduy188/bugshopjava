package com.bugshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "User")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "CreateDate")
	@CreatedDate
	private Date CreateDate;
	
	@Column(name = "ModifiedDate")
	@LastModifiedDate
	private Date ModifiedDate;
	
	@Column(name = "CreateBy")
	@CreatedBy
	private String CreateBy;
	
	@Column(name = "ModifiedBy")
	@LastModifiedBy
	private String ModifiedBy;
	@Column(name = "email", columnDefinition = "nvarchar(255)")
	private String email;
	@Column(name = "password", columnDefinition = "nvarchar(255)")
	private String password;
	@Column(name = "Name", columnDefinition = "nvarchar(255)")
	private String Name;
	@Column
	private int status;
	
	
	
	//lazy : co list load tu bang role, chi load khi dc goi ra
	
	//tao khoa ngoai n-n
	@ManyToMany(fetch= FetchType.LAZY)
	@JoinTable(name = "roles_user", joinColumns = @JoinColumn(name = "user_id"),
								   inverseJoinColumns = @JoinColumn(name = "roles_id"))
	private List<RoleEntity> roles = new ArrayList<>();
	//
	
	
	
	
	@Column(name = "IsDelete", columnDefinition = "boolean default false" )
	private boolean IsDelete;
	
	public boolean isIsDelete() {
		return IsDelete;
	}
	public void setIsDelete(boolean isDelete) {
		IsDelete = isDelete;
	}
	public Long getID() {
		return id;
	}
	
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Date getModifiedDate() {
		return ModifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		ModifiedDate = modifiedDate;
	}
	public String getCreateBy() {
		return CreateBy;
	}
	public void setCreateBy(String createBy) {
		CreateBy = createBy;
	}
	public String getModifiedBy() {
		return ModifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		ModifiedBy = modifiedBy;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public List<RoleEntity> getRoles() {
		return roles;
	}
	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}
	
	
}

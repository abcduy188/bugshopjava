package com.bugshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="role")
public class RoleEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
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
	@Column(name ="name", columnDefinition = "nvarchar(255)")
	private String Name;
	@Column(name ="role", columnDefinition = "nvarchar(50)")
	private String Code;
	
	@ManyToMany(mappedBy = "roles")
    private List<UserEntity> users = new ArrayList<>();

	public Long getID() {
		return ID;
	}

	public void setID(Long iD) {
		ID = iD;
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

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}


	
}


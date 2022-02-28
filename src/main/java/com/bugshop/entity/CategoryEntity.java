package com.bugshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

@Entity
@Table(name="CategoryProduct")
public class CategoryEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name = "ParentID")
	private Long ParentID;
	
	
	@Column(name = "SeoTitle",  columnDefinition = "nvarchar(255)")
	private String SeoTitle;
	
	
	@Column(name = "CreateDate")
	@CreatedBy
	private Date CreateDate;
	
	@Column(name = "ModifiedDate")
	@LastModifiedBy
	private Date ModifiedDate;
	
	@Column(name = "CreateBy")
	@CreatedBy
	private String CreateBy;
	
	@Column(name = "ModifiedBy")
	@LastModifiedBy
	private String ModifiedBy;
	@Column(name ="CategoryName", columnDefinition = "nvarchar(255)")
	private String CategoryName;
	@OneToMany(mappedBy="category")
	private List<productEntity> products = new ArrayList<>();
	
	@Column(name = "Status",columnDefinition = "boolean default true")
	private boolean Status;
	@Column(name = "IsDelete", columnDefinition = "boolean default false" )
	private boolean IsDelete;
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public boolean isIsDelete() {
		return IsDelete;
	}
	public void setIsDelete(boolean isDelete) {
		IsDelete = isDelete;
	}
	

	
	public Long getID() {
		return ID;
	}
	
	public Long getParentID() {
		return ParentID;
	}
	public void setParentID(Long parentID) {
		ParentID = parentID;
	}
	public String getSeoTitle() {
		return SeoTitle;
	}
	public void setSeoTitle(String seoTitle) {
		SeoTitle = seoTitle;
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
	public String getCategoryName() {
		return CategoryName;
	}
	public void setCategoryName(String categoryName) {
		CategoryName = categoryName;
	}
	public List<productEntity> getProducts() {
		return products;
	}
	public void setProducts(List<productEntity> products) {
		this.products = products;
	}
	
}

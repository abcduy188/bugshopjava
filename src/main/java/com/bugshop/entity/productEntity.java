package com.bugshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Id;

@Entity
@Table(name = "product")
public class productEntity {
		@Id
		//Auto increment
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long ID;
		@Column(name = "Name")
		private String Name;
		@Column(name = "SeoTitle",  columnDefinition = "nvarchar(255)")
		private String SeoTitle;
		@Column(name = "Description",  columnDefinition = "ntext")
		private String Description;
		@Column(name = "Image")
		private String Image;
		@Column(name = "Price")
		private Double Price;
		@Column(name = "PromotionPrice")
		private Double PromotionPrice;
		@Column(name = "Quantity")
		private int Quantity;
		@Column(name = "Status",columnDefinition = "boolean default true")
		private boolean Status;
		@Column(name = "IsDelete", columnDefinition = "boolean default false" )
		private boolean IsDelete;
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name = "category_id")
		private CategoryEntity category;
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
		
		//bien tam ko dung trong csdl
		@Transient
		private String abc;
		
		
		public CategoryEntity getCategory() {
			return category;
		}
		public void setCategory(CategoryEntity category) {
			this.category = category;
		}
		public long getID() {
			return ID;
		}
		
		public String getName() {
			return Name;
		}
		public void setName(String name) {
			Name = name;
		}
		public String getSeoTitle() {
			return SeoTitle;
		}
		public void setSeoTitle(String seoTitle) {
			SeoTitle = seoTitle;
		}
		public String getDescription() {
			return Description;
		}
		public void setDescription(String description) {
			Description = description;
		}
		public String getImage() {
			return Image;
		}
		public void setImage(String image) {
			Image = image;
		}
		public Double getPrice() {
			return Price;
		}
		public void setPrice(Double price) {
			Price = price;
		}
		public Double getPromotionPrice() {
			return PromotionPrice;
		}
		public void setPromotionPrice(Double promotionPrice) {
			PromotionPrice = promotionPrice;
		}
		public int getQuantity() {
			return Quantity;
		}
		public void setQuantity(int quantity) {
			Quantity = quantity;
		}
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
		
}

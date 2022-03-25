package com.bugshop.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.Id;

@Entity
@Table(name = "product")
public class ProductEntity {
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
		
		@Column(name = "highlights",columnDefinition = "boolean default true")
		private boolean highlights;
		@Column(name = "cpu",  columnDefinition = "nvarchar(255)")
		private String cpu;
		@Column(name = "vga",  columnDefinition = "nvarchar(255)")
		private String vga;
		@Column(name = "ram",  columnDefinition = "nvarchar(255)")
		private String ram;
		@Column(name = "monitor",  columnDefinition = "nvarchar(255)")
		private String monitor;
		
		
		public void setID(long iD) {
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
		public boolean isHighlights() {
			return highlights;
		}
		public void setHighlights(boolean highlights) {
			this.highlights = highlights;
		}
		public String getCpu() {
			return cpu;
		}
		public void setCpu(String cpu) {
			this.cpu = cpu;
		}
		public String getVga() {
			return vga;
		}
		public void setVga(String vga) {
			this.vga = vga;
		}
		public String getRam() {
			return ram;
		}
		public void setRam(String ram) {
			this.ram = ram;
		}
		public String getMonitor() {
			return monitor;
		}
		public void setMonitor(String monitor) {
			this.monitor = monitor;
		}
		
}

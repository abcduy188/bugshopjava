package com.bugshop.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AbstractDTO<T> {
	private Long iD;
	private List<T> listResult = new ArrayList<>();
	private boolean status;
	private boolean isDelete;
	private String createBy;
	private Date modifiedDate;
	private Date createDate;
	private String modifiedBy;
	public Long getiD() {
		return iD;
	}
	public void setiD(Long iD) {
		this.iD = iD;
	}
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public boolean isDelete() {
		return isDelete;
	}
	public void setDelete(boolean isDelete) {
		this.isDelete = isDelete;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
	
}

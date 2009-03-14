package com.ejd.web.vo.productcategory;

public class ProductCategoryItem {
	private Integer id;
	private String categoryName;
	private Integer serialNumber;
	private Boolean selected = Boolean.FALSE;
	public ProductCategoryItem() {
	}
	public ProductCategoryItem(Integer id, String categoryName,
			Integer serialNumber, Boolean selected) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.serialNumber = serialNumber;
		this.selected = selected;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
	public Boolean getSelected() {
		return selected;
	}
	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

}

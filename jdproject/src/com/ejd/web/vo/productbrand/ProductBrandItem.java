package com.ejd.web.vo.productbrand;

public class ProductBrandItem {
	private Integer id;
	private String brandName;
	private Integer serialNumber;
	private Boolean selected = Boolean.FALSE;
	public ProductBrandItem() {
	}
	public ProductBrandItem(Integer id, String brandName,
			Integer serialNumber, Boolean selected) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.serialNumber = serialNumber;
		this.selected = selected;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
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

package com.ejd.web.vo.productunit;

public class ProductUnitItem {
	private Integer id;
	private String unitName;
	private Integer serialNumber;
	private Boolean selected = Boolean.FALSE;
	public ProductUnitItem() {
	}
	public ProductUnitItem(Integer id, String unitName,
			Integer serialNumber, Boolean selected) {
		super();
		this.id = id;
		this.unitName = unitName;
		this.serialNumber = serialNumber;
		this.selected = selected;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
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

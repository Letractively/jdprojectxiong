package com.ejd.web.bo;

public class AbstractConsignee extends java.lang.Object implements java.io.Serializable{
	private Integer id;
	private Integer stakeholderId;
	private String shortName;
	private String invoiceCompanyName;//the invoice title
	private String consigneeName;
	private String consigneeMobile;
	private String consigneePhone;
	private String consigneeTax;
	private String consigneeZip;
	private String consigneeProvince;
	private String consigneeCity;
	private String consigneeCounty;
	private String consigneeAddress;
	private String remark;
	private boolean selected;
	public AbstractConsignee(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStakeholderId() {
		return stakeholderId;
	}

	public void setStakeholderId(Integer stakeholderId) {
		this.stakeholderId = stakeholderId;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getInvoiceCompanyName() {
		return invoiceCompanyName;
	}

	public void setInvoiceCompanyName(String invoiceCompanyName) {
		this.invoiceCompanyName = invoiceCompanyName;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeMobile() {
		return consigneeMobile;
	}

	public void setConsigneeMobile(String consigneeMobile) {
		this.consigneeMobile = consigneeMobile;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}

	public String getConsigneeTax() {
		return consigneeTax;
	}

	public void setConsigneeTax(String consigneeTax) {
		this.consigneeTax = consigneeTax;
	}

	public String getConsigneeZip() {
		return consigneeZip;
	}

	public void setConsigneeZip(String consigneeZip) {
		this.consigneeZip = consigneeZip;
	}

	public String getConsigneeProvince() {
		return consigneeProvince;
	}

	public void setConsigneeProvince(String consigneeProvince) {
		this.consigneeProvince = consigneeProvince;
	}

	public String getConsigneeCity() {
		return consigneeCity;
	}

	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}

	public String getConsigneeCounty() {
		return consigneeCounty;
	}

	public void setConsigneeCounty(String consigneeCounty) {
		this.consigneeCounty = consigneeCounty;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
}

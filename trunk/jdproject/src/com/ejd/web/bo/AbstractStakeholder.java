package com.ejd.web.bo;

/**
 * AbstractStakeholder entity provides the base persistence definition of the
 * Stakeholder entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractStakeholder extends java.lang.Object implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String mnemonicchars;
	private String shortName;
	private String fullName;
	private String province;
	private String city;
	private String county;
	private String phone;
	private String tax;
	private String url;
	private String remarks;
	private String status;
	private String type;
	private String taxaccounts;

	// Constructors

	/** default constructor */
	public AbstractStakeholder() {
	}

	/** minimal constructor */
	public AbstractStakeholder(String mnemonicchars, String shortName,
			String fullName, String status, String type) {
		this.mnemonicchars = mnemonicchars;
		this.shortName = shortName;
		this.fullName = fullName;
		this.status = status;
		this.type = type;
	}

	/** full constructor */
	public AbstractStakeholder(String mnemonicchars, String shortName,
			String fullName, String province, String city, String county,
			String phone, String tax, String url, String remarks,
			String status, String type, String taxaccounts) {
		this.mnemonicchars = mnemonicchars;
		this.shortName = shortName;
		this.fullName = fullName;
		this.province = province;
		this.city = city;
		this.county = county;
		this.phone = phone;
		this.tax = tax;
		this.url = url;
		this.remarks = remarks;
		this.status = status;
		this.type = type;
		this.taxaccounts = taxaccounts;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMnemonicchars() {
		return this.mnemonicchars;
	}

	public void setMnemonicchars(String mnemonicchars) {
		this.mnemonicchars = mnemonicchars;
	}

	public String getShortName() {
		return this.shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTax() {
		return this.tax;
	}

	public void setTax(String tax) {
		this.tax = tax;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getRemarks() {
		return this.remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTaxaccounts() {
		return this.taxaccounts;
	}

	public void setTaxaccounts(String taxaccounts) {
		this.taxaccounts = taxaccounts;
	}

}
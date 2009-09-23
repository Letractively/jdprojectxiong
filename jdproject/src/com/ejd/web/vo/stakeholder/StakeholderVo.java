package com.ejd.web.vo.stakeholder;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

public class StakeholderVo {
	
	private Integer id;
	@NotEmpty
	@Length(min=2,max=20)
	private String userId;
	private String userPassword;
	private String mnemonicchars;
	private String shortName;
	@NotEmpty
	@Length(min=2,max=100)
	private String fullName;
	private String province;
	private String city;
	private String county;
	private String phone;
	private String tax;
	private String url;
	@Length(min=0,max=1000)
	private String remarks;
	@NotEmpty
	@Length(min=1,max=1)
	private String status;
	@NotEmpty
	@Length(min=1,max=1)
	private String type;
	private String taxaccounts;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getMnemonicchars() {
		return mnemonicchars;
	}
	public void setMnemonicchars(String mnemonicchars) {
		this.mnemonicchars = mnemonicchars;
	}
	public String getShortName() {
		return shortName;
	}
	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCounty() {
		return county;
	}
	public void setCounty(String county) {
		this.county = county;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTaxaccounts() {
		return taxaccounts;
	}
	public void setTaxaccounts(String taxaccounts) {
		this.taxaccounts = taxaccounts;
	}
	public StakeholderVo() {
		
	}
	public StakeholderVo(String userId, String fullName, String status, String type) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.status = status;
		this.type = type;
	}
	public StakeholderVo(String userId, String fullName, String type) {
		super();
		this.userId = userId;
		this.fullName = fullName;
		this.type = type;
		this.status = "A";
	}
	public StakeholderVo(String userId, String userPassword, String mnemonicchars, String shortName, String fullName, String province, String city, String county,
			 String phone, String tax, String url, String remarks,  String status, String type, String taxaccounts) {
		super();
		this.userId = userId;
		this.userPassword = userPassword;
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
	
}

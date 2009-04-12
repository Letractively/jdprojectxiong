package com.ejd.web.bo;

/**
 * AbstractBank entity provides the base persistence definition of the Bank
 * entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractBank extends java.lang.Object implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String accountName;
	private String accountNumber;
	private String bankName;
	private String bankAddress;
	private Integer stakeholderId;
	private Integer sortOrder;
	
	// Constructors

	/** default constructor */
	public AbstractBank() {
	}

	/** minimal constructor */
	public AbstractBank(String accountName, String accountNumber,
			String bankName, String bankAddress, Integer sortOrder) {
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.sortOrder = sortOrder;
	}

	/** full constructor */
	public AbstractBank(String accountName, String accountNumber,
			String bankName, String bankAddress, Integer stakeholderId, Integer sortOrder) {
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.stakeholderId = stakeholderId;
		this.sortOrder = sortOrder;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountName() {
		return this.accountName;
	}

	public void setAccountName(String accountname) {
		this.accountName = accountname;
	}

	public String getAccountNumber() {
		return this.accountNumber;
	}

	public void setAccountNumber(String accountnumber) {
		this.accountNumber = accountnumber;
	}

	public String getBankName() {
		return this.bankName;
	}

	public void setBankName(String bankname) {
		this.bankName = bankname;
	}

	public String getBankAddress() {
		return this.bankAddress;
	}

	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}

	public Integer getStakeholderId() {
		return this.stakeholderId;
	}

	public void setStakeholderId(Integer stakeholderId) {
		this.stakeholderId = stakeholderId;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

}
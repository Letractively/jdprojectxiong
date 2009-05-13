package com.ejd.web.vo.stakeholder;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;

public class BankVo {
	private Integer id;
	@NotEmpty
	@Length(min=2,max=50)
	private String accountName;
	@NotEmpty
	@Length(min=2,max=16)
	private String accountNumber;
	@NotEmpty
	@Length(min=2,max=50)
	private String bankName;
	private String bankAddress;
	private Integer sortOrder;
	private boolean selected;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getBankAddress() {
		return bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this.bankAddress = bankAddress;
	}
	public Integer getSortOrder() {
		return sortOrder;
	}
	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}
	public boolean isSelected() {
		return selected;
	}
	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public BankVo() {
		
	}
	public BankVo(String accountName, String accountNumber, String bankName) {
		super();
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.sortOrder = 1;
		this.selected = Boolean.FALSE;
	}
	public BankVo(String accountName, String accountNumber, String bankName, String bankAddress, Integer sortOrder, boolean selected) {
		super();
		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.bankAddress = bankAddress;
		this.sortOrder = sortOrder;
		this.selected = selected;
	}
}

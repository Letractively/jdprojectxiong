package com.ejd.web.bo;

/**
 * Bank entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Bank extends AbstractBank implements java.io.Serializable {

	// Constructors
	Stakeholder stakeholder;
	/** default constructor */
	public Bank() {
	}

	/** minimal constructor */
	public Bank(String accountName, String accountNumber, String bankName,
			String bankAddress,Integer sortOrder) {
		super(accountName, accountNumber, bankName, bankAddress, sortOrder);
	}

	/** full constructor */
	public Bank(String accountName, String accountNumber, String bankName,
			String bankAddress, Integer stakeholderId, Integer sortOrder) {
		super(accountName, accountNumber, bankName, bankAddress, stakeholderId, sortOrder);
	}

	public Stakeholder getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(Stakeholder stakeholder) {
		this.stakeholder = stakeholder;
	}

}

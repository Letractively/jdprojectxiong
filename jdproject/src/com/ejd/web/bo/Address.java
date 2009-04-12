package com.ejd.web.bo;

/**
 * Address entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Address extends AbstractAddress implements java.io.Serializable {

	// Constructors
	Stakeholder stakeholder;
	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(String address,String zip, String desc,Integer sortOrder) {
		super(address, zip, desc, sortOrder);
	}

	/** full constructor */
	public Address(String address, String zip, String desc,
			Integer stakeholderId, Integer sortOrder) {
		super(address, zip, desc, stakeholderId, sortOrder);
	}

	public Stakeholder getStakeholder() {
		return stakeholder;
	}

	public void setStakeholder(Stakeholder stakeholder) {
		this.stakeholder = stakeholder;
	}

}

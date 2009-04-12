package com.ejd.web.bo;

/**
 * AbstractAddress entity provides the base persistence definition of the
 * Address entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractAddress extends java.lang.Object implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String address;
	private String zip;
	private String desc;
	private Integer stakeholderId;
	private Integer sortOrder;

	// Constructors

	/** default constructor */
	public AbstractAddress() {
	}

	/** minimal constructor */
	public AbstractAddress(String address,String zip, String desc , Integer sortOrder) {
		this.address = address;
		this.zip = zip;
		this.desc = desc;
		this.sortOrder = sortOrder;
	}

	/** full constructor */
	public AbstractAddress(String address, String zip, String desc,
			Integer stakeholderId , Integer sortOrder) {
		this.address = address;
		this.zip = zip;
		this.desc = desc;
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

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
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
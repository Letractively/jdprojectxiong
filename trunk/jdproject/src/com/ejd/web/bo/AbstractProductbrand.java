package com.ejd.web.bo;

/**
 * AbstractProductbrand entity provides the base persistence definition of the
 * Productbrand entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractProductbrand extends java.lang.Object implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String brandName;
	private Integer serialNumber;

	// Constructors

	/** default constructor */
	public AbstractProductbrand() {
	}

	/** minimal constructor */
	public AbstractProductbrand(String brandName) {
		this.brandName = brandName;
	}

	/** full constructor */
	public AbstractProductbrand(String brandName, Integer serialNumber) {
		this.brandName = brandName;
		this.serialNumber = serialNumber;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBrandName() {
		return this.brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

}
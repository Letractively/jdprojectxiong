package com.ejd.web.bo;

/**
 * AbstractProductbrand entity provides the base persistence definition of the
 * Productbrand entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractProductunit extends java.lang.Object implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String unitName;
	private Integer serialNumber;

	// Constructors

	/** default constructor */
	public AbstractProductunit() {
	}

	/** minimal constructor */
	public AbstractProductunit(String unitName) {
		this.unitName = unitName;
	}

	/** full constructor */
	public AbstractProductunit(String unitName, Integer serialNumber) {
		this.unitName = unitName;
		this.serialNumber = serialNumber;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUnitName() {
		return this.unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public Integer getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

}
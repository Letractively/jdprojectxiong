package com.ejd.web.bo;

/**
 * AbstractProductcategory entity provides the base persistence definition of
 * the Productcategory entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractProductcategory extends java.lang.Object
		implements java.io.Serializable {

	// Fields

	private Integer id;
	private String categoryName;
	private Integer serialNumber;
	// Constructors

	/** default constructor */
	public AbstractProductcategory() {
	}

	/** full constructor */
	public AbstractProductcategory(String categoryName) {
		this.categoryName = categoryName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryName() {
		return this.categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}

}
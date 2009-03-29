package com.ejd.web.bo;

/**
 * Productbrand entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Productbrand extends AbstractProductbrand implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Productbrand() {
	}

	/** minimal constructor */
	public Productbrand(String brandname) {
		super(brandname);
	}

	/** full constructor */
	public Productbrand(String brandName, Integer serialNumber) {
		super(brandName, serialNumber);
	}

}

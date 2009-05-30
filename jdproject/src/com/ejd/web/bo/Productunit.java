package com.ejd.web.bo;

/**
 * Productbrand entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Productunit extends AbstractProductunit implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public Productunit() {
	}

	/** minimal constructor */
	public Productunit(String unitname) {
		super(unitname);
	}

	/** full constructor */
	public Productunit(String unitName, Integer serialNumber) {
		super(unitName, serialNumber);
	}

}

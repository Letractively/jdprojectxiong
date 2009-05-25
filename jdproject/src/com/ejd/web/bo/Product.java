package com.ejd.web.bo;

/**
 * Product entity.
 * 
 * @author MyEclipse Persistence Tools
 */
public class Product extends AbstractProduct implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Product() {
	}

	/** minimal constructor */
	public Product(String code, Stakeholder provider, Productcategory primaryCategory,
			Productcategory secondCategory, Productbrand brand, String status) {
		super(code, provider, primaryCategory, secondCategory, brand,
				status);
	}

	/** full constructor */
	public Product(String code, String manufacturerCode, String name,
			Stakeholder provider, Productcategory primaryCategory,
			Productcategory secondCategory, Productbrand brand, String status,
			Double purchaseprice, Double tradePriceOne, Double tradePriceTwo,
			Double retailPrice, String introduceFileName) {
		super(code, manufacturerCode, name, provider, primaryCategory,
				secondCategory, brand, status, purchaseprice,
				tradePriceOne, tradePriceTwo, retailPrice, introduceFileName);
	}

}

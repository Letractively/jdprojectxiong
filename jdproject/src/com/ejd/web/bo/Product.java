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
	public Product(String code, Stakeholder provider, String primaryCategoryCode,
			String secondCategoryCode, String brandCode, String status) {
		super(code, provider, primaryCategoryCode, secondCategoryCode, brandCode,
				status);
	}

	/** full constructor */
	public Product(String code, String manufacturerCode,String barcode,String spec,Productunit unit,Integer stockLowerNumber,Integer stockUpperNumber,Integer currentNumber,String imageName, String name,
			Stakeholder provider, String primaryCategoryCode,
			String secondCategoryCode, String brandCode, String status,
			Double purchaseprice, Double tradePriceOne, Double tradePriceTwo,
			Double retailPrice,Double integration, String introduceFileName) {
		super(code, manufacturerCode, barcode, spec, unit, stockLowerNumber, stockUpperNumber, currentNumber, imageName,name, provider, primaryCategoryCode,
				secondCategoryCode, brandCode, status, purchaseprice,
				tradePriceOne, tradePriceTwo, retailPrice,integration, introduceFileName);
	}

}

package com.ejd.web.vo.genl.productnavigation;

import java.util.List;

import com.ejd.web.vo.productbrand.ProductBrand;
import com.ejd.web.vo.productcategory.ProductCategory;

public class ProductGroup {
	private ProductCategory primaryCategory;
	private List<ProductBrand> brands;
	private List<ProductCategory> secondCategorys;
	public ProductGroup() {
		super();
	}
	
	public ProductGroup(ProductCategory primaryCategory,
			List<ProductBrand> brands, List<ProductCategory> secondCategorys) {
		super();
		this.primaryCategory = primaryCategory;
		this.brands = brands;
		this.secondCategorys = secondCategorys;
	}

	public ProductCategory getPrimaryCategory() {
		return primaryCategory;
	}
	public void setPrimaryCategory(ProductCategory primaryCategory) {
		this.primaryCategory = primaryCategory;
	}
	public List<ProductBrand> getBrands() {
		return brands;
	}
	public void setBrands(List<ProductBrand> brands) {
		this.brands = brands;
	}
	public List<ProductCategory> getSecondCategorys() {
		return secondCategorys;
	}
	public void setSecondCategorys(List<ProductCategory> secondCategorys) {
		this.secondCategorys = secondCategorys;
	}
	

}

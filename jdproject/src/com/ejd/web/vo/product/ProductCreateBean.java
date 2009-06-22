package com.ejd.web.vo.product;

public class ProductCreateBean extends ProductBaseBean {

	private ProductVo product;

	public ProductCreateBean() {
		super();
		product = new ProductVo();
		product.setStockLowerNumber(1);
		product.setStockUpperNumber(1);
	}
	public ProductCreateBean(ProductVo product) {
		super();
		this.product = product;
	}

	public ProductVo getProduct() {
		return product;
	}

	public void setProduct(ProductVo product) {
		this.product = product;
	}
	
}

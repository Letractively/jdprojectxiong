package com.ejd.web.vo;

import com.ejd.model.service.iface.IProductCategoryService;


public class ProductCategoryBaseBean {
	private IProductCategoryService productCategoryService;

	public IProductCategoryService getProductCategoryService() {
		return productCategoryService;
	}

	public void setProductCategoryService(
			IProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	

}

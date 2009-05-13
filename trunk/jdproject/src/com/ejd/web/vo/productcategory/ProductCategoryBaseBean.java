package com.ejd.web.vo.productcategory;

import com.ejd.model.service.iface.IProductCategoryService;


public class ProductCategoryBaseBean {
	public IProductCategoryService productCategoryService;

	public IProductCategoryService getProductCategoryService() {
		return productCategoryService;
	}

	public void setProductCategoryService(
			IProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	

}

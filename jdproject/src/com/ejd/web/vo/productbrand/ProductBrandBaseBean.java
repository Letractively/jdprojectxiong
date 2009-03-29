package com.ejd.web.vo.productbrand;

import com.ejd.model.service.iface.IProductBrandService;


public class ProductBrandBaseBean {
	private IProductBrandService productBrandService;

	public IProductBrandService getProductBrandService() {
		return productBrandService;
	}

	public void setProductBrandService(
			IProductBrandService productBrandService) {
		this.productBrandService = productBrandService;
	}
	

}

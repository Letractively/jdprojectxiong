package com.ejd.web.vo.productunit;

import com.ejd.model.service.iface.IProductUnitService;


public class ProductUnitBaseBean {
	public IProductUnitService productUnitService;

	public IProductUnitService getProductUnitService() {
		return productUnitService;
	}

	public void setProductUnitService(
			IProductUnitService productUnitService) {
		this.productUnitService = productUnitService;
	}
	

}

package com.ejd.web.vo.product.base;

import com.ejd.model.service.iface.IProductService;
import com.ejd.model.service.iface.IProductUnitService;
import com.ejd.model.service.iface.IStakeholderService;


public class ProductBaseBean {
	public IStakeholderService stakeholderService;
	
	public IProductUnitService  productUnitService;
	
	public IProductService productService;

	public IStakeholderService getStakeholderService() {
		return stakeholderService;
	}

	public void setStakeholderService(IStakeholderService stakeholderService) {
		this.stakeholderService = stakeholderService;
	}

	public IProductUnitService getProductUnitService() {
		return productUnitService;
	}

	public void setProductUnitService(IProductUnitService productUnitService) {
		this.productUnitService = productUnitService;
	}

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	

}

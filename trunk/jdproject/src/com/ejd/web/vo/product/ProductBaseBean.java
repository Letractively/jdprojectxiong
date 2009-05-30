package com.ejd.web.vo.product;

import com.ejd.model.service.iface.IProductBrandService;
import com.ejd.model.service.iface.IProductCategoryService;
import com.ejd.model.service.iface.IProductService;
import com.ejd.model.service.iface.IProductUnitService;
import com.ejd.model.service.iface.IStakeholderService;


public class ProductBaseBean {
	public IProductBrandService productBrandService;

	public IProductCategoryService productCategoryService;
	
	public IStakeholderService stakeholderService;
	
	public IProductUnitService  productUnitService;
	
	public IProductService productService;
	public IProductBrandService getProductBrandService() {
		return productBrandService;
	}

	public void setProductBrandService(
			IProductBrandService productBrandService) {
		this.productBrandService = productBrandService;
	}

	public IProductCategoryService getProductCategoryService() {
		return productCategoryService;
	}

	public void setProductCategoryService(
			IProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}

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

package com.ejd.web.vo.shopcart;

import com.ejd.model.service.iface.IProductService;

public class ShopCartBaseBean {
	
	public IProductService productService;

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public ShopCartBaseBean() {
		super();
	}
	

}

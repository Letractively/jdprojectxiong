package com.ejd.web.vo.shopcart;

import com.ejd.model.service.iface.ICouponService;
import com.ejd.model.service.iface.IProductService;

public class ShopCartBaseBean {
	
	public IProductService productService;
	
	public ICouponService couponService;

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public ICouponService getCouponService() {
		return couponService;
	}

	public void setCouponService(ICouponService couponService) {
		this.couponService = couponService;
	}

	public ShopCartBaseBean() {
		super();
	}
	

}

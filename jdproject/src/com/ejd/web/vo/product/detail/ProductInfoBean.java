package com.ejd.web.vo.product.detail;

import com.ejd.model.service.iface.IProductService;
import com.ejd.web.vo.product.ProductVo;

public class ProductInfoBean{
	
	public IProductService productService;
	
	public String preViewId;
	
	private ProductVo product;

	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public String getPreViewId() {
		return preViewId;
	}

	public void setPreViewId(String preViewId) {
		this.preViewId = preViewId;
	}

	public ProductVo getProduct() {
		return product;
	}

	public void setProduct(ProductVo product) {
		this.product = product;
	}

	public ProductInfoBean() {
	}
	
}

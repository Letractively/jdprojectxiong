package com.ejd.web.vo.product.detail;

import com.ejd.model.service.iface.IProductService;
import com.ejd.web.vo.product.ProductVo;

public class ProductInfoBean{
	
	public IProductService productService;
	
	public String preViewId;
	
	private ProductVo product;
	
	private String subViewId;
	
	private String goUrlAfterAdd;

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

	public String getSubViewId() {
		return subViewId;
	}

	public void setSubViewId(String subViewId) {
		this.subViewId = subViewId;
	}

	public String getGoUrlAfterAdd() {
		return goUrlAfterAdd;
	}

	public void setGoUrlAfterAdd(String goUrlAfterAdd) {
		this.goUrlAfterAdd = goUrlAfterAdd;
	}

	public ProductInfoBean() {
		this.setGoUrlAfterAdd("none");
	}
	
	public String getPreViewIdString() {
		String result = "home";
		if (null == this.getPreViewId() || "".equals(this.getPreViewId())) {
			
		}
		return result;
	}
	public String getPrimaryCategoryLabel() {
		String result = "";
		if (null != this.getProduct()) {
			if ("01".equals(this.getProduct().getPrimaryCategoryCode())) {
				result = "kitchenAppliance";
			}
			if ("02".equals(this.getProduct().getPrimaryCategoryCode())) {
				result = "householdAppliance";
			}
			if ("03".equals(this.getProduct().getPrimaryCategoryCode())) {
				result = "personalCare";
			}
			if ("04".equals(this.getProduct().getPrimaryCategoryCode())) {
				result = "healthDevice";
			}
			if ("05".equals(this.getProduct().getPrimaryCategoryCode())) {
				result = "majorAppliance";
			}
			if ("06".equals(this.getProduct().getPrimaryCategoryCode())) {
				result = "phoneDigital";
			}
			if ("07".equals(this.getProduct().getPrimaryCategoryCode())) {
				result = "computerNetwork";
			}
		}
		return result;
	}
}

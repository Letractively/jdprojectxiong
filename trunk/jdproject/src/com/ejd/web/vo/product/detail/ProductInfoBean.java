package com.ejd.web.vo.product.detail;

import com.ejd.model.service.iface.IProductService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.product.ProductVo;

public class ProductInfoBean{
	
	public IProductService productService;
	
	public String preViewId;
	
	private ProductVo product;
	
	private String subViewId;
	
	private String goUrlAfterAdd;

	private String preContinueBuyPage; 
	
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

	public String getPreViewIdFromOutCome() {
		String result = "";
		if (null != this.getPreViewId() && !"".equals(this.getPreViewId())) {
			result = "";
			String[] subFromOutCome = this.getPreViewId().split("/");
			String fromOutCome = subFromOutCome[subFromOutCome.length - 1];
			int atPosion = fromOutCome.indexOf(".");
			if (atPosion > 0) {
				result = fromOutCome.substring(0, atPosion);
			}
		}
		return result ;
	}
	
	
	public String getPreContinueBuyPage() {
		return preContinueBuyPage;
	}

	public void setPreContinueBuyPage(String preContinueBuyPage) {
		this.preContinueBuyPage = preContinueBuyPage;
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
	public String goBackByPreViewIdFromOutCome() {
		String result = "";
		String goUrl = (String) SpringFacesUtil.getRequestParameter("goUrl");
		if (null != goUrl && !"".equals(goUrl)) {
			result = goUrl;
		}
		return result;
	}
	public String goContinueBuy() {
		String result = "";
		String goUrl = (String) SpringFacesUtil.getRequestParameter("goContinueUrl");
		if (null != goUrl && !"".equals(goUrl)) {
			result = goUrl;
		}
		return result;
	}
}

package com.ejd.web.vo.product;

import javax.faces.context.FacesContext;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.ProductException;
import com.ejd.model.service.iface.IProductService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Product;
import com.ejd.web.vo.genl.ExistProductPrimaryCategoryBean;
import com.ejd.web.vo.product.detail.ProductInfoBean;
import com.ejd.web.vo.shopcart.InventoryItem;

public class ProductGlobalNavigationBean {
	
	public IProductService productService;
	
	private String currentViewId;
	
	private String code;

	private String id;
	
	public IProductService getProductService() {
		return productService;
	}

	public void setProductService(IProductService productService) {
		this.productService = productService;
	}

	public String getCurrentViewId() {
		return currentViewId;
	}

	public void setCurrentViewId(String currentViewId) {
		this.currentViewId = currentViewId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProductGlobalNavigationBean() {
	}
	
	public String seeProductDetail() throws ProductException {
		
		String nowviewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
		String id =(String) SpringFacesUtil.getRequestParameter("productid");
		Product product =(Product) this.getProductService().getProductById(Integer.valueOf(id).intValue());
		if (null != product) {
			ProductInfoBean productInfoBean = (ProductInfoBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.PRODUCT_INFO_BEAN_NAME);
			productInfoBean.setPreViewId(nowviewId);
			ProductVo productVo = new ProductVo();
			BeanCopier copyBean = BeanCopier.create(Product.class, ProductVo.class, false);
			copyBean.copy(product, productVo, null);
			productInfoBean.setProduct(productVo);
			return "seeProductDetail";
		} else {
			return null;
		}
	}
	

}

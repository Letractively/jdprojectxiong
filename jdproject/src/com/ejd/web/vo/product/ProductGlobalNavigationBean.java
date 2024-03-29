package com.ejd.web.vo.product;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.ProductException;
import com.ejd.model.service.iface.IProductService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Product;
import com.ejd.web.bo.Productunit;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.genl.ExistProductPrimaryCategoryBean;
import com.ejd.web.vo.product.detail.ProductInfoBean;
import com.ejd.web.vo.productunit.ProductUnit;
import com.ejd.web.vo.shopcart.InventoryItem;
import com.ejd.web.vo.stakeholder.StakeholderVo;

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
			Productunit productUnit = product.getUnit();
			ProductUnit newProductUnit = new ProductUnit();
			BeanCopier copyUnitBean = BeanCopier.create(Productunit.class, ProductUnit.class, false);
			copyUnitBean.copy(productUnit, newProductUnit, null);
			Stakeholder stakeholder = product.getProvider();
			StakeholderVo newStakeholderVo = new StakeholderVo();
			BeanCopier copyStakeholderBean = BeanCopier.create(Stakeholder.class, StakeholderVo.class, false);
			copyStakeholderBean.copy(stakeholder, newStakeholderVo, null);
			ProductInfoBean productInfoBean = (ProductInfoBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.PRODUCT_INFO_BEAN_NAME);
			productInfoBean.setPreViewId(nowviewId);
			String continueBuyPage = productInfoBean.getPreViewIdFromOutCome();
			if ((!"shoppingCart".equals(continueBuyPage)) && !"".equals(continueBuyPage)) {
				productInfoBean.setPreContinueBuyPage(continueBuyPage);
			}
			ProductVo productVo = new ProductVo();
			BeanCopier copyBean = BeanCopier.create(Product.class, ProductVo.class, false);
			copyBean.copy(product, productVo, null);
			productVo.setProvider(newStakeholderVo);
			productVo.setUnit(newProductUnit);
			productInfoBean.setProduct(productVo);
			String fileName = productVo.getIntroduceFileName();
			if (this.checkJspExist(fileName)) {
				productInfoBean.setSubViewId(productVo.getIntroduceFileName());
			} else {
				productInfoBean.setSubViewId("noThisPage.jsp");
			}
			return "seeProductDetail";
		} else {
			return null;
		}
	}
	private boolean checkJspExist(String fileName){
		boolean result = false;
		try	{
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = facesContext.getExternalContext();
			Set resourcePaths = externalContext.getResourcePaths("/WEB-INF/jspLayout/subProductDetail");
			Iterator iterator = resourcePaths.iterator(); 
			while (iterator.hasNext()) {
				String path = (String) iterator.next();
				String tempFileName = path.substring(36, path.length());
				if (tempFileName.equals(fileName)) {
					result = true;
					if (result) {
						break;
					}
				}
				System.out.println(path);
			} 
			return result;
		}
		catch(Exception	e){  
			e.printStackTrace();  
	        return   false;  
	    }  
	}     

}

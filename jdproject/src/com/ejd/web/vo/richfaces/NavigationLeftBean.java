package com.ejd.web.vo.richfaces;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistProductGroupBean;
import com.ejd.web.vo.product.phone.ListPhoneProductBean;
import com.ejd.web.vo.productbrand.ProductBrand;
import com.ejd.web.vo.productcategory.ProductCategory;

public class NavigationLeftBean {
	private UIComponent panelBar;
	private String currentBar = "phone";
	public UIComponent getPanelBar() {
		return panelBar;
	}
	public void setPanelBar(UIComponent panelBar) {
		this.panelBar = panelBar;
	}
	public String getCurrentBar() {
		return currentBar;
	}
	public void setCurrentBar(String currentBar) {
		this.currentBar = currentBar;
	}
	
	public NavigationLeftBean() {
		
	}
	public String getPhonePrimaryCategoryName() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getPhoneProductGroup().getPrimaryCategory().getCategoryName();
	}
	public ProductCategory getPhonePrimaryCategory() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getPhoneProductGroup().getPrimaryCategory();
	}
	
	public List<ProductBrand> getPhoneBrands() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getPhoneProductGroup().getBrands();
	}
	
	public List<ProductCategory> getPhoneSecondCategorys() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getPhoneProductGroup().getSecondCategorys();
	}
	
	public String getCameraPrimaryCategoryName() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getCameraProductGroup().getPrimaryCategory().getCategoryName();
	}
	
	public ProductCategory getCameraPrimaryCategory(){
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getCameraProductGroup().getPrimaryCategory();
	}
	public List<ProductBrand> getCameraBrands() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getCameraProductGroup().getBrands();
	}
	
	public List<ProductCategory> getCameraSecondCategorys() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getCameraProductGroup().getSecondCategorys();
	}
	
	public String getTelevisionPrimaryCategoryName() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getTelevisionProductGroup().getPrimaryCategory().getCategoryName();
	}
	public ProductCategory getTelevisionPrimaryCategory() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getTelevisionProductGroup().getPrimaryCategory();
	}
	
	public List<ProductBrand> getTelevisionBrands() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getTelevisionProductGroup().getBrands();
	}
	
	public List<ProductCategory> getTelevisionSecondCategorys() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getTelevisionProductGroup().getSecondCategorys();
	}

	public String clickLink() {
		Object primaryCategoryId = SpringFacesUtil.getRequestParameter("primaryCategoryId");
		Object secondCategoryId = SpringFacesUtil.getRequestParameter("secondCategoryId");
		Object brandId = SpringFacesUtil.getRequestParameter("brandId");
		Object model = SpringFacesUtil.getRequestParameter("model");
		if ("phone".equals(model.toString())) {
			ListPhoneProductBean listPhoneProduct = (ListPhoneProductBean) SpringFacesUtil.getManagedBean("listPhoneProduct");
			listPhoneProduct.setBrandId(null==brandId?null:(new Integer(brandId.toString())));
			listPhoneProduct.setPrimaryCategoryId(null == brandId?null:("".equals(primaryCategoryId)?null:new Integer(primaryCategoryId.toString())));
			listPhoneProduct.setModel(null == model?null:(String)model);
			listPhoneProduct.setSecondCategoryId(null ==secondCategoryId?null:(new Integer("".equals(secondCategoryId)?null:secondCategoryId.toString())));
		}
		//this.setCurrentBar(currentBar);
		return null;
	}
}

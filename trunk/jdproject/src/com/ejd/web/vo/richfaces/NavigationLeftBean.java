package com.ejd.web.vo.richfaces;

import java.util.List;

import javax.faces.component.UIComponent;

import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistProductGroupBean;
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
	public String getPhonePrimaryCategory() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getPhoneProductGroup().getPrimaryCategory().getCategoryName();
	}
	public List<ProductBrand> getPhoneBrands() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getPhoneProductGroup().getBrands();
	}
	
	public List<ProductCategory> getPhoneSecondCategorys() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getPhoneProductGroup().getSecondCategorys();
	}
	
	public String getCameraPrimaryCategory() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getCameraProductGroup().getPrimaryCategory().getCategoryName();
	}
	public List<ProductBrand> getCameraBrands() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getCameraProductGroup().getBrands();
	}
	
	public List<ProductCategory> getCameraSecondCategorys() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getCameraProductGroup().getSecondCategorys();
	}
	
	public String getTelevisionPrimaryCategory() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getTelevisionProductGroup().getPrimaryCategory().getCategoryName();
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
		String currentBar =(String) SpringFacesUtil.getRequestMapValue("currentBar");
		//this.setCurrentBar(currentBar);
		return null;
	}
}

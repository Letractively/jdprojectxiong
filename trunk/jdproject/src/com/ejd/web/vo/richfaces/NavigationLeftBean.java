package com.ejd.web.vo.richfaces;

import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistProductGroupBean;
import com.ejd.web.vo.product.ListProductBean;
import com.ejd.web.vo.product.ProductPrice;
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
	
	public List<ProductPrice> getPhonePrices() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getPhoneProductGroup().getPrices();
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
	
	public List<ProductPrice> getCameraPrices() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getCameraProductGroup().getPrices();
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
	public List<ProductPrice> getTelevisionPrices() {
		ExistProductGroupBean existProductGroup = (ExistProductGroupBean)SpringFacesUtil.getManagedBean("existProductGroup");
		return existProductGroup.getTelevisionProductGroup().getPrices();
	}

	public String clickLink() {
		
		Object primaryCategoryId = SpringFacesUtil.getRequestParameter("primaryCategoryId");
		Object secondCategoryId = SpringFacesUtil.getRequestParameter("secondCategoryId");
		Object brandId = SpringFacesUtil.getRequestParameter("brandId");
		Object model = SpringFacesUtil.getRequestParameter("model");
		Object minPrice = SpringFacesUtil.getRequestParameter("minPrice");
		Object maxPrice = SpringFacesUtil.getRequestParameter("maxPrice");
		if ("phone".equals(model.toString())) {
			ProductPrice priceRange = null;
			ListProductBean listPhoneProduct = (ListProductBean) SpringFacesUtil.getManagedBean("listPhoneProduct");
			listPhoneProduct.setBrandId(null);
			listPhoneProduct.setPrimaryCategoryId(null);
			listPhoneProduct.setModel(null);
			listPhoneProduct.setSecondCategoryId(null);
			listPhoneProduct.setPriceRange(null);
			priceRange = new ProductPrice();
			priceRange.setMinPrice(null == minPrice?null:("".equals(minPrice)?null:new Double(minPrice.toString())));
			priceRange.setMaxPrice(null == maxPrice?null:("".equals(maxPrice)?null:new Double(maxPrice.toString())));
			listPhoneProduct.setPriceRange(priceRange);
			listPhoneProduct.setBrandId(null==brandId?null:(new Integer(brandId.toString())));
			listPhoneProduct.setPrimaryCategoryId(null == primaryCategoryId?null:("".equals(primaryCategoryId)?null:new Integer(primaryCategoryId.toString())));
			listPhoneProduct.setModel(null == model?null:(String)model);
			listPhoneProduct.setSecondCategoryId(null ==secondCategoryId?null:(new Integer("".equals(secondCategoryId)?null:secondCategoryId.toString())));
		}
		if ("camera".equals(model.toString())) {
			ProductPrice priceRange = null;
			ListProductBean listCameraProduct = (ListProductBean) SpringFacesUtil.getManagedBean("listCameraProduct");
			listCameraProduct.setBrandId(null);
			listCameraProduct.setPrimaryCategoryId(null);
			listCameraProduct.setModel(null);
			listCameraProduct.setSecondCategoryId(null);
			listCameraProduct.setPriceRange(null);
			priceRange = new ProductPrice();
			priceRange.setMinPrice(null == minPrice?null:("".equals(minPrice)?null:new Double(minPrice.toString())));
			priceRange.setMaxPrice(null == maxPrice?null:("".equals(maxPrice)?null:new Double(maxPrice.toString())));
			listCameraProduct.setPriceRange(priceRange);
			listCameraProduct.setBrandId(null==brandId?null:(new Integer(brandId.toString())));
			listCameraProduct.setPrimaryCategoryId(null == primaryCategoryId?null:("".equals(primaryCategoryId)?null:new Integer(primaryCategoryId.toString())));
			listCameraProduct.setModel(null == model?null:(String)model);
			listCameraProduct.setSecondCategoryId(null ==secondCategoryId?null:(new Integer("".equals(secondCategoryId)?null:secondCategoryId.toString())));
		}
		if ("television".equals(model.toString())) {
			ProductPrice priceRange = null;
			ListProductBean listTelevisionProduct = (ListProductBean) SpringFacesUtil.getManagedBean("listTelevisionProduct");
			listTelevisionProduct.setBrandId(null);
			listTelevisionProduct.setPrimaryCategoryId(null);
			listTelevisionProduct.setModel(null);
			listTelevisionProduct.setSecondCategoryId(null);
			listTelevisionProduct.setPriceRange(null);
			priceRange = new ProductPrice();
			priceRange.setMinPrice(null == minPrice?null:("".equals(minPrice)?null:new Double(minPrice.toString())));
			priceRange.setMaxPrice(null == maxPrice?null:("".equals(maxPrice)?null:new Double(maxPrice.toString())));
			listTelevisionProduct.setPriceRange(priceRange);
			listTelevisionProduct.setBrandId(null==brandId?null:(new Integer(brandId.toString())));
			listTelevisionProduct.setPrimaryCategoryId(null == primaryCategoryId?null:("".equals(primaryCategoryId)?null:new Integer(primaryCategoryId.toString())));
			listTelevisionProduct.setModel(null == model?null:(String)model);
			listTelevisionProduct.setSecondCategoryId(null ==secondCategoryId?null:(new Integer("".equals(secondCategoryId)?null:secondCategoryId.toString())));
		}
		//this.setCurrentBar(currentBar);
		return null;
	}
}

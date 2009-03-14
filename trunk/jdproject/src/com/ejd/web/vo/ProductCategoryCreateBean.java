package com.ejd.web.vo;

import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.ejd.model.exception.ProductCategoryException;
import com.ejd.model.service.iface.IProductCategoryService;
import com.ejd.web.bo.Productcategory;
import com.ejd.web.vo.productcategory.ProductCategory;

public class ProductCategoryCreateBean extends ProductCategoryBaseBean {
	
	//this is for create new productCategory start
	private String newProgressString="请填写以下信息";
	private ProductCategory newProductCategory =  new ProductCategory(); 
	
	//this is for create new productCategory end
	public ProductCategoryCreateBean() {
		init();
	}
	protected void init() {
		ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IProductCategoryService em = (IProductCategoryService) appctx.getBean("productCategoryService");
		this.setProductCategoryService(em);
	}
	public String getNewProgressString() {
		return newProgressString;
	}
	public void setNewProgressString(String newProgressString) {
		this.newProgressString = newProgressString;
	}
	public ProductCategory getNewProductCategory() {
		return newProductCategory;
	}
	public void setNewProductCategory(ProductCategory newProductCategory) {
		this.newProductCategory = newProductCategory;
	}
	public void createProductCategory() throws ProductCategoryException{
		if (this.getProductCategoryService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductCategoryService em = (IProductCategoryService) appctx.getBean("productCategoryService");
			this.setProductCategoryService(em);
		}
		Productcategory productCategory =(Productcategory) this.getProductCategoryService().getProductCategoryByName(newProductCategory.getCategoryName());
		
		if (productCategory != null) {
			setNewProgressString(newProductCategory.getCategoryName()+" 已存在！");
		} else {
			Productcategory creProductCategory = new Productcategory();
			creProductCategory.setCategoryName(newProductCategory.getCategoryName());
			creProductCategory.setSerialNumber(newProductCategory.getSerialNumber());
			this.getProductCategoryService().addProductCategory(creProductCategory);
			setNewProgressString(newProductCategory.getCategoryName()+" 保存成功!");
		}
    }
}

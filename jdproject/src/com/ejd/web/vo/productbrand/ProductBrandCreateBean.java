package com.ejd.web.vo.productbrand;

import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.ejd.model.exception.ProductBrandException;
import com.ejd.model.service.iface.IProductBrandService;
import com.ejd.web.bo.Productbrand;
import com.ejd.web.vo.productbrand.ProductBrand;

public class ProductBrandCreateBean extends ProductBrandBaseBean {
	
	//this is for create new productBrand start
	private String newProgressString="";
	private ProductBrand newProductBrand =  new ProductBrand(); 
	
	//this is for create new productBrand end
	public ProductBrandCreateBean() {
		//init();
	}
	protected void init() {
		ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IProductBrandService em = (IProductBrandService) appctx.getBean("productBrandService");
		this.setProductBrandService(em);
	}
	public String getNewProgressString() {
		return newProgressString;
	}
	public void setNewProgressString(String newProgressString) {
		this.newProgressString = newProgressString;
	}
	public ProductBrand getNewProductBrand() {
		return newProductBrand;
	}
	public void setNewProductBrand(ProductBrand newProductBrand) {
		this.newProductBrand = newProductBrand;
	}
	public void createProductBrand() throws ProductBrandException {
		if (this.getProductBrandService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductBrandService em = (IProductBrandService) appctx.getBean("productBrandService");
			this.setProductBrandService(em);
		}
		Productbrand productBrand =(Productbrand) this.getProductBrandService().getProductBrandByName(newProductBrand.getBrandName());
		
		if (productBrand != null) {
			setNewProgressString(newProductBrand.getBrandName()+" ");
		} else {
			Productbrand creProductBrand = new Productbrand();
			creProductBrand.setBrandName(newProductBrand.getBrandName());
			creProductBrand.setSerialNumber(newProductBrand.getSerialNumber());
			this.getProductBrandService().addProductBrand(creProductBrand);
			setNewProgressString(newProductBrand.getBrandName()+"");
		}
    }
}


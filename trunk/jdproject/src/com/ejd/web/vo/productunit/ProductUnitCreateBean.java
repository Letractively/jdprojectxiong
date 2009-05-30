package com.ejd.web.vo.productunit;

import javax.faces.context.FacesContext;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.ejd.model.exception.ProductUnitException;
import com.ejd.model.service.iface.IProductUnitService;
import com.ejd.web.bo.Productunit;

public class ProductUnitCreateBean extends ProductUnitBaseBean {
	
	//this is for create new productUnit start
	private String newProgressString="";
	private ProductUnit newProductUnit =  new ProductUnit(); 
	
	//this is for create new productUnit end
	public ProductUnitCreateBean() {
		//init();
	}
	protected void init() {
		ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IProductUnitService em = (IProductUnitService) appctx.getBean("productUnitService");
		this.setProductUnitService(em);
	}
	public String getNewProgressString() {
		return newProgressString;
	}
	public void setNewProgressString(String newProgressString) {
		this.newProgressString = newProgressString;
	}
	public ProductUnit getNewProductUnit() {
		return newProductUnit;
	}
	public void setNewProductUnit(ProductUnit newProductUnit) {
		this.newProductUnit = newProductUnit;
	}
	public void createProductUnit() throws ProductUnitException {
		if (this.getProductUnitService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductUnitService em = (IProductUnitService) appctx.getBean("productUnitService");
			this.setProductUnitService(em);
		}
		Productunit productUnit =(Productunit) this.getProductUnitService().getProductUnitByName(newProductUnit.getUnitName());
		
		if (productUnit != null) {
			setNewProgressString(newProductUnit.getUnitName()+" ");
		} else {
			Productunit creProductUnit = new Productunit();
			creProductUnit.setUnitName(newProductUnit.getUnitName());
			creProductUnit.setSerialNumber(newProductUnit.getSerialNumber());
			this.getProductUnitService().addProductUnit(creProductUnit);
			setNewProgressString(newProductUnit.getUnitName()+"");
		}
    }
}


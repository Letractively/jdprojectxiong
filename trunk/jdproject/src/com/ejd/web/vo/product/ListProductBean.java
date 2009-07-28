package com.ejd.web.vo.product;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ejd.common.datapage.DataPage;
import com.ejd.common.datapage.PagedBaseBean;
import com.ejd.common.datapage.PagedListDataModel;
import com.ejd.model.exception.ProductException;
import com.ejd.model.service.iface.IProductService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Product;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.product.ProductPrice;

public class ListProductBean extends PagedBaseBean {
	public IProductService productService;
	public String currentTitleOne;
	public String currentTitleTwo;
	public String model;
	// these is for search property
	private Integer primaryCategoryId;
	private Integer secondCategoryId;
	private Integer brandId;
	private ProductPrice priceRange;
	private DataModel dataModel;
	private int scrollerPage;
	public ListProductBean() {
		super();
	}
	public int getTotalCount() {
		int totalCount = 0;
		List alist= new ArrayList();
		try {
		alist = this.getProductService().getProductByCriteria(primaryCategoryId, secondCategoryId, brandId, priceRange);
		} catch (ProductException e) {
			e.printStackTrace();
		}
		totalCount = alist.size();
		return totalCount;
		
	}
	public DataPage<Product> getDataPage(int startRow, int pageSize) {
		DataPage<Product> dataPage = null;
		try {
		dataPage = new DataPage<Product>(getTotalCount(), startRow,this.getProductService().getProductByCriteria(primaryCategoryId, secondCategoryId, brandId, priceRange));
		} catch (ProductException e) {
			e.printStackTrace();
		}
		return dataPage;
	}
	public DataModel getDataModel(){
		   if (dataModel == null) {
		     dataModel = new PagedListDataModel<Product>(18) {
		     public DataPage<Product> fetchPage(int startRow, int pageSize) {
		      return getDataPage(startRow, pageSize);
		     }
		    };
		    
		    } 
		   return dataModel;
		}
	public IProductService getProductService() {
		return productService;
	}
	public void setProductService(IProductService productService) {
		this.productService = productService;
	}
	public String getCurrentTitleOne() {
		return currentTitleOne;
	}
	public void setCurrentTitleOne(String currentTitleOne) {
		this.currentTitleOne = currentTitleOne;
	}
	public String getCurrentTitleTwo() {
		return currentTitleTwo;
	}
	public void setCurrentTitleTwo(String currentTitleTwo) {
		this.currentTitleTwo = currentTitleTwo;
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public Integer getPrimaryCategoryId() {
		return primaryCategoryId;
	}
	public void setPrimaryCategoryId(Integer primaryCategoryId) {
		this.primaryCategoryId = primaryCategoryId;
	}
	public Integer getSecondCategoryId() {
		return secondCategoryId;
	}
	public void setSecondCategoryId(Integer secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public ProductPrice getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(ProductPrice priceRange) {
		this.priceRange = priceRange;
	}
	
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}
	public int getScrollerPage() {
		return scrollerPage;
	}
	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}
	

}

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
import com.ejd.web.vo.product.base.RangeParam;

public class ListProductBean extends PagedBaseBean {
	public IProductService productService;
	public String currentTitleOne;
	public String currentTitleTwo;
	public String model;
	// these is for search property
	private String primaryCategoryCode;
	private String secondCategoryCode;
	private String brandCode;
	private RangeParam priceRange;
	private DataModel dataModel;
	private int scrollerPage;
	private String styleFont;
	private boolean styleFontFlag;
	private String styleImg;
	private boolean styleImgFla;
	private String styleImgFont;
	private boolean styleImgFontFlag;
	public ListProductBean() {
		super();
		this.styleImgFont = "";
		this.styleFont = "";
		this.styleImg = "_on";
	}
	public int getTotalCount() {
		int totalCount = 0;
		List alist= new ArrayList();
		try {
		alist = this.getProductService().getPSBPProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange);
		} catch (ProductException e) {
			e.printStackTrace();
		}
		totalCount = alist.size();
		return totalCount;
		
	}
	public DataPage<Product> getDataPage(int startRow, int pageSize) {
		DataPage<Product> dataPage = null;
		try {
		dataPage = new DataPage<Product>(getTotalCount(), startRow,this.getProductService().getPSBPProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange));
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
	
	
	public String getPrimaryCategoryCode() {
		return primaryCategoryCode;
	}
	public void setPrimaryCategoryCode(String primaryCategoryCode) {
		this.primaryCategoryCode = primaryCategoryCode;
	}
	public String getSecondCategoryCode() {
		return secondCategoryCode;
	}
	public void setSecondCategoryCode(String secondCategoryCode) {
		this.secondCategoryCode = secondCategoryCode;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public RangeParam getPriceRange() {
		return priceRange;
	}
	public void setPriceRange(RangeParam priceRange) {
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
	public String getStyleFont() {
		return styleFont;
	}
	public void setStyleFont(String font) {
		styleFont = font;
	}
	public boolean getStyleFontFlag() {
		boolean result = false;
		if (null == this.getStyleFont() || "".equals(this.getStyleFont()) || !"_on".equals(this.getStyleFont())) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
	public String getStyleImg() {
		return styleImg;
	}
	public void setStyleImg(String img) {
		styleImg = img;
	}
	public boolean getStyleImgFlag() {
		boolean result = false;
		if (null == this.getStyleImg() || "".equals(this.getStyleImg()) || !"_on".equals(this.getStyleImg())) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
	public String getStyleImgFont() {
		return styleImgFont;
	}
	public void setStyleImgFont(String imgFont) {
		styleImgFont = imgFont;
	}
	public boolean getStyleImgFontFlag() {
		boolean result = false;
		if (null == this.getStyleImgFont() || "".equals(this.getStyleImgFont()) || !"_on".equals(this.getStyleImgFont())) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}

}

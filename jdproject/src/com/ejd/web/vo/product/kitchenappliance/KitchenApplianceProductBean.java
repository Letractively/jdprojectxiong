package com.ejd.web.vo.product.kitchenappliance;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;

import net.sf.cglib.beans.BeanCopier;

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
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.shopcart.InventoryItem;
import com.ejd.web.vo.shopcart.ShopCartBean;

public class KitchenApplianceProductBean extends PagedBaseBean {
	public IProductService productService;
	public String currentTitleOne;
	public String currentTitleTwo;
	public String model;
	public String productType;
	//start for search property
	private String primaryCategoryCode;
	private String secondCategoryCode;
	private String secondCategoryLabel;
	private String brandCode;
	private String brandLabel;
	private RangeParam priceRange;
	//end for search property
	private DataModel dataModel;
	
	private int scrollerPage;
	private String styleFont;
	private boolean styleFontFlag;
	private String styleImg;
	private boolean styleImgFla;
	private String styleImgFont;
	private boolean styleImgFontFlag;
	private String number10;
	private String number20;
	private String number40;
	private String number100;
	private int numberOnePage;
	private int oldNumberOnePage;
	public KitchenApplianceProductBean() {
		super();
		this.secondCategoryLabel = "全部";
		this.brandLabel = "全部";
		this.styleImgFont = "";
		this.styleFont = "";
		this.styleImg = "_on";
		this.number10 = "_on";
		this.number20 = "";
		this.number40 = "";
		this.number100 = "";
		this.numberOnePage = 15;
		this.oldNumberOnePage = 15;
		this.primaryCategoryCode = HeaderConstants.KITCHEN_APPLIANCE_ID;
		this.setBrandCode("");
		this.setProductType(HeaderConstants.KITCHEN_APPLIANCE_NAME);
	}
	public int getTotalCount() {
		int totalCount = 0;
		List alist= new ArrayList();
		try {
			if (HeaderConstants.KITCHEN_APPLIANCE_NAME.equals(productType)) {
				alist = this.getProductService().getPSBPProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange);
			}
		} catch (ProductException e) {
			e.printStackTrace();
		}
		totalCount = alist.size();
		return totalCount;
		
	}
	public DataPage<Product> getDataPage(int startRow, int pageSize) {
		DataPage<Product> dataPage = null;
		try {
			if (HeaderConstants.KITCHEN_APPLIANCE_NAME.equals(productType)) {
				dataPage = new DataPage<Product>(getTotalCount(), startRow,this.getProductService().getPSBPProductByCriteria(primaryCategoryCode, secondCategoryCode, brandCode, priceRange));
			}
		} catch (ProductException e) {
			e.printStackTrace();
		}
		return dataPage;
	}
	public DataModel getDataModel(){
		   if (dataModel == null || (this.getOldNumberOnePage() != this.getNumberOnePage())) {
		     dataModel = new PagedListDataModel<Product>(this.getNumberOnePage()) {
		     public DataPage<Product> fetchPage(int startRow, int pageSize) {
		      return getDataPage(startRow, pageSize);
		     }
		    };
		    this.setOldNumberOnePage(this.getNumberOnePage());
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
	
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
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
	
	public String getSecondCategoryLabel() {
		return secondCategoryLabel;
	}
	public void setSecondCategoryLabel(String secondCategoryLabel) {
		this.secondCategoryLabel = secondCategoryLabel;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	
	public String getBrandLabel() {
		return brandLabel;
	}
	public void setBrandLabel(String brandLabel) {
		this.brandLabel = brandLabel;
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
	
	public String getNumber10() {
		return number10;
	}
	public void setNumber10(String number10) {
		this.number10 = number10;
	}
	public String getNumber20() {
		return number20;
	}
	public void setNumber20(String number20) {
		this.number20 = number20;
	}
	public String getNumber40() {
		return number40;
	}
	public void setNumber40(String number40) {
		this.number40 = number40;
	}
	public String getNumber100() {
		return number100;
	}
	public void setNumber100(String number100) {
		this.number100 = number100;
	}
	public int getNumberOnePage() {
		return numberOnePage;
	}
	public void setNumberOnePage(int numberOnePage) {
		this.numberOnePage = numberOnePage;
	}
	
	public int getOldNumberOnePage() {
		return oldNumberOnePage;
	}
	public void setOldNumberOnePage(int oldNumberOnePage) {
		this.oldNumberOnePage = oldNumberOnePage;
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

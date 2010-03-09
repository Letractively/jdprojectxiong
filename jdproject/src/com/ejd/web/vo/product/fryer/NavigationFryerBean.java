package com.ejd.web.vo.product.fryer;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceFryerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationFryerBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	

	public NavigationFryerBean () {
		ExistKitchenApplianceFryerProductBrandBean existKitchenApplianceFryerProductBrand = (ExistKitchenApplianceFryerProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_FRYER_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceFryerProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(199),"<=199"));
		tempPriceRange.add(new RangeParam(new Double(199),new Double(499),"199-499"));
		tempPriceRange.add(new RangeParam(new Double(499),new Double(799),"499-799"));
		tempPriceRange.add(new RangeParam(new Double(799),new Double(999),"799-999"));
		tempPriceRange.add(new RangeParam(new Double(999),null,">=999"));
		this.setPriceRangeList(tempPriceRange);
	}
	
public List<RangeParam> getPriceRangeList() {
		return priceRangeList;
	}

	public void setPriceRangeList(List<RangeParam> priceRangeList) {
		this.priceRangeList = priceRangeList;
	}

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public void setBrandCodeItems(SelectItem[] brandCodeItems) {
		this.brandCodeItems = brandCodeItems;
	}

public String clickLink() {
		
		Object brandCode = SpringFacesUtil.getRequestParameter("brandCode");
		Object brandLabel = SpringFacesUtil.getRequestParameter("brandLabel");
		Object priceRangeMin = SpringFacesUtil.getRequestParameter("priceRangeMin");
		Object priceRangeMax = SpringFacesUtil.getRequestParameter("priceRangeMax");
		Object priceRangeLabel = SpringFacesUtil.getRequestParameter("priceRangeLabel");
		FryerProductBean listFryerProduct = (FryerProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_FRYER_PRODUCT_BEAN_NAME);
		listFryerProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listFryerProduct.setPriceRange(priceRange);
			listFryerProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		if (null != brandCode) {
			listFryerProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listFryerProduct.setBrandLabel((String)brandLabel);
		}
		return null;
	}

}

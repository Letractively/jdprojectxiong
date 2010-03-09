package com.ejd.web.vo.product.meatchopper;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceCuisineMachineProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceFryerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceMeatChopperProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceSaucepanProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationMeatChopperBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	

	public NavigationMeatChopperBean () {
		ExistKitchenApplianceMeatChopperProductBrandBean existKitchenApplianceMeatChopperProductBrand = (ExistKitchenApplianceMeatChopperProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_MEAT_CHOPPER_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceMeatChopperProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(199.9),"0-199.9"));
		tempPriceRange.add(new RangeParam(new Double(200),new Double(399),"200-499.9"));
		tempPriceRange.add(new RangeParam(new Double(500),null,">=500"));
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
		MeatChopperProductBean listMeatChopperProduct = (MeatChopperProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_MEAT_CHOPPER_PRODUCT_BEAN_NAME);
		listMeatChopperProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listMeatChopperProduct.setPriceRange(priceRange);
			listMeatChopperProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		if (null != brandCode) {
			listMeatChopperProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listMeatChopperProduct.setBrandLabel((String)brandLabel);
		}
		return null;
	}

}

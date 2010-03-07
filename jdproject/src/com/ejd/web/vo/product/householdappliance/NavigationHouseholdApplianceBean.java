package com.ejd.web.vo.product.householdappliance;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.householdappliance.ExistHouseholdApplianceProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceProductBrandBean;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationHouseholdApplianceBean {
	
	public SelectItem[] getBrandCodeItems() {
		ExistHouseholdApplianceProductBrandBean existHouseholdApplianceProductBrand = (ExistHouseholdApplianceProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_HOUSEHOLD_APPLIANCE_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existHouseholdApplianceProductBrand.getBrandCodeItems();
		return result;
	}

	public List<MenuItem> getSecondCategoryCodeList() {
		HeaderTabPanelBean headerTabPanel = (HeaderTabPanelBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.HEADER_TABPANEL_BEAN_NAME);
		List<MenuItem> result = new ArrayList<MenuItem>();
		result =  headerTabPanel.getHouseholdAppliance().getSubMenu();
		return result;
	}
	public NavigationHouseholdApplianceBean () {
		
	}
public String clickLink() {
		
		Object secondCategoryCode = SpringFacesUtil.getRequestParameter("secondCategoryCode");
		Object brandCode = SpringFacesUtil.getRequestParameter("brandCode");
		Object secondCategoryLabel = SpringFacesUtil.getRequestParameter("secondCategoryLabel");
		Object brandLabel = SpringFacesUtil.getRequestParameter("brandLabel");
		//Object model = SpringFacesUtil.getRequestParameter("model");
		//Object minPrice = SpringFacesUtil.getRequestParameter("minPrice");
		//Object maxPrice = SpringFacesUtil.getRequestParameter("maxPrice");
		
		//ProductPrice priceRange = null;
		HouseholdApplianceProductBean listHouseholdApplianceProduct = (HouseholdApplianceProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_HOUSEHOLD_APPLIANCE_PRODUCT_BEAN_NAME);
		listHouseholdApplianceProduct.setDataModel(null);
		//listKitchenApplianceProduct.setBrandCode(null);
		//listKitchenApplianceProduct.setSecondCategoryCode(null);
		//listPhoneProduct.setPriceRange(null);
		/*priceRange = new ProductPrice();
		priceRange.setMinPrice(null == minPrice?null:("".equals(minPrice)?null:new Double(minPrice.toString())));
		priceRange.setMaxPrice(null == maxPrice?null:("".equals(maxPrice)?null:new Double(maxPrice.toString())));
		listPhoneProduct.setPriceRange(priceRange);*/
		if (null != brandCode) {
			listHouseholdApplianceProduct.setBrandCode((String)brandCode);
		}
		if (null != secondCategoryCode) {
			listHouseholdApplianceProduct.setSecondCategoryCode((String)secondCategoryCode);
		}
		if (null != brandLabel) {
			listHouseholdApplianceProduct.setBrandLabel((String)brandLabel);
		}
		if (null != secondCategoryLabel) {
			listHouseholdApplianceProduct.setSecondCategoryLabel((String)secondCategoryLabel);
		}
		return null;
	}

}

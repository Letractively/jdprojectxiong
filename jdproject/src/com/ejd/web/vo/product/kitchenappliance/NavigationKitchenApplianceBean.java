package com.ejd.web.vo.product.kitchenappliance;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistKitchenApplianceProductBrandBean;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationKitchenApplianceBean {
	
	public SelectItem[] getBrandCodeItems() {
		ExistKitchenApplianceProductBrandBean existKitchenApplianceProductBrand = (ExistKitchenApplianceProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceProductBrand.getBrandCodeItems();
		return result;
	}

	public List<MenuItem> getSecondCategoryCodeList() {
		HeaderTabPanelBean headerTabPanel = (HeaderTabPanelBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.HEADER_TABPANEL_BEAN_NAME);
		List<MenuItem> result = new ArrayList<MenuItem>();
		result =  headerTabPanel.getKitchenAppliance().getSubMenu();
		return result;
	}
	public NavigationKitchenApplianceBean () {
		
	}
public String clickLink() {
		
		Object secondCategoryCode = SpringFacesUtil.getRequestParameter("secondCategoryCode");
		Object brandCode = SpringFacesUtil.getRequestParameter("brandCode");
		//Object model = SpringFacesUtil.getRequestParameter("model");
		//Object minPrice = SpringFacesUtil.getRequestParameter("minPrice");
		//Object maxPrice = SpringFacesUtil.getRequestParameter("maxPrice");
		
		//ProductPrice priceRange = null;
		KitchenApplianceProductBean listKitchenApplianceProduct = (KitchenApplianceProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_KITCHEN_APPLIANCE_PRODUCT_BEAN_NAME);
		listKitchenApplianceProduct.setDataModel(null);
		//listKitchenApplianceProduct.setBrandCode(null);
		//listKitchenApplianceProduct.setSecondCategoryCode(null);
		//listPhoneProduct.setPriceRange(null);
		/*priceRange = new ProductPrice();
		priceRange.setMinPrice(null == minPrice?null:("".equals(minPrice)?null:new Double(minPrice.toString())));
		priceRange.setMaxPrice(null == maxPrice?null:("".equals(maxPrice)?null:new Double(maxPrice.toString())));
		listPhoneProduct.setPriceRange(priceRange);*/
		if (null != brandCode) {
			listKitchenApplianceProduct.setBrandCode((String)brandCode);
		}
		if (null != secondCategoryCode) {
			listKitchenApplianceProduct.setSecondCategoryCode((String)secondCategoryCode);
		}
		return null;
	}

}

package com.ejd.web.vo.genl.householdappliance;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistHouseholdApplianceElectricKettleProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_MIDEA_LABEL.toString(),EjdConstants.BRAND_MIDEA_LABEL),
		new SelectItem(EjdConstants.BRAND_GREE_NAME.toString(),EjdConstants.BRAND_GREE_LABEL),
		new SelectItem(EjdConstants.BRAND_PHILIPS_NAME.toString(),EjdConstants.BRAND_PHILIPS_LABEL),
		new SelectItem(EjdConstants.BRAND_GALANZ_NAME.toString(),EjdConstants.BRAND_GALANZ_LABEL),
		new SelectItem(EjdConstants.BRAND_DONLIM_NAME.toString(),EjdConstants.BRAND_DONLIM_LABEL),
		new SelectItem(EjdConstants.BRAND_ACA_NAME.toString(),EjdConstants.BRAND_ACA_LABEL),
		new SelectItem(EjdConstants.BRAND_TEFAL_NAME.toString(),EjdConstants.BRAND_TEFAL_LABEL),
		new SelectItem(EjdConstants.BRAND_JOYOUNG_NAME.toString(),EjdConstants.BRAND_JOYOUNG_LABEL),
		new SelectItem(EjdConstants.BRAND_TIGER_NAME.toString(),EjdConstants.BRAND_TIGER_LABEL),
		new SelectItem(EjdConstants.BRAND_DELONGHI_NAME.toString(),EjdConstants.BRAND_DELONGHI_LABEL),
		new SelectItem(EjdConstants.BRAND_WIK_NAME.toString(),EjdConstants.BRAND_WIK_LABEL),
		new SelectItem(EjdConstants.BRAND_ELECTROLUX_NAME.toString(),EjdConstants.BRAND_ELECTROLUX_LABEL),
		new SelectItem(EjdConstants.BRAND_DEERDQ_NAME.toString(),EjdConstants.BRAND_DEERDQ_LABEL),
		new SelectItem(EjdConstants.BRAND_5E_NAME.toString(),EjdConstants.BRAND_5E_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistHouseholdApplianceElectricKettleProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistHouseholdApplianceElectricKettleProductBrandBean() {
		
	}

}

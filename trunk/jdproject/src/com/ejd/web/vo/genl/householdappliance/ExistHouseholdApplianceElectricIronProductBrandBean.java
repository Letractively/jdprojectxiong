package com.ejd.web.vo.genl.householdappliance;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistHouseholdApplianceElectricIronProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_PANASONIC_NAME.toString(),EjdConstants.BRAND_PANASONIC_LABEL),
		new SelectItem(EjdConstants.BRAND_PHILIPS_NAME.toString(),EjdConstants.BRAND_PHILIPS_LABEL),
		new SelectItem(EjdConstants.BRAND_DONLIM_NAME.toString(),EjdConstants.BRAND_DONLIM_LABEL),
		new SelectItem(EjdConstants.BRAND_FLYCO_NAME.toString(),EjdConstants.BRAND_FLYCO_LABEL),
		new SelectItem(EjdConstants.BRAND_SID_NAME.toString(),EjdConstants.BRAND_SID_LABEL),
		new SelectItem(EjdConstants.BRAND_TEFAL_NAME.toString(),EjdConstants.BRAND_TEFAL_LABEL),
		new SelectItem(EjdConstants.BRAND_TSANNKUEN_NAME.toString(),EjdConstants.BRAND_TSANNKUEN_LABEL),
		new SelectItem(EjdConstants.BRAND_DELONGHI_NAME.toString(),EjdConstants.BRAND_DELONGHI_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistHouseholdApplianceElectricIronProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistHouseholdApplianceElectricIronProductBrandBean() {
		
	}

}

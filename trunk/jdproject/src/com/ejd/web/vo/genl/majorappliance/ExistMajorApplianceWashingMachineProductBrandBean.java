package com.ejd.web.vo.genl.majorappliance;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistMajorApplianceWashingMachineProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_HIVOX_NAME.toString(),EjdConstants.BRAND_HIVOX_LABEL),
		new SelectItem(EjdConstants.BRAND_PHILIPS_NAME.toString(),EjdConstants.BRAND_PHILIPS_LABEL),
		new SelectItem(EjdConstants.BRAND_OSRAM_NAME.toString(),EjdConstants.BRAND_OSRAM_LABEL),
		new SelectItem(EjdConstants.BRAND_MKD_NAME.toString(),EjdConstants.BRAND_MKD_LABEL),
		new SelectItem(EjdConstants.BRAND_PANASONIC_NAME.toString(),EjdConstants.BRAND_PANASONIC_LABEL),
		new SelectItem(EjdConstants.BRAND_WIK_NAME.toString(),EjdConstants.BRAND_WIK_LABEL),
		new SelectItem(EjdConstants.BRAND_ZOFU_NAME.toString(),EjdConstants.BRAND_ZOFU_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistMajorApplianceWashingMachineProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistMajorApplianceWashingMachineProductBrandBean() {
		
	}

}

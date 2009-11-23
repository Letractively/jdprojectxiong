package com.ejd.web.vo.genl.personalcare;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistPersonalCareShowerLampProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_PANASONIC_NAME.toString(),EjdConstants.BRAND_PANASONIC_LABEL),
		new SelectItem(EjdConstants.BRAND_PHILIPS_NAME.toString(),EjdConstants.BRAND_PHILIPS_LABEL),
		new SelectItem(EjdConstants.BRAND_FLYCO_NAME.toString(),EjdConstants.BRAND_FLYCO_LABEL),
		new SelectItem(EjdConstants.BRAND_SID_NAME.toString(),EjdConstants.BRAND_SID_LABEL),
		new SelectItem(EjdConstants.BRAND_POVOS_NAME.toString(),EjdConstants.BRAND_POVOS_LABEL),
		new SelectItem(EjdConstants.BRAND_WIK_NAME.toString(),EjdConstants.BRAND_WIK_LABEL),
		new SelectItem(EjdConstants.BRAND_AUPU_NAME.toString(),EjdConstants.BRAND_AUPU_LABEL),
		new SelectItem(EjdConstants.BRAND_MAXCARE_NAME.toString(),EjdConstants.BRAND_MAXCARE_LABEL),
		new SelectItem(EjdConstants.BRAND_DLG_NAME.toString(),EjdConstants.BRAND_DLG_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistPersonalCareShowerLampProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistPersonalCareShowerLampProductBrandBean() {
		
	}

}

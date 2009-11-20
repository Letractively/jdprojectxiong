package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceGasStoveProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_MIDEA_LABEL.toString(),EjdConstants.BRAND_MIDEA_LABEL),
		new SelectItem(EjdConstants.BRAND_ROBAM_NAME.toString(),EjdConstants.BRAND_ROBAM_LABEL),
		new SelectItem(EjdConstants.BRAND_FOTILE_NAME.toString(),EjdConstants.BRAND_FOTILE_LABEL),
		new SelectItem(EjdConstants.BRAND_SACON_NAME.toString(),EjdConstants.BRAND_SACON_LABEL),
		new SelectItem(EjdConstants.BRAND_VANWARD_NAME.toString(),EjdConstants.BRAND_VANWARD_LABEL),
		new SelectItem(EjdConstants.BRAND_CANBO_NAME.toString(),EjdConstants.BRAND_CANBO_LABEL),
		new SelectItem(EjdConstants.BRAND_VATTI_NAME.toString(),EjdConstants.BRAND_VATTI_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceGasStoveProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceGasStoveProductBrandBean() {
		
	}

}

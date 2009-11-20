package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceMicrowaveOvenProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_MIDEA_LABEL.toString(),EjdConstants.BRAND_MIDEA_LABEL),
		new SelectItem(EjdConstants.BRAND_LG_NAME.toString(),EjdConstants.BRAND_LG_LABEL),
		new SelectItem(EjdConstants.BRAND_GALANZ_NAME.toString(),EjdConstants.BRAND_GALANZ_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceMicrowaveOvenProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceMicrowaveOvenProductBrandBean() {
		
	}

}

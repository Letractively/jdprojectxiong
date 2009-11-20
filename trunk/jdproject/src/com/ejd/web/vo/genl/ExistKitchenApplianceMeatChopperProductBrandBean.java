package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceMeatChopperProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_JOYOUNG_NAME.toString(),EjdConstants.BRAND_JOYOUNG_LABEL),
		new SelectItem(EjdConstants.BRAND_DEERDQ_NAME.toString(),EjdConstants.BRAND_DEERDQ_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceMeatChopperProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceMeatChopperProductBrandBean() {
		
	}

}

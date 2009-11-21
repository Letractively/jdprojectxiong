package com.ejd.web.vo.genl.kitchenapplicance;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceEggCookerProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_DONLIM_NAME.toString(),EjdConstants.BRAND_DONLIM_LABEL),
		new SelectItem(EjdConstants.BRAND_ACA_NAME.toString(),EjdConstants.BRAND_ACA_LABEL),
		new SelectItem(EjdConstants.BRAND_DEERDQ_NAME.toString(),EjdConstants.BRAND_DEERDQ_LABEL),
		new SelectItem(EjdConstants.BRAND_BEAR_NAME.toString(),EjdConstants.BRAND_BEAR_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceEggCookerProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceEggCookerProductBrandBean() {
		
	}

}

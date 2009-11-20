package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceWhiskProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_ACA_NAME.toString(),EjdConstants.BRAND_ACA_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceWhiskProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceWhiskProductBrandBean() {
		
	}

}

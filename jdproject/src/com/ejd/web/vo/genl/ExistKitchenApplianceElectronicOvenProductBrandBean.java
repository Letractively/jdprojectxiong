package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceElectronicOvenProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_PHILIPS_NAME.toString(),EjdConstants.BRAND_PHILIPS_LABEL),
		new SelectItem(EjdConstants.BRAND_GREE_NAME.toString(),EjdConstants.BRAND_GREE_LABEL),
		new SelectItem(EjdConstants.BRAND_DONLIM_NAME.toString(),EjdConstants.BRAND_DONLIM_LABEL),
		new SelectItem(EjdConstants.BRAND_ACA_NAME.toString(),EjdConstants.BRAND_ACA_LABEL),
		new SelectItem(EjdConstants.BRAND_TIGER_NAME.toString(),EjdConstants.BRAND_TIGER_LABEL),
		new SelectItem(EjdConstants.BRAND_DELONGHI_NAME.toString(),EjdConstants.BRAND_DELONGHI_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceElectronicOvenProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceElectronicOvenProductBrandBean() {
		
	}

}

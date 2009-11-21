package com.ejd.web.vo.genl.kitchenapplicance;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceElectricPressureCookerProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_MIDEA_LABEL.toString(),EjdConstants.BRAND_MIDEA_LABEL),
		new SelectItem(EjdConstants.BRAND_GALANZ_NAME.toString(),EjdConstants.BRAND_GALANZ_LABEL),
		new SelectItem(EjdConstants.BRAND_AIRMATE_NAME.toString(),EjdConstants.BRAND_AIRMATE_LABEL),
		new SelectItem(EjdConstants.BRAND_SANSUI_NAME.toString(),EjdConstants.BRAND_SANSUI_LABEL),
		new SelectItem(EjdConstants.BRAND_ACA_NAME.toString(),EjdConstants.BRAND_ACA_LABEL),
		new SelectItem(EjdConstants.BRAND_WEKING_NAME.toString(),EjdConstants.BRAND_WEKING_LABEL),
		new SelectItem(EjdConstants.BRAND_JOYOUNG_NAME.toString(),EjdConstants.BRAND_JOYOUNG_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceElectricPressureCookerProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceElectricPressureCookerProductBrandBean() {
		
	}

}

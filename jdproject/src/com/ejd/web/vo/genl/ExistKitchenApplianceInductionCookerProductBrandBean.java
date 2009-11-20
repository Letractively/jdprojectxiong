package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceInductionCookerProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_MIDEA_LABEL.toString(),EjdConstants.BRAND_MIDEA_LABEL),
		new SelectItem(EjdConstants.BRAND_GREE_NAME.toString(),EjdConstants.BRAND_GREE_LABEL),
		new SelectItem(EjdConstants.BRAND_PHILIPS_NAME.toString(),EjdConstants.BRAND_PHILIPS_LABEL),
		new SelectItem(EjdConstants.BRAND_GALANZ_NAME.toString(),EjdConstants.BRAND_GALANZ_LABEL),
		new SelectItem(EjdConstants.BRAND_AIRMATE_NAME.toString(),EjdConstants.BRAND_AIRMATE_LABEL),
		new SelectItem(EjdConstants.BRAND_POVOS_NAME.toString(),EjdConstants.BRAND_POVOS_LABEL),
		new SelectItem(EjdConstants.BRAND_SUPOR_NAME.toString(),EjdConstants.BRAND_SUPOR_LABEL),
		new SelectItem(EjdConstants.BRAND_SANSUI_NAME.toString(),EjdConstants.BRAND_SANSUI_LABEL),
		new SelectItem(EjdConstants.BRAND_ACA_NAME.toString(),EjdConstants.BRAND_ACA_LABEL),
		new SelectItem(EjdConstants.BRAND_FUSHIBAO_NAME.toString(),EjdConstants.BRAND_FUSHIBAO_LABEL),
		new SelectItem(EjdConstants.BRAND_WEKING_NAME.toString(),EjdConstants.BRAND_WEKING_LABEL),
		new SelectItem(EjdConstants.BRAND_JOYOUNG_NAME.toString(),EjdConstants.BRAND_JOYOUNG_LABEL),
		new SelectItem(EjdConstants.BRAND_DEERDQ_NAME.toString(),EjdConstants.BRAND_DEERDQ_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceInductionCookerProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceInductionCookerProductBrandBean() {
		
	}

}

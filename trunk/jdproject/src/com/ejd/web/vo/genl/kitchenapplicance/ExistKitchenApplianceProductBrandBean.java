package com.ejd.web.vo.genl.kitchenapplicance;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_MIDEA_LABEL.toString(),EjdConstants.BRAND_MIDEA_LABEL),
		new SelectItem(EjdConstants.BRAND_GREE_NAME.toString(),EjdConstants.BRAND_GREE_LABEL),
		new SelectItem(EjdConstants.BRAND_PANASONIC_NAME.toString(),EjdConstants.BRAND_PANASONIC_LABEL),
		new SelectItem(EjdConstants.BRAND_PHILIPS_NAME.toString(),EjdConstants.BRAND_PHILIPS_LABEL),
		new SelectItem(EjdConstants.BRAND_GALANZ_NAME.toString(),EjdConstants.BRAND_GALANZ_LABEL),
		new SelectItem(EjdConstants.BRAND_AIRMATE_NAME.toString(),EjdConstants.BRAND_AIRMATE_LABEL),
		new SelectItem(EjdConstants.BRAND_POVOS_NAME.toString(),EjdConstants.BRAND_POVOS_LABEL),
		new SelectItem(EjdConstants.BRAND_SUPOR_NAME.toString(),EjdConstants.BRAND_SUPOR_LABEL),
		new SelectItem(EjdConstants.BRAND_ACA_NAME.toString(),EjdConstants.BRAND_ACA_LABEL),
		new SelectItem(EjdConstants.BRAND_WEKING_NAME.toString(),EjdConstants.BRAND_WEKING_LABEL),
		new SelectItem(EjdConstants.BRAND_JOYOUNG_NAME.toString(),EjdConstants.BRAND_JOYOUNG_LABEL),
		new SelectItem(EjdConstants.BRAND_TIGER_NAME.toString(),EjdConstants.BRAND_TIGER_LABEL),
		new SelectItem(EjdConstants.BRAND_DEERDQ_NAME.toString(),EjdConstants.BRAND_DEERDQ_LABEL),
		new SelectItem(EjdConstants.BRAND_SANSUI_NAME.toString(),EjdConstants.BRAND_SANSUI_LABEL),
		new SelectItem(EjdConstants.BRAND_FUSHIBAO_NAME.toString(),EjdConstants.BRAND_FUSHIBAO_LABEL),
		new SelectItem(EjdConstants.BRAND_BEAR_NAME.toString(),EjdConstants.BRAND_BEAR_LABEL),
		new SelectItem(EjdConstants.BRAND_DONLIM_NAME.toString(),EjdConstants.BRAND_DONLIM_LABEL),
		new SelectItem(EjdConstants.BRAND_DELONGHI_NAME.toString(),EjdConstants.BRAND_DELONGHI_LABEL),
		new SelectItem(EjdConstants.BRAND_ELECTROLUX_NAME.toString(),EjdConstants.BRAND_ELECTROLUX_LABEL),
		new SelectItem(EjdConstants.BRAND_WIK_NAME.toString(),EjdConstants.BRAND_WIK_LABEL),
		new SelectItem(EjdConstants.BRAND_LG_NAME.toString(),EjdConstants.BRAND_LG_LABEL),
		new SelectItem(EjdConstants.BRAND_ROBAM_NAME.toString(),EjdConstants.BRAND_ROBAM_LABEL),
		new SelectItem(EjdConstants.BRAND_FOTILE_NAME.toString(),EjdConstants.BRAND_FOTILE_LABEL),
		new SelectItem(EjdConstants.BRAND_SACON_NAME.toString(),EjdConstants.BRAND_SACON_LABEL),
		new SelectItem(EjdConstants.BRAND_VANWARD_NAME.toString(),EjdConstants.BRAND_VANWARD_LABEL),
		new SelectItem(EjdConstants.BRAND_CANBO_NAME.toString(),EjdConstants.BRAND_CANBO_LABEL),
		new SelectItem(EjdConstants.BRAND_VATTI_NAME.toString(),EjdConstants.BRAND_VATTI_LABEL),
		new SelectItem(EjdConstants.BRAND_YILI_NAME.toString(),EjdConstants.BRAND_YILI_LABEL),
		new SelectItem(EjdConstants.BRAND_TEFAL_NAME.toString(),EjdConstants.BRAND_TEFAL_LABEL),
		new SelectItem(EjdConstants.BRAND_ARISTON_NAME.toString(),EjdConstants.BRAND_ARISTON_LABEL),
		new SelectItem(EjdConstants.BRAND_AOSMICH_NAME.toString(),EjdConstants.BRAND_AOSMICH_LABEL),
		new SelectItem(EjdConstants.BRAND_HAIER_NAME.toString(),EjdConstants.BRAND_HAIER_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceProductBrandBean() {
		
	}

}

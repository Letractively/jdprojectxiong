package com.ejd.web.vo.genl.householdappliance;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistHouseholdApplianceAirPurifierProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_MIDEA_LABEL.toString(),EjdConstants.BRAND_MIDEA_LABEL),
		new SelectItem(EjdConstants.BRAND_GREE_NAME.toString(),EjdConstants.BRAND_GREE_LABEL),
		new SelectItem(EjdConstants.BRAND_PHILIPS_NAME.toString(),EjdConstants.BRAND_PHILIPS_LABEL),
		new SelectItem(EjdConstants.BRAND_GALANZ_NAME.toString(),EjdConstants.BRAND_GALANZ_LABEL),
		new SelectItem(EjdConstants.BRAND_DONLIM_NAME.toString(),EjdConstants.BRAND_DONLIM_LABEL),
		new SelectItem(EjdConstants.BRAND_ACA_NAME.toString(),EjdConstants.BRAND_ACA_LABEL),
		new SelectItem(EjdConstants.BRAND_TEFAL_NAME.toString(),EjdConstants.BRAND_TEFAL_LABEL),
		new SelectItem(EjdConstants.BRAND_JOYOUNG_NAME.toString(),EjdConstants.BRAND_JOYOUNG_LABEL),
		new SelectItem(EjdConstants.BRAND_TIGER_NAME.toString(),EjdConstants.BRAND_TIGER_LABEL),
		new SelectItem(EjdConstants.BRAND_DELONGHI_NAME.toString(),EjdConstants.BRAND_DELONGHI_LABEL),
		new SelectItem(EjdConstants.BRAND_WIK_NAME.toString(),EjdConstants.BRAND_WIK_LABEL),
		new SelectItem(EjdConstants.BRAND_ELECTROLUX_NAME.toString(),EjdConstants.BRAND_ELECTROLUX_LABEL),
		new SelectItem(EjdConstants.BRAND_DEERDQ_NAME.toString(),EjdConstants.BRAND_DEERDQ_LABEL),
		new SelectItem(EjdConstants.BRAND_5E_NAME.toString(),EjdConstants.BRAND_5E_LABEL),
		new SelectItem(EjdConstants.BRAND_AIRMATE_NAME.toString(),EjdConstants.BRAND_AIRMATE_LABEL),
		new SelectItem(EjdConstants.BRAND_PANASONIC_NAME.toString(),EjdConstants.BRAND_PANASONIC_LABEL),
		new SelectItem(EjdConstants.BRAND_FLYCO_NAME.toString(),EjdConstants.BRAND_FLYCO_LABEL),
		new SelectItem(EjdConstants.BRAND_SID_NAME.toString(),EjdConstants.BRAND_SID_LABEL),
		new SelectItem(EjdConstants.BRAND_TSANNKUEN_NAME.toString(),EjdConstants.BRAND_TSANNKUEN_LABEL),
		new SelectItem(EjdConstants.BRAND_TOSHIBA_NAME.toString(),EjdConstants.BRAND_TOSHIBA_LABEL),
		new SelectItem(EjdConstants.BRAND_ROWENTA_NAME.toString(),EjdConstants.BRAND_ROWENTA_LABEL),
		new SelectItem(EjdConstants.BRAND_SINCERE_NAME.toString(),EjdConstants.BRAND_SINCERE_LABEL),
		new SelectItem(EjdConstants.BRAND_MAXCARE_NAME.toString(),EjdConstants.BRAND_MAXCARE_LABEL),
		new SelectItem(EjdConstants.BRAND_BLACKDECKER_NAME.toString(),EjdConstants.BRAND_BLACKDECKER_LABEL),
		new SelectItem(EjdConstants.BRAND_SHARPCROWN_NAME.toString(),EjdConstants.BRAND_SHARPCROWN_LABEL),
		new SelectItem(EjdConstants.BRAND_YADU_NAME.toString(),EjdConstants.BRAND_YADU_LABEL),
		new SelectItem(EjdConstants.BRAND_SANSUI_NAME.toString(),EjdConstants.BRAND_SANSUI_LABEL),
		new SelectItem(EjdConstants.BRAND_FUSHIBAO_NAME.toString(),EjdConstants.BRAND_FUSHIBAO_LABEL),
		new SelectItem(EjdConstants.BRAND_ANGEL_NAME.toString(),EjdConstants.BRAND_ANGEL_LABEL),
		new SelectItem(EjdConstants.BRAND_QINYUAN_NAME.toString(),EjdConstants.BRAND_QINYUAN_LABEL),
		new SelectItem(EjdConstants.BRAND_SIEMENS_NAME.toString(),EjdConstants.BRAND_SIEMENS_LABEL),
		new SelectItem(EjdConstants.BRAND_HWAMEIR_NAME.toString(),EjdConstants.BRAND_HWAMEIR_LABEL),
		new SelectItem(EjdConstants.BRAND_FEIYUE_NAME.toString(),EjdConstants.BRAND_FEIYUE_LABEL),
		new SelectItem(EjdConstants.BRAND_LUCKLIFE_NAME.toString(),EjdConstants.BRAND_LUCKLIFE_LABEL),
		new SelectItem(EjdConstants.BRAND_DIVA_NAME.toString(),EjdConstants.BRAND_DIVA_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistHouseholdApplianceAirPurifierProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistHouseholdApplianceAirPurifierProductBrandBean() {
		
	}

}

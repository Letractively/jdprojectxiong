package com.ejd.web.vo.genl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.NONE_LAEBL),
		new SelectItem(EjdConstants.BRAND_MIDEA_NAME.toString(),EjdConstants.BRAND_MIDEA_LABEL),
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
		new SelectItem(EjdConstants.BRAND_5E_NAME.toString(),EjdConstants.BRAND_5E_LABEL),
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
		new SelectItem(EjdConstants.BRAND_ANGEL_NAME.toString(),EjdConstants.BRAND_ANGEL_LABEL),
		new SelectItem(EjdConstants.BRAND_QINYUAN_NAME.toString(),EjdConstants.BRAND_QINYUAN_LABEL),
		new SelectItem(EjdConstants.BRAND_SIEMENS_NAME.toString(),EjdConstants.BRAND_SIEMENS_LABEL),
		new SelectItem(EjdConstants.BRAND_HWAMEIR_NAME.toString(),EjdConstants.BRAND_HWAMEIR_LABEL),
		new SelectItem(EjdConstants.BRAND_FEIYUE_NAME.toString(),EjdConstants.BRAND_FEIYUE_LABEL),
		new SelectItem(EjdConstants.BRAND_LUCKLIFE_NAME.toString(),EjdConstants.BRAND_LUCKLIFE_LABEL),
		new SelectItem(EjdConstants.BRAND_DIVA_NAME.toString(),EjdConstants.BRAND_DIVA_LABEL),
		new SelectItem(EjdConstants.BRAND_AUPU_NAME.toString(),EjdConstants.BRAND_AUPU_LABEL),
		new SelectItem(EjdConstants.BRAND_DLG_NAME.toString(),EjdConstants.BRAND_DLG_LABEL),
		new SelectItem(EjdConstants.BRAND_HIVOX_NAME.toString(),EjdConstants.BRAND_HIVOX_LABEL),
		new SelectItem(EjdConstants.BRAND_OSRAM_NAME.toString(),EjdConstants.BRAND_OSRAM_LABEL),
		new SelectItem(EjdConstants.BRAND_MKD_NAME.toString(),EjdConstants.BRAND_MKD_LABEL),
		new SelectItem(EjdConstants.BRAND_ZOFU_NAME.toString(),EjdConstants.BRAND_ZOFU_LABEL),
		new SelectItem(EjdConstants.BRAND_TCL_NAME.toString(),EjdConstants.BRAND_TCL_LABEL),
		new SelectItem(EjdConstants.BRAND_HISENSE_NAME.toString(),EjdConstants.BRAND_HISENSE_LABEL),
		new SelectItem(EjdConstants.BRAND_CHANGHONG_NAME.toString(),EjdConstants.BRAND_CHANGHONG_LABEL),
		new SelectItem(EjdConstants.BRAND_KONKA_NAME.toString(),EjdConstants.BRAND_KONKA_LABEL),
		new SelectItem(EjdConstants.BRAND_SONY_NAME.toString(),EjdConstants.BRAND_SONY_LABEL),
		new SelectItem(EjdConstants.BRAND_SHARP_NAME.toString(),EjdConstants.BRAND_SHARP_LABEL),
		new SelectItem(EjdConstants.BRAND_HITACHI_NAME.toString(),EjdConstants.BRAND_HITACHI_LABEL),
		new SelectItem(EjdConstants.BRAND_SKYWORTH_NAME.toString(),EjdConstants.BRAND_SKYWORTH_LABEL),
		new SelectItem(EjdConstants.BRAND_SAMSUNG_NAME.toString(),EjdConstants.BRAND_SAMSUNG_LABEL),
		new SelectItem(EjdConstants.BRAND_MALATA_NAME.toString(),EjdConstants.BRAND_MALATA_LABEL),
		new SelectItem(EjdConstants.BRAND_NEWSMY_NAME.toString(),EjdConstants.BRAND_NEWSMY_LABEL),
		new SelectItem(EjdConstants.BRAND_SANYO_NAME.toString(),EjdConstants.BRAND_SANYO_LABEL),
		new SelectItem(EjdConstants.BRAND_FRESTECH_NAME.toString(),EjdConstants.BRAND_FRESTECH_LABEL),
		new SelectItem(EjdConstants.BRAND_RONGSHENG_NAME.toString(),EjdConstants.BRAND_RONGSHENG_LABEL),
		new SelectItem(EjdConstants.BRAND_CHIGO_NAME.toString(),EjdConstants.BRAND_CHIGO_LABEL),
		new SelectItem(EjdConstants.BRAND_AUX_NAME.toString(),EjdConstants.BRAND_AUX_LABEL),
		new SelectItem(EjdConstants.BRAND_MHI_NAME.toString(),EjdConstants.BRAND_MHI_LABEL),
		new SelectItem(EjdConstants.BRAND_MITSUBISHI_NAME.toString(),EjdConstants.BRAND_MITSUBISHI_LABEL),
		new SelectItem(EjdConstants.BRAND_KELON_NAME.toString(),EjdConstants.BRAND_KELON_LABEL),
		new SelectItem(EjdConstants.BRAND_DAIKIN_NAME.toString(),EjdConstants.BRAND_DAIKIN_LABEL),
		new SelectItem(EjdConstants.BRAND_ROYALSTAR_NAME.toString(),EjdConstants.BRAND_ROYALSTAR_LABEL),
		new SelectItem(EjdConstants.BRAND_WHIRLPOOL_NAME.toString(),EjdConstants.BRAND_WHIRLPOOL_LABEL),
		new SelectItem(EjdConstants.BRAND_HANYU_NAME.toString(),EjdConstants.BRAND_HANYU_LABEL),
		new SelectItem(EjdConstants.BRAND_AIGO_NAME.toString(),EjdConstants.BRAND_AIGO_LABEL),
		new SelectItem(EjdConstants.BRAND_CHUWI_NAME.toString(),EjdConstants.BRAND_CHUWI_LABEL),
		new SelectItem(EjdConstants.BRAND_CREATIVE_NAME.toString(),EjdConstants.BRAND_CREATIVE_LABEL),
		new SelectItem(EjdConstants.BRAND_NOKIA_NAME.toString(),EjdConstants.BRAND_NOKIA_LABEL),
		new SelectItem(EjdConstants.BRAND_LENOVO_NAME.toString(),EjdConstants.BRAND_LENOVO_LABEL),
		new SelectItem(EjdConstants.BRAND_MOTOROLA_NAME.toString(),EjdConstants.BRAND_MOTOROLA_LABEL),
		new SelectItem(EjdConstants.BRAND_SONY_ERICSSON_NAME.toString(),EjdConstants.BRAND_SONY_ERICSSON_LABEL),
		new SelectItem(EjdConstants.BRAND_DOPOD_NAME.toString(),EjdConstants.BRAND_DOPOD_LABEL),
		new SelectItem(EjdConstants.BRAND_COOLPAD_NAME.toString(),EjdConstants.BRAND_COOLPAD_LABEL),
		new SelectItem(EjdConstants.BRAND_CECT_NAME.toString(),EjdConstants.BRAND_CECT_LABEL),
		new SelectItem(EjdConstants.BRAND_GIONEE_NAME.toString(),EjdConstants.BRAND_GIONEE_LABEL),
		new SelectItem(EjdConstants.BRAND_K_TOUCH_NAME.toString(),EjdConstants.BRAND_K_TOUCH_LABEL),
		new SelectItem(EjdConstants.BRAND_LOVEME_NAME.toString(),EjdConstants.BRAND_LOVEME_LABEL),
		new SelectItem(EjdConstants.BRAND_V_THREE_NAME.toString(),EjdConstants.BRAND_V_THREE_LABEL),
		new SelectItem(EjdConstants.BRAND_JABRA_NAME.toString(),EjdConstants.BRAND_JABRA_LABEL),
		new SelectItem(EjdConstants.BRAND_CUBE_NAME.toString(),EjdConstants.BRAND_CUBE_LABEL),
		new SelectItem(EjdConstants.BRAND_ONDA_NAME.toString(),EjdConstants.BRAND_ONDA_LABEL),
		new SelectItem(EjdConstants.BRAND_AINOL_NAME.toString(),EjdConstants.BRAND_AINOL_LABEL),
		new SelectItem(EjdConstants.BRAND_TECLAST_NAME.toString(),EjdConstants.BRAND_TECLAST_LABEL),
		new SelectItem(EjdConstants.BRAND_RAMOS_NAME.toString(),EjdConstants.BRAND_RAMOS_LABEL),
		new SelectItem(EjdConstants.BRAND_NIHO_NAME.toString(),EjdConstants.BRAND_NIHO_LABEL),
		new SelectItem(EjdConstants.BRAND_MSUR_NAME.toString(),EjdConstants.BRAND_MSUR_LABEL),
		new SelectItem(EjdConstants.BRAND_RENWOYOU_NAME.toString(),EjdConstants.BRAND_RENWOYOU_LABEL),
		new SelectItem(EjdConstants.BRAND_SHINCO_NAME.toString(),EjdConstants.BRAND_SHINCO_LABEL),
		new SelectItem(EjdConstants.BRAND_CITYEXPRESS_NAME.toString(),EjdConstants.BRAND_CITYEXPRESS_LABEL),
		new SelectItem(EjdConstants.BRAND_NPANEL_NAME.toString(),EjdConstants.BRAND_NPANEL_LABEL),
		new SelectItem(EjdConstants.BRAND_ELODA_NAME.toString(),EjdConstants.BRAND_ELODA_LABEL),
		new SelectItem(EjdConstants.BRAND_APACER_NAME.toString(),EjdConstants.BRAND_APACER_LABEL),
		new SelectItem(EjdConstants.BRAND_KINGSTON_NAME.toString(),EjdConstants.BRAND_KINGSTON_LABEL),
		new SelectItem(EjdConstants.BRAND_SIGL_NAME.toString(),EjdConstants.BRAND_SIGL_LABEL),
		new SelectItem(EjdConstants.BRAND_RAPOO_NAME.toString(),EjdConstants.BRAND_RAPOO_LABEL),
		new SelectItem(EjdConstants.BRAND_SUNROSE_NAME.toString(),EjdConstants.BRAND_SUNROSE_LABEL),
		new SelectItem(EjdConstants.BRAND_DELUX_NAME.toString(),EjdConstants.BRAND_DELUX_LABEL),
		new SelectItem(EjdConstants.BRAND_Newmen_NAME.toString(),EjdConstants.BRAND_Newmen_LABEL),
		new SelectItem(EjdConstants.BRAND_SUMTAX_NAME.toString(),EjdConstants.BRAND_SUMTAX_LABEL),
		new SelectItem(EjdConstants.BRAND_RAZER_NAME.toString(),EjdConstants.BRAND_RAZER_LABEL),
		new SelectItem(EjdConstants.BRAND_GOLDENFIELD_NAME.toString(),EjdConstants.BRAND_GOLDENFIELD_LABEL),
		new SelectItem(EjdConstants.BRAND_REALMADRID_NAME.toString(),EjdConstants.BRAND_REALMADRID_LABEL),
		new SelectItem(EjdConstants.BRAND_HYUNDAI_NAME.toString(),EjdConstants.BRAND_HYUNDAI_LABEL),
		new SelectItem(EjdConstants.BRAND_MICROSOFT_NAME.toString(),EjdConstants.BRAND_MICROSOFT_LABEL),
		new SelectItem(EjdConstants.BRAND_APPLE_NAME.toString(),EjdConstants.BRAND_APPLE_LABEL),
		new SelectItem(EjdConstants.BRAND_HP_NAME.toString(),EjdConstants.BRAND_HP_LABEL),
		new SelectItem(EjdConstants.BRAND_DELL_NAME.toString(),EjdConstants.BRAND_DELL_LABEL),
		new SelectItem(EjdConstants.BRAND_AOC_NAME.toString(),EjdConstants.BRAND_AOC_LABEL),
		new SelectItem(EjdConstants.BRAND_PCCOOLER_NAME.toString(),EjdConstants.BRAND_PCCOOLER_LABEL),
		new SelectItem(EjdConstants.BRAND_TOMADO_NAME.toString(),EjdConstants.BRAND_TOMADO_LABEL),
		new SelectItem(EjdConstants.BRAND_IBM_NAME.toString(),EjdConstants.BRAND_IBM_LABEL),
		new SelectItem(EjdConstants.BRAND_AIXUEBAO_NAME.toString(),EjdConstants.BRAND_AIXUEBAO_LABEL),
		new SelectItem(EjdConstants.BRAND_ASUS_NAME.toString(),EjdConstants.BRAND_ASUS_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public Map<String,SelectItem> getBrandCodeMapItems() {
		Map<String,SelectItem> result = new HashMap<String,SelectItem>();
		int itemLength = this.getBrandCodeItems().length;
		SelectItem[] tempBrandCodeItems = new SelectItem[itemLength];
		tempBrandCodeItems = this.getBrandCodeItems();
		for (int i = 0; i < tempBrandCodeItems.length ; i++) {
			result.put(tempBrandCodeItems[i].getValue().toString(),(SelectItem)tempBrandCodeItems[i]);
		}
		return result;
	}
	public String getLabelOfBrandCode(String brandCode) {
		String result = "";
		Map<String,SelectItem> tempMap = this.getBrandCodeMapItems();
		SelectItem curCodeItem = tempMap.get(brandCode);
		result = curCodeItem.getLabel();
		return result;
	}
	public ExistProductBrandBean() {
		
	}

}

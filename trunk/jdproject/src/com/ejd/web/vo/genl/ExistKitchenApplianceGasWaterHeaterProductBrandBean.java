package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ExistKitchenApplianceGasWaterHeaterProductBrandBean {
	private static SelectItem[] brandCodeItems = {
		new SelectItem(new String(""),HeaderConstants.PRODUCT_ALL_LABEL),
		new SelectItem(EjdConstants.BRAND_MIDEA_LABEL.toString(),EjdConstants.BRAND_MIDEA_LABEL),
		new SelectItem(EjdConstants.BRAND_VANWARD_NAME.toString(),EjdConstants.BRAND_VANWARD_LABEL),
		new SelectItem(EjdConstants.BRAND_VATTI_NAME.toString(),EjdConstants.BRAND_VATTI_LABEL),
		new SelectItem(EjdConstants.BRAND_ARISTON_NAME.toString(),EjdConstants.BRAND_ARISTON_LABEL),
		new SelectItem(EjdConstants.BRAND_AOSMICH_NAME.toString(),EjdConstants.BRAND_AOSMICH_LABEL),
	};

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public static void setBrandCodeItems(SelectItem[] brandCodeItems) {
		ExistKitchenApplianceGasWaterHeaterProductBrandBean.brandCodeItems = brandCodeItems;
	}
	
	public ExistKitchenApplianceGasWaterHeaterProductBrandBean() {
		
	}

}

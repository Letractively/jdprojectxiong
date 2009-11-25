package com.ejd.utils;

import java.util.List;
import java.util.Map;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.web.vo.genl.ExistProductBrandBean;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ProductBrandUtil {
	public ProductBrandUtil() {
		
	}
	public Map<String,SelectItem> getBrandCodeMapItems() {
		ExistProductBrandBean existProductBrand = (ExistProductBrandBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_PRODUCT_BRAND_BEAN_NAME);
		return existProductBrand.getBrandCodeMapItems();
	}
	
	public String getLabelOfBrandCode(String brandCode) {
		ExistProductBrandBean existProductBrand = (ExistProductBrandBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_PRODUCT_BRAND_BEAN_NAME);
		return existProductBrand.getLabelOfBrandCode(brandCode);
	}
	
	public  SelectItem[] getBrandCodeItem(List<String> param) {
		SelectItem[] result = null;
		if (null == param || param.isEmpty()) {
			result = new SelectItem[1];
			result[0] = new SelectItem("",HeaderConstants.PRODUCT_ALL_LABEL);
			return result;
		}
		int length = param.size() + 1;
		 result = new SelectItem[length];
		 Map<String,SelectItem> tempBrandCodeMap = this.getBrandCodeMapItems();
		 result[0] = new SelectItem("",HeaderConstants.PRODUCT_ALL_LABEL);;
		 for (int i = 1; i < length; i++) {
			 result[i] = tempBrandCodeMap.get(param.get(i-1));
		 }
		 return result;
	}
	


}

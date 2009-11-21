package com.ejd.utils;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.web.vo.genl.secondcategory.ExistComputerNetworkProductSecondCategoryBean;
import com.ejd.web.vo.genl.secondcategory.ExistHealthDeviceProductSecondCategoryBean;
import com.ejd.web.vo.genl.secondcategory.ExistHouseholdApplianceProductSecondCategoryBean;
import com.ejd.web.vo.genl.secondcategory.ExistKitchenApplianceProductSecondCategoryBean;
import com.ejd.web.vo.genl.secondcategory.ExistMajorApplianceProductSecondCategoryBean;
import com.ejd.web.vo.genl.secondcategory.ExistPersonalCareProductSecondCategoryBean;
import com.ejd.web.vo.genl.secondcategory.ExistPhoneDigitalProductSecondCategoryBean;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class ProductCategoryUtil {
	
	public static SelectItem[] selectProductSecondCategoryByPrimaryCategory(String primaryCategoryName) {
		SelectItem[] result = new SelectItem[1];
		result[0] = new SelectItem("","kitchenAppliance","kitchenAppliance");
		if (HeaderConstants.KITCHEN_APPLIANCE_NAME.equals(primaryCategoryName)) {
			ExistKitchenApplianceProductSecondCategoryBean existKitchenApplianceProductSecondCategory = (ExistKitchenApplianceProductSecondCategoryBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_PRODUCT_SECOND_CATEGORY_BEAN_NAME);
			return existKitchenApplianceProductSecondCategory.getSecondCategoryCodeItems();
		}
		if (HeaderConstants.HOUSEHOLD_APPLIANCE_NAME.equals(primaryCategoryName)) {
			ExistHouseholdApplianceProductSecondCategoryBean existHouseholdApplianceProductSecondCategory = (ExistHouseholdApplianceProductSecondCategoryBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_HOUSEHOLD_APPLIANCE_PRODUCT_SECOND_CATEGORY_BEAN_NAME);
			return existHouseholdApplianceProductSecondCategory.getSecondCategoryCodeItems();
		}
		if (HeaderConstants.PERSONAL_CARE_NAME.equals(primaryCategoryName)) {
			ExistPersonalCareProductSecondCategoryBean existPersonalCareProductSecondCategory = (ExistPersonalCareProductSecondCategoryBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_PERSONAL_CARE_PRODUCT_SECOND_CATEGORY_BEAN_NAME);
			return existPersonalCareProductSecondCategory.getSecondCategoryCodeItems();
		}
		if (HeaderConstants.HEALTH_DEVICE_NAME.equals(primaryCategoryName)) {
			ExistHealthDeviceProductSecondCategoryBean existHealthDeviceProductSecondCategory = (ExistHealthDeviceProductSecondCategoryBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_HEALTH_DEVICE_PRODUCT_SECOND_CATEGORY_BEAN_NAME);
			return existHealthDeviceProductSecondCategory.getSecondCategoryCodeItems();
		}
		if (HeaderConstants.MAJOR_APPLIANCE_NAME.equals(primaryCategoryName)) {
			ExistMajorApplianceProductSecondCategoryBean existMajorApplianceProductSecondCategory = (ExistMajorApplianceProductSecondCategoryBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_MAJOR_APPLIANCE_PRODUCT_SECOND_CATEGORY_BEAN_NAME);
			return existMajorApplianceProductSecondCategory.getSecondCategoryCodeItems();
		}
		if (HeaderConstants.PHONE_DIGITAL_NAME.equals(primaryCategoryName)) {
			ExistPhoneDigitalProductSecondCategoryBean existPhoneDigitalProductSecondCategory = (ExistPhoneDigitalProductSecondCategoryBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_PHONE_DIGITAL_PRODUCT_SECOND_CATEGORY_BEAN_NAME);
			return existPhoneDigitalProductSecondCategory.getSecondCategoryCodeItems();
		}
		if (HeaderConstants.COMPUTER_NETWORK_NAME.equals(primaryCategoryName)) {
			ExistComputerNetworkProductSecondCategoryBean existComputerNetworkProductSecondCategory = (ExistComputerNetworkProductSecondCategoryBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_COMPUTER_NETWORK_PRODUCT_SECOND_CATEGORY_BEAN_NAME);
			return existComputerNetworkProductSecondCategory.getSecondCategoryCodeItems();
		}
		return result;
	}
	public static String getCurrentSelectItemName(String value,SelectItem[] items) {
		String result = "";
		if (null == value || "".equals(value)) {
			return "";
		}
		if (null == items || items.length < 1) {
			return "";
		}
		for (int i = 0; i < items.length; i ++) {
			SelectItem tempItem = items[i];
			if (value.equals(tempItem.getValue())) {
				result = tempItem.getDescription();
				break;
			}
		}
		return result;
	}

}

package com.ejd.utils;

import java.util.Iterator;
import java.util.List;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.Menu;
import com.ejd.web.vo.richfaces.header.MenuItem;
import com.ejd.web.vo.shopcart.InventoryCategory;

public final class HeaderMenuUtil {
	
	public static MenuItem getMenuItemByName(String name, List<MenuItem> items) {//name items must need
		MenuItem result = new MenuItem();
		for (MenuItem tempItem:items) {
			if (name.equals(tempItem.getName())) {
				result = tempItem;
				break;
			}
		}
		return result;
	}
	
	public static Menu getMenuByIdFirst(String idFirst) {
		Menu result = null;
		HeaderTabPanelBean headerTabPanel = (HeaderTabPanelBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.HEADER_TABPANEL_BEAN_NAME);
		//List<MenuItem> subMenu = headerTabPanel.getComputerNetwork().getSubMenu();
		if (HeaderConstants.KITCHEN_APPLIANCE_NAME.equals(idFirst) || (HeaderConstants.KITCHEN_APPLIANCE_ID.equals(idFirst))) {
			result =  headerTabPanel.getKitchenAppliance();
		}
		if (HeaderConstants.HOUSEHOLD_APPLIANCE_NAME.equals(idFirst) || (HeaderConstants.HOUSEHOLD_APPLIANCE_ID.equals(idFirst))) {
			result = headerTabPanel.getHouseholdAppliance();
		}
		if (HeaderConstants.PERSONAL_CARE_NAME.equals(idFirst) || (HeaderConstants.PERSONAL_CARE_ID.equals(idFirst))){
			result = headerTabPanel.getPersonalCare();
		}
		if (HeaderConstants.HEALTH_DEVICE_NAME.equals(idFirst) || (HeaderConstants.HEALTH_DEVICE_ID.equals(idFirst))){
			result = headerTabPanel.getHealthDevice();
		}
		if (HeaderConstants.MAJOR_APPLIANCE_NAME.equals(idFirst) || (HeaderConstants.MAJOR_APPLIANCE_ID.equals(idFirst))){
			result = headerTabPanel.getMajorAppliance();
		}
		if (HeaderConstants.PHONE_DIGITAL_NAME.equals(idFirst) || (HeaderConstants.PHONE_DIGITAL_ID.equals(idFirst))) {
			result = headerTabPanel.getPhoneDigital();
		}
		if (HeaderConstants.COMPUTER_NETWORK_NAME.equals(idFirst) || (HeaderConstants.COMPUTER_NETWORK_ID.equals(idFirst))) {
			result = headerTabPanel.getComputerNetwork();
		}
		return result;
	}
	public static MenuItem getMainMenuItemByIdFirst(String idFirst) {
		MenuItem result = null;
		HeaderTabPanelBean headerTabPanel = (HeaderTabPanelBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.HEADER_TABPANEL_BEAN_NAME);
		//List<MenuItem> subMenu = headerTabPanel.getComputerNetwork().getSubMenu();
		if (HeaderConstants.KITCHEN_APPLIANCE_NAME.equals(idFirst) || (HeaderConstants.KITCHEN_APPLIANCE_ID.equals(idFirst))) {
			result =  headerTabPanel.getKitchenAppliance().getMainMenu();
		}
		if (HeaderConstants.HOUSEHOLD_APPLIANCE_NAME.equals(idFirst) || (HeaderConstants.HOUSEHOLD_APPLIANCE_ID.equals(idFirst))) {
			result = headerTabPanel.getHouseholdAppliance().getMainMenu();
		}
		if (HeaderConstants.PERSONAL_CARE_NAME.equals(idFirst) || (HeaderConstants.PERSONAL_CARE_ID.equals(idFirst))){
			result = headerTabPanel.getPersonalCare().getMainMenu();
		}
		if (HeaderConstants.HEALTH_DEVICE_NAME.equals(idFirst) || (HeaderConstants.HEALTH_DEVICE_ID.equals(idFirst))){
			result = headerTabPanel.getHealthDevice().getMainMenu();
		}
		if (HeaderConstants.MAJOR_APPLIANCE_NAME.equals(idFirst) || (HeaderConstants.MAJOR_APPLIANCE_ID.equals(idFirst))){
			result = headerTabPanel.getMajorAppliance().getMainMenu();
		}
		if (HeaderConstants.PHONE_DIGITAL_NAME.equals(idFirst) || (HeaderConstants.PHONE_DIGITAL_ID.equals(idFirst))) {
			result = headerTabPanel.getPhoneDigital().getMainMenu();
		}
		if (HeaderConstants.COMPUTER_NETWORK_NAME.equals(idFirst) || (HeaderConstants.COMPUTER_NETWORK_ID.equals(idFirst))) {
			result = headerTabPanel.getComputerNetwork().getMainMenu();
		}
		return result;
	}
	public static List<MenuItem> getSubMenuByIdFirst(String idFirst) {
		List<MenuItem> result = null;
		HeaderTabPanelBean headerTabPanel = (HeaderTabPanelBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.HEADER_TABPANEL_BEAN_NAME);
		//List<MenuItem> subMenu = headerTabPanel.getComputerNetwork().getSubMenu();
		if (HeaderConstants.KITCHEN_APPLIANCE_NAME.equals(idFirst) || (HeaderConstants.KITCHEN_APPLIANCE_ID.equals(idFirst))) {
			result =  headerTabPanel.getKitchenAppliance().getSubMenu();
		}
		if (HeaderConstants.HOUSEHOLD_APPLIANCE_NAME.equals(idFirst) || (HeaderConstants.HOUSEHOLD_APPLIANCE_ID.equals(idFirst))) {
			result = headerTabPanel.getHouseholdAppliance().getSubMenu();
		}
		if (HeaderConstants.PERSONAL_CARE_NAME.equals(idFirst) || (HeaderConstants.PERSONAL_CARE_ID.equals(idFirst))){
			result = headerTabPanel.getPersonalCare().getSubMenu();
		}
		if (HeaderConstants.HEALTH_DEVICE_NAME.equals(idFirst) || (HeaderConstants.HEALTH_DEVICE_ID.equals(idFirst))){
			result = headerTabPanel.getHealthDevice().getSubMenu();
		}
		if (HeaderConstants.MAJOR_APPLIANCE_NAME.equals(idFirst) || (HeaderConstants.MAJOR_APPLIANCE_ID.equals(idFirst))){
			result = headerTabPanel.getMajorAppliance().getSubMenu();
		}
		if (HeaderConstants.PHONE_DIGITAL_NAME.equals(idFirst) || (HeaderConstants.PHONE_DIGITAL_ID.equals(idFirst))) {
			result = headerTabPanel.getPhoneDigital().getSubMenu();
		}
		if (HeaderConstants.COMPUTER_NETWORK_NAME.equals(idFirst) || (HeaderConstants.COMPUTER_NETWORK_ID.equals(idFirst))) {
			result = headerTabPanel.getComputerNetwork().getSubMenu();
		}
		return result;
	}
	public static MenuItem getSubMenuEachByIdFirstAndIdSecond(String idFirst,String idSecond) {
		List<MenuItem> resultItems = null;
		MenuItem result = null;
		HeaderTabPanelBean headerTabPanel = (HeaderTabPanelBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.HEADER_TABPANEL_BEAN_NAME);
		//List<MenuItem> subMenu = headerTabPanel.getComputerNetwork().getSubMenu();
		if (HeaderConstants.KITCHEN_APPLIANCE_ID.equals(idFirst)) {
			resultItems =  headerTabPanel.getKitchenAppliance().getSubMenu();
		}
		if (HeaderConstants.HOUSEHOLD_APPLIANCE_ID.equals(idFirst)) {
			resultItems = headerTabPanel.getHouseholdAppliance().getSubMenu();
		}
		if (HeaderConstants.PERSONAL_CARE_ID.equals(idFirst)){
			resultItems = headerTabPanel.getPersonalCare().getSubMenu();
		}
		if (HeaderConstants.HEALTH_DEVICE_ID.equals(idFirst)){
			resultItems = headerTabPanel.getHealthDevice().getSubMenu();
		}
		if (HeaderConstants.MAJOR_APPLIANCE_ID.equals(idFirst)){
			resultItems = headerTabPanel.getMajorAppliance().getSubMenu();
		}
		if (HeaderConstants.PHONE_DIGITAL_ID.equals(idFirst)) {
			resultItems = headerTabPanel.getPhoneDigital().getSubMenu();
		}
		if (HeaderConstants.COMPUTER_NETWORK_ID.equals(idFirst)) {
			resultItems = headerTabPanel.getComputerNetwork().getSubMenu();
		}
		Iterator it = resultItems.iterator();            
        while (it.hasNext()) {
        	MenuItem obj = (MenuItem)(it.next());
        	if (obj.getIdFirst().equals(idFirst) && obj.getIdSecond().equals(idSecond)) {
        		result = obj;
        		break;
        	}
        	
        }
		return result;
	}
}

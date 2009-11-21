package com.ejd.web.vo.genl;

import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.web.vo.richfaces.header.Menu;
import com.ejd.web.vo.richfaces.header.MenuItem;
import com.ejd.common.constant.CommonConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.product.kitchenappliance.KitchenApplianceProductBean;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;

public class ExistProductPrimaryCategoryBean {
	
	private static ExistProductPrimaryCategoryBean instance = null;
	
	public static synchronized ExistProductPrimaryCategoryBean getInstance() {
		if (null == instance){
			instance = new ExistProductPrimaryCategoryBean();
		}
		return instance;
	}
	
	private SelectItem[] primaryCategoryCodeItems = null;
	

	public SelectItem[] getPrimaryCategoryCodeItems() {
		return primaryCategoryCodeItems;
	}


	public void setPrimaryCategoryCodeItems(SelectItem[] primaryCategoryCodeItems) {
		this.primaryCategoryCodeItems = primaryCategoryCodeItems;
	}



	public ExistProductPrimaryCategoryBean() {
		HeaderTabPanelBean headerTabPanel = (HeaderTabPanelBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.HEADER_TABPANEL_BEAN_NAME);
		java.beans.PropertyDescriptor origDescriptors[] = org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptors(headerTabPanel);
		List<MenuItem> tempMenuItemList = new ArrayList<MenuItem>();
		for   (int i = 0; i < origDescriptors.length; i++) {   
            String name = origDescriptors[i].getName();   
            java.beans.PropertyDescriptor tempPropertyDescriptor =origDescriptors[i];
            String className= tempPropertyDescriptor.getPropertyType().getName();
            if (CommonConstants.COM_EJD_WEB_VO_RICHFACES_HEADER_MENU.equals(className)) {
            	MenuItem tempMenuItem = new MenuItem();
            	Class cl = headerTabPanel.getClass();
            	Menu tempMenu= new Menu();
            	Method md = tempPropertyDescriptor.getReadMethod();
            	try {
            		tempMenu = (Menu) md.invoke(headerTabPanel, null);
            		tempMenuItem = (MenuItem)tempMenu.getMainMenu();
            		tempMenuItemList.add(tempMenuItem);
            	} catch(Exception e) {
            		e.printStackTrace(); 
            		}
            		//System.exit(0);
            }
            
		}
		if (null == this.getPrimaryCategoryCodeItems()) {
			if (null != tempMenuItemList && tempMenuItemList.size() > 0) {
				SelectItem[] tempCategoryCodeItems = new SelectItem[tempMenuItemList.size()];
				for (int i = 0; i< tempMenuItemList.size() ; i++) {
					MenuItem tempMenuItem = tempMenuItemList.get(i);
					tempCategoryCodeItems[i] = new SelectItem(tempMenuItem.getIdFirst(),tempMenuItem.getLabel(),tempMenuItem.getName());
				}
				this.setPrimaryCategoryCodeItems(tempCategoryCodeItems);
			}
		}
	}

}

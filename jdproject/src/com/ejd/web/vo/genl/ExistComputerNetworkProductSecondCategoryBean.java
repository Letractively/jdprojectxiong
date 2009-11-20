package com.ejd.web.vo.genl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.CommonConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.Menu;
import com.ejd.web.vo.richfaces.header.MenuItem;

/*this bean is common ,it is according param to create bean*/
public class ExistComputerNetworkProductSecondCategoryBean {
	
	private String beanName;
	
	private SelectItem[] secondCategoryCodeItems = null;

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public SelectItem[] getSecondCategoryCodeItems() {
		return secondCategoryCodeItems;
	}

	public void setSecondCategoryCodeItems(SelectItem[] secondCategoryCodeItems) {
		this.secondCategoryCodeItems = secondCategoryCodeItems;
	}
	
	public ExistComputerNetworkProductSecondCategoryBean() {
		if (null == this.getBeanName() || "".equals(this.getBeanName())) {
			this.setBeanName("computerNetwork");
		}
		HeaderTabPanelBean headerTabPanel = (HeaderTabPanelBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.HEADER_TABPANEL_BEAN_NAME);
		java.beans.PropertyDescriptor origDescriptors[] = org.apache.commons.beanutils.PropertyUtils.getPropertyDescriptors(headerTabPanel);
		List<MenuItem> tempMenuItemList = new ArrayList<MenuItem>();
		for   (int i = 0; i < origDescriptors.length; i++) {   
            String name = origDescriptors[i].getName();   
            java.beans.PropertyDescriptor tempPropertyDescriptor =origDescriptors[i];
            String className= tempPropertyDescriptor.getPropertyType().getName();
            if ((CommonConstants.COM_EJD_WEB_VO_RICHFACES_HEADER_MENU.equals(className)) && (name.equals(this.getBeanName()))) {
            	MenuItem tempMenuItem = new MenuItem();
            	Class cl = headerTabPanel.getClass();
            	Menu tempMenu= new Menu();
            	Method md = tempPropertyDescriptor.getReadMethod();
            	try {
            		tempMenu = (Menu) md.invoke(headerTabPanel, null);
            		tempMenuItemList = tempMenu.getSubMenu();
            	} catch(Exception e) {
            		e.printStackTrace(); 
            		}
            		//System.exit(0);
            	break;
            }
            
		}
		if (null == this.getSecondCategoryCodeItems()) {
			if (null != tempMenuItemList && tempMenuItemList.size() > 0) {
				SelectItem[] tempCategoryCodeItems = new SelectItem[tempMenuItemList.size()];
				for (int i = 0; i< tempMenuItemList.size() ; i++) {
					MenuItem tempMenuItem = tempMenuItemList.get(i);
					tempCategoryCodeItems[i] = new SelectItem(tempMenuItem.getIdSecond(),tempMenuItem.getLabel(),tempMenuItem.getName());
				}
				this.setSecondCategoryCodeItems(tempCategoryCodeItems);
			}
		}
	}

}

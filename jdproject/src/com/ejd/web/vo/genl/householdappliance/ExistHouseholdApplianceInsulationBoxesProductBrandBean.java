package com.ejd.web.vo.genl.householdappliance;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.ProductException;
import com.ejd.model.service.iface.IProductService;
import com.ejd.utils.HeaderMenuUtil;
import com.ejd.utils.ProductBrandUtil;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class ExistHouseholdApplianceInsulationBoxesProductBrandBean {
	private SelectItem[] brandCodeItems;

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public void setBrandCodeItems(SelectItem[] brandCodeItems) {
		this.brandCodeItems = brandCodeItems;
	}
	
	public ExistHouseholdApplianceInsulationBoxesProductBrandBean() {
		IProductService productService = (IProductService) SpringFacesUtil.getSpringBean("productService");
		List<String> brandList =  new ArrayList<String>();
		HeaderTabPanelBean headerTabPanel = (HeaderTabPanelBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.HEADER_TABPANEL_BEAN_NAME);
		List<MenuItem> subMenu = headerTabPanel.getHouseholdAppliance().getSubMenu();
		MenuItem paraItem = HeaderMenuUtil.getMenuItemByName(HeaderConstants.HOUSEHOLD_APPLIANCE_INSULATIONBOXES_NAME, subMenu);
		try {
			brandList = productService.getBrandCodeListByCategory(paraItem.getIdFirst(), paraItem.getIdSecond());
		} catch (ProductException e) {
			
		}
		ProductBrandUtil productBrandUtil = (ProductBrandUtil) SpringFacesUtil.getSpringBean("productBrandUtil");
		SelectItem[] result = null;
		result = productBrandUtil.getBrandCodeItem(brandList);
		this.setBrandCodeItems(result);
	}

}

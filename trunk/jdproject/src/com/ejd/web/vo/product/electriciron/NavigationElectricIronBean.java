package com.ejd.web.vo.product.electriciron;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistDisinfectionCabinetTypeBean;
import com.ejd.web.vo.genl.ExistElectricFanSetTypeBean;
import com.ejd.web.vo.genl.ExistElectricIronSteamTypeBean;
import com.ejd.web.vo.genl.ExistElectricPressureCookerControlTypeBean;
import com.ejd.web.vo.genl.householdappliance.ExistHouseholdApplianceElectricFanProductBrandBean;
import com.ejd.web.vo.genl.householdappliance.ExistHouseholdApplianceElectricIronProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceDisinfectionCabinetProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricPressureCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationElectricIronBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] steamTypeItems;
	

	public NavigationElectricIronBean () {
		ExistHouseholdApplianceElectricIronProductBrandBean existElectricIronProductBrand = (ExistHouseholdApplianceElectricIronProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_HOUSEHOLD_APPLIANCE_ELECTRIC_IRON_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existElectricIronProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(99),"<=99.9"));
		tempPriceRange.add(new RangeParam(new Double(100),new Double(199.9),"100-199.9"));
		tempPriceRange.add(new RangeParam(new Double(200),new Double(299.9),"200-299.9"));
		tempPriceRange.add(new RangeParam(new Double(300),new Double(399.9),"300-399.9"));
		tempPriceRange.add(new RangeParam(new Double(400),new Double(499.9),"400-499.9"));
		tempPriceRange.add(new RangeParam(new Double(500),null,">=500"));
		this.setPriceRangeList(tempPriceRange);
		ExistElectricIronSteamTypeBean existElectricIronType = (ExistElectricIronSteamTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_ELECTRIC_IRON_STEAM_TYPE_BEAN_NAME);
		SelectItem[] steamTypeItems = existElectricIronType.getSteamTypeItems();
		this.setSteamTypeItems(steamTypeItems);
	}
	
public List<RangeParam> getPriceRangeList() {
		return priceRangeList;
	}

	public void setPriceRangeList(List<RangeParam> priceRangeList) {
		this.priceRangeList = priceRangeList;
	}

	public SelectItem[] getSteamTypeItems() {
		return steamTypeItems;
	}

	public void setSteamTypeItems(SelectItem[] steamTypeItems) {
		this.steamTypeItems = steamTypeItems;
	}

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public void setBrandCodeItems(SelectItem[] brandCodeItems) {
		this.brandCodeItems = brandCodeItems;
	}

public String clickLink() {
		
		Object brandCode = SpringFacesUtil.getRequestParameter("brandCode");
		Object brandLabel = SpringFacesUtil.getRequestParameter("brandLabel");
		Object priceRangeMin = SpringFacesUtil.getRequestParameter("priceRangeMin");
		Object priceRangeMax = SpringFacesUtil.getRequestParameter("priceRangeMax");
		Object priceRangeLabel = SpringFacesUtil.getRequestParameter("priceRangeLabel");
		Object steamTypeItem = SpringFacesUtil.getRequestParameter("steamTypeItem");
		Object steamTypeItemLabel = SpringFacesUtil.getRequestParameter("steamTypeItemLabel");
		ElectricIronProductBean listElectricIronProduct = (ElectricIronProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_ELECTRIC_IRON_PRODUCT_BEAN_NAME);
		listElectricIronProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listElectricIronProduct.setPriceRange(priceRange);
			listElectricIronProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		if (null != brandCode) {
			listElectricIronProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listElectricIronProduct.setBrandLabel((String)brandLabel);
		}
		if (null != steamTypeItem) {
			listElectricIronProduct.setSteamTypeItems((String)steamTypeItem);
		}
		if (null != steamTypeItemLabel) {
			listElectricIronProduct.setSteamTypeItemsLabel((String)steamTypeItemLabel);
		}
		return null;
	}

}

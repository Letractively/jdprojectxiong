package com.ejd.web.vo.product.vacuumcleaner;

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
import com.ejd.web.vo.genl.ExistVacuumCleanerPowerSupplyTypeBean;
import com.ejd.web.vo.genl.ExistVacuumCleanerUseTypeBean;
import com.ejd.web.vo.genl.householdappliance.ExistHouseholdApplianceElectricFanProductBrandBean;
import com.ejd.web.vo.genl.householdappliance.ExistHouseholdApplianceElectricIronProductBrandBean;
import com.ejd.web.vo.genl.householdappliance.ExistHouseholdApplianceVacuumCleanerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceDisinfectionCabinetProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricPressureCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationVacuumCleanerBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] powerSupplyTypeItems;
	
	private SelectItem[] useTypeItems;
	

	public NavigationVacuumCleanerBean () {
		ExistHouseholdApplianceVacuumCleanerProductBrandBean existVacuumCleanerProductBrand = (ExistHouseholdApplianceVacuumCleanerProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_HOUSEHOLD_APPLIANCE_VACUUM_CLEANER_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existVacuumCleanerProductBrand.getBrandCodeItems();
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
		ExistVacuumCleanerPowerSupplyTypeBean VacuumCleanerPowerSupplyType = (ExistVacuumCleanerPowerSupplyTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_VACUUM_CLEANER_POWER_SUPPLY_TYPE_BEAN_NAME);
		SelectItem[] powerSupplyTypeItems = VacuumCleanerPowerSupplyType.getPowerSupplyTypeItems();
		this.setPowerSupplyTypeItems(powerSupplyTypeItems);
		ExistVacuumCleanerUseTypeBean existVacuumCleanerUseType = (ExistVacuumCleanerUseTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_VACUUM_CLEANER_USE_TYPE_BEAN_NAME);
		SelectItem[] useTypeItems = existVacuumCleanerUseType.getUseTypeItems();
		this.setUseTypeItems(useTypeItems);
	}
	
public List<RangeParam> getPriceRangeList() {
		return priceRangeList;
	}

	public void setPriceRangeList(List<RangeParam> priceRangeList) {
		this.priceRangeList = priceRangeList;
	}
	
	public SelectItem[] getPowerSupplyTypeItems() {
		return powerSupplyTypeItems;
	}

	public void setPowerSupplyTypeItems(SelectItem[] powerSupplyTypeItems) {
		this.powerSupplyTypeItems = powerSupplyTypeItems;
	}

	public SelectItem[] getUseTypeItems() {
		return useTypeItems;
	}

	public void setUseTypeItems(SelectItem[] useTypeItems) {
		this.useTypeItems = useTypeItems;
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
		Object powerSupplyTypeItem = SpringFacesUtil.getRequestParameter("powerSupplyTypeItem");
		Object powerSupplyTypeItemLabel = SpringFacesUtil.getRequestParameter("powerSupplyTypeItemLabel");
		Object useTypeItem = SpringFacesUtil.getRequestParameter("useTypeItem");
		Object useTypeItemLabel = SpringFacesUtil.getRequestParameter("useTypeItemLabel");
		VacuumCleanerProductBean listVacuumCleanerProduct = (VacuumCleanerProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_VACUUM_CLEANER_PRODUCT_BEAN_NAME);
		listVacuumCleanerProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listVacuumCleanerProduct.setPriceRange(priceRange);
			listVacuumCleanerProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		if (null != brandCode) {
			listVacuumCleanerProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listVacuumCleanerProduct.setBrandLabel((String)brandLabel);
		}
		if (null != powerSupplyTypeItem) {
			listVacuumCleanerProduct.setPowerSupplyTypeItems((String)powerSupplyTypeItem);
		}
		if (null != powerSupplyTypeItemLabel) {
			listVacuumCleanerProduct.setPowerSupplyTypeItemsLabel((String)powerSupplyTypeItemLabel);
		}
		if (null != useTypeItem) {
			listVacuumCleanerProduct.setUseTypeItems((String)useTypeItem);
		}
		if (null != useTypeItemLabel) {
			listVacuumCleanerProduct.setUseTypeItemsLabel((String)useTypeItemLabel);
		}
		return null;
	}

}

package com.ejd.web.vo.product.electricfan;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistDisinfectionCabinetTypeBean;
import com.ejd.web.vo.genl.ExistElectricFanSetTypeBean;
import com.ejd.web.vo.genl.ExistElectricPressureCookerControlTypeBean;
import com.ejd.web.vo.genl.householdappliance.ExistHouseholdApplianceElectricFanProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceDisinfectionCabinetProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricPressureCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationElectricFanBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> powerRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> gearsRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] setTypeItems;
	

	public NavigationElectricFanBean () {
		ExistHouseholdApplianceElectricFanProductBrandBean existElectricFanProductBrand = (ExistHouseholdApplianceElectricFanProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_HOUSEHOLD_APPLIANCE_ELECTRIC_FAN_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existElectricFanProductBrand.getBrandCodeItems();
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
		List<RangeParam> tempGearsRange = new ArrayList<RangeParam>();
		tempGearsRange.add(new RangeParam(null,null,"全部"));
		tempGearsRange.add(new RangeParam(new Double(0),new Double(3),"3档及以下"));
		tempGearsRange.add(new RangeParam(new Double(4),new Double(4),"4档"));
		tempGearsRange.add(new RangeParam(new Double(5),null,"5档及以上"));
		this.setGearsRangeList(tempGearsRange);
		List<RangeParam> tempPowerRange = new ArrayList<RangeParam>();
		tempPowerRange.add(new RangeParam(null,null,"全部"));
		tempPowerRange.add(new RangeParam(new Double(0),new Double(40),"40瓦及以下"));
		tempPowerRange.add(new RangeParam(new Double(41),new Double(65),"41-65W"));
		tempPowerRange.add(new RangeParam(new Double(66),new Double(90),"66-90W"));
		tempPowerRange.add(new RangeParam(new Double(91),null,"90瓦以上"));
		this.setPowerRangeList(tempPowerRange);
		ExistElectricFanSetTypeBean existElectricFanSetType = (ExistElectricFanSetTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_ELECTRIC_FAN_SET_TYPE_BEAN_NAME);
		SelectItem[] setTypeItems = existElectricFanSetType.getSetTypeItems();
		this.setSetTypeItems(setTypeItems);
	}
	
public List<RangeParam> getPriceRangeList() {
		return priceRangeList;
	}

	public void setPriceRangeList(List<RangeParam> priceRangeList) {
		this.priceRangeList = priceRangeList;
	}

	public List<RangeParam> getGearsRangeList() {
		return gearsRangeList;
	}

	public void setGearsRangeList(List<RangeParam> gearsRangeList) {
		this.gearsRangeList = gearsRangeList;
	}

	public List<RangeParam> getPowerRangeList() {
		return powerRangeList;
	}

	public void setPowerRangeList(List<RangeParam> powerRangeList) {
		this.powerRangeList = powerRangeList;
	}

	public SelectItem[] getSetTypeItems() {
		return setTypeItems;
	}

	public void setSetTypeItems(SelectItem[] setTypeItems) {
		this.setTypeItems = setTypeItems;
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
		Object gearsRangeMin = SpringFacesUtil.getRequestParameter("gearsRangeMin");
		Object gearsRangeMax = SpringFacesUtil.getRequestParameter("gearsRangeMax");
		Object gearsRangeLabel = SpringFacesUtil.getRequestParameter("gearsRangeLabel");
		Object powerRangeMin = SpringFacesUtil.getRequestParameter("powerRangeMin");
		Object powerRangeMax = SpringFacesUtil.getRequestParameter("powerRangeMax");
		Object powerRangeLabel = SpringFacesUtil.getRequestParameter("powerRangeLabel");
		
		Object setTypeItem = SpringFacesUtil.getRequestParameter("setTypeItem");
		Object setTypeItemLabel = SpringFacesUtil.getRequestParameter("setTypeItemLabel");
		ElectricFanProductBean listElectricFanProduct = (ElectricFanProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_ELECTRIC_FAN_PRODUCT_BEAN_NAME);
		listElectricFanProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listElectricFanProduct.setPriceRange(priceRange);
			listElectricFanProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		RangeParam gearsRange = new RangeParam();
		gearsRange.setMin(null == gearsRangeMin?null:("".equals(gearsRangeMin)?null:new Double(gearsRangeMin.toString())));
		gearsRange.setMax(null == gearsRangeMax?null:("".equals(gearsRangeMax)?null:new Double(gearsRangeMax.toString())));
		gearsRange.setDescription(null == gearsRangeLabel?"全部":("".equals(gearsRangeLabel)?"全部":gearsRangeLabel.toString()));
		if (null != gearsRangeMin || null != gearsRangeMax) {
			listElectricFanProduct.setGearsRange(gearsRange);
			listElectricFanProduct.setGearsRangeLabel(gearsRange.getDescription());
		}
		RangeParam powerRange = new RangeParam();
		powerRange.setMin(null == powerRangeMin?null:("".equals(powerRangeMin)?null:new Double(powerRangeMin.toString())));
		powerRange.setMax(null == powerRangeMax?null:("".equals(powerRangeMax)?null:new Double(powerRangeMax.toString())));
		powerRange.setDescription(null == powerRangeLabel?"全部":("".equals(powerRangeLabel)?"全部":powerRangeLabel.toString()));
		if (null != powerRangeMin || null != powerRangeMax) {
			listElectricFanProduct.setPowerRange(powerRange);
			listElectricFanProduct.setPowerRangeLabel(powerRange.getDescription());
		}
		if (null != brandCode) {
			listElectricFanProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listElectricFanProduct.setBrandLabel((String)brandLabel);
		}
		if (null != setTypeItem) {
			listElectricFanProduct.setSetTypeItems((String)setTypeItem);
		}
		if (null != setTypeItemLabel) {
			listElectricFanProduct.setSetTypeItemsLabel((String)setTypeItemLabel);
		}
		
		
		return null;
	}

}

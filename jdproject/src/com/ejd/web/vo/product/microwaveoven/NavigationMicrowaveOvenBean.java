package com.ejd.web.vo.product.microwaveoven;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistElectricPressureCookerControlTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricPressureCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceMicrowaveOvenProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationMicrowaveOvenBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> volumeRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] controlTypeItems;
	

	public NavigationMicrowaveOvenBean () {
		ExistKitchenApplianceMicrowaveOvenProductBrandBean existKitchenApplianceMicrowaveOvenProductBrand = (ExistKitchenApplianceMicrowaveOvenProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_MICROWAVE_OVEN_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceMicrowaveOvenProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(99),"<=399"));
		tempPriceRange.add(new RangeParam(new Double(399.1),new Double(599.9),"399.1-599.9"));
		tempPriceRange.add(new RangeParam(new Double(599),new Double(799.9),"599.1-799.9"));
		tempPriceRange.add(new RangeParam(new Double(800),null,">=800"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempVolumeRange = new ArrayList<RangeParam>();
		tempVolumeRange.add(new RangeParam(null,null,"全部"));
		tempVolumeRange.add(new RangeParam(new Double(0),new Double(22),"<=22"));
		tempVolumeRange.add(new RangeParam(new Double(22.1),new Double(25),"22.1-25"));
		tempVolumeRange.add(new RangeParam(new Double(25.1),null,">=25.1"));
		this.setVolumeRangeList(tempVolumeRange);
		ExistElectricPressureCookerControlTypeBean existElectricPressureCookerControlType = (ExistElectricPressureCookerControlTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_ELECTRIC_PRESSURE_COOKER_CONTROL_TYPE_BEAN_NAME);
		SelectItem[] controlTypeItems = existElectricPressureCookerControlType.getControlTypeItems();
		this.setControlTypeItems(controlTypeItems);
	}
	
public List<RangeParam> getPriceRangeList() {
		return priceRangeList;
	}

	public void setPriceRangeList(List<RangeParam> priceRangeList) {
		this.priceRangeList = priceRangeList;
	}

	public List<RangeParam> getVolumeRangeList() {
		return volumeRangeList;
	}

	public void setVolumeRangeList(List<RangeParam> volumeRangeList) {
		this.volumeRangeList = volumeRangeList;
	}

	public SelectItem[] getControlTypeItems() {
		return controlTypeItems;
	}

	public void setControlTypeItems(SelectItem[] controlTypeItems) {
		this.controlTypeItems = controlTypeItems;
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
		Object volumeRangeMin = SpringFacesUtil.getRequestParameter("volumeRangeMin");
		Object volumeRangeMax = SpringFacesUtil.getRequestParameter("volumeRangeMax");
		Object volumeRangeLabel = SpringFacesUtil.getRequestParameter("volumeRangeLabel");
		Object controlType = SpringFacesUtil.getRequestParameter("controlType");
		Object controlTypeLabel = SpringFacesUtil.getRequestParameter("controlTypeLabel");
		MicrowaveOvenProductBean listMicrowaveOvenProduct = (MicrowaveOvenProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_MICROWAVE_OVEN_PRODUCT_BEAN_NAME);
		listMicrowaveOvenProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listMicrowaveOvenProduct.setPriceRange(priceRange);
			listMicrowaveOvenProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		RangeParam volumeRange = new RangeParam();
		volumeRange.setMin(null == volumeRangeMin?null:("".equals(volumeRangeMin)?null:new Double(volumeRangeMin.toString())));
		volumeRange.setMax(null == volumeRangeMax?null:("".equals(volumeRangeMax)?null:new Double(volumeRangeMax.toString())));
		volumeRange.setDescription(null == volumeRangeLabel?"全部":("".equals(volumeRangeLabel)?"全部":volumeRangeLabel.toString()));
		if (null != volumeRangeMin || null != volumeRangeMax) {
			listMicrowaveOvenProduct.setVolumeRange(volumeRange);
			listMicrowaveOvenProduct.setVolumeRangeLabel(volumeRange.getDescription());
		}
		if (null != brandCode) {
			listMicrowaveOvenProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listMicrowaveOvenProduct.setBrandLabel((String)brandLabel);
		}
		if (null != controlType) {
			listMicrowaveOvenProduct.setControlType((String)controlType);
		}
		if (null != controlTypeLabel) {
			listMicrowaveOvenProduct.setControlTypeLabel((String)controlTypeLabel);
		}
		return null;
	}

}

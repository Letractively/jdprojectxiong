package com.ejd.web.vo.product.electricpressurecooker;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistElectricPressureCookerControlTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricPressureCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationElectricPressureCookerBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> volumeRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] controlTypeItems;
	

	public NavigationElectricPressureCookerBean () {
		ExistKitchenApplianceElectricPressureCookerProductBrandBean existKitchenApplianceElectricPressureCookerProductBrand = (ExistKitchenApplianceElectricPressureCookerProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_ELECTRIC_PRESSURE_COOKER_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceElectricPressureCookerProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(99),"<=299"));
		tempPriceRange.add(new RangeParam(new Double(299),new Double(399),"299-399"));
		tempPriceRange.add(new RangeParam(new Double(399),new Double(499),"399-499"));
		tempPriceRange.add(new RangeParam(new Double(500),null,">=500"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempVolumeRange = new ArrayList<RangeParam>();
		tempVolumeRange.add(new RangeParam(null,null,"全部"));
		tempVolumeRange.add(new RangeParam(new Double(0),new Double(3),"<=3"));
		tempVolumeRange.add(new RangeParam(new Double(3),new Double(4),"3-4"));
		tempVolumeRange.add(new RangeParam(new Double(4),new Double(5),"4-5"));
		tempVolumeRange.add(new RangeParam(new Double(5),new Double(6),"5-6"));
		tempVolumeRange.add(new RangeParam(new Double(6),null,">=6"));
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
		ElectricPressureCookerProductBean listElectricPressureCookerProduct = (ElectricPressureCookerProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_ELECTRIC_PRESSURE_COOKER_PRODUCT_BEAN_NAME);
		listElectricPressureCookerProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listElectricPressureCookerProduct.setPriceRange(priceRange);
			listElectricPressureCookerProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		RangeParam volumeRange = new RangeParam();
		volumeRange.setMin(null == volumeRangeMin?null:("".equals(volumeRangeMin)?null:new Double(volumeRangeMin.toString())));
		volumeRange.setMax(null == volumeRangeMax?null:("".equals(volumeRangeMax)?null:new Double(volumeRangeMax.toString())));
		volumeRange.setDescription(null == volumeRangeLabel?"全部":("".equals(volumeRangeLabel)?"全部":volumeRangeLabel.toString()));
		if (null != volumeRangeMin || null != volumeRangeMax) {
			listElectricPressureCookerProduct.setVolumeRange(volumeRange);
			listElectricPressureCookerProduct.setVolumeRangeLabel(volumeRange.getDescription());
		}
		if (null != brandCode) {
			listElectricPressureCookerProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listElectricPressureCookerProduct.setBrandLabel((String)brandLabel);
		}
		if (null != controlType) {
			listElectricPressureCookerProduct.setControlType((String)controlType);
		}
		if (null != controlTypeLabel) {
			listElectricPressureCookerProduct.setControlTypeLabel((String)controlTypeLabel);
		}
		
		
		return null;
	}

}

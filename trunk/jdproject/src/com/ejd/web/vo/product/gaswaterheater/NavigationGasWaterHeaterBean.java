package com.ejd.web.vo.product.gaswaterheater;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;


import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistGasStoveFitTypeBean;
import com.ejd.web.vo.genl.ExistGasStoveGasTypeBean;
import com.ejd.web.vo.genl.ExistGasWaterHeaterSmokeTypeBean;
import com.ejd.web.vo.genl.ExistToasterTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceGasStoveProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceGasWaterHeaterProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceToasterProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;

public class NavigationGasWaterHeaterBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> volumeRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> yieldRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] gasTypeItems = null;
	
	private SelectItem[] smokeTypeItems = null;

	public NavigationGasWaterHeaterBean () {
		ExistKitchenApplianceGasWaterHeaterProductBrandBean existKitchenApplianceGasWaterHeaterProductBrand = (ExistKitchenApplianceGasWaterHeaterProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_GAS_WATER_HEATER_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceGasWaterHeaterProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		//get gasTypeItems
		ExistGasStoveGasTypeBean existGasStoveGasTypeType = (ExistGasStoveGasTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_GAS_STOVE_GAS_TYPE_BEAN_NAME);
		SelectItem[] gasTypeItems = null;
		gasTypeItems = existGasStoveGasTypeType.getGasTypeItems();
		this.setGasTypeItems(gasTypeItems);
		//end
		//get smokeTypeItems
		ExistGasWaterHeaterSmokeTypeBean existGasWaterHeaterSmokeTypeType = (ExistGasWaterHeaterSmokeTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_GAS_WATER_HEATER_SMOKE_TYPE_BEAN_NAME);
		SelectItem[] smokeTypeItems = null;
		smokeTypeItems = existGasWaterHeaterSmokeTypeType.getSmokeTypeItems();
		this.setSmokeTypeItems(smokeTypeItems);
		//end
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(499.9),"<500"));
		tempPriceRange.add(new RangeParam(new Double(500),new Double(999.9),"500-999.9"));
		tempPriceRange.add(new RangeParam(new Double(1000),new Double(1499.9),"1000-1499.9"));
		tempPriceRange.add(new RangeParam(new Double(1500),new Double(1999.9),"1500-1999.9"));
		tempPriceRange.add(new RangeParam(new Double(2000),new Double(2999.9),"2000-2999.9"));
		tempPriceRange.add(new RangeParam(new Double(3000),null,">=3000"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempVolumeRange = new ArrayList<RangeParam>();
		tempVolumeRange.add(new RangeParam(null,null,"全部"));
		tempVolumeRange.add(new RangeParam(new Double(0),new Double(5),"5L及以下"));
		tempVolumeRange.add(new RangeParam(new Double(5.1),new Double(8),"5.1-8L"));
		tempVolumeRange.add(new RangeParam(new Double(8.1),new Double(10),"8.1-10L"));
		tempVolumeRange.add(new RangeParam(new Double(10.1),new Double(12),"10.1-12L"));
		tempVolumeRange.add(new RangeParam(new Double(12.1),null,"12.1及以上"));
		this.setVolumeRangeList(tempVolumeRange);
		List<RangeParam> tempYieldRange = new ArrayList<RangeParam>();
		tempYieldRange.add(new RangeParam(null,null,"全部"));
		tempYieldRange.add(new RangeParam(new Double(0),new Double(5),"5L及以下"));
		tempYieldRange.add(new RangeParam(new Double(5.1),new Double(10),"5.1-10"));
		tempYieldRange.add(new RangeParam(new Double(10.1),new Double(20),"10.1-20"));
		tempYieldRange.add(new RangeParam(new Double(20),null,"20及以上"));
		this.setYieldRangeList(tempYieldRange);
		
	}
	
public List<RangeParam> getPriceRangeList() {
		return priceRangeList;
	}

	public void setPriceRangeList(List<RangeParam> priceRangeList) {
		this.priceRangeList = priceRangeList;
	}

	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}

	public void setBrandCodeItems(SelectItem[] brandCodeItems) {
		this.brandCodeItems = brandCodeItems;
	}
	

	public List<RangeParam> getVolumeRangeList() {
		return volumeRangeList;
	}

	public void setVolumeRangeList(List<RangeParam> volumeRangeList) {
		this.volumeRangeList = volumeRangeList;
	}
	

	public List<RangeParam> getYieldRangeList() {
		return yieldRangeList;
	}

	public void setYieldRangeList(List<RangeParam> yieldRangeList) {
		this.yieldRangeList = yieldRangeList;
	}

	public SelectItem[] getGasTypeItems() {
		return gasTypeItems;
	}

	public void setGasTypeItems(SelectItem[] gasTypeItems) {
		this.gasTypeItems = gasTypeItems;
	}
	
	public SelectItem[] getSmokeTypeItems() {
		return smokeTypeItems;
	}

	public void setSmokeTypeItems(SelectItem[] smokeTypeItems) {
		this.smokeTypeItems = smokeTypeItems;
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
		Object yieldRangeMin = SpringFacesUtil.getRequestParameter("yieldRangeMin");
		Object yieldRangeMax = SpringFacesUtil.getRequestParameter("yieldRangeMax");
		Object yieldRangeLabel = SpringFacesUtil.getRequestParameter("yieldRangeLabel");
		Object gasType = SpringFacesUtil.getRequestParameter("gasType");
		Object gasTypeLabel = SpringFacesUtil.getRequestParameter("gasTypeLabel");
		Object smokeType = SpringFacesUtil.getRequestParameter("smokeType");
		Object smokeTypeLabel = SpringFacesUtil.getRequestParameter("smokeTypeLabel");
		GasWaterHeaterProductBean listGasWaterHeaterProduct = (GasWaterHeaterProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_GAS_WATER_HEATER_PRODUCT_BEAN_NAME);
		listGasWaterHeaterProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listGasWaterHeaterProduct.setPriceRange(priceRange);
			listGasWaterHeaterProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		RangeParam volumeRange = new RangeParam();
		volumeRange.setMin(null == volumeRangeMin?null:("".equals(volumeRangeMin)?null:new Double(volumeRangeMin.toString())));
		volumeRange.setMax(null == volumeRangeMax?null:("".equals(volumeRangeMax)?null:new Double(volumeRangeMax.toString())));
		volumeRange.setDescription(null == volumeRangeLabel?"全部":("".equals(volumeRangeLabel)?"全部":volumeRangeLabel.toString()));
		if (null != volumeRangeMin || null != volumeRangeMax) {
			listGasWaterHeaterProduct.setVolumeRange(volumeRange);
			listGasWaterHeaterProduct.setVolumeRangeLabel(volumeRange.getDescription());
		}
		RangeParam yieldRange = new RangeParam();
		yieldRange.setMin(null == yieldRangeMin?null:("".equals(yieldRangeMin)?null:new Double(yieldRangeMin.toString())));
		yieldRange.setMax(null == yieldRangeMax?null:("".equals(yieldRangeMax)?null:new Double(yieldRangeMax.toString())));
		yieldRange.setDescription(null == yieldRangeLabel?"全部":("".equals(yieldRangeLabel)?"全部":yieldRangeLabel.toString()));
		if (null != yieldRangeMin || null != yieldRangeMax) {
			listGasWaterHeaterProduct.setYieldRange(yieldRange);
			listGasWaterHeaterProduct.setYieldRangeLabel(yieldRange.getDescription());
		}
		if (null != brandCode) {
			listGasWaterHeaterProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listGasWaterHeaterProduct.setBrandLabel((String)brandLabel);
		}
		if (null != gasType) {
			listGasWaterHeaterProduct.setGasType((String)gasType);
		}
		if (null != gasTypeLabel) {
			listGasWaterHeaterProduct.setGasTypeLabel((String)gasTypeLabel);
		}
		if (null != smokeType) {
			listGasWaterHeaterProduct.setSmokeType((String)smokeType);
		}
		if (null != smokeTypeLabel) {
			listGasWaterHeaterProduct.setSmokeTypeLabel((String)smokeTypeLabel);
		}
		
		return null;
	}

}

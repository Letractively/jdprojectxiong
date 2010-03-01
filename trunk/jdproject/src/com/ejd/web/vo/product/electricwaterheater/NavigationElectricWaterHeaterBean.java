package com.ejd.web.vo.product.electricwaterheater;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistDisinfectionCabinetTypeBean;
import com.ejd.web.vo.genl.ExistElectricPressureCookerControlTypeBean;
import com.ejd.web.vo.genl.ExistElectricWaterHeaterSetTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceDisinfectionCabinetProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricPressureCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricWaterHeaterProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationElectricWaterHeaterBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> volumeRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> powerRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> pressureRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] setTypeItems;
	

	public NavigationElectricWaterHeaterBean () {
		ExistKitchenApplianceElectricWaterHeaterProductBrandBean existElectricWaterHeaterProductBrand = (ExistKitchenApplianceElectricWaterHeaterProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_ELECTRIC_WATER_HEATER_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existElectricWaterHeaterProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(999),"<=999.9"));
		tempPriceRange.add(new RangeParam(new Double(1000),new Double(1499.9),"1000-1499.9"));
		tempPriceRange.add(new RangeParam(new Double(1500),new Double(1999.9),"1500-1999.9"));
		tempPriceRange.add(new RangeParam(new Double(2000),new Double(2999.9),"2000-2999.9"));
		tempPriceRange.add(new RangeParam(new Double(3000),null,">=3000"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempVolumeRange = new ArrayList<RangeParam>();
		tempVolumeRange.add(new RangeParam(null,null,"全部"));
		tempVolumeRange.add(new RangeParam(new Double(0),new Double(10),"10L及以下"));
		tempVolumeRange.add(new RangeParam(new Double(11),new Double(20),"11-20"));
		tempVolumeRange.add(new RangeParam(new Double(21),new Double(30),"21-30"));
		tempVolumeRange.add(new RangeParam(new Double(31),new Double(40),"31-40"));
		tempVolumeRange.add(new RangeParam(new Double(41),new Double(50),"41-50"));
		tempVolumeRange.add(new RangeParam(new Double(51),new Double(60),"51-60"));
		tempVolumeRange.add(new RangeParam(new Double(61),new Double(70),"61-70"));
		tempVolumeRange.add(new RangeParam(new Double(71),new Double(80),"71-80"));
		tempVolumeRange.add(new RangeParam(new Double(81),null,"81L及以上"));
		this.setVolumeRangeList(tempVolumeRange);
		List<RangeParam> tempPowerRange = new ArrayList<RangeParam>();
		tempPowerRange.add(new RangeParam(null,null,"全部"));
		tempPowerRange.add(new RangeParam(new Double(0),new Double(1000),"1000W及以下"));
		tempPowerRange.add(new RangeParam(new Double(1001),new Double(2000),"1001-2000W"));
		tempPowerRange.add(new RangeParam(new Double(2001),new Double(3000),"2001-3000W"));
		tempPowerRange.add(new RangeParam(new Double(3001),null,"3001W及以上"));
		this.setPowerRangeList(tempPowerRange);
		List<RangeParam> tempPressureRange = new ArrayList<RangeParam>();
		tempPressureRange.add(new RangeParam(null,null,"全部"));
		tempPressureRange.add(new RangeParam(new Double(0),new Double(0.5),"0.5Mpa"));
		tempPressureRange.add(new RangeParam(new Double(0.51),new Double(0.75),"0.51-0.75Mpa"));
		tempPressureRange.add(new RangeParam(new Double(0.76),new Double(1.01),"0.76-1.01Mpa"));
		tempPressureRange.add(new RangeParam(new Double(1.02),null,"1.02Mpa及以上"));
		this.setPressureRangeList(tempPressureRange);
		ExistElectricWaterHeaterSetTypeBean existElectricWaterHeaterSetType = (ExistElectricWaterHeaterSetTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_ELECTRIC_WATER_HEATER_SET_TYPE_BEAN_NAME);
		SelectItem[] setTypeItems = existElectricWaterHeaterSetType.getSetTypeItems();
		this.setSetTypeItems(setTypeItems);
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

	public List<RangeParam> getPowerRangeList() {
		return powerRangeList;
	}

	public void setPowerRangeList(List<RangeParam> powerRangeList) {
		this.powerRangeList = powerRangeList;
	}

	public List<RangeParam> getPressureRangeList() {
		return pressureRangeList;
	}

	public void setPressureRangeList(List<RangeParam> pressureRangeList) {
		this.pressureRangeList = pressureRangeList;
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
		Object volumeRangeMin = SpringFacesUtil.getRequestParameter("volumeRangeMin");
		Object volumeRangeMax = SpringFacesUtil.getRequestParameter("volumeRangeMax");
		Object volumeRangeLabel = SpringFacesUtil.getRequestParameter("volumeRangeLabel");
		Object powerRangeMin = SpringFacesUtil.getRequestParameter("powerRangeMin");
		Object powerRangeMax = SpringFacesUtil.getRequestParameter("powerRangeMax");
		Object powerRangeLabel = SpringFacesUtil.getRequestParameter("powerRangeLabel");
		Object pressureRangeMin = SpringFacesUtil.getRequestParameter("pressureRangeMin");
		Object pressureRangeMax = SpringFacesUtil.getRequestParameter("pressureRangeMax");
		Object pressureRangeLabel = SpringFacesUtil.getRequestParameter("pressureRangeLabel");
		Object setTypeItem = SpringFacesUtil.getRequestParameter("setTypeItem");
		Object setTypeItemLabel = SpringFacesUtil.getRequestParameter("setTypeItemLabel");
		ElectricWaterHeaterProductBean listElectricWaterHeaterProduct = (ElectricWaterHeaterProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_ELECTRIC_WATER_HEATER_PRODUCT_BEAN_NAME);
		listElectricWaterHeaterProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		listElectricWaterHeaterProduct.setPriceRange(priceRange);
		listElectricWaterHeaterProduct.setPriceRangeLabel(priceRange.getDescription());
		RangeParam volumeRange = new RangeParam();
		volumeRange.setMin(null == volumeRangeMin?null:("".equals(volumeRangeMin)?null:new Double(volumeRangeMin.toString())));
		volumeRange.setMax(null == volumeRangeMax?null:("".equals(volumeRangeMax)?null:new Double(volumeRangeMax.toString())));
		volumeRange.setDescription(null == volumeRangeLabel?"全部":("".equals(volumeRangeLabel)?"全部":volumeRangeLabel.toString()));
		listElectricWaterHeaterProduct.setVolumeRange(volumeRange);
		listElectricWaterHeaterProduct.setVolumeRangeLabel(volumeRange.getDescription());
		RangeParam powerRange = new RangeParam();
		powerRange.setMin(null == powerRangeMin?null:("".equals(powerRangeMin)?null:new Double(powerRangeMin.toString())));
		powerRange.setMax(null == powerRangeMax?null:("".equals(powerRangeMax)?null:new Double(powerRangeMax.toString())));
		powerRange.setDescription(null == powerRangeLabel?"全部":("".equals(powerRangeLabel)?"全部":powerRangeLabel.toString()));
		listElectricWaterHeaterProduct.setPowerRange(powerRange);
		listElectricWaterHeaterProduct.setPowerRangeLabel(powerRange.getDescription());
		RangeParam pressureRange = new RangeParam();
		pressureRange.setMin(null == pressureRangeMin?null:("".equals(pressureRangeMin)?null:new Double(pressureRangeMin.toString())));
		pressureRange.setMax(null == pressureRangeMax?null:("".equals(pressureRangeMax)?null:new Double(pressureRangeMax.toString())));
		pressureRange.setDescription(null == pressureRangeLabel?"全部":("".equals(pressureRangeLabel)?"全部":pressureRangeLabel.toString()));
		listElectricWaterHeaterProduct.setPressureRange(pressureRange);
		listElectricWaterHeaterProduct.setPressureRangeLabel(pressureRange.getDescription());
		
		if (null != brandCode) {
			listElectricWaterHeaterProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listElectricWaterHeaterProduct.setBrandLabel((String)brandLabel);
		}
		if (null != setTypeItem) {
			listElectricWaterHeaterProduct.setSetTypeItems((String)setTypeItem);
		}
		if (null != setTypeItemLabel) {
			listElectricWaterHeaterProduct.setSetTypeItemsLabel((String)setTypeItemLabel);
		}
		
		
		return null;
	}

}

package com.ejd.web.vo.product.disinfectioncabinet;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistDisinfectionCabinetTypeBean;
import com.ejd.web.vo.genl.ExistElectricPressureCookerControlTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceDisinfectionCabinetProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricPressureCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationDisinfectionCabinetBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> volumeRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> powerRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] typeItems;
	

	public NavigationDisinfectionCabinetBean () {
		ExistKitchenApplianceDisinfectionCabinetProductBrandBean existDisinfectionCabinetProductBrand = (ExistKitchenApplianceDisinfectionCabinetProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_DISINFECTION_CABINET_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existDisinfectionCabinetProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(999),"<=999.9"));
		tempPriceRange.add(new RangeParam(new Double(1000),new Double(1499.9),"1000-1499.9"));
		tempPriceRange.add(new RangeParam(new Double(1500),new Double(1999.9),"1500-1999.9"));
		tempPriceRange.add(new RangeParam(new Double(2000),null,">=2000"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempVolumeRange = new ArrayList<RangeParam>();
		tempVolumeRange.add(new RangeParam(null,null,"全部"));
		tempVolumeRange.add(new RangeParam(new Double(0),new Double(100),"<=100"));
		tempVolumeRange.add(new RangeParam(new Double(100.1),new Double(300),"100.1-300"));
		tempVolumeRange.add(new RangeParam(new Double(300),null,">=300"));
		this.setVolumeRangeList(tempVolumeRange);
		List<RangeParam> tempPowerRange = new ArrayList<RangeParam>();
		tempPowerRange.add(new RangeParam(null,null,"全部"));
		tempPowerRange.add(new RangeParam(new Double(0),new Double(299.9),"300瓦及以下"));
		tempPowerRange.add(new RangeParam(new Double(300),new Double(499.9),"300-499.9W"));
		tempPowerRange.add(new RangeParam(new Double(500),new Double(1000),"500-1000W"));
		tempPowerRange.add(new RangeParam(new Double(1000.1),null,"1000瓦及以上"));
		this.setPowerRangeList(tempPowerRange);
		ExistDisinfectionCabinetTypeBean existDisinfectionCabinetType = (ExistDisinfectionCabinetTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_DISINFECTION_CABINET_TYPE_BEAN_NAME);
		SelectItem[] typeItems = existDisinfectionCabinetType.getTypeItems();
		this.setTypeItems(typeItems);
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

	public SelectItem[] getTypeItems() {
		return typeItems;
	}

	public void setTypeItems(SelectItem[] typeItems) {
		this.typeItems = typeItems;
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
		
		Object typeItem = SpringFacesUtil.getRequestParameter("typeItem");
		Object typeItemLabel = SpringFacesUtil.getRequestParameter("typeItemLabel");
		DisinfectionCabinetProductBean listDisinfectionCabinetProduct = (DisinfectionCabinetProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_DISINFECTION_CABINET_PRODUCT_BEAN_NAME);
		listDisinfectionCabinetProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listDisinfectionCabinetProduct.setPriceRange(priceRange);
			listDisinfectionCabinetProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		RangeParam volumeRange = new RangeParam();
		volumeRange.setMin(null == volumeRangeMin?null:("".equals(volumeRangeMin)?null:new Double(volumeRangeMin.toString())));
		volumeRange.setMax(null == volumeRangeMax?null:("".equals(volumeRangeMax)?null:new Double(volumeRangeMax.toString())));
		volumeRange.setDescription(null == volumeRangeLabel?"全部":("".equals(volumeRangeLabel)?"全部":volumeRangeLabel.toString()));
		if (null != volumeRangeMin || null != volumeRangeMax) {
			listDisinfectionCabinetProduct.setVolumeRange(volumeRange);
			listDisinfectionCabinetProduct.setVolumeRangeLabel(volumeRange.getDescription());
		}
		RangeParam powerRange = new RangeParam();
		powerRange.setMin(null == powerRangeMin?null:("".equals(powerRangeMin)?null:new Double(powerRangeMin.toString())));
		powerRange.setMax(null == powerRangeMax?null:("".equals(powerRangeMax)?null:new Double(powerRangeMax.toString())));
		powerRange.setDescription(null == powerRangeLabel?"全部":("".equals(powerRangeLabel)?"全部":powerRangeLabel.toString()));
		if (null != powerRangeMin || null != powerRangeMax) {
			listDisinfectionCabinetProduct.setPowerRange(powerRange);
			listDisinfectionCabinetProduct.setPowerRangeLabel(powerRange.getDescription());
		}
		if (null != brandCode) {
			listDisinfectionCabinetProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listDisinfectionCabinetProduct.setBrandLabel((String)brandLabel);
		}
		if (null != typeItem) {
			listDisinfectionCabinetProduct.setTypeItems((String)typeItem);
		}
		if (null != typeItemLabel) {
			listDisinfectionCabinetProduct.setTypeItemsLabel((String)typeItemLabel);
		}
		
		
		return null;
	}

}

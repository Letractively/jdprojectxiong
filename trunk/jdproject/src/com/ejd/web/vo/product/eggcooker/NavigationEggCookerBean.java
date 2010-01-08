package com.ejd.web.vo.product.eggcooker;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistEggCookerTimeTypeBean;
import com.ejd.web.vo.genl.ExistElectricPressureCookerControlTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceEggCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricPressureCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationEggCookerBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> volumeRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] timeTypeItems;
	

	public NavigationEggCookerBean () {
		ExistKitchenApplianceEggCookerProductBrandBean existKitchenApplianceEggCookerProductBrand = (ExistKitchenApplianceEggCookerProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_EGG_COOKER_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceEggCookerProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(50),"<=50"));
		tempPriceRange.add(new RangeParam(new Double(50),new Double(99.9),"50-99.9"));
		tempPriceRange.add(new RangeParam(new Double(100),null,">=100"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempVolumeRange = new ArrayList<RangeParam>();
		tempVolumeRange.add(new RangeParam(null,null,"全部"));
		tempVolumeRange.add(new RangeParam(new Double(0),new Double(5),"<=5"));
		tempVolumeRange.add(new RangeParam(new Double(6),new Double(10),"6-10"));
		tempVolumeRange.add(new RangeParam(new Double(11),null,">10"));
		this.setVolumeRangeList(tempVolumeRange);
		ExistEggCookerTimeTypeBean existEggCookerTimeType = (ExistEggCookerTimeTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_EGG_COOKER_TIME_TYPE_BEAN_NAME);
		SelectItem[] timeTypeItems = existEggCookerTimeType.getTimeTypeItems();
		this.setTimeTypeItems(timeTypeItems);
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

	public SelectItem[] getTimeTypeItems() {
		return timeTypeItems;
	}

	public void setTimeTypeItems(SelectItem[] timeTypeItems) {
		this.timeTypeItems = timeTypeItems;
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
		Object timeType = SpringFacesUtil.getRequestParameter("timeType");
		Object timeTypeLabel = SpringFacesUtil.getRequestParameter("timeTypeLabel");
		EggCookerProductBean listEggCookerProduct = (EggCookerProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_EGG_COOKER_PRODUCT_BEAN_NAME);
		listEggCookerProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		listEggCookerProduct.setPriceRange(priceRange);
		listEggCookerProduct.setPriceRangeLabel(priceRange.getDescription());
		RangeParam volumeRange = new RangeParam();
		volumeRange.setMin(null == volumeRangeMin?null:("".equals(volumeRangeMin)?null:new Double(volumeRangeMin.toString())));
		volumeRange.setMax(null == volumeRangeMax?null:("".equals(volumeRangeMax)?null:new Double(volumeRangeMax.toString())));
		volumeRange.setDescription(null == volumeRangeLabel?"全部":("".equals(volumeRangeLabel)?"全部":volumeRangeLabel.toString()));
		listEggCookerProduct.setVolumeRange(volumeRange);
		listEggCookerProduct.setVolumeRangeLabel(volumeRange.getDescription());
		if (null != brandCode) {
			listEggCookerProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listEggCookerProduct.setBrandLabel((String)brandLabel);
		}
		if (null != timeType) {
			listEggCookerProduct.setTimeType((String)timeType);
		}
		if (null != timeTypeLabel) {
			listEggCookerProduct.setTimeTypeLabel((String)timeTypeLabel);
		}
		
		
		return null;
	}

}

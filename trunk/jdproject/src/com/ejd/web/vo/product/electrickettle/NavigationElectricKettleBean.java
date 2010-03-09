package com.ejd.web.vo.product.electrickettle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistDisinfectionCabinetTypeBean;
import com.ejd.web.vo.genl.ExistElectricKettleMaterialTypeBean;
import com.ejd.web.vo.genl.ExistElectricPressureCookerControlTypeBean;
import com.ejd.web.vo.genl.ExistElectricWaterHeaterSetTypeBean;
import com.ejd.web.vo.genl.householdappliance.ExistHouseholdApplianceElectricKettleProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceDisinfectionCabinetProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricPressureCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectricWaterHeaterProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationElectricKettleBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> volumeRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] materialTypeItems;
	

	public NavigationElectricKettleBean () {
		ExistHouseholdApplianceElectricKettleProductBrandBean existElectricKettleProductBrand = (ExistHouseholdApplianceElectricKettleProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_HOUSEHOLD_APPLIANCE_ELECTRIC_KETTLE_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existElectricKettleProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(99.9),"<=99.9"));
		tempPriceRange.add(new RangeParam(new Double(100),new Double(199.9),"100-199.9"));
		tempPriceRange.add(new RangeParam(new Double(200),new Double(299.9),"200-299.9"));
		tempPriceRange.add(new RangeParam(new Double(300),null,">=300"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempVolumeRange = new ArrayList<RangeParam>();
		tempVolumeRange.add(new RangeParam(null,null,"全部"));
		tempVolumeRange.add(new RangeParam(new Double(0),new Double(1.1),"1.1L及以下"));
		tempVolumeRange.add(new RangeParam(new Double(1.2),new Double(1.5),"1.2-1.5"));
		tempVolumeRange.add(new RangeParam(new Double(1.6),new Double(2.0),"1.6-2.0"));
		tempVolumeRange.add(new RangeParam(new Double(2.1),null,"2.1及以上"));
		this.setVolumeRangeList(tempVolumeRange);
		ExistElectricKettleMaterialTypeBean existElectricKettleMaterialType = (ExistElectricKettleMaterialTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_ELECTRIC_KETTLE_MATERIAL_TYPE_BEAN_NAME);
		SelectItem[] materialTypeItems = existElectricKettleMaterialType.getMaterialTypeItems();
		this.setMaterialTypeItems(materialTypeItems);
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

	public SelectItem[] getMaterialTypeItems() {
		return materialTypeItems;
	}

	public void setMaterialTypeItems(SelectItem[] materialTypeItems) {
		this.materialTypeItems = materialTypeItems;
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
		Object materialTypeItem = SpringFacesUtil.getRequestParameter("materialTypeItem");
		Object materialTypeItemLabel = SpringFacesUtil.getRequestParameter("materialTypeItemLabel");
		ElectricKettleProductBean listElectricKettleProduct = (ElectricKettleProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_ELECTRIC_KETTLE_PRODUCT_BEAN_NAME);
		listElectricKettleProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listElectricKettleProduct.setPriceRange(priceRange);
			listElectricKettleProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		RangeParam volumeRange = new RangeParam();
		volumeRange.setMin(null == volumeRangeMin?null:("".equals(volumeRangeMin)?null:new Double(volumeRangeMin.toString())));
		volumeRange.setMax(null == volumeRangeMax?null:("".equals(volumeRangeMax)?null:new Double(volumeRangeMax.toString())));
		volumeRange.setDescription(null == volumeRangeLabel?"全部":("".equals(volumeRangeLabel)?"全部":volumeRangeLabel.toString()));
		if (null != volumeRangeMin || null != volumeRangeMax) {
			listElectricKettleProduct.setVolumeRange(volumeRange);
			listElectricKettleProduct.setVolumeRangeLabel(volumeRange.getDescription());
		}
		if (null != brandCode) {
			listElectricKettleProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listElectricKettleProduct.setBrandLabel((String)brandLabel);
		}
		if (null != materialTypeItem) {
			listElectricKettleProduct.setMaterialTypeItems((String)materialTypeItem);
		}
		if (null != materialTypeItemLabel) {
			listElectricKettleProduct.setMaterialTypeItemsLabel((String)materialTypeItemLabel);
		}
		
		
		return null;
	}

}

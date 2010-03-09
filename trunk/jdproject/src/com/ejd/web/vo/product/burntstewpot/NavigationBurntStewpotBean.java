package com.ejd.web.vo.product.burntstewpot;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceBurntStewpotProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationBurntStewpotBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> volumeRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> powerRangeList = new ArrayList<RangeParam>();
	

	public NavigationBurntStewpotBean () {
		ExistKitchenApplianceBurntStewpotProductBrandBean ExistKitchenApplianceBurntStewpotProductBrand = (ExistKitchenApplianceBurntStewpotProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_BURNT_STEWPOT_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = ExistKitchenApplianceBurntStewpotProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(199),"<=199"));
		tempPriceRange.add(new RangeParam(new Double(199),new Double(399),"199-399"));
		tempPriceRange.add(new RangeParam(new Double(399),new Double(599),"399-599"));
		tempPriceRange.add(new RangeParam(new Double(599),new Double(999),"599-999"));
		tempPriceRange.add(new RangeParam(new Double(999),null,"999以上"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempVolumeRange = new ArrayList<RangeParam>();
		tempVolumeRange.add(new RangeParam(null,null,"全部"));
		tempVolumeRange.add(new RangeParam(new Double(0),new Double(4),"<=4"));
		tempVolumeRange.add(new RangeParam(new Double(4),new Double(6),"4-6"));
		tempVolumeRange.add(new RangeParam(new Double(6),new Double(8),"6-8"));
		tempVolumeRange.add(new RangeParam(new Double(8),new Double(10),"8-10"));
		tempVolumeRange.add(new RangeParam(new Double(10),null,"10及以上"));
		this.setVolumeRangeList(tempVolumeRange);
		List<RangeParam> tempPowerRange = new ArrayList<RangeParam>();
		tempPowerRange.add(new RangeParam(null,null,"全部"));
		tempPowerRange.add(new RangeParam(new Double(0),new Double(500),"500瓦及以下"));
		tempPowerRange.add(new RangeParam(new Double(500),new Double(799),"500-799W"));
		tempPowerRange.add(new RangeParam(new Double(800),null,"800瓦及以上"));
		this.setPowerRangeList(tempPowerRange);
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
		BurntStewpotProductBean listBurntStewpotProduct = (BurntStewpotProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_BURNT_STEWPOT_PRODUCT_BEAN_NAME);
		listBurntStewpotProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listBurntStewpotProduct.setPriceRange(priceRange);
			listBurntStewpotProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		RangeParam volumeRange = new RangeParam();
		volumeRange.setMin(null == volumeRangeMin?null:("".equals(volumeRangeMin)?null:new Double(volumeRangeMin.toString())));
		volumeRange.setMax(null == volumeRangeMax?null:("".equals(volumeRangeMax)?null:new Double(volumeRangeMax.toString())));
		volumeRange.setDescription(null == volumeRangeLabel?"全部":("".equals(volumeRangeLabel)?"全部":volumeRangeLabel.toString()));
		if (null != volumeRangeMin || null != volumeRangeMax) {
			listBurntStewpotProduct.setVolumeRange(volumeRange);
			listBurntStewpotProduct.setVolumeRangeLabel(volumeRange.getDescription());
		}
		RangeParam powerRange = new RangeParam();
		powerRange.setMin(null == powerRangeMin?null:("".equals(powerRangeMin)?null:new Double(powerRangeMin.toString())));
		powerRange.setMax(null == powerRangeMax?null:("".equals(powerRangeMax)?null:new Double(powerRangeMax.toString())));
		powerRange.setDescription(null == powerRangeLabel?"全部":("".equals(powerRangeLabel)?"全部":powerRangeLabel.toString()));
		if (null != powerRangeMin || null != powerRangeMax) {
			listBurntStewpotProduct.setPowerRange(powerRange);
			listBurntStewpotProduct.setPowerRangeLabel(powerRange.getDescription());
		}
		if (null != brandCode) {
			listBurntStewpotProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listBurntStewpotProduct.setBrandLabel((String)brandLabel);
		}
		return null;
	}

}

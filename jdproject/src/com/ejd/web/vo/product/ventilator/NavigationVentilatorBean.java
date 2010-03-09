package com.ejd.web.vo.product.ventilator;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceVentilatorProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationVentilatorBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> windRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> powerRangeList = new ArrayList<RangeParam>();
	

	public NavigationVentilatorBean () {
		ExistKitchenApplianceVentilatorProductBrandBean existKitchenApplianceVentilatorProductBrand = (ExistKitchenApplianceVentilatorProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_VENTILATOR_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceVentilatorProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(999),"<=999"));
		tempPriceRange.add(new RangeParam(new Double(1000),new Double(1999.9),"1000-1999.9"));
		tempPriceRange.add(new RangeParam(new Double(2000),new Double(2999.9),"2000-2999.9"));
		tempPriceRange.add(new RangeParam(new Double(3000),new Double(3999.9),"3000-3999.9"));
		tempPriceRange.add(new RangeParam(new Double(4000),null,">=4000"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempWindRange = new ArrayList<RangeParam>();
		tempWindRange.add(new RangeParam(null,null,"全部"));
		tempWindRange.add(new RangeParam(new Double(0),new Double(14),"14及以下"));
		tempWindRange.add(new RangeParam(new Double(14.1),new Double(14.9),"14.1-14.9"));
		tempWindRange.add(new RangeParam(new Double(15),new Double(16),"15-16"));
		tempWindRange.add(new RangeParam(new Double(16.1),null,"16.1及以上"));
		this.setWindRangeList(tempWindRange);
		List<RangeParam> tempPowerRange = new ArrayList<RangeParam>();
		tempPowerRange.add(new RangeParam(null,null,"全部"));
		tempPowerRange.add(new RangeParam(new Double(0),new Double(180),"<=180"));
		tempPowerRange.add(new RangeParam(new Double(181),new Double(200),"181-200"));
		tempPowerRange.add(new RangeParam(new Double(201),new Double(300),"201-300"));
		tempPowerRange.add(new RangeParam(new Double(301),null,">=301"));
		this.setPowerRangeList(tempPowerRange);
	}
	
public List<RangeParam> getPriceRangeList() {
		return priceRangeList;
	}

	public void setPriceRangeList(List<RangeParam> priceRangeList) {
		this.priceRangeList = priceRangeList;
	}

	

	public List<RangeParam> getWindRangeList() {
		return windRangeList;
	}

	public void setWindRangeList(List<RangeParam> windRangeList) {
		this.windRangeList = windRangeList;
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
		Object windRangeMin = SpringFacesUtil.getRequestParameter("windRangeMin");
		Object windRangeMax = SpringFacesUtil.getRequestParameter("windRangeMax");
		Object windRangeLabel = SpringFacesUtil.getRequestParameter("windRangeLabel");
		Object powerRangeMin = SpringFacesUtil.getRequestParameter("powerRangeMin");
		Object powerRangeMax = SpringFacesUtil.getRequestParameter("powerRangeMax");
		Object powerRangeLabel = SpringFacesUtil.getRequestParameter("powerRangeLabel");
		VentilatorProductBean listVentilatorProduct = (VentilatorProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_VENTILATOR_PRODUCT_BEAN_NAME);
		listVentilatorProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listVentilatorProduct.setPriceRange(priceRange);
			listVentilatorProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		RangeParam windRange = new RangeParam();
		windRange.setMin(null == windRangeMin?null:("".equals(windRangeMin)?null:new Double(windRangeMin.toString())));
		windRange.setMax(null == windRangeMax?null:("".equals(windRangeMax)?null:new Double(windRangeMax.toString())));
		windRange.setDescription(null == windRangeLabel?"全部":("".equals(windRangeLabel)?"全部":windRangeLabel.toString()));
		if (null != windRangeMin || null != windRangeMax) {
			listVentilatorProduct.setWindRange(windRange);
			listVentilatorProduct.setWindRangeLabel(windRange.getDescription());
		}
		RangeParam powerRange = new RangeParam();
		powerRange.setMin(null == powerRangeMin?null:("".equals(powerRangeMin)?null:new Double(powerRangeMin.toString())));
		powerRange.setMax(null == powerRangeMax?null:("".equals(powerRangeMax)?null:new Double(powerRangeMax.toString())));
		powerRange.setDescription(null == powerRangeLabel?"全部":("".equals(powerRangeLabel)?"全部":powerRangeLabel.toString()));
		if (null != powerRangeMin || null != powerRangeMax) {
			listVentilatorProduct.setPowerRange(powerRange);
			listVentilatorProduct.setPowerRangeLabel(powerRange.getDescription());
		}
		if (null != brandCode) {
			listVentilatorProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listVentilatorProduct.setBrandLabel((String)brandLabel);
		}
		return null;
	}

}

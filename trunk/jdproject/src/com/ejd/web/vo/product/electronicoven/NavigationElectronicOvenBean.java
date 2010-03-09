package com.ejd.web.vo.product.electronicoven;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistElectronicOvenHotTypeBean;
import com.ejd.web.vo.genl.ExistInductionCookerFittingBean;
import com.ejd.web.vo.genl.ExistInductionCookerPanelTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceElectronicOvenProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceInductionCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationElectronicOvenBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] hotTypeItems = null;
	

	public NavigationElectronicOvenBean () {
		ExistKitchenApplianceElectronicOvenProductBrandBean existKitchenApplianceElectronicOvenProductBrand = (ExistKitchenApplianceElectronicOvenProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_ELECTRONIC_OVEN_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceElectronicOvenProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		//get panelTypeItems
		ExistElectronicOvenHotTypeBean existElectronicOvenHotType = (ExistElectronicOvenHotTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_ELECTRONIC_OVEN_HOT_TYPE_BEAN_NAME);
		SelectItem[] hotTypeItems = null;
		hotTypeItems = existElectronicOvenHotType.getHotTypeItems();
		this.setHotTypeItems(hotTypeItems);
		//end
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(199),"<=199"));
		tempPriceRange.add(new RangeParam(new Double(199),new Double(399),"199-399"));
		tempPriceRange.add(new RangeParam(new Double(399),new Double(599),"399-599"));
		tempPriceRange.add(new RangeParam(new Double(600),null,">=600"));
		this.setPriceRangeList(tempPriceRange);
		
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
	
	public SelectItem[] getHotTypeItems() {
		return hotTypeItems;
	}

	public void setHotTypeItems(SelectItem[] hotTypeItems) {
		this.hotTypeItems = hotTypeItems;
	}

public String clickLink() {
		
		Object brandCode = SpringFacesUtil.getRequestParameter("brandCode");
		Object brandLabel = SpringFacesUtil.getRequestParameter("brandLabel");
		Object priceRangeMin = SpringFacesUtil.getRequestParameter("priceRangeMin");
		Object priceRangeMax = SpringFacesUtil.getRequestParameter("priceRangeMax");
		Object priceRangeLabel = SpringFacesUtil.getRequestParameter("priceRangeLabel");
		Object hotType = SpringFacesUtil.getRequestParameter("hotType");
		Object hotTypeLabel = SpringFacesUtil.getRequestParameter("hotTypeLabel");
		ElectronicOvenProductBean listElectronicOvenProduct = (ElectronicOvenProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_ELECTRONIC_OVEN_PRODUCT_BEAN_NAME);
		listElectronicOvenProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listElectronicOvenProduct.setPriceRange(priceRange);
			listElectronicOvenProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		if (null != brandCode) {
			listElectronicOvenProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listElectronicOvenProduct.setBrandLabel((String)brandLabel);
		}
		if (null != hotType) {
			listElectronicOvenProduct.setHotType((String)hotType);
		}
		if (null != hotTypeLabel) {
			listElectronicOvenProduct.setHotTypeLabel((String)hotTypeLabel);
		}
		
		return null;
	}

}

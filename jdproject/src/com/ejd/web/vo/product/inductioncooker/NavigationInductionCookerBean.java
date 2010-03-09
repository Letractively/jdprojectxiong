package com.ejd.web.vo.product.inductioncooker;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistInductionCookerFittingBean;
import com.ejd.web.vo.genl.ExistInductionCookerPanelTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceInductionCookerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceRiceCookerProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationInductionCookerBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] panelTypeItems = null;
	
	private SelectItem[] fittingItems = null;
	

	public NavigationInductionCookerBean () {
		ExistKitchenApplianceInductionCookerProductBrandBean existKitchenApplianceInductionCookerProductBrand = (ExistKitchenApplianceInductionCookerProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_INDUCTION_COOKERP_RODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceInductionCookerProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		//get panelTypeItems
		ExistInductionCookerPanelTypeBean existInductionCookerPanelType = (ExistInductionCookerPanelTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_INDUCTION_COOKER_PANEL_TYPE_BEAN_NAME);
		SelectItem[] panelTypeItems = null;
		panelTypeItems = existInductionCookerPanelType.getPanelTypeItems();
		this.setPanelTypeItems(panelTypeItems);
		//end
		//get fitting items
		ExistInductionCookerFittingBean existInductionCookerFitting = (ExistInductionCookerFittingBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_INDUCTION_COOKER_FITTING_BEAN_NAME);
		SelectItem[] fittingItems = null;
		fittingItems = existInductionCookerFitting.getFittingItems();
		this.setFittingItems(fittingItems);
		//end
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(199),"<=199"));
		tempPriceRange.add(new RangeParam(new Double(199),new Double(299),"199-299"));
		tempPriceRange.add(new RangeParam(new Double(299),new Double(399),"299-399"));
		tempPriceRange.add(new RangeParam(new Double(399),new Double(500),"399-500"));
		tempPriceRange.add(new RangeParam(new Double(500),null,">=500"));
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
	
	

public SelectItem[] getPanelTypeItems() {
		return panelTypeItems;
	}

	public void setPanelTypeItems(SelectItem[] panelTypeItems) {
		this.panelTypeItems = panelTypeItems;
	}

	public SelectItem[] getFittingItems() {
		return fittingItems;
	}

	public void setFittingItems(SelectItem[] fittingItems) {
		this.fittingItems = fittingItems;
	}

public String clickLink() {
		
		Object brandCode = SpringFacesUtil.getRequestParameter("brandCode");
		Object brandLabel = SpringFacesUtil.getRequestParameter("brandLabel");
		Object priceRangeMin = SpringFacesUtil.getRequestParameter("priceRangeMin");
		Object priceRangeMax = SpringFacesUtil.getRequestParameter("priceRangeMax");
		Object priceRangeLabel = SpringFacesUtil.getRequestParameter("priceRangeLabel");
		Object panelType = SpringFacesUtil.getRequestParameter("panelType");
		Object panelTypeLabel = SpringFacesUtil.getRequestParameter("panelTypeLabel");
		Object fitting = SpringFacesUtil.getRequestParameter("fitting");
		Object fittingLabel = SpringFacesUtil.getRequestParameter("fittingLabel");
		InductionCookerProductBean listInductionCookerProduct = (InductionCookerProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_INDUCTION_COOKER_PRODUCT_BEAN_NAME);
		listInductionCookerProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listInductionCookerProduct.setPriceRange(priceRange);
			listInductionCookerProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		if (null != brandCode) {
			listInductionCookerProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listInductionCookerProduct.setBrandLabel((String)brandLabel);
		}
		if (null != panelType) {
			listInductionCookerProduct.setPanelType((String)panelType);
		}
		if (null != panelTypeLabel) {
			listInductionCookerProduct.setPanelTypeLabel((String)panelTypeLabel);
		}
		if (null != fitting) {
			listInductionCookerProduct.setFitting((String)fitting);
		}
		if (null != fittingLabel) {
			listInductionCookerProduct.setFittingLabel((String)fittingLabel);
		}
		
		return null;
	}

}

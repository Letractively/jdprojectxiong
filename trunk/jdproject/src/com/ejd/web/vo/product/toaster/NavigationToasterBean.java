package com.ejd.web.vo.product.toaster;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;


import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistToasterTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceToasterProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;

public class NavigationToasterBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] typeItems = null;
	

	public NavigationToasterBean () {
		ExistKitchenApplianceToasterProductBrandBean existKitchenApplianceToasterProductBrand = (ExistKitchenApplianceToasterProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_TOASTER_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceToasterProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		//get panelTypeItems
		ExistToasterTypeBean existToasterType = (ExistToasterTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_TOASTER_TYPE_BEAN_NAME);
		SelectItem[] typeItems = null;
		typeItems = existToasterType.getTypeItems();
		this.setTypeItems(typeItems);
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
	
	public SelectItem[] getTypeItems() {
		return typeItems;
	}

	public void setTypeItems(SelectItem[] typeItems) {
		this.typeItems = typeItems;
	}

public String clickLink() {
		
		Object brandCode = SpringFacesUtil.getRequestParameter("brandCode");
		Object brandLabel = SpringFacesUtil.getRequestParameter("brandLabel");
		Object priceRangeMin = SpringFacesUtil.getRequestParameter("priceRangeMin");
		Object priceRangeMax = SpringFacesUtil.getRequestParameter("priceRangeMax");
		Object priceRangeLabel = SpringFacesUtil.getRequestParameter("priceRangeLabel");
		Object type = SpringFacesUtil.getRequestParameter("type");
		Object typeLabel = SpringFacesUtil.getRequestParameter("typeLabel");
		ToasterProductBean listToasterProduct = (ToasterProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_TOASTER_PRODUCT_BEAN_NAME);
		listToasterProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listToasterProduct.setPriceRange(priceRange);
			listToasterProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		if (null != brandCode) {
			listToasterProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listToasterProduct.setBrandLabel((String)brandLabel);
		}
		if (null != type) {
			listToasterProduct.setType((String)type);
		}
		if (null != typeLabel) {
			listToasterProduct.setTypeLabel((String)typeLabel);
		}
		
		return null;
	}

}

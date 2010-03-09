package com.ejd.web.vo.product.gasstove;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;


import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.ExistGasStoveFitTypeBean;
import com.ejd.web.vo.genl.ExistGasStoveGasTypeBean;
import com.ejd.web.vo.genl.ExistToasterTypeBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceGasStoveProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceToasterProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;

public class NavigationGasStoveBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	
	private List<RangeParam> numberRangeList = new ArrayList<RangeParam>();
	
	private SelectItem[] gasTypeItems = null;
	
	private SelectItem[] fitTypeItems = null;

	public NavigationGasStoveBean () {
		ExistKitchenApplianceGasStoveProductBrandBean existKitchenApplianceGasStoveProductBrand = (ExistKitchenApplianceGasStoveProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_GAS_STOVE_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceGasStoveProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		//get gasTypeItems
		ExistGasStoveGasTypeBean existGasStoveGasTypeType = (ExistGasStoveGasTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_GAS_STOVE_GAS_TYPE_BEAN_NAME);
		SelectItem[] gasTypeItems = null;
		gasTypeItems = existGasStoveGasTypeType.getGasTypeItems();
		this.setGasTypeItems(gasTypeItems);
		//end
		//get fitTypeItems
		ExistGasStoveFitTypeBean existGasStoveFitTypeType = (ExistGasStoveFitTypeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_GAS_STOVE_FIT_TYPE_BEAN_NAME);
		SelectItem[] fitTypeItems = null;
		fitTypeItems = existGasStoveFitTypeType.getFitTypeItems();
		this.setFitTypeItems(fitTypeItems);
		//end
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(499),"1-499"));
		tempPriceRange.add(new RangeParam(new Double(500),new Double(999),"500-999"));
		tempPriceRange.add(new RangeParam(new Double(1000),new Double(1499),"1000-1499"));
		tempPriceRange.add(new RangeParam(new Double(1500),new Double(1999),"1500-1999"));
		tempPriceRange.add(new RangeParam(new Double(2000),new Double(2999),"2000-2999"));
		tempPriceRange.add(new RangeParam(new Double(3000),null,">=3000"));
		this.setPriceRangeList(tempPriceRange);
		List<RangeParam> tempNumberRange = new ArrayList<RangeParam>();
		tempNumberRange.add(new RangeParam(null,null,"全部"));
		tempNumberRange.add(new RangeParam(new Double(1),new Double(1),"1个"));
		tempNumberRange.add(new RangeParam(new Double(2),new Double(2),"2个"));
		tempNumberRange.add(new RangeParam(new Double(3),new Double(3),"3个"));
		tempNumberRange.add(new RangeParam(new Double(4),null,"4个及以上"));
		this.setNumberRangeList(tempNumberRange);
		
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
	

public List<RangeParam> getNumberRangeList() {
		return numberRangeList;
	}

	public void setNumberRangeList(List<RangeParam> numberRangeList) {
		this.numberRangeList = numberRangeList;
	}

	public SelectItem[] getGasTypeItems() {
		return gasTypeItems;
	}

	public void setGasTypeItems(SelectItem[] gasTypeItems) {
		this.gasTypeItems = gasTypeItems;
	}

	public SelectItem[] getFitTypeItems() {
		return fitTypeItems;
	}

	public void setFitTypeItems(SelectItem[] fitTypeItems) {
		this.fitTypeItems = fitTypeItems;
	}

public String clickLink() {
		
		Object brandCode = SpringFacesUtil.getRequestParameter("brandCode");
		Object brandLabel = SpringFacesUtil.getRequestParameter("brandLabel");
		Object priceRangeMin = SpringFacesUtil.getRequestParameter("priceRangeMin");
		Object priceRangeMax = SpringFacesUtil.getRequestParameter("priceRangeMax");
		Object priceRangeLabel = SpringFacesUtil.getRequestParameter("priceRangeLabel");
		Object numberRangeMin = SpringFacesUtil.getRequestParameter("numberRangeMin");
		Object numberRangeMax = SpringFacesUtil.getRequestParameter("numberRangeMax");
		Object numberRangeLabel = SpringFacesUtil.getRequestParameter("numberRangeLabel");
		Object gasType = SpringFacesUtil.getRequestParameter("gasType");
		Object gasTypeLabel = SpringFacesUtil.getRequestParameter("gasTypeLabel");
		Object fitType = SpringFacesUtil.getRequestParameter("fitType");
		Object fitTypeLabel = SpringFacesUtil.getRequestParameter("fitTypeLabel");
		GasStoveProductBean listGasStoveProduct = (GasStoveProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_GAS_STOVE_PRODUCT_BEAN_NAME);
		listGasStoveProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		if (null != priceRangeMin || null != priceRangeMax) {
			listGasStoveProduct.setPriceRange(priceRange);
			listGasStoveProduct.setPriceRangeLabel(priceRange.getDescription());
		}
		RangeParam numberRange = new RangeParam();
		numberRange.setMin(null == numberRangeMin?null:("".equals(numberRangeMin)?null:new Double(numberRangeMin.toString())));
		numberRange.setMax(null == numberRangeMax?null:("".equals(numberRangeMax)?null:new Double(numberRangeMax.toString())));
		numberRange.setDescription(null == numberRangeLabel?"全部":("".equals(numberRangeLabel)?"全部":numberRangeLabel.toString()));
		if (null != numberRangeMin || null != numberRangeMax) {
			listGasStoveProduct.setNumberRange(numberRange);
			listGasStoveProduct.setNumberRangeLabel(numberRange.getDescription());
		}
		if (null != brandCode) {
			listGasStoveProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listGasStoveProduct.setBrandLabel((String)brandLabel);
		}
		if (null != gasType) {
			listGasStoveProduct.setGasType((String)gasType);
		}
		if (null != gasTypeLabel) {
			listGasStoveProduct.setGasTypeLabel((String)gasTypeLabel);
		}
		if (null != fitType) {
			listGasStoveProduct.setFitType((String)fitType);
		}
		if (null != fitTypeLabel) {
			listGasStoveProduct.setFitTypeLabel((String)fitTypeLabel);
		}
		
		return null;
	}

}

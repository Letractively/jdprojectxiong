package com.ejd.web.vo.product.coffeemachine;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceCoffeeMachineProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceCuisineMachineProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceFryerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceSaucepanProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationCoffeeMachineBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	

	public NavigationCoffeeMachineBean () {
		ExistKitchenApplianceCoffeeMachineProductBrandBean existKitchenApplianceCoffeeMachineProductBrand = (ExistKitchenApplianceCoffeeMachineProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_COFFEE_MACHINE_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceCoffeeMachineProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(99.9),"<100"));
		tempPriceRange.add(new RangeParam(new Double(100),new Double(199.9),"100-199.9"));
		tempPriceRange.add(new RangeParam(new Double(200),new Double(399.9),"200-399.9"));
		tempPriceRange.add(new RangeParam(new Double(400),new Double(599.9),"400-599.9"));
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

public String clickLink() {
		
		Object brandCode = SpringFacesUtil.getRequestParameter("brandCode");
		Object brandLabel = SpringFacesUtil.getRequestParameter("brandLabel");
		Object priceRangeMin = SpringFacesUtil.getRequestParameter("priceRangeMin");
		Object priceRangeMax = SpringFacesUtil.getRequestParameter("priceRangeMax");
		Object priceRangeLabel = SpringFacesUtil.getRequestParameter("priceRangeLabel");
		CoffeeMachineProductBean listCoffeeMachineProduct = (CoffeeMachineProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_COFFEE_MACHINE_PRODUCT_BEAN_NAME);
		listCoffeeMachineProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		listCoffeeMachineProduct.setPriceRange(priceRange);
		listCoffeeMachineProduct.setPriceRangeLabel(priceRange.getDescription());
		if (null != brandCode) {
			listCoffeeMachineProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listCoffeeMachineProduct.setBrandLabel((String)brandLabel);
		}
		return null;
	}

}

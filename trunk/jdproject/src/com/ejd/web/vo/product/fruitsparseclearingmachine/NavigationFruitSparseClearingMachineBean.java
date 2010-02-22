package com.ejd.web.vo.product.fruitsparseclearingmachine;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.common.constant.EjdConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceCoffeeMachineProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceCuisineMachineProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceFruitSparseClearingMachineProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceFryerProductBrandBean;
import com.ejd.web.vo.genl.kitchenapplicance.ExistKitchenApplianceSaucepanProductBrandBean;
import com.ejd.web.vo.product.base.RangeParam;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.richfaces.header.HeaderTabPanelBean;
import com.ejd.web.vo.richfaces.header.MenuItem;

public class NavigationFruitSparseClearingMachineBean {
	
	private SelectItem[] brandCodeItems = null;
	
	private List<RangeParam> priceRangeList = new ArrayList<RangeParam>();
	

	public NavigationFruitSparseClearingMachineBean () {
		ExistKitchenApplianceFruitSparseClearingMachineProductBrandBean existKitchenApplianceFruitSparseClearingMachineProductBrand = (ExistKitchenApplianceFruitSparseClearingMachineProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_KITCHEN_APPLIANCE_FRUIT_SPARSE_CLEARING_MACHINE_PRODUCT_BRAND_BEAN_NAME);
		SelectItem[] result = null;
		result = existKitchenApplianceFruitSparseClearingMachineProductBrand.getBrandCodeItems();
		this.setBrandCodeItems(result);
		List<RangeParam> tempPriceRange = new ArrayList<RangeParam>();
		tempPriceRange.add(new RangeParam(null,null,"全部"));
		tempPriceRange.add(new RangeParam(new Double(0),new Double(399.9),"<400"));
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
		FruitSparseClearingMachineProductBean listFruitSparseClearingMachineProduct = (FruitSparseClearingMachineProductBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.LIST_FRUIT_SPARSE_CLEARING_MACHINE_PRODUCT_BEAN_NAME);
		listFruitSparseClearingMachineProduct.setDataModel(null);
		RangeParam priceRange = new RangeParam();
		priceRange.setMin(null == priceRangeMin?null:("".equals(priceRangeMin)?null:new Double(priceRangeMin.toString())));
		priceRange.setMax(null == priceRangeMax?null:("".equals(priceRangeMax)?null:new Double(priceRangeMax.toString())));
		priceRange.setDescription(null == priceRangeLabel?"全部":("".equals(priceRangeLabel)?"全部":priceRangeLabel.toString()));
		listFruitSparseClearingMachineProduct.setPriceRange(priceRange);
		listFruitSparseClearingMachineProduct.setPriceRangeLabel(priceRange.getDescription());
		if (null != brandCode) {
			listFruitSparseClearingMachineProduct.setBrandCode((String)brandCode);
		}
		if (null != brandLabel) {
			listFruitSparseClearingMachineProduct.setBrandLabel((String)brandLabel);
		}
		return null;
	}

}

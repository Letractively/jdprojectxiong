package com.ejd.web.vo.genl;

import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.model.exception.ProductUnitException;
import com.ejd.model.service.iface.IProductUnitService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Productunit;
import com.ejd.web.vo.productunit.ProductUnitBaseBean;

public class ExistProductUnitBean extends ProductUnitBaseBean {

	private SelectItem[] unitItems;

	public SelectItem[] getUnitItems() {
		return unitItems;
	}

	public void setUnitItems(SelectItem[] unitItems) {
		this.unitItems = unitItems;
	}
	public ExistProductUnitBean() throws ProductUnitException {
		if (null == this.getProductUnitService()) {
			this.setProductUnitService((IProductUnitService)SpringFacesUtil.getSpringBean("productUnitService"));
		}
		List<Productunit> productUnits = this.getProductUnitService().getAllProductUnit();
		SelectItem[] tempUnitItems = new SelectItem[productUnits.size()];
		for (int i=0; i< tempUnitItems.length; i++) {
			Productunit productUnit = (Productunit) productUnits.get(i);
			tempUnitItems[i] = new SelectItem(new Integer(productUnit.getId()),productUnit.getUnitName());
		}
		this.setUnitItems(tempUnitItems);
	}
}

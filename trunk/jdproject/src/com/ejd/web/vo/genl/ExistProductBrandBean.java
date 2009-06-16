package com.ejd.web.vo.genl;

import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.model.exception.ProductBrandException;
import com.ejd.model.service.iface.IProductBrandService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Productbrand;
import com.ejd.web.vo.productbrand.ProductBrandBaseBean;

public class ExistProductBrandBean extends ProductBrandBaseBean {

	private SelectItem[] brandItems;

	public SelectItem[] getBrandItems() {
		return brandItems;
	}

	public void setBrandItems(SelectItem[] brandItems) {
		this.brandItems = brandItems;
	}
	public ExistProductBrandBean() throws ProductBrandException {
		if (null == this.getProductBrandService()) {
			this.setProductBrandService((IProductBrandService)SpringFacesUtil.getSpringBean("productBrandService"));
		}
		List<Productbrand> productBrands = this.getProductBrandService().getAllProductBrand();
		SelectItem[] tempBrandItems = new SelectItem[productBrands.size()];
		for (int i=0; i <tempBrandItems.length; i++ ) {
			Productbrand productBrand = (Productbrand)productBrands.get(i);
			tempBrandItems[i] = new SelectItem(new Integer(productBrand.getId()),productBrand.getBrandName());
		}
		this.setBrandItems(tempBrandItems);
	}
}

package com.ejd.web.vo.genl;

import java.util.List;

import javax.faces.model.SelectItem;

import com.ejd.model.exception.ProductCategoryException;
import com.ejd.model.service.iface.IProductCategoryService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Productcategory;
import com.ejd.web.vo.productcategory.ProductCategoryBaseBean;

public class ExistProductCategoryBean extends ProductCategoryBaseBean {

	private SelectItem[] categoryItems;

	public SelectItem[] getCategoryItems() {
		return categoryItems;
	}

	public void setCategoryItems(SelectItem[] categoryItems) {
		this.categoryItems = categoryItems;
	}
	public ExistProductCategoryBean() throws ProductCategoryException{
		if (null == this.getProductCategoryService()) {
			this.setProductCategoryService((IProductCategoryService)SpringFacesUtil.getSpringBean("productCategoryService"));
		}
		List<Productcategory> productCategorys = this.getProductCategoryService().getAllProductCategory();
		SelectItem[] tempCategoryItems = new SelectItem[productCategorys.size()];
		for (int i=0; i < tempCategoryItems.length; i++) {
			Productcategory productCategory = (Productcategory) productCategorys.get(i);
			tempCategoryItems[i] = new SelectItem(new Integer(productCategory.getId()),productCategory.getCategoryName());
		}
		this.setCategoryItems(tempCategoryItems);
	}
}

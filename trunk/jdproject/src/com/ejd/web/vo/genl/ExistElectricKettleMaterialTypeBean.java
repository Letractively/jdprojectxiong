package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;


public class ExistElectricKettleMaterialTypeBean {

	private static SelectItem[] materialTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("P"),"塑料"),
		new SelectItem(new String("S"),"不锈钢"),
		new SelectItem(new String("C"),"陶瓷"),
	};

	public SelectItem[] getMaterialTypeItems() {
		return materialTypeItems;
	}

	public void setMaterialTypeItems(SelectItem[] materialTypeItems) {
		ExistElectricKettleMaterialTypeBean.materialTypeItems = materialTypeItems;
	}
	
}

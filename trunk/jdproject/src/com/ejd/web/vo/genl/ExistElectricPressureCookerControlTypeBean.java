package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistElectricPressureCookerControlTypeBean {

	private static SelectItem[] controlTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("A"),"电脑版"),
		new SelectItem(new String("B"),"机械版"),
	};

	public SelectItem[] getControlTypeItems() {
		return controlTypeItems;
	}

	public void setControlTypeItems(SelectItem[] typeItems) {
		ExistElectricPressureCookerControlTypeBean.controlTypeItems = typeItems;
	}
	
}

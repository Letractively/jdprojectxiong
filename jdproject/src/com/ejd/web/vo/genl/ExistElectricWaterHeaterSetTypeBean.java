package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistElectricWaterHeaterSetTypeBean {

	private static SelectItem[] setTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("A"),"卧式"),
		new SelectItem(new String("B"),"立式"),
	};

	public SelectItem[] getSetTypeItems() {
		return setTypeItems;
	}

	public void setSetTypeItems(SelectItem[] typeItems) {
		ExistElectricWaterHeaterSetTypeBean.setTypeItems = typeItems;
	}
	
}

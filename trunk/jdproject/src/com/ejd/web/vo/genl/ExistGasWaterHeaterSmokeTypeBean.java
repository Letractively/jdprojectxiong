package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistGasWaterHeaterSmokeTypeBean {

	private static SelectItem[] smokeTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("A"),"平衡式"),
		new SelectItem(new String("B"),"强排式"),
		new SelectItem(new String("C"),"烟道式"),
		new SelectItem(new String("D"),"户外式"),
	};

	public SelectItem[] getSmokeTypeItems() {
		return smokeTypeItems;
	}

	public void setSmokeTypeItems(SelectItem[] typeItems) {
		ExistGasWaterHeaterSmokeTypeBean.smokeTypeItems = typeItems;
	}
	
}

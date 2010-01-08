package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistEggCookerTimeTypeBean {

	private static SelectItem[] timeTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("Y"),"定时"),
		new SelectItem(new String("N"),"不定时"),
	};

	public SelectItem[] getTimeTypeItems() {
		return timeTypeItems;
	}

	public void setTimeTypeItems(SelectItem[] typeItems) {
		ExistEggCookerTimeTypeBean.timeTypeItems = typeItems;
	}
	
}

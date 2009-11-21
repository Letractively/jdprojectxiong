package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistProductStatusBean {

	private static SelectItem[] statusItems = {
		new SelectItem(new String("F"),"即将上市"),
		new SelectItem(new String("N"),"新品"),
		new SelectItem(new String("H"),"热销"),
		new SelectItem(new String("S"),"停产"),
	};

	public SelectItem[] getStatusItems() {
		return statusItems;
	}

	public void setStatusItems(SelectItem[] typeItems) {
		ExistProductStatusBean.statusItems = typeItems;
	}
	
}

package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistStakeholderStatusBean {

	private static SelectItem[] statusItems = {
		new SelectItem(new String("N"),"����"),
		new SelectItem(new String("L"),"����"),
		new SelectItem(new String("A"),"����"),
	};

	public SelectItem[] getStatusItems() {
		return statusItems;
	}

	public void setStatusItems(SelectItem[] statusItems) {
		ExistStakeholderStatusBean.statusItems = statusItems;
	}

	
}

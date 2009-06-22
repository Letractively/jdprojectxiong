package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistStakeholderStatusBean {

	private static SelectItem[] statusItems = {
		new SelectItem(new String("N"),"待批"),
		new SelectItem(new String("L"),"锁定"),
		new SelectItem(new String("A"),"正常"),
	};

	public SelectItem[] getStatusItems() {
		return statusItems;
	}

	public void setStatusItems(SelectItem[] statusItems) {
		ExistStakeholderStatusBean.statusItems = statusItems;
	}

	
}

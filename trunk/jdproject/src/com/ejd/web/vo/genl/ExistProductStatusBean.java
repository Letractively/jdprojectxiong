package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistProductStatusBean {

	private static SelectItem[] statusItems = {
		new SelectItem(new String("F"),"��������"),
		new SelectItem(new String("N"),"��Ʒ"),
		new SelectItem(new String("H"),"����"),
		new SelectItem(new String("S"),"ͣ��"),
	};

	public SelectItem[] getStatusItems() {
		return statusItems;
	}

	public void setStatusItems(SelectItem[] typeItems) {
		ExistProductStatusBean.statusItems = typeItems;
	}
	
}

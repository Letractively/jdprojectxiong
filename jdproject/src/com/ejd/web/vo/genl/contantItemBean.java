package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class contantItemBean {
	private static SelectItem[] sexItems = {
		new SelectItem(new String("M"),"男"),
		new SelectItem(new String("F"),"女"),
	};

	public SelectItem[] getSexItems() {
		return sexItems;
	}

	public void setSexItems(SelectItem[] sexItems) {
		contantItemBean.sexItems = sexItems;
	}
	
}

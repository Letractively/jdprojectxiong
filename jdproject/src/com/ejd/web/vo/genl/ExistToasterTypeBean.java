package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistToasterTypeBean {

	private static SelectItem[] typeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("B"),"面包机"),
		new SelectItem(new String("T"),"多士炉"),
	};

	public SelectItem[] getTypeItems() {
		return typeItems;
	}

	public void setTypeItems(SelectItem[] typeItems) {
		ExistToasterTypeBean.typeItems = typeItems;
	}
	
}

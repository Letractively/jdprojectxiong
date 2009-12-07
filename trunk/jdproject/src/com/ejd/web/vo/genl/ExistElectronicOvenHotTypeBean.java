package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistElectronicOvenHotTypeBean {

	private static SelectItem[] hotTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("A"),"石英管"),
		new SelectItem(new String("B"),"光波"),
	};

	public SelectItem[] getHotTypeItems() {
		return hotTypeItems;
	}

	public void setHotTypeItems(SelectItem[] typeItems) {
		ExistElectronicOvenHotTypeBean.hotTypeItems = typeItems;
	}
	
}

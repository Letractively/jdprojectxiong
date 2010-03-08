package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistElectricIronSteamTypeBean {

	private static SelectItem[] steamTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("Q"),"蒸汽式"),
		new SelectItem(new String("Y"),"压力式"),
		new SelectItem(new String("Z"),"蒸气刷"),
	};

	public SelectItem[] getSteamTypeItems() {
		return steamTypeItems;
	}

	public void setSteamTypeItems(SelectItem[] steamTypeItems) {
		ExistElectricIronSteamTypeBean.steamTypeItems = steamTypeItems;
	}
	
}

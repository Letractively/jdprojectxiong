package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistGasStoveGasTypeBean {

	private static SelectItem[] gasTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("T"),"天然气(T)"),
		new SelectItem(new String("Y"),"液化石油气(Y)"),
		new SelectItem(new String("Z"),"沼气(Z)"),
		new SelectItem(new String("R"),"人工煤气(R)"),
	};

	public SelectItem[] getGasTypeItems() {
		return gasTypeItems;
	}

	public void setGasTypeItems(SelectItem[] typeItems) {
		ExistGasStoveGasTypeBean.gasTypeItems = typeItems;
	}
	
}

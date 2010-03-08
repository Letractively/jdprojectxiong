package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistHumidifierUseTypeBean {

	private static SelectItem[] useTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("C"),"超声波"),
		new SelectItem(new String("J"),"净化型"),
		new SelectItem(new String("S"),"除湿器"),
		new SelectItem(new String("F"),"附属产品"),
	};

	public SelectItem[] getUseTypeItems() {
		return useTypeItems;
	}

	public void setUseTypeItems(SelectItem[] useTypeItems) {
		ExistHumidifierUseTypeBean.useTypeItems = useTypeItems;
	}
	
}

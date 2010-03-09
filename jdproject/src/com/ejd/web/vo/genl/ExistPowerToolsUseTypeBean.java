package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistPowerToolsUseTypeBean {

	private static SelectItem[] useTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("C"),"冲击钻"),
		new SelectItem(new String("D"),"充电电钻"),
		new SelectItem(new String("G"),"工具套装"),
		new SelectItem(new String("J"),"测距仪"),
		new SelectItem(new String("Q"),"曲线锯"),
		new SelectItem(new String("P"),"抛光机/打蜡机"),
		new SelectItem(new String("Y"),"水平仪"),
		new SelectItem(new String("M"),"角磨机"),
		new SelectItem(new String("O"),"其他"),
	};

	public SelectItem[] getUseTypeItems() {
		return useTypeItems;
	}

	public void setUseTypeItems(SelectItem[] useTypeItems) {
		ExistPowerToolsUseTypeBean.useTypeItems = useTypeItems;
	}
	
}

package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistInductionCookerPanelTypeBean {

	private static SelectItem[] panelTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("A"),"玻璃面板"),
		new SelectItem(new String("B"),"黑晶面板"),
		new SelectItem(new String("C"),"陶瓷面板"),
		new SelectItem(new String("D"),"彩晶透明板"),
		new SelectItem(new String("E"),"暗纹彩晶面板"),
		new SelectItem(new String("F"),"炫金面板"),
		new SelectItem(new String("G"),"微晶面板"),
	};

	public SelectItem[] getPanelTypeItems() {
		return panelTypeItems;
	}

	public void setPanelTypeItems(SelectItem[] typeItems) {
		ExistInductionCookerPanelTypeBean.panelTypeItems = typeItems;
	}
	
}

package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistVacuumCleanerUseTypeBean {

	private static SelectItem[] useTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("W"),"卧式"),
		new SelectItem(new String("S"),"手持式"),
		new SelectItem(new String("Z"),"智能式"),
		new SelectItem(new String("T"),"水过滤式"),
		new SelectItem(new String("B"),"扫地机"),
		new SelectItem(new String("D"),"打蜡机"),
		new SelectItem(new String("Q"),"蒸汽拖把"),
	};

	public SelectItem[] getUseTypeItems() {
		return useTypeItems;
	}

	public void setUseTypeItems(SelectItem[] useTypeItems) {
		ExistVacuumCleanerUseTypeBean.useTypeItems = useTypeItems;
	}
	
}

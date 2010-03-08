package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistElectricFanSetTypeBean {

	private static SelectItem[] setTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("L"),"落地式"),
		new SelectItem(new String("G"),"夹挂式"),
		new SelectItem(new String("T"),"台式"),
		new SelectItem(new String("K"),"空调扇"),
		new SelectItem(new String("S"),"手持式"),
		new SelectItem(new String("D"),"吊顶式"),
		new SelectItem(new String("Z"),"转页扇"),
		new SelectItem(new String("E"),"塔扇"),
		new SelectItem(new String("F"),"台地扇"),
		new SelectItem(new String("B"),"壁扇"),
	};

	public SelectItem[] getSetTypeItems() {
		return setTypeItems;
	}

	public void setSetTypeItems(SelectItem[] typeItems) {
		ExistElectricFanSetTypeBean.setTypeItems = typeItems;
	}
	
}

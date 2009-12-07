package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistInductionCookerFittingBean {

	private static SelectItem[] fittingItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("A"),"带汤锅"),
		new SelectItem(new String("B"),"带汤锅炒锅"),
	};

	public SelectItem[] getFittingItems() {
		return fittingItems;
	}

	public void setFittingItems(SelectItem[] typeItems) {
		ExistInductionCookerFittingBean.fittingItems = typeItems;
	}
	
}

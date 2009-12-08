package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistGasStoveFitTypeBean {

	private static SelectItem[] fitTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("A"),"台式"),
		new SelectItem(new String("B"),"嵌入式"),
	};

	public SelectItem[] getFitTypeItems() {
		return fitTypeItems;
	}

	public void setFitTypeItems(SelectItem[] typeItems) {
		ExistGasStoveFitTypeBean.fitTypeItems = typeItems;
	}
	
}

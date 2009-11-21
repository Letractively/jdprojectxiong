package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class CharSearCondItemBean {
	private static SelectItem[] conditionItems = {
		new SelectItem(new String(""),""),
		new SelectItem(new String("="),"等于"),
		new SelectItem(new String("%"),"类似"),
		new SelectItem(new String("<"),"小于"),
		new SelectItem(new String("<="),"小于等于"),
		new SelectItem(new String(">"),"大于"),
		new SelectItem(new String(">="),"大于等于"),
	};

	public SelectItem[] getSexItems() {
		return conditionItems;
	}

	public void setSexItems(SelectItem[] conditionItems) {
		this.conditionItems = conditionItems;
	}
	
}

package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class CharSearCondItemBean {
	private static SelectItem[] conditionItems = {
		new SelectItem(new String(""),""),
		new SelectItem(new String("="),"����"),
		new SelectItem(new String("%"),"����"),
		new SelectItem(new String("<"),"С��"),
		new SelectItem(new String("<="),"С�ڵ���"),
		new SelectItem(new String(">"),"����"),
		new SelectItem(new String(">="),"���ڵ���"),
	};

	public SelectItem[] getSexItems() {
		return conditionItems;
	}

	public void setSexItems(SelectItem[] conditionItems) {
		this.conditionItems = conditionItems;
	}
	
}

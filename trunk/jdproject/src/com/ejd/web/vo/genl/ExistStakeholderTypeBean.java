package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistStakeholderTypeBean {

	private static SelectItem[] typeItems = {
		new SelectItem(new String("V"),"游客"),//visitor
		new SelectItem(new String("P"),"供应商"),//provider
		new SelectItem(new String("S"),"客户"), //customer
		new SelectItem(new String("A"),"代理商"),//agent
		new SelectItem(new String("D"),"经销商"),//dealer
	};

	public SelectItem[] getTypeItems() {
		return typeItems;
	}

	public void setTypeItems(SelectItem[] typeItems) {
		ExistStakeholderTypeBean.typeItems = typeItems;
	}
	
}

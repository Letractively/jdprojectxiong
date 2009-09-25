package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistStakeholderTypeBean {

	private static SelectItem[] typeItems = {
		new SelectItem(new String("V"),"�ο�"),//visitor
		new SelectItem(new String("P"),"��Ӧ��"),//provider
		new SelectItem(new String("S"),"�ͻ�"), //customer
		new SelectItem(new String("A"),"������"),//agent
		new SelectItem(new String("D"),"������"),//dealer
	};

	public SelectItem[] getTypeItems() {
		return typeItems;
	}

	public void setTypeItems(SelectItem[] typeItems) {
		ExistStakeholderTypeBean.typeItems = typeItems;
	}
	
}

package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistStakeholderTypeBean {

	private static SelectItem[] typeItems = {
		new SelectItem(new String("V"),"�ο�"),
		new SelectItem(new String("P"),"��Ӧ��"),
		new SelectItem(new String("S"),"�ͻ�"),
		new SelectItem(new String("A"),"������"),
		new SelectItem(new String("D"),"������"),
	};

	public SelectItem[] getTypeItems() {
		return typeItems;
	}

	public void setTypeItems(SelectItem[] typeItems) {
		ExistStakeholderTypeBean.typeItems = typeItems;
	}
	
}

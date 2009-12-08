package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistDisinfectionCabinetTypeBean {

	private static SelectItem[] typeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("A"),"臭氧"),
		new SelectItem(new String("B"),"高温"),
		new SelectItem(new String("C"),"中温"),
		new SelectItem(new String("D"),"紫外线臭氧"),
		new SelectItem(new String("E"),"红外线高温"),
		new SelectItem(new String("F"),"超高温蒸汽"),
		new SelectItem(new String("G"),"紫外臭氧+高温"),
		new SelectItem(new String("H"),"紫外线+光波"),
		new SelectItem(new String("I"),"臭氧+远红外线"),
	};

	public SelectItem[] getTypeItems() {
		return typeItems;
	}

	public void setTypeItems(SelectItem[] typeItems) {
		ExistDisinfectionCabinetTypeBean.typeItems = typeItems;
	}
	
}

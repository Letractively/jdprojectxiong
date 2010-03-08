package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistElectricHeaterUseTypeBean {

	private static SelectItem[] useTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("A"),"电油汀"),
		new SelectItem(new String("B"),"反射型"),
		new SelectItem(new String("C"),"卤素管"),
		new SelectItem(new String("D"),"暖风机"),
		new SelectItem(new String("E"),"电暖炉"),
		new SelectItem(new String("F"),"冷暖空调扇"),
		new SelectItem(new String("G"),"电热毯"),
		new SelectItem(new String("H"),"取暖干衣机"),
		new SelectItem(new String("I"),"对衡式"),
		new SelectItem(new String("G"),"电膜式"),
		new SelectItem(new String("K"),"远红外式"),
	};

	public SelectItem[] getUseTypeItems() {
		return useTypeItems;
	}

	public void setUseTypeItems(SelectItem[] useTypeItems) {
		ExistElectricHeaterUseTypeBean.useTypeItems = useTypeItems;
	}
	
}

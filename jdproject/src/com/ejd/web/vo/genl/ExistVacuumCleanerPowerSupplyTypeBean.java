package com.ejd.web.vo.genl;

import javax.faces.model.SelectItem;

public class ExistVacuumCleanerPowerSupplyTypeBean {

	private static SelectItem[] powerSupplyTypeItems = {
		new SelectItem(new String(""),"全部"),
		new SelectItem(new String("Y"),"有线电源式"),
		new SelectItem(new String("N"),"无线充电式"),
	};

	public SelectItem[] getPowerSupplyTypeItems() {
		return powerSupplyTypeItems;
	}

	public void setPowerSupplyTypeItems(SelectItem[] powerSupplyTypeItems) {
		ExistVacuumCleanerPowerSupplyTypeBean.powerSupplyTypeItems = powerSupplyTypeItems;
	}
	
}

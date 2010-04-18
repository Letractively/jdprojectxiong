package com.ejd.web.vo.help;

import javax.faces.event.ActionEvent;

public class HelpPanelMenuBean {
	
	private HelpPanelMenuStatusBean menuState;

	public HelpPanelMenuStatusBean getMenuState() {
		return menuState;
	}

	public void setMenuState(HelpPanelMenuStatusBean menuState) {
		this.menuState = menuState;
	}

	public HelpPanelMenuBean() {
	}
	
	public void select (ActionEvent event) {
		if (null != event.getComponent().getId()) {
			menuState.setSelectedMenuItemId(event.getComponent().getId());
		} else {
			//do nothing
		}
		if (null != event.getComponent().getAttributes().get("value")) {
			menuState.setSelectedMenuItemValue(event.getComponent().getAttributes().get("value").toString());
		} else {
			menuState.setSelectedMenuItemValue("newCustomerRegister.jsp");
		}
		System.out.println(event.getComponent().getId());
		System.out.println(event.getComponent().getAttributes().get("value"));
	}

}

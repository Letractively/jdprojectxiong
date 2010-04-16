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
		menuState.setSelectedMenuItem(event.getComponent().getId());  
		System.out.println(event.getComponent().getId());
		System.out.println(event.getComponent().getAttributes().get("value"));
	}

}

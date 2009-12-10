package com.ejd.web.vo.richfaces.header;

import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;

public class ProductPanelBarBean {
	private static ProductPanelBarBean instance = null;
	
	private UIComponent panelBar;
	
	private String currentBar = "";
	
	public String getCurrentBar() {
		return currentBar;
	}
	
	public void setCurrentBar(String currentBar) {
		this.currentBar = currentBar;
		System.out.println("Bean.setCurrentTab(): " + currentBar);
	}
	
	public UIComponent getPanelBar() {
		return panelBar;
	}
	public void setPanelBar(UIComponent panelBar) {
		this.panelBar = panelBar;
	}
	
	public static synchronized ProductPanelBarBean getInstance() {
		if (null == instance){
			instance = new ProductPanelBarBean();
		}
		return instance;
	}
	public void valueChanged(ValueChangeEvent event) {
		System.out.println("Bean.valueChanged()");
		System.out.println("Old value: " + event.getOldValue());
		System.out.println("New value: " + event.getNewValue());
	}
}

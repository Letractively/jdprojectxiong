package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;

import org.richfaces.component.UITabPanel;

/**
 * @author $Autor$
 *
 */
public class TabPanelBean {
	private UIComponent tabPanel;
	
	private static final String NONE = "none";
	
	private String disabledTabName = NONE;
	
	private String currentTab = "";
	
	private String value1 = "test1";
	private String value2 = "test2";
	private String value3 = "test3";
	
	public String getCurrentTab() {
		return currentTab;
	}
	
	public void setCurrentTab(String currentTab) {
		this.currentTab = currentTab;
		System.out.println("Bean.setCurrentTab(): " + currentTab);
	}
	
	public UIComponent getTabPanel() {
		return tabPanel;
	}
	public void setTabPanel(UIComponent tabPanel) {
		this.tabPanel = tabPanel;
	}
	public String getDisabledTabName() {
		return disabledTabName;
	}
	public void setDisabledTabName(String disabledTabId) {
		this.disabledTabName = disabledTabId;
		
	}

	public String disableTab() {
		UITabPanel tabPanel = (UITabPanel) getTabPanel();
		Object value = tabPanel.getValue();
		if (value != null && value.equals(disabledTabName)) {
			List tabNames = getTabNames();
			int idx = tabNames.indexOf(value);

			int i = idx + 1;
			if (i >= tabNames.size()) {

				if (!tabNames.isEmpty()) {
					tabPanel.setValue(tabNames.get(0));
				}

			} else {
				tabPanel.setValue(tabNames.get(i));
			}
		}
		
		return null;
	}

	private static final List tabNames = new ArrayList();
	
	static {
		tabNames.add("canon");
		tabNames.add("nikon");
		tabNames.add("olympus");
	}
	
	public List getTabNames() {
		return tabNames;
	}
	
	public String getValue1() {
		return value1;
	}
	
	public String getValue2() {
		return value2;
	}
	
	public String getValue3() {
		return value3;
	}
	
	public void setValue1(String value1) {
		System.out.println("Bean.setValue1()"+value1);
		this.value1 = value1;
	}
	public void setValue2(String value2) {
		System.out.println("Bean.setValue2()"+value2);
		this.value2 = value2;
	}
	
	public void setValue3(String value3) {
		System.out.println("Bean.setValue3()"+value3);
		this.value3 = value3;
	}

	public void valueChanged(ValueChangeEvent event) {
		System.out.println("Bean.valueChanged()");
		System.out.println("Old value: " + event.getOldValue());
		System.out.println("New value: " + event.getNewValue());
	}
}

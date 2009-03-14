package com.ejd.web.vo.richfaces;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.richfaces.component.UIDropDownMenu;
import org.richfaces.component.UIMenuGroup;
import org.richfaces.component.UIMenuItem;
import org.richfaces.component.html.HtmlDropDownMenu;
import org.richfaces.component.html.HtmlMenuGroup;
import org.richfaces.component.html.HtmlMenuItem;
import org.richfaces.component.html.HtmlToolBar;
import org.richfaces.taglib.PanelMenuTag;
import javax.faces.component.UIComponent;

public class ManageHeaderMenu {
	private UIComponent curComponent = null;
	private String menuTitle = "";
	private String curString = "";
    private List<String> componentList = new ArrayList<String>();
	public String updateCurrent()
    {
		FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        return (String) map.get("current");
    }
	public void actionListener(ActionEvent event) {
		String tempMenuTitle="";
		if (componentList != null) {
			componentList.clear();
		}
		this.setCurComponent(null);
		this.setMenuTitle("");
		curComponent = event.getComponent();
		this.setCurString("");
		do{
			
		if (curComponent instanceof HtmlMenuItem) {
			HtmlMenuItem curUIMenuItemComponent = (HtmlMenuItem) curComponent;
			this.setCurString(curUIMenuItemComponent.getValue().toString());
		}
		if (curComponent instanceof HtmlMenuGroup) {
			HtmlMenuGroup curUIMenuGroupComponent = (HtmlMenuGroup) curComponent;
			this.setCurString(curUIMenuGroupComponent.getValue().toString());
		}
		if (curComponent instanceof HtmlDropDownMenu) {
			HtmlDropDownMenu curUIDropDownMenuComponent = (HtmlDropDownMenu) curComponent;
			this.setCurString(curUIDropDownMenuComponent.getValue().toString());
		}
		componentList.add(curString);
		curComponent = curComponent.getParent();
		if (curComponent instanceof HtmlToolBar) {
			break;
		}
		} while(curComponent != null);
		this.setMenuTitle("");
		if (componentList != null && componentList.size() >0) {
			for (int i=componentList.size()-1;i>=0;i--) {
				tempMenuTitle = tempMenuTitle + ">>" + componentList.get(i);
			}
		}
		this.setMenuTitle(tempMenuTitle);
	}
	public UIComponent getCurComponent() {
		return curComponent;
	}
	public void setCurComponent(UIComponent curComponent) {
		this.curComponent = curComponent;
	}
	public String getMenuTitle() {
		return menuTitle;
	}
	public void setMenuTitle(String menuTitle) {
		this.menuTitle = menuTitle;
	}
	public String getCurString() {
		return curString;
	}
	public void setCurString(String curString) {
		this.curString = curString;
	}
	public List<String> getComponentList() {
		return componentList;
	}
	public void setComponentList(List<String> componentList) {
		this.componentList = componentList;
	}
	
}

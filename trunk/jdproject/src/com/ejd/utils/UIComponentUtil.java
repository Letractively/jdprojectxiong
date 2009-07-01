package com.ejd.utils;

import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;

public final class UIComponentUtil {
	public UIComponentUtil() {
	  }
	public static List<UIComponent> getComponentChildren(UIComponent component,Map componentMap){ 
        List<UIComponent> componentList = null; 
        addComponentToAllList(component,componentMap); 
        if(component.getChildCount() > 0){ 
            for(UIComponent ui : component.getChildren()){ 
                componentList = getComponentChildren(ui,componentMap); 
            } 
        } 
        return componentList; 
    }
	
	public static void addComponentToAllList(UIComponent component,Map<String,UIComponent> map) {
		map.put(component.getId(), component);
	}
}

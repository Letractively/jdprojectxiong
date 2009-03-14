package com.ejd.web.vo.richfaces;

import java.util.Map;

import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.richfaces.taglib.PanelMenuTag;
import javax.faces.component.UIComponent;

public class ManagePanelMenu {
	
	public String updateCurrent()
    {
		FacesContext context = FacesContext.getCurrentInstance();
        Map map = context.getExternalContext().getRequestParameterMap();
        return (String) map.get("current");
    }

}

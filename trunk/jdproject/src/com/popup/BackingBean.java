package com.popup;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import com.ejd.utils.SpringFacesUtil;

public class BackingBean {
   private String country = "USA";
   private String state = "USA";
   private String viewId;
   private static Map states;

   // PROPERTY: country
   public String getCountry() { return country; }
   public void setCountry(String newValue) { country = newValue; }

   // PROPERTY: state
   public String getState() { return state; }
   public void setState(String newValue) { state = newValue; }

   public String getViewId() {
	   System.out.println(FacesContext.getCurrentInstance().getViewRoot().getViewId());
	return FacesContext.getCurrentInstance().getViewRoot().getViewId();
	
}
public void setViewId(String viewId) {
	this.viewId = viewId;
}
public Map getStates() { return states; }

   public String[] getStatesForCountry() { return (String[]) states.get(country); }

   static {
      states = new HashMap();
      states.put("USA", 
         new String[] {
            "Alabama", "Alaska", "Arizona", "Arkansas", "California", 
            "Colorado", "Connecticut", "Delaware", "Florida", "Georgia", 
            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", 
            "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", 
            "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", 
            "Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", 
            "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", 
            "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", 
            "South Dakota", "Tennessee", "Texas", "Utah", "Vermont", 
            "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"
         });

      states.put("Canada", 
         new String[] { 
            "Alberta", "British Columbia", "Manitoba", "New Brunswick", 
            "Newfoundland and Labrador", "Northwest Territories", 
            "Nova Scotia", "Nunavut", "Ontario", "Prince Edward Island", 
            "Quebec", "Saskatchewan", "Yukon"
         });
   }
   public String popudbclick() {
	   String state = SpringFacesUtil.getRequestParameter("state");
	   String preViewId = SpringFacesUtil.getRequestParameter("viewId");
	   System.out.println(preViewId);
	   String nowviewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
	   UIViewRoot uivr = FacesContext.getCurrentInstance().getViewRoot();
	   UIComponent uict = FacesContext.getCurrentInstance().getViewRoot().findComponent("j_id3:state");
	   //String pareenviewid = FacesContext.getCurrentInstance().getViewRoot().
	   BackingBean bbb =(BackingBean) SpringFacesUtil.getManagedBean("bb");
	   bbb.setState("testvalue");
	   this.setState("testvalue");
	   uict.processUpdates(FacesContext.getCurrentInstance());
	   System.out.println(state+"bean:"+bbb.getState());
	   //SpringFacesUtil.redirectPage("/popup/index2.jsp");
	   return null;
   }
   public void ActionListenerTest(ActionEvent e) {
	   UIComponent uict = e.getComponent();
	   UIViewRoot uivr = FacesContext.getCurrentInstance().getViewRoot();
	   String nowviewId = FacesContext.getCurrentInstance().getViewRoot().getViewId();
	}
}

package com.ejd.web.vo.richfaces.header;
import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;

import org.richfaces.component.UITabPanel;

import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.richfaces.header.HeaderConstants;

public class HeaderTabPanelBean {
	//define menu start
	private Menu kitchenAppliance = null;
	private Menu householdAppliance = null;
	private Menu personalCare = null;
	private Menu healthDevice = null;
	private Menu majorAppliance = null;
	private Menu phoneDigital = null;
	private Menu computerNetwork = null;
	//define menu end
	
	private UIComponent tabPanel;
	
	private static final String NONE = "none";
	
	private String disabledTabName = NONE;
	
	private String currentTab = "";
	
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
		tabNames.add(HeaderConstants.KITCHEN_APPLIANCE);
		tabNames.add(HeaderConstants.HOUSEHOLD_APPLIANCE);
		tabNames.add(HeaderConstants.PERSONAL_CARE);
		tabNames.add(HeaderConstants.HEALTH_DEVICE);
		tabNames.add(HeaderConstants.MAJOR_APPLIANCE);
		tabNames.add(HeaderConstants.PHONE_DIGITAL);
		tabNames.add(HeaderConstants.COMPUTER_NETWORK);
	}
	public List getTabNames() {
		return tabNames;
	}
	public Menu getKitchenAppliance() {
		return kitchenAppliance;
	}

	public void setKitchenAppliance(Menu kitchenAppliance) {
		this.kitchenAppliance = kitchenAppliance;
	}
	
	public Menu getHouseholdAppliance() {
		return householdAppliance;
	}

	public void setHouseholdAppliance(Menu householdAppliance) {
		this.householdAppliance = householdAppliance;
	}

	public Menu getPersonalCare() {
		return personalCare;
	}

	public void setPersonalCare(Menu personalCare) {
		this.personalCare = personalCare;
	}

	public Menu getHealthDevice() {
		return healthDevice;
	}

	public void setHealthDevice(Menu healthDevice) {
		this.healthDevice = healthDevice;
	}

	public Menu getMajorAppliance() {
		return majorAppliance;
	}

	public void setMajorAppliance(Menu majorAppliance) {
		this.majorAppliance = majorAppliance;
	}

	public Menu getPhoneDigital() {
		return phoneDigital;
	}

	public void setPhoneDigital(Menu phoneDigital) {
		this.phoneDigital = phoneDigital;
	}

	public Menu getComputerNetwork() {
		return computerNetwork;
	}

	public void setComputerNetwork(Menu computerNetwork) {
		this.computerNetwork = computerNetwork;
	}

	public HeaderTabPanelBean() {
		if (null == kitchenAppliance) {
			kitchenAppliance = new Menu();
			kitchenAppliance.setMainMenu(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,"",HeaderConstants.KITCHEN_APPLIANCE,HeaderConstants.KITCHEN_APPLIANCE_DESCRIPTION));
			List<MenuItem> subKitchenAppliance = new ArrayList<MenuItem>();
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu01,HeaderConstants.KITCHEN_APPLIANCE_RICE_COOKER_NAME,HeaderConstants.KITCHEN_APPLIANCE_RICE_COOKER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu02,HeaderConstants.KITCHEN_APPLIANCE_INDUCTION_COOKER_NAME,HeaderConstants.KITCHEN_APPLIANCE_INDUCTION_COOKER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu03,HeaderConstants.KITCHEN_APPLIANCE_ELECTRIC_STEW_PAN_NAME,HeaderConstants.KITCHEN_APPLIANCE_ELECTRIC_STEW_PAN_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu04,HeaderConstants.KITCHEN_APPLIANCE_ELECTRONIC_OVEN_NAME,HeaderConstants.KITCHEN_APPLIANCE_ELECTRONIC_OVEN_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu05,HeaderConstants.KITCHEN_APPLIANCE_FRYER_NAME,HeaderConstants.KITCHEN_APPLIANCE_FRYER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu06,HeaderConstants.KITCHEN_APPLIANCE_BURNTSTEWPOT_NAME,HeaderConstants.KITCHEN_APPLIANCE_BURNTSTEWPOT_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu07,HeaderConstants.KITCHEN_APPLIANCE_ELECTRICSTEAMER_NAME,HeaderConstants.KITCHEN_APPLIANCE_ELECTRICSTEAMER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu08,HeaderConstants.KITCHEN_APPLIANCE_ELECTRIC_PRESSURE_COOKER_NAME,HeaderConstants.KITCHEN_APPLIANCE_ELECTRIC_PRESSURE_COOKER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu09,HeaderConstants.KITCHEN_APPLIANCE_YOGURT_MACHINE_NAME,HeaderConstants.KITCHEN_APPLIANCE_YOGURT_MACHINE_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu10,HeaderConstants.KITCHEN_APPLIANCE_EGGCOOKER_NAME,HeaderConstants.KITCHEN_APPLIANCE_RICE_EGGCOOKER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu11,HeaderConstants.KITCHEN_APPLIANCE_WHISK_NAME,HeaderConstants.KITCHEN_APPLIANCE_WHISK_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu12,HeaderConstants.KITCHEN_APPLIANCE_BREADKNIFE_NAME,HeaderConstants.KITCHEN_APPLIANCE_BREADKNIFE_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu13,HeaderConstants.KITCHEN_APPLIANCE_TOASTER_NAME,HeaderConstants.KITCHEN_APPLIANCE_TOASTER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu14,HeaderConstants.KITCHEN_APPLIANCE_MICROWAVE_OVEN_NAME,HeaderConstants.KITCHEN_APPLIANCE_MICROWAVE_OVEN_DESCRIPTION));
			kitchenAppliance.setSubMenu(subKitchenAppliance);
		}
		if (null == householdAppliance) {
			householdAppliance = new Menu();
			householdAppliance.setMainMenu(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,"",HeaderConstants.HOUSEHOLD_APPLIANCE,HeaderConstants.HOUSEHOLD_APPLIANCE_DESCRIPTION));
		}
		if (null == personalCare) {
			personalCare = new Menu();
			personalCare.setMainMenu(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,"",HeaderConstants.PERSONAL_CARE,HeaderConstants.PERSONAL_CARE_DESCRIPTION));
		}
		if (null == healthDevice) {
			healthDevice = new Menu();
			healthDevice.setMainMenu(new MenuItem(HeaderConstants.HEALTH_DEVICE_ID,"",HeaderConstants.HEALTH_DEVICE,HeaderConstants.HEALTH_DEVICE_DESCRIPTION));
		}
		if (null == majorAppliance) {
			majorAppliance = new Menu();
			majorAppliance.setMainMenu(new MenuItem(HeaderConstants.MAJOR_APPLIANCE_ID,"",HeaderConstants.MAJOR_APPLIANCE,HeaderConstants.MAJOR_APPLIANCE_DESCRIPTION));
		}
		if (null == phoneDigital) {
			phoneDigital = new Menu();
			phoneDigital.setMainMenu(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,"",HeaderConstants.PHONE_DIGITAL,HeaderConstants.PHONE_DIGITAL_DESCRIPTION));
		}
		if (null == computerNetwork) {
			computerNetwork = new Menu();
			computerNetwork.setMainMenu(new MenuItem(HeaderConstants.COMPUTER_NETWORK_ID,"",HeaderConstants.COMPUTER_NETWORK,HeaderConstants.COMPUTER_NETWORK_DESCRIPTION));
		}
	}
	public void valueChanged(ValueChangeEvent event) {
		System.out.println("Bean.valueChanged()");
		System.out.println("Old value: " + event.getOldValue());
		System.out.println("New value: " + event.getNewValue());
	}
	
	
	//redirt
	public String gotoProduct(){
		String aa = (String) SpringFacesUtil.getRequestParameter("idFirst");
		String bb = (String) SpringFacesUtil.getRequestParameter("idSecond");
		String dd = (String) SpringFacesUtil.getRequestParameter("productType");
		return dd;
	}
	

}

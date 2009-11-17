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
		tabNames.add(HeaderConstants.KITCHEN_APPLIANCE_NAME);
		tabNames.add(HeaderConstants.HOUSEHOLD_APPLIANCE_NAME);
		tabNames.add(HeaderConstants.PERSONAL_CARE_NAME);
		tabNames.add(HeaderConstants.HEALTH_DEVICE_NAME);
		tabNames.add(HeaderConstants.MAJOR_APPLIANCE_NAME);
		tabNames.add(HeaderConstants.PHONE_DIGITAL_NAME);
		tabNames.add(HeaderConstants.COMPUTER_NETWORK_NAME);
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
			kitchenAppliance.setMainMenu(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,"",HeaderConstants.KITCHEN_APPLIANCE_NAME,HeaderConstants.KITCHEN_APPLIANCE_DESCRIPTION));
			List<MenuItem> subKitchenAppliance = new ArrayList<MenuItem>();
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu00,HeaderConstants.KITCHEN_APPLIANCE_NAME,HeaderConstants.PRODUCT_ALL_DESCRIPTION));
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
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu15,HeaderConstants.KITCHEN_APPLIANCE_DISINFECTION_CABINET_NAME,HeaderConstants.KITCHEN_APPLIANCE_DISINFECTION_CABINET_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu16,HeaderConstants.KITCHEN_APPLIANCE_SAUCEPAN_NAME,HeaderConstants.KITCHEN_APPLIANCE_SAUCEPAN_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu17,HeaderConstants.KITCHEN_APPLIANCE_CUISINE_MACHINE_NAME,HeaderConstants.KITCHEN_APPLIANCE_CUISINE_MACHINE_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu18,HeaderConstants.KITCHEN_APPLIANCE_MEATCHOPPER_NAME,HeaderConstants.KITCHEN_APPLIANCE_MEATCHOPPER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu19,HeaderConstants.KITCHEN_APPLIANCE_COFFEE_MACHINE_NAME,HeaderConstants.KITCHEN_APPLIANCE_COFFEE_MACHINE_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu20,HeaderConstants.KITCHEN_APPLIANCE_BAKINGBOWL_MACHINE_NAME,HeaderConstants.KITCHEN_APPLIANCE_BAKINGBOWL_MACHINE_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu21,HeaderConstants.KITCHEN_APPLIANCE_GASSTOVE_NAME,HeaderConstants.KITCHEN_APPLIANCE_GASSTOVE_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu22,HeaderConstants.KITCHEN_APPLIANCE_FRUITSPARSECLEARING_MACHINE_NAME,HeaderConstants.KITCHEN_APPLIANCE_FRUITSPARSECLEARING_MACHINE_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu23,HeaderConstants.KITCHEN_APPLIANCE_FOODPROCESSING_MACHINE_NAME,HeaderConstants.KITCHEN_APPLIANCE_FOODPROCESSING_MACHINE_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu24,HeaderConstants.KITCHEN_APPLIANCE_JUICER_NAME,HeaderConstants.KITCHEN_APPLIANCE_JUICER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu25,HeaderConstants.KITCHEN_APPLIANCE_GASWATERHEATER_NAME,HeaderConstants.KITCHEN_APPLIANCE_GASWATERHEATER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu26,HeaderConstants.KITCHEN_APPLIANCE_ELECTRICWATERHEATER_NAME,HeaderConstants.KITCHEN_APPLIANCE_ELECTRICWATERHEATER_DESCRIPTION));
			subKitchenAppliance.add(new MenuItem(HeaderConstants.KITCHEN_APPLIANCE_ID,HeaderConstants.subMenu27,HeaderConstants.KITCHEN_APPLIANCE_VENTILATOR_NAME,HeaderConstants.KITCHEN_APPLIANCE_VENTILATOR_DESCRIPTION));
			kitchenAppliance.setSubMenu(subKitchenAppliance);
		}
		if (null == householdAppliance) {
			householdAppliance = new Menu();
			householdAppliance.setMainMenu(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,"",HeaderConstants.HOUSEHOLD_APPLIANCE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_DESCRIPTION));
			List<MenuItem> subHouseholdAppliance = new ArrayList<MenuItem>();
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu00,HeaderConstants.HOUSEHOLD_APPLIANCE_NAME,HeaderConstants.PRODUCT_ALL_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu01,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_KETTLE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_KETTLE_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu02,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_FAN_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_FAN_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu03,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_IRON_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_IRON_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu04,HeaderConstants.HOUSEHOLD_APPLIANCE_VACUUM_CLEANER_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_VACUUM_CLEANER_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu05,HeaderConstants.HOUSEHOLD_APPLIANCE_HUMIDIFIER_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_HUMIDIFIER_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu06,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_HEATER_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_HEATER_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu07,HeaderConstants.HOUSEHOLD_APPLIANCE_SOYMILKMAKER_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_SOYMILKMAKER_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu08,HeaderConstants.HOUSEHOLD_APPLIANCE_PEELING_MACHINE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_PEELING_MACHINE_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu09,HeaderConstants.HOUSEHOLD_APPLIANCE_WATER_DISPENSER_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_WATER_DISPENSER_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu10,HeaderConstants.HOUSEHOLD_APPLIANCE_HOTBOTTLE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_HOTBOTTLE_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu11,HeaderConstants.HOUSEHOLD_APPLIANCE_VACUUM_CUP_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_VACUUM_CUP_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu12,HeaderConstants.HOUSEHOLD_APPLIANCE_TELEPHONE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_TELEPHONE_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu13,HeaderConstants.HOUSEHOLD_APPLIANCE_OXYGEN_MACHINE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_OXYGEN_MACHINE_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu14,HeaderConstants.HOUSEHOLD_APPLIANCE_MOSQUITOSMOKE_MACHINE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_MOSQUITOSMOKE_MACHINE_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu15,HeaderConstants.HOUSEHOLD_APPLIANCE_ADMISSIONBAG_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_ADMISSIONBAG_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu16,HeaderConstants.HOUSEHOLD_APPLIANCE_SEWINGMACHINE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_SEWINGMACHINE_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu17,HeaderConstants.HOUSEHOLD_APPLIANCE_INSULATIONBOXES_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_INSULATIONBOXES_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu18,HeaderConstants.HOUSEHOLD_APPLIANCE_PURIFIEDWATER_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_PURIFIEDWATER_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu19,HeaderConstants.HOUSEHOLD_APPLIANCE_POWERTOOLS_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_POWERTOOLS_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu20,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_TOOTHBRUSH_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_ELECTRIC_TOOTHBRUSH_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu21,HeaderConstants.HOUSEHOLD_APPLIANCE_SPINBRUSH_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_SPINBRUSH_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu22,HeaderConstants.HOUSEHOLD_APPLIANCE_STEAMMOP_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_STEAMMOP_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu23,HeaderConstants.HOUSEHOLD_APPLIANCE_STEAM_CLEANING_MACHINE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_STEAM_CLEANING_MACHINE_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu24,HeaderConstants.HOUSEHOLD_APPLIANCE_LINKED_TOHOT_STEAM_MACHINE_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_LINKED_TOHOT_STEAM_MACHINE_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu25,HeaderConstants.HOUSEHOLD_APPLIANCE_AIR_PURIFIER_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_AIR_PURIFIER_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu26,HeaderConstants.HOUSEHOLD_APPLIANCE_VACUUMCLEANERACCESSORIES_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_VACUUMCLEANERACCESSORIES_DESCRIPTION));
			subHouseholdAppliance.add(new MenuItem(HeaderConstants.HOUSEHOLD_APPLIANCE_ID,HeaderConstants.subMenu27,HeaderConstants.HOUSEHOLD_APPLIANCE_SOCKETPOWER_NAME,HeaderConstants.HOUSEHOLD_APPLIANCE_SOCKETPOWER_DESCRIPTION));
			householdAppliance.setSubMenu(subHouseholdAppliance);
		}
		if (null == personalCare) {
			personalCare = new Menu();
			personalCare.setMainMenu(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,"",HeaderConstants.PERSONAL_CARE_NAME,HeaderConstants.PERSONAL_CARE_DESCRIPTION));
			List<MenuItem> subPersonalCare = new ArrayList<MenuItem>();
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu00,HeaderConstants.PERSONAL_CARE_NAME,HeaderConstants.PRODUCT_ALL_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu01,HeaderConstants.PERSONAL_CARE_HAIR_DRYER_NAME,HeaderConstants.PERSONAL_CARE_HAIR_DRYER_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu02,HeaderConstants.PERSONAL_CARE_SHAVER_NAME,HeaderConstants.PERSONAL_CARE_SHAVER_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu03,HeaderConstants.PERSONAL_CARE_FITTINGS_NAME,HeaderConstants.PERSONAL_CARE_FITTINGS_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu04,HeaderConstants.PERSONAL_CARE_HAIRCUT_NAME,HeaderConstants.PERSONAL_CARE_HAIRCUT_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu05,HeaderConstants.PERSONAL_CARE_DEPILATOR_NAME,HeaderConstants.PERSONAL_CARE_DEPILATOR_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu06,HeaderConstants.PERSONAL_CARE_MARCELWAVER_NAME,HeaderConstants.PERSONAL_CARE_MARCELWAVER_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu07,HeaderConstants.PERSONAL_CARE_SHOWER_LAMP_NAME,HeaderConstants.PERSONAL_CARE_SHOWER_LAMP_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu08,HeaderConstants.PERSONAL_CARE_PRUNINGDEVICE_NAME,HeaderConstants.PERSONAL_CARE_PRUNINGDEVICE_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu09,HeaderConstants.PERSONAL_CARE_FITNESSEQUIPMENT_NAME,HeaderConstants.PERSONAL_CARE_FITNESSEQUIPMENT_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu10,HeaderConstants.PERSONAL_CARE_OXYGEN_BAR_NAME,HeaderConstants.PERSONAL_CARE_OXYGEN_BAR_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu11,HeaderConstants.PERSONAL_CARE_CURLEYELASHESBROWSER_NAME,HeaderConstants.PERSONAL_CARE_CURLEYELASHESBROWSER_DESCRIPTION));
			subPersonalCare.add(new MenuItem(HeaderConstants.PERSONAL_CARE_ID,HeaderConstants.subMenu12,HeaderConstants.PERSONAL_CARE_SKINCARE_NAME,HeaderConstants.PERSONAL_CARE_SKINCARE_DESCRIPTION));
			personalCare.setSubMenu(subPersonalCare);
		}
		if (null == healthDevice) {
			healthDevice = new Menu();
			healthDevice.setMainMenu(new MenuItem(HeaderConstants.HEALTH_DEVICE_ID,"",HeaderConstants.HEALTH_DEVICE_NAME,HeaderConstants.HEALTH_DEVICE_DESCRIPTION));
			List<MenuItem> subHealthDevice = new ArrayList<MenuItem>();
			subHealthDevice.add(new MenuItem(HeaderConstants.HEALTH_DEVICE_ID,HeaderConstants.subMenu00,HeaderConstants.HEALTH_DEVICE_NAME,HeaderConstants.PRODUCT_ALL_DESCRIPTION));
			subHealthDevice.add(new MenuItem(HeaderConstants.HEALTH_DEVICE_ID,HeaderConstants.subMenu01,HeaderConstants.HEALTH_DEVICE_SNORING_DEVICE_NAME,HeaderConstants.HEALTH_DEVICE_SNORING_DEVICE_DESCRIPTION));
			subHealthDevice.add(new MenuItem(HeaderConstants.HEALTH_DEVICE_ID,HeaderConstants.subMenu02,HeaderConstants.HEALTH_DEVICE_SLEEPING_SPECS_NAME,HeaderConstants.HEALTH_DEVICE_SLEEPING_SPECS_DESCRIPTION));
			subHealthDevice.add(new MenuItem(HeaderConstants.HEALTH_DEVICE_ID,HeaderConstants.subMenu03,HeaderConstants.HEALTH_DEVICE_ELECTRONIC_WEIGHER_NAME,HeaderConstants.HEALTH_DEVICE_ELECTRONIC_WEIGHER_DESCRIPTION));
			subHealthDevice.add(new MenuItem(HeaderConstants.HEALTH_DEVICE_ID,HeaderConstants.subMenu04,HeaderConstants.HEALTH_DEVICE_TABLE_LAMP_NAME,HeaderConstants.HEALTH_DEVICE_TABLE_LAMP_DESCRIPTION));
			subHealthDevice.add(new MenuItem(HeaderConstants.HEALTH_DEVICE_ID,HeaderConstants.subMenu05,HeaderConstants.HEALTH_DEVICE_MASSAGER_NAME,HeaderConstants.HEALTH_DEVICE_MASSAGER_DESCRIPTION));
			subHealthDevice.add(new MenuItem(HeaderConstants.HEALTH_DEVICE_ID,HeaderConstants.subMenu06,HeaderConstants.HEALTH_DEVICE_ELECTRONIC_SPHYGMOMANOMETER_NAME,HeaderConstants.HEALTH_DEVICE_ELECTRONIC_SPHYGMOMANOMETER_DESCRIPTION));
			healthDevice.setSubMenu(subHealthDevice);
		}
		if (null == majorAppliance) {
			majorAppliance = new Menu();
			majorAppliance.setMainMenu(new MenuItem(HeaderConstants.MAJOR_APPLIANCE_ID,"",HeaderConstants.MAJOR_APPLIANCE_NAME,HeaderConstants.MAJOR_APPLIANCE_DESCRIPTION));
			List<MenuItem> subMajorAppliance = new ArrayList<MenuItem>();
			subMajorAppliance.add(new MenuItem(HeaderConstants.MAJOR_APPLIANCE_ID,HeaderConstants.subMenu00,HeaderConstants.MAJOR_APPLIANCE_NAME,HeaderConstants.PRODUCT_ALL_DESCRIPTION));
			subMajorAppliance.add(new MenuItem(HeaderConstants.MAJOR_APPLIANCE_ID,HeaderConstants.subMenu01,HeaderConstants.MAJOR_APPLIANCE_TV_NAME,HeaderConstants.MAJOR_APPLIANCE_TV_DESCRIPTION));
			subMajorAppliance.add(new MenuItem(HeaderConstants.MAJOR_APPLIANCE_ID,HeaderConstants.subMenu02,HeaderConstants.MAJOR_APPLIANCE_REFRIGERATOR_NAME,HeaderConstants.MAJOR_APPLIANCE_REFRIGERATOR_DESCRIPTION));
			subMajorAppliance.add(new MenuItem(HeaderConstants.MAJOR_APPLIANCE_ID,HeaderConstants.subMenu03,HeaderConstants.MAJOR_APPLIANCE_AIR_CONDITIONER_NAME,HeaderConstants.MAJOR_APPLIANCE_AIR_CONDITIONER_DESCRIPTION));
			subMajorAppliance.add(new MenuItem(HeaderConstants.MAJOR_APPLIANCE_ID,HeaderConstants.subMenu04,HeaderConstants.MAJOR_APPLIANCE_WASHING_MACHINE_NAME,HeaderConstants.MAJOR_APPLIANCE_WASHING_MACHINE_DESCRIPTION));
			majorAppliance.setSubMenu(subMajorAppliance);
		}
		if (null == phoneDigital) {
			phoneDigital = new Menu();
			phoneDigital.setMainMenu(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,"",HeaderConstants.PHONE_DIGITAL_NAME,HeaderConstants.PHONE_DIGITAL_DESCRIPTION));
			List<MenuItem> subPhoneDigital = new ArrayList<MenuItem>();
			subPhoneDigital.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu00,HeaderConstants.PHONE_DIGITAL_NAME,HeaderConstants.PRODUCT_ALL_DESCRIPTION));
			subPhoneDigital.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu01,HeaderConstants.PHONE_DIGITAL_DIGITALFITTING_NAME,HeaderConstants.PHONE_DIGITAL_DIGITALFITTING_DESCRIPTION));
			subPhoneDigital.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu02,HeaderConstants.PHONE_DIGITAL_MOBILE_PHONE_NAME,HeaderConstants.PHONE_DIGITAL_MOBILE_PHONE_DESCRIPTION));
			subPhoneDigital.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu03,HeaderConstants.PHONE_DIGITAL_MOBILE_PHONE_ACCESSORIES_NAME,HeaderConstants.PHONE_DIGITAL_MOBILE_PHONE_ACCESSORIES_DESCRIPTION));
			subPhoneDigital.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu04,HeaderConstants.PHONE_DIGITAL_RECORDER_PEN_NAME,HeaderConstants.PHONE_DIGITAL_RECORDER_PEN_DESCRIPTION));
			subPhoneDigital.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu05,HeaderConstants.PHONE_DIGITAL_MPEG_AUDIO_LAYER_NAME,HeaderConstants.PHONE_DIGITAL_MPEG_AUDIO_LAYER_DESCRIPTION));
			subPhoneDigital.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu06,HeaderConstants.PHONE_DIGITAL_GLOBAL_POSITIONING_SYSTEM_NAME,HeaderConstants.PHONE_DIGITAL_GLOBAL_POSITIONING_SYSTEM_DESCRIPTION));
			subPhoneDigital.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu07,HeaderConstants.PHONE_DIGITAL_DIGITAL_PHOTO_FRAME_NAME,HeaderConstants.PHONE_DIGITAL_DIGITAL_PHOTO_FRAME_DESCRIPTION));
			phoneDigital.setSubMenu(subPhoneDigital);
		}
		if (null == computerNetwork) {
			computerNetwork = new Menu();
			computerNetwork.setMainMenu(new MenuItem(HeaderConstants.COMPUTER_NETWORK_ID,"",HeaderConstants.COMPUTER_NETWORK_NAME,HeaderConstants.COMPUTER_NETWORK_DESCRIPTION));
			List<MenuItem> subComputerNetwork = new ArrayList<MenuItem>();
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu00,HeaderConstants.COMPUTER_NETWORK_NAME,HeaderConstants.PRODUCT_ALL_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu01,HeaderConstants.COMPUTER_NETWORK_USB_STICK_NAME,HeaderConstants.COMPUTER_NETWORK_USB_STICK_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu02,HeaderConstants.COMPUTER_NETWORK_MOUSE_NAME,HeaderConstants.COMPUTER_NETWORK_MOUSE_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu03,HeaderConstants.COMPUTER_NETWORK_KEYBOARD_NAME,HeaderConstants.COMPUTER_NETWORK_KEYBOARD_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu04,HeaderConstants.COMPUTER_NETWORK_AUDIO_DEVICE_NAME,HeaderConstants.COMPUTER_NETWORK_AUDIO_DEVICE_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu05,HeaderConstants.COMPUTER_NETWORK_CHASSIS_NAME,HeaderConstants.COMPUTER_NETWORK_CHASSIS_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu06,HeaderConstants.COMPUTER_NETWORK_WEBCAM_NAME,HeaderConstants.COMPUTER_NETWORK_WEBCAM_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu07,HeaderConstants.COMPUTER_NETWORK_DISPLAY_NAME,HeaderConstants.COMPUTER_NETWORK_DISPLAY_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu08,HeaderConstants.COMPUTER_NETWORK_KEYBOARDANDMOUSEPACKAGE_NAME,HeaderConstants.COMPUTER_NETWORK_KEYBOARDANDMOUSEPACKAGE_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu09,HeaderConstants.COMPUTER_NETWORK_POWERSOURCE_NAME,HeaderConstants.COMPUTER_NETWORK_POWERSOURCE_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu10,HeaderConstants.COMPUTER_NETWORK_PCCOOLER_NAME,HeaderConstants.COMPUTER_NETWORK_PCCOOLER_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu11,HeaderConstants.COMPUTER_NETWORK_HEADSET_NAME,HeaderConstants.COMPUTER_NETWORK_HEADSET_DESCRIPTION));
			subComputerNetwork.add(new MenuItem(HeaderConstants.PHONE_DIGITAL_ID,HeaderConstants.subMenu12,HeaderConstants.COMPUTER_NETWORK_PC_SHARING_DEVICE_NAME,HeaderConstants.COMPUTER_NETWORK_PC_SHARING_DEVICE_DESCRIPTION));
			computerNetwork.setSubMenu(subComputerNetwork);
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
		System.out.println(aa);
		System.out.println(bb);
		System.out.println(dd);
		return dd;
	}
	

}

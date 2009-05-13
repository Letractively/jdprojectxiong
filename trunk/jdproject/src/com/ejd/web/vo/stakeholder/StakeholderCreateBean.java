package com.ejd.web.vo.stakeholder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;

import org.richfaces.component.UIOrderingList;
import org.richfaces.component.UITabPanel;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.ejd.model.service.iface.IStakeholderService;
import net.sf.cglib.beans.BeanCopier;



public class StakeholderCreateBean extends StakeholderBaseBean {
	private StakeholderVo stakeholder;
	private List<PersonVo> persons;
	private PersonVo newPerson;
	private List<AddressVo> addresses;
	private AddressVo newAddress;
	private List<BankVo> banks;
	private BankVo newBank;
	private String controlsType = "button";
	private String controlsHorizontalAlign = "right";
	private String controlsVerticalAlign = "top";
	
	private String ontopclick = "new Effect.Highlight('form:ontopclickDiv', {startcolor:'#FF0000', endcolor:'#FF0000', restorecolor: 'green'});";
	private String onbottomclick = "new Effect.Highlight('form:onbottomclickDiv', {startcolor:'#FF0000', endcolor:'#FF0000', restorecolor: 'green'});";
	
	private boolean orderControlsVisible = true;
	private boolean fastOrderControlsVisible = true;
	//this is for persons tabPersonPanel begin.
	private UIComponent tabPersonPanel;
	
	private static final String NONE = "none";
	
	private String disabledTabPersonName = NONE;
	
	private String currentTabPerson = "createPerson";
	public UIComponent getTabPersonPanel() {
		return tabPersonPanel;
	}
	public void setTabPersonPanel(UIComponent tabPanel) {
		this.tabPersonPanel = tabPanel;
	}
	
	public String getDisabledTabPersonName() {
		return disabledTabPersonName;
	}
	public void setDisabledTabPersonName(String disabledTabPersonName) {
		this.disabledTabPersonName = disabledTabPersonName;
	}
	
	public String getCurrentTabPerson() {
		return currentTabPerson;
	}
	public void setCurrentTabPerson(String currentTabPerson) {
		this.currentTabPerson = currentTabPerson;
	}
	//this is for persons tabPersonPanel end.
	//this is for persons orderingListPerson begin.
	UIOrderingList orderingListPerson;
	UIInput inputPerson;
	private Set<Integer> personsKeys = null;
	Set<PersonVo> personSelections = new HashSet<PersonVo>();

	public UIOrderingList getOrderingListPerson() {
		return orderingListPerson;
	}
	public void setOrderingListPerson(UIOrderingList orderingListPerson) {
		this.orderingListPerson = orderingListPerson;
	}
	public UIInput getInputPerson() {
		return inputPerson;
	}
	public void setInputPerson(UIInput inputPerson) {
		this.inputPerson = inputPerson;
	}
	
	public Set<Integer> getPersonsKeys() {
		return personsKeys;
	}
	public void setPersonsKeys(Set<Integer> personsKeys) {
		this.personsKeys = personsKeys;
	}
	
	public Set<PersonVo> getPersonSelections() {
		return personSelections;
	}
	public void setPersonSelections(Set<PersonVo> personSelections) {
		this.personSelections = personSelections;
	}
	//this is for persons orderingListPerson end.
	public StakeholderVo getStakeholder() {
		return stakeholder;
	}
	public void setStakeholder(StakeholderVo stakeholder) {
		this.stakeholder = stakeholder;
	}
	public List<PersonVo> getPersons() {
		return persons;
	}
	public void setPersons(List<PersonVo> persons) {
		this.persons = persons;
	}
	
	public PersonVo getNewPerson() {
		return newPerson;
	}
	public void setNewPerson(PersonVo newPerson) {
		this.newPerson = newPerson;
	}
	public List<AddressVo> getAddresses() {
		return addresses;
	}
	public void setAddresses(List<AddressVo> addresses) {
		this.addresses = addresses;
	}
	
	public AddressVo getNewAddress() {
		return newAddress;
	}
	public void setNewAddress(AddressVo newAddress) {
		this.newAddress = newAddress;
	}
	public List<BankVo> getBanks() {
		return banks;
	}
	public void setBanks(List<BankVo> banks) {
		this.banks = banks;
	}
	
	public BankVo getNewBank() {
		return newBank;
	}
	public void setNewBank(BankVo newBank) {
		this.newBank = newBank;
	}
	public Integer getPersonsQuantity() {
		if (null == persons) {
			return 0;
		} else {
			return persons.size();
		}
	}
	public Integer getAddressesQuantity() {
		if (null == addresses) {
			return 0;
		} else {
			return addresses.size();
		}
	}
	public Integer getBanksQuantity() {
		if (null == banks) {
			return 0;
		} else {
			return banks.size();
		}
	}
	
	public String getControlsType() {
		return controlsType;
	}

	public void setControlsType(String controlsType) {
		this.controlsType = controlsType;
	}

	public String getControlsHorizontalAlign() {
		return controlsHorizontalAlign;
	}

	public void setControlsHorizontalAlign(String controlsHorizontalAlign) {
		this.controlsHorizontalAlign = controlsHorizontalAlign;
	}

	public String getControlsVerticalAlign() {
		return controlsVerticalAlign;
	}

	public void setControlsVerticalAlign(String controlsVerticalAlign) {
		this.controlsVerticalAlign = controlsVerticalAlign;
	}

	public boolean isOrderControlsVisible() {
		return orderControlsVisible;
	}

	public void setOrderControlsVisible(boolean orderControlsVisible) {
		this.orderControlsVisible = orderControlsVisible;
	}

	public boolean isFastOrderControlsVisible() {
		return fastOrderControlsVisible;
	}

	public void setFastOrderControlsVisible(boolean fastOrderControlsVisible) {
		this.fastOrderControlsVisible = fastOrderControlsVisible;
	}

	public Object getActionResult() {
		return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("actionResult");
	}

	public String getOntopclick() {
		return ontopclick;
	}

	public void setOntopclick(String ontopclick) {
		this.ontopclick = ontopclick;
	}

	public String getOnbottomclick() {
		return onbottomclick;
	}

	public void setOnbottomclick(String onbottomclick) {
		this.onbottomclick = onbottomclick;
	}
	public StakeholderCreateBean() {
		super();
		this.newPerson = new PersonVo();
		newPerson.setSex("M");
		newPerson.setAge(18);
		this.newAddress = new AddressVo();
		this.newBank = new BankVo();
		this.stakeholder = new StakeholderVo();
		this.persons = new ArrayList<PersonVo>();
		this.addresses = new ArrayList<AddressVo>();
		this.banks = new ArrayList<BankVo>();
	}
	public String addNewPerson() {
		FacesContext facesContext = FacesContext.getCurrentInstance();
 		boolean hasExist = false;
		PersonVo tempPerson = new PersonVo();
		BeanCopier copy = BeanCopier.create(PersonVo.class, PersonVo.class, false);
		copy.copy(newPerson, tempPerson, null);
		if (null != persons && persons.size()>0) {
			for(PersonVo pVo:persons){
				if (tempPerson.getName().equals(pVo.getName())) {
					FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","输入的姓名重复！");
					facesContext.addMessage("manageTemplateView:a4jinclude:scpcform:newpersonname", message);
					hasExist = true;
			 		return null;
			 	}
				
			}
			persons.add(tempPerson);
		} else {
			persons.add(tempPerson);
		}
		
		return "";
	}
	public String gotoView() {
		return "stakeholderCreatePersonView";
	}
	public String applyUpdate() {
		List<PersonVo> aa=(List<PersonVo>)orderingListPerson.getValue();
		for (PersonVo aaa:aa) {
			System.out.println(aaa.isSelected());
			System.out.println(aaa.getName());
		}
		for (PersonVo ccc:persons) {
			System.out.println(ccc.isSelected()+"in persons");
			System.out.println(ccc.getName()+"in persons");
		}
		if (null != personSelections & personSelections.size()>0) {
			for (PersonVo ddd:personSelections) {
				System.out.println(ddd.isSelected()+"in personSelections");
				System.out.println(ddd.getName()+"in personSelections");
			}
		} else {
			System.out.println("no selected");
		}
		return null;
	}
	public String valueChangeInputInOrderingListPerson() {
		HashSet Keys = new HashSet<Integer>();
		int rowKey = getOrderingListPerson().getRowIndex();
		Keys.add(rowKey);
		setPersonsKeys(Keys);
		//test
		for(PersonVo v:persons){
			System.out.println(v.getName());
		}
		List<PersonVo> aa=(List<PersonVo>)orderingListPerson.getValue();
		for (PersonVo aaa:aa) {
			System.out.println(aaa.isSelected());
			System.out.println(aaa.getName());
		}
		for (PersonVo ccc:persons) {
			System.out.println(ccc.isSelected()+"in persons");
			System.out.println(ccc.getName()+"in persons");
		}
		if (null != personSelections & personSelections.size()>0) {
			for (PersonVo ddd:personSelections) {
				System.out.println(ddd.isSelected()+"in personSelections");
				System.out.println(ddd.getName()+"in personSelections");
			}
		} else {
			System.out.println("no selected");
		}
		//test
		inputPerson.processValidators(FacesContext.getCurrentInstance());
		inputPerson.processUpdates(FacesContext.getCurrentInstance());
		
		return null;
	}
}

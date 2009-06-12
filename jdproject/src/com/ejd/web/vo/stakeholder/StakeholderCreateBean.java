package com.ejd.web.vo.stakeholder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;

import org.hibernate.mapping.Collection;
import org.richfaces.component.UIOrderingList;
import org.richfaces.component.UITabPanel;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.ejd.model.exception.StakeholderException;
import com.ejd.model.service.iface.IStakeholderService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Address;
import com.ejd.web.bo.Bank;
import com.ejd.web.bo.Person;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.genl.ModalPanelMessagesBean;
import com.ejd.web.vo.richfaces.FileUploadBean;

import net.sf.cglib.beans.BeanCopier;



public class StakeholderCreateBean extends StakeholderBaseBean {
	private StakeholderVo stakeholder;
	private List<PersonVo> persons;
	private PersonVo newPerson;
	private List<AddressVo> addresses;
	private AddressVo newAddress;
	private List<BankVo> banks;
	private BankVo newBank;
	private String addOneStakeholderSuccessOrNot ="";
	private String controlsType = "button";
	private String controlsHorizontalAlign = "right";
	private String controlsVerticalAlign = "top";
	
	private String ontopclick = "new Effect.Highlight('form:ontopclickDiv', {startcolor:'#FF0000', endcolor:'#FF0000', restorecolor: 'green'});";
	private String onbottomclick = "new Effect.Highlight('form:onbottomclickDiv', {startcolor:'#FF0000', endcolor:'#FF0000', restorecolor: 'green'});";
	
	private boolean orderControlsVisible = true;
	private boolean fastOrderControlsVisible = true;
	//this is for persons tabPersonPanel begin.
	private UIComponent tabChoiceInfoPanel;
	
	private static final String NONE = "none";
	
	private String disabledTabChoiceInfoName = NONE;
	
	private String currentTabChoiceInfo = "createPerson";
	
	private boolean disableAddNewPerson = false;
	public boolean isDisableAddNewPerson() {
		if (null == persons) {
			return false;
		} else {
			if (persons.size() >=10) {
				return true;
			} else {
				return false;
			}
		}
	}
	public void setDisableAddNewPerson(boolean disableAddNewPerson) {
		this.disableAddNewPerson = disableAddNewPerson;
	}
	public UIComponent getTabChoiceInfoPanel() {
		return tabChoiceInfoPanel;
	}
	public void setTabChoiceInfoPanel(UIComponent tabPanel) {
		this.tabChoiceInfoPanel = tabPanel;
	}
	
	public String getDisabledTabChoiceInfoName() {
		return disabledTabChoiceInfoName;
	}
	public void setDisabledTabChoiceInfoName(String disabledTabChoiceInfoName) {
		this.disabledTabChoiceInfoName = disabledTabChoiceInfoName;
	}
	
	public String getCurrentTabChoiceInfo() {
		return currentTabChoiceInfo;
	}
	public void setCurrentTabChoiceInfo(String currentTabChoiceInfo) {
		this.currentTabChoiceInfo = currentTabChoiceInfo;
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
	
	public String getAddOneStakeholderSuccessOrNot() {
		return addOneStakeholderSuccessOrNot;
	}
	public void setAddOneStakeholderSuccessOrNot(
			String addOneStakeholderSuccessOrNot) {
		this.addOneStakeholderSuccessOrNot = addOneStakeholderSuccessOrNot;
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
		/*if (null != persons && persons.size()>0) {
			for(PersonVo pVo:persons){
				if (tempPerson.getName().equals(pVo.getName())) {
					FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","输入的姓名重复！");
					facesContext.addMessage("manageTemplateView:a4jincludenew:scpcform:newpersonname", message);
					hasExist = true;
			 		return null;
			 	}
				
			}
			persons.add(tempPerson);
		} else {
			persons.add(tempPerson);
		}*/
		if (null == persons) {
			persons = new ArrayList<PersonVo>();
			persons.add(tempPerson);
		} else {
			if (persons.size() > 10) {
				return null;
			} else {
			persons.add(tempPerson);
			}
		}
		return null;
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
		PersonVo changePersonVo =(PersonVo) getOrderingListPerson().getRowData();
		System.out.print(changePersonVo.isSelected()+changePersonVo.getName()+changePersonVo.getAge()+changePersonVo.getPhone());
		Keys.add(rowKey);
		setPersonsKeys(Keys);
		//test
		/*for(PersonVo v:persons){
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
		}*/
		//test
		inputPerson.processValidators(FacesContext.getCurrentInstance());
		inputPerson.processUpdates(FacesContext.getCurrentInstance());
		FacesContext ctx = FacesContext.getCurrentInstance();
		Iterator co = ctx.getMessages();
		if (co.hasNext()) {
			FacesMessage aaa =(FacesMessage) co.next();
			aaa.getDetail().concat("在第"+rowKey+"行");
		}
		return null;
	}
	public void takeSelection() {
		if (orderingListPerson.isRowAvailable()) {
			if (null != personSelections) {
			
			}
			PersonVo changePersonVo =(PersonVo) getOrderingListPerson().getRowData();
		}
	}
	
	public String addOneStakeholder() throws StakeholderException {
		ModalPanelMessagesBean modalPanelMessagesBean =(ModalPanelMessagesBean) SpringFacesUtil.getManagedBean("modalPanelMessages");
		IStakeholderService  eee =(IStakeholderService) SpringFacesUtil.getSpringBean("stakeholderService");
		

		Stakeholder stakeholder = stakeholderService.getStakeholderByUserId(this.getStakeholder().getUserId());
		if (null != stakeholder) {
			if (null != modalPanelMessagesBean.getMessages() && modalPanelMessagesBean.getMessages().size() > 0) {
			modalPanelMessagesBean.getMessages().clear();
			}
			List<String> tempMessages = new ArrayList<String>();
			tempMessages.add(new String("该用户ID号已存在!请用其他ID号注册!"));
			modalPanelMessagesBean.setMessages(tempMessages);
			//this.setAddOneStakeholderSuccessOrNot("该用户ID号已存在!请用其他ID号注册");
			return null;
		}
		Stakeholder newStakeholder = new Stakeholder();
		StakeholderVo tempStakeholder = this.getStakeholder();
		BeanCopier copy = BeanCopier.create(StakeholderVo.class, Stakeholder.class, false);
		copy.copy(tempStakeholder, newStakeholder, null);
		if (null != this.getPersons() && this.getPersons().size() > 0) {
			List<Person> newPersons = new ArrayList<Person>();
			BeanCopier copyPersons = BeanCopier.create(PersonVo.class, Person.class, false);
			for (int i = 0; i < this.getPersons().size(); i++) {
				PersonVo tempPerson = this.getPersons().get(i);
				Person newPerson = new Person();
				tempPerson.setSortOrder(i+1);
				copyPersons.copy(tempPerson, newPerson, null);
				newPerson.setStakeholder(newStakeholder);
				newPersons.add(newPerson);
			}
			newStakeholder.getConatctMans().addAll(newPersons);
			
		}
		if (null != this.getAddresses() && this.getAddresses().size() > 0) {
			List<Address> newAddresses = new ArrayList<Address>();
			BeanCopier copyAddresses = BeanCopier.create(Address.class, AddressVo.class, false);
			for (int j = 0; j < this.getAddresses().size(); j++) {
				AddressVo tempAddress = this.getAddresses().get(j);
				tempAddress.setSortOrder(j+1);
				Address newAddress = new Address();
				copyAddresses.copy(tempAddress, newAddresses, null);
				newAddress.setStakeholder(newStakeholder);
				newAddresses.add(newAddress);
			}
			newStakeholder.getAddresses().addAll(newAddresses);
		}
		if (null != this.getBanks() && this.getBanks().size() > 0) {
			List<Bank> newBanks = new ArrayList<Bank>();
			BeanCopier copyBanks = BeanCopier.create(BankVo.class, Bank.class, false);
			for (int k = 0; k < this.getBanks().size(); k++) {
				BankVo tempBank = this.getBanks().get(k);
				tempBank.setSortOrder(k+1);
				Bank newBank = new Bank();
				copyBanks.copy(tempBank, newBank, null);
				newBank.setStakeholder(newStakeholder);
				newBanks.add(newBank);
			}
			newStakeholder.getBanks().addAll(newBanks);
		}
		this.getStakeholderService().saveStakeholder(newStakeholder);
		//this.setAddOneStakeholderSuccessOrNot("保存成功!");
		if ( null != modalPanelMessagesBean.getMessages() && modalPanelMessagesBean.getMessages().size() > 0) {
			modalPanelMessagesBean.getMessages().clear();
		}
		List<String> tempMessages = new ArrayList<String>();
		tempMessages.add(new String("保存成功!"));
		modalPanelMessagesBean.setMessages(tempMessages);
		
		return null;
	}
	

}

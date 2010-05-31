package com.ejd.web.vo.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.apache.commons.beanutils.PropertyUtils;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.CommonConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.common.datapage.DataPage;
import com.ejd.model.exception.ConsigneeException;
import com.ejd.model.exception.ProductUnitException;
import com.ejd.model.exception.StakeholderException;
import com.ejd.model.service.iface.IConsigneeService;
import com.ejd.model.service.iface.IProductUnitService;
import com.ejd.model.service.iface.IStakeholderService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.utils.UIComponentUtil;
import com.ejd.web.bo.Consignee;
import com.ejd.web.bo.Person;
import com.ejd.web.bo.Productunit;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.genl.AbstractExtendedTableDataModel;
import com.ejd.web.vo.genl.AbstractTableDataModel;
import com.ejd.web.vo.genl.ITableDataModel;
import com.ejd.web.vo.productunit.ProductUnit;
import com.ejd.web.vo.stakeholder.PersonVo;
import com.ejd.web.vo.stakeholder.StakeholderVo;
import com.ejd.web.vo.user.UserBean;

public class EditPersonPageBean extends AbstractTableDataModel<PersonVo,PersonVo> implements ITableDataModel<PersonVo> {
	
	public IStakeholderService stakeholderService;
	
	private String action;
	
	public String errorMessages;

	public IStakeholderService getStakeholderService() {
		return stakeholderService;
	}

	public void setStakeholderService(IStakeholderService stakeholderService) {
		this.stakeholderService = stakeholderService;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	public Object getIdItem(PersonVo item) {
		return item.getId();
	}
	
	public EditPersonPageBean() {
		super();
		this.setNumberOnePage(CommonConstants.MAX_PERSONS_OF_USER);
	}

	public EditPersonPageBean (String newAnother) {
		super();
		PersonVo personVo = new PersonVo();
		personVo.setSelected(false);
		this.setEditData(personVo);
	}
	public void createNewPerson () {
		PersonVo newPerson = new PersonVo();
		newPerson.setName("");
		newPerson.setAge(18);
		newPerson.setSex("M");
		newPerson.setPhone("");
		newPerson.setTax("");
		newPerson.setMobile("");
		newPerson.setEmail("");
		newPerson.setAddress("");
		newPerson.setPrincipalship("");
		newPerson.setRemark("");
		newPerson.setSelected(Boolean.TRUE);
		this.setEditData(newPerson);
	}
	
	public String reSetPerson() {
		operationAfterExeAction();
		EditPersonPageBean editPersonPage = (EditPersonPageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_PERSON_PAGE_BEAN_NAME);
		if (CommonConstants.ACTION_NEW_TYPE.equals(editPersonPage.getAction())) {
			editPersonPage.getEditData().setId(null);
			editPersonPage.getEditData().setName("");
			editPersonPage.getEditData().setAge(18);
			editPersonPage.getEditData().setSex("M");
			editPersonPage.getEditData().setPhone("");
			editPersonPage.getEditData().setTax("");
			editPersonPage.getEditData().setMobile("");
			editPersonPage.getEditData().setEmail("");
			editPersonPage.getEditData().setAddress("");
			editPersonPage.getEditData().setPrincipalship("");
			editPersonPage.getEditData().setRemark("");
			editPersonPage.getEditData().setSelected(Boolean.TRUE);
		} else if (CommonConstants.ACTION_EDIT_TYPE.equals(editPersonPage.getAction())) {
			editPersonPage.getEditData().setName(editPersonPage.getSelectedData().getName());
			editPersonPage.getEditData().setAge(editPersonPage.getSelectedData().getAge());
			editPersonPage.getEditData().setSex(editPersonPage.getSelectedData().getSex());
			editPersonPage.getEditData().setPhone(editPersonPage.getSelectedData().getPhone());
			editPersonPage.getEditData().setTax(editPersonPage.getSelectedData().getTax());
			editPersonPage.getEditData().setMobile(editPersonPage.getSelectedData().getMobile());
			editPersonPage.getEditData().setEmail(editPersonPage.getSelectedData().getEmail());
			editPersonPage.getEditData().setAddress(editPersonPage.getSelectedData().getAddress());
			editPersonPage.getEditData().setPrincipalship(editPersonPage.getSelectedData().getPrincipalship());
			editPersonPage.getEditData().setRemark(editPersonPage.getSelectedData().getRemark());
			editPersonPage.getEditData().setSelected(editPersonPage.getSelectedData().isSelected());
		}
		editPersonPage.setErrorMessages("");
		return null;
	}
	
	public String commitPerson() throws StakeholderException {
		System.out.println("in commit person");
		operationAfterExeAction();
		String result = null;
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
		}
		//add consignee
		if (null != this.getAction() && CommonConstants.ACTION_NEW_TYPE.equals(this.getAction())) {
			List<PersonVo> allPersons = this.getDatas();
			if (null != allPersons && allPersons.size() >= CommonConstants.MAX_PERSONS_OF_USER) {
				this.setErrorMessages("对不起!您最多能添加 " + String.valueOf(CommonConstants.MAX_PERSONS_OF_USER) + "项联系人信息!");
				return null;
			}
			//yanzhen
			//end yanzhen
			Integer nowId = this.caluMaxIdAddNewPerson();
			//this.getEditData().setId(nowId);
			Person newPerson = new Person();
			BeanCopier copyHere = BeanCopier.create(PersonVo.class, Person.class, false);
			copyHere.copy(this.getEditData(), newPerson, null);
			Stakeholder stakeholder = new Stakeholder();
			stakeholder = this.getStakeholderService().getStakeholderById(currentUser.getUserInfo().getId());
			newPerson.setId(null);
			newPerson.setSortOrder(nowId);
			newPerson.setStakeholder(stakeholder);
			List<Person> newPersons = new ArrayList<Person>();
			newPersons.add(newPerson);
			stakeholder.setConatctMans(newPersons);
			this.getStakeholderService().saveOrUpdateStakeholder(stakeholder);
			//re selecte data from db like as navigation click clickActionByCustomerUpdateInfo
			CustomerUpdateInfoPageBean customerUpdateInfoPage = (CustomerUpdateInfoPageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.CUSTOMER_UPDATE_INFO_PAGE_BEAN_NAME);
			BeanCopier copy = BeanCopier.create(Stakeholder.class, StakeholderVo.class, false);
			StakeholderVo currStakeholder = new StakeholderVo();
			IStakeholderService stakeholderService = (IStakeholderService)SpringFacesUtil.getManagedBean(ManageBeanConstants.STAKEHOLDER_SERVICE_BEAN_NAME);
			Stakeholder theStakeholder = new Stakeholder();
			theStakeholder = stakeholderService.getStakeholderById(currentUser.getUserInfo().getId());
			currentUser.setUserInfo(theStakeholder);
			copy.copy(currentUser.getUserInfo(), currStakeholder, null);
			customerUpdateInfoPage.setStakeholder(currStakeholder);
			List<Person> persons = null;
			persons =currentUser.getUserInfo().getConatctMans();
			List<PersonVo> rePersons = new ArrayList<PersonVo>();
			if (null != persons && !(persons.isEmpty())) {
				
				for (int i = 0; i < persons.size(); i++) {
					BeanCopier copyPersons = BeanCopier.create(Person.class, PersonVo.class, false);
					Person tempPerson = new Person();
					tempPerson = persons.get(i);
					PersonVo rePerson = new PersonVo();
					copyPersons.copy(tempPerson, rePerson, null);
					rePersons.add(rePerson);
				}
			}
			customerUpdateInfoPage.setPersons(rePersons);
			EditPersonPageBean editPersonPage = (EditPersonPageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_PERSON_PAGE_BEAN_NAME);
			
			editPersonPage.setDatas(customerUpdateInfoPage.getPersons());
			PersonVo editData = new PersonVo();
			editData.setAge(18);
			editData.setSex("M");
			editData.setSelected(Boolean.TRUE);
			editPersonPage.setEditData(editData);
			editPersonPage.setSelectedData(editData);
			editPersonPage.setErrorMessages("");
			editPersonPage.setAction(new String (CommonConstants.ACTION_NEW_TYPE));
			
			// end
			return null;
			
		}
		//edit consignee
		if (null != this.getAction() && CommonConstants.ACTION_EDIT_TYPE.equals(this.getAction())) {
			this.setSelectedData(this.getEditData());
			List<PersonVo> dataLists = new ArrayList<PersonVo>();
			dataLists = this.getDatas();
			for (PersonVo pVo:dataLists) {
				if (this.getEditData().getId().equals(pVo.getId())) {
					BeanCopier copyHere1 = BeanCopier.create(PersonVo.class, PersonVo.class, false);
					copyHere1.copy(this.getEditData(), pVo, null);
				}
			}
			//save data
			BeanCopier copyHelp = BeanCopier.create(PersonVo.class, Person.class, false);
			Person paraPerson = new Person();
			copyHelp.copy(this.getEditData(), paraPerson, null);
			Stakeholder stakeholder = new Stakeholder();
			stakeholder = this.getStakeholderService().getStakeholderById(currentUser.getUserInfo().getId());
			paraPerson.setStakeholder(stakeholder);
			List<Person> paraPersons = new ArrayList<Person>();
			paraPersons.add(paraPerson);
			stakeholder.setConatctMans(paraPersons);
			this.getStakeholderService().saveOrUpdateStakeholder(stakeholder);
			stakeholder = this.getStakeholderService().getStakeholderById(currentUser.getUserInfo().getId());
			currentUser.setUserInfo(stakeholder);
			
			//end save data
		}
		return null;
	}
	
	public String requireUpdatePerson() {
		operationAfterExeAction();
		Map<String,UIComponent> componentMap = new HashMap<String,UIComponent>();
		List<UIComponent> te= new ArrayList<UIComponent>();
		UIViewRoot currentViewRoot = FacesContext.getCurrentInstance().getViewRoot();
		for(UIComponent component : currentViewRoot.getChildren()){ 
            te= UIComponentUtil.getComponentChildren(component,componentMap); 
        }
		UIData tempTable = (UIData) componentMap.get("table");
		setSelectedData((PersonVo) tempTable.getRowData());
		try {
			PropertyUtils.copyProperties(this.getEditData(),this.getSelectedData());
			this.setAction(CommonConstants.ACTION_EDIT_TYPE);
		} catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return null;
	}
	public String selfTakeSelection() throws ConsigneeException {
		operationAfterExeAction();
		//takeSelection();
		this.setAction("");
		return null;
	}
	public String deletePerson() throws StakeholderException {
		String result = null;
		operationAfterExeAction();
		if (null == this.getEditData()) {
			this.setErrorMessages("您未选择要删除的数据!");
			return null;
		} else if (null == this.getEditData().getId() || "".equals(this.getEditData().getName())) {
			this.setErrorMessages("您未选择要删除的数据!");
			return null;
		}
		
		this.setErrorMessages("您选择的联系人:" + this.getEditData().getName() + " 已成功删除!");
		//delete data
		PersonVo delPersonVo = new PersonVo();
		delPersonVo = this.getEditData();
		BeanCopier copyHelp = BeanCopier.create(PersonVo.class, Person.class, false);
		Person delPerson = new Person();
		copyHelp.copy(delPersonVo,delPerson,null);
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
		}
		Stakeholder stakeholder = new Stakeholder();
		stakeholder = this.getStakeholderService().getStakeholderById(currentUser.getUserInfo().getId());
		List<Person> paraPersons = new ArrayList<Person>();
		paraPersons = stakeholder.getConatctMans();
		for (int i = paraPersons.size()-1; i>=0; i--) {
			Person p = paraPersons.get(i);
			if (p.getId().equals(delPerson.getId())) {
				paraPersons.remove(i);
			}
		}
		this.getStakeholderService().saveOrUpdateStakeholder(stakeholder);
		//end delete data
		//re get data;
		CustomerUpdateInfoPageBean customerUpdateInfoPage = (CustomerUpdateInfoPageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.CUSTOMER_UPDATE_INFO_PAGE_BEAN_NAME);
		BeanCopier copy = BeanCopier.create(Stakeholder.class, StakeholderVo.class, false);
		StakeholderVo currStakeholder = new StakeholderVo();
		IStakeholderService stakeholderService = (IStakeholderService)SpringFacesUtil.getManagedBean(ManageBeanConstants.STAKEHOLDER_SERVICE_BEAN_NAME);
		Stakeholder theStakeholder = new Stakeholder();
		theStakeholder = stakeholderService.getStakeholderById(currentUser.getUserInfo().getId());
		currentUser.setUserInfo(theStakeholder);
		copy.copy(currentUser.getUserInfo(), currStakeholder, null);
		customerUpdateInfoPage.setStakeholder(currStakeholder);
		List<Person> persons = null;
		persons =currentUser.getUserInfo().getConatctMans();
		List<PersonVo> rePersons = new ArrayList<PersonVo>();
		if (null != persons && !(persons.isEmpty())) {
			
			for (int i = 0; i < persons.size(); i++) {
				BeanCopier copyPersons = BeanCopier.create(Person.class, PersonVo.class, false);
				Person tempPerson = new Person();
				tempPerson = persons.get(i);
				PersonVo rePerson = new PersonVo();
				copyPersons.copy(tempPerson, rePerson, null);
				rePersons.add(rePerson);
			}
		}
		customerUpdateInfoPage.setPersons(rePersons);
		EditPersonPageBean editPersonPage = (EditPersonPageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_PERSON_PAGE_BEAN_NAME);
		
		editPersonPage.setDatas(customerUpdateInfoPage.getPersons());
		PersonVo editData = new PersonVo();
		editData.setAge(18);
		editData.setSex("M");
		editData.setSelected(Boolean.TRUE);
		editPersonPage.setEditData(editData);
		editPersonPage.setSelectedData(editData);
		editPersonPage.setErrorMessages("");
		editPersonPage.setAction(new String (CommonConstants.ACTION_NEW_TYPE));
		//end get data;
		return null;
	}
	public String deletePersonByEachItem() throws StakeholderException {
		String result = null;
		operationAfterExeAction();
		Map<String,UIComponent> componentMap = new HashMap<String,UIComponent>();
		List<UIComponent> te= new ArrayList<UIComponent>();
		UIViewRoot currentViewRoot = FacesContext.getCurrentInstance().getViewRoot();
		for(UIComponent component : currentViewRoot.getChildren()){ 
            te= UIComponentUtil.getComponentChildren(component,componentMap); 
        }
		UIData tempTable = (UIData) componentMap.get("table");
		PersonVo delPersonVo = (PersonVo) tempTable.getRowData();
		this.getDatas().remove(delPersonVo);
		if (null != this.getEditData() && (this.getEditData().equals(delPersonVo))) {
			PersonVo newPersonVo = new PersonVo();
			newPersonVo.setAge(18);
			newPersonVo.setSex("M");
			newPersonVo.setSelected(false);
			this.setEditData(newPersonVo);
			this.setSelectedData(newPersonVo);
			this.setAction(CommonConstants.ACTION_NEW_TYPE);
		}
		//delete data
		BeanCopier copyHelp = BeanCopier.create(PersonVo.class, Person.class, false);
		Person delPerson = new Person();
		copyHelp.copy(delPersonVo,delPerson,null);
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
		}
		Stakeholder stakeholder = new Stakeholder();
		stakeholder = this.getStakeholderService().getStakeholderById(currentUser.getUserInfo().getId());
		List<Person> paraPersons = new ArrayList<Person>();
		paraPersons = stakeholder.getConatctMans();
		for (int i = paraPersons.size()-1; i>=0; i--) {
			Person p = paraPersons.get(i);
			if (p.getId().equals(delPerson.getId())) {
				paraPersons.remove(i);
			}
		}
		this.getStakeholderService().saveOrUpdateStakeholder(stakeholder);
		//end delete data
		//re get data;
		CustomerUpdateInfoPageBean customerUpdateInfoPage = (CustomerUpdateInfoPageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.CUSTOMER_UPDATE_INFO_PAGE_BEAN_NAME);
		BeanCopier copy = BeanCopier.create(Stakeholder.class, StakeholderVo.class, false);
		StakeholderVo currStakeholder = new StakeholderVo();
		IStakeholderService stakeholderService = (IStakeholderService)SpringFacesUtil.getManagedBean(ManageBeanConstants.STAKEHOLDER_SERVICE_BEAN_NAME);
		Stakeholder theStakeholder = new Stakeholder();
		theStakeholder = stakeholderService.getStakeholderById(currentUser.getUserInfo().getId());
		currentUser.setUserInfo(theStakeholder);
		copy.copy(currentUser.getUserInfo(), currStakeholder, null);
		customerUpdateInfoPage.setStakeholder(currStakeholder);
		List<Person> persons = null;
		persons =currentUser.getUserInfo().getConatctMans();
		List<PersonVo> rePersons = new ArrayList<PersonVo>();
		if (null != persons && !(persons.isEmpty())) {
			
			for (int i = 0; i < persons.size(); i++) {
				BeanCopier copyPersons = BeanCopier.create(Person.class, PersonVo.class, false);
				Person tempPerson = new Person();
				tempPerson = persons.get(i);
				PersonVo rePerson = new PersonVo();
				copyPersons.copy(tempPerson, rePerson, null);
				rePersons.add(rePerson);
			}
		}
		customerUpdateInfoPage.setPersons(rePersons);
		EditPersonPageBean editPersonPage = (EditPersonPageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_PERSON_PAGE_BEAN_NAME);
		
		editPersonPage.setDatas(customerUpdateInfoPage.getPersons());
		PersonVo editData = new PersonVo();
		editData.setAge(18);
		editData.setSex("M");
		editData.setSelected(Boolean.TRUE);
		editPersonPage.setEditData(editData);
		editPersonPage.setSelectedData(editData);
		editPersonPage.setErrorMessages("");
		editPersonPage.setAction(new String (CommonConstants.ACTION_NEW_TYPE));
		//end get data;
		return result;
	}
	
	public String preDddPerson(){
		operationAfterExeAction();
		this.setAction(CommonConstants.ACTION_NEW_TYPE);
		PersonVo newPersonVo = new PersonVo();
		newPersonVo.setAge(18);
		newPersonVo.setSex("M");
		newPersonVo.setSelected(Boolean.TRUE);
		this.setEditData(newPersonVo);
		this.setSelectedData(newPersonVo);
		return null;
	}
	private void operationAfterExeAction(){
		this.setErrorMessages("");
	}
	// getTotalCount() in this bean not used , so it's not need to realize
	public int getTotalCount() {
		return 0;
	}
	// getDataPage() in this bean not used , so it's not need to realize
	public DataPage<PersonVo> getDataPage(int startRow, int pageSize) {
		return null;
	}
	// getDataPage() in this bean not used , so it's not need to realize
	public DataModel getDataModel(){
		return null;
	}
	//in this bean data must from DB first.
	public DataModel getCurrDataModel() {
		 DataModel cdataModel = null;
		 cdataModel= new ExtendedTableDataModel<PersonVo>(new DataProvider<PersonVo>(){

			private static final long serialVersionUID = 5054087821033164847L;

			public PersonVo getItemByKey(Object key) {
				for(PersonVo c : getDatas()){
					if (key.equals(getKey(c))){
						return c;
					}
				}
				return null;
			}

			public List<PersonVo> getItemsByRange(int firstRow, int endRow) {
				return (null != getDatas())?getDatas().subList(firstRow, endRow):null;
			}

			public Object getKey(PersonVo item) {
				return getIdItem(item);
			}

			public int getRowCount() {
				return (null != getDatas())?getDatas().size():0;
			}
			
		});
	
	return cdataModel;
		
	}
	private Integer caluMaxIdAddNewPerson(){
		Integer result = 01;
		if (null == this.getDatas() || this.getDatas().isEmpty()) {
			result = 0;
		} else {
			for (PersonVo personVo: this.getDatas()) {
				if (personVo.getId() > result) {
					result = personVo.getId();
				}
			}
		}
		return result + 1;
	}

}

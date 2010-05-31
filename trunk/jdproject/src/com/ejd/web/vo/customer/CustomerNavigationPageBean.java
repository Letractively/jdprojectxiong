package com.ejd.web.vo.customer;

import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.CommonConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.ConsigneeException;
import com.ejd.model.exception.StakeholderException;
import com.ejd.model.service.iface.IConsigneeService;
import com.ejd.model.service.iface.IStakeholderService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Consignee;
import com.ejd.web.bo.Person;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.stakeholder.PersonVo;
import com.ejd.web.vo.stakeholder.StakeholderVo;
import com.ejd.web.vo.user.UserBean;

public class CustomerNavigationPageBean {
	
	private String param;

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}
	
	public CustomerNavigationPageBean() {
		
	}
	public String clickActionByConsigneeCustomer() throws ConsigneeException {
		String result = null;
		if (null == this.getParam() || "".equals(this.getParam())) {
			return result;
		}
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
		}
		IConsigneeService consigneeService = (IConsigneeService)SpringFacesUtil.getManagedBean(ManageBeanConstants.CONSIGNEE_SERVICE_BEAN_NAME);
		List<Consignee> consignees = new ArrayList<Consignee>();
		consignees = consigneeService.getConsigneeByStakeholderId(currentUser.getUserInfo().getId());
		EditConsigneePageBean editConsignedPage = (EditConsigneePageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_CONSIGNEE_PAGE_BEAN_NAME);
		List<ConsigneeVo> newConsignees= new ArrayList<ConsigneeVo>();
		BeanCopier copy = BeanCopier.create(Consignee.class, ConsigneeVo.class, false);
		if (null != consignees && consignees.size() > 0) {
			for (Consignee consigneeBo:consignees) {
				ConsigneeVo consigneeVo = new ConsigneeVo();
				copy.copy(consigneeBo, consigneeVo, null);
				newConsignees.add(consigneeVo);
			}
		}
		editConsignedPage.setDatas(newConsignees);
		editConsignedPage.setEditData(new ConsigneeVo(false));
		editConsignedPage.setErrorMessages("");
		editConsignedPage.setAction(new String (CommonConstants.ACTION_NEW_TYPE));
		result = this.getParam();
		return result;
	}
	public String clickActionByShoppingCart() throws ConsigneeException {
		String result = null;
		if (null == this.getParam() || "".equals(this.getParam())) {
			return result;
		}
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
		}
		result = this.getParam();
		return result;
	}
	
	public String clickActionByCustomerUpdatePassword() {
		String result = null;
		if (null == this.getParam() || "".equals(this.getParam())) {
			return result;
		}
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
		}
		result = this.getParam();
		CustomerUpdatePasswordPageBean customerUpdatePasswordPage = (CustomerUpdatePasswordPageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.CUSTOMER_UPDATE_PASSWORD_PAGE_BEAN_NAME);
		customerUpdatePasswordPage.setErrorMessages("");
		customerUpdatePasswordPage.setNewUserPassword("");
		customerUpdatePasswordPage.setOldUserPassword("");
		customerUpdatePasswordPage.setVerifyNewUserPassword("");
		return result;
	}
	public String clickActionByCustomerUpdateInfo() throws StakeholderException {
		System.out.println("click update info");
		String result = null;
		if (null == this.getParam() || "".equals(this.getParam())) {
			return result;
		}
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
		}
		result = this.getParam();
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
		List<PersonVo> newPersons = new ArrayList<PersonVo>();
		if (null != persons && !(persons.isEmpty())) {
			
			for (int i = 0; i < persons.size(); i++) {
				BeanCopier copyPersons = BeanCopier.create(Person.class, PersonVo.class, false);
				Person tempPerson = new Person();
				tempPerson = persons.get(i);
				PersonVo newPerson = new PersonVo();
				copyPersons.copy(tempPerson, newPerson, null);
				newPersons.add(newPerson);
			}
		}
		customerUpdateInfoPage.setPersons(newPersons);
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
		return result;
	}
	

}

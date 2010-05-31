package com.ejd.web.vo.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.StakeholderException;
import com.ejd.model.service.iface.IStakeholderService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Person;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.stakeholder.PersonVo;
import com.ejd.web.vo.stakeholder.StakeholderVo;

public class CustomerUpdateInfoPageBean {
	private StakeholderVo stakeholder;
	private List<PersonVo> persons;
	public String errorMessages;
	public String updated;
	private IStakeholderService stakeholderService;
	SessionFactory at;
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
	public String getErrorMessages() {
		return errorMessages;
	}
	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}
	public String getUpdated() {
		return updated;
	}
	public void setUpdated(String updated) {
		this.updated = updated;
	}
	public IStakeholderService getStakeholderService() {
		return stakeholderService;
	}
	public void setStakeholderService(IStakeholderService stakeholderService) {
		this.stakeholderService = stakeholderService;
	}
	
	public String saveCustomerInfo() throws StakeholderException {
		Stakeholder stakeholderBo = new Stakeholder();
		stakeholderBo = stakeholderService.getStakeholderByUserId(this.getStakeholder().getUserId());
		BeanCopier copyStakeholder = BeanCopier.create(StakeholderVo.class, Stakeholder.class, false);
		copyStakeholder.copy(this.getStakeholder(), stakeholderBo, null);
		stakeholderService.saveOrUpdateStakeholder(stakeholderBo);
		return null;
	}
	private Map<String,Person> getPersonsMap(List<Person> para) {
		Map<String,Person> result = new HashMap<String,Person>();
		if (null == para || (para.isEmpty())) {
			return null;
		}
		for (int i=0;i<para.size();i++) {
			Person cPerson = para.get(i);
			result.put(String.valueOf(cPerson.getId().intValue()), cPerson);
		}
		return result;
	}

}

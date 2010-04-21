package com.ejd.web.vo.customer;

import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.ConsigneeException;
import com.ejd.model.service.iface.IConsigneeService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Consignee;
import com.ejd.web.vo.user.UserBean;

public class EditConsigneePageBean {
	
	IConsigneeService consigneeService;
	
	List<ConsigneeVo> consignees  = new ArrayList<ConsigneeVo>();
	private String action;
	
	private ConsigneeVo consignee;
	
	public String errorMessages;

	public IConsigneeService getConsigneeService() {
		return consigneeService;
	}

	public void setConsigneeService(IConsigneeService consigneeService) {
		this.consigneeService = consigneeService;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public List<ConsigneeVo> getConsignees() {
		return consignees;
	}

	public void setConsignees(List<ConsigneeVo> consignees) {
		this.consignees = consignees;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public ConsigneeVo getConsignee() {
		return consignee;
	}

	public void setConsignee(ConsigneeVo consignee) {
		this.consignee = consignee;
	}
	
	public EditConsigneePageBean () {
		
	}
	
	public EditConsigneePageBean (String newAnother) {
		this.consignee = new ConsigneeVo();
		this.consignee.setSelected(false);
	}
	public void createNewConsignee () {
		this.consignee = new ConsigneeVo();
		this.consignee.setInvoiceCompanyName("");
		this.consignee.setConsigneeName("");
		this.consignee.setConsigneeMobile("");
		this.consignee.setConsigneePhone("");
		this.consignee.setConsigneeTax("");
		this.consignee.setConsigneeZip("");
		this.consignee.setConsigneeProvince("");
		this.consignee.setConsigneeCity("");
		this.consignee.setConsigneeCounty("");
		this.consignee.setConsigneeAddress("");
		this.consignee.setSelected(false);
	}
	
	public String reSetConsignee() {
		EditConsigneePageBean editConsignedPage = (EditConsigneePageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_CONSIGNEE_PAGE_BEAN_NAME);
		editConsignedPage.getConsignee().setId(null);
		editConsignedPage.getConsignee().setStakeholderId(null);
		editConsignedPage.getConsignee().setShortName("");
		editConsignedPage.getConsignee().setInvoiceCompanyName("");
		editConsignedPage.getConsignee().setConsigneeName("");
		editConsignedPage.getConsignee().setConsigneeMobile("");
		editConsignedPage.getConsignee().setConsigneePhone("");
		editConsignedPage.getConsignee().setConsigneeTax("");
		editConsignedPage.getConsignee().setConsigneeZip("");
		editConsignedPage.getConsignee().setConsigneeProvince("");
		editConsignedPage.getConsignee().setConsigneeCity("");
		editConsignedPage.getConsignee().setConsigneeCounty("");
		editConsignedPage.getConsignee().setConsigneeAddress("");
		editConsignedPage.getConsignee().setRemark("");
		editConsignedPage.getConsignee().setSelected(Boolean.FALSE);
		editConsignedPage.setErrorMessages("");
		return null;
	}
	
	public String commitConsignee() throws ConsigneeException {
		String result = null;
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
		}
		//add consignee
		if (null != this.getAction() && "new".equals(this.getAction())) {
			Consignee newConsignee = new Consignee();
			BeanCopier copy = BeanCopier.create(ConsigneeVo.class, Consignee.class, false);
			copy.copy(this.getConsignee(),newConsignee,null);
			if (null == newConsignee.getStakeholderId() || "".equals(newConsignee.getStakeholderId())) {
				newConsignee.setStakeholderId(currentUser.getUserInfo().getId());
			}
			try {
				this.getConsigneeService().saveConsignee(newConsignee);
				EditConsigneePageBean editConsignedPage = (EditConsigneePageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_CONSIGNEE_PAGE_BEAN_NAME);
				BeanCopier copyHere = BeanCopier.create(Consignee.class, ConsigneeVo.class, false);
				ConsigneeVo newConsigneeVo = new ConsigneeVo();
				copyHere.copy(newConsignee, newConsigneeVo, null);
				editConsignedPage.getConsignees().add(newConsigneeVo);
			} catch (ConsigneeException e) {
				
			}
			finally {
				
			}
		}
		return null;
	}

}

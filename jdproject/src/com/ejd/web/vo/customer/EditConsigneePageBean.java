package com.ejd.web.vo.customer;

import java.util.ArrayList;
import java.util.List;

import com.ejd.web.bo.Consignee;

public class EditConsigneePageBean {
	
	List<ConsigneeVo> consignees  = new ArrayList<ConsigneeVo>();
	private String action;
	
	private ConsigneeVo consignee;
	
	public String errorMessages;

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

}

package com.ejd.web.vo.customer;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.ConsigneeException;
import com.ejd.model.service.iface.IConsigneeService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Consignee;
import com.ejd.web.vo.genl.AbstractExtendedTableDataModel;
import com.ejd.web.vo.user.UserBean;

public class EditConsigneePageBean extends AbstractExtendedTableDataModel<ConsigneeVo,ConsigneeVo>{
	
	IConsigneeService consigneeService;
	
	private String action;
	
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

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	public Object getIdItem(ConsigneeVo item) {
		return item.getId();
	}
	
	public EditConsigneePageBean() {
		super();
	}

	public EditConsigneePageBean (String newAnother) {
		super();
		ConsigneeVo consigneeVo = new ConsigneeVo();
		consigneeVo.setSelected(false);
		this.setEditData(consigneeVo);
	}
	public void createNewConsignee () {
		ConsigneeVo newConsignee = new ConsigneeVo();
		newConsignee.setInvoiceCompanyName("");
		newConsignee.setConsigneeName("");
		newConsignee.setConsigneeMobile("");
		newConsignee.setConsigneePhone("");
		newConsignee.setConsigneeTax("");
		newConsignee.setConsigneeZip("");
		newConsignee.setConsigneeProvince("");
		newConsignee.setConsigneeCity("");
		newConsignee.setConsigneeCounty("");
		newConsignee.setConsigneeAddress("");
		newConsignee.setSelected(false);
		this.setEditData(newConsignee);
	}
	
	public String reSetConsignee() {
		EditConsigneePageBean editConsignedPage = (EditConsigneePageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_CONSIGNEE_PAGE_BEAN_NAME);
		if ("new".equals(editConsignedPage.getAction())) {
			editConsignedPage.getEditData().setId(null);
			editConsignedPage.getEditData().setStakeholderId(null);
			editConsignedPage.getEditData().setShortName("");
			editConsignedPage.getEditData().setInvoiceCompanyName("");
			editConsignedPage.getEditData().setConsigneeName("");
			editConsignedPage.getEditData().setConsigneeMobile("");
			editConsignedPage.getEditData().setConsigneePhone("");
			editConsignedPage.getEditData().setConsigneeTax("");
			editConsignedPage.getEditData().setConsigneeZip("");
			editConsignedPage.getEditData().setConsigneeProvince("");
			editConsignedPage.getEditData().setConsigneeCity("");
			editConsignedPage.getEditData().setConsigneeCounty("");
			editConsignedPage.getEditData().setConsigneeAddress("");
			editConsignedPage.getEditData().setRemark("");
			editConsignedPage.getEditData().setSelected(Boolean.FALSE);
		} else if ("edit".equals(editConsignedPage.getAction())) {
			editConsignedPage.getEditData().setShortName(editConsignedPage.getSelectedData().getShortName());
			editConsignedPage.getEditData().setInvoiceCompanyName(editConsignedPage.getSelectedData().getInvoiceCompanyName());
			editConsignedPage.getEditData().setConsigneeName(editConsignedPage.getSelectedData().getConsigneeName());
			editConsignedPage.getEditData().setConsigneeMobile(editConsignedPage.getSelectedData().getConsigneeMobile());
			editConsignedPage.getEditData().setConsigneePhone(editConsignedPage.getSelectedData().getConsigneePhone());
			editConsignedPage.getEditData().setConsigneeTax(editConsignedPage.getSelectedData().getConsigneeTax());
			editConsignedPage.getEditData().setConsigneeZip(editConsignedPage.getSelectedData().getConsigneeZip());
			editConsignedPage.getEditData().setConsigneeProvince(editConsignedPage.getSelectedData().getConsigneeProvince());
			editConsignedPage.getEditData().setConsigneeCity(editConsignedPage.getSelectedData().getConsigneeCity());
			editConsignedPage.getEditData().setConsigneeCounty(editConsignedPage.getSelectedData().getConsigneeCounty());
			editConsignedPage.getEditData().setConsigneeAddress(editConsignedPage.getSelectedData().getConsigneeAddress());
			editConsignedPage.getEditData().setRemark(editConsignedPage.getSelectedData().getRemark());
			editConsignedPage.getEditData().setSelected(editConsignedPage.getSelectedData().isSelected());
		}
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
			copy.copy(this.getEditData(),newConsignee,null);
			if (null == newConsignee.getStakeholderId() || "".equals(newConsignee.getStakeholderId())) {
				newConsignee.setStakeholderId(currentUser.getUserInfo().getId());
			}
			try {
				this.getConsigneeService().saveConsignee(newConsignee);
				EditConsigneePageBean editConsignedPage = (EditConsigneePageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_CONSIGNEE_PAGE_BEAN_NAME);
				BeanCopier copyHere = BeanCopier.create(Consignee.class, ConsigneeVo.class, false);
				ConsigneeVo newConsigneeVo = new ConsigneeVo();
				copyHere.copy(newConsignee, newConsigneeVo, null);
				editConsignedPage.getDatas().add(newConsigneeVo);
			} catch (ConsigneeException e) {
				
			}
			finally {
				
			}
		}
		return null;
	}
	
	public String requireUpdateConsignee() throws ConsigneeException {
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()){
			Object key = iterator.next();
			this.getTable().setRowKey(key);
			if (this.getTable().isRowAvailable()) {
				setSelectedData((ConsigneeVo) this.getTable().getRowData());
				try {
					PropertyUtils.copyProperties(this.getEditData(),this.getSelectedData());
				} catch(Exception e)
				{
					System.out.println(e.toString());
				}

			}
		}
		
		return null;
	}

}

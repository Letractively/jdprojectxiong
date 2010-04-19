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
	public String clickActionByConsignee() throws ConsigneeException {
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
		editConsignedPage.setConsignees(newConsignees);
		editConsignedPage.setConsignee(new ConsigneeVo(false));
		editConsignedPage.setErrorMessages("");
		editConsignedPage.setAction(new String ("new"));
		result = this.getParam();
		return result;
	}
	
	

}

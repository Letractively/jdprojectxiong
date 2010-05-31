package com.ejd.web.vo.customer;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.StakeholderException;
import com.ejd.model.service.iface.IStakeholderService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.utils.ValidatorUtil;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.user.UserBean;

public class CustomerUpdatePasswordPageBean {
	
	private String oldUserPassword;
	private String newUserPassword;
	private String verifyNewUserPassword;
	public String errorMessages;
	public String updated;
	private IStakeholderService stakeholderService;
	public String getOldUserPassword() {
		return oldUserPassword;
	}
	public void setOldUserPassword(String oldUserPassword) {
		this.oldUserPassword = oldUserPassword;
	}
	public String getNewUserPassword() {
		return newUserPassword;
	}
	public void setNewUserPassword(String newUserPassword) {
		this.newUserPassword = newUserPassword;
	}
	public String getVerifyNewUserPassword() {
		return verifyNewUserPassword;
	}
	public void setVerifyNewUserPassword(String verifyNewUserPassword) {
		this.verifyNewUserPassword = verifyNewUserPassword;
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
	public CustomerUpdatePasswordPageBean() {
		super();
	}
	public String resetPassword() {
		this.setOldUserPassword("");
		this.setNewUserPassword("");
		this.setVerifyNewUserPassword("");
		this.setErrorMessages("");
		this.setUpdated("");
		return null;
	}
	public String updatePassword() throws StakeholderException{
		String result = null;
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
			return result;
		}
		CustomerUpdatePasswordPageBean customerUpdatePasswordPage = (CustomerUpdatePasswordPageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.CUSTOMER_UPDATE_PASSWORD_PAGE_BEAN_NAME);
		customerUpdatePasswordPage.setErrorMessages("");
		customerUpdatePasswordPage.setUpdated("");
		if (null == this.getOldUserPassword() || "".equals(this.getOldUserPassword())) {
			customerUpdatePasswordPage.setErrorMessages("请输入原密码!");
			return null;
		}
		if (this.getOldUserPassword().length()<6 || this.getOldUserPassword().length()==0) {
			this.setErrorMessages("您输入的原密码长度为\""+this.getOldUserPassword().length()+"\"不满足6-24位的要求");
			return null;
		}
		if (this.getOldUserPassword().length()>24){
			this.setErrorMessages("您输入的原密码长度为\""+this.getOldUserPassword().length()+"\"不满足6-24位的要求");
			return null;
		}
		if ( ValidatorUtil.isWhitespace((this.getOldUserPassword())) ) {
			this.setErrorMessages("输入的原密码中不能包含空格符，请重新输入!");
			return null;
		}
		if (null == this.getNewUserPassword() || "".equals(this.getNewUserPassword())) {
			customerUpdatePasswordPage.setErrorMessages("请输入新密码!");
			return null;
		}
		if (this.getNewUserPassword().length()<6 || this.getNewUserPassword().length()==0) {
			this.setErrorMessages("您输入的新密码长度为\""+this.getNewUserPassword().length()+"\"不满足6-24位的要求");
			return null;
		}
		if (this.getNewUserPassword().length()>24){
			this.setErrorMessages("您输入的新密码长度为\""+this.getNewUserPassword().length()+"\"不满足6-24位的要求");
			return null;
		}
		if ( ValidatorUtil.isWhitespace((this.getNewUserPassword())) ) {
			this.setErrorMessages("输入的新密码中不能包含空格符，请重新输入!");
			return null;
		}
		if (null == this.getVerifyNewUserPassword() || "".equals(this.getVerifyNewUserPassword())) {
			customerUpdatePasswordPage.setErrorMessages("请输入确认密码!");
			return null;
		}
		if (this.getVerifyNewUserPassword().length()<6 || this.getVerifyNewUserPassword().length()==0) {
			this.setErrorMessages("您输入的确认密码长度为\""+this.getVerifyNewUserPassword().length()+"\"不满足6-24位的要求");
			return null;
		}
		if (this.getVerifyNewUserPassword().length()>24){
			this.setErrorMessages("您输入的确认密码长度为\""+this.getVerifyNewUserPassword().length()+"\"不满足6-24位的要求");
			return null;
		}
		if ( ValidatorUtil.isWhitespace((this.getVerifyNewUserPassword())) ) {
			this.setErrorMessages("输入的确认码中不能包含空格符，请重新输入!");
			return null;
		}
		if (!(this.getNewUserPassword().equals(this.getVerifyNewUserPassword()))) {
			this.setErrorMessages("两次输入的新密码不一致，请重新输入!");
			return null;
		}
		if ((this.getNewUserPassword().equals(currentUser.getUserInfo().getUserPassword()))) {
			this.setErrorMessages("新密码与原密码一致，无须更改!");
			return null;
		}
		if (!(this.getOldUserPassword().equals(currentUser.getUserInfo().getUserPassword()))) {
			this.setErrorMessages("原密码输入错误，请重新输入!");
			return null;
		}
		Stakeholder stakeholder = null;
		stakeholder = stakeholderService.getStakeholderByUserId(currentUser.getUserInfo().getUserId());
		stakeholder.setUserPassword(this.getNewUserPassword());
		stakeholderService.saveOrUpdateStakeholder(stakeholder);
		this.setErrorMessages("");
		this.setUpdated("true");
		currentUser.setUserInfo(stakeholder);
		return result;
	}

}

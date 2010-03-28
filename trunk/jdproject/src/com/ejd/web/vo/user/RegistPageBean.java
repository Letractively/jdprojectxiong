package com.ejd.web.vo.user;

import java.util.ArrayList;
import java.util.List;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.model.exception.LoginException;
import com.ejd.model.exception.StakeholderException;
import com.ejd.model.service.iface.IStakeholderService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Address;
import com.ejd.web.bo.Bank;
import com.ejd.web.bo.Person;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.stakeholder.AddressVo;
import com.ejd.web.vo.stakeholder.BankVo;
import com.ejd.web.vo.stakeholder.PersonVo;
import com.ejd.web.vo.stakeholder.StakeholderVo;

public class RegistPageBean {
	private String userId;
	private String fullName;
	private String userPassword;
	private String verifyPassword;
	private String email;
	private String errorMessage;
	private boolean agreementFlag;
	private IStakeholderService stakeholderService;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getVerifyPassword() {
		return verifyPassword;
	}
	public void setVerifyPassword(String verifyPassword) {
		this.verifyPassword = verifyPassword;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public boolean isAgreementFlag() {
		return agreementFlag;
	}
	public void setAgreementFlag(boolean agreementFlag) {
		this.agreementFlag = agreementFlag;
	}
	public IStakeholderService getStakeholderService() {
		return stakeholderService;
	}
	public void setStakeholderService(IStakeholderService stakeholderService) {
		this.stakeholderService = stakeholderService;
	}
	public RegistPageBean(){
		
	}
	public String registerIn() throws StakeholderException{
		this.setErrorMessage(null);
		Stakeholder stakeholder = null;
		stakeholder = stakeholderService.getStakeholderByUserId(this.getUserId());
		if (null == this.getUserId() || "".equals(this.getUserId())) {
			this.setErrorMessage("请输入用户名!");
			return null;
		}
		if (null != stakeholder) {
			this.setErrorMessage("该用户名已被使用!");
			return null;
		}
		if (null == this.getUserPassword() || "".equals(this.getUserPassword()) || null == this.getVerifyPassword() || "".equals(this.getVerifyPassword())) {
			this.setErrorMessage("密码必须输入,且确认密码项不能为空!");
			return null;
		} else if (!(this.getUserPassword().equals(this.getVerifyPassword()))) {
			this.setErrorMessage("两次输入密码不一致,请重新输入!");
			return null;
		}
		if (null == this.getEmail() || "".equals(this.getEmail())) {
			this.setErrorMessage("E-mail地址必须输入!");
			return null;
		}
		if (!this.isAgreementFlag()) {
			this.setErrorMessage("请阅读并决定是否同意用户协议!");
			return null;
		}
		//add new stakeholder;
		Stakeholder newStakeholder = new Stakeholder();
		newStakeholder.getConatctMans().add(null);
		newStakeholder.getAddresses().add(null);
		newStakeholder.getBanks().add(null);
		newStakeholder.setUserId(this.getUserId());
		newStakeholder.setUserPassword(this.getUserPassword());
		newStakeholder.setFullName(this.getUserId());
		newStakeholder.setShortName(this.getUserId());
		newStakeholder.setEmail(this.getEmail());
		newStakeholder.setStatus("A");
		newStakeholder.setType("S");
		newStakeholder.setIntegration(0.0);
		newStakeholder.setRemainingAmount(0.0);
		newStakeholder.setTotalExpendAmount(0.0);
		newStakeholder.setCreditLimit(0.0);
		this.getStakeholderService().saveStakeholder(newStakeholder);
		//end added stakeholder;
		//then login in
		UserBean userBean = (UserBean) SpringFacesUtil.getManagedBean("currentUser");
		stakeholder = stakeholderService.getStakeholderByUserId(this.getUserId());
		userBean.setUserInfo(stakeholder);
		userBean.setUserLoginFlag(true);
		LoginInfo tempLoginInfo = new LoginInfo();
		tempLoginInfo.setUserId(this.getUserId());
		tempLoginInfo.setUserPassword(this.getUserPassword());
		userBean.setLoginInfo(tempLoginInfo);
		// end login in
		return "registSuccess";
	}

}

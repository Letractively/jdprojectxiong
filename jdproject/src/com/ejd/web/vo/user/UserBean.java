package com.ejd.web.vo.user;

import com.ejd.model.exception.LoginException;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Stakeholder;

public class UserBean extends UserBaseBean{
	private LoginInfo loginInfo = new LoginInfo();
	private boolean userLoginFlag = false;
	private Stakeholder userInfo;
	public LoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(LoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	
	public boolean isUserLoginFlag() {
		return userLoginFlag && (null != this.getUserInfo());
	}
	public void setUserLoginFlag(boolean userLoginFlag) {
		this.userLoginFlag = userLoginFlag;
	}
	public Stakeholder getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(Stakeholder userInfo) {
		this.userInfo = userInfo;
	}
	public UserBean() {
	}
	public String loginInAction() throws LoginException {
		Stakeholder stakeholder = null;
		stakeholder = loginService.loginIn(loginInfo.getUserId(), loginInfo.getUserPassword());
		if (null == stakeholder) {// no this stakeholder
			userLoginFlag = false;
			if (null != this.getUserInfo()) {
				this.setUserInfo(null);
			}
		} else { // exist this stakeholder
			this.setUserInfo(stakeholder);
			userLoginFlag = true;
		}
		return null;
	}
	
	public String loginOutAction() throws LoginException {
		UserBean userBean = (UserBean) SpringFacesUtil.getManagedBean("currentUser");
		if (loginService.loginOut(userBean)) {
			userBean.setUserLoginFlag(false);
			userBean.setUserInfo(null);
		}
		return null;
	}
}

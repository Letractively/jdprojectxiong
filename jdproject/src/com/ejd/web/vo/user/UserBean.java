package com.ejd.web.vo.user;

import com.ejd.model.exception.LoginException;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Stakeholder;

public class UserBean extends UserBaseBean{
	private LoginInfo loginInfo = new LoginInfo();
	private boolean userLoginFlag = false;
	private boolean showPurchasePrice = false;//�Ƿ���ʾ������
	private boolean showTradePriceOne = false;//�Ƿ���ʾ�����̼�
	private boolean showTradePriceTwo = false;//�Ƿ���ʾ�����̼�
	private boolean showRetailPrice = false;//�Ƿ���ʾ���ۼ�
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
	
	public boolean isShowPurchasePrice() {
		if (null != this.getUserInfo()) {
			if ("V".equals(this.getUserInfo().getType()) || "P".equals(this.getUserInfo().getType()) || "S".equals(this.getUserInfo().getType()) || "A".equals(this.getUserInfo().getType()) || "D".equals(this.getUserInfo().getType())) {
				return false;
			} else {
				return true;
			}
			
		} else {
			return false;
		}
		
	}
	public void setShowPurchasePrice(boolean showPurchasePrice) {
		this.showPurchasePrice = showPurchasePrice;
	}
	public boolean isShowTradePriceOne() {
		if (null != this.getUserInfo() && ("D".equals(this.getUserInfo().getType()))) {
			return true;
		} else {
			return false;
		}
	}
	public void setShowTradePriceOne(boolean showTradePriceOne) {
		this.showTradePriceOne = showTradePriceOne;
	}
	public boolean isShowTradePriceTwo() {
		if (null != this.getUserInfo() && ("A".equals(this.getUserInfo().getType()))) {
			return true;
		} else {
			return false;
		}
	}
	public void setShowTradePriceTwo(boolean showTradePriceTwo) {
		this.showTradePriceTwo = showTradePriceTwo;
	}
	public boolean isShowRetailPrice() {
		return true;
	}
	public void setShowRetailPrice(boolean showRetailPrice) {
		this.showRetailPrice = showRetailPrice;
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

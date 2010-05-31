package com.ejd.web.vo.user;

import java.util.List;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.LoginException;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Person;
import com.ejd.web.bo.Stakeholder;

public class UserBean extends UserBaseBean{
	private LoginInfo loginInfo = new LoginInfo();
	private boolean userLoginFlag = false;
	private boolean showPurchasePrice = false;//
	private boolean showTradePriceOne = false;//
	private boolean showTradePriceTwo = false;//
	private boolean showRetailPrice = false;//
	private Stakeholder userInfo;
	private String errorMessage;
	private String verifyCode;
	private String comeFrom;
	public UserBean() {
	}
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
	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	
	public String getComeFrom() {
		return comeFrom;
	}
	public void setComeFrom(String comeFrom) {
		this.comeFrom = comeFrom;
	}
	public String loginInAction() throws LoginException {
		String result = "";
		this.setErrorMessage("");
		if (null == loginInfo.getUserId() || "".equals(loginInfo.getUserId()) || null == loginInfo.getUserPassword() || "".equals(loginInfo.getUserPassword())) {
			this.setErrorMessage("请输入用户名和密码!");
			return null;
		}
		PaintVerifyCodeBean paintVerifyCode = (PaintVerifyCodeBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.PAINT_VERIFY_CODE_BEAN_NAME);
		if (null == this.getVerifyCode() || "".equals(this.getVerifyCode())) {
			this.setErrorMessage("请输入验证码!");
			return null;
		} else if (!((this.getVerifyCode().toUpperCase()).equals(paintVerifyCode.getVerifyCode().toUpperCase()))) {
			this.setErrorMessage("输入的验证码有误!");
			return null;
		}
		Stakeholder stakeholder = null;
		stakeholder = loginService.loginIn(loginInfo.getUserId(), loginInfo.getUserPassword());
		if (null == stakeholder) {// no this stakeholder
			userLoginFlag = false;
			this.setUserInfo(stakeholder);
			this.setErrorMessage("请输入正确的用户名和密码");
			
		} else { // exist this stakeholder
			List<Person> persons = stakeholder.getConatctMans();
			for (int j = persons.size()-1 ;j >=0 ; j--) {
				if (null == persons.get(j)) {
					persons.remove(j);
				}
			}
			this.setUserInfo(stakeholder);
			userLoginFlag = true;
		}
		//clear password;
		this.loginInfo.setUserPassword("");
		String comeFrom = this.getComeFrom();
		if (null != comeFrom && !("".equals(comeFrom))) {
			result = comeFrom;
		}
		return result;
	}
	
	public String loginOutAction() throws LoginException {
		UserBean userBean = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (loginService.loginOut(userBean)) {
			userBean.setUserLoginFlag(false);
			userBean.setUserInfo(null);
		}
		return null;
	}
}

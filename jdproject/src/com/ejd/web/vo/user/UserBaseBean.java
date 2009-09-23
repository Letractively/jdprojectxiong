package com.ejd.web.vo.user;

import com.ejd.model.service.iface.ILoginService;

public class UserBaseBean {
	public ILoginService loginService;

	public ILoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(ILoginService loginService) {
		this.loginService = loginService;
	}
	

}

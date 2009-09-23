package com.ejd.model.service.iface;

import com.ejd.model.exception.LoginException;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.user.UserBean;

public interface ILoginService {
	public Stakeholder loginIn(String userId ,String userPassword) throws LoginException;
	public boolean loginOut(UserBean currentUser) throws LoginException;
}

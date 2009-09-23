package com.ejd.model.service.impl;

import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import com.ejd.data.dao.iface.ILoginDao;
import com.ejd.model.exception.LoginException;
import com.ejd.model.exception.ProductBrandException;
import com.ejd.model.service.iface.ILoginService;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.user.UserBean;

public class LoginServiceImpl implements ILoginService {
	private ILoginDao loginDao;
	
	public ILoginDao getLoginDao() {
		return loginDao;
	}

	public void setLoginDao(ILoginDao loginDao) {
		this.loginDao = loginDao;
	}

	public Stakeholder loginIn(String userId, String userPassword)
			throws LoginException {
		// TODO Auto-generated method stub
		try {
			return loginDao.loginIn(userId, userPassword);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new LoginException("error");
		}
	}

	public boolean loginOut(UserBean currentUser) throws LoginException {
		// TODO Auto-generated method stub
		 return loginDao.loginOut(currentUser);
		
	}

}

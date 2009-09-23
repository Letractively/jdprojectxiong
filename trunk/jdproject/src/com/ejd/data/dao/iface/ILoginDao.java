package com.ejd.data.dao.iface;

import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.user.UserBean;

public interface ILoginDao {

	public Stakeholder loginIn(String userId ,String userPassword);
	
	public boolean loginOut(UserBean currentUser);
}

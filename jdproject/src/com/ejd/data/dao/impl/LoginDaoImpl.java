package com.ejd.data.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ejd.data.dao.iface.ILoginDao;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.user.UserBean;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public class LoginDaoImpl extends HibernateDaoSupport implements ILoginDao {

	public Stakeholder loginIn(String userId, String userPassword) {
		try {
			String hql="from Stakeholder s where s.userId = :userId and s.userPassword = :userPassword";
			Map<String,String>  cariteria = new HashMap<String,String>();
			cariteria.put("userId", userId);
			cariteria.put("userPassword", userPassword);
			SessionFactory sf =(SessionFactory) this.getSessionFactory();
			Session session = sf.openSession();
			List<Stakeholder> result = null;
			try {
				Query query=session.createQuery(hql);  
				query.setProperties(cariteria);
				session.beginTransaction();
				result = query.list();
				session.flush();
			} catch (HibernateException e) {
				e.printStackTrace();
				session.getTransaction().rollback();
			} finally {
				  session.close();
			  }
			if (null != result && result.size() >= 1) {
				return (Stakeholder)result.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
		// TODO Auto-generated method stub
		
	}

	public boolean loginOut(UserBean currentUser) {
		// TODO Auto-generated method stub
		return true;
	}

}

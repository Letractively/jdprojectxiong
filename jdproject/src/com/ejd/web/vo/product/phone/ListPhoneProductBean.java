package com.ejd.web.vo.product.phone;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ejd.common.datapage.DataPage;
import com.ejd.common.datapage.PagedBaseBean;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Stakeholder;

public class ListPhoneProductBean extends PagedBaseBean {
	
	public int getTotalCount() {
		/*int totalCount = 0;
		SessionFactory sf =(SessionFactory) SpringFacesUtil.getSpringBean("sessionFactory");
		Session session = sf.openSession();
		try {
		Query q = session.createQuery(this.getSearchSql());
		this.setQueryProperty(q);
		
		session.beginTransaction();
		List alist = q.list();
		totalCount = q.list().size();
		session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			  session.close();
		  }
		return totalCount;*/
		return 0;
	}
	public DataPage<Stakeholder> getDataPage(int startRow, int pageSize) {
		/*DataPage<Stakeholder> dataPage = null;
		SessionFactory sf =(SessionFactory) SpringFacesUtil.getSpringBean("sessionFactory");
		Session session = sf.openSession();
		try {
		Query query = session.createQuery(this.getSearchSql());
		this.setQueryProperty(query);
		query.setFirstResult(startRow);                    
        query.setMaxResults(pageSize);
        dataPage = new DataPage<Stakeholder>(getTotalCount(), startRow,query.list());
		session.beginTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			  session.close();
		  }
		return dataPage;*/
		return null;
	}

}

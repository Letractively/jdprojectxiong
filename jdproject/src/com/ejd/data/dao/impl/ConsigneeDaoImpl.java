package com.ejd.data.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ejd.data.dao.iface.IConsigneeDao;
import com.ejd.web.bo.Consignee;
import com.ejd.web.bo.Coupon;
import com.ejd.web.bo.Productunit;

public class ConsigneeDaoImpl extends HibernateDaoSupport implements IConsigneeDao {

	public Consignee addConsignee(Consignee consignee) {
		// TODO Auto-generated method stub
		try {
        	this.getHibernateTemplate().save(consignee);
        	return consignee;
        } catch (Exception e) {   
            logger.error(e);   
            return null;   
        }
	}

	public boolean delConsigneeById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Consignee consignee = (Consignee)this.getHibernateTemplate().get(Consignee.class, id);
			this.getHibernateTemplate().delete(consignee);
			return true;
		} catch (Exception e) {   
            logger.error(e);   
            return false;   
        }
	}

	public boolean delConsigneeByStakeholderId(Integer stakeholderId)  {
		// TODO Auto-generated method stub
		try{
			SessionFactory sf =(SessionFactory) this.getSessionFactory();
			Session session = sf.openSession();
			Transaction tx = session.beginTransaction();
			Connection con=session.connection();
			PreparedStatement stmt=con.prepareStatement("delete CONSIGNEE where STAKEHOLDERID = " + stakeholderId );
			stmt.executeQuery();
			tx.commit();
			return true;
		}catch (Exception e) {
			logger.error(e);
			return false;
		}finally {
			
		}
	}

	public List<Consignee> getAllConsignee() {
		// TODO Auto-generated method stub
		try {
			String hql = "from Consignee c ";
			List<Consignee> consignees = this.getHibernateTemplate().find(hql);
			return consignees;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Consignee getConsigneeById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Consignee consignee =(Consignee)this.getHibernateTemplate().get(Consignee.class, id);
			return consignee;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public List<Consignee> getConsigneeByStakeholderId(Integer stakeholderId) {
		// TODO Auto-generated method stub
		try {
			String hql = "from Consignee c where c.stakeholderId = ? ";
			List<Consignee> consignees = this.getHibernateTemplate().find(hql, stakeholderId);
			return consignees;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Consignee saveConsignee(Consignee consignee) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(consignee);
			return consignee;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Consignee saveOrUpdateConsignee(Consignee consignee) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().saveOrUpdate(consignee);
			return consignee;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Consignee updateConsignee(Consignee consignee) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(consignee);
			return consignee;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

}

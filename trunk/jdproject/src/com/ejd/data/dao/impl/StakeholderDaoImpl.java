package com.ejd.data.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ejd.data.dao.iface.IStakeholderDao;
import com.ejd.web.bo.Stakeholder;

public class StakeholderDaoImpl extends HibernateDaoSupport implements IStakeholderDao {

	public boolean delStakeholderById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Stakeholder stakeholder = (Stakeholder)this.getHibernateTemplate().get(Stakeholder.class, id);
			this.getHibernateTemplate().delete(stakeholder);
			return true;
		} catch (Exception e) {   
            logger.error(e);   
            return false;   
        }
	}

	public boolean delStakeholderByUserId(String userId) {
		// TODO Auto-generated method stub
		try {
			Stakeholder stakeholder = this.getStakeholderByUserId(userId);
			this.getHibernateTemplate().delete(stakeholder);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	public Stakeholder getStakeholderById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Stakeholder stakeholder=(Stakeholder)this.getHibernateTemplate().get(Stakeholder.class, id);
			return stakeholder;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Stakeholder getStakeholderByUserId(String userId) {
		// TODO Auto-generated method stub
		try {
			String hql="from Stakeholder s where userId=?";
			List<Stakeholder> stakeholders = this.getHibernateTemplate().find(hql, userId);
			if (stakeholders.size() >= 1) {
				return stakeholders.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public List<Stakeholder> getStakeholdersByFullName(String fullName) {
		// TODO Auto-generated method stub
		try {
			String hql="from Stakeholder s where fullName=? and status ='A'";
			List<Stakeholder> stakeholders = this.getHibernateTemplate().find(hql, fullName);
			return stakeholders;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public List<Stakeholder> getStakeholdersByMnemonicchars(String mnemonicchars) {
		// TODO Auto-generated method stub
		try {
			String hql="from Stakeholder s where mnemonicchars=? and status ='A'";
			List<Stakeholder> stakeholders = this.getHibernateTemplate().find(hql, mnemonicchars);
			return stakeholders;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public List<Stakeholder> getStakeholdersByShortName(String shortName) {
		// TODO Auto-generated method stub
		try {
			String hql="from Stakeholder s where shortName=? and status ='A'";
			List<Stakeholder> stakeholders = this.getHibernateTemplate().find(hql, shortName);
			return stakeholders;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public List<Stakeholder> getStakeholdersByType(String type) {
		// TODO Auto-generated method stub
		try {
			String hql="from Stakeholder s where type=? and status ='A'";
			List<Stakeholder> stakeholders = this.getHibernateTemplate().find(hql, type);
			return stakeholders;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Stakeholder saveOrUpdateStakeholder(Stakeholder stakeholder) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().saveOrUpdate(stakeholder);
			return stakeholder;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Stakeholder saveStakeholder(Stakeholder stakeholder) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(stakeholder);
			return stakeholder;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Stakeholder updateStakeholder(Stakeholder stakeholder) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(stakeholder);
			return stakeholder;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

}

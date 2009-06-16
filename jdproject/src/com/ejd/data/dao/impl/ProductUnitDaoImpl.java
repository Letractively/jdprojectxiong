package com.ejd.data.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ejd.data.dao.iface.IProductUnitDao;
import com.ejd.web.bo.Productunit;

public class ProductUnitDaoImpl extends HibernateDaoSupport implements IProductUnitDao {

	public Productunit addProductUnit(Productunit productUnit) {
		// TODO Auto-generated method stub
		try {
        	this.getHibernateTemplate().save(productUnit);
        	return productUnit;
        } catch (Exception e) {   
            logger.error(e);   
            return null;   
        } 
	}

	public boolean delProductUnitById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Productunit productUnit = (Productunit)this.getHibernateTemplate().get(Productunit.class, id);
			this.getHibernateTemplate().delete(productUnit);
			return true;
		} catch (Exception e) {   
            logger.error(e);   
            return false;   
        }
	}

	public boolean delProductUnitByName(String unitName) {
		// TODO Auto-generated method stub
		try {
			String hql="from Productunit u where unitName=?";
			List<Productunit> productUnits = this.getHibernateTemplate().find(hql, unitName);
			this.getHibernateTemplate().deleteAll(productUnits);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	public List<Productunit> getAllProductUnit() {
		// TODO Auto-generated method stub
		try {
			String hql="from Productunit u order by u.serialNumber DESC";
			List<Productunit> productUnits=this.getHibernateTemplate().find(hql);
			return productUnits;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productunit getProductUnitById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Productunit productUnit=(Productunit)this.getHibernateTemplate().get(Productunit.class, id);
			return productUnit;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productunit getProductUnitByName(String unitName) {
		// TODO Auto-generated method stub
		try {
			String hql="from Productunit u where unitName=?";
			List<Productunit> productUnits = this.getHibernateTemplate().find(hql, unitName);
			if (productUnits.size() >= 1) {
				return productUnits.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productunit saveOrUpdateProductUnit(Productunit productUnit) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().saveOrUpdate(productUnit);
			return productUnit;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productunit saveProductUnit(Productunit productUnit) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(productUnit);
			return productUnit;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productunit updateProductUnit(Productunit productUnit) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(productUnit);
			return productUnit;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

}

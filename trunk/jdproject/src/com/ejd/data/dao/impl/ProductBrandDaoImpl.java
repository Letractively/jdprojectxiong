package com.ejd.data.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ejd.data.dao.iface.IProductBrandDao;
import com.ejd.web.bo.Productbrand;
import com.ejd.web.bo.Productcategory;

public class ProductBrandDaoImpl extends HibernateDaoSupport implements IProductBrandDao {

	public Productbrand addProductBrand(Productbrand productBrand) {
		// TODO Auto-generated method stub
		try {
        	this.getHibernateTemplate().save(productBrand);
        	return productBrand;
        } catch (Exception e) {   
            logger.error(e);   
            return null;   
        } 
	}

	public boolean delProductBrandById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Productbrand productBrand = (Productbrand)this.getHibernateTemplate().get(Productbrand.class, id);
			this.getHibernateTemplate().delete(productBrand);
			return true;
		} catch (Exception e) {   
            logger.error(e);   
            return false;   
        }
	}

	public boolean delProductBrandByName(String brandName) {
		// TODO Auto-generated method stub
		try {
			String hql="from Productbrand b where brandName=?";
			List<Productbrand> productBrands = this.getHibernateTemplate().find(hql, brandName);
			this.getHibernateTemplate().deleteAll(productBrands);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	public List<Productbrand> getAllProductBrand() {
		// TODO Auto-generated method stub
		try {
			String hql="from Productbrand b";
			List<Productbrand> productBrands=this.getHibernateTemplate().find(hql);
			return productBrands;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productbrand getProductBrandById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Productbrand productBrand=(Productbrand)this.getHibernateTemplate().get(Productbrand.class, id);
			return productBrand;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productbrand getProductBrandByName(String brandName) {
		// TODO Auto-generated method stub
		try {
			String hql="from Productbrand b where brandName=?";
			List<Productbrand> productBrands = this.getHibernateTemplate().find(hql, brandName);
			if (productBrands.size() >= 1) {
				return productBrands.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productbrand saveOrUpdateProductBrand(Productbrand productBrand) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().saveOrUpdate(productBrand);
			return productBrand;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productbrand saveProductBrand(Productbrand productBrand) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(productBrand);
			return productBrand;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productbrand updateProductBrand(Productbrand productBrand) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(productBrand);
			return productBrand;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

}

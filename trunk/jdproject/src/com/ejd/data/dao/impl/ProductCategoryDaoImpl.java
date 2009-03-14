package com.ejd.data.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ejd.data.dao.iface.IProductCategoryDao;
import com.ejd.web.bo.Productcategory;

public class ProductCategoryDaoImpl extends HibernateDaoSupport implements
		IProductCategoryDao {

	public Productcategory addProductCategory(Productcategory productCategory) {
		// TODO Auto-generated method stub  
        try {
        	this.getHibernateTemplate().save(productCategory);
        	return productCategory;
        } catch (Exception e) {   
            logger.error(e);   
            return null;   
        }   
	}

	public boolean delProductCategoryById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Productcategory productCategory = (Productcategory)this.getHibernateTemplate().get(Productcategory.class, id);
			this.getHibernateTemplate().delete(productCategory);
			return true;
		} catch (Exception e) {   
            logger.error(e);   
            return false;   
        }  
	}

	public boolean delProductCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		try {
			String hql="from Productcategory p where categoryName=?";
			List<Productcategory> productCategorys = this.getHibernateTemplate().find(hql, categoryName);
			this.getHibernateTemplate().deleteAll(productCategorys);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	public List<Productcategory> getAllProductCategory() {
		// TODO Auto-generated method stub
		try {
			String hql="from Productcategory p";
			List<Productcategory> productCategorys=this.getHibernateTemplate().find(hql);
			return productCategorys;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
		 
	}

	public Productcategory getProductCategoryById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Productcategory productCategory=(Productcategory)this.getHibernateTemplate().get(Productcategory.class, id);
			return productCategory;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productcategory getProductCategoryByName(String categoryName) {
		// TODO Auto-generated method stub
		try {
			String hql="from Productcategory p where categoryName=?";
			List<Productcategory> productCategorys = this.getHibernateTemplate().find(hql, categoryName);
			if (productCategorys.size() >= 1) {
				return productCategorys.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Productcategory updateProductCategory(Productcategory productCategory) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(productCategory);
			return productCategory;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	public Productcategory saveProductCategory(Productcategory productCategory) {
		try {
			this.getHibernateTemplate().save(productCategory);
			return productCategory;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	public Productcategory saveOrUpdateProductCategory(Productcategory productCategory) {
		try {
			this.getHibernateTemplate().saveOrUpdate(productCategory);
			return productCategory;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
}

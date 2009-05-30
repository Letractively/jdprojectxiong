package com.ejd.data.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ejd.data.dao.iface.IProductDao;
import com.ejd.web.bo.Product;
import com.ejd.web.bo.Productbrand;

public class ProductDaoImpl extends HibernateDaoSupport implements IProductDao {

	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		try {
        	this.getHibernateTemplate().save(product);
        	return product;
        } catch (Exception e) {   
            logger.error(e);   
            return null;   
        }
	}

	public boolean delProductByCode(String code) {
		// TODO Auto-generated method stub
		try {
			String hql="from Product p where code=?";
			List<Product> products = this.getHibernateTemplate().find(hql, code);
			this.getHibernateTemplate().deleteAll(products);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	public boolean delProductById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Product product = (Product)this.getHibernateTemplate().get(Product.class, id);
			this.getHibernateTemplate().delete(product);
			return true;
		} catch (Exception e) {   
            logger.error(e);   
            return false;   
        }
	}

	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		try {
			String hql="from Product p";
			List<Product> products=this.getHibernateTemplate().find(hql);
			return products;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Product getProductByCode(String code) {
		// TODO Auto-generated method stub
		try {
			String hql="from Product p where code=?";
			List<Product> products = this.getHibernateTemplate().find(hql, code);
			if (products.size() >= 1) {
				return products.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Product product=(Product)this.getHibernateTemplate().get(Product.class, id);
			return product;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Product saveOrUpdateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().saveOrUpdate(product);
			return product;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(product);
			return product;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(product);
			return product;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

}

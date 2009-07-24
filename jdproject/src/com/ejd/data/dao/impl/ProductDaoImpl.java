package com.ejd.data.dao.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ejd.data.dao.iface.IProductDao;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Product;
import com.ejd.web.bo.Productbrand;
import com.ejd.web.vo.product.ProductPrice;

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

	public List<Product> getProductByCriteria(Integer primaryCategoryId, Integer secondCategoryId, Integer brandId, ProductPrice priceRange) {
		try {
			Map criteria = new HashMap();
			List<Product> result = new ArrayList();
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryId) {
				hql = hql + " and p.primaryCategory.id = :primaryCategoryId ";
				criteria.put("primaryCategoryId", primaryCategoryId);
			}
			
			if (null != secondCategoryId) {
				hql = hql + " and p.secondCategory.id = :secondCategoryId ";
				criteria.put("secondCategoryId", secondCategoryId);
			}
			if (null != brandId) {
				hql = hql + " and p.brand.id = :brandId ";
				criteria.put("brandId", brandId);
			}
			if (null != priceRange && null != priceRange.getMinPrice() && null != priceRange.getMaxPrice()) {
				hql = hql + " and p.retailPrice >= :minPrice and p.retailPrice <= :maxPrice ";
				criteria.put("minPrice", priceRange.getMinPrice());
				criteria.put("maxPrice", priceRange.getMaxPrice());
			}
			SessionFactory sf =(SessionFactory) this.getSessionFactory();
			Session session = sf.openSession();
			/*List<Product> products=this.getHibernateTemplate().find(hql, criteria);*/
			try {
				Query q = session.createQuery(hql);
				q.setProperties(criteria);
				session.beginTransaction();
				result = q.list();
				session.flush();
				} catch (HibernateException e) {
					e.printStackTrace();
					session.getTransaction().rollback();
				} finally {
					  session.close();
				  }
				return result;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
}

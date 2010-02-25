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
import com.ejd.web.vo.product.ProductPrice;
import com.ejd.web.vo.product.base.RangeParam;

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

	
	public List<Product> getPSBPF1F2ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
			}
			if (null != f1 && null != f1.getMin()) {
				hql = hql + " and p.field1 >= :volumemin ";
				criteria.put("volumemin", f1.getMin());
			}
			if (null != f1 && null != f1.getMax()) {
				hql = hql + " and p.field1 <= :volumemax ";
				criteria.put("volumemax", f1.getMax());
			}
			if (null != f2 && null != f2.getMin()) {
				hql = hql + " and p.field2 >= :powermin ";
				criteria.put("powermin", f2.getMin());
			}
			if (null != f2 && null != f2.getMax()) {
				hql = hql + " and p.field2 <= :powermax ";
				criteria.put("powermax", f2.getMax());
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
	
	public List<Product> getPSBPF6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, String f6, String f7) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
			}
			if (null != f6 && !"".equals(f6)) {
				hql = hql + " and p.field6 = :panelType ";
				criteria.put("panelType", f6);
			}
			if (null != f7 && !"".equals(f7)) {
				hql = hql + " and p.field7 = :fitting ";
				criteria.put("fitting", f7);
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
	
	public List<Product> getPSBPF1ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
			}
			if (null != f1 && null != f1.getMin()) {
				hql = hql + " and p.field1 >= :volumemin ";
				criteria.put("volumemin", f1.getMin());
			}
			if (null != f1 && null != f1.getMax()) {
				hql = hql + " and p.field1 <= :volumemax ";
				criteria.put("volumemax", f1.getMax());
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
	
	public List<Product> getPSBPF6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, String f6) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
			}
			if (null != f6 && !"".equals(f6)) {
				hql = hql + " and p.field6 = :hotType ";
				criteria.put("hotType", f6);
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
	public List<Product> getPSBPProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
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
	public List<Product> getPSBPF1F6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1 ,String f6) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
			}
			if (null != f1 && null != f1.getMin()) {
				hql = hql + " and p.field1 >= :volumemin ";
				criteria.put("volumemin", f1.getMin());
			}
			if (null != f1 && null != f1.getMax()) {
				hql = hql + " and p.field1 <= :volumemax ";
				criteria.put("volumemax", f1.getMax());
			}
			if (null != f6 && !"".equals(f6)) {
				hql = hql + " and p.field6 = :fsix ";
				criteria.put("fsix", f6);
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
	
	public List<Product> getPSBPF1F6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1 ,String f6, String f7) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
			}
			if (null != f1 && null != f1.getMin()) {
				hql = hql + " and p.field1 >= :volumemin ";
				criteria.put("volumemin", f1.getMin());
			}
			if (null != f1 && null != f1.getMax()) {
				hql = hql + " and p.field1 <= :volumemax ";
				criteria.put("volumemax", f1.getMax());
			}
			if (null != f6 && !"".equals(f6)) {
				hql = hql + " and p.field6 = :fsix ";
				criteria.put("fsix", f6);
			}
			if (null != f7 && !"".equals(f7)) {
				hql = hql + " and p.field7 = :fseven ";
				criteria.put("fseven", f7);
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
	public List<Product> getPSBPF1F2F6F7ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2, String f6, String f7) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
			}
			if (null != f1 && null != f1.getMin()) {
				hql = hql + " and p.field1 >= :f1min ";
				criteria.put("f1min", f1.getMin());
			}
			if (null != f1 && null != f1.getMax()) {
				hql = hql + " and p.field1 <= :f1max ";
				criteria.put("f1max", f1.getMax());
			}
			if (null != f2 && null != f2.getMin()) {
				hql = hql + " and p.field2 >= :f2min ";
				criteria.put("f2min", f2.getMin());
			}
			if (null != f2 && null != f2.getMax()) {
				hql = hql + " and p.field2 <= :f2max ";
				criteria.put("f2max", f2.getMax());
			}
			if (null != f6 && !"".equals(f6)) {
				hql = hql + " and p.field6 = :fsix ";
				criteria.put("fsix", f6);
			}
			if (null != f7 && !"".equals(f7)) {
				hql = hql + " and p.field7 = :fseven ";
				criteria.put("fseven", f7);
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
	public List<Product> getPSBPF1F2F3F4F5F6F7F8F9F10ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2, RangeParam f3, RangeParam f4, RangeParam f5, String f6, String f7, String f8, String f9, String f10) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
			}
			if (null != f1 && null != f1.getMin()) {
				hql = hql + " and p.field1 >= :f1min ";
				criteria.put("f1min", f1.getMin());
			}
			if (null != f1 && null != f1.getMax()) {
				hql = hql + " and p.field1 <= :f1max ";
				criteria.put("f1max", f1.getMax());
			}
			if (null != f2 && null != f2.getMin()) {
				hql = hql + " and p.field2 >= :f2min ";
				criteria.put("f2min", f2.getMin());
			}
			if (null != f2 && null != f2.getMax()) {
				hql = hql + " and p.field2 <= :f2max ";
				criteria.put("f2max", f2.getMax());
			}
			if (null != f3 && null != f3.getMin()) {
				hql = hql + " and p.field3 >= :f3min ";
				criteria.put("f3min", f3.getMin());
			}
			if (null != f3 && null != f3.getMax()) {
				hql = hql + " and p.field3 <= :f3max ";
				criteria.put("f3max", f3.getMax());
			}
			if (null != f4 && null != f4.getMin()) {
				hql = hql + " and p.field4 >= :f4min ";
				criteria.put("f4min", f4.getMin());
			}
			if (null != f4 && null != f4.getMax()) {
				hql = hql + " and p.field4 <= :f4max ";
				criteria.put("f4max", f4.getMax());
			}
			if (null != f5 && null != f5.getMin()) {
				hql = hql + " and p.field5 >= :f5min ";
				criteria.put("f5min", f5.getMin());
			}
			if (null != f5 && null != f5.getMax()) {
				hql = hql + " and p.field5 <= :f5max ";
				criteria.put("f5max", f5.getMax());
			}
			if (null != f6 && !"".equals(f6)) {
				hql = hql + " and p.field6 = :fsix ";
				criteria.put("fsix", f6);
			}
			if (null != f7 && !"".equals(f7)) {
				hql = hql + " and p.field7 = :fseven ";
				criteria.put("fseven", f7);
			}
			if (null != f8 && !"".equals(f8)) {
				hql = hql + " and p.field8 = :feight ";
				criteria.put("feight", f8);
			}
			if (null != f9 && !"".equals(f9)) {
				hql = hql + " and p.field9 = :fnine ";
				criteria.put("fnine", f9);
			}
			if (null != f10 && !"".equals(f10)) {
				hql = hql + " and p.field10 = :ften ";
				criteria.put("ften", f10);
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
	
	public List<Product> getPSBPF1F2F6ProductByCriteria(String primaryCategoryCode, String secondCategoryCode, String brandCode, RangeParam priceRange, RangeParam f1, RangeParam f2, String f6) {
		Map criteria = new HashMap();
		List<Product> result = new ArrayList();
		try {
			String hql="from Product as p where 1=1 ";
			if (null != primaryCategoryCode && !"".equals(primaryCategoryCode)) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
			}
			if (null != brandCode && !"".equals(brandCode)) {
				hql = hql + " and p.brandCode = :brandCode ";
				criteria.put("brandCode", brandCode);
			}
			if (null != priceRange && null != priceRange.getMin()) {
				hql = hql + " and p.retailPrice >= :pricemin ";
				criteria.put("pricemin", priceRange.getMin());
			}
			if (null != priceRange && null != priceRange.getMax()) {
				hql = hql + " and p.retailPrice <= :pricemax ";
				criteria.put("pricemax", priceRange.getMax());
			}
			if (null != f1 && null != f1.getMin()) {
				hql = hql + " and p.field1 >= :volumemin ";
				criteria.put("volumemin", f1.getMin());
			}
			if (null != f1 && null != f1.getMax()) {
				hql = hql + " and p.field1 <= :volumemax ";
				criteria.put("volumemax", f1.getMax());
			}
			if (null != f2 && null != f2.getMin()) {
				hql = hql + " and p.field2 >= :f2min ";
				criteria.put("f2min", f2.getMin());
			}
			if (null != f2 && null != f2.getMax()) {
				hql = hql + " and p.field2 <= :f2max ";
				criteria.put("f2max", f2.getMax());
			}
			if (null != f6 && !"".equals(f6)) {
				hql = hql + " and p.field6 = :fsix ";
				criteria.put("fsix", f6);
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
	
	
	
	public List<String> getBrandCodeListByCategory(String primaryCategoryCode, String secondCategoryCode) {
		Map criteria = new HashMap();
		List<String> result = new ArrayList();
		try {
			String hql="select distinct p.brandCode from Product as p where 1=1 ";
			if (null != primaryCategoryCode) {
				hql = hql + " and p.primaryCategoryCode = :primaryCategoryCode ";
				criteria.put("primaryCategoryCode", primaryCategoryCode);
			}
			
			if (null != secondCategoryCode && !"".equals(secondCategoryCode)) {
				hql = hql + " and p.secondCategoryCode = :secondCategoryCode ";
				criteria.put("secondCategoryCode", secondCategoryCode);
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

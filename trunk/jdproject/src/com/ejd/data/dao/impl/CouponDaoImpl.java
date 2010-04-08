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

import com.ejd.data.dao.iface.ICouponDao;
import com.ejd.web.bo.Coupon;
import com.ejd.web.bo.Product;
import com.ejd.web.bo.Productunit;

public class CouponDaoImpl extends HibernateDaoSupport implements ICouponDao {

	public Coupon addCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		try {
        	this.getHibernateTemplate().save(coupon);
        	return coupon;
        } catch (Exception e) {   
            logger.error(e);   
            return null;   
        }
	}

	public boolean delCouponByAccount(String account) {
		// TODO Auto-generated method stub
		try {
			String hql = "from Coupon c where c.couponAccount = ?";
			List<Coupon> coupons = this.getHibernateTemplate().find(hql, account);
			this.getHibernateTemplate().deleteAll(coupons);
			return true;
		} catch (Exception e) {
			logger.error(e);
			return false;
		}
	}

	public boolean delCouponById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Coupon coupon = (Coupon)this.getHibernateTemplate().get(Coupon.class, id);
			this.getHibernateTemplate().delete(coupon);
			return true;
		} catch (Exception e) {   
            logger.error(e);   
            return false;   
        }
	}

	public List<Coupon> getAllCoupon() {
		// TODO Auto-generated method stub
		try {
			String hql = "from Coupon c order by c.createDate DESC";
			List<Coupon> coupons = this.getHibernateTemplate().find(hql);
			return coupons;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Coupon getCouponByAccount(String account) {
		// TODO Auto-generated method stub
		try {
			String hql="from Coupon c where c.couponAccount = ?";
			List<Coupon> accounts = this.getHibernateTemplate().find(hql, account);
			if (accounts.size() >= 1) {
				return accounts.get(0);
			} else {
				return null;
			}
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Coupon getCouponById(Integer id) {
		// TODO Auto-generated method stub
		try {
			Coupon coupon =(Coupon)this.getHibernateTemplate().get(Productunit.class, id);
			return coupon;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public List<Coupon> getCouponsByCreateBy(String createBy) {
		// TODO Auto-generated method stub
		try {
			String hql = "from Coupon c where c.createBy = ? order by c.createDate DESC";
			List<Coupon> coupons = this.getHibernateTemplate().find(hql, createBy);
			return coupons;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public List<Coupon> getCouponsByStatus(String status) {
		// TODO Auto-generated method stub
		try {
			String hql = "from Coupon c where c.status = ? order by c.createDate DESC";
			List<Coupon> coupons = this.getHibernateTemplate().find(hql, status);
			return coupons;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Coupon saveCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().save(coupon);
			return coupon;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Coupon saveOrUpdateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().saveOrUpdate(coupon);
			return coupon;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}

	public Coupon updateCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		try {
			this.getHibernateTemplate().update(coupon);
			return coupon;
		} catch (Exception e) {
			logger.error(e);
			return null;
		}
	}
	public List<Coupon> getCouponsByUserIdAndStatus(String userId, String status) {
		Map criteria = new HashMap();
		List<Coupon> result = new ArrayList<Coupon>();
		try {
			String hql="from Coupon as c where 1=1 ";
			if (null != userId && !"".equals(userId)) {
				hql = hql + " and c.userId = :userId ";
				criteria.put("userId", userId);
			}
			
			if (null != status && !"".equals(status)) {
				hql = hql + " and c.status = :status ";
				criteria.put("status", status);
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

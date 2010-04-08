package com.ejd.model.service.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateObjectRetrievalFailureException;

import com.ejd.data.dao.iface.ICouponDao;
import com.ejd.model.exception.CouponException;
import com.ejd.model.exception.ProductUnitException;
import com.ejd.model.service.iface.ICouponService;
import com.ejd.web.bo.Coupon;

public class CouponServiceImpl implements ICouponService {

	private ICouponDao couponDao;
	
	
	public ICouponDao getCouponDao() {
		return couponDao;
	}

	public void setCouponDao(ICouponDao couponDao) {
		this.couponDao = couponDao;
	}

	public Coupon addCoupon(Coupon coupon) throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.addCoupon(coupon);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public boolean delCouponByAccount(String account) throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.delCouponByAccount(account);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public boolean delCouponById(Integer id) throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.delCouponById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public List<Coupon> getAllCoupon() throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.getAllCoupon();
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public Coupon getCouponByAccount(String account) throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.getCouponByAccount(account);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public Coupon getCouponById(Integer id) throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.getCouponById(id);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public List<Coupon> getCouponsByCreateBy(String createBy)
			throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.getCouponsByCreateBy(createBy);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public List<Coupon> getCouponsByStatus(String status)
			throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.getCouponsByStatus(status);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public Coupon saveCoupon(Coupon coupon) throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.saveCoupon(coupon);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public Coupon saveOrUpdateCoupon(Coupon coupon) throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.saveOrUpdateCoupon(coupon);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

	public Coupon updateCoupon(Coupon coupon) throws CouponException {
		// TODO Auto-generated method stub
		try {
			return couponDao.updateCoupon(coupon);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}
	public List<Coupon> getCouponsByUserIdAndStatus(String userId, String status) throws CouponException {
		try {
			return couponDao.getCouponsByUserIdAndStatus(userId, status);
		} catch(HibernateObjectRetrievalFailureException he) {
			throw new CouponException("error");
		}
	}

}

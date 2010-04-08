package com.ejd.model.service.iface;

import java.util.List;

import com.ejd.model.exception.CouponException;
import com.ejd.web.bo.Coupon;

public interface ICouponService {
	public Coupon getCouponById(Integer id) throws CouponException;
	public Coupon getCouponByAccount(String account) throws CouponException;
	public List<Coupon> getAllCoupon() throws CouponException;
	public Coupon addCoupon(Coupon coupon) throws CouponException;
	public boolean delCouponById(Integer id) throws CouponException;
	public boolean delCouponByAccount(String account) throws CouponException;
	public Coupon updateCoupon(Coupon coupon) throws CouponException;
	public Coupon saveCoupon(Coupon coupon) throws CouponException;
	public Coupon saveOrUpdateCoupon(Coupon coupon) throws CouponException;
	public List<Coupon> getCouponsByCreateBy(String createBy) throws CouponException;
	public List<Coupon> getCouponsByStatus(String status) throws CouponException;
	public List<Coupon> getCouponsByUserIdAndStatus(String userId, String status) throws CouponException;
}

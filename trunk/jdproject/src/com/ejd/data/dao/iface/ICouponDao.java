package com.ejd.data.dao.iface;

import java.util.List;

import com.ejd.web.bo.Coupon;

public interface ICouponDao {
	public Coupon getCouponById(Integer id);
	public Coupon getCouponByAccount(String account);
	public List<Coupon> getAllCoupon();
	public Coupon addCoupon(Coupon coupon);
	public boolean delCouponById(Integer id);
	public boolean delCouponByAccount(String account);
	public Coupon updateCoupon(Coupon coupon);
	public Coupon saveCoupon(Coupon coupon);
	public Coupon saveOrUpdateCoupon(Coupon coupon);
	public List<Coupon> getCouponsByCreateBy(String createBy);
	public List<Coupon> getCouponsByStatus(String status);
	public List<Coupon> getCouponsByUserIdAndStatus(String userId, String status);
}

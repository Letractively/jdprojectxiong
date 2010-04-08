package com.ejd.web.bo;

import java.io.Serializable;
import java.sql.Timestamp;

public class AbstractCoupon implements Serializable {
	private Integer id;
	private String couponAccount;
	private Double couponScore;
	private String status;
	private Timestamp availableDate;
	private Timestamp createDate;
	private String createBy;
	private String userId;
	
	public AbstractCoupon() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCouponAccount() {
		return couponAccount;
	}

	public void setCouponAccount(String couponAccount) {
		this.couponAccount = couponAccount;
	}

	public Double getCouponScore() {
		return couponScore;
	}

	public void setCouponScore(Double couponScore) {
		this.couponScore = couponScore;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Timestamp getAvailableDate() {
		return availableDate;
	}

	public void setAvailableDate(Timestamp availableDate) {
		this.availableDate = availableDate;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
}

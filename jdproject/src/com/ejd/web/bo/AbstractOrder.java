package com.ejd.web.bo;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.sql.Timestamp;
public class AbstractOrder extends java.lang.Object implements Serializable {

	private Integer id;
	private String orderId;
	private Stakeholder customer;
	private String status;
	private String consigneeName;
	private String consigneeMobile;
	private String consigneePhone;
	private String consigneeTax;
	private String consigneeZip;
	private String consigneeProvince;
	private String consigneeCity;
	private String consigneeCounty;
	private String consigneeAddress;
	private String deliveryType;
	private String deliveryCost;
	private String paymentType;
	private String invoiceType;
	private String invoiceCompanyName;
	private String invoiceCompanyAddress;
	private String invoiceCompanyPhone;
	private String taxaccounts;
	private String bankName;
	private String accountNumber;
	private String invoicePostAddress;
	private String orderSendSession;
	private java.sql.Timestamp orderGenerateTime;
	private java.sql.Timestamp orderSendTime;
	private String couponAccount;
	private Double couponScore;
	private Double integrationScore;
	private Double totallPrice;
	private Double needPayment;
	private Set orderDetails = new HashSet();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Stakeholder getCustomer() {
		return customer;
	}
	public void setCustomer(Stakeholder customer) {
		this.customer = customer;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getConsigneeName() {
		return consigneeName;
	}
	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}
	public String getConsigneeMobile() {
		return consigneeMobile;
	}
	public void setConsigneeMobile(String consigneeMobile) {
		this.consigneeMobile = consigneeMobile;
	}
	public String getConsigneePhone() {
		return consigneePhone;
	}
	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
	public String getConsigneeTax() {
		return consigneeTax;
	}
	public void setConsigneeTax(String consigneeTax) {
		this.consigneeTax = consigneeTax;
	}
	public String getConsigneeZip() {
		return consigneeZip;
	}
	public void setConsigneeZip(String consigneeZip) {
		this.consigneeZip = consigneeZip;
	}
	public String getConsigneeProvince() {
		return consigneeProvince;
	}
	public void setConsigneeProvince(String consigneeProvince) {
		this.consigneeProvince = consigneeProvince;
	}
	public String getConsigneeCity() {
		return consigneeCity;
	}
	public void setConsigneeCity(String consigneeCity) {
		this.consigneeCity = consigneeCity;
	}
	public String getConsigneeCounty() {
		return consigneeCounty;
	}
	public void setConsigneeCounty(String consigneeCounty) {
		this.consigneeCounty = consigneeCounty;
	}
	public String getConsigneeAddress() {
		return consigneeAddress;
	}
	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}
	public String getDeliveryType() {
		return deliveryType;
	}
	public void setDeliveryType(String deliveryType) {
		this.deliveryType = deliveryType;
	}
	public String getDeliveryCost() {
		return deliveryCost;
	}
	public void setDeliveryCost(String deliveryCost) {
		this.deliveryCost = deliveryCost;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceCompanyName() {
		return invoiceCompanyName;
	}
	public void setInvoiceCompanyName(String invoiceCompanyName) {
		this.invoiceCompanyName = invoiceCompanyName;
	}
	public String getInvoiceCompanyAddress() {
		return invoiceCompanyAddress;
	}
	public void setInvoiceCompanyAddress(String invoiceCompanyAddress) {
		this.invoiceCompanyAddress = invoiceCompanyAddress;
	}
	public String getInvoiceCompanyPhone() {
		return invoiceCompanyPhone;
	}
	public void setInvoiceCompanyPhone(String invoiceCompanyPhone) {
		this.invoiceCompanyPhone = invoiceCompanyPhone;
	}
	public String getTaxaccounts() {
		return taxaccounts;
	}
	public void setTaxaccounts(String taxaccounts) {
		this.taxaccounts = taxaccounts;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getInvoicePostAddress() {
		return invoicePostAddress;
	}
	public void setInvoicePostAddress(String invoicePostAddress) {
		this.invoicePostAddress = invoicePostAddress;
	}
	public String getOrderSendSession() {
		return orderSendSession;
	}
	public void setOrderSendSession(String orderSendSession) {
		this.orderSendSession = orderSendSession;
	}
	public Timestamp getOrderGenerateTime() {
		return orderGenerateTime;
	}
	public void setOrderGenerateTime(Timestamp orderGenerateTime) {
		this.orderGenerateTime = orderGenerateTime;
	}
	public Timestamp getOrderSendTime() {
		return orderSendTime;
	}
	public void setOrderSendTime(Timestamp orderSendTime) {
		this.orderSendTime = orderSendTime;
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
	
	public Double getIntegrationScore() {
		return integrationScore;
	}
	public void setIntegrationScore(Double integrationScore) {
		this.integrationScore = integrationScore;
	}
	public Double getTotallPrice() {
		return totallPrice;
	}
	public void setTotallPrice(Double totallPrice) {
		this.totallPrice = totallPrice;
	}
	public Double getNeedPayment() {
		return needPayment;
	}
	public void setNeedPayment(Double needPayment) {
		this.needPayment = needPayment;
	}
	
	public Set getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(Set orderDetails) {
		this.orderDetails = orderDetails;
	}
	public AbstractOrder() {
	}
	
	
}

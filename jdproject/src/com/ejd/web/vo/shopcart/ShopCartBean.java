package com.ejd.web.vo.shopcart;

import java.text.DecimalFormat;
import java.util.ArrayList;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.CommonConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.CouponException;
import com.ejd.model.exception.ProductException;
import com.ejd.utils.DateTimeUtil;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Coupon;
import com.ejd.web.bo.Product;
import com.ejd.web.vo.genl.ExistProductPrimaryCategoryBean;
import com.ejd.web.vo.product.detail.ProductInfoBean;
import com.ejd.web.vo.user.UserBean;

public class ShopCartBean extends ShopCartBaseBean {
	
	private Inventory cart;
	private String couponAccount;
	private Double couponScore;
	private boolean couponChecked;
	private String couponErrorMessage;
	private Double integrationScore;
	private boolean integrationChecked;
	private String integrationErrorMessage;
	public Inventory getCart() {
		return cart;
	}

	public void setCart(Inventory cart) {
		this.cart = cart;
	}

	protected void init() {
		cart = new Inventory();
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

	public boolean isCouponChecked() {
		return couponChecked;
	}

	public void setCouponChecked(boolean couponChecked) {
		this.couponChecked = couponChecked;
	}

	public String getCouponErrorMessage() {
		return couponErrorMessage;
	}

	public void setCouponErrorMessage(String couponErrorMessage) {
		this.couponErrorMessage = couponErrorMessage;
	}

	public Double getIntegrationScore() {
		return integrationScore;
	}

	public void setIntegrationScore(Double integrationScore) {
		this.integrationScore = integrationScore;
	}

	public boolean isIntegrationChecked() {
		return integrationChecked;
	}

	public void setIntegrationChecked(boolean integrationChecked) {
		this.integrationChecked = integrationChecked;
	}

	public String getIntegrationErrorMessage() {
		return integrationErrorMessage;
	}

	public void setIntegrationErrorMessage(String integrationErrorMessage) {
		this.integrationErrorMessage = integrationErrorMessage;
	}
	
	public Double getNeedPayment(){
		double couponScore = (null == this.getCouponScore())?0.0:(new Double(this.getCouponScore())).doubleValue();
		double integrationScore = (null == this.getIntegrationScore())?0.0:(new Double(this.getIntegrationScore())).doubleValue() / 10;
		double result = this.getCart().getInventoryPriceTotal() - couponScore - integrationScore;
		return new Double(result);
	}

	public ShopCartBean() {
		init();
		this.setCouponChecked(false);
		this.setIntegrationChecked(false);
	}
	public void addInventoryItem() throws ProductException {
		ShopCartBean shopCart = (ShopCartBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.SHOP_CART_BEAN_NAME);
		String code = (String) SpringFacesUtil.getRequestParameter("productCode");
		Product product = this.getProductService().getProductByCode(code);
		InventoryItem newInventoryItem = new InventoryItem();
		BeanCopier copyBean = BeanCopier.create(Product.class, InventoryItem.class, false);
		copyBean.copy(product, newInventoryItem, null);
		newInventoryItem.setSalesPrice(product.getRetailPrice());
		newInventoryItem.setSalesQuantity(1);
		shopCart.getCart().addInventoryItem(newInventoryItem);
		shopCart.getCart().recalculateIventory();
	}
	public String addInventoryItemAddGoByParam() throws ProductException {
		ShopCartBean shopCart = (ShopCartBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.SHOP_CART_BEAN_NAME);
		String code = (String) SpringFacesUtil.getRequestParameter("productCode");
		if (null == code || "".equals(code)) {
			return null;
		}
		Product product = this.getProductService().getProductByCode(code);
		InventoryItem newInventoryItem = new InventoryItem();
		BeanCopier copyBean = BeanCopier.create(Product.class, InventoryItem.class, false);
		copyBean.copy(product, newInventoryItem, null);
		newInventoryItem.setSalesPrice(product.getRetailPrice());
		newInventoryItem.setSalesQuantity(1);
		shopCart.getCart().addInventoryItem(newInventoryItem);
		shopCart.getCart().recalculateIventory();
		ProductInfoBean productInfo = (ProductInfoBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.PRODUCT_INFO_BEAN_NAME);
		String goUrlAfterAdd = productInfo.getGoUrlAfterAdd();
		if (null == goUrlAfterAdd || "".equals(goUrlAfterAdd)) {
			return null;
		}
		if (CommonConstants.VALUE_NONE.equals(goUrlAfterAdd)) {
			return null;
		}
		if (CommonConstants.VALUE_GO_SHOPPING_CART.equals(goUrlAfterAdd)) {
			return "shoppingCart";
		}
		if (CommonConstants.VALUE_GO_BACK.equals(goUrlAfterAdd)) {
			String go = productInfo.getPreViewIdFromOutCome();
			return go;
		}
		return null;
	}
	public String clearShoppingCart() throws ProductException {
		if (null != this.getCart() && null != this.getCart().getInventory() && (!(this.getCart().getInventory().isEmpty()))) {
			this.getCart().getInventory().clear();
			this.getCart().setInventoryPriceTotal(0.0);
			this.getCart().setInventoryQuantityTotal(0);
			this.getCart().setHaveSelected(false);
		}
		return null;
	}
	public String removeOneSelectedFromShoppingCart() throws ProductException {
		String selectedProductId = (String) SpringFacesUtil.getRequestParameter("selectedProductId");
		if (null == this.getCart() || null == this.getCart().getInventory()) {
			return null;
		}
		if (this.getCart().getInventory().isEmpty()) {
			return null;
		}
		ArrayList<InventoryItem> curCartInventory = this.getCart().getInventory();
		for (int i = curCartInventory.size()-1 ; i >= 0; i--) {
			InventoryItem tempInventoryItem = curCartInventory.get(i);
			if (selectedProductId.equals(tempInventoryItem.getId().toString())) {
				curCartInventory.remove(i);
			}
		}
		this.getCart().recalculateIventory();
		return null;
	}
	public String removeMulSelectedFromShoppingCart() throws ProductException {
		if (null == this.getCart() || null == this.getCart().getInventory()) {
			return null;
		}
		if (this.getCart().getInventory().isEmpty()) {
			return null;
		}
		ArrayList<InventoryItem> curCartInventory = this.getCart().getInventory();
		for (int i = curCartInventory.size()-1 ; i >= 0; i--) {
			InventoryItem tempInventoryItem = curCartInventory.get(i);
			if (tempInventoryItem.isSelected()) {
				curCartInventory.remove(i);
			}
		}
		this.getCart().recalculateIventory();
		return null;
	}
	public String recalCulateIventory() throws ProductException {
		this.getCart().recalculateIventory();
		return null;
	}
	public String gotoGenerateOrder() {
		String comeFrom = (String) SpringFacesUtil.getRequestParameter("comeFrom");
		if (null != comeFrom && !("".equals(comeFrom))) {
			SpringFacesUtil.setRequestMapValue("comeFrom", comeFrom);
		}
		String result = "";
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			currentUser.setComeFrom(SpringFacesUtil.getViewIdStr());
			result = "customerLogin";
		}
		return result;
	}
	public String selectOneCoupon() throws CouponException{
		Coupon coupon = null;
		coupon = this.getCouponService().getCouponByAccount(this.getCouponAccount());
		if (null == coupon) {
			this.setCouponChecked(false);
			this.setCouponScore(null);
			this.setCouponErrorMessage("该优惠券不存在!");
			return null;
		} else {
			if (null == coupon.getStatus() || "".equals(coupon.getStatus())) {
				this.setCouponChecked(false);
				this.setCouponScore(null);
				this.setCouponErrorMessage("该优惠券状态不确定,暂不能使用!");
				return null;
			}
			if ("U".equals(coupon.getStatus())) {
				this.setCouponChecked(false);
				this.setCouponScore(null);
				this.setCouponErrorMessage("该优惠券已使用!");
				return null;
			}
			if ("D".equals(coupon.getStatus())) {
				this.setCouponChecked(false);
				this.setCouponScore(null);
				this.setCouponErrorMessage("该优惠券已弃用!");
				return null;
			}
			if (!("A".equals(coupon.getStatus()))) {
				this.setCouponChecked(false);
				this.setCouponScore(null);
				this.setCouponErrorMessage("该优惠券非激活状态,不能使用!");
				return null;
			} else {
				if (coupon.getAvailableDate().before(DateTimeUtil.getCurrentTimestamp())) {
					this.setCouponChecked(false);
					this.setCouponScore(null);
					this.setCouponErrorMessage("该优惠券已过期!");
					return null;
				} else {
					this.setCouponChecked(true);
					this.setCouponErrorMessage("");
					this.setCouponScore(coupon.getCouponScore());
					return null;
				}
			}
		}

	}
	
	public String useIntegrationLink() {
		String result = "";
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			currentUser.setComeFrom(SpringFacesUtil.getViewIdStr());
			result = "customerLogin";
			return result;
		}
		this.setIntegrationChecked(true);
		this.setIntegrationErrorMessage("");
		return null;
	}
	
	public String notUseIntegrationLink() {
		String result = "";
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			currentUser.setComeFrom(SpringFacesUtil.getViewIdStr());
			result = "customerLogin";
			return result;
		}
		this.setIntegrationChecked(false);
		this.setIntegrationScore(0.0);
		return null;
	}
}

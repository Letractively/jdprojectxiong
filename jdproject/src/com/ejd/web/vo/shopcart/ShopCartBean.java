package com.ejd.web.vo.shopcart;

import java.util.ArrayList;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.CommonConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.ProductException;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Product;
import com.ejd.web.vo.genl.ExistProductPrimaryCategoryBean;
import com.ejd.web.vo.product.detail.ProductInfoBean;
import com.ejd.web.vo.user.UserBean;

public class ShopCartBean extends ShopCartBaseBean {
	
	private Inventory cart;
	
	
	public Inventory getCart() {
		return cart;
	}

	public void setCart(Inventory cart) {
		this.cart = cart;
	}

	protected void init() {
		cart = new Inventory();
	}

	public ShopCartBean() {
		init();
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
			result = "customerLogin";
		}
		return result;
	}

}

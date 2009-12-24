package com.ejd.web.vo.shopcart;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.ProductException;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Product;
import com.ejd.web.vo.genl.ExistProductPrimaryCategoryBean;

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
		ShopCartBean shopCart = (ShopCartBean)SpringFacesUtil.getManagedBean("shopCart");
		String code = (String) SpringFacesUtil.getRequestParameter("productCode");
		Product product = this.getProductService().getProductByCode(code);
		InventoryItem newInventoryItem = new InventoryItem();
		BeanCopier copyBean = BeanCopier.create(Product.class, InventoryItem.class, false);
		copyBean.copy(product, newInventoryItem, null);
		newInventoryItem.setSalesPrice(product.getRetailPrice());
		newInventoryItem.setSalesQuantity(1);
		shopCart.getCart().addInventoryItem(newInventoryItem);
		System.out.println("==============="+shopCart.getCart().getInventoryPriceTotal());
	}

}

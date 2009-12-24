package com.ejd.web.vo.shopcart;

import com.ejd.web.vo.richfaces.header.MenuItem;

public class InventoryCategoryItem extends MenuItem {
	
	private Integer salesQuantity;
	
	private Double salesTotalAmount;
	
	public InventoryCategoryItem(){
		
	}

	public Integer getSalesQuantity() {
		return salesQuantity;
	}

	public void setSalesQuantity(Integer salesQuantity) {
		this.salesQuantity = salesQuantity;
	}

	public Double getSalesTotalAmount() {
		return salesTotalAmount;
	}

	public void setSalesTotalAmount(Double salesTotalAmount) {
		this.salesTotalAmount = salesTotalAmount;
	}
	

}

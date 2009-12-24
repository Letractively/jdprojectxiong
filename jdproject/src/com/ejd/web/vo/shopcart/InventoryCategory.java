package com.ejd.web.vo.shopcart;

import java.util.List;

public class InventoryCategory {
	
	private InventoryCategoryItem primaryCategory;
	
	private List<InventoryCategoryItem> secondCategory;
	
	public InventoryCategory () {
		
	}

	public InventoryCategoryItem getPrimaryCategory() {
		return primaryCategory;
	}

	public void setPrimaryCategory(InventoryCategoryItem primaryCategory) {
		this.primaryCategory = primaryCategory;
	}

	public List<InventoryCategoryItem> getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(List<InventoryCategoryItem> secondCategory) {
		this.secondCategory = secondCategory;
	}
	
}

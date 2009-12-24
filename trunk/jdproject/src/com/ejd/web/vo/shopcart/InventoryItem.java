package com.ejd.web.vo.shopcart;

import com.ejd.web.bo.AbstractProduct;

public class InventoryItem extends AbstractProduct implements java.io.Serializable{
	
    private Double salesPrice;
    
    private Integer salesQuantity;
    
    public InventoryItem(){
    	
    }
	
	public Double getSalesPrice() {
		return salesPrice;
	}
	public void setSalesPrice(Double salesPrice) {
		this.salesPrice = salesPrice;
	}
	public Integer getSalesQuantity() {
		return salesQuantity;
	}
	public void setSalesQuantity(Integer salesQuantity) {
		this.salesQuantity = salesQuantity;
	}
	public void incrementQuantity() {
        salesQuantity++;
    }
	
	public Double getSubTotal() {
		return this.getSalesPrice() * this.getSalesQuantity();
	}

    /**
     * Decrements the quqntity count and resets the Effect to fire on the
     * next render pass.
     */
    public void decrementQuantity() {
    	salesQuantity--;
    }
    
    

}




package com.ejd.web.vo.product;

public class ProductPrice {
	private Double minPrice;
	private Double maxPrice;
	private String descPrice;
	public Double getMinPrice() {
		return minPrice;
	}
	public void setMinPrice(Double minPrice) {
		this.minPrice = minPrice;
	}
	public Double getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(Double maxPrice) {
		this.maxPrice = maxPrice;
	}
	public String getDescPrice() {
		return descPrice;
	}
	public void setDescPrice(String descPrice) {
		this.descPrice = descPrice;
	}
	public ProductPrice() {
		
	}
	public ProductPrice(Double minPrice, Double maxPrice, String descPrice) {
		super();
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		this.descPrice = descPrice;
	}

}

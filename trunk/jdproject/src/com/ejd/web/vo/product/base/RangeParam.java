package com.ejd.web.vo.product.base;

public class RangeParam {

	private Double min;
	private Double max;
	private String description;
	public Double getMin() {
		return min;
	}
	public void setMin(Double min) {
		this.min = min;
	}
	public Double getMax() {
		return max;
	}
	public void setMax(Double max) {
		this.max = max;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public RangeParam() {
		super();
	}
	public RangeParam(Double min, Double max, String description) {
		super();
		this.min = min;
		this.max = max;
		this.description = description;
	}
	
}

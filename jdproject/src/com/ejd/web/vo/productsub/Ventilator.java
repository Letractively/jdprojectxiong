package com.ejd.web.vo.productsub;

public class Ventilator {
	//rong ji
	private Double field1;
	//gong lv
    private Double field2;
    
	public Ventilator() {
		super();
	}
	public Double getField1() {
		return field1;
	}
	public void setField1(Double field1) {
		this.field1 = field1;
	}
	public Double getField2() {
		return field2;
	}
	public void setField2(Double field2) {
		this.field2 = field2;
	}
    public String getField1Label() {
    	return "排风量(m³/min)";
    }
    public String getField2Label() {
    	return "最大功率(W)";
    }

}

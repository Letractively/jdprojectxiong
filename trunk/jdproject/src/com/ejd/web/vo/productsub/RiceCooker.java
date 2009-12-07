package com.ejd.web.vo.productsub;

public class RiceCooker {
	//rong ji
	private Double field1;
	//gong lv
    private Double field2;
    
	public RiceCooker() {
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
    	return "容积(L)";
    }
    public String getField2Label() {
    	return "功率(W)";
    }

}

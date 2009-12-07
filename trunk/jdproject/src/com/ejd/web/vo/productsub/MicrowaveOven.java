package com.ejd.web.vo.productsub;

public class MicrowaveOven {
	//rong ji
	private Double field1;
	//gong lv
    private String field6;
    
	public MicrowaveOven() {
		super();
	}
	public Double getField1() {
		return field1;
	}
	public void setField1(Double field1) {
		this.field1 = field1;
	}
	
    public String getField6() {
		return field6;
	}
	public void setField6(String field6) {
		this.field6 = field6;
	}
	public String getField1Label() {
    	return "容积(L)";
    }
    public String getField6Label() {
    	return "控制方式";
    }

}

package com.ejd.web.vo.productsub;

public class ElectricWaterHeater {
	
	private Double field1;
	
	private Double field2;
	
	private Double field3;
	
	private String field6;

	public ElectricWaterHeater() {
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
	

	public Double getField3() {
		return field3;
	}

	public void setField3(Double field3) {
		this.field3 = field3;
	}

	public String getField6() {
		return field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}
	
	public String getField1Label() {
		return "最大容积(L)";
	}
	
	public String getField2Label() {
		return "最大加热功率(W)";
	}
	
	public String getField3Label() {
		return "额定水压(Mpa)";
	}
	
	public String getField6Label() {
		return "款式";
	}
	
}

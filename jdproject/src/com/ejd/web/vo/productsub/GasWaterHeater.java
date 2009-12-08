package com.ejd.web.vo.productsub;

public class GasWaterHeater {
	
	private Double field1;
	
	private Double field2;
	
	private String field6;
	
	private String field7;

	public GasWaterHeater() {
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

	public String getField6() {
		return field6;
	}

	public void setField6(String field6) {
		this.field6 = field6;
	}

	public String getField7() {
		return field7;
	}

	public void setField7(String field7) {
		this.field7 = field7;
	}
	
	public String getField1Label() {
		return "最大容积(L)";
	}
	
	public String getField2Label() {
		return "热水产率(L/min)";
	}
	
	public String getField6Label() {
		return "气源类型";
	}
	
	public String getField7Label() {
		return "排烟方式";
	}

}

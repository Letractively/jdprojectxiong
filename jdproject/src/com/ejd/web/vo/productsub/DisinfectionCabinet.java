package com.ejd.web.vo.productsub;

public class DisinfectionCabinet {
	
	private Double field1;
	
	private Double field2;
	
	private String field6;

	public DisinfectionCabinet() {
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
	
	public String getField1Label() {
		return "容积(L)";
	}
	public String getField2Label() {
		return "额定输入功率(W)";
	}
	public String getField6Label() {
		return "消毒方式";
	}

}

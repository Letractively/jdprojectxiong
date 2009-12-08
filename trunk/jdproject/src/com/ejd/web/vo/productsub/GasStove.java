package com.ejd.web.vo.productsub;

public class GasStove {
	
	private Double field1;
	
	private String field6;
	
	private String field7;

	public GasStove() {
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

	public String getField7() {
		return field7;
	}

	public void setField7(String field7) {
		this.field7 = field7;
	}
	
	public String getField1Label() {
		return "燃烧器数量(P)";
	}
	
	public String getField6Label() {
		return "适用气源";
	}
	
	public String getField7Label() {
		return "安装方式";
	}

}

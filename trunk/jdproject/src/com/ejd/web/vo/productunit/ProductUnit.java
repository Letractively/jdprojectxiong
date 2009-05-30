package com.ejd.web.vo.productunit;
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.Max;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;
import org.hibernate.validator.Range;

public class ProductUnit {
	private Integer id;

    @NotEmpty
    @Pattern(regex=".*[^\\s].*", message="This string contain only spaces")
    @Length(min=1,max=20)
	private String unitName;
    @NotNull
    @Range(min=0,max=10000)
	private Integer serialNumber;
	public ProductUnit() {
		
	}
	public ProductUnit(String unitName, Integer serialNumber) {
		super();
		this.unitName = unitName;
		this.serialNumber = serialNumber;
	}
	public ProductUnit(Integer id,String unitName, Integer serialNumber) {
		super();
		this.id = id;
		this.unitName = unitName;
		this.serialNumber = serialNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUnitName() {
		return unitName;
	}
	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
}

package com.ejd.web.vo.productbrand;
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.Max;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;
import org.hibernate.validator.Range;

public class ProductBrand {
	private Integer id;

    @NotEmpty
    @Pattern(regex=".*[^\\s].*", message="This string contain only spaces")
    @Length(min=2,max=20)
	private String brandName;
    @NotNull
    @Range(min=0,max=10000)
	private Integer serialNumber;
	public ProductBrand() {
		
	}
	public ProductBrand(String brandName, Integer serialNumber) {
		super();
		this.brandName = brandName;
		this.serialNumber = serialNumber;
	}
	public ProductBrand(Integer id,String brandName, Integer serialNumber) {
		super();
		this.id = id;
		this.brandName = brandName;
		this.serialNumber = serialNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrandName() {
		return brandName;
	}
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
}

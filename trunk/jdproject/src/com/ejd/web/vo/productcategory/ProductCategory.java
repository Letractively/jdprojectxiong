package com.ejd.web.vo.productcategory;
import org.hibernate.validator.Email;
import org.hibernate.validator.Length;
import org.hibernate.validator.Max;
import org.hibernate.validator.Min;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Pattern;
import org.hibernate.validator.Range;

public class ProductCategory {
	private Integer id;

    @NotEmpty
    @Pattern(regex=".*[^\\s].*", message="This string contain only spaces")
    @Length(min=2,max=20)
	private String categoryName;
    @NotNull
    @Range(min=0,max=10000)
	private Integer serialNumber;
	public ProductCategory() {
		
	}
	public ProductCategory(String categoryName, Integer serialNumber) {
		super();
		this.categoryName = categoryName;
		this.serialNumber = serialNumber;
	}
	public ProductCategory(Integer id,String categoryName, Integer serialNumber) {
		super();
		this.id = id;
		this.categoryName = categoryName;
		this.serialNumber = serialNumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(Integer serialNumber) {
		this.serialNumber = serialNumber;
	}
}

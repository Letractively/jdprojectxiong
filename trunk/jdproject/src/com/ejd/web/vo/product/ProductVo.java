package com.ejd.web.vo.product;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Pattern;

import com.ejd.web.bo.Productunit;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.productunit.ProductUnit;
import com.ejd.web.vo.stakeholder.StakeholderVo;

public class ProductVo {
	
	private Integer id;
	private String code;
	private String manufacturerCode;//厂商型号
	private String barcode;//条码号
	private String spec;//规格
	private Integer unitId;//use is get unit;
	private ProductUnit unit;//单位
	private Integer stockLowerNumber;//库存下限
	private Integer stockUpperNumber;//库存上限
	private Integer currentNumber;
	private String imageName;//图片名称
	private String name;
	private StakeholderVo provider;//only use StakeholderVo
	//private Integer providerId;
	private String primaryCategoryCode;
	//private ProductCategory primaryCategory;
	private String secondCategoryCode;
	//private ProductCategory secondCategory;
	private String brandCode;
	//private ProductBrand brand;
	private String status;
	private Double purchasePrice;
	private Double tradePriceOne;
	private Double tradePriceTwo;
	private Double retailPrice;
	private String introduceFileName;
	private Double field1;
    private Double field2;
    private Double field3;
    private Double field4;
    private Double field5;
    private String field6;
    private String field7;
    private String field8;
    private String field9;
    private String field10;
	public ProductVo(){
		
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getManufacturerCode() {
		return manufacturerCode;
	}
	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getSpec() {
		return spec;
	}
	public void setSpec(String spec) {
		this.spec = spec;
	}
	public Integer getUnitId() {
		return unitId;
	}
	public void setUnitId(Integer unitId) {
		this.unitId = unitId;
	}
	public ProductUnit getUnit() {
		return unit;
	}
	public void setUnit(ProductUnit unit) {
		this.unit = unit;
	}
	public Integer getStockLowerNumber() {
		return stockLowerNumber;
	}
	public void setStockLowerNumber(Integer stockLowerNumber) {
		this.stockLowerNumber = stockLowerNumber;
	}
	public Integer getStockUpperNumber() {
		return stockUpperNumber;
	}
	public void setStockUpperNumber(Integer stockUpperNumber) {
		this.stockUpperNumber = stockUpperNumber;
	}
	
	public Integer getCurrentNumber() {
		return currentNumber;
	}
	public void setCurrentNumber(Integer currentNumber) {
		this.currentNumber = currentNumber;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public StakeholderVo getProvider() {
		return provider;
	}
	public void setProvider(StakeholderVo provider) {
		this.provider = provider;
	}
	
	public String getPrimaryCategoryCode() {
		return primaryCategoryCode;
	}
	public void setPrimaryCategoryCode(String primaryCategoryCode) {
		this.primaryCategoryCode = primaryCategoryCode;
	}
	public String getSecondCategoryCode() {
		return secondCategoryCode;
	}
	public void setSecondCategoryCode(String secondCategoryCode) {
		this.secondCategoryCode = secondCategoryCode;
	}
	public String getBrandCode() {
		return brandCode;
	}
	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	public Double getTradePriceOne() {
		return tradePriceOne;
	}
	public void setTradePriceOne(Double tradePriceOne) {
		this.tradePriceOne = tradePriceOne;
	}
	public Double getTradePriceTwo() {
		return tradePriceTwo;
	}
	public void setTradePriceTwo(Double tradePriceTwo) {
		this.tradePriceTwo = tradePriceTwo;
	}
	public Double getRetailPrice() {
		return retailPrice;
	}
	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}
	public String getIntroduceFileName() {
		return introduceFileName;
	}
	public void setIntroduceFileName(String introduceFileName) {
		this.introduceFileName = introduceFileName;
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
	public Double getField4() {
		return field4;
	}
	public void setField4(Double field4) {
		this.field4 = field4;
	}
	public Double getField5() {
		return field5;
	}
	public void setField5(Double field5) {
		this.field5 = field5;
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
	public String getField8() {
		return field8;
	}
	public void setField8(String field8) {
		this.field8 = field8;
	}
	public String getField9() {
		return field9;
	}
	public void setField9(String field9) {
		this.field9 = field9;
	}
	public String getField10() {
		return field10;
	}
	public void setField10(String field10) {
		this.field10 = field10;
	}
	
	
}

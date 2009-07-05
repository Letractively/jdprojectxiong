package com.ejd.web.vo.product;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.Pattern;

import com.ejd.web.bo.Productbrand;
import com.ejd.web.bo.Productcategory;
import com.ejd.web.bo.Productunit;
import com.ejd.web.bo.Stakeholder;
import com.ejd.web.vo.productbrand.ProductBrand;
import com.ejd.web.vo.productcategory.ProductCategory;
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
	private String imageName;//图片名称
	private String name;
	private StakeholderVo provider;//only use StakeholderVo
	//private Integer providerId;
	private Integer primaryCategoryId;
	private ProductCategory primaryCategory;
	private Integer secondCategoryId;
	private ProductCategory secondCategory;
	private Integer brandId;
	private ProductBrand brand;
	private String status;
	private Double purchasePrice;
	private Double tradePriceOne;
	private Double tradePriceTwo;
	private Double retailPrice;
	private String introduceFileName;
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
	public Integer getPrimaryCategoryId() {
		return primaryCategoryId;
	}
	public void setPrimaryCategoryId(Integer primaryCategoryId) {
		this.primaryCategoryId = primaryCategoryId;
	}
	public ProductCategory getPrimaryCategory() {
		return primaryCategory;
	}
	public void setPrimaryCategory(ProductCategory primaryCategory) {
		this.primaryCategory = primaryCategory;
	}
	public Integer getSecondCategoryId() {
		return secondCategoryId;
	}
	public void setSecondCategoryId(Integer secondCategoryId) {
		this.secondCategoryId = secondCategoryId;
	}
	public ProductCategory getSecondCategory() {
		return secondCategory;
	}
	public void setSecondCategory(ProductCategory secondCategory) {
		this.secondCategory = secondCategory;
	}
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public ProductBrand getBrand() {
		return brand;
	}
	public void setBrand(ProductBrand brand) {
		this.brand = brand;
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
	
	
}

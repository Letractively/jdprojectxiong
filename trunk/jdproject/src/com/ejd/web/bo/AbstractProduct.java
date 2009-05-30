package com.ejd.web.bo;

/**
 * AbstractProduct entity provides the base persistence definition of the
 * Product entity.
 * 
 * @author MyEclipse Persistence Tools
 */

public abstract class AbstractProduct extends java.lang.Object implements
		java.io.Serializable {

	// Fields

	private Integer id;
	private String code;
	private String manufacturerCode;//厂商型号
	private String barcode;//条码号
	private String spec;//规格
	private Productunit unit;//单位
	private Integer stockLowerNumber;//库存下限
	private Integer stockUpperNumber;//库存上限
	private String imageName;//图片名称
	private String name;
	private Stakeholder provider;
	//private Integer providerId;
	private Productcategory primaryCategory;
	//private Integer primaryCategoryId;
	private Productcategory secondCategory;
	//private Integer secondCategoryId;
	private Productbrand brand;
	//private Integer brandId;
	private String status;
	private Double purchasePrice;
	private Double tradePriceOne;
	private Double tradePriceTwo;
	private Double retailPrice;
	private String introduceFileName;

	// Constructors

	/** default constructor */
	public AbstractProduct() {
	}

	/** minimal constructor */
	public AbstractProduct(String code, Stakeholder provider,
			Productcategory primaryCategory, Productcategory secondCategory,
			Productbrand brand, String status) {
		this.code = code;
		this.provider = provider;
		this.primaryCategory = primaryCategory;
		this.secondCategory = secondCategory;
		this.brand = brand;
		this.status = status;
	}

	/** full constructor */
	public AbstractProduct(String code, String manufacturerCode,String barcode,String spec,Productunit unit,Integer stockLowerNumber,Integer stockUpperNumber,String imageName, String name,
			Stakeholder provider, Productcategory primaryCategory,
			Productcategory secondCategory, Productbrand brand, String status,
			Double purchasePrice, Double tradePriceOne, Double tradePriceTwo,
			Double retailPrice, String introduceFileName) {
		this.code = code;
		this.manufacturerCode = manufacturerCode;
		this.barcode = barcode;
		this.spec = spec;
		this.unit = unit;
		this.stockLowerNumber = stockLowerNumber;
		this.stockUpperNumber = stockUpperNumber;
		this.imageName = imageName;
		this.name = name;
		this.provider = provider;
		this.primaryCategory = primaryCategory;
		this.secondCategory = secondCategory;
		this.brand = brand;
		this.status = status;
		this.purchasePrice = purchasePrice;
		this.tradePriceOne = tradePriceOne;
		this.tradePriceTwo = tradePriceTwo;
		this.retailPrice = retailPrice;
		this.introduceFileName = introduceFileName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getManufacturerCode() {
		return this.manufacturerCode;
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

	public Productunit getUnit() {
		return unit;
	}

	public void setUnit(Productunit unit) {
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
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Stakeholder getProvider() {
		return provider;
	}

	public void setProvider(Stakeholder provider) {
		this.provider = provider;
	}

	public Productcategory getPrimaryCategory() {
		return primaryCategory;
	}

	public void setPrimaryCategory(Productcategory primaryCategory) {
		this.primaryCategory = primaryCategory;
	}

	public Productcategory getSecondCategory() {
		return secondCategory;
	}

	public void setSecondCategory(Productcategory secondCategory) {
		this.secondCategory = secondCategory;
	}

	public Productbrand getBrand() {
		return brand;
	}

	public void setBrand(Productbrand brand) {
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
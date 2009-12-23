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
	private Integer currentNumber;
	private String imageName;//图片名称
	private String name;
	private String description;
	private Stakeholder provider;
	//private Integer providerId;
	private String primaryCategoryCode;
	//private Integer primaryCategoryId;
	private String secondCategoryCode;
	//private Integer secondCategoryId;
	private String brandCode;
	//private Integer brandId;
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
	// Constructors

	/** default constructor */
	public AbstractProduct() {
	}

	/** minimal constructor */
	public AbstractProduct(String code, Stakeholder provider,
			String primaryCategoryCode, String secondCategoryCode,
			String brandCode, String status) {
		this.code = code;
		this.provider = provider;
		this.primaryCategoryCode = primaryCategoryCode;
		this.secondCategoryCode = secondCategoryCode;
		this.brandCode = brandCode;
		this.status = status;
	}

	/** full constructor */
	public AbstractProduct(String code, String manufacturerCode,String barcode,String spec,Productunit unit,Integer stockLowerNumber,Integer stockUpperNumber,Integer currentNumber,String imageName, String name,
			Stakeholder provider, String primaryCategoryCode,
			String secondCategoryCode, String brandCode, String status,
			Double purchasePrice, Double tradePriceOne, Double tradePriceTwo,
			Double retailPrice, String introduceFileName) {
		this.code = code;
		this.manufacturerCode = manufacturerCode;
		this.barcode = barcode;
		this.spec = spec;
		this.unit = unit;
		this.stockLowerNumber = stockLowerNumber;
		this.stockUpperNumber = stockUpperNumber;
		this.currentNumber = currentNumber;
		this.imageName = imageName;
		this.name = name;
		this.provider = provider;
		this.primaryCategoryCode = primaryCategoryCode;
		this.secondCategoryCode = secondCategoryCode;
		this.brandCode = brandCode;
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
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Stakeholder getProvider() {
		return provider;
	}

	public void setProvider(Stakeholder provider) {
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
package com.ejd.web.vo.product;

import com.ejd.web.bo.Productbrand;
import com.ejd.web.bo.Productcategory;
import com.ejd.web.bo.Productunit;
import com.ejd.web.bo.Stakeholder;

public class ProductVo {
	
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
	
	
}

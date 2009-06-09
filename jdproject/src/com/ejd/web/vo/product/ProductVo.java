package com.ejd.web.vo.product;

import com.ejd.web.bo.Productbrand;
import com.ejd.web.bo.Productcategory;
import com.ejd.web.bo.Productunit;
import com.ejd.web.bo.Stakeholder;

public class ProductVo {
	
	private Integer id;
	private String code;
	private String manufacturerCode;//�����ͺ�
	private String barcode;//�����
	private String spec;//���
	private Productunit unit;//��λ
	private Integer stockLowerNumber;//�������
	private Integer stockUpperNumber;//�������
	private String imageName;//ͼƬ����
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

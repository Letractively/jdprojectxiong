package com.ejd.web.vo.product;

import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.genl.PopupStakeholderBean;
import com.ejd.web.vo.stakeholder.StakeholderVo;

public class ProductCreateBean extends ProductBaseBean {

	private ProductVo product;

	public ProductCreateBean() {
		super();
		product = new ProductVo();
		product.setStockLowerNumber(1);
		product.setStockUpperNumber(1);
		product.setProvider(new StakeholderVo());
	}
	public ProductCreateBean(ProductVo product) {
		super();
		this.product = product;
	}

	public ProductVo getProduct() {
		return product;
	}

	public void setProduct(ProductVo product) {
		this.product = product;
	}
	public String setPopupStakeholderSearchName() {
		PopupStakeholderBean popupStakeholder = (PopupStakeholderBean)SpringFacesUtil.getManagedBean("popupStakeholder");
		if (null != popupStakeholder) {
			popupStakeholder.setSearchName(this.getProduct().getProvider().getFullName());
		}
		return null;
	}
}

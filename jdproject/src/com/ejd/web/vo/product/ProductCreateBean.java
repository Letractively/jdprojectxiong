package com.ejd.web.vo.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.beanutils.BeanUtils;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.model.exception.ProductBrandException;
import com.ejd.model.exception.ProductCategoryException;
import com.ejd.model.exception.ProductException;
import com.ejd.model.exception.ProductUnitException;
import com.ejd.model.exception.StakeholderException;
import com.ejd.model.service.iface.IProductService;
import com.ejd.utils.ProductCategoryUtil;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.utils.UIComponentUtil;
import com.ejd.web.bo.Person;
import com.ejd.web.bo.Product;
import com.ejd.web.bo.Productunit;
import com.ejd.web.vo.genl.ExistProductBrandBean;
import com.ejd.web.vo.genl.ExistProductPrimaryCategoryBean;
import com.ejd.web.vo.genl.PopupStakeholderBean;
import com.ejd.web.vo.product.base.ProductBaseBean;
import com.ejd.web.vo.richfaces.header.HeaderConstants;
import com.ejd.web.vo.stakeholder.PersonVo;
import com.ejd.web.vo.stakeholder.StakeholderVo;

public class ProductCreateBean extends ProductBaseBean {
	
	private ProductVo product;
	
	private SelectItem[] primaryCategoryCodeItems = null;
	
	private SelectItem[] secondCategoryCodeItems = null;
	
	private SelectItem[] brandCodeItems = null;
	
	private String currProductType = "";
	//start rice cooker
	public ProductCreateBean() {
		super();
		product = new ProductVo();
		product.setStockLowerNumber(1);
		product.setStockUpperNumber(1);
		product.setProvider(new StakeholderVo());
		ExistProductPrimaryCategoryBean existProductPrimaryCategory = (ExistProductPrimaryCategoryBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_PRODUCT_PRIMARY_CATEGORY_BEAN_NAME);
		this.setPrimaryCategoryCodeItems(existProductPrimaryCategory.getPrimaryCategoryCodeItems());
		String primaryCategoryName = existProductPrimaryCategory.getPrimaryCategoryCodeItems()[0].getDescription();
		this.setSecondCategoryCodeItems(ProductCategoryUtil.selectProductSecondCategoryByPrimaryCategory(primaryCategoryName));
		String secondCategoryName = this.getSecondCategoryCodeItems()[0].getDescription();
		// set brandcodeitem by primary and second category
		ExistProductBrandBean existProductBrand = (ExistProductBrandBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_PRODUCT_BRAND_BEAN_NAME);
		this.setBrandCodeItems(existProductBrand.getBrandCodeItems());
	}
	public ProductCreateBean(ProductVo product) {
		super();
		this.product = product;
	}

	
	public SelectItem[] getPrimaryCategoryCodeItems() {
		return primaryCategoryCodeItems;
	}
	public void setPrimaryCategoryCodeItems(SelectItem[] primaryCategoryCodeItems) {
		this.primaryCategoryCodeItems = primaryCategoryCodeItems;
	}
	public SelectItem[] getSecondCategoryCodeItems() {
		return secondCategoryCodeItems;
	}
	public void setSecondCategoryCodeItems(SelectItem[] secondCategoryCodeItems) {
		this.secondCategoryCodeItems = secondCategoryCodeItems;
	}
	
	public String getCurrProductType() {
		return currProductType;
	}
	public void setCurrProductType(String currProductType) {
		this.currProductType = currProductType;
	}
	public SelectItem[] getBrandCodeItems() {
		return brandCodeItems;
	}
	public void setBrandCodeItems(SelectItem[] brandCodeItems) {
		this.brandCodeItems = brandCodeItems;
	}
	
	public ProductVo getProduct() {
		return product;
	}
	
	public void setProduct(ProductVo product) {
		this.product = product;
	}
	public String setPopupStakeholderSearchName() {
		PopupStakeholderBean popupStakeholder = (PopupStakeholderBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.POPUP_STAKEHOLDER_BEAN_NAME);
		if (null != popupStakeholder) {
			popupStakeholder.setSearchName(this.getProduct().getProvider().getFullName());
		}
		/*Map<String,UIComponent> componentMap = new HashMap<String,UIComponent>();
		List<UIComponent> te= new ArrayList<UIComponent>();
		UIViewRoot currentViewRoot = FacesContext.getCurrentInstance().getViewRoot();
		List<UIComponent> uicts = FacesContext.getCurrentInstance().getViewRoot().getChildren();
		List<UIComponent> forSunComponent = new ArrayList<UIComponent>();
		for (UIComponent tempComponent:uicts) {
			if ("productProviderFullName".equals(tempComponent.getId())) {
				forSunComponent.add(tempComponent);
			}
		}
		for(UIComponent component : currentViewRoot.getChildren()){ 
            te= UIComponentUtil.getComponentChildren(component,componentMap); 
        }
		forSunComponent.add(componentMap.get("productProviderFullName"));
		popupStakeholder.setParentViewRoot(currentViewRoot);
		popupStakeholder.setParentComponents(forSunComponent);*/
		return null;
	}
	public String reRreshStakeholder() {
		return null;
	}
	public String setProductIntroduceFileName() {
		this.getProduct().setIntroduceFileName(this.getProduct().getCode() + ".jsp");
		return null;
	}
	public String createProduct() throws ProductException,ProductUnitException,StakeholderException,ProductCategoryException,ProductBrandException{
		FacesContext facesContext = SpringFacesUtil.getFacesContext();
		Map<String,UIComponent> componentMap = new HashMap<String,UIComponent>();
		List<UIComponent> te= new ArrayList<UIComponent>();
		UIViewRoot currentViewRoot = FacesContext.getCurrentInstance().getViewRoot();
		for(UIComponent component : currentViewRoot.getChildren()){ 
            te= UIComponentUtil.getComponentChildren(component,componentMap); 
        }
		if ("".equals(this.getProduct().getCode())) {
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","产品编码不能为空!");
			facesContext.addMessage(componentMap.get("productCode").getClientId(facesContext), message);
			return null;
		}
		IProductService productService = (IProductService) this.getProductService();
		Product product = (Product)productService.getProductByCode(this.getProduct().getCode());
		if (null != product) {
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","产品编码已存在!");
			facesContext.addMessage(componentMap.get("productCode").getClientId(facesContext), message);
			return null;
		}
		if (null == this.getProduct().getProvider() || null == this.getProduct().getProvider().getId()) {
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","请选择原厂商!");
			facesContext.addMessage(componentMap.get("productProviderFullName").getClientId(facesContext), message);
			return null;
		}
		Product newProduct = new Product();	
		newProduct.setCode(this.getProduct().getCode());
		newProduct.setManufacturerCode(this.getProduct().getManufacturerCode());
		newProduct.setBarcode(this.getProduct().getBarcode());
		newProduct.setSpec(this.getProduct().getSpec());
		newProduct.setUnit(this.getProductUnitService().getProductUnitById(this.getProduct().getUnitId()));
		newProduct.setStockLowerNumber(this.getProduct().getStockLowerNumber());
		newProduct.setStockUpperNumber(this.getProduct().getStockUpperNumber());
		newProduct.setImageName(this.getProduct().getImageName());
		newProduct.setName(this.getProduct().getName());
		newProduct.setDescription(this.getProduct().getDescription());
		newProduct.setProvider(this.getStakeholderService().getStakeholderById(this.getProduct().getProvider().getId()));
		newProduct.setPrimaryCategoryCode(this.getProduct().getPrimaryCategoryCode());
		newProduct.setSecondCategoryCode(this.getProduct().getSecondCategoryCode());
		newProduct.setBrandCode(this.getProduct().getBrandCode());
		newProduct.setStatus(this.getProduct().getStatus());
		newProduct.setPurchasePrice(this.getProduct().getPurchasePrice());
		newProduct.setTradePriceOne(this.getProduct().getTradePriceOne());
		newProduct.setTradePriceTwo(this.getProduct().getTradePriceTwo());
		newProduct.setRetailPrice(this.getProduct().getRetailPrice());
		newProduct.setIntegration(this.getProduct().getIntegration());
		newProduct.setIntroduceFileName(this.getProduct().getIntroduceFileName());
		//start copy fields value to new product
		newProduct.setField1(this.getProduct().getField1());
		newProduct.setField2(this.getProduct().getField2());
		newProduct.setField3(this.getProduct().getField3());
		newProduct.setField4(this.getProduct().getField4());
		newProduct.setField5(this.getProduct().getField5());
		newProduct.setField6(this.getProduct().getField6());
		newProduct.setField7(this.getProduct().getField7());
		newProduct.setField8(this.getProduct().getField8());
		newProduct.setField9(this.getProduct().getField9());
		newProduct.setField10(this.getProduct().getField10());
		
		this.getProductService().saveProduct(newProduct);
		return null;
	}
	public void changePrimaryCategory(ValueChangeEvent e) {
		String value =(String)e.getNewValue();
		this.getProduct().setPrimaryCategoryCode(value);
	}
	public void changeSecondCategory(ValueChangeEvent e) {
		String value =(String)e.getNewValue();
		this.getProduct().setSecondCategoryCode(value);
	}
	public String changeSecondCategoryAndBrand() {
		String value= this.getProduct().getPrimaryCategoryCode();
		ExistProductPrimaryCategoryBean existProductPrimaryCategory = (ExistProductPrimaryCategoryBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_PRODUCT_PRIMARY_CATEGORY_BEAN_NAME);
		SelectItem [] tempPrimaryCategoryCodeItems = existProductPrimaryCategory.getPrimaryCategoryCodeItems();
		String currentCategoryName = ProductCategoryUtil.getCurrentSelectItemName(value, tempPrimaryCategoryCodeItems);
		if ((null != this.getProduct().getSecondCategoryCode()) && (!"".equals(this.getProduct().getSecondCategoryCode()))) {
			this.getProduct().setSecondCategoryCode("");
		}
		this.setSecondCategoryCodeItems(ProductCategoryUtil.selectProductSecondCategoryByPrimaryCategory(currentCategoryName));
		clearFieldWithNull(this.getProduct());
		this.setCurrProductType("");
		return null;
	}
	public String changeSecondCategoryCode() {
		String value= this.getProduct().getPrimaryCategoryCode();
		SelectItem[] selects = ProductCategoryUtil.selectProductSecondCategoryByPrimaryCategory(value);
		/*ExistProductPrimaryCategoryBean existProductPrimaryCategory = (ExistProductPrimaryCategoryBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EXIST_PRODUCT_PRIMARY_CATEGORY_BEAN_NAME);
		SelectItem [] tempPrimaryCategoryCodeItems = existProductPrimaryCategory.getPrimaryCategoryCodeItems();
		String currentCategoryName = ProductCategoryUtil.getCurrentSelectItemName(value, tempPrimaryCategoryCodeItems);
		if ((null != this.getProduct().getSecondCategoryCode()) && (!"".equals(this.getProduct().getSecondCategoryCode()))) {
			this.getProduct().setSecondCategoryCode("");
		}
		this.setSecondCategoryCodeItems(ProductCategoryUtil.selectProductSecondCategoryByPrimaryCategory(currentCategoryName));*/
		String currentSecondCategoryName = ProductCategoryUtil.getCurrentSelectItemName(this.getProduct().getSecondCategoryCode(),selects);
		this.setCurrProductType(currentSecondCategoryName);
		clearFieldWithNull(this.getProduct());
		return null;
	}
	private void clearFieldWithNull(ProductVo pVo){
		pVo.setField1(null);
		pVo.setField2(null);
		pVo.setField3(null);
		pVo.setField4(null);
		pVo.setField5(null);
		pVo.setField6(null);
		pVo.setField7(null);
		pVo.setField8(null);
		pVo.setField9(null);
		pVo.setField10(null);
	}
}

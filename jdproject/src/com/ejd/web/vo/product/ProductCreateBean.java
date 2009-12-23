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
import com.ejd.web.vo.productsub.BurntStewpot;
import com.ejd.web.vo.productsub.DisinfectionCabinet;
import com.ejd.web.vo.productsub.ElectricPressureCooker;
import com.ejd.web.vo.productsub.ElectricStewPan;
import com.ejd.web.vo.productsub.ElectricWaterHeater;
import com.ejd.web.vo.productsub.ElectronicOven;
import com.ejd.web.vo.productsub.GasStove;
import com.ejd.web.vo.productsub.GasWaterHeater;
import com.ejd.web.vo.productsub.InductionCooker;
import com.ejd.web.vo.productsub.MicrowaveOven;
import com.ejd.web.vo.productsub.RiceCooker;
import com.ejd.web.vo.productsub.Ventilator;
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
	private RiceCooker riceCooker=  new RiceCooker();
	public boolean getIsRiceCooker() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu01.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end rice cooker
	//start induction cooker
	private InductionCooker inductionCooker = new InductionCooker();
	public boolean getIsInductionCooker() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu02.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end induction cooker
	//start electric stew pan
	ElectricStewPan electricStewPan =  new ElectricStewPan();
	public boolean getIsElectricStewPan() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu03.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end electric stew pan
	//start electronic oven
	ElectronicOven electronicOven = new ElectronicOven();
	public boolean getIsElectronicOven() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu04.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end electronic oven
	//burnt stew pot
	BurntStewpot burntStewpot = new BurntStewpot();
	public boolean getIsBurntStewpot() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu06.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//burnt stew pot
	//start electric pressure cooker
	ElectricPressureCooker electricPressureCooker = new ElectricPressureCooker();
	public boolean getIsElectricPressureCooker() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu08.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end electric pressure cooker
	//start microwave oven
	MicrowaveOven microwaveOven = new MicrowaveOven();
	public boolean getIsMicrowaveOven() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu14.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end microwave oven
	
	//start dis infection cabinet
	DisinfectionCabinet disinfectionCabinet = new DisinfectionCabinet();
	public boolean getIsDisinfectionCabinet() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu15.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end dis infection cabinet
	
	//start gas stove
	GasStove gasStove = new GasStove();
	public boolean getIsGasStove() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu21.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end gas stove
	//start gas water heater
	GasWaterHeater gasWaterHeater = new GasWaterHeater();
	public boolean getIsGasWaterHeater() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu25.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end gas water heater
	//start electric water heater
	ElectricWaterHeater electricWaterHeater = new ElectricWaterHeater();
	public boolean getIsElectricWaterHeater() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu26.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//end electric water heater
	//ventilator
	Ventilator ventilator = new Ventilator();
	public boolean getIsVentilator() {
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu27.equals(this.getProduct().getSecondCategoryCode()))) {
			return true;
		}
		return false;
	}
	//ventilator
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
	
	public RiceCooker getRiceCooker() {
		return riceCooker;
	}
	public void setRiceCooker(RiceCooker riceCooker) {
		this.riceCooker = riceCooker;
	}
	
	public InductionCooker getInductionCooker() {
		return inductionCooker;
	}
	public void setInductionCooker(InductionCooker inductionCooker) {
		this.inductionCooker = inductionCooker;
	}
	
	public ElectricStewPan getElectricStewPan() {
		return electricStewPan;
	}
	public void setElectricStewPan(ElectricStewPan electricStewPan) {
		this.electricStewPan = electricStewPan;
	}
	
	public ElectronicOven getElectronicOven() {
		return electronicOven;
	}
	public void setElectronicOven(ElectronicOven electronicOven) {
		this.electronicOven = electronicOven;
	}
	public ProductVo getProduct() {
		return product;
	}
	

	public BurntStewpot getBurntStewpot() {
		return burntStewpot;
	}
	public void setBurntStewpot(BurntStewpot burntStewpot) {
		this.burntStewpot = burntStewpot;
	}
	
	public ElectricPressureCooker getElectricPressureCooker() {
		return electricPressureCooker;
	}
	public void setElectricPressureCooker(
			ElectricPressureCooker electricPressureCooker) {
		this.electricPressureCooker = electricPressureCooker;
	}
	
	public MicrowaveOven getMicrowaveOven() {
		return microwaveOven;
	}
	public void setMicrowaveOven(MicrowaveOven microwaveOven) {
		this.microwaveOven = microwaveOven;
	}
	
	public DisinfectionCabinet getDisinfectionCabinet() {
		return disinfectionCabinet;
	}
	public void setDisinfectionCabinet(DisinfectionCabinet disinfectionCabinet) {
		this.disinfectionCabinet = disinfectionCabinet;
	}
	
	public GasStove getGasStove() {
		return gasStove;
	}
	public void setGasStove(GasStove gasStove) {
		this.gasStove = gasStove;
	}
	
	public GasWaterHeater getGasWaterHeater() {
		return gasWaterHeater;
	}
	public void setGasWaterHeater(GasWaterHeater gasWaterHeater) {
		this.gasWaterHeater = gasWaterHeater;
	}
	
	public ElectricWaterHeater getElectricWaterHeater() {
		return electricWaterHeater;
	}
	public void setElectricWaterHeater(ElectricWaterHeater electricWaterHeater) {
		this.electricWaterHeater = electricWaterHeater;
	}
	
	public Ventilator getVentilator() {
		return ventilator;
	}
	public void setVentilator(Ventilator ventilator) {
		this.ventilator = ventilator;
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
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","产品编码不能为空！");
			facesContext.addMessage(componentMap.get("productCode").getClientId(facesContext), message);
			return null;
		}
		IProductService productService = (IProductService) this.getProductService();
		Product product = (Product)productService.getProductByCode(this.getProduct().getCode());
		if (null != product) {
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","产品编码已存在！");
			facesContext.addMessage(componentMap.get("productCode").getClientId(facesContext), message);
			return null;
		}
		if (null == this.getProduct().getProvider() || null == this.getProduct().getProvider().getId()) {
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","请选择原厂商！");
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
		newProduct.setIntroduceFileName(this.getProduct().getIntroduceFileName());
		//start copy fields value to new product
		newProduct.setField1(null);
		newProduct.setField2(null);
		newProduct.setField3(null);
		newProduct.setField4(null);
		newProduct.setField5(null);
		newProduct.setField6(null);
		newProduct.setField7(null);
		newProduct.setField8(null);
		newProduct.setField9(null);
		newProduct.setField10(null);
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu01.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(RiceCooker.class, Product.class, false);
			copyBean.copy(this.getRiceCooker(), newProduct, null);
		}
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu02.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(InductionCooker.class, Product.class, false);
			copyBean.copy(this.getInductionCooker(), newProduct, null);
		}
		//end induction cooker
		//start electric stew pan
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu03.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(ElectricStewPan.class, Product.class, false);
			copyBean.copy(this.getElectricStewPan(), newProduct, null);
		}
		//end electric stew pan
		//start electronic oven
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu04.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(ElectronicOven.class, Product.class, false);
			copyBean.copy(this.getElectronicOven(), newProduct, null);
		}
		//end electronic oven
		//burnt stew pot
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu06.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(BurntStewpot.class, Product.class, false);
			copyBean.copy(this.getBurntStewpot(), newProduct, null);
		}
		//burnt stew pot
		//start electric pressure cooker
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu08.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(ElectricPressureCooker.class, Product.class, false);
			copyBean.copy(this.getElectricPressureCooker(), newProduct, null);
		}
		//end electric pressure cooker
		//start microwave oven
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu14.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(MicrowaveOven.class, Product.class, false);
			copyBean.copy(this.getMicrowaveOven(), newProduct, null);
		}
		//end microwave oven
		
		//start dis infection cabinet
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu15.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(DisinfectionCabinet.class, Product.class, false);
			copyBean.copy(this.getDisinfectionCabinet(), newProduct, null);
		}
		//end dis infection cabinet
		
		//start gas stove
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu21.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(GasStove.class, Product.class, false);
			copyBean.copy(this.getGasStove(), newProduct, null);
		}
		//end gas stove
		//start gas water heater
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu25.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(GasWaterHeater.class, Product.class, false);
			copyBean.copy(this.getGasWaterHeater(), newProduct, null);
		}
		//end gas water heater
		//start electric water heater
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu26.equals(this.getProduct().getSecondCategoryCode()))) {
			BeanCopier copyBean = BeanCopier.create(ElectricWaterHeater.class, Product.class, false);
			copyBean.copy(this.getElectricWaterHeater(), newProduct, null);
		}
		//end electric water heater
		//ventilator
		if ((HeaderConstants.KITCHEN_APPLIANCE_ID.equals(this.getProduct().getPrimaryCategoryCode())) && (HeaderConstants.subMenu27.equals(this.getProduct().getSecondCategoryCode()))) {
				BeanCopier copyBean = BeanCopier.create(Ventilator.class, Product.class, false);
				copyBean.copy(this.getVentilator(), newProduct, null);
		}
		//ventilator
		//end   copy fields value to new product
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
		return null;
	}
}

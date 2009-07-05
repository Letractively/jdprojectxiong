package com.ejd.web.vo.product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;

import com.ejd.utils.SpringFacesUtil;
import com.ejd.utils.UIComponentUtil;
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
	public String createProduct(){
		FacesContext facesContext = SpringFacesUtil.getFacesContext();
		Map<String,UIComponent> componentMap = new HashMap<String,UIComponent>();
		List<UIComponent> te= new ArrayList<UIComponent>();
		UIViewRoot currentViewRoot = FacesContext.getCurrentInstance().getViewRoot();
		for(UIComponent component : currentViewRoot.getChildren()){ 
            te= UIComponentUtil.getComponentChildren(component,componentMap); 
        }
		if (null == this.getProduct().getCode() || "".equals(this.getProduct().getCode())) {
			FacesMessage message=new FacesMessage(FacesMessage.SEVERITY_ERROR,"错误提示:","产品编码不能为空！");
			facesContext.addMessage(componentMap.get("productCode").getClientId(facesContext), message);
		}
		return null;
	}
}

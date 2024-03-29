package com.ejd.web.vo.customer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.UIData;
import javax.faces.event.ActionEvent;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.apache.commons.beanutils.PropertyUtils;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import net.sf.cglib.beans.BeanCopier;

import com.ejd.common.constant.CommonConstants;
import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.common.datapage.DataPage;
import com.ejd.model.exception.ConsigneeException;
import com.ejd.model.exception.ProductUnitException;
import com.ejd.model.service.iface.IConsigneeService;
import com.ejd.model.service.iface.IProductUnitService;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.utils.UIComponentUtil;
import com.ejd.web.bo.Consignee;
import com.ejd.web.bo.Productunit;
import com.ejd.web.vo.genl.AbstractExtendedTableDataModel;
import com.ejd.web.vo.genl.AbstractTableDataModel;
import com.ejd.web.vo.genl.ITableDataModel;
import com.ejd.web.vo.productunit.ProductUnit;
import com.ejd.web.vo.user.UserBean;

public class EditConsigneePageBean extends AbstractTableDataModel<ConsigneeVo,ConsigneeVo> implements ITableDataModel<ConsigneeVo> {
	
	IConsigneeService consigneeService;
	
	private String action;
	
	public String errorMessages;

	public IConsigneeService getConsigneeService() {
		return consigneeService;
	}

	public void setConsigneeService(IConsigneeService consigneeService) {
		this.consigneeService = consigneeService;
	}

	public String getErrorMessages() {
		return errorMessages;
	}

	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	
	public Object getIdItem(ConsigneeVo item) {
		return item.getId();
	}
	
	public EditConsigneePageBean() {
		super();
		this.setNumberOnePage(CommonConstants.MAX_CONSIGNEES_OF_USER);
	}

	public EditConsigneePageBean (String newAnother) {
		super();
		ConsigneeVo consigneeVo = new ConsigneeVo();
		consigneeVo.setSelected(false);
		this.setEditData(consigneeVo);
	}
	public void createNewConsignee () {
		ConsigneeVo newConsignee = new ConsigneeVo();
		newConsignee.setInvoiceCompanyName("");
		newConsignee.setConsigneeName("");
		newConsignee.setConsigneeMobile("");
		newConsignee.setConsigneePhone("");
		newConsignee.setConsigneeTax("");
		newConsignee.setConsigneeZip("");
		newConsignee.setConsigneeProvince("");
		newConsignee.setConsigneeCity("");
		newConsignee.setConsigneeCounty("");
		newConsignee.setConsigneeAddress("");
		newConsignee.setSelected(false);
		this.setEditData(newConsignee);
	}
	
	public String reSetConsignee() {
		operationAfterExeAction();
		EditConsigneePageBean editConsignedPage = (EditConsigneePageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_CONSIGNEE_PAGE_BEAN_NAME);
		if (CommonConstants.ACTION_NEW_TYPE.equals(editConsignedPage.getAction())) {
			editConsignedPage.getEditData().setId(null);
			editConsignedPage.getEditData().setStakeholderId(null);
			editConsignedPage.getEditData().setShortName("");
			editConsignedPage.getEditData().setInvoiceCompanyName("");
			editConsignedPage.getEditData().setConsigneeName("");
			editConsignedPage.getEditData().setConsigneeMobile("");
			editConsignedPage.getEditData().setConsigneePhone("");
			editConsignedPage.getEditData().setConsigneeTax("");
			editConsignedPage.getEditData().setConsigneeZip("");
			editConsignedPage.getEditData().setConsigneeProvince("");
			editConsignedPage.getEditData().setConsigneeCity("");
			editConsignedPage.getEditData().setConsigneeCounty("");
			editConsignedPage.getEditData().setConsigneeAddress("");
			editConsignedPage.getEditData().setRemark("");
			editConsignedPage.getEditData().setSelected(Boolean.FALSE);
		} else if (CommonConstants.ACTION_EDIT_TYPE.equals(editConsignedPage.getAction())) {
			editConsignedPage.getEditData().setShortName(editConsignedPage.getSelectedData().getShortName());
			editConsignedPage.getEditData().setInvoiceCompanyName(editConsignedPage.getSelectedData().getInvoiceCompanyName());
			editConsignedPage.getEditData().setConsigneeName(editConsignedPage.getSelectedData().getConsigneeName());
			editConsignedPage.getEditData().setConsigneeMobile(editConsignedPage.getSelectedData().getConsigneeMobile());
			editConsignedPage.getEditData().setConsigneePhone(editConsignedPage.getSelectedData().getConsigneePhone());
			editConsignedPage.getEditData().setConsigneeTax(editConsignedPage.getSelectedData().getConsigneeTax());
			editConsignedPage.getEditData().setConsigneeZip(editConsignedPage.getSelectedData().getConsigneeZip());
			editConsignedPage.getEditData().setConsigneeProvince(editConsignedPage.getSelectedData().getConsigneeProvince());
			editConsignedPage.getEditData().setConsigneeCity(editConsignedPage.getSelectedData().getConsigneeCity());
			editConsignedPage.getEditData().setConsigneeCounty(editConsignedPage.getSelectedData().getConsigneeCounty());
			editConsignedPage.getEditData().setConsigneeAddress(editConsignedPage.getSelectedData().getConsigneeAddress());
			editConsignedPage.getEditData().setRemark(editConsignedPage.getSelectedData().getRemark());
			editConsignedPage.getEditData().setSelected(editConsignedPage.getSelectedData().isSelected());
		}
		editConsignedPage.setErrorMessages("");
		return null;
	}
	
	public String commitConsignee() throws ConsigneeException {
		operationAfterExeAction();
		String result = null;
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		if (null == currentUser || null == currentUser.getUserInfo()) {
			result = "customerLogin";
		}
		//add consignee
		if (null != this.getAction() && CommonConstants.ACTION_NEW_TYPE.equals(this.getAction())) {
			List<Consignee> allConsingeesOfUser = this.getConsigneeService().getConsigneeByStakeholderId(currentUser.getUserInfo().getId());
			if (null != allConsingeesOfUser && allConsingeesOfUser.size() >= CommonConstants.MAX_CONSIGNEES_OF_USER) {
				this.setErrorMessages("对不起!您最多能添加 " + String.valueOf(CommonConstants.MAX_CONSIGNEES_OF_USER) + "项收货地址!");
				return null;
			}
			Consignee newConsignee = new Consignee();
			BeanCopier copy = BeanCopier.create(ConsigneeVo.class, Consignee.class, false);
			copy.copy(this.getEditData(),newConsignee,null);
			if (null == newConsignee.getStakeholderId() || "".equals(newConsignee.getStakeholderId())) {
				newConsignee.setStakeholderId(currentUser.getUserInfo().getId());
			}
			try {
				this.getConsigneeService().saveConsignee(newConsignee);
				EditConsigneePageBean editConsignedPage = (EditConsigneePageBean)SpringFacesUtil.getManagedBean(ManageBeanConstants.EDIT_CONSIGNEE_PAGE_BEAN_NAME);
				BeanCopier copyHere = BeanCopier.create(Consignee.class, ConsigneeVo.class, false);
				ConsigneeVo newConsigneeVo = new ConsigneeVo();
				copyHere.copy(newConsignee, newConsigneeVo, null);
				editConsignedPage.getDatas().add(newConsigneeVo);
			} catch (ConsigneeException e) {
				
			}
			finally {
				
			}
		}
		//edit consignee
		if (null != this.getAction() && CommonConstants.ACTION_EDIT_TYPE.equals(this.getAction())) {
			BeanCopier copyHere = BeanCopier.create(ConsigneeVo.class, Consignee.class, false);
			Consignee consignee = new Consignee();
			copyHere.copy(this.getEditData(), consignee, null);
			this.getConsigneeService().saveOrUpdateConsignee(consignee);
			this.setSelectedData(this.getEditData());
			List<ConsigneeVo> dataLists = this.getDatas();
			for (ConsigneeVo cVo:dataLists) {
				if (this.getEditData().getId().equals(cVo.getId())) {
					BeanCopier copyHere1 = BeanCopier.create(ConsigneeVo.class, ConsigneeVo.class, false);
					copyHere1.copy(this.getEditData(), cVo, null);
				}
			}
			
		}
		return null;
	}
	
	public String requireUpdateConsignee() throws ConsigneeException {
		operationAfterExeAction();
		Map<String,UIComponent> componentMap = new HashMap<String,UIComponent>();
		List<UIComponent> te= new ArrayList<UIComponent>();
		UIViewRoot currentViewRoot = FacesContext.getCurrentInstance().getViewRoot();
		for(UIComponent component : currentViewRoot.getChildren()){ 
            te= UIComponentUtil.getComponentChildren(component,componentMap); 
        }
		UIData tempTable = (UIData) componentMap.get("table");
		setSelectedData((ConsigneeVo) tempTable.getRowData());
		try {
			PropertyUtils.copyProperties(this.getEditData(),this.getSelectedData());
			this.setAction(CommonConstants.ACTION_EDIT_TYPE);
		} catch(Exception e)
		{
			System.out.println(e.toString());
		}
		return null;
	}
	public String selfTakeSelection() throws ConsigneeException {
		operationAfterExeAction();
		//takeSelection();
		this.setAction("");
		return null;
	}
	public String deleteConsignee() throws ConsigneeException {
		operationAfterExeAction();
		if (this.getEditData() == null) {
			this.setErrorMessages("您未选择要删除的数据!");
			return null;
		} else if (this.getEditData().getId() == null || "".equals(this.getEditData().getId())) {
			this.setErrorMessages("您未选择要删除的数据!");
			return null;
		}
		Consignee curConsignee =(Consignee) this.getConsigneeService().getConsigneeById(this.getEditData().getId());
		
		if (null == curConsignee) {
			this.setErrorMessages("未找到匹配的数据供删除!");
			return null;
		} else {
			this.getConsigneeService().delConsigneeById(this.getEditData().getId());
			this.setErrorMessages("您选择的联系人:" + this.getEditData().getShortName() + " 已成功删除!");
			this.getDatas().remove(this.getSelectedData());
			ConsigneeVo newConsigneeVo = new ConsigneeVo();
			newConsigneeVo.setSelected(false);
			this.setEditData(newConsigneeVo);
			this.setAction(CommonConstants.ACTION_NEW_TYPE);
		}
		return null;
	}
	public String deleteConsigneeByEachItem() throws ConsigneeException {
		operationAfterExeAction();
		Map<String,UIComponent> componentMap = new HashMap<String,UIComponent>();
		List<UIComponent> te= new ArrayList<UIComponent>();
		UIViewRoot currentViewRoot = FacesContext.getCurrentInstance().getViewRoot();
		for(UIComponent component : currentViewRoot.getChildren()){ 
            te= UIComponentUtil.getComponentChildren(component,componentMap); 
        }
		UIData tempTable = (UIData) componentMap.get("table");
		ConsigneeVo delConsigneeVo = (ConsigneeVo) tempTable.getRowData();
		System.out.println(delConsigneeVo.getId().toString());
		Consignee curConsignee =(Consignee) this.getConsigneeService().getConsigneeById(delConsigneeVo.getId().intValue());
		if (null == curConsignee) {
			this.setErrorMessages("未找到匹配的数据供删除!");
			return null;
		} else {
			this.getConsigneeService().delConsigneeById(delConsigneeVo.getId().intValue());
			this.getDatas().remove(delConsigneeVo);
			System.out.println("removed  success=========================");
			//clear EditData and selectedData if delete data same as.
			if (null != this.getEditData() && (this.getEditData().getId() == (delConsigneeVo.getId()))) {
				System.out.println("11111111111111111=========================");
				ConsigneeVo newConsigneeVo = new ConsigneeVo();
				newConsigneeVo.setSelected(false);
				this.setEditData(newConsigneeVo);
				this.setSelectedData(newConsigneeVo);
				this.setAction(CommonConstants.ACTION_NEW_TYPE);
			}
		}
		return null;
	}
	
	public String preDddConsignee(){
		operationAfterExeAction();
		this.setAction(CommonConstants.ACTION_NEW_TYPE);
		ConsigneeVo newConsigneeVo = new ConsigneeVo();
		newConsigneeVo.setSelected(false);
		this.setEditData(newConsigneeVo);
		this.setSelectedData(newConsigneeVo);
		return null;
	}
	private void operationAfterExeAction(){
		this.setErrorMessages("");
	}
	// getTotalCount() in this bean not used , so it's not need to realize
	public int getTotalCount() {
		return 0;
	}
	// getDataPage() in this bean not used , so it's not need to realize
	public DataPage<ConsigneeVo> getDataPage(int startRow, int pageSize) {
		return null;
	}
	// getDataPage() in this bean not used , so it's not need to realize
	public DataModel getDataModel(){
		return null;
	}
	//in this bean data must from DB first.
	public DataModel getCurrDataModel() {
		 DataModel cdataModel = null;
		 cdataModel= new ExtendedTableDataModel<ConsigneeVo>(new DataProvider<ConsigneeVo>(){

			private static final long serialVersionUID = 5054087821033164847L;

			public ConsigneeVo getItemByKey(Object key) {
				for(ConsigneeVo c : getDatas()){
					if (key.equals(getKey(c))){
						return c;
					}
				}
				return null;
			}

			public List<ConsigneeVo> getItemsByRange(int firstRow, int endRow) {
				return (null != getDatas())?getDatas().subList(firstRow, endRow):null;
			}

			public Object getKey(ConsigneeVo item) {
				return getIdItem(item);
			}

			public int getRowCount() {
				return (null != getDatas())?getDatas().size():0;
			}
			
		});
	
	return cdataModel;
		
	}

}

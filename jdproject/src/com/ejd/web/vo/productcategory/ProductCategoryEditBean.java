package com.ejd.web.vo.productcategory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.apache.commons.beanutils.PropertyUtils;
import org.richfaces.component.UIExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;
import org.richfaces.validator.BeanValidator;
import org.richfaces.validator.FacesBeanValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.ejd.model.exception.ProductCategoryException;
import com.ejd.model.service.iface.IProductCategoryService;
import com.ejd.web.bo.Productcategory;
import com.ejd.web.vo.productcategory.ProductCategoryItem;

public class ProductCategoryEditBean extends ProductCategoryBaseBean {
	private String newProgressString="请填写以下信息";
	private String searchProductCategoryName = "";
	private String sortMode="single";
	private String selectionMode="single";
	private int scrollerPage;
	private UIExtendedDataTable table;

	private ExtendedTableDataModel<ProductCategoryItem> dataModel;
	private List<ProductCategoryItem> productCategorys = new ArrayList<ProductCategoryItem>();
	private SimpleSelection selection = new SimpleSelection();
    private ProductCategoryItem selectedProductCategory = new ProductCategoryItem();
    private ProductCategory editProductCategory = new ProductCategory();
    
	public String getNewProgressString() {
		return newProgressString;
	}
	public void setNewProgressString(String newProgressString) {
		this.newProgressString = newProgressString;
	}
	
	public String getSearchProductCategoryName() {
		return searchProductCategoryName;
	}
	public void setSearchProductCategoryName(String searchProductCategoryName) {
		this.searchProductCategoryName = searchProductCategoryName;
	}
	public String getSortMode() {
		return sortMode;
	}
	public void setSortMode(String sortMode) {
		this.sortMode = sortMode;
	}
	public String getSelectionMode() {
		return selectionMode;
	}
	public void setSelectionMode(String selectionMode) {
		this.selectionMode = selectionMode;
	}
	public int getScrollerPage() {
		return scrollerPage;
	}
	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}
	public UIExtendedDataTable getTable() {
		return table;
	}
	public void setTable(UIExtendedDataTable table) {
		this.table = table;
	}
	public List<ProductCategoryItem> getProductCategorys() {
		return productCategorys;
	}
	public void setProductCategorys(List<ProductCategoryItem> productCategorys) {
		this.productCategorys = productCategorys;
	}
	public SimpleSelection getSelection() {
		return selection;
	}
	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}
	public ProductCategoryItem getSelectedProductCategory() {
		return selectedProductCategory;
	}
	public void setSelectedProductCategory(ProductCategoryItem selectedProductCategory) {
		this.selectedProductCategory = selectedProductCategory;
	}
	
	public ProductCategory getEditProductCategory() {
		return editProductCategory;
	}
	public void setEditProductCategory(ProductCategory editProductCategory) {
		this.editProductCategory = editProductCategory;
	}
	public ProductCategoryEditBean() {
		init();
	}
	protected void init() {
		ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IProductCategoryService em = (IProductCategoryService) appctx.getBean("productCategoryService");
		this.setProductCategoryService(em);
	}
	public ExtendedTableDataModel<ProductCategoryItem> getProductCategorysDataModel() {
		
			dataModel = new ExtendedTableDataModel<ProductCategoryItem>(new DataProvider<ProductCategoryItem>(){

				private static final long serialVersionUID = 5054087821033164847L;

				public ProductCategoryItem getItemByKey(Object key) {
					for(ProductCategoryItem c : productCategorys){
						if (key.equals(getKey(c))){
							return c;
						}
					}
					return null;
				}

				public List<ProductCategoryItem> getItemsByRange(int firstRow, int endRow) {
					return productCategorys.subList(firstRow, endRow);
				}

				public Object getKey(ProductCategoryItem item) {
					return item.getCategoryName();
				}

				public int getRowCount() {
					return productCategorys.size();
				}
				
			});
		
		return dataModel;
	}
	public String takeSelection() {
		//this.setSelectedProductCategory(null);
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()){
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				setSelectedProductCategory((ProductCategoryItem) table.getRowData());
				try {
					PropertyUtils.copyProperties(editProductCategory,selectedProductCategory);
				} catch(Exception e)
				{
					System.out.println(e.toString());
				}

			}
		}
		
		return null;
	}
	public void richBeanValidate(ActionEvent event) {
		FacesContext context= FacesContext.getCurrentInstance();
		UIViewRoot view = context.getViewRoot();
		HtmlInputText inputText = (HtmlInputText) view.findComponent("manageTemplateView:productcategoryEditform:categoryName");
		FacesBeanValidator beanValidator = new FacesBeanValidator();
		inputText.addValidator(beanValidator);
		HtmlInputText inputTexto = (HtmlInputText) view.findComponent("manageTemplateView:productcategoryEditform:serialNumber");
		inputTexto.addValidator(beanValidator);
	}
	public void richBeanValidateNone(ActionEvent event) {
		FacesContext context= FacesContext.getCurrentInstance();
		UIViewRoot view = context.getViewRoot();
		HtmlInputText inputText = (HtmlInputText) view.findComponent("manageTemplateView:productcategoryEditform:categoryName");
		FacesBeanValidator beanValidator = new FacesBeanValidator();
		inputText.removeValidator(beanValidator);
		inputText.setValid(Boolean.TRUE);
		HtmlInputText inputTexto = (HtmlInputText) view.findComponent("manageTemplateView:productcategoryEditform:serialNumber");
		inputTexto.removeValidator(beanValidator);
		inputTexto.setValid(Boolean.TRUE);
	}
	public String updateProductCategory() throws ProductCategoryException {
		if (this.getProductCategoryService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductCategoryService em = (IProductCategoryService) appctx.getBean("productCategoryService");
			this.setProductCategoryService(em);
		}
		Productcategory productCategory =(Productcategory) this.getProductCategoryService().getProductCategoryByName(editProductCategory.getCategoryName());
		
		if (productCategory != null) {
			setNewProgressString(editProductCategory.getCategoryName()+" 已存在！");
		} else {
			Productcategory newproductCategory = (Productcategory) this.getProductCategoryService().getProductCategoryById(editProductCategory.getId());
			newproductCategory.setCategoryName(editProductCategory.getCategoryName());
			newproductCategory.setSerialNumber(editProductCategory.getSerialNumber());
			this.getProductCategoryService().updateProductCategory(newproductCategory);
			setNewProgressString(editProductCategory.getCategoryName()+" 保存成功!");
			selectedProductCategory.setCategoryName(editProductCategory.getCategoryName());
			selectedProductCategory.setSerialNumber(editProductCategory.getSerialNumber());
		}
		return null;
	}
	public String searchProductCategoryByName() {
		return null;
	}
	public String searchAllProductCategory() throws ProductCategoryException{ 
		if (this.getProductCategorys() != null) {
			this.setProductCategorys(null);
		}
		List<Productcategory> productCategoryList = new ArrayList<Productcategory>();
		productCategoryList = this.getProductCategoryService().getAllProductCategory();
		List<ProductCategoryItem> newproductCategorys = new ArrayList<ProductCategoryItem>();
		for(Productcategory c : productCategoryList){
			ProductCategoryItem productCategoryItem = new ProductCategoryItem();
			productCategoryItem.setId(c.getId());
			productCategoryItem.setCategoryName(c.getCategoryName());
			productCategoryItem.setSerialNumber(c.getSerialNumber());
			productCategoryItem.setSelected(Boolean.FALSE);
			newproductCategorys.add(productCategoryItem);
		}
		this.setProductCategorys(newproductCategorys);
		return null;
	}
}

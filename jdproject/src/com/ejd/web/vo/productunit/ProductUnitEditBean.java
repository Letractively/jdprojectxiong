package com.ejd.web.vo.productunit;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.beanutils.PropertyUtils;
import org.hibernate.validator.Validator;
import org.richfaces.component.UIExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;
import org.richfaces.validator.BeanValidator;
import org.richfaces.validator.FacesBeanValidator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import com.ejd.model.exception.ProductUnitException;
import com.ejd.model.service.iface.IProductUnitService;
import com.ejd.web.bo.Productunit;
import com.ejd.web.vo.productunit.ProductUnitItem;

public class ProductUnitEditBean extends ProductUnitBaseBean {
	private String newProgressString="";
	private String searchProductUnitName = "";
	private String sortMode="single";
	private String selectionMode="single";
	private int scrollerPage;
	private int recordNumberShow = 10;
	private SelectItem[] recordNumbers = {
			new SelectItem(new Integer(10),"10"),
			new SelectItem(new Integer(20),"20"),
			new SelectItem(new Integer(30),"30")
	};
	private UIExtendedDataTable table;

	private ExtendedTableDataModel<ProductUnitItem> dataModel;
	private List<ProductUnitItem> productUnits = new ArrayList<ProductUnitItem>();
	private SimpleSelection selection = new SimpleSelection();
    private ProductUnitItem selectedProductUnit = new ProductUnitItem();
    private ProductUnit editProductUnit = new ProductUnit();
    public String getNewProgressString() {
		return newProgressString;
	}
	public void setNewProgressString(String newProgressString) {
		this.newProgressString = newProgressString;
	}
	
	public String getSearchProductUnitName() {
		return searchProductUnitName;
	}
	public void setSearchProductUnitName(String searchProductUnitName) {
		this.searchProductUnitName = searchProductUnitName;
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
	
	public int getRecordNumberShow() {
		return recordNumberShow;
	}
	public void setRecordNumberShow(int recordNumberShow) {
		this.recordNumberShow = recordNumberShow;
	}
	
	public SelectItem[] getRecordNumbers() {
		return recordNumbers;
	}
	public void setRecordNumbers(SelectItem[] recordNumbers) {
		this.recordNumbers = recordNumbers;
	}
	public UIExtendedDataTable getTable() {
		return table;
	}
	public void setTable(UIExtendedDataTable table) {
		this.table = table;
	}
	public List<ProductUnitItem> getProductUnits() {
		return productUnits;
	}
	public void setProductUnits(List<ProductUnitItem> productUnits) {
		this.productUnits = productUnits;
	}
	public SimpleSelection getSelection() {
		return selection;
	}
	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}
	public ProductUnitItem getSelectedProductUnit() {
		return selectedProductUnit;
	}
	public void setSelectedProductUnit(ProductUnitItem selectedProductUnit) {
		this.selectedProductUnit = selectedProductUnit;
	}
	
	public ProductUnit getEditProductUnit() {
		return editProductUnit;
	}
	public void setEditProductUnit(ProductUnit editProductUnit) {
		this.editProductUnit = editProductUnit;
	}
	
	public ProductUnitEditBean() {
		//init();
	}
	protected void init() {
		ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IProductUnitService em = (IProductUnitService) appctx.getBean("productUnitService");
		this.setProductUnitService(em);
	}
	public ExtendedTableDataModel<ProductUnitItem> getProductUnitsDataModel() {
		
			dataModel = new ExtendedTableDataModel<ProductUnitItem>(new DataProvider<ProductUnitItem>(){

				private static final long serialVersionUID = 5054087821033164847L;

				public ProductUnitItem getItemByKey(Object key) {
					for(ProductUnitItem c : productUnits){
						if (key.equals(getKey(c))){
							return c;
						}
					}
					return null;
				}

				public List<ProductUnitItem> getItemsByRange(int firstRow, int endRow) {
					return productUnits.subList(firstRow, endRow);
				}

				public Object getKey(ProductUnitItem item) {
					return item.getUnitName();
				}

				public int getRowCount() {
					return productUnits.size();
				}
				
			});
		
		return dataModel;
	}
	public String takeSelection() {
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()){
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				setSelectedProductUnit((ProductUnitItem) table.getRowData());
				try {
					PropertyUtils.copyProperties(editProductUnit,selectedProductUnit);
				} catch(Exception e)
				{
					System.out.println(e.toString());
				}

			}
		}
		
		return null;
	}
	public String updateProductUnit() throws ProductUnitException {
		if (this.getProductUnitService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductUnitService em = (IProductUnitService) appctx.getBean("productUnitService");
			this.setProductUnitService(em);
		}
		if (editProductUnit == null) {
			return null;
		}
		Productunit productUnit =(Productunit) this.getProductUnitService().getProductUnitByName(editProductUnit.getUnitName());
		
		if (productUnit != null) {
			setNewProgressString("\""+editProductUnit.getUnitName()+"\"已存在！");
		} else if ((editProductUnit.getId() != null) && (!"".equals(editProductUnit.getId()))) {
			Productunit newproductUnit = (Productunit) this.getProductUnitService().getProductUnitById(editProductUnit.getId());
			newproductUnit.setUnitName(editProductUnit.getUnitName());
			newproductUnit.setSerialNumber(editProductUnit.getSerialNumber());
			this.getProductUnitService().updateProductUnit(newproductUnit);
			setNewProgressString("\""+editProductUnit.getUnitName()+"\"保存成功!");
			selectedProductUnit.setUnitName(editProductUnit.getUnitName());
			selectedProductUnit.setSerialNumber(editProductUnit.getSerialNumber());
		}
		return null;
	}
	public String searchProductUnitByName() throws ProductUnitException{
		if (this.getProductUnitService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductUnitService em = (IProductUnitService) appctx.getBean("productUnitService");
			this.setProductUnitService(em);
		}
		if ("".equals(searchProductUnitName)) {
			return null;
		} else {
			if (productUnits != null && productUnits.size() > 0) {
				productUnits.clear();
			}
			if (selectedProductUnit != null) {
				this.setSelectedProductUnit (new ProductUnitItem());
			}
			if (editProductUnit != null) {
				this.setEditProductUnit(new ProductUnit());
			}
			if (selection  != null) {
				this.setSelection(new SimpleSelection());
			}
			Productunit newProductUnit = new Productunit();
			newProductUnit = this.getProductUnitService().getProductUnitByName(searchProductUnitName);
			ProductUnitItem productUnitItem = new ProductUnitItem();
			if (newProductUnit != null) {
				productUnitItem.setId(newProductUnit.getId());
				productUnitItem.setUnitName(newProductUnit.getUnitName());
				productUnitItem.setSerialNumber(newProductUnit.getSerialNumber());
				productUnitItem.setSelected(Boolean.FALSE);
				productUnits.add(productUnitItem);
			}
			return null;
		}
	}
	public String searchAllProductUnit() throws ProductUnitException{ 
		if (this.getProductUnits() != null) {
			this.setProductUnits(null);
		}
		List<Productunit> productUnitList = new ArrayList<Productunit>();
		productUnitList = this.getProductUnitService().getAllProductUnit();
		List<ProductUnitItem> newproductUnits = new ArrayList<ProductUnitItem>();
		for(Productunit c : productUnitList){
			ProductUnitItem productUnitItem = new ProductUnitItem();
			productUnitItem.setId(c.getId());
			productUnitItem.setUnitName(c.getUnitName());
			productUnitItem.setSerialNumber(c.getSerialNumber());
			productUnitItem.setSelected(Boolean.FALSE);
			newproductUnits.add(productUnitItem);
		}
		this.setProductUnits(newproductUnits);
		return null;
	}
	public String deleteProductUnit() throws ProductUnitException {
		if (this.getProductUnitService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductUnitService em = (IProductUnitService) appctx.getBean("productUnitService");
			this.setProductUnitService(em);
		}
		if (editProductUnit == null) {
			return null;
		} else if (editProductUnit.getId() == null || "".equals(editProductUnit.getId())) {
			return null;
		}
		Productunit productUnit =(Productunit) this.getProductUnitService().getProductUnitById(editProductUnit.getId());
		
		if (productUnit == null) {
			return null;
		} else if (!(editProductUnit.getUnitName().equals(productUnit.getUnitName()))) {
			setNewProgressString(""+editProductUnit.getUnitName()+""+productUnit.getUnitName()+"");
			return null;
		} else {
			this.getProductUnitService().delProductUnitById(productUnit.getId());
			setNewProgressString("\""+editProductUnit.getUnitName()+"");
			productUnits.remove(selectedProductUnit);
			editProductUnit = new ProductUnit();
		}
		return null;
	}

}

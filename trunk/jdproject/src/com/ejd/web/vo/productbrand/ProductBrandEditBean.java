package com.ejd.web.vo.productbrand;

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

import com.ejd.model.exception.ProductBrandException;
import com.ejd.model.service.iface.IProductBrandService;
import com.ejd.web.bo.Productbrand;
import com.ejd.web.vo.productbrand.ProductBrandItem;

public class ProductBrandEditBean extends ProductBrandBaseBean {
	private String newProgressString="请填写以下信息";
	private String searchProductBrandName = "";
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

	private ExtendedTableDataModel<ProductBrandItem> dataModel;
	private List<ProductBrandItem> productBrands = new ArrayList<ProductBrandItem>();
	private SimpleSelection selection = new SimpleSelection();
    private ProductBrandItem selectedProductBrand = new ProductBrandItem();
    private ProductBrand editProductBrand = new ProductBrand();
    public String getNewProgressString() {
		return newProgressString;
	}
	public void setNewProgressString(String newProgressString) {
		this.newProgressString = newProgressString;
	}
	
	public String getSearchProductBrandName() {
		return searchProductBrandName;
	}
	public void setSearchProductBrandName(String searchProductBrandName) {
		this.searchProductBrandName = searchProductBrandName;
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
	public List<ProductBrandItem> getProductBrands() {
		return productBrands;
	}
	public void setProductBrands(List<ProductBrandItem> productBrands) {
		this.productBrands = productBrands;
	}
	public SimpleSelection getSelection() {
		return selection;
	}
	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}
	public ProductBrandItem getSelectedProductBrand() {
		return selectedProductBrand;
	}
	public void setSelectedProductBrand(ProductBrandItem selectedProductBrand) {
		this.selectedProductBrand = selectedProductBrand;
	}
	
	public ProductBrand getEditProductBrand() {
		return editProductBrand;
	}
	public void setEditProductBrand(ProductBrand editProductBrand) {
		this.editProductBrand = editProductBrand;
	}
	
	public ProductBrandEditBean() {
		init();
	}
	protected void init() {
		ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IProductBrandService em = (IProductBrandService) appctx.getBean("productBrandService");
		this.setProductBrandService(em);
	}
	public ExtendedTableDataModel<ProductBrandItem> getProductBrandsDataModel() {
		
			dataModel = new ExtendedTableDataModel<ProductBrandItem>(new DataProvider<ProductBrandItem>(){

				private static final long serialVersionUID = 5054087821033164847L;

				public ProductBrandItem getItemByKey(Object key) {
					for(ProductBrandItem c : productBrands){
						if (key.equals(getKey(c))){
							return c;
						}
					}
					return null;
				}

				public List<ProductBrandItem> getItemsByRange(int firstRow, int endRow) {
					return productBrands.subList(firstRow, endRow);
				}

				public Object getKey(ProductBrandItem item) {
					return item.getBrandName();
				}

				public int getRowCount() {
					return productBrands.size();
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
				setSelectedProductBrand((ProductBrandItem) table.getRowData());
				try {
					PropertyUtils.copyProperties(editProductBrand,selectedProductBrand);
				} catch(Exception e)
				{
					System.out.println(e.toString());
				}

			}
		}
		
		return null;
	}
	public String updateProductBrand() throws ProductBrandException {
		if (this.getProductBrandService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductBrandService em = (IProductBrandService) appctx.getBean("productBrandService");
			this.setProductBrandService(em);
		}
		if (editProductBrand == null) {
			return null;
		}
		Productbrand productBrand =(Productbrand) this.getProductBrandService().getProductBrandByName(editProductBrand.getBrandName());
		
		if (productBrand != null) {
			setNewProgressString("\""+editProductBrand.getBrandName()+"\"已存在！");
		} else if ((editProductBrand.getId() != null) && (!"".equals(editProductBrand.getId()))) {
			Productbrand newproductBrand = (Productbrand) this.getProductBrandService().getProductBrandById(editProductBrand.getId());
			newproductBrand.setBrandName(editProductBrand.getBrandName());
			newproductBrand.setSerialNumber(editProductBrand.getSerialNumber());
			this.getProductBrandService().updateProductBrand(newproductBrand);
			setNewProgressString("\""+editProductBrand.getBrandName()+"\"保存成功!");
			selectedProductBrand.setBrandName(editProductBrand.getBrandName());
			selectedProductBrand.setSerialNumber(editProductBrand.getSerialNumber());
		}
		return null;
	}
	public String searchProductBrandByName() throws ProductBrandException{
		if (this.getProductBrandService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductBrandService em = (IProductBrandService) appctx.getBean("productBrandService");
			this.setProductBrandService(em);
		}
		if ("".equals(searchProductBrandName)) {
			return null;
		} else {
			if (productBrands != null && productBrands.size() > 0) {
				productBrands.clear();
			}
			if (selectedProductBrand != null) {
				this.setSelectedProductBrand (new ProductBrandItem());
			}
			if (editProductBrand != null) {
				this.setEditProductBrand(new ProductBrand());
			}
			Productbrand newProductBrand = new Productbrand();
			newProductBrand = this.getProductBrandService().getProductBrandByName(searchProductBrandName);
			ProductBrandItem productBrandItem = new ProductBrandItem();
			if (newProductBrand != null) {
				productBrandItem.setId(newProductBrand.getId());
				productBrandItem.setBrandName(newProductBrand.getBrandName());
				productBrandItem.setSerialNumber(newProductBrand.getSerialNumber());
				productBrandItem.setSelected(Boolean.FALSE);
			}
			productBrands.add(productBrandItem);
			return null;
		}
	}
	public String searchAllProductBrand() throws ProductBrandException{ 
		if (this.getProductBrands() != null) {
			this.setProductBrands(null);
		}
		List<Productbrand> productBrandList = new ArrayList<Productbrand>();
		productBrandList = this.getProductBrandService().getAllProductBrand();
		List<ProductBrandItem> newproductBrands = new ArrayList<ProductBrandItem>();
		for(Productbrand c : productBrandList){
			ProductBrandItem productBrandItem = new ProductBrandItem();
			productBrandItem.setId(c.getId());
			productBrandItem.setBrandName(c.getBrandName());
			productBrandItem.setSerialNumber(c.getSerialNumber());
			productBrandItem.setSelected(Boolean.FALSE);
			newproductBrands.add(productBrandItem);
		}
		this.setProductBrands(newproductBrands);
		return null;
	}
	public String deleteProductBrand() throws ProductBrandException {
		if (this.getProductBrandService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductBrandService em = (IProductBrandService) appctx.getBean("productBrandService");
			this.setProductBrandService(em);
		}
		if (editProductBrand == null) {
			return null;
		} else if (editProductBrand.getId() == null || "".equals(editProductBrand.getId())) {
			return null;
		}
		Productbrand productBrand =(Productbrand) this.getProductBrandService().getProductBrandById(editProductBrand.getId());
		
		if (productBrand == null) {
			return null;
		} else if (!(editProductBrand.getBrandName().equals(productBrand.getBrandName()))) {
			setNewProgressString("您删除的种类名称：\""+editProductBrand.getBrandName()+"\"与实际的种类名称\""+productBrand.getBrandName()+"\"不符，不能删除!");
			return null;
		} else {
			this.getProductBrandService().delProductBrandById(productBrand.getId());
			setNewProgressString("\""+editProductBrand.getBrandName()+"\"删除成功!");
			productBrands.remove(selectedProductBrand);
			editProductBrand = new ProductBrand();
		}
		return null;
	}

}

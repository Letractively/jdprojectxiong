package com.ejd.web.vo;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.faces.context.FacesContext;

import org.richfaces.component.UIScrollableDataTable;

import com.ejd.model.exception.ProductCategoryException;
import com.ejd.web.vo.productcategory.ProductCategory;
import com.ejd.web.vo.productcategory.ProductCategoryBaseBean;
import com.ejd.web.vo.productcategory.ProductCategoryItem;
import org.richfaces.model.SortField;
import org.richfaces.model.SortOrder;
import org.richfaces.model.selection.SimpleSelection;
import javax.faces.component.UIComponent;
import javax.faces.event.ValueChangeEvent;
import com.ejd.web.bo.Productcategory;
import com.ejd.model.exception.ProductCategoryException;
import com.ejd.model.service.iface.IProductCategoryService;

import org.richfaces.component.UITabPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;
public class ProductCategoryTabBean extends ProductCategoryBaseBean{
	//this is for tabPaenl start
	private UIComponent tabPanel;
	
	private static final String NONE = "none";
	
	private String disabledTabName = NONE;
	
	private String currentTab = "new";
	//this is for tabPaenl end
	//this is for create new productCategory start
	private String newProgressString="";
	private ProductCategory newProductCategory =  new ProductCategory(); 
	
	//this is for create new productCategory end
	
	private ProductCategoryItem currentItem = new ProductCategoryItem();	

	private Set<Integer> keys = new HashSet<Integer>();
	
	private int currentRow;	
	
	private SimpleSelection selection = new SimpleSelection();
	
	private UIScrollableDataTable table;
	
	private SortOrder order = new SortOrder();
	
	private int scrollerPage;
	
	private ArrayList<ProductCategoryItem> selectedCars = new ArrayList<ProductCategoryItem>();
	private static int DECIMALS = 1;
	private static int ROUNDING_MODE = BigDecimal.ROUND_HALF_UP;
	
	private List <ProductCategoryItem> allCars = null;

	public ProductCategoryTabBean() {
		init();
	}
	protected void init() {
		ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
		IProductCategoryService em = (IProductCategoryService) appctx.getBean("productCategoryService");
		this.setProductCategoryService(em);
	}
	
	public List<ProductCategoryItem> getAllCars() {
		return allCars;
	}

	public SimpleSelection getSelection() {
		return selection;
	}

	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}
	
	public String takeSelection() {
		getSelectedCars().clear();
		if (getSelection().isSelectAll()){
			getSelectedCars().addAll(allCars);
		}else{
			Iterator<Object> iterator = getSelection().getKeys();
			while (iterator.hasNext()){
				Object key = iterator.next();
				table.setRowKey(key);
				if (table.isRowAvailable()) {
					getSelectedCars().add((ProductCategoryItem) table.getRowData());
				}
			}
		}
		return null;
	}

	public ArrayList<ProductCategoryItem> getSelectedCars() {
		return selectedCars;
	}

	public void setSelectedCars(ArrayList<ProductCategoryItem> selectedCars) {
		this.selectedCars = selectedCars;
	}

	public UIScrollableDataTable getTable() {
		return table;
	}

	public void setTable(UIScrollableDataTable table) {
		this.table = table;
	}
	
	public ArrayList<ProductCategoryItem[]> getModel() {

		ArrayList<ProductCategoryItem[]> model = new ArrayList<ProductCategoryItem[]>();
		return model;
	}

	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public SortOrder getOrder() {
		return order;
	}

	public void setOrder(SortOrder order) {
		this.order = order;
	}

	public ProductCategoryItem getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(ProductCategoryItem currentItem) {
		this.currentItem = currentItem;
	}

	public int getCurrentRow() {
		return currentRow;
	}

	public void setCurrentRow(int currentRow) {
		this.currentRow = currentRow;
	}

	public void store() {
		allCars.set(currentRow, currentItem);
		keys.clear();
		keys.add(currentRow);
	}

	public void delete() {
		allCars.remove(currentRow);
	}

	public Set<Integer> getKeys() {
		return keys;
	}

	public void setKeys(Set<Integer> keys) {
		this.keys = keys;
	}
	// tabPanel

	public String getCurrentTab() {
		return currentTab;
	}
	
	public void setCurrentTab(String currentTab) {
		this.currentTab = currentTab;
		System.out.println("Bean.setCurrentTab(): " + currentTab);
	}
	
	public UIComponent getTabPanel() {
		return tabPanel;
	}
	public void setTabPanel(UIComponent tabPanel) {
		this.tabPanel = tabPanel;
	}
	public String getDisabledTabName() {
		return disabledTabName;
	}
	public void setDisabledTabName(String disabledTabId) {
		this.disabledTabName = disabledTabId;
		
	}
	public String disableTab() {
		UITabPanel tabPanel = (UITabPanel) getTabPanel();
		Object value = tabPanel.getValue();
		if (value != null && value.equals(disabledTabName)) {
			List tabNames = getTabNames();
			int idx = tabNames.indexOf(value);

			int i = idx + 1;
			if (i >= tabNames.size()) {

				if (!tabNames.isEmpty()) {
					tabPanel.setValue(tabNames.get(0));
				}

			} else {
				tabPanel.setValue(tabNames.get(i));
			}
		}
		
		return null;
	}

	private static final List tabNames = new ArrayList();
	
	static {
		tabNames.add("new");
		tabNames.add("edit");
	}
	
	public List getTabNames() {
		return tabNames;
	}
	public void valueChanged(ValueChangeEvent event) {
		System.out.println("Bean.valueChanged()");
		System.out.println("Old value: " + event.getOldValue());
		System.out.println("New value: " + event.getNewValue());
		System.out.println("curtab: " + this.getCurrentTab());
	}

	public ProductCategory getNewProductCategory() {
		return newProductCategory;
	}

	public void setNewProductCategory(ProductCategory newProductCategory) {
		this.newProductCategory = newProductCategory;
	}

	public String getNewProgressString() {
		return newProgressString;
	}

	public void setNewProgressString(String newProgressString) {
		this.newProgressString = newProgressString;
	}
	public void success() throws ProductCategoryException{
		if (this.getProductCategoryService() == null) {
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			IProductCategoryService em = (IProductCategoryService) appctx.getBean("productCategoryService");
			this.setProductCategoryService(em);
		}
		Productcategory productCategory =(Productcategory) this.getProductCategoryService().getProductCategoryByName(newProductCategory.getCategoryName());
		
		if (productCategory != null) {
			setNewProgressString(newProductCategory.getCategoryName()+" 已存在！");
		} else {
			Productcategory creProductCategory = new Productcategory();
			creProductCategory.setCategoryName(newProductCategory.getCategoryName());
			creProductCategory.setSerialNumber(newProductCategory.getSerialNumber());
			this.getProductCategoryService().addProductCategory(creProductCategory);
			setNewProgressString(newProductCategory.getCategoryName()+" 保存成功!");
		}
    }


}

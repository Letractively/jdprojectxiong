package com.ejd.web.vo.genl;

import java.lang.reflect.ParameterizedType;

import org.apache.commons.beanutils.PropertyUtils;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.UIExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;

import com.ejd.common.datapage.DataPage;
import com.ejd.common.datapage.PagedListDataModel;
import com.ejd.model.exception.ProductException;
import com.ejd.web.bo.Product;
import com.ejd.web.vo.richfaces.header.HeaderConstants;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.model.DataModel;

public class AbstractTableDataModel<T,V> {
	protected Class<T> entityTClass;
	protected Class<V> entityVClass; 

	 public AbstractTableDataModel() {
		 entityTClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		 entityVClass = (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	 } 
	 protected Class<T> getEntityTClass() {
		 return entityTClass;
	 }
	 protected Class<V> getEntityVClass() {
		 return entityVClass;
	 }

	private int scrollerPage;
	private int numberOnePage;
	private int oldNumberOnePage;
	private UIDataTable table;
	private ExtendedTableDataModel dataModel;
	private List<T> datas = new ArrayList<T>();
	private T selectedData ;
	private V editData ;
	public int getScrollerPage() {
		return scrollerPage;
	}
	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}
	public int getNumberOnePage() {
		return numberOnePage;
	}
	public void setNumberOnePage(int numberOnePage) {
		this.numberOnePage = numberOnePage;
	}
	public int getOldNumberOnePage() {
		return oldNumberOnePage;
	}
	public void setOldNumberOnePage(int oldNumberOnePage) {
		this.oldNumberOnePage = oldNumberOnePage;
	}
	public int getDataCounts() {
		if (null == this.getDatas()) {
			return 0;
		}
		return this.getDatas().size();
	}
	public UIDataTable getTable() {
		return table;
	}
	public void setTable(UIDataTable table) {
		this.table = table;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public T getSelectedData() {
		return selectedData;
	}
	public void setSelectedData(T selectedData) {
		this.selectedData = selectedData;
	}
	
	public V getEditData() {
		return editData;
	}
	public void setEditData(V editData) {
		this.editData = editData;
	}
	

}

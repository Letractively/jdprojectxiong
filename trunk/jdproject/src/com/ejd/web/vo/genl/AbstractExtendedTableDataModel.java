package com.ejd.web.vo.genl;

import java.lang.reflect.ParameterizedType;

import org.apache.commons.beanutils.PropertyUtils;
import org.richfaces.component.UIDataTable;
import org.richfaces.component.UIExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AbstractExtendedTableDataModel<T,V> {
	protected Class<T> entityTClass;
	protected Class<V> entityVClass; 

	 public AbstractExtendedTableDataModel() {
		 entityTClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		 entityVClass = (Class<V>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	 } 
	 protected Class<T> getEntityTClass() {
		 return entityTClass;
	 }
	 protected Class<V> getEntityVClass() {
		 return entityVClass;
	 }

	private String sortMode="single";
	private String selectionMode="single";
	private int scrollerPage;
	private int pageRows = 0;
	private int recordNumberShow = 10;
	private UIExtendedDataTable table;
	private ExtendedTableDataModel<T> dataModel;
	private List<T> datas = new ArrayList<T>();
	private SimpleSelection selection = new SimpleSelection();
	private T selectedData ;
	private V editData ;
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
	public int getPageRows() {
		return this.getTable().getRowCount();
		
	}
	public void setRecordNumberShow(int recordNumberShow) {
		this.recordNumberShow = recordNumberShow;
	}
	
	public UIExtendedDataTable getTable() {
		return table;
	}
	public void setTable(UIExtendedDataTable table) {
		this.table = table;
	}
	public ExtendedTableDataModel<T> getDataModel() {
		return dataModel;
	}
	public void setDataModel(ExtendedTableDataModel<T> dataModel) {
		this.dataModel = dataModel;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public SimpleSelection getSelection() {
		return selection;
	}
	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
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
	public ExtendedTableDataModel<T> getCurrDataModel() {
		
		dataModel = new ExtendedTableDataModel<T>(new DataProvider<T>(){

			private static final long serialVersionUID = 5054087821033164847L;

			public T getItemByKey(Object key) {
				for(T c : datas){
					if (key.equals(getKey(c))){
						return c;
					}
				}
				return null;
			}

			public List<T> getItemsByRange(int firstRow, int endRow) {
				return datas.subList(firstRow, endRow);
			}

			public Object getKey(T item) {
				return getIdItem(item);
			}

			public int getRowCount() {
				return datas.size();
			}
			
		});
	
	return dataModel;
	}
	public Object getIdItem(T item) {
		return item;
	}
	public String takeSelection() {
		Iterator<Object> iterator = getSelection().getKeys();
		while (iterator.hasNext()){
			Object key = iterator.next();
			table.setRowKey(key);
			if (table.isRowAvailable()) {
				setSelectedData((T) table.getRowData());
				try {
					PropertyUtils.copyProperties(editData,selectedData);
				} catch(Exception e)
				{
					System.out.println(e.toString());
				}

			}
		}
		
		return null;
	}
	

}

package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.test.Capital;

import org.richfaces.component.UIExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;

/**
 * @author Ilya Shaikovsky
 *
 */
public class ExtendedTableBean {
	private String sortMode="single";
	private String selectionMode="multi";
	private int scrollerPage;
	private UIExtendedDataTable table;

	private ExtendedTableDataModel<Capital> dataModel;
	private List<Capital> capitals = new ArrayList<Capital>();
	private SimpleSelection selection = new SimpleSelection();
    private Capital selectedCapital = new Capital();
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

	public ExtendedTableBean() {
	}
	
	public ExtendedTableDataModel<Capital> getCapitalsDataModel() {
		if (dataModel == null) {
			dataModel = new ExtendedTableDataModel<Capital>(new DataProvider<Capital>(){

				private static final long serialVersionUID = 5054087821033164847L;

				public Capital getItemByKey(Object key) {
					for(Capital c : capitals){
						if (key.equals(getKey(c))){
							return c;
						}
					}
					return null;
				}

				public List<Capital> getItemsByRange(int firstRow, int endRow) {
					return capitals.subList(firstRow, endRow);
				}

				public Object getKey(Capital item) {
					return item.getName();
				}

				public int getRowCount() {
					return capitals.size();
				}
				
			});
		}
		return dataModel;
	}
	public String takeSelection() {
		setSelectedCapital(null);
			Iterator<Object> iterator = getSelection().getKeys();
			while (iterator.hasNext()){
				Object key = iterator.next();
				table.setRowKey(key);
				if (table.isRowAvailable()) {
					setSelectedCapital((Capital) table.getRowData());
				}
			}
		
		return null;
	}
	public String saveUpdate() {
		if (table.isRowAvailable()) {
			
		}
		return null;
	}
	public void setCapitals(List<Capital> capitals) {
		this.capitals = capitals;
	}
	public int getScrollerPage() {
		return scrollerPage;
	}

	public void setScrollerPage(int scrollerPage) {
		this.scrollerPage = scrollerPage;
	}

	public SimpleSelection getSelection() {
		return selection;
	}

	public void setSelection(SimpleSelection selection) {
		this.selection = selection;
	}

	public Capital getSelectedCapital() {
		return selectedCapital;
	}

	public void setSelectedCapital(Capital selectedCapital) {
		this.selectedCapital = selectedCapital;
	}

	public UIExtendedDataTable getTable() {
		return table;
	}

	public void setTable(UIExtendedDataTable table) {
		this.table = table;
	}

}
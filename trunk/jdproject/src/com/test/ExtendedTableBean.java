package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import com.ejd.web.bo.Person;
import com.ejd.web.bo.Stakeholder;
import com.test.Capital;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.richfaces.component.UIExtendedDataTable;
import org.richfaces.model.DataProvider;
import org.richfaces.model.ExtendedTableDataModel;
import org.richfaces.model.selection.SimpleSelection;
import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

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
		ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());

		SessionFactory at=(SessionFactory)appctx.getBean("sessionFactory",SessionFactory.class);
		Session aa = at.openSession();
		 Stakeholder s = new Stakeholder("abcd", "bcde", "aaaaaaaaa", "sc", "yc", "ym",
					"121212221", "1221212", "www.sohu.com", "woaini", "A", "C", "1342222222");
		aa.beginTransaction();
		aa.save(s);
		aa.flush();
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
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			Transaction tx = null;
			SessionFactory at=(SessionFactory)appctx.getBean("sessionFactory",SessionFactory.class);
			Session aa = at.openSession();
			 Stakeholder s = new Stakeholder("abcd", "bcde", "aaaaaaaaa", "sc", "yc", "ym",
						"121212221", "1221212", "www.sohu.com", "woaini", "A", "C", "1342222222");
			tx = aa.beginTransaction();
			Person p1 = new Person("name", 19, "sex", "phone", "tax", "mobile", "email", "address",
					"ship", "remark", 1);
			Person p2 = new Person();
			p2.setName("name1");
			p2.setAge(19);
			p2.setSex("male");
			p2.setPhone("1233333");
			p2.setTax("34434");
			p2.setMobile("12456777");
			p2.setEmail("jqhero792sohu.com");
			p2.setAddress("address");
			p2.setPrincipalship("mana");
			p2.setSortOrder(3);
			p2.setStakeholder(s);
			s.getConatctMans().add(p2);
			aa.save(s);
			//aa.save(p2);
			tx.commit();
			aa.flush();
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
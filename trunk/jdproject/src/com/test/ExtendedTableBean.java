package com.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.context.FacesContext;

import com.ejd.model.exception.ProductBrandException;
import com.ejd.model.exception.ProductCategoryException;
import com.ejd.model.exception.ProductUnitException;
import com.ejd.model.exception.StakeholderException;
import com.ejd.model.service.iface.IProductBrandService;
import com.ejd.model.service.iface.IProductCategoryService;
import com.ejd.model.service.iface.IProductUnitService;
import com.ejd.model.service.iface.IStakeholderService;
import com.ejd.web.bo.Person;
import com.ejd.web.bo.Product;
import com.ejd.web.bo.Productbrand;
import com.ejd.web.bo.Productcategory;
import com.ejd.web.bo.Productunit;
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
		 Stakeholder s = new Stakeholder("ID1","abcd", "bcde", "aaaaaaaaa", "sc", "yc", "ym",
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
			 Stakeholder s = new Stakeholder("ID2","abcd", "bcde", "aaaaaaaaa", "sc", "yc", "ym",
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
	public String addProduct() throws ProductBrandException,ProductCategoryException,StakeholderException,ProductUnitException {
		
			ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
			Transaction tx = null;
			SessionFactory at=(SessionFactory)appctx.getBean("sessionFactory",SessionFactory.class);
			Session aa = at.openSession();
			tx = aa.beginTransaction();
			Product p = new Product();
			p.setCode("product1");
			p.setManufacturerCode("433rer");
			p.setStatus("A");
			p.setBarcode("1234ie0");
			p.setSpec("1X4cm");
			p.setImageName("pee.jpg");
			p.setStockLowerNumber(12);
			p.setStockUpperNumber(100);
			p.setPurchasePrice(23.40);
			p.setTradePriceOne(10.00);
			p.setTradePriceTwo(12.00);
			p.setRetailPrice(20.00);
			p.setIntroduceFileName("product1.jsp");
			IStakeholderService stakeholderService = (IStakeholderService)appctx.getBean("stakeholderService");
			Stakeholder st = stakeholderService.getStakeholderById(new Integer(3));
			List ccc = st.getConatctMans();
			List ddd= st.getAddresses();
			List eee= st.getBanks();
			p.setProvider(st);
			IProductBrandService productBrandService = (IProductBrandService)appctx.getBean("productBrandService");
			Productbrand pb = productBrandService.getProductBrandById(new Integer(2));
			p.setBrand(pb);
			IProductCategoryService  productCategoryService = (IProductCategoryService)appctx.getBean("productCategoryService");
			Productcategory pt1= productCategoryService.getProductCategoryById(new Integer(1));
			Productcategory pt2= productCategoryService.getProductCategoryById(new Integer(2));
			p.setPrimaryCategory(pt1);
			p.setSecondCategory(pt2);
			IProductUnitService  productUnitService = (IProductUnitService)appctx.getBean("productUnitService");
			Productunit unit = productUnitService.getProductUnitById(new Integer(2));
			p.setUnit(unit);
			aa.save(p);
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
package com.ejd.web.vo.genl;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import org.hibernate.SessionFactory;

import bsh.This;

import com.ejd.common.datapage.DataPage;
import com.ejd.common.datapage.PagedBaseBean;
import com.ejd.common.datapage.PagedListDataModel;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.bo.Stakeholder;

public class PopupStakeholderBean extends PagedBaseBean {
	private String searchName;//for search;
	private String statusItem;//for search; 
	private String typeItem;//for search;
	private UIViewRoot parentViewRoot;
	private List<UIComponent> parentComponents;//these component need refresh;
	private String compomentId; //set value in opener page
	private String facesBean;//update facesbean;
	private String propertyOfFacesBean;// ;format with *.* or * or *.*.*.*
	private DataModel dataModel;
	public PopupStakeholderBean() {
		super();
	}
	public String getSearchSql() {
		String resultSql = "from Stakeholder s where 1=1";//order by s.fullName desc";*/
		if ( (null == this.getSearchName()) || (this.getSearchName().length() < 2)) {
			// do nothing;
		} else {
			resultSql = resultSql + " and s.fullName like ?";
		}
		String[] statusList = null;
		if (null != statusItem && !"".equals(statusItem)) {
			statusList = statusItem.split("|");
		}
		if (null != statusList && statusList.length > 0) {
			for (int i = 0; i <= statusList.length; i++) {
				if (i ==0) {
					resultSql = resultSql + " and (s.status = :status"+ String.valueOf(i);
				}  else {
					if ( i == statusList.length) {
						resultSql = resultSql + ")";
					} else {
						resultSql = resultSql + " or s.status = :status" + String.valueOf(i); 
					}
				}
			}
		}
		String [] typeList = null;
		if (null !=typeItem && !"".equals(typeItem)) {
			typeList = typeItem.split("|");
		}
		if (null != typeList && typeList.length > 0) {
			for (int i = 0; i <= typeList.length; i++) {
				if (i ==0) {
					resultSql = resultSql + " and (s.type = :type"+ String.valueOf(i);
				}  else {
					if ( i == typeList.length) {
						resultSql = resultSql + ")";
					} else {
						resultSql = resultSql + " or s.type = :type" + String.valueOf(i); 
					}
				}
			}
		}
			
		return resultSql;
	}
	
	public void setQueryProperty(Query q) {
		if ( (null == this.getSearchName()) || (this.getSearchName().length() < 2)) {
			// do nothing;
		} else {
			q.setString(0, "%" + this.getSearchName() + "%");
		}
		String[] statusList = null;
		if (null != statusItem && !"".equals(statusItem)) {
			statusList = statusItem.split("|");
		}
		if (null != statusList && statusList.length > 0) {
			for (int i = 0; i < statusList.length; i++) {
				q.setString("status" + String.valueOf(i), statusList[i]);
			}
		}
		String [] typeList = null;
		if (null !=typeItem && !"".equals(typeItem)) {
			typeList = typeItem.split("|");
		}
		if (null != typeList && typeList.length > 0) {
			for (int i = 0; i < typeList.length; i++) {
				q.setString("type"+ String.valueOf(i), typeList[i]);
			}
		}
		
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
	
	public String getStatusItem() {
		return statusItem;
	}
	public void setStatusItem(String statusItem) {
		this.statusItem = statusItem;
	}
	public String getTypeItem() {
		return typeItem;
	}
	public void setTypeItem(String typeItem) {
		this.typeItem = typeItem;
	}
	
	public UIViewRoot getParentViewRoot() {
		return parentViewRoot;
	}
	public void setParentViewRoot(UIViewRoot parentViewRoot) {
		this.parentViewRoot = parentViewRoot;
	}
	public List<UIComponent> getParentComponents() {
		return parentComponents;
	}
	public void setParentComponents(List<UIComponent> parentComponents) {
		this.parentComponents = parentComponents;
	}
	public String getCompomentId() {
		return compomentId;
	}
	public void setCompomentId(String compomentId) {
		this.compomentId = compomentId;
	}
	public String getFacesBean() {
		return facesBean;
	}
	public void setFacesBean(String facesBean) {
		this.facesBean = facesBean;
	}
	public String getPropertyOfFacesBean() {
		return propertyOfFacesBean;
	}
	public void setPropertyOfFacesBean(String propertyOfFacesBean) {
		this.propertyOfFacesBean = propertyOfFacesBean;
	}
	
	public void setDataModel(DataModel dataModel) {
		this.dataModel = dataModel;
	}
	public int getTotalCount() {
		int totalCount = 0;
		SessionFactory sf =(SessionFactory) SpringFacesUtil.getSpringBean("sessionFactory");
		Session session = sf.openSession();
		try {
		Query q = session.createQuery(this.getSearchSql());
		this.setQueryProperty(q);
		
		session.beginTransaction();
		List alist = q.list();
		totalCount = q.list().size();
		session.flush();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			  session.close();
		  }
		return totalCount;
	}
	public DataPage getDataPage(int startRow, int pageSize) {
		DataPage<Stakeholder> dataPage = null;
		SessionFactory sf =(SessionFactory) SpringFacesUtil.getSpringBean("sessionFactory");
		Session session = sf.openSession();
		try {
		Query query = session.createQuery(this.getSearchSql());
		this.setQueryProperty(query);
		query.setFirstResult(startRow);                    
        query.setMaxResults(pageSize);
        dataPage = new DataPage(getTotalCount(), startRow,query.list());
		session.beginTransaction();
		} catch (HibernateException e) {
			e.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			  session.close();
		  }
		return dataPage;
	}
	
	public void ActionListenerTest(ActionEvent e) {
		System.out.println("action event invoke!");
	}
	public void valueChange() {
		System.out.println(this.getSearchName());
		System.out.println(this.getFacesBean());
		System.out.println(this.getStatusItem());
		System.out.println(this.getTypeItem());
		System.out.println(this.getFacesBean());
		System.out.println(this.getPropertyOfFacesBean());
		System.out.println(this.getTotalCount());
		System.out.println(this.getSearchSql());
		   
		}
	public DataModel getDataModel(){
	   if (dataModel == null) {
	     dataModel = new PagedListDataModel(20) {
	     public DataPage<Stakeholder> fetchPage(int startRow, int pageSize) {
	      return getDataPage(startRow, pageSize);
	     }
	    };
	    
	    }
	   return dataModel;
	}
}

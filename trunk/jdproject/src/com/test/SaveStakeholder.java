package com.test;
import java.util.List;

import javax.faces.context.FacesContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.jsf.FacesContextUtils;

import com.ejd.web.bo.Address;
import com.ejd.web.bo.Bank;
import com.ejd.web.bo.Person;
import com.ejd.web.bo.Stakeholder;
public class SaveStakeholder extends HibernateDaoSupport {
	SessionFactory at;
 public SaveStakeholder(){
	ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());

	at=(SessionFactory)appctx.getBean("sessionFactory",SessionFactory.class);
	Session aa = at.openSession();
	Stakeholder s = null;
	aa.beginTransaction();
	s =(Stakeholder) aa.load(Stakeholder.class, 2);
	Person  p= new Person();
	p.setStakeholder(s);
	p.setName("xiong");
	p.setAge(31);
	aa.save(p);
	aa.flush();
 }
 public static void save() {
	 Stakeholder s = new Stakeholder("ID4","12345678","abcd", "bcde", "aaaaaaaaa", "sc", "yc", "ym",
				"121212221", "1221212", "www.sohu.com", "woaini", "A", "C", "1342222222");
	 
 }
 public static void main(String[] args) throws Exception {
	 SaveStakeholder aa = new SaveStakeholder();
 }
public SessionFactory getAt() {
	return at;
}
public void setAt(SessionFactory at) {
	this.at = at;
}

 
}

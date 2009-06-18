package com.ejd.utils;
import java.util.Map;
import org.springframework.web.context.support.WebApplicationContextUtils;
import javax.servlet.ServletContext;
import javax.faces.el.ValueBinding;
import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;

import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
public final class SpringFacesUtil {
  public SpringFacesUtil() {
  }
  /**
   * ¥”Spring÷–≤È’“bean.
   * @param beanname String
   * @return Object
   */
  public static Object getSpringBean(String beanName) {
	  ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
      return appctx.getBean(beanName);
  }

	  /*private static ValueBinding getValueBinding(String el) {
	    return getApplication().createValueBinding(el);
	  }*/
	  /*private static Application getApplication() {
	    ApplicationFactory appFactory = (ApplicationFactory) FactoryFinder.
	        getFactory(FactoryFinder.APPLICATION_FACTORY);
	    //FactoryFinder.FACES_CONTEXT_FACTORY
	    //FactoryFinder.RENDER_KIT_FACTORY
	    return appFactory.getApplication();
	  }*/
	  /**
	     * Get servlet context.
	     * 
	     * @return the servlet context
	     */
	    public static ServletContext getServletContext() {
	        return (ServletContext)FacesContext.getCurrentInstance().getExternalContext().getContext();
	    }
	    
	    /**
	     * Get managed bean based on the bean name.
	     * 
	     * @param beanName the bean name
	     * @return the managed bean associated with the bean name
	     */
	    public static Object getManagedBean(String beanName) {
	        Object o = getValueBinding(getJsfEl(beanName)).getValue(FacesContext.getCurrentInstance());
	        
	        return o;
	    }  
	    
	    /**
	     * Remove the managed bean based on the bean name.
	     * 
	     * @param beanName the bean name of the managed bean to be removed
	     */
	    public static void resetManagedBean(String beanName) {
	        getValueBinding(getJsfEl(beanName)).setValue(FacesContext.getCurrentInstance(), null);
	    }
	    
	    /**
	     * Store the managed bean inside the session scope.
	     * 
	     * @param beanName the name of the managed bean to be stored
	     * @param managedBean the managed bean to be stored
	     */
	    public static void setManagedBeanInSession(String beanName, Object managedBean) {
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(beanName, managedBean);
	    }
	    
	    public static FacesContext getFacesContext(){
	    	return FacesContext.getCurrentInstance();
	    }
	    public static UIViewRoot getViewRoot() {
	    	return getFacesContext().getViewRoot();
	    }
	    
	    public static String getViewId(){
	    	return getViewRoot().getId();
	    }
	    /**
	     * Get parameter value from request scope.
	     * 
	     * @param name the name of the parameter
	     * @return the parameter value
	     */
	    public static String getRequestParameter(String name) {
	        return (String)FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get(name);
	    }
	    
	    // Getters requstMap bean-----------------------------------------------------------------------------------

	    public static Object getRequestMapValue(String key) {
	        return FacesContext.getCurrentInstance().getExternalContext().getRequestMap().get(key);
	    }

	    // Setters requstMap bean-----------------------------------------------------------------------------------

	    public static void setRequestMapValue(String key, Object value) {
	        FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put(key, value);
	    }
	    // Getters sessionMap Bean----------------------------------------------------------------------------------

	    public static Object getSessionMapValue(String key) {
	        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(key);
	    }

	    // Setters sessionMap Bean-----------------------------------------------------------------------------------

	    public static void setSessionMapValue(String key, Object value) {
	        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(key, value);
	    }

	    // Getters -----------------------------------------------------------------------------------

	    public static Object getApplicationMapValue(String key) {
	        return FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().get(key);
	    }

	    // Setters -----------------------------------------------------------------------------------

	    public static void setApplicationMapValue(String key, Object value) {
	        FacesContext.getCurrentInstance().getExternalContext().getApplicationMap().put(key, value);
	    }
	    public static Object getUnknownMapValue(String key) {
	    	Object o = getRequestMapValue(key);
	    	if (null == o) {
	    		o = getSessionMapValue(key);
	    	}
	    	if (null == o) {
	    		o = getApplicationMapValue(key);
	    	}
	    	return o;
	    }

	    /**
	     * Add information message.
	     * 
	     * @param msg the information message
	     */
	    public static void addInfoMessage(String msg) {
	        addInfoMessage(null, msg);
	    }
	    
	    /**
	     * Add information message to a sepcific client.
	     * 
	     * @param clientId the client id 
	     * @param msg the information message
	     */
	    public static void addInfoMessage(String clientId, String msg) {
	        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
	    }
	    
	    /**
	     * Add error message.
	     * 
	     * @param msg the error message
	     */
	    public static void addErrorMessage(String msg) {
	        addErrorMessage(null, msg);
	    }
	    
	    /**
	     * Add error message to a sepcific client.
	     * 
	     * @param clientId the client id 
	     * @param msg the error message
	     */    
	    public static void addErrorMessage(String clientId, String msg) {
	        FacesContext.getCurrentInstance().addMessage(clientId, new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg));
	    }
	    
	    
	    private static Application getApplication() {
	        ApplicationFactory appFactory = (ApplicationFactory)FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
	        return appFactory.getApplication(); 
	    }
	    
	    private static ValueBinding getValueBinding(String el) {
	        return getApplication().createValueBinding(el);
	    }
	    
	    private static HttpServletRequest getServletRequest() {
	        return (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
	    }
	    
	    private static Object getElValue(String el) {
	        return getValueBinding(el).getValue(FacesContext.getCurrentInstance());
	    }
	    
	    private static String getJsfEl(String value) {
	        return "#{" + value + "}";
	    }

	    public static void redirectPage(String szPage) {
	    	FacesContext context = FacesContext.getCurrentInstance();
	    	javax.faces.application.Application app = context.getApplication();
	    	UIViewRoot view = app.getViewHandler().createView(context, szPage);
	    	context.setViewRoot(view);
	    	context.renderResponse();
	    } 

}


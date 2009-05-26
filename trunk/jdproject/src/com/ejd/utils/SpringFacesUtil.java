package com.ejd.utils;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.web.jsf.FacesContextUtils;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
public final class SpringFacesUtil {
  public SpringFacesUtil() {
  }
  /**
   * 从Spring中查找bean.
   * @param beanname String
   * @return Object
   */
  public static Object findBean(String beanname) {
	  ApplicationContext appctx = FacesContextUtils.getWebApplicationContext(FacesContext.getCurrentInstance());
      return appctx.getBean(beanname);
  }
  /**
   * 从JSF中查找bean.
   * @param beanname String
   * @return Object
   */
  public static Object lookupBean(String beanname) {
	  FacesContext fc = FacesContext.getCurrentInstance();
	  HttpServletRequest request = (HttpServletRequest)fc.getExternalContext().getRequest();
	  Object obj =(Object) request.getAttribute(beanname);
	  if (null == obj) {
		  Map  dd = fc.getExternalContext().getSessionMap();
		  obj = fc.getExternalContext().getSessionMap().get(beanname);
	  }
	  if (null == obj) {
		  fc.getExternalContext().getApplicationMap().get(beanname);
	  }
    return obj;
  }
}


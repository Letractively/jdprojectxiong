package com.ejd.web.vo.genl;

import java.io.IOException; 

import javax.faces.FactoryFinder;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.el.ValueBinding;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletContext;
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServletRequest; 

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.user.UserBean;

public class RightFilter implements Filter { 
	
	private FilterConfig filterConfig = null;

	public void destroy() { 
		filterConfig = null;
	} 

	public void doFilter(ServletRequest sreq, ServletResponse sres, FilterChain arg2) throws IOException, ServletException { 
		// 获取uri地址 
		HttpServletRequest request=(HttpServletRequest)sreq;
		String uri = request.getRequestURI();
		String ctx=request.getContextPath();
		uri = uri.substring(ctx.length());
		//判断admin级别网页的浏览权限 
		FacesContext facesContext = this.getFacesContext(sreq, sres);
		UserBean currentUser=(UserBean)facesContext.getApplication().getVariableResolver().resolveVariable(facesContext,"currentUser");
		/*if (null == currentUser || null == currentUser.getUserInfo()) {
			currentUser.setComeFrom(SpringFacesUtil.getViewIdStr());
			result = "customerLogin";
		}*/
		if (uri.startsWith("/jspLayout/manage")) {
			if(null == currentUser || null == currentUser.getUserInfo() || "M".equalsIgnoreCase(currentUser.getUserInfo().getType())) {
				request.setAttribute("errormessage","您没有这个权限,您可尝试重新登陆!");
				request.getRequestDispatcher("/jspLayout/common/customerLogin.jsf").forward(sreq,sres);
				return;
			} 
		} 
		//判断manage级别网页的浏览权限 
		if (uri.startsWith("/jspLayout/Shopping/generateOrder.jsf")) {
			if (null == currentUser || null == currentUser.getUserInfo()) {
				request.setAttribute("errormessage","您没有这个权限,您可尝试重新登陆!");
				request.getRequestDispatcher("/jspLayout/common/customerLogin.jsf").forward(sreq,sres);
				return;
			}
		}
		if (uri.startsWith("/jspLayout/help/subHelp")) {
			request.getRequestDispatcher("/jspLayout/help/mainHelp.jsf").forward(sreq,sres);
			return;
		}
		request.getRequestDispatcher(uri).forward(sreq,sres);
	}
	//下面还可以添加其他的用户权限，省去。 



	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		ServletContext servletContext = filterConfig.getServletContext();

	}
	// You need an inner class to be able to call FacesContext.setCurrentInstance
	// since it's a protected method
	private abstract static class InnerFacesContext extends FacesContext
	{
	  protected static void setFacesContextAsCurrentInstance(FacesContext facesContext) {
	    FacesContext.setCurrentInstance(facesContext);
	  }
	}

	private FacesContext getFacesContext(ServletRequest request, ServletResponse response) {
	  // Try to get it first
	  FacesContext facesContext = FacesContext.getCurrentInstance();
	  if (null != facesContext) return facesContext;

	  FacesContextFactory contextFactory = (FacesContextFactory)FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
	  LifecycleFactory lifecycleFactory = (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY);
	  Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

	  // Either set a private member servletContext = filterConfig.getServletContext();
	  //HttpServletContext servletContext = filterConfig.getServletContext();
	  // in you filter init() method or set it here like this:
	  // ServletContext servletContext = ((HttpServletRequest)request).getSession().getServletContext();
	  // Note that the above line would fail if you are using any other protocol than http
	  ServletContext servletContext = ((HttpServletRequest) request).getSession().getServletContext();
	  // Doesn't set this instance as the current instance of FacesContext.getCurrentInstance
	  facesContext = contextFactory.getFacesContext(servletContext, request, response, lifecycle);

	  // Set using our inner class
	  InnerFacesContext.setFacesContextAsCurrentInstance(facesContext);

	  // set a new viewRoot, otherwise context.getViewRoot returns null
	  UIViewRoot view = facesContext.getApplication().getViewHandler().createView(facesContext, "yourOwnID");
	  facesContext.setViewRoot(view);

	  return facesContext;
	}
	

}

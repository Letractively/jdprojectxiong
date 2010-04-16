package com.ejd.web.vo.genl;

import java.io.IOException; 
import javax.servlet.Filter; 
import javax.servlet.FilterChain; 
import javax.servlet.FilterConfig; 
import javax.servlet.ServletException; 
import javax.servlet.ServletRequest; 
import javax.servlet.ServletResponse; 
import javax.servlet.http.HttpServletRequest; 

import com.ejd.common.constant.ManageBeanConstants;
import com.ejd.utils.SpringFacesUtil;
import com.ejd.web.vo.user.UserBean;

public class RightFilter implements Filter { 

	public void destroy() { 
	
	} 

	public void doFilter(ServletRequest sreq, ServletResponse sres, FilterChain arg2) throws IOException, ServletException { 
		// 获取uri地址 
		HttpServletRequest request=(HttpServletRequest)sreq;
		String uri = request.getRequestURI();
		String ctx=request.getContextPath();
		uri = uri.substring(ctx.length());
		//判断admin级别网页的浏览权限 
		UserBean currentUser = (UserBean) SpringFacesUtil.getManagedBean(ManageBeanConstants.CURRENT_USER_BEAN_NAME);
		/*if (null == currentUser || null == currentUser.getUserInfo()) {
			currentUser.setComeFrom(SpringFacesUtil.getViewIdStr());
			result = "customerLogin";
		}*/
		if(uri.startsWith("/jspLayout/manage")) {
			if(null == currentUser || null == currentUser.getUserInfo() || "M".equalsIgnoreCase(currentUser.getUserInfo().getType())) {
				request.setAttribute("errormessage","您没有这个权限,您可尝试重新登陆!");
				request.getRequestDispatcher("/jspLayout/common/customerLogin.jsf").forward(sreq,sres);
				return;
			} 
		} 
		//判断manage级别网页的浏览权限 
		if(uri.startsWith("/jspLayout/Shopping/generateOrder.jsf")) {
			if (null == currentUser || null == currentUser.getUserInfo()) {
				request.setAttribute("errormessage","您没有这个权限,您可尝试重新登陆!");
				request.getRequestDispatcher("/jspLayout/common/customerLogin.jsf").forward(sreq,sres);
				return;
			}
		} 
		request.getRequestDispatcher(uri).forward(sreq,sres);
	}
	//下面还可以添加其他的用户权限，省去。 



	public void init(FilterConfig arg0) throws ServletException {

	}

}

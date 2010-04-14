package com.ejd.web.vo.genl;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class JudgeUserLogin implements Filter {

	private FilterConfig filterConfig = null;
	
    public void init(FilterConfig filterConfig) throws ServletException {
       this.filterConfig = filterConfig;
    }

	public void destroy() {
		// TODO Auto-generated method stub
		this.filterConfig = null;
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

	}


}

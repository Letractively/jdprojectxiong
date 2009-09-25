package com.test;

import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.richfaces.renderkit.html.SuggestionBoxRenderer;

import com.ejd.utils.SpringFacesUtil;

public class WebData implements Serializable {
    private String sendUrl;
    private String receivedText;
    private Cookie cookie;
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
	public WebData() {
		
	}
	
	public String getSendUrl() {
		return sendUrl;
	}

	public void setSendUrl(String sendUrl) {
		this.sendUrl = sendUrl;
	}

	public String getReceivedText() {
		return receivedText;
	}

	public void setReceivedText(String receivedText) {
		this.receivedText = receivedText;
	}

	public Cookie getCookie() {
		return cookie;
	}

	public void setCookie(Cookie cookie) {
		this.cookie = cookie;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}

	public String getWebPageText() throws Exception{
		if ("".equals(sendUrl)) {
			return null;
		}
		String param="test";
		receivedText = send_url(this.getSendUrl(),param);
		return null;
     }
	
	public String send_url(String urlStr, String param) throws Exception {
        StringBuilder tempStr;
        HttpURLConnection url_con = null;
        try {
            URL url = new URL(urlStr);
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("POST");
            url_con.setDoOutput(true);
            //url_con.getOutputStream().write(param.getBytes());
            url_con.getOutputStream().flush();
            url_con.getOutputStream().close();
            InputStream in = url_con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(in));
            tempStr = new StringBuilder();
            while (rd.read() != -1) {
                tempStr.append(rd.readLine());
            }

        } finally {
            if (url_con != null)
                url_con.disconnect();
        }
        return new String(tempStr);
    }


    
}
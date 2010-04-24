package com.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.PasswordAuthentication;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebData implements Serializable {
    private String sendUrl;
    private String errorSendUrl;
    private String receivedText;
    private Cookie cookie;
    private HttpServletRequest request = null;
    private HttpServletResponse response = null;
    private boolean useProxy = false;
    private String host ;
    private int port;
    private String username;
    private String password;
    private String province;
    private String cities;
    
	public WebData() {
		
	}
	
	public String getSendUrl() {
		return sendUrl;
	}

	public void setSendUrl(String sendUrl) {
		this.sendUrl = sendUrl;
	}

	public String getErrorSendUrl() {
		return errorSendUrl;
	}

	public void setErrorSendUrl(String errorSendUrl) {
		this.errorSendUrl = errorSendUrl;
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

	public boolean isUseProxy() {
		return useProxy;
	}

	public void setUseProxy(boolean useProxy) {
		this.useProxy = useProxy;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCities() {
		return cities;
	}

	public void setCities(String cities) {
		this.cities = cities;
	}

	public String getWebPageText() throws Exception{
		/*if ("".equals(sendUrl)) {
			return null;
		}*/
		if (null == this.getProvince() || "".equals(this.getProvince())) {
			return null;
		}
		if (null == this.getCities() || "".equals(this.getCities())) {
			return null;
		}
		String mainPage = "http://jdxx.zhs.mofcom.gov.cn/index.do?method=queryCpList";
		String province = "&_province=";
		String city = "&_city=";
		String param="test";
		String result = "";
		String exist = "";
		result = generateProvinceAndCityUrl(mainPage, province, city, this.getProvince(), cities);
		this.setReceivedText(result);
		return null;
     }
	 public static void initProxy(String host, int port, final String username,   
			  
	            final String password) {   
	  
	        Authenticator.setDefault(new Authenticator() {   
	  
	            protected PasswordAuthentication getPasswordAuthentication() {   
	  
	                return new PasswordAuthentication(username,   
	  
	                        new String(password).toCharArray());   
	  
	            }   
	  
	        });   
	  
	        System.setProperty("http.proxyType", "4");   
	  
	        System.setProperty("http.proxyPort", Integer.toString(port));   
	  
	        System.setProperty("http.proxyHost", host);   
	  
	        System.setProperty("http.proxySet", "true");   
	  
	    }
	
	public String send_url(String urlStr, String param) throws Exception {
        StringBuilder tempStr = null;
        HttpURLConnection url_con = null;
        try {
        	String proxy = "yourProxy";
			int port =8080;
			String username ="username";
			String password ="password";
            URL url = new URL(urlStr);
            if (this.isUseProxy()) {
            	initProxy(this.getHost(), this.getPort(), this.getUsername(), this.getPassword());
            } else {
            	initProxy(proxy,port,username,password);
            }
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
        } catch (Exception e) {
        	
        } finally {
            if (url_con != null)
                url_con.disconnect();
        }
        return null == tempStr?"":new String(tempStr);
    }
	public String generateProvinceAndCityUrl(String mainPage, String province, String city,String provinceValue, String cities) throws Exception {
        String tempStr = "";
        HttpURLConnection url_con = null;
        String[] tempinputcity = cities.split("\n");
        List<String> citiesList = new ArrayList<String>();
        for (int i = 0 ; i< tempinputcity.length ;i ++) {
        	citiesList.add(tempinputcity[i].trim());
        }
        try {
        	String newMainPage = "";
        	mainPage = mainPage + province + this.getProvince();
        	pageone:
        	for (String tempCity:citiesList) {
        		newMainPage = mainPage  + city + tempCity ;

	            URL url = new URL(newMainPage);
	            String proxy = "yourProxy";
				int port =8080;
				String username ="username";
				String password ="password";
	            if (this.isUseProxy()) {
	            	initProxy(this.getHost(), this.getPort(), this.getUsername(), this.getPassword());
	            } else {
	            	initProxy(proxy,port,username,password);
	            }
	            url_con = (HttpURLConnection) url.openConnection();
	            url_con.setRequestMethod("POST");
	            url_con.setDoOutput(true);
	            //url_con.getOutputStream().write(param.getBytes());
	            url_con.getOutputStream().flush();
	            url_con.getOutputStream().close();
	            url_con.setReadTimeout(90000);
	            InputStream in ;
	            try {
	            	in= url_con.getInputStream();
	            } catch (IOException e) {
	            	continue pageone;
	            }
	            BufferedReader rd = new BufferedReader(new InputStreamReader(in));
	            inbreak:
	            while (rd.read() != -1) {
	            	String tempsss = rd.readLine();
	                if (tempsss.indexOf("javascript:skip") < 0) {
	                	continue;
	                } else  {
	                	int place = tempsss.lastIndexOf("javascript:skip");
	                	int  lengthall = tempsss.length();
	                	String tempS= tempsss.substring(place,175);
	                	String[] dd = tempS.split("'");
	                	int pageNumber = new Integer(dd[1]).intValue();
	                	for (int j = 1;j <= pageNumber; j++) {
	                	tempStr = tempStr +"\n" + newMainPage+ "&cpf.cpage=" + j ; 
	                	}
	                	break inbreak;
	                }
	            }
        	}
        } catch (Exception e) {
        	
        } finally {
            if (url_con != null)
                url_con.disconnect();
        }
        return null == tempStr?"":tempStr;
    }

	public String getWebDataText() throws Exception{
		/*if ("".equals(sendUrl)) {
			return null;
		}*/
		if (null == this.getSendUrl() || "".equals(this.getSendUrl())) {
			return null;
		}
		StringBuffer lastData = new StringBuffer("");
		StringBuffer errorData = new StringBuffer("");
		HttpURLConnection url_con = null;
		List<String> lastURLList = new ArrayList<String>();
		String sendUrlString = this.getSendUrl();
		String[] allPages = sendUrlString.split("\n");
		pageweb:
		for (int i = 0 ;i < allPages.length ; i++) {
			String tempUrl = allPages[i];
			try {
			URL url = new URL(tempUrl.replace("\n", "").replace("\r", ""));
			String proxy = "yourProxy";
			int port =8080;
			String username ="username";
			String password ="password";
            if (this.isUseProxy()) {
            	initProxy(this.getHost(), this.getPort(), this.getUsername(), this.getPassword());
            } else {
            	initProxy(proxy,port,username,password);
            }
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("POST");
            url_con.setDoOutput(true);
            //url_con.getOutputStream().write(param.getBytes());
            url_con.getOutputStream().flush();
            url_con.getOutputStream().close();
            url_con.setReadTimeout(90000);
            InputStream in ;
            try {
            	in= url_con.getInputStream();
            } catch (IOException e) {
            	continue pageweb;
            }
            BufferedReader rd = new BufferedReader(new InputStreamReader(in));
            inbreak:
            while (rd.read() != -1) {
            	String tempsss = rd.readLine();
                if (tempsss.indexOf("/index.shtml?method=viewCp&id=") < 0) {
                	continue;
                } else  {
                	int place = tempsss.indexOf("/index.shtml?method=viewCp&id=");
                	int placeRight = tempsss.indexOf("target=\"_blank");
                	int  lengthall = tempsss.length();
                	String tempS= tempsss.substring(place+30,placeRight-2);
                	lastURLList.add("http://jdxx.zhs.mofcom.gov.cn/index.shtml?method=viewCp&id="+tempS);
                }
            }
			} finally {
				//do nothing
			}
		}
		//�˴�Ӧ����ҳ�õ���URL ������һ��LIST<STRING> ��
		/*String mainPage = "http://jdxx.zhs.mofcom.gov.cn/index.do?method=queryCpList";
		String province = "&_province=";
		String city = "&_city=";
		String param="test";
		String result = "";
		String exist = "";*/
		/*result = generateProvinceAndCityUrl(mainPage, province, city, this.getProvince(), cities);
		this.setReceivedText(result);*/
		if (null == lastURLList || lastURLList.size() < 0) {
			return null;
		}
		success:
		for (int j = 0; j < lastURLList.size() ; j++) {
			String currentPageData = "";
			String lastStr = lastURLList.get(j);
			try {
			URL url = new URL(lastStr.replace("\n", "").replace("\r", ""));
			String proxy = "yourProxy";
			int port =8080;
			String username ="username";
			String password ="password";
            if (this.isUseProxy()) {
            	initProxy(this.getHost(), this.getPort(), this.getUsername(), this.getPassword());
            } else {
            	initProxy(proxy,port,username,password);
            }
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("POST");
            url_con.setDoOutput(true);
            //url_con.getOutputStream().write(param.getBytes());
            url_con.getOutputStream().flush();
            url_con.getOutputStream().close();
            if (null == url) {
            	continue success;
            }
            url_con.setReadTimeout(90000);
            InputStream in;
            try {
            	in = url_con.getInputStream();
            	
            } catch (IOException e) {
            	errorData.append("\n"+lastStr.replace("\n", "").replace("\r", ""));
            	continue success;
            }
            BufferedReader rd = new BufferedReader(new InputStreamReader(in));
            inbreak:
            while (rd.read() != -1) {
            	
            	String tempsss = rd.readLine();
            	String tempS = "";
            	
            	 if (tempsss.indexOf("<td>") < 0 ) {
            		 if (tempsss.indexOf("title>") >=0) {
            			int place = tempsss.indexOf("title>");
                 		int placeRight = tempsss.indexOf("</title>");
                 		tempS = tempsss.substring(place+6,placeRight).replaceAll("&nbsp;", "");
            		 } else {
            			 continue;
            		 }
                } else  {
                	if (tempsss.indexOf("<td>") > 0) {
	                	int place = tempsss.indexOf("<td>");
	                	int placeRight = tempsss.indexOf("</td>");
	                	int  lengthall = tempsss.length();
	                	tempS= tempsss.substring(place+4,placeRight).replaceAll("&nbsp;", "");
                	}
                	
                }
            	 if (!("".equals(tempS))) {
            		 currentPageData = currentPageData + "|" + tempS;
            	 }
            }
            if (!("".equals(currentPageData))) {
            	lastData.append("\n" + currentPageData);
            }
		} finally {
			// do thing
		}
		}
		this.wirteStringTofile(lastData.toString()+"\n"+lastURLList.size()+errorData.toString());
		this.setReceivedText("");
		return null;
     }
	public void wirteStringTofile(String str){   
		  BufferedWriter   bw;   
		  File   filePath   =   new   File("d:\\hello.txt");   
		  try{   
		  bw   =   new   BufferedWriter(new   FileWriter(filePath));   
		  bw.write(str);   
		  bw.flush();   
		  bw.close();   
		  }   
		  catch(IOException   e){   
		  e.printStackTrace();   
		  }   
		  }   
	
	public void wirteErrorStringTofile(String str){   
		  BufferedWriter   bw;   
		  File   filePath   =   new   File("d:\\errorhello.txt");   
		  try{   
		  bw   =   new   BufferedWriter(new   FileWriter(filePath));   
		  bw.write(str);   
		  bw.flush();   
		  bw.close();   
		  }   
		  catch(IOException   e){   
		  e.printStackTrace();   
		  }   
		  } 
	public String getErrorWebDataText() throws Exception{
		/*if ("".equals(sendUrl)) {
			return null;
		}*/
		if (null == this.getErrorSendUrl() || "".equals(this.getErrorSendUrl())) {
			return null;
		}
		StringBuffer lastData = new StringBuffer("");
		StringBuffer errorData = new StringBuffer("");
		HttpURLConnection url_con = null;
		List<String> lastURLList = new ArrayList<String>();
		String sendUrlString = this.getErrorSendUrl();
		String[] allPages = sendUrlString.split("\n");
		for (int k = 0 ;k < allPages.length; k ++) {
			lastURLList.add(allPages[k].replace("\n", "").replace("\r", ""));
		}
		successa:
		for (int j = 0; j < lastURLList.size() ; j++) {
			String currentPageData = "";
			String lastStr = lastURLList.get(j);
			try {
			URL url = new URL(lastStr.replace("\n", "").replace("\r", ""));
			String proxy = "yourProxy";
			int port =8080;
			String username ="username";
			String password ="password";
            if (this.isUseProxy()) {
            	initProxy(this.getHost(), this.getPort(), this.getUsername(), this.getPassword());
            } else {
            	initProxy(proxy,port,username,password);
            }
            url_con = (HttpURLConnection) url.openConnection();
            url_con.setRequestMethod("POST");
            url_con.setDoOutput(true);
            //url_con.getOutputStream().write(param.getBytes());
            url_con.getOutputStream().flush();
            url_con.getOutputStream().close();
            if (null == url) {
            	continue successa;
            }
            url_con.setReadTimeout(90000);
            InputStream in;
            try {
            	in = url_con.getInputStream();
            	
            } catch (IOException e) {
            	errorData.append("\n"+lastStr.replace("\n", "").replace("\r", ""));
            	continue successa;
            }
            BufferedReader rd = new BufferedReader(new InputStreamReader(in));
            inbreak:
            while (rd.read() != -1) {
            	
            	String tempsss = rd.readLine();
            	String tempS = "";
            	
            	 if (tempsss.indexOf("<td>") < 0 ) {
            		 if (tempsss.indexOf("title>") >=0) {
            			int place = tempsss.indexOf("title>");
                 		int placeRight = tempsss.indexOf("</title>");
                 		tempS = tempsss.substring(place+6,placeRight).replaceAll("&nbsp;", "");
            		 } else {
            			 continue;
            		 }
                } else  {
                	if (tempsss.indexOf("<td>") > 0) {
	                	int place = tempsss.indexOf("<td>");
	                	int placeRight = tempsss.indexOf("</td>");
	                	int  lengthall = tempsss.length();
	                	tempS= tempsss.substring(place+4,placeRight).replaceAll("&nbsp;", "");
                	}
                	
                }
            	 if (!("".equals(tempS))) {
            		 currentPageData = currentPageData + "|" + tempS;
            	 }
            }
            if (!("".equals(currentPageData))) {
            	lastData.append("\n" + currentPageData);
            }
		} finally {
			// do thing
		}
		}
		this.wirteErrorStringTofile(lastData.toString()+"\n"+lastURLList.size()+errorData.toString());
		this.setReceivedText("");
		return null;
     }
    
}
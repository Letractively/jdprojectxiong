package com.test;

import java.io.BufferedReader;   

import java.io.IOException;   
  
import java.io.InputStream;   
  
import java.io.InputStreamReader;   
  
import java.net.Authenticator;   
  
import java.net.HttpURLConnection;   
  
import java.net.PasswordAuthentication;   
  
import java.net.URL;   
  
import java.net.URLConnection;   
  
import java.util.Properties;   
  
  
  
public class URLtest {   
  
    // 一个public方法，返回字符串，错误则返回"error open url"   
  
    public static String getContent(String strUrl) {   
  
        try {   
  
            URL url = new URL(strUrl);   
  
            BufferedReader br = new BufferedReader(new InputStreamReader(url   
  
                    .openStream()));   
  
            String s = "";   
  
            StringBuffer sb = new StringBuffer("");   
  
            while ((s = br.readLine()) != null) {   
  
                sb.append(s + "\r\n");   
  
            }   
  
            br.close();   
  
            return sb.toString();   
  
        } catch (Exception e) {   
  
            return "error open url:" + strUrl;   
  
        }   
  
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
  
  
  
    public static void main(String[] args) throws IOException {   
  
         String url = "http://jdxx.zhs.mofcom.gov.cn/index.do?method=queryRegCpList&type=1";   
  
         String proxy = "192.168.70.73";   
  
         int port = 8080;   
  
         String username = "KGHGROUP\txiong";   
  
         String password = "yes8abcd";   
  
         String curLine = "";   
  
         String content = "";   
  
         URL server = new URL(url);   
  
         initProxy(proxy, port, username, password);   
  
         HttpURLConnection connection = (HttpURLConnection) server   
  
         .openConnection();   
  
         connection.connect();   
  
         InputStream is = connection.getInputStream();   
  
         BufferedReader reader = new BufferedReader(new  
  
         InputStreamReader(is));   
  
         while ((curLine = reader.readLine()) != null) {   
  
         content = content + curLine+ "\r\n";   
  
         }   
  
         System.out.println("content= " + content);   
  
         is.close();   
  
         System.out.println(getContent(url));   
  
    }   
  
}


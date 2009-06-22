package com.ejd.web.vo.image;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.richfaces.renderkit.html.SuggestionBoxRenderer;

import com.ejd.utils.SpringFacesUtil;

public class ImageSuggestionBox implements Serializable {

	private boolean usingSuggestObjects;
    
    private String property;

    private ArrayList data;
    private ArrayList tokens;

    private String rows;
    private String first;
    private String cellspacing;
    private String cellpadding;
    private String minchars;
    private String frequency;
    private String rules;
    private boolean check;
    private String shadowDepth = Integer.toString(SuggestionBoxRenderer.SHADOW_DEPTH);
    private String border = "1";
    private String width = "200";
    private String height = "150";
    private String shadowOpacity = "4";
    private String onsubmit = "true";

    public ImageSuggestionBox() {
        this.rows = "0";
        this.first = "0";
        this.cellspacing = "2";
        this.cellpadding = "2";
        this.minchars = "1";
        this.frequency = "0";
        this.rules = "none";
    }

    public List autocomplete(Object suggest) {
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage("SuggestionBox.autocomplete(" + suggest + ")");
        context.addMessage(null, message);
        
        String pref = (String)suggest;
        if (pref.length() < 2) {
	    	return null;
	    }
        ArrayList result = new ArrayList();

        Iterator iterator = getAllData().iterator();
        while (iterator.hasNext()) {
            ImageData elem = (ImageData) iterator.next();
            if ((elem != null && elem.getName().toLowerCase().indexOf(pref.toLowerCase()) >= 0) || "".equals(pref))
            {
                result.add(elem);
            }
        }
        return result;
    }

    public ArrayList getAllData() {
        ArrayList<ImageData> result = new ArrayList<ImageData>();
        /*for (int i = 0; i < cit.length; i++) {
            Data data = new Data(cit[i], String.valueOf(i + 1), prices[i]);
            result.add(data);
        }*/
        String path = SpringFacesUtil.getServletContext().getRealPath("/");
        path=path+"productimage";
        String filePath = "F:\\job\\Test_081028\\bin\\com\\txt";
        LinkedHashMap map = this.ReadAllFilesName(path);
        String out = "";
        for(Iterator keyItr = map.keySet().iterator();keyItr.hasNext();){
             Object i  =  keyItr.next();
                out = (String)map.get(i);
                result.add(new ImageData(out));
                System.out.println(out);
        }

        return result;
    }

    public ArrayList getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getCellpadding() {
        return cellpadding;
    }

    public void setCellpadding(String cellpadding) {
        this.cellpadding = cellpadding;
    }

    public String getCellspacing() {
        return cellspacing;
    }

    public void setCellspacing(String cellspacing) {
        this.cellspacing = cellspacing;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public String getFirst() {
        return first;
    }

    public int getIntFirst() {
        return Integer.parseInt(getFirst());
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getFrequency() {
        return frequency;
    }

    public double getDoubleFrequency() {
        return Double.parseDouble(getFrequency());
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getMinchars() {
        return minchars;
    }

    public void setMinchars(String minchars) {
        this.minchars = minchars;
    }

    public String getRows() {
        return rows;
    }

    public void setRows(String rows) {
        this.rows = rows;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public ArrayList getTokens() {
        return tokens;
    }

    public void setTokens(ArrayList tokens) {
        this.tokens = tokens;
    }

    public void OnSelect() {
        System.out.print("Onselect works!!!");

    }

    public String getShadowDepth() {
        return shadowDepth;
    }

    public void setShadowDepth(String shadowDepth) {
        this.shadowDepth = shadowDepth;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getShadowOpacity() {
        return shadowOpacity;
    }

    public void setShadowOpacity(String shadowOpacity) {
        this.shadowOpacity = shadowOpacity;
    }

    public String getOnsubmit() {
        return onsubmit;
    }

    public void setOnsubmit(String onsubmit) {
        this.onsubmit = onsubmit;
    }

    public String getOnsubmitFunction() {
        if ("false".equalsIgnoreCase(onsubmit)) return null;
        return "alert(this.value); return " + onsubmit + ";";
    }

    public void setOnsubmitFunction(String onsubmit) {
    }

    public boolean isUsingSuggestObjects() {
        return usingSuggestObjects;
    }

    public void setUsingSuggestObjects(boolean usingSuggestObjects) {
        this.usingSuggestObjects = usingSuggestObjects;
    }
    public static LinkedHashMap ReadAllFilesName(String filePath){
    	LinkedList list=new LinkedList();
    	LinkedHashMap map = new LinkedHashMap();
    	String fileName = "";
    	File tmp;
    	File dir=new File(filePath);
    	File file[]=dir.listFiles();
    	//遍历文件夹下的所有文件
    	for(int i=0;i<file.length;i++){
    		if(file[i].isDirectory()){//如果是文件夹，暂放集合中去
    			list.add(file[i]);
    			}else{
    	          // System.out.println(file[i].getAbsolutePath());
    	         fileName = file[i].getName();
    	         map.put(fileName+i,fileName);
    	        }//end if
    	}//end for
    	//开始循环遍历，次级文件夹下的所有文件
    	while(!list.isEmpty()){
    		tmp=(File)list.removeFirst();
    	    if(tmp.isDirectory()){
    	    	file=tmp.listFiles();
    	        if(file==null) continue;
    	        for(int i=0;i<file.length;i++){
    	        	if(file[i].isDirectory()){
    	        		list.add(file[i]);
    	                }else{
    	                   // System.out.println(file[i].getAbsolutePath());
    	                   fileName = file[i].getName();
    	                      map.put(fileName+i,fileName);
    	            }//end if
    	        }//end for
    	     }else{
    	    	 fileName = tmp.getName();
    	         map.put(fileName,fileName);
    	         } 
    	}//end while
    	return map;
    }

}

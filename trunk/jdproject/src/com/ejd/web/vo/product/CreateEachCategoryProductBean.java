package com.ejd.web.vo.product;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import com.ejd.utils.SpringFacesUtil;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class CreateEachCategoryProductBean {
	
	private String templateName;
	
	private String  foldName;
	
	private String fileName;

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getFoldName() {
		return foldName;
	}

	public void setFoldName(String foldName) {
		this.foldName = foldName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public CreateEachCategoryProductBean() {
	}
	public String createJsp() {
		ServletContext context = SpringFacesUtil.getServletContext();
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("fileName", this.getFileName());
		data.put("upFileName", (this.getFileName().substring(0,1).toUpperCase() + this.getFileName().substring(1)));
		String templatePath = this.getTemplateName();
		String targetJspPath = this.getFoldName();
		Configuration freemarkerCfg = new Configuration();
		//load template
		freemarkerCfg.setServletContextForTemplateLoading(context, "/ftl");
		freemarkerCfg.setEncoding(Locale.getDefault(), "UTF-8");
		try {
			//指定模版路径
			Template template = freemarkerCfg.getTemplate(templatePath,"UTF-8");
			template.setEncoding("UTF-8");
			//静态页面路径
			String htmlPath = context.getRealPath("/jspLayout/product") + "/" +targetJspPath + "/" + this.getFileName() +".jsp";
			File htmlFile = new File(htmlPath);
			Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream
			(htmlFile), "UTF-8"));
			//处理模版 
			template.process(data, out);
			out.flush();
			out.close();
			} catch (Exception e) {
			e.printStackTrace();
			}

		return null;
	}
}

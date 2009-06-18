<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view id="manageMainView">
<html>
	<head>
    <title>上传产品图片</title>
    </head>
    <body>
    	<ui:composition template="../manageTemplate.jsp">
    		<ui:define name="content">
    			<h:form id="addproductimageform">
    			<fieldset class="demo_fieldset">
				<legend class="demo_legend"><h:outputText value="#{manageHeaderMenu.menuTitle}"/></legend>
    			
    				<h:panelGrid id="addproductimagepg" style="width:100%" columns="2" columnClasses="top,top">
            <rich:fileUpload fileUploadListener="#{fileUploadBean.listener}"
                maxFilesQuantity="#{fileUploadBean.uploadsAvailable}"
                id="upload"
                addControlLabel="添加图片" 
                uploadControlLabel="上传" 
                clearAllControlLabel="清除所有" 
                clearControlLabel="清除" 
                cancelEntryControlLabel="取消" 
                stopControlLabel="停止" 
                stopEntryControlLabel="停止"
                doneLabel="成功"
                transferErrorLabel="失败"
                immediateUpload="#{fileUploadBean.autoUpload}"
                acceptedTypes="jpg, gif, png, bmp" allowFlash="#{fileUploadBean.useFlash}">
                <a4j:support event="onuploadcomplete" reRender="info" />
            </rich:fileUpload>
            <h:panelGroup id="info">
                <rich:panel bodyClass="info">
                    <f:facet name="header">
                        <h:outputText value="已缓存文件信息" />
                    </f:facet>
                    <h:outputText value="当前无文件上传" rendered="#{fileUploadBean.size==0}" style="width:100%"/>
                    <rich:dataGrid columns="1" value="#{fileUploadBean.files}"
                        var="file" rowKeyVar="row">
                        <rich:panel bodyClass="rich-laguna-panel-no-header">
                            <h:panelGrid columns="2">
                                <a4j:mediaOutput element="img" mimeType="#{file.mime}"
                                    createContent="#{fileUploadBean.paint}" value="#{row}"
                                    style="width:100px; height:100px;" cacheable="false">
                                    <f:param value="#{fileUploadBean.timeStamp}" name="time"/>  
                                </a4j:mediaOutput>
                                <h:panelGrid columns="2">
                                    <h:outputText value="名称:" />
                                    <h:outputText value="#{file.name}" />
                                    <h:outputText value="大小:" />
                                    <h:outputText value="#{file.length}" />
                                </h:panelGrid>
                            </h:panelGrid>
                        </rich:panel>
                    </rich:dataGrid>
                </rich:panel>
                <rich:spacer height="3"/>
                <br />
                <h:panelGroup>
                	<a4j:commandButton action="#{fileUploadBean.clearUploadData}" reRender="info, upload" value="清除缓存" rendered="#{fileUploadBean.size>0}" />
                	<a4j:commandButton action="#{fileUploadBean.sendUploadData}" reRender="info, upload" value="发送" rendered="#{fileUploadBean.size>0}" ></a4j:commandButton>
                </h:panelGroup>
            </h:panelGroup>
        </h:panelGrid>

					</fieldset>
    			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>	
</jsp:root>	
<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="theproductDetailsubview">
	<rich:tabPanel switchType="ajax" headerSpacing="0px" headerClass="rich-tabpanel-header" contentClass="rich-tabpanel-content">
				        <rich:tab>
				        	<f:facet name="label"><h:panelGroup><h:outputLabel value="&#160;"></h:outputLabel><h:outputText value="产品描述" styleClass="rich-tab-header-text"></h:outputText></h:panelGroup></f:facet>
				           		<h:panelGrid columns="1" style="width:100%" headerClass="panel-header-none-border" styleClass="panel-none-border" columnClasses="product-detail-common-font">
									<h:panelGroup><H5>商品介绍</H5></h:panelGroup>
									<h:panelGroup><h:outputText value="实用便捷，简约明快的设计" styleClass="product-detail-gray-font"/></h:panelGroup>
									<h:panelGroup>远红外波纹黑锅 <br/>双层操作面板 <br/></h:panelGroup>
								</h:panelGrid>
				        </rich:tab>
				        <rich:tab>
				        	<f:facet name="label"><h:panelGroup><h:outputLabel value="&#160;"></h:outputLabel><h:outputText value="规格参数" styleClass="rich-tab-header-text"></h:outputText></h:panelGroup></f:facet>
				            Here is tab #2
				            <h:inputText value="dfdfdf"></h:inputText>
				            <a4j:commandButton id="btn1" value="click me" reRender="l1,l2"></a4j:commandButton>
				            <h:outputText id="l1" value="cvccvcv"></h:outputText>
				        </rich:tab>
				        <rich:tab>
				        <f:facet name="label"><h:panelGroup><h:outputLabel value="&#160;"></h:outputLabel><h:outputText value="包装信息" styleClass="rich-tab-header-text"></h:outputText></h:panelGroup></f:facet>
				            Here is tab #3
				            <h:outputText id="l2" value="fdfdfdf"></h:outputText>
				        </rich:tab>
				        <rich:tab>
				        	<f:facet name="label"><h:panelGroup><h:outputLabel value="&#160;"></h:outputLabel><h:outputText value="保修条款" styleClass="rich-tab-header-text"></h:outputText></h:panelGroup></f:facet>
				            Here is tab #3
				            <h:outputText id="l3" value="fdfdfdf"></h:outputText>
				        </rich:tab>
				    </rich:tabPanel>
</f:subview>		
</jsp:root>	
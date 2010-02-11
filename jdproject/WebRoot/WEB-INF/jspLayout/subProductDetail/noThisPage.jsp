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
	<rich:panel style="width:100%" styleClass="panel-none-border" headerClass="panel-header-gray-border" bodyClass="panel-documents-gray-border">
		<f:facet name="header">
			<h:panelGrid columns="3"  cellspacing="0" cellpadding="0" columnClasses="common-panel-grid-header-left,common-panel-grid-header-center,common-panel-grid-header-right">
					<h:outputText value="" style="width:4px"></h:outputText>
					<h:panelGroup>
						 <h:outputText value="暂无详细信息"></h:outputText>
					</h:panelGroup>
					<h:outputText value="" style="width:4px"></h:outputText>
			</h:panelGrid>	
		</f:facet>
		<h:panelGrid columns="1" style="width:100%" headerClass="panel-header-none-border" styleClass="panel-documents-gray-border">
			<h:outputText value="改商品暂无详细信息,正在准备中......"></h:outputText>
			<h:panelGroup><h:outputLabel value="如果需要即可了解详细信息,请联系"/></h:panelGroup>
		</h:panelGrid>
	</rich:panel>
</f:subview>		
</jsp:root>	
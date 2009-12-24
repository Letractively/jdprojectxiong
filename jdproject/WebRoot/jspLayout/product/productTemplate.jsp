<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="manageTemplateView">
<script src="${facesContext.externalContext.requestContextPath}/css/common.js" type="text/javascript"></script>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/common.css"/>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/top.css"/>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/style.css"/>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/index.css"/>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/css.css"/>
<h:panelGrid columns="1" style="width:998px;min-width:880px;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle;ALIGN:CENTER;BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px">
	<ui:insert name="manageHeaderMainMiddle">
		<f:subview id="manageHeaderMainView2">
			<ui:include src="./productHeader1.jsp" />
		</f:subview>
	</ui:insert>
	
</h:panelGrid>
<h:panelGrid columns="1" style="width:998px;min-width:880px;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle;ALIGN:CENTER; BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px">
	<ui:insert name="productStepDisplay">
		<f:subview id="productStepDisplayView">
			<h:outputText value="productStepDisplayView"></h:outputText>
		</f:subview>
	</ui:insert>
</h:panelGrid>

<h:panelGrid columns="3" style="width:998px;min-width:880px;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle;ALIGN:CENTER; BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px" columnClasses="template-left,template-content,template-right">
	<h:panelGroup id="template-left">
		<ui:insert name="left">
			<f:subview id="leftview">
				<h:outputText value="lefttext"></h:outputText>
			</f:subview>
		</ui:insert>
	</h:panelGroup>
	<h:panelGroup id="template-content">
		<ui:insert name="productSearchNavigation">
			<f:subview id="productSearchNavigationView">
				<h:outputText value="productSearchNavigation"></h:outputText>
			</f:subview>
		</ui:insert>
		<ui:insert name="content">
			<f:subview id="contentview">
				<h:panelGrid columns="2">
					
					<h:outputText value="ddd"></h:outputText>
					<h:outputText value="cccc"></h:outputText>

				</h:panelGrid>
			</f:subview>
		</ui:insert>
	</h:panelGroup>
	<h:panelGroup id="template-right">
		<ui:insert name="right">
			<f:subview id="rightview">
				<h:outputText value="righttext"></h:outputText>
			</f:subview>
		</ui:insert>
	</h:panelGroup>

</h:panelGrid>

<h:panelGrid columns="1" style="width:998px;min-width:880px;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle;ALIGN:CENTER; BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px">
	<h:outputText value="dddd"></h:outputText>
</h:panelGrid>

<h:panelGrid width="100%" style="width:998px;min-width:880px;height:39;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle;ALIGN:CENTER; BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px">
	<ui:insert name="footer">
		<ui:include src="./productFooter.jsp" />
	</ui:insert>
</h:panelGrid>

</f:subview>		
</jsp:root>	
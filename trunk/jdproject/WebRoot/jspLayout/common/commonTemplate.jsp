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
<script src="/css/jquery131.js" type="text/javascript"></script>

<f:loadBundle basename="com.ejd.resources.messages" var="msgs"/>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/common.css"/>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/style.css"/>
<link rel="STYLESHEET" type="text/css" href="${facesContext.externalContext.requestContextPath}/css/css.css"/>

<table class="skr" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody>
<tr>
<td align="center" width="100%">
<h:panelGrid columns="1" style="width:970;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: top;ALIGN:CENTER; BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px;">
	<ui:insert name="manageHeaderMainMiddle">
		<f:subview id="manageHeaderMainView2">
			<ui:include src="../mainHeader.jsp" />
		</f:subview>
	</ui:insert>
</h:panelGrid>
</td>
</tr>
</tbody>
</table>
<table class="skr" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody>
<tr>
<td align="center" width="100%">
<h:panelGrid columns="1" style="WIDTH:970;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle; ALIGN:CENTER;BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px">
	<ui:insert name="commonStepDisplay">
		<f:subview id="commonStepDisplayView">
			<h:outputText value="commonStepDisplayView"></h:outputText>
		</f:subview>
	</ui:insert>
</h:panelGrid>
</td>
</tr>
</tbody>
</table>
<table class="skr" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody>
<tr>
<td align="center" width="100%">
<h:panelGrid columns="1" width="970"  styleClass="contentStyle">
	<h:panelGroup id="template-content">
		<ui:insert name="contentHeader">
			<f:subview id="contentHeaderView">
				
			</f:subview>
		</ui:insert>
		<ui:insert name="content">
			<f:subview id="contentview">
			</f:subview>
		</ui:insert>
	</h:panelGroup>
</h:panelGrid>
</td>
</tr>
</tbody>
</table>
<table class="skr" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody>
<tr>
<td align="center" width="100%">
<h:panelGrid columns="1" style="WIDTH:970;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle; ALIGN:CENTER;BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px">
	<ui:insert name="footerone">
		<f:subview id="footerOneView">
			<h:outputText value="footerone"></h:outputText>
		</f:subview>
	</ui:insert>
</h:panelGrid>
</td>
</tr>
</tbody>
</table>

<table class="skr" border="0" cellpadding="0" cellspacing="0" width="100%">
<tbody><tr>
<td align="center" width="100%">
	<h:panelGrid width="970" style=" height:39;border:0 ;BORDER-RIGHT: 0px; PADDING-RIGHT: 0px; BORDER-TOP: 0px; PADDING-LEFT: 0px; PADDING-BOTTOM: 0px; VERTICAL-ALIGN: middle; BORDER-LEFT: 0px ; PADDING-TOP: 0px; BORDER-BOTTOM: 0px">
		<ui:insert name="footer">
			<ui:include src="../mainFooter.jsp" />
		</ui:insert>
	</h:panelGrid>
</td>
</tr>
</tbody>
</table>
</f:subview>		
</jsp:root>	
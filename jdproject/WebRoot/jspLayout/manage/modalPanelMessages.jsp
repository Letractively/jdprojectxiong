<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<rich:modalPanel id="addstakeholderresultmp">
	<f:facet name="header">
		<h:outputText id="optheader" value="反馈信息"/>
	</f:facet>
	<f:facet name="controls">
		<h:graphicImage value="/css/images/icons/ico_close.gif" style="cursor:pointer" onclick="Richfaces.hideModalPanel('manageTemplateView:modalPanelMessagesinclude:addstakeholderresultmp')" />
	</f:facet>
	<a4j:outputPanel id="oppdetailmessages">
		<a4j:repeat id="detailmessages" value="#{modalPanelMessages.messages}" var="message">
			<h:outputText value="#{message}"/>
		</a4j:repeat>
	</a4j:outputPanel>
</rich:modalPanel>	
</jsp:root>	
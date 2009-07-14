<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:subview id="phoneMainView">
<html>
	<head>
    <title>电视</title>
    </head>
    <body>
    	<ui:composition template="../productTemplate.jsp">
    	<ui:define name="content">
    			<h:outputText value="#{existProductGroup.televisionProductGroup.primaryCategory.categoryName}"></h:outputText>
    			<rich:orderingList id="televisionlist" value="#{existProductGroup.televisionProductGroup.brands}" var="list">
    				<h:column><h:outputText value="#{list.brandName}"/></h:column>
    			</rich:orderingList>
    		</ui:define>
    	</ui:composition>
    	<h:outputText value="电视"></h:outputText>
    </body>
</html>	
</f:subview>		
</jsp:root>	
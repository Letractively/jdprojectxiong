<?xml version="1.0" encoding="UTF-8" ?>
<jsp:root version="1.2"
xmlns:jsp="http://java.sun.com/JSP/Page"
xmlns="http://www.w3.org/1999/xhtml"
xmlns:ui="http://java.sun.com/jsf/facelets"
xmlns:f="http://java.sun.com/jsf/core"
xmlns:h="http://java.sun.com/jsf/html"
xmlns:a4j="http://richfaces.org/a4j"
xmlns:rich="http://richfaces.org/rich">
<f:view>
<html>
	<head>
    <title>产品浏览</title>
    </head>
    <body>
    	<ui:composition template="./helpTemplate.jsp">
    		<ui:define id="kitchenApplianceLeft" name="left">
    			<ui:include id="kitchenApplianceLeftInclude" src="./navigationHelpLeft.jsp">
    			</ui:include>
    		</ui:define>
    		<ui:define id="contentHeader" name="contentHeader">
    			<h:outputText value=""></h:outputText>
			</ui:define>
			<ui:define id="kitchenApplianceContent" name="content">
				<h:outputText value="helpcontent"></h:outputText>
    		</ui:define>
    		<ui:define id="kitchenApplianceRight" name="right">
    			<h:outputText value=""></h:outputText>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	
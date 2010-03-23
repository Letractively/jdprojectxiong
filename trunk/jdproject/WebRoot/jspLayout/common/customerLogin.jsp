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
    <title>新用户注册</title>
    </head>
    <body>
    	<ui:composition template="./commonTemplate.jsp">
    		
    		<ui:define id="commonStepDisplayOfShoppingCart" name="commonStepDisplay">
    			
			</ui:define>
    		<ui:define id="contentHeader" name="contentHeader">
    				<h:outputText value="欢迎您登录! "></h:outputText>
			</ui:define>
			<ui:define id="customerLoginContent" name="content">
			<h:form>
				<a4j:region id="customerLoginRegion" renderRegionOnly="false" selfRendered="true">
				
				
			</a4j:region>	
			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	
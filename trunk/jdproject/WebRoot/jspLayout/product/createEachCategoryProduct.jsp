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
    <title>创建产品产品浏览</title>
    </head>
    <body>
    	<ui:composition template="./productTemplate.jsp">
    		<ui:define id="createKitchenApplianceLeft" name="left">
    			
    		</ui:define>
    		
			<ui:define id="createKitchenApplianceContent" name="content">
				<a4j:region id="createKitchenApplianceRegion" renderRegionOnly="false" selfRendered="true">
    			<h:form id="createKitchenApplianceRegionForm">
    				<h:panelGrid columns="2">
    					<h:outputText value="模板名称"></h:outputText>
    					<h:selectOneMenu value="#{createEachCategoryProduct.templateName}">
    						<f:selectItem itemValue="eachCategoryProduct.ftl" itemLabel="eachCategoryProduct.ftl"/>
    					</h:selectOneMenu>
    					<h:outputText value="文件名称"></h:outputText>
    					<h:inputText value="#{createEachCategoryProduct.fileName}"></h:inputText>
    					<h:outputText value="存放上级文件夹名称"></h:outputText>
    					<h:inputText value="#{createEachCategoryProduct.foldName}"></h:inputText>
    					<h:outputText value=""></h:outputText>
    					<a4j:commandButton action="#{createEachCategoryProduct.createJsp}"></a4j:commandButton>
    				</h:panelGrid>
    				
    			</h:form>
    			</a4j:region>
    		</ui:define>
    		<ui:define id="createKitchenApplianceRight" name="right">
    			<h:outputText value=""></h:outputText>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>		
</jsp:root>	
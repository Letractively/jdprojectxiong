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
    <title>sdsdsdsdsd</title>
    </head>
    <body>
    	<ui:composition template="../manageTemplate.jsp">
    		<ui:define name="content">
    			<h:form id="productunitform">
    			<fieldset class="demo_fieldset">
				<legend class="demo_legend"><h:outputText value="#{manageHeaderMenu.menuTitle}"/></legend>
    			
    				<h:panelGrid id="newpanel" columns="3" rowClasses="table-row" columnClasses="table-one-column,table-two-column,table-three-column" headerClass="page-header" footerClass="table-footer" styleClass="table-background" width="96%">
						<f:facet name="header">
                			<h:outputText value="#{productUnitCreate.newProgressString}" id="newProgress"/>
            			</f:facet>
						<h:outputLabel value="单位名称：" for="unitName"></h:outputLabel>
						<h:inputText value="#{productUnitCreate.newProductUnit.unitName}" id="unitName">
							<rich:beanValidator summary="类型有误"/>
                		</h:inputText>
                		<rich:message for="unitName" />
                		<h:outputLabel value="单位序号：" for="serialNumber"></h:outputLabel>
						<h:inputText value="#{productUnitCreate.newProductUnit.serialNumber}" id="serialNumber" onblur="if(/\D/.test(this.value)){alert('只能输入数字');this.select();}">
                    		<rich:beanValidator summary="序号有误"/>
                    	</h:inputText>
                		<rich:message for="serialNumber" />
                		<h:outputText value=" "></h:outputText>
                			<a4j:commandButton action="#{productUnitCreate.createProductUnit}" reRender="newpanel" value="保存"/>
                		<h:outputText value=" "></h:outputText>
					</h:panelGrid>
					</fieldset>
    			</h:form>
    		</ui:define>
    	</ui:composition>
    </body>
</html>	
</f:view>	
</jsp:root>	
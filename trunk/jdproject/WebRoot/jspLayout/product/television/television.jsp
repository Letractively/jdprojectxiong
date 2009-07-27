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
    <title>sdsdsdsdsd</title>
    </head>
    <body>
		<ui:composition template="../productTemplate.jsp">
    		<ui:define name="left">
    			<a4j:region id="televisionregionleft" renderRegionOnly="true">
    			<h:form id="televisionleftform">
    			<rich:panelBar id="televisionpb" style="width: auto;" height="300px" contentStyle="background:none;">
					<rich:panelBarItem id="television">
						<f:facet name="label">
							<h:panelGroup layout="block">
							<ui:include id="phoneinp35" src="../productNavigationPanelHeader.jsp" >
								<ui:param name="label" value="#{navigationLeft.televisionPrimaryCategoryName}"/>
								
							</ui:include>
							
							</h:panelGroup>
						</f:facet>
						<ui:include id="phoneinp36" src="../productNavigationGroup.jsp" >
 							<ui:param name="brands" value="#{navigationLeft.televisionBrands}" />
							<ui:param name="secondCategorys" value="#{navigationLeft.televisionSecondCategorys}" />
							<ui:param name="primaryCategoryId" value="#{navigationLeft.televisionPrimaryCategory.id}"/>
							<ui:param name="model" value="television"/>
 						</ui:include>
					</rich:panelBarItem>
				</rich:panelBar>
				</h:form>
				</a4j:region>
    		</ui:define>
		</ui:composition>
	</body>
</html>	
</f:view>		
</jsp:root>	